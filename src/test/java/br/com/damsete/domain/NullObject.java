package br.com.damsete.domain;

import java.math.BigDecimal;

public class NullObject {

    public Object object;
    private String string;
    private BigDecimal bigDecimal;

    public NullObject() {
    }

    public NullObject(Object object, String string, BigDecimal bigDecimal) {
        this.object = object;
        this.string = string;
        this.bigDecimal = bigDecimal;
    }

    public Object getObject() {
        return object;
    }

    public String getString() {
        return string;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }
}
