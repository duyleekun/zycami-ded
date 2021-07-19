/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ListBucketsRequest
extends OSSRequest {
    private static final int MAX_RETURNED_KEYS_LIMIT = 1000;
    private String marker;
    private Integer maxKeys;
    private String prefix;

    public ListBucketsRequest() {
    }

    public ListBucketsRequest(String string2) {
        this(string2, null);
    }

    public ListBucketsRequest(String string2, String string3) {
        Integer n10 = 100;
        this(string2, string3, n10);
    }

    public ListBucketsRequest(String string2, String string3, Integer n10) {
        this.prefix = string2;
        this.marker = string3;
        this.maxKeys = n10;
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

    public void setMarker(String string2) {
        this.marker = string2;
    }

    public void setMaxKeys(Integer n10) {
        this.maxKeys = n10;
    }

    public void setPrefix(String string2) {
        this.prefix = string2;
    }
}

