/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.BucketLifecycleRule;
import com.alibaba.sdk.android.oss.model.OSSResult;
import java.util.ArrayList;

public class GetBucketLifecycleResult
extends OSSResult {
    private ArrayList mLifecycleRules;

    public void addLifecycleRule(BucketLifecycleRule bucketLifecycleRule) {
        ArrayList arrayList = this.mLifecycleRules;
        if (arrayList == null) {
            this.mLifecycleRules = arrayList = new ArrayList();
        }
        this.mLifecycleRules.add(bucketLifecycleRule);
    }

    public ArrayList getlifecycleRules() {
        return this.mLifecycleRules;
    }

    public void setLifecycleRules(ArrayList arrayList) {
        this.mLifecycleRules = arrayList;
    }
}

