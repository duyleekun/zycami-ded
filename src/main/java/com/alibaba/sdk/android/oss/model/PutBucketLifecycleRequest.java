/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.util.ArrayList;

public class PutBucketLifecycleRequest
extends OSSRequest {
    public ArrayList lifecycleRules;
    private String mBucketName;

    public String getBucketName() {
        return this.mBucketName;
    }

    public ArrayList getLifecycleRules() {
        return this.lifecycleRules;
    }

    public void setBucketName(String string2) {
        this.mBucketName = string2;
    }

    public void setLifecycleRules(ArrayList arrayList) {
        this.lifecycleRules = arrayList;
    }
}

