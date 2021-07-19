/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;

public class PutSymlinkRequest
extends OSSRequest {
    private String bucketName;
    private ObjectMetadata metadata;
    private String objectKey;
    private String targetObjectName;

    public String getBucketName() {
        return this.bucketName;
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public String getTargetObjectName() {
        return this.targetObjectName;
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

    public void setTargetObjectName(String string2) {
        this.targetObjectName = string2;
    }
}

