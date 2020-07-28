package com.restassuredexample.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;


public class PropertyLoader {
    public static String url;
    static {
        Properties prop = new Properties();
        try {
            File file = new File("src/test/resources/config.properties");
            InputStream fs = new FileInputStream(file);
            prop.load(fs);
            url = prop.getProperty("base.url");
        }catch (IOException e){
            System.exit(0);
        }
    }
    public static String getUrl(){
        return url;
    }

}
