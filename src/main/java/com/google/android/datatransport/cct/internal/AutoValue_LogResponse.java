/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.LogResponse;

public final class AutoValue_LogResponse
extends LogResponse {
    private final long nextRequestWaitMillis;

    public AutoValue_LogResponse(long l10) {
        this.nextRequestWaitMillis = l10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof LogResponse;
        if (bl3) {
            long l10 = this.nextRequestWaitMillis;
            long l11 = ((LogResponse)(object = (LogResponse)object)).getNextRequestWaitMillis();
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public int hashCode() {
        long l10 = this.nextRequestWaitMillis;
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11) ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogResponse{nextRequestWaitMillis=");
        long l10 = this.nextRequestWaitMillis;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

