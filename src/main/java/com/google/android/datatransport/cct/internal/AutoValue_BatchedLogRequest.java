/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import java.util.List;
import java.util.Objects;

public final class AutoValue_BatchedLogRequest
extends BatchedLogRequest {
    private final List logRequests;

    public AutoValue_BatchedLogRequest(List list) {
        Objects.requireNonNull(list, "Null logRequests");
        this.logRequests = list;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof BatchedLogRequest;
        if (bl2) {
            object = (BatchedLogRequest)object;
            List list = this.logRequests;
            object = ((BatchedLogRequest)object).getLogRequests();
            return list.equals(object);
        }
        return false;
    }

    public List getLogRequests() {
        return this.logRequests;
    }

    public int hashCode() {
        return this.logRequests.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BatchedLogRequest{logRequests=");
        List list = this.logRequests;
        stringBuilder.append(list);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

