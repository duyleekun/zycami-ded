/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ListPartsRequest
extends OSSRequest {
    private String bucketName;
    private Integer maxParts;
    private String objectKey;
    private Integer partNumberMarker;
    private String uploadId;

    public ListPartsRequest(String string2, String string3, String string4) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setUploadId(string4);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public Integer getMaxParts() {
        return this.maxParts;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Integer getPartNumberMarker() {
        return this.partNumberMarker;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setMaxParts(int n10) {
        Integer n11;
        this.maxParts = n11 = Integer.valueOf(n10);
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setPartNumberMarker(Integer n10) {
        this.partNumberMarker = n10;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

