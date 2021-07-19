/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.EventInternal$Builder;
import java.util.Map;
import java.util.Objects;

public final class AutoValue_EventInternal$Builder
extends EventInternal$Builder {
    private Map autoMetadata;
    private Integer code;
    private EncodedPayload encodedPayload;
    private Long eventMillis;
    private String transportName;
    private Long uptimeMillis;

    public EventInternal build() {
        boolean bl2;
        Object object = this.transportName;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" transportName");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.encodedPayload) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" encodedPayload");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.eventMillis) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" eventMillis");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.uptimeMillis) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" uptimeMillis");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.autoMetadata) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" autoMetadata");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            String string3 = this.transportName;
            Integer n10 = this.code;
            EncodedPayload encodedPayload = this.encodedPayload;
            long l10 = this.eventMillis;
            long l11 = this.uptimeMillis;
            Map map = this.autoMetadata;
            Object object2 = object;
            object = new AutoValue_EventInternal(string3, n10, encodedPayload, l10, l11, map, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public Map getAutoMetadata() {
        Object object = this.autoMetadata;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Property \"autoMetadata\" has not been set");
        throw object;
    }

    public EventInternal$Builder setAutoMetadata(Map map) {
        Objects.requireNonNull(map, "Null autoMetadata");
        this.autoMetadata = map;
        return this;
    }

    public EventInternal$Builder setCode(Integer n10) {
        this.code = n10;
        return this;
    }

    public EventInternal$Builder setEncodedPayload(EncodedPayload encodedPayload) {
        Objects.requireNonNull(encodedPayload, "Null encodedPayload");
        this.encodedPayload = encodedPayload;
        return this;
    }

    public EventInternal$Builder setEventMillis(long l10) {
        Long l11;
        this.eventMillis = l11 = Long.valueOf(l10);
        return this;
    }

    public EventInternal$Builder setTransportName(String string2) {
        Objects.requireNonNull(string2, "Null transportName");
        this.transportName = string2;
        return this;
    }

    public EventInternal$Builder setUptimeMillis(long l10) {
        Long l11;
        this.uptimeMillis = l11 = Long.valueOf(l10);
        return this;
    }
}

