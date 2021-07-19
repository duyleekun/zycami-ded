/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal$Builder;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal$Builder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class EventInternal {
    public static EventInternal$Builder builder() {
        AutoValue_EventInternal$Builder autoValue_EventInternal$Builder = new AutoValue_EventInternal$Builder();
        HashMap hashMap = new HashMap();
        return autoValue_EventInternal$Builder.setAutoMetadata(hashMap);
    }

    public final String get(String string2) {
        Map map = this.getAutoMetadata();
        string2 = (String)map.get(string2);
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public abstract Map getAutoMetadata();

    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String object) {
        int n10;
        Map map = this.getAutoMetadata();
        object = (String)map.get(object);
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = Integer.valueOf((String)object);
            n10 = (Integer)object;
        }
        return n10;
    }

    public final long getLong(String object) {
        long l10;
        Map map = this.getAutoMetadata();
        object = (String)map.get(object);
        if (object == null) {
            l10 = 0L;
        } else {
            object = Long.valueOf((String)object);
            l10 = (Long)object;
        }
        return l10;
    }

    public final Map getMetadata() {
        return Collections.unmodifiableMap(this.getAutoMetadata());
    }

    public final String getOrDefault(String string2, String string3) {
        Map map = this.getAutoMetadata();
        string2 = (String)map.get(string2);
        if (string2 != null) {
            string3 = string2;
        }
        return string3;
    }

    public byte[] getPayload() {
        return this.getEncodedPayload().getBytes();
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public EventInternal$Builder toBuilder() {
        EventInternal$Builder eventInternal$Builder = new AutoValue_EventInternal$Builder();
        HashMap hashMap = this.getTransportName();
        eventInternal$Builder = ((AutoValue_EventInternal$Builder)eventInternal$Builder).setTransportName((String)((Object)hashMap));
        hashMap = this.getCode();
        eventInternal$Builder = eventInternal$Builder.setCode((Integer)((Object)hashMap));
        hashMap = this.getEncodedPayload();
        eventInternal$Builder = eventInternal$Builder.setEncodedPayload((EncodedPayload)((Object)hashMap));
        long l10 = this.getEventMillis();
        eventInternal$Builder = eventInternal$Builder.setEventMillis(l10);
        l10 = this.getUptimeMillis();
        eventInternal$Builder = eventInternal$Builder.setUptimeMillis(l10);
        Map map = this.getAutoMetadata();
        hashMap = new HashMap(map);
        return eventInternal$Builder.setAutoMetadata(hashMap);
    }
}

