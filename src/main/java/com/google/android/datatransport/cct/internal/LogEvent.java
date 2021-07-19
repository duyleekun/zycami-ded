/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogEvent$Builder;
import com.google.android.datatransport.cct.internal.LogEvent$Builder;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

public abstract class LogEvent {
    private static LogEvent$Builder builder() {
        AutoValue_LogEvent$Builder autoValue_LogEvent$Builder = new AutoValue_LogEvent$Builder();
        return autoValue_LogEvent$Builder;
    }

    public static LogEvent$Builder jsonBuilder(String string2) {
        return LogEvent.builder().setSourceExtensionJsonProto3(string2);
    }

    public static LogEvent$Builder protoBuilder(byte[] byArray) {
        return LogEvent.builder().setSourceExtension(byArray);
    }

    public abstract Integer getEventCode();

    public abstract long getEventTimeMs();

    public abstract long getEventUptimeMs();

    public abstract NetworkConnectionInfo getNetworkConnectionInfo();

    public abstract byte[] getSourceExtension();

    public abstract String getSourceExtensionJsonProto3();

    public abstract long getTimezoneOffsetSeconds();
}

