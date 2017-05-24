package com.xinguoren.coolpen.cloud.web.common.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Lenovo on 2017/5/24.
 */
public class PropertiesUtils {


    public static String getValueByKey(String key) {
        Properties properties = new Properties();
        String fileName = "conf/jdbc.properties";
        String value = "";
        String url = PropertiesUtils.class.getClassLoader().getResource(fileName).getPath();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(url));
            properties.load(in);
            value = properties.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        String value = PropertiesUtils.getValueByKey("jdbc.driver");
        System.out.println(value);
    }

}
