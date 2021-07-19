/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class RestoreObjectRequest
extends OSSRequest {
    private String bucketName;
    private String objectKey;

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

