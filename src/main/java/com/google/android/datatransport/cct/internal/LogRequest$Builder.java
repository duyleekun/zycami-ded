/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.QosTier;
import java.util.List;

public abstract class LogRequest$Builder {
    public abstract LogRequest build();

    public abstract LogRequest$Builder setClientInfo(ClientInfo var1);

    public abstract LogRequest$Builder setLogEvents(List var1);

    public abstract LogRequest$Builder setLogSource(Integer var1);

    public abstract LogRequest$Builder setLogSourceName(String var1);

    public abstract LogRequest$Builder setQosTier(QosTier var1);

    public abstract LogRequest$Builder setRequestTimeMs(long var1);

    public abstract LogRequest$Builder setRequestUptimeMs(long var1);

    public LogRequest$Builder setSource(int n10) {
        Integer n11 = n10;
        return this.setLogSource(n11);
    }

    public LogRequest$Builder setSource(String string2) {
        return this.setLogSourceName(string2);
    }
}

