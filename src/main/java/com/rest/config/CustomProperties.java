package com.rest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "custom")
public class CustomProperties {

    private String pesho;

    private String yes;

    private String no;

    public String getPesho() {
        return pesho;
    }

    public void setPesho(String pesho) {
        this.pesho = pesho;
    }

    public String getYes() {
        return yes;
    }

    public void setYes(String yes) {
        this.yes = yes;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
