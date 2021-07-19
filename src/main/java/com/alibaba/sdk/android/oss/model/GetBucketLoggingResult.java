/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class GetBucketLoggingResult
extends OSSResult {
    private boolean mLoggingEnabled = false;
    private String mTargetBucketName;
    private String mTargetPrefix;

    public String getTargetBucketName() {
        return this.mTargetBucketName;
    }

    public String getTargetPrefix() {
        return this.mTargetPrefix;
    }

    public boolean loggingEnabled() {
        return this.mLoggingEnabled;
    }

    public void setLoggingEnabled(boolean bl2) {
        this.mLoggingEnabled = bl2;
    }

    public void setTargetBucketName(String string2) {
        this.mTargetBucketName = string2;
    }

    public void setTargetPrefix(String string2) {
        this.mTargetPrefix = string2;
    }
}

