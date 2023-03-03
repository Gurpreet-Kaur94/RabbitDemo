package com.rabbitmq.rabbitmqdemo;

import javax.xml.bind.annotation.XmlEnumValue;

public enum TestEnum {

    REGISTERED_ACCOUNT("RegisteredAccount"),
    UNREGISTERED_ACCOUNT("UnregisteredAccount");

    private String value;

    TestEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
