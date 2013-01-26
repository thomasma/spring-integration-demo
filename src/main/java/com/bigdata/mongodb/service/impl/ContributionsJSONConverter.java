package com.bigdata.mongodb.service.impl;

import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoPersistentProperty;

import com.bigdata.mongodb.domain.Contribution;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public class ContributionsJSONConverter extends MappingMongoConverter {

    public ContributionsJSONConverter(
            MongoDbFactory mongoDbFactory,
            MappingContext<? extends MongoPersistentEntity<?>, MongoPersistentProperty> mappingContext) {
        super(mongoDbFactory, mappingContext);
    }

    @Override
    public void write(Object source, DBObject target) {
        Contribution contrib = (Contribution) source;
        DBObject innerObject = new BasicDBObject();
        innerObject.put("candId", contrib.getCandId());
        innerObject.put("candNm", contrib.getCandNm());
        innerObject.put("cmteId", contrib.getCmteId());
        innerObject.put("contbrCity", contrib.getContbrCity());
        innerObject.put("contbReceiptAmt", contrib.getContbReceiptAmt());
        innerObject.put("contbReceiptDt", contrib.getContbReceiptDt());
        innerObject.put("contbrEmployer", contrib.getContbrEmployer());
        innerObject.put("contbrNm", contrib.getContbrNm());
        innerObject.put("contbrOccupation", contrib.getContbrOccupation());
        innerObject.put("contbrSt", contrib.getContbrSt());
        innerObject.put("contbrZip", contrib.getContbrZip());
        innerObject.put("fileNum", contrib.getFileNum());
        innerObject.put("memoText", contrib.getMemoText());
        innerObject.put("receiptDesc", contrib.getReceiptDesc());
        target.put("contribution", innerObject);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <S> S read(Class<S> clazz, DBObject source) {
        Contribution c = new Contribution();
        c.setCandId((String) source.get("candId"));
        c.setCandNm((String) source.get("candNm"));
        c.setCmteId((String) source.get("cmteId"));
        c.setContbrCity((String) source.get("contbrCity"));
        c.setContbReceiptAmt((Double) source.get("contbReceiptAmt"));
        c.setContbReceiptDt((String) source.get("contbReceiptDt"));
        c.setContbrEmployer((String) source.get("contbrEmployer"));
        c.setContbrNm((String) source.get("contbrNm"));
        c.setContbrOccupation((String) source.get("contbrOccupation"));
        c.setContbrSt((String) source.get("contbrSt"));
        c.setContbrZip((String) source.get("contbrZip"));
        c.setFileNum((String) source.get("fileNum"));
        c.setMemoText((String) source.get("memoText"));
        c.setReceiptDesc((String) source.get("receiptDesc"));
        return (S) c;
    }
}
