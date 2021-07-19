/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendRequest$Builder;
import java.util.Objects;

public final class AutoValue_BackendRequest$Builder
extends BackendRequest$Builder {
    private Iterable events;
    private byte[] extras;

    public BackendRequest build() {
        boolean bl2;
        Object object = this.events;
        Object object2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" events");
            object2 = ((StringBuilder)object).toString();
        }
        if (bl2 = ((String)object2).isEmpty()) {
            object2 = this.events;
            byte[] byArray = this.extras;
            object = new AutoValue_BackendRequest((Iterable)object2, byArray, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append((String)object2);
        object2 = stringBuilder.toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public BackendRequest$Builder setEvents(Iterable iterable) {
        Objects.requireNonNull(iterable, "Null events");
        this.events = iterable;
        return this;
    }

    public BackendRequest$Builder setExtras(byte[] byArray) {
        this.extras = byArray;
        return this;
    }
}

