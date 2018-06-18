

package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }


    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) return Long.parseLong(implicitlyWait);
        else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");
    }

    public String getTAGApplicationUrl() {
        String url = properties.getProperty("Tag_url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }


    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        if (windowSize != null) return Boolean.valueOf(windowSize);
        return true;
    }

    public String getTestDataResourcePath() {
        String testDataResourcePath = properties.getProperty("testDataResourcePath");
        if (testDataResourcePath != null) return testDataResourcePath;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getSuperUserName() {
        String automationTAGSUPER = properties.getProperty("automationTAGSUPER");
        if (automationTAGSUPER != null) return automationTAGSUPER;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getSuperUserPassword() {
        String automationTAGSUPER_password = properties.getProperty("automationTAGSUPER_password");
        if (automationTAGSUPER_password != null) return automationTAGSUPER_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUser1UserName() {
        String automationUser1 = properties.getProperty("automationUser1");
        if (automationUser1 != null) return automationUser1;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUser1Password() {
        String automationUser1_password = properties.getProperty("automationUser1_password");
        if (automationUser1_password != null) return automationUser1_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUser2UserName() {
        String automationUser2 = properties.getProperty("automationUser2");
        if (automationUser2 != null) return automationUser2;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getUser2Password() {
        String automationUser2_password = properties.getProperty("automationUser2_password");
        if (automationUser2_password != null) return automationUser2_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getFISUPERUserName() {
        String automationFISUPER = properties.getProperty("automationFISUPER");
        if (automationFISUPER != null) return automationFISUPER;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getFISUPERPassword() {
        String automationFISUPER_password = properties.getProperty("automationFISUPER_password");
        if (automationFISUPER_password != null) return automationFISUPER_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getPartnerSuperUserName() {
        String automationPartnerSuper = properties.getProperty("automationPartnerSuper");
        if (automationPartnerSuper != null) return automationPartnerSuper;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getPartnerSuperPassword() {
        String automationPartnerSuper_password = properties.getProperty("automationPartnerSuper_password");
        if (automationPartnerSuper_password != null) return automationPartnerSuper_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getTAGCRMUserName() {
        String automationTAGCRM = properties.getProperty("automationTAGCRM");
        if (automationTAGCRM != null) return automationTAGCRM;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getTAGCRMPassword() {
        String automationTAGCRM_password = properties.getProperty("automationTAGCRM_password");
        if (automationTAGCRM_password != null) return automationTAGCRM_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getTAGQAUserName() {
        String automationTAGQA = properties.getProperty("automationTAGQA");
        if (automationTAGQA != null) return automationTAGQA;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }

    public String getTAGQAPassword() {
        String automationTAGQA_password = properties.getProperty("automationTAGQA_password");
        if (automationTAGQA_password != null) return automationTAGQA_password;
        else
            throw new RuntimeException("Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
    }
}