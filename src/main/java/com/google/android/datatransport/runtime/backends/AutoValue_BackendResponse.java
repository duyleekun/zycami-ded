/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.BackendResponse$Status;
import java.util.Objects;

public final class AutoValue_BackendResponse
extends BackendResponse {
    private final long nextRequestWaitMillis;
    private final BackendResponse$Status status;

    public AutoValue_BackendResponse(BackendResponse$Status backendResponse$Status, long l10) {
        Objects.requireNonNull(backendResponse$Status, "Null status");
        this.status = backendResponse$Status;
        this.nextRequestWaitMillis = l10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof BackendResponse;
        if (bl3) {
            long l10;
            long l11;
            long l12;
            long l13;
            BackendResponse$Status backendResponse$Status = this.status;
            BackendResponse$Status backendResponse$Status2 = ((BackendResponse)(object = (BackendResponse)object)).getStatus();
            bl3 = backendResponse$Status.equals((Object)backendResponse$Status2);
            if (!bl3 || (l13 = (l12 = (l11 = this.nextRequestWaitMillis) - (l10 = ((BackendResponse)object).getNextRequestWaitMillis())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public long getNextRequestWaitMillis() {
        return this.nextRequestWaitMillis;
    }

    public BackendResponse$Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int n10 = this.status.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        long l10 = this.nextRequestWaitMillis;
        long l11 = l10 >>> 32;
        n11 = (int)(l10 ^ l11);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BackendResponse{status=");
        BackendResponse$Status backendResponse$Status = this.status;
        stringBuilder.append((Object)backendResponse$Status);
        stringBuilder.append(", nextRequestWaitMillis=");
        long l10 = this.nextRequestWaitMillis;
        stringBuilder.append(l10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

