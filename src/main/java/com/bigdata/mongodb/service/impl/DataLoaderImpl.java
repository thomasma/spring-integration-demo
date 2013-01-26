package com.bigdata.mongodb.service.impl;

import java.io.File;

import org.aver.fft.RecordListener;
import org.aver.fft.Transformer;
import org.aver.fft.TransformerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Component;

import com.bigdata.mongodb.domain.Contribution;
import com.bigdata.mongodb.service.DataLoader;

@Component
public class DataLoaderImpl implements DataLoader {
    @Autowired
    @Qualifier("saveToDBChannel")
    private MessageChannel channel;

    @Autowired
    private MongoTemplate mongoTemplate;

    public void loadData(File dataFile) {
        Transformer spec = TransformerFactory.getTransformer(Contribution.class);
        spec.parseFlatFile(dataFile, new RecordListener() {
            public boolean foundRecord(Object o) {
                final Contribution contrib = (Contribution) o;
                channel.send(new GenericMessage<Contribution>(contrib));
                return true;
            }

            public boolean unresolvableRecord(String rec) {
                // nothing in here for now
                return true;
            }
        });
    }

    public long getTotalCount(String candidateName) {
        return mongoTemplate.count(new Query(Criteria.where("candNm").is(candidateName)),
                Contribution.class);
    }

    public long getTotalCount() {
        return mongoTemplate.count(new Query(), Contribution.class);
    }
}
