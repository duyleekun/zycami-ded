/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

public class TXPlayerAuthBuilder {
    public int appId;
    public int exper = -1;
    public String fileId;
    public boolean isHttps;
    public String sign;
    public String timeout;
    public String us;

    public int getAppId() {
        return this.appId;
    }

    public int getExper() {
        return this.exper;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getSign() {
        return this.sign;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public String getUs() {
        return this.us;
    }

    public boolean isHttps() {
        return this.isHttps;
    }

    public void setAppId(int n10) {
        this.appId = n10;
    }

    public void setExper(int n10) {
        this.exper = n10;
    }

    public void setFileId(String string2) {
        this.fileId = string2;
    }

    public void setHttps(boolean bl2) {
        this.isHttps = bl2;
    }

    public void setSign(String string2) {
        this.sign = string2;
    }

    public void setTimeout(String string2) {
        this.timeout = string2;
    }

    public void setUs(String string2) {
        this.us = string2;
    }
}

