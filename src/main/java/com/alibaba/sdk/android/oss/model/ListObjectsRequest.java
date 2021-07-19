/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ListObjectsRequest
extends OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private String marker;
    private Integer maxKeys;
    private String prefix;

    public ListObjectsRequest() {
        this(null);
    }

    public ListObjectsRequest(String string2) {
        this(string2, null, null, null, null);
    }

    public ListObjectsRequest(String string2, String string3, String string4, String string5, Integer n10) {
        this.setBucketName(string2);
        this.setPrefix(string3);
        this.setMarker(string4);
        this.setDelimiter(string5);
        if (n10 != null) {
            this.setMaxKeys(n10);
        }
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getDelimiter() {
        return this.delimiter;
    }

    public String getEncodingType() {
        return this.encodingType;
    }

    public String getMarker() {
        return this.marker;
    }

    public Integer getMaxKeys() {
        return this.maxKeys;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setDelimiter(String string2) {
        this.delimiter = string2;
    }

    public void setEncodingType(String string2) {
        this.encodingType = string2;
    }

    public void setMarker(String string2) {
        this.marker = string2;
    }

    public void setMaxKeys(Integer serializable) {
        int n10;
        int n11 = serializable;
        if (n11 >= 0 && (n11 = serializable.intValue()) <= (n10 = 1000)) {
            this.maxKeys = serializable;
            return;
        }
        serializable = new IllegalArgumentException("Maxkeys should less can not exceed 1000.");
        throw serializable;
    }

    public void setPrefix(String string2) {
        this.prefix = string2;
    }
}

