/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSRequest;
import java.util.ArrayList;

public class PutBucketRefererRequest
extends OSSRequest {
    private boolean mAllowEmpty;
    private String mBucketName;
    private ArrayList mReferers;

    public String getBucketName() {
        return this.mBucketName;
    }

    public ArrayList getReferers() {
        return this.mReferers;
    }

    public boolean isAllowEmpty() {
        return this.mAllowEmpty;
    }

    public void setAllowEmpty(boolean bl2) {
        this.mAllowEmpty = bl2;
    }

    public void setBucketName(String string2) {
        this.mBucketName = string2;
    }

    public void setReferers(ArrayList arrayList) {
        this.mReferers = arrayList;
    }
}

