/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent$1;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import java.util.Arrays;

public final class AutoValue_LogEvent
extends LogEvent {
    private final Integer eventCode;
    private final long eventTimeMs;
    private final long eventUptimeMs;
    private final NetworkConnectionInfo networkConnectionInfo;
    private final byte[] sourceExtension;
    private final String sourceExtensionJsonProto3;
    private final long timezoneOffsetSeconds;

    private AutoValue_LogEvent(long l10, Integer n10, long l11, byte[] byArray, String string2, long l12, NetworkConnectionInfo networkConnectionInfo) {
        this.eventTimeMs = l10;
        this.eventCode = n10;
        this.eventUptimeMs = l11;
        this.sourceExtension = byArray;
        this.sourceExtensionJsonProto3 = string2;
        this.timezoneOffsetSeconds = l12;
        this.networkConnectionInfo = networkConnectionInfo;
    }

    public /* synthetic */ AutoValue_LogEvent(long l10, Integer n10, long l11, byte[] byArray, String string2, long l12, NetworkConnectionInfo networkConnectionInfo, AutoValue_LogEvent$1 autoValue_LogEvent$1) {
        this(l10, n10, l11, byArray, string2, l12, networkConnectionInfo);
    }

    public boolean equals(Object object) {
        block6: {
            boolean bl2;
            block8: {
                block7: {
                    boolean bl3;
                    long l10;
                    long l11;
                    Object object2;
                    Object object3;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    Object object4 = object instanceof LogEvent;
                    if (!object4) break block6;
                    long l12 = this.eventTimeMs;
                    long l13 = ((LogEvent)(object = (LogEvent)object)).getEventTimeMs();
                    long l14 = l12 - l13;
                    object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object4 || !((object3 = this.eventCode) == null ? (object3 = ((LogEvent)object).getEventCode()) == null : (object4 = ((Integer)object3).equals(object2 = ((LogEvent)object).getEventCode()))) || (object4 = (l11 = (l12 = this.eventUptimeMs) - (l13 = ((LogEvent)object).getEventUptimeMs())) == 0L ? 0 : (l11 < 0L ? -1 : 1))) break block7;
                    object3 = this.sourceExtension;
                    boolean bl4 = object instanceof AutoValue_LogEvent;
                    if (bl4) {
                        object2 = object;
                        object2 = ((AutoValue_LogEvent)object).sourceExtension;
                    } else {
                        object2 = ((LogEvent)object).getSourceExtension();
                    }
                    object4 = Arrays.equals((byte[])object3, (byte[])object2);
                    if (object4 && ((object3 = this.sourceExtensionJsonProto3) == null ? (object3 = ((LogEvent)object).getSourceExtensionJsonProto3()) == null : (object4 = ((String)object3).equals(object2 = ((LogEvent)object).getSourceExtensionJsonProto3()))) && !(object4 = (l10 = (l12 = this.timezoneOffsetSeconds) - (l13 = ((LogEvent)object).getTimezoneOffsetSeconds())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) && ((object3 = this.networkConnectionInfo) == null ? (object = ((LogEvent)object).getNetworkConnectionInfo()) == null : (bl3 = object3.equals(object = ((LogEvent)object).getNetworkConnectionInfo())))) break block8;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Integer getEventCode() {
        return this.eventCode;
    }

    public long getEventTimeMs() {
        return this.eventTimeMs;
    }

    public long getEventUptimeMs() {
        return this.eventUptimeMs;
    }

    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.networkConnectionInfo;
    }

    public byte[] getSourceExtension() {
        return this.sourceExtension;
    }

    public String getSourceExtensionJsonProto3() {
        return this.sourceExtensionJsonProto3;
    }

    public long getTimezoneOffsetSeconds() {
        return this.timezoneOffsetSeconds;
    }

    public int hashCode() {
        int n10;
        long l10 = this.eventTimeMs;
        int n11 = 32;
        long l11 = l10 >>> n11;
        int n12 = (int)(l10 ^= l11);
        int n13 = 1000003;
        n12 = (n12 ^ n13) * n13;
        Object object = this.eventCode;
        int n14 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((Integer)object).hashCode();
        }
        n12 = (n12 ^ n10) * n13;
        long l12 = this.eventUptimeMs;
        long l13 = l12 >>> n11;
        n10 = (int)(l12 ^= l13);
        n12 = (n12 ^ n10) * n13;
        n10 = Arrays.hashCode(this.sourceExtension);
        n12 = (n12 ^ n10) * n13;
        object = this.sourceExtensionJsonProto3;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n12 = (n12 ^ n10) * n13;
        l12 = this.timezoneOffsetSeconds;
        long l14 = l12 >>> n11 ^ l12;
        n11 = (int)l14;
        n12 = (n12 ^ n11) * n13;
        NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
        if (networkConnectionInfo != null) {
            n14 = networkConnectionInfo.hashCode();
        }
        return n12 ^ n14;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogEvent{eventTimeMs=");
        long l10 = this.eventTimeMs;
        stringBuilder.append(l10);
        stringBuilder.append(", eventCode=");
        Object object = this.eventCode;
        stringBuilder.append(object);
        stringBuilder.append(", eventUptimeMs=");
        l10 = this.eventUptimeMs;
        stringBuilder.append(l10);
        stringBuilder.append(", sourceExtension=");
        object = Arrays.toString(this.sourceExtension);
        stringBuilder.append((String)object);
        stringBuilder.append(", sourceExtensionJsonProto3=");
        object = this.sourceExtensionJsonProto3;
        stringBuilder.append((String)object);
        stringBuilder.append(", timezoneOffsetSeconds=");
        l10 = this.timezoneOffsetSeconds;
        stringBuilder.append(l10);
        stringBuilder.append(", networkConnectionInfo=");
        object = this.networkConnectionInfo;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

