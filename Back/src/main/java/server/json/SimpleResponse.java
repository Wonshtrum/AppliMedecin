package server.json;

import java.lang.reflect.Field;
import java.util.HashMap;

public class SimpleResponse extends HashMap<String, Object> {
    public SimpleResponse() {
        super();
    }
    public SimpleResponse(Object source) {
        super();
        Field[] fs = source.getClass().getDeclaredFields();
        for(Field f : fs) {
            f.setAccessible(true);
            try {
                this.put(f.getName(), f.get(source));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
