/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class PutBucketLoggingRequest
extends OSSRequest {
    private String mBucketName;
    private String mTargetBucketName;
    private String mTargetPrefix;

    public String getBucketName() {
        return this.mBucketName;
    }

    public String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public void setBucketName(String string2) {
        this.mBucketName = string2;
    }

    public void setTargetBucketName(String string2) {
        this.mTargetBucketName = string2;
    }

    public void setTargetPrefix(String string2) {
        this.mTargetPrefix = string2;
    }
}

