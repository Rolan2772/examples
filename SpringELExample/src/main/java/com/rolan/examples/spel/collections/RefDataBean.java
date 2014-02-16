package com.rolan.examples.spel.collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("refDataBean")
public class RefDataBean {

    @Value("#{sourceDataBean.map['key 1']}")
    private String mapValue;
    @Value("#{sourceDataBean.list[0]}")
    private String listValue;

    public String getMapValue() {
        return mapValue;
    }

    public void setMapValue(String mapValue) {
        this.mapValue = mapValue;
    }

    public String getListValue() {
        return listValue;
    }

    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    @Override
    public String toString() {
        return "RefDataBean{" +
                "mapValue='" + mapValue + '\'' +
                ", listValue='" + listValue + '\'' +
                '}';
    }
}
