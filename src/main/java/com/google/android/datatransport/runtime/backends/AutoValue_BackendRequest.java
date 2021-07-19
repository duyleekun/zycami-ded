/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest$1;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import java.util.Arrays;

public final class AutoValue_BackendRequest
extends BackendRequest {
    private final Iterable events;
    private final byte[] extras;

    private AutoValue_BackendRequest(Iterable iterable, byte[] byArray) {
        this.events = iterable;
        this.extras = byArray;
    }

    public /* synthetic */ AutoValue_BackendRequest(Iterable iterable, byte[] byArray, AutoValue_BackendRequest$1 autoValue_BackendRequest$1) {
        this(iterable, byArray);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof BackendRequest;
        if (bl3) {
            boolean bl4;
            boolean bl5;
            Object object2 = this.events;
            Iterable iterable = ((BackendRequest)(object = (BackendRequest)object)).getEvents();
            bl3 = object2.equals(iterable);
            if (!bl3 || !(bl5 = Arrays.equals((byte[])(object2 = (Object)this.extras), (byte[])(object = (bl4 = object instanceof AutoValue_BackendRequest) ? (Object)((AutoValue_BackendRequest)object).extras : (Object)((BackendRequest)object).getExtras())))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Iterable getEvents() {
        return this.events;
    }

    public byte[] getExtras() {
        return this.extras;
    }

    public int hashCode() {
        int n10 = this.events.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = Arrays.hashCode(this.extras);
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BackendRequest{events=");
        Object object = this.events;
        stringBuilder.append(object);
        stringBuilder.append(", extras=");
        object = Arrays.toString(this.extras);
        stringBuilder.append((String)object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

