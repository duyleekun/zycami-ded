/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ListMultipartUploadsRequest
extends OSSRequest {
    private String bucketName;
    private String delimiter;
    private String encodingType;
    private String keyMarker;
    private Integer maxUploads;
    private String prefix;
    private String uploadIdMarker;

    public ListMultipartUploadsRequest(String string2) {
        this.bucketName = string2;
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

    public String getKeyMarker() {
        return this.keyMarker;
    }

    public Integer getMaxUploads() {
        return this.maxUploads;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public String getUploadIdMarker() {
        return this.uploadIdMarker;
    }

    public void setDelimiter(String string2) {
        this.delimiter = string2;
    }

    public void setEncodingType(String string2) {
        this.encodingType = string2;
    }

    public void setKeyMarker(String string2) {
        this.keyMarker = string2;
    }

    public void setMaxUploads(Integer n10) {
        this.maxUploads = n10;
    }

    public void setPrefix(String string2) {
        this.prefix = string2;
    }

    public void setUploadIdMarker(String string2) {
        this.uploadIdMarker = string2;
    }
}

