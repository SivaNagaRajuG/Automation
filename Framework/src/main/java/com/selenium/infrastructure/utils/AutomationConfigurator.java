package com.selenium.infrastructure.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

public class AutomationConfigurator {

    private final static Logger LOGGER = Logger.getLogger(AutomationConfigurator.class.getName());

    private final DesiredCapabilities capabilities = new DesiredCapabilities();
    Properties prop = new Properties();

    InputStream input = null;
    String projectpath = System.getProperty("user.dir");

    /**
     * constructor to load properties file
     * @throws IOException
     */
    public AutomationConfigurator() throws IOException {

        try {
            input = new FileInputStream(projectpath+"/AutomationConfigurator.properties");
            prop.load(input);
        }catch (IOException e)
        {
            LOGGER.info("AutomationConfigurator.properties file doesn't exist at "+projectpath);

        }finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * Method to get the capabilities from properties file and mapped to Hash Map
     * @return
     */
    public Map<String, Object> getCapFromPropertiesFile()
    {
        Map<String, Object> map = new HashMap<String, Object>(prop.size());

        for (Object Key: prop.keySet())
        {
            map.put((String) Key,prop.getProperty( (String) Key));
        }

        return map;

    }


    /**
     * Method to set the desired capabilities for mobile
     * @return
     */
    public DesiredCapabilities setMobileCap()
    {
        Map<String,Object> mobileProperties = getCapFromPropertiesFile();
        for(String key: mobileProperties.keySet())
        {
            String value =(String) mobileProperties.get(key);
            if(StringUtils.equalsIgnoreCase(value,"true")||StringUtils.equalsIgnoreCase(value,"false"))
            {
                capabilities.setCapability(key,Boolean.parseBoolean(value));
            }
            else
            {
                capabilities.setCapability(key,value);
            }

        }
        return capabilities;
    }

}
