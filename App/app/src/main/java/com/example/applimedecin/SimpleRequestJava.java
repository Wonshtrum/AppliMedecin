package com.example.applimedecin;

import java.util.HashMap;
import java.util.Map;

public class SimpleRequestJava {
    public static final String CLIENT = "Client";
    public static final String OFFRE = "Offre";
    public static final String POSTULAT = "Postulat";
    public static final String REMPLACANT = "Remplacant";

    private String type;
    private HashMap<String, String> content;
    public SimpleRequestJava(String type) {
        this.type = type;
        content = new HashMap<String, String>();
    }

    public void put(String key, String value) {
        this.content.put(key, value);
    }

    @Override
    public String toString() {
        String res = "[\""+type+"\",{";
        for (Map.Entry<String, String> c : content.entrySet()) {
            res += "\""+c.getKey()+"\":\""+c.getValue()+"\"";
        }
        return res+"}]";
    }
}
