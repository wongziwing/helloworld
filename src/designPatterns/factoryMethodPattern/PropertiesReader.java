package designPatterns.factoryMethodPattern;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {

    public Map<String, String> getProperties(){
        Properties properties = new Properties();
        Map<String, String> map = new HashMap<>();

        InputStream in = getClass().getResourceAsStream("type.properties");
        Enumeration enumeration;
        try {
            properties.load(in);
            // 获取type文件的所有的值
            enumeration = properties.propertyNames();
            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String property = properties.getProperty(key);
                map.put(key, property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

}
