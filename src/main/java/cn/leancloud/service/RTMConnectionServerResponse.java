/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

public class RTMConnectionServerResponse {
    private String groupId;
    private String groupUrl;
    private String secondary;
    private String server;
    private long ttl;

    public String getGroupId() {
        return this.groupId;
    }

    public String getGroupUrl() {
        return this.groupUrl;
    }

    public String getSecondary() {
        return this.secondary;
    }

    public String getServer() {
        return this.server;
    }

    public long getTtl() {
        return this.ttl;
    }

    public void setGroupId(String string2) {
        this.groupId = string2;
    }

    public void setGroupUrl(String string2) {
        this.groupUrl = string2;
    }

    public void setSecondary(String string2) {
        this.secondary = string2;
    }

    public void setServer(String string2) {
        this.server = string2;
    }

    public void setTtl(long l10) {
        this.ttl = l10;
    }
}

