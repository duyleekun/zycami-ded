/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogRequest$Builder;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

public final class AutoValue_LogRequest$Builder
extends LogRequest$Builder {
    private ClientInfo clientInfo;
    private List logEvents;
    private Integer logSource;
    private String logSourceName;
    private QosTier qosTier;
    private Long requestTimeMs;
    private Long requestUptimeMs;

    public LogRequest build() {
        boolean bl2;
        Object object = this.requestTimeMs;
        String string2 = "";
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" requestTimeMs");
            string2 = ((StringBuilder)object).toString();
        }
        if ((object = this.requestUptimeMs) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" requestUptimeMs");
            string2 = ((StringBuilder)object).toString();
        }
        if (bl2 = string2.isEmpty()) {
            long l10 = this.requestTimeMs;
            long l11 = this.requestUptimeMs;
            ClientInfo clientInfo = this.clientInfo;
            Integer n10 = this.logSource;
            String string3 = this.logSourceName;
            List list = this.logEvents;
            QosTier qosTier = this.qosTier;
            Object object2 = object;
            object = new AutoValue_LogRequest(l10, l11, clientInfo, n10, string3, list, qosTier, null);
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Missing required properties:");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public LogRequest$Builder setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        return this;
    }

    public LogRequest$Builder setLogEvents(List list) {
        this.logEvents = list;
        return this;
    }

    public LogRequest$Builder setLogSource(Integer n10) {
        this.logSource = n10;
        return this;
    }

    public LogRequest$Builder setLogSourceName(String string2) {
        this.logSourceName = string2;
        return this;
    }

    public LogRequest$Builder setQosTier(QosTier qosTier) {
        this.qosTier = qosTier;
        return this;
    }

    public LogRequest$Builder setRequestTimeMs(long l10) {
        Long l11;
        this.requestTimeMs = l11 = Long.valueOf(l10);
        return this;
    }

    public LogRequest$Builder setRequestUptimeMs(long l10) {
        Long l11;
        this.requestUptimeMs = l11 = Long.valueOf(l10);
        return this;
    }
}

