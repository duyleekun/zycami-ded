/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.IMessageEntity;

public class ResponseHeader
implements IMessageEntity {
    public int statusCode;

    public ResponseHeader() {
    }

    public ResponseHeader(int n10) {
        this.statusCode = n10;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}

