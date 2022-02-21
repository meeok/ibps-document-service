package com.kelmorgan.ibpsdocumentservice.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class LoadProp implements Constants {
    private final Properties properties = new Properties();

    public LoadProp(String configPath) {
        try {
            InputStream inputStream = new FileInputStream(configPath);
            properties.load(inputStream);
        } catch (Exception e) {
            System.out.println("Exception Occurred: " + e.getMessage());
        }
    }

    public String getServerIp() {
        return properties.getProperty(appServerIpField);
    }

    public String getServerWrapperPort() {
        return properties.getProperty(wrapperPortField);
    }

    public String getServerCabinetName() {
        return properties.getProperty(cabinetNameField);
    }

    public String getServiceUserName() {
        return properties.getProperty(usernameField);
    }

    public String getServiceUserPassword() {
        return properties.getProperty(passwordField);
    }

    public String getServiceLogPath() {
        return properties.getProperty(logPathField);
    }

    public String getVolumeId() {
        return properties.getProperty(volumeIdField);
    }

}
