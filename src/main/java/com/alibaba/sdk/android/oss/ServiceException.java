/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss;

import com.alibaba.sdk.android.oss.common.OSSLog;

public class ServiceException
extends Exception {
    private static final long serialVersionUID = 430933593095358673L;
    private String errorCode;
    private String hostId;
    private String partEtag;
    private String partNumber;
    private String rawMessage;
    private String requestId;
    private int statusCode;

    public ServiceException(int n10, String string2, String string3, String string4, String string5, String string6) {
        super(string2);
        this.statusCode = n10;
        this.errorCode = string3;
        this.requestId = string4;
        this.hostId = string5;
        this.rawMessage = string6;
        OSSLog.logThrowable2Local(this);
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getHostId() {
        return this.hostId;
    }

    public String getPartEtag() {
        return this.partEtag;
    }

    public String getPartNumber() {
        return this.partNumber;
    }

    public String getRawMessage() {
        return this.rawMessage;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setPartEtag(String string2) {
        this.partEtag = string2;
    }

    public void setPartNumber(String string2) {
        this.partNumber = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[StatusCode]: ");
        int n10 = this.statusCode;
        stringBuilder.append(n10);
        stringBuilder.append(", [Code]: ");
        String string2 = this.getErrorCode();
        stringBuilder.append(string2);
        stringBuilder.append(", [Message]: ");
        string2 = this.getMessage();
        stringBuilder.append(string2);
        stringBuilder.append(", [Requestid]: ");
        string2 = this.getRequestId();
        stringBuilder.append(string2);
        stringBuilder.append(", [HostId]: ");
        string2 = this.getHostId();
        stringBuilder.append(string2);
        stringBuilder.append(", [RawMessage]: ");
        string2 = this.getRawMessage();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

