/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

public abstract class EventInternal$Builder {
    public final EventInternal$Builder addMetadata(String string2, int n10) {
        Map map = this.getAutoMetadata();
        String string3 = String.valueOf(n10);
        map.put(string2, string3);
        return this;
    }

    public final EventInternal$Builder addMetadata(String string2, long l10) {
        Map map = this.getAutoMetadata();
        String string3 = String.valueOf(l10);
        map.put(string2, string3);
        return this;
    }

    public final EventInternal$Builder addMetadata(String string2, String string3) {
        this.getAutoMetadata().put(string2, string3);
        return this;
    }

    public abstract EventInternal build();

    public abstract Map getAutoMetadata();

    public abstract EventInternal$Builder setAutoMetadata(Map var1);

    public abstract EventInternal$Builder setCode(Integer var1);

    public abstract EventInternal$Builder setEncodedPayload(EncodedPayload var1);

    public abstract EventInternal$Builder setEventMillis(long var1);

    public abstract EventInternal$Builder setTransportName(String var1);

    public abstract EventInternal$Builder setUptimeMillis(long var1);
}

