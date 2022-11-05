package com.mkyong.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestMessageBuilder {

    @Test
    void testNameMkyong() {
        MessageBuilder obj = new MessageBuilder();
        assertEquals("Hello mkyong", obj.getMessage("mkyong"));
    }

    @Test
    void testNameNull() {
        MessageBuilder obj = new MessageBuilder();
        assertEquals("Please provide a name!", obj.getMessage(null));
    }

    @Test
    void readFile() {
        LeerFicherosExcel obj = new LeerFicherosExcel();
        obj.readFile();
    }

    @Test
    void createFile() {
        CrearFicherosExcel.createFile();
    }
}