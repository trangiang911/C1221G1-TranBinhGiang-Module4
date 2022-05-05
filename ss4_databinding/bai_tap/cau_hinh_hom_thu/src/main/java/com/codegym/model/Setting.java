package com.codegym.model;

public class Setting {
    private String language;
    private String pageSize;
    private boolean SpamsFillter;
    private String signature;

    public Setting(String language, String pageSize, boolean spamsFillter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.SpamsFillter = spamsFillter;
        this.signature = signature;
    }

    public Setting() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public boolean getSpamsFillter() {
        return SpamsFillter;
    }

    public void setSpamsFillter(boolean spamsFillter) {
        SpamsFillter = spamsFillter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
