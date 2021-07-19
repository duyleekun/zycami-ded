/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.AutoValue_EventInternal$1;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

public final class AutoValue_EventInternal
extends EventInternal {
    private final Map autoMetadata;
    private final Integer code;
    private final EncodedPayload encodedPayload;
    private final long eventMillis;
    private final String transportName;
    private final long uptimeMillis;

    private AutoValue_EventInternal(String string2, Integer n10, EncodedPayload encodedPayload, long l10, long l11, Map map) {
        this.transportName = string2;
        this.code = n10;
        this.encodedPayload = encodedPayload;
        this.eventMillis = l10;
        this.uptimeMillis = l11;
        this.autoMetadata = map;
    }

    public /* synthetic */ AutoValue_EventInternal(String string2, Integer n10, EncodedPayload encodedPayload, long l10, long l11, Map map, AutoValue_EventInternal$1 autoValue_EventInternal$1) {
        this(string2, n10, encodedPayload, l10, l11, map);
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    boolean bl3;
                    long l10;
                    long l11;
                    long l12;
                    long l13;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    boolean bl4 = object instanceof EventInternal;
                    if (!bl4) break block4;
                    Object object2 = this.transportName;
                    Object object3 = ((EventInternal)(object = (EventInternal)object)).getTransportName();
                    bl4 = ((String)object2).equals(object3);
                    if (!bl4 || !((object2 = this.code) == null ? (object2 = ((EventInternal)object).getCode()) == null : (bl4 = ((Integer)object2).equals(object3 = ((EventInternal)object).getCode())))) break block5;
                    object2 = this.encodedPayload;
                    object3 = ((EventInternal)object).getEncodedPayload();
                    bl4 = ((EncodedPayload)object2).equals(object3);
                    if (bl4 && !(bl4 = (l13 = (l12 = this.eventMillis) - (l11 = ((EventInternal)object).getEventMillis())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) && !(bl4 = (l10 = (l12 = this.uptimeMillis) - (l11 = ((EventInternal)object).getUptimeMillis())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) && (bl3 = (object2 = this.autoMetadata).equals(object = ((EventInternal)object).getAutoMetadata()))) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Map getAutoMetadata() {
        return this.autoMetadata;
    }

    public Integer getCode() {
        return this.code;
    }

    public EncodedPayload getEncodedPayload() {
        return this.encodedPayload;
    }

    public long getEventMillis() {
        return this.eventMillis;
    }

    public String getTransportName() {
        return this.transportName;
    }

    public long getUptimeMillis() {
        return this.uptimeMillis;
    }

    public int hashCode() {
        int n10;
        String string2 = this.transportName;
        int n11 = string2.hashCode();
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        Integer n13 = this.code;
        if (n13 == null) {
            n10 = 0;
            n13 = null;
        } else {
            n10 = n13.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        n10 = this.encodedPayload.hashCode();
        n11 = (n11 ^ n10) * n12;
        long l10 = this.eventMillis;
        int n14 = 32;
        long l11 = l10 >>> n14;
        n10 = (int)(l10 ^ l11);
        n11 = (n11 ^ n10) * n12;
        l10 = this.uptimeMillis;
        long l12 = l10 >>> n14;
        n10 = (int)(l10 ^ l12);
        n11 = (n11 ^ n10) * n12;
        n12 = this.autoMetadata.hashCode();
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EventInternal{transportName=");
        Object object = this.transportName;
        stringBuilder.append((String)object);
        stringBuilder.append(", code=");
        object = this.code;
        stringBuilder.append(object);
        stringBuilder.append(", encodedPayload=");
        object = this.encodedPayload;
        stringBuilder.append(object);
        stringBuilder.append(", eventMillis=");
        long l10 = this.eventMillis;
        stringBuilder.append(l10);
        stringBuilder.append(", uptimeMillis=");
        l10 = this.uptimeMillis;
        stringBuilder.append(l10);
        stringBuilder.append(", autoMetadata=");
        object = this.autoMetadata;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

