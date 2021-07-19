/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;

public class InitiateMultipartUploadRequest
extends OSSRequest {
    private String bucketName;
    public boolean isSequential;
    private ObjectMetadata metadata;
    private String objectKey;

    public InitiateMultipartUploadRequest(String string2, String string3) {
        this(string2, string3, null);
    }

    public InitiateMultipartUploadRequest(String string2, String string3, ObjectMetadata objectMetadata) {
        this.setBucketName(string2);
        this.setObjectKey(string3);
        this.setMetadata(objectMetadata);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }
}

