/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class GetBucketLifecycleRequest
extends OSSRequest {
    private String mBucketName;

    public String getBucketName() {
        return this.mBucketName;
    }

    public void setBucketName(String string2) {
        this.mBucketName = string2;
    }
}

