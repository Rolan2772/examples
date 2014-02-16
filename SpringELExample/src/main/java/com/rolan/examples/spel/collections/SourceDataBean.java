package com.rolan.examples.spel.collections;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("sourceDataBean")
public class SourceDataBean {

    @Resource(name = "simpleMap")
    Map<String, String> map;
    @Resource(name = "simpleList")
    List<String> list;

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
