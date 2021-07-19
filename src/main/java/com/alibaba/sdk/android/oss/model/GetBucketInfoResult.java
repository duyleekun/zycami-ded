/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSBucketSummary;
import com.alibaba.sdk.android.oss.model.OSSResult;

public class GetBucketInfoResult
extends OSSResult {
    private OSSBucketSummary bucket;

    public OSSBucketSummary getBucket() {
        return this.bucket;
    }

    public void setBucket(OSSBucketSummary oSSBucketSummary) {
        this.bucket = oSSBucketSummary;
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        String string2 = super.toString();
        objectArray[0] = string2;
        string2 = this.bucket.toString();
        objectArray[1] = string2;
        return String.format("GetBucketInfoResult<%s>:\n bucket:%s", objectArray);
    }
}

