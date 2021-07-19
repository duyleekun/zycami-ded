/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class GetBucketInfoRequest
extends OSSRequest {
    private String bucketName;

    public GetBucketInfoRequest(String string2) {
        this.bucketName = string2;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }
}

