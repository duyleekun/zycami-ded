/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class DeleteObjectRequest
extends OSSRequest {
    private String bucketName;
    private String objectKey;

    public DeleteObjectRequest(String string2, String string3) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }
}

