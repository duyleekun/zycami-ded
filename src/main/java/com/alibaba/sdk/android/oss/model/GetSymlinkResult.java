/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class GetSymlinkResult
extends OSSResult {
    private String targetObjectName;

    public String getTargetObjectName() {
        return this.targetObjectName;
    }

    public void setTargetObjectName(String string2) {
        this.targetObjectName = string2;
    }
}

