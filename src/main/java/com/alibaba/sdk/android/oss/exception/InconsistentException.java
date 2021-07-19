/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.exception;

import java.io.IOException;

public class InconsistentException
extends IOException {
    private Long clientChecksum;
    private String requestId;
    private Long serverChecksum;

    public InconsistentException(Long l10, Long l11, String string2) {
        this.clientChecksum = l10;
        this.serverChecksum = l11;
        this.requestId = string2;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("InconsistentException: inconsistent object\n[RequestId]: ");
        Object object = this.requestId;
        stringBuilder.append((String)object);
        stringBuilder.append("\n[ClientChecksum]: ");
        object = this.clientChecksum;
        stringBuilder.append(object);
        stringBuilder.append("\n[ServerChecksum]: ");
        object = this.serverChecksum;
        stringBuilder.append(object);
        return stringBuilder.toString();
    }
}

