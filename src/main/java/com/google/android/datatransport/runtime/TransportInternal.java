/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime;

import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.SendRequest;

public interface TransportInternal {
    public void send(SendRequest var1, TransportScheduleCallback var2);
}

