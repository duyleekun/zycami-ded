/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.AutoValue_TransportContext;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportContext$Builder;
import java.util.Objects;

public final class AutoValue_TransportContext$Builder
extends TransportContext$Builder {
    private String backendName;
    private byte[] extras;
    private Priority priority;

    public TransportContext build() {
        boolean bl2;
        Object object = this.backendName;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" backendName");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.priority) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" priority");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            string2 = this.backendName;
            byte[] byArray = this.extras;
            Priority priority = this.priority;
            object = new AutoValue_TransportContext(string2, byArray, priority, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public TransportContext$Builder setBackendName(String string2) {
        Objects.requireNonNull(string2, "Null backendName");
        this.backendName = string2;
        return this;
    }

    public TransportContext$Builder setExtras(byte[] byArray) {
        this.extras = byArray;
        return this;
    }

    public TransportContext$Builder setPriority(Priority priority) {
        Objects.requireNonNull(priority, "Null priority");
        this.priority = priority;
        return this;
    }
}

