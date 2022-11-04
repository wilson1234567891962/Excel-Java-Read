package com.mkyong.examples;

import java.util.concurrent.atomic.AtomicInteger;

public class MessageBuilder {

    public String getMessage(String name) {

        try {
            String a = "";
            AtomicInteger aInt1 = new AtomicInteger(0);
            AtomicInteger aInt2 = new AtomicInteger(0);
            if (aInt1.equals(aInt2)) {
                System.out.println("Inyecte bug");
            }
            StringBuilder result = new StringBuilder();

            if (name == null || name.trim().length() == 0) {
                String test = "Test";
                result.append("Please provide a name!");

            } else {

                result.append("Hello " + name);

            }
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
