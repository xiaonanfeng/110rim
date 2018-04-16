package com.zxit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "local-config")
public class YmlConfig {

    private String serverIp;
    private String httpFilePath;

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

    public String getHttpFilePath() {
        return httpFilePath;
    }

    public void setHttpFilePath(String httpFilePath) {
        this.httpFilePath = httpFilePath;
    }

    @Override
    public String toString() {
        return "YmlConfig{" +
                "serverIp='" + serverIp + '\'' +
                '}';
    }
}