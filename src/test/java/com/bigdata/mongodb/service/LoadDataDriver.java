package com.bigdata.mongodb.service;

import java.io.File;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Run this to load data into Mongodb using Spring Integration and ActiveMQ.
 */
public class LoadDataDriver {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        DataLoader loader = ctx.getBean(DataLoader.class);

        // --------------------------------
        // load data - point this to your path
        // --------------------------------
        loader.loadData(new File("place path to your file here"));

        // --------------------------------
        // print total count for verification
        // --------------------------------
        //System.out.println("Total Count of Documents = " + loader.getTotalCount());

        //
        ctx.close();
    }
}
