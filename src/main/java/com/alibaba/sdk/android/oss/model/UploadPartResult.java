/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class UploadPartResult
extends OSSResult {
    private String eTag;

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String string2) {
        this.eTag = string2;
    }
}

