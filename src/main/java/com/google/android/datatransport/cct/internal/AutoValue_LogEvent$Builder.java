/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogEvent$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

public final class AutoValue_LogEvent$Builder
extends LogEvent$Builder {
    private Integer eventCode;
    private Long eventTimeMs;
    private Long eventUptimeMs;
    private NetworkConnectionInfo networkConnectionInfo;
    private byte[] sourceExtension;
    private String sourceExtensionJsonProto3;
    private Long timezoneOffsetSeconds;

    public LogEvent build() {
        boolean bl2;
        Object object = this.eventTimeMs;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" eventTimeMs");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.eventUptimeMs) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" eventUptimeMs");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.timezoneOffsetSeconds) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" timezoneOffsetSeconds");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.eventTimeMs;
            Integer n10 = this.eventCode;
            long l11 = this.eventUptimeMs;
            byte[] byArray = this.sourceExtension;
            String string3 = this.sourceExtensionJsonProto3;
            long l12 = this.timezoneOffsetSeconds;
            NetworkConnectionInfo networkConnectionInfo = this.networkConnectionInfo;
            Object object2 = object;
            object = new AutoValue_LogEvent(l10, n10, l11, byArray, string3, l12, networkConnectionInfo, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public LogEvent$Builder setEventCode(Integer n10) {
        this.eventCode = n10;
        return this;
    }

    public LogEvent$Builder setEventTimeMs(long l10) {
        Long l11;
        this.eventTimeMs = l11 = Long.valueOf(l10);
        return this;
    }

    public LogEvent$Builder setEventUptimeMs(long l10) {
        Long l11;
        this.eventUptimeMs = l11 = Long.valueOf(l10);
        return this;
    }

    public LogEvent$Builder setNetworkConnectionInfo(NetworkConnectionInfo networkConnectionInfo) {
        this.networkConnectionInfo = networkConnectionInfo;
        return this;
    }

    public LogEvent$Builder setSourceExtension(byte[] byArray) {
        this.sourceExtension = byArray;
        return this;
    }

    public LogEvent$Builder setSourceExtensionJsonProto3(String string2) {
        this.sourceExtensionJsonProto3 = string2;
        return this;
    }

    public LogEvent$Builder setTimezoneOffsetSeconds(long l10) {
        Long l11;
        this.timezoneOffsetSeconds = l11 = Long.valueOf(l10);
        return this;
    }
}

