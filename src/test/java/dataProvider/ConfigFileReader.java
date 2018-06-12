

package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath="configs//Configuration.properties";
    public ConfigFileReader(){
        BufferedReader reader;
        try{
            reader=new BufferedReader(new FileReader(propertyFilePath));
            properties=new Properties();
            try{
                properties.load(reader);
                reader.close();
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getTAGApplicationUrl() {
        String url = properties.getProperty("Tag_url");
        if(url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if(windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }
    public String getTestDataResourcePath(){
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if(testDataResourcePath!= null) return testDataResourcePath;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
    public String getSuperUserName(){
        String automationTAGSUPER = properties.getProperty("automationTAGSUPER");
        if(automationTAGSUPER!= null) return automationTAGSUPER;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
    public String getSuperUserPassword(){
        String automationTAGSUPER_password = properties.getProperty("automationTAGSUPER_password");
        if(automationTAGSUPER_password!= null) return automationTAGSUPER_password;
        else throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
}
