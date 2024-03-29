package com.mkyong.examples;

import org.apache.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class MessageBuilder {
    private static final  Logger logger = Logger.getLogger(MessageBuilder.class);

    public String getMessage(String name) {

        try {
            AtomicInteger aInt1 = new AtomicInteger(0);
            AtomicInteger aInt2 = new AtomicInteger(0);
            
            
            if (aInt1.get() == aInt2.get()) {
                logger.info("Inyecte bug");
            }
            StringBuilder result = new StringBuilder();

            if (name == null || name.trim().length() == 0) {
                result.append("Please provide a name!");
            } else {
                result.append("Hello " + name);

            }
            return result.toString();
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

}
