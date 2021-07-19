/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import java.util.Map;

public class OSSResult {
    private Long clientCRC;
    private String requestId;
    private Map responseHeader;
    private Long serverCRC;
    private int statusCode;

    public Long getClientCRC() {
        return this.clientCRC;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Map getResponseHeader() {
        return this.responseHeader;
    }

    public Long getServerCRC() {
        return this.serverCRC;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setClientCRC(Long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        if (l10 != null && (l14 = (l13 = (l12 = l10.longValue()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            this.clientCRC = l10;
        }
    }

    public void setRequestId(String string2) {
        this.requestId = string2;
    }

    public void setResponseHeader(Map map) {
        this.responseHeader = map;
    }

    public void setServerCRC(Long l10) {
        long l11;
        long l12;
        long l13;
        long l14;
        if (l10 != null && (l14 = (l13 = (l12 = l10.longValue()) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
            this.serverCRC = l10;
        }
    }

    public void setStatusCode(int n10) {
        this.statusCode = n10;
    }

    public String toString() {
        Object object = super.toString();
        Object[] objectArray = new Object[]{object, object = Integer.valueOf(this.statusCode), object = this.responseHeader.toString(), object = this.requestId};
        return String.format("OSSResult<%s>: \nstatusCode:%d,\nresponseHeader:%s,\nrequestId:%s", objectArray);
    }
}

