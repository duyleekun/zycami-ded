/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;

public class ImagePersistRequest
extends OSSRequest {
    public String mAction;
    public String mFromBucket;
    public String mFromObjectkey;
    public String mToBucketName;
    public String mToObjectKey;

    public ImagePersistRequest(String string2, String string3, String string4, String string5, String string6) {
        this.mFromBucket = string2;
        this.mFromObjectkey = string3;
        this.mToBucketName = string4;
        this.mToObjectKey = string5;
        this.mAction = string6;
    }
}

