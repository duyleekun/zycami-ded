/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class InitiateMultipartUploadResult
extends OSSResult {
    private String bucketName;
    private String objectKey;
    private String uploadId;

    public String getBucketName() {
        return this.bucketName;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getUploadId() {
        return this.uploadId;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setUploadId(String string2) {
        this.uploadId = string2;
    }
}

