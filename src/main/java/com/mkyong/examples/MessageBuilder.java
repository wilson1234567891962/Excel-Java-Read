package com.mkyong.examples;

public class MessageBuilder {

    public String getMessage(String name) {

        StringBuilder result = new StringBuilder();

        if (name == null || name.trim().length() == 0) {

            result.append("Please provide a name!");

        } else {
            result.append("");
            result.append("Hello " + name);
            result.append("");
        }
        return result.toString();
    }

}
