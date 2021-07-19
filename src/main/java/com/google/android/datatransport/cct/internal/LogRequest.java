/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogRequest$Builder;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogRequest$Builder;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

public abstract class LogRequest {
    public static LogRequest$Builder builder() {
        AutoValue_LogRequest$Builder autoValue_LogRequest$Builder = new AutoValue_LogRequest$Builder();
        return autoValue_LogRequest$Builder;
    }

    public abstract ClientInfo getClientInfo();

    public abstract List getLogEvents();

    public abstract Integer getLogSource();

    public abstract String getLogSourceName();

    public abstract QosTier getQosTier();

    public abstract long getRequestTimeMs();

    public abstract long getRequestUptimeMs();
}

