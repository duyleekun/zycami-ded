/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_LogRequest$1;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

public final class AutoValue_LogRequest
extends LogRequest {
    private final ClientInfo clientInfo;
    private final List logEvents;
    private final Integer logSource;
    private final String logSourceName;
    private final QosTier qosTier;
    private final long requestTimeMs;
    private final long requestUptimeMs;

    private AutoValue_LogRequest(long l10, long l11, ClientInfo clientInfo, Integer n10, String string2, List list, QosTier qosTier) {
        this.requestTimeMs = l10;
        this.requestUptimeMs = l11;
        this.clientInfo = clientInfo;
        this.logSource = n10;
        this.logSourceName = string2;
        this.logEvents = list;
        this.qosTier = qosTier;
    }

    public /* synthetic */ AutoValue_LogRequest(long l10, long l11, ClientInfo clientInfo, Integer n10, String string2, List list, QosTier qosTier, AutoValue_LogRequest$1 autoValue_LogRequest$1) {
        this(l10, l11, clientInfo, n10, string2, list, qosTier);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        Object object2 = object instanceof LogRequest;
        if (object2) {
            boolean bl3;
            Object object3;
            Object object4;
            long l10;
            long l11 = this.requestTimeMs;
            long l12 = ((LogRequest)(object = (LogRequest)object)).getRequestTimeMs();
            long l13 = l11 - l12;
            object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (!(!object2 && !(object2 = (l10 = (l11 = this.requestUptimeMs) - (l12 = ((LogRequest)object).getRequestUptimeMs())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) && ((object4 = this.clientInfo) == null ? (object4 = ((LogRequest)object).getClientInfo()) == null : (object2 = object4.equals(object3 = ((LogRequest)object).getClientInfo()))) && ((object4 = this.logSource) == null ? (object4 = ((LogRequest)object).getLogSource()) == null : (object2 = ((Integer)object4).equals(object3 = ((LogRequest)object).getLogSource()))) && ((object4 = this.logSourceName) == null ? (object4 = ((LogRequest)object).getLogSourceName()) == null : (object2 = ((String)object4).equals(object3 = ((LogRequest)object).getLogSourceName()))) && ((object4 = this.logEvents) == null ? (object4 = ((LogRequest)object).getLogEvents()) == null : (object2 = object4.equals(object3 = ((LogRequest)object).getLogEvents()))) && ((object4 = this.qosTier) == null ? (object = ((LogRequest)object).getQosTier()) == null : (bl3 = ((Enum)object4).equals(object = ((LogRequest)object).getQosTier()))))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public ClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public List getLogEvents() {
        return this.logEvents;
    }

    public Integer getLogSource() {
        return this.logSource;
    }

    public String getLogSourceName() {
        return this.logSourceName;
    }

    public QosTier getQosTier() {
        return this.qosTier;
    }

    public long getRequestTimeMs() {
        return this.requestTimeMs;
    }

    public long getRequestUptimeMs() {
        return this.requestUptimeMs;
    }

    public int hashCode() {
        long l10 = this.requestTimeMs;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^= l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        l11 = this.requestUptimeMs;
        long l12 = l11 >>> n10;
        long l13 = l12 ^ l11;
        n10 = (int)l13;
        n11 = (n11 ^ n10) * n12;
        Object object = this.clientInfo;
        int n13 = 0;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        object = this.logSource;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((Integer)object).hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        object = this.logSourceName;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = ((String)object).hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        object = this.logEvents;
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            n10 = object.hashCode();
        }
        n11 = (n11 ^ n10) * n12;
        QosTier qosTier = this.qosTier;
        if (qosTier != null) {
            n13 = qosTier.hashCode();
        }
        return n11 ^ n13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LogRequest{requestTimeMs=");
        long l10 = this.requestTimeMs;
        stringBuilder.append(l10);
        stringBuilder.append(", requestUptimeMs=");
        l10 = this.requestUptimeMs;
        stringBuilder.append(l10);
        stringBuilder.append(", clientInfo=");
        Object object = this.clientInfo;
        stringBuilder.append(object);
        stringBuilder.append(", logSource=");
        object = this.logSource;
        stringBuilder.append(object);
        stringBuilder.append(", logSourceName=");
        object = this.logSourceName;
        stringBuilder.append((String)object);
        stringBuilder.append(", logEvents=");
        object = this.logEvents;
        stringBuilder.append(object);
        stringBuilder.append(", qosTier=");
        object = this.qosTier;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

