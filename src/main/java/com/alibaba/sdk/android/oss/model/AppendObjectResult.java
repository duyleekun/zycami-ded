/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.model.OSSResult;

public class AppendObjectResult
extends OSSResult {
    private long nextPosition;
    private String objectCRC64;

    public long getNextPosition() {
        return this.nextPosition;
    }

    public String getObjectCRC64() {
        return this.objectCRC64;
    }

    public void setNextPosition(Long l10) {
        long l11;
        this.nextPosition = l11 = l10.longValue();
    }

    public void setObjectCRC64(String string2) {
        this.objectCRC64 = string2;
    }
}

