package com.zxit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "local-config")
public class YmlConfig {

    private String serverIp;

    public YmlConfig() {
    }

    public YmlConfig(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    @Override
    public String toString() {
        return "YmlConfig{" +
                "serverIp='" + serverIp + '\'' +
                '}';
    }
}