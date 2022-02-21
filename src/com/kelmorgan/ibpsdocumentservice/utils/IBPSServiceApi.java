package com.kelmorgan.ibpsdocumentservice.utils;

import com.kelmorgan.ibpservices.initializer.IBPSServiceHandler;
import com.kelmorgan.ibpservices.initializer.ServiceInitializer;
import com.kelmorgan.ibpservices.initializer.ServiceInjector;

public class IBPSServiceApi {

    private final String configPath;

    public IBPSServiceApi(String configPath) {
        this.configPath = configPath;
    }

    public IBPSServiceHandler initializedService() {
        ServiceInjector serviceInjector = new ServiceInitializer();
        return serviceInjector.getService(configPath);
    }
}
