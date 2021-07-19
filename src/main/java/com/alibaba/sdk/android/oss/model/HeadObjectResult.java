/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;
import com.alibaba.sdk.android.oss.model.ObjectMetadata;

public class HeadObjectResult
extends OSSResult {
    private ObjectMetadata metadata;

    public HeadObjectResult() {
        ObjectMetadata objectMetadata;
        this.metadata = objectMetadata = new ObjectMetadata();
    }

    public ObjectMetadata getMetadata() {
        return this.metadata;
    }

    public void setMetadata(ObjectMetadata objectMetadata) {
        this.metadata = objectMetadata;
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        String string2 = super.toString();
        objectArray[0] = string2;
        string2 = this.metadata.toString();
        objectArray[1] = string2;
        return String.format("HeadObjectResult<%s>:\n metadata:%s", objectArray);
    }
}

