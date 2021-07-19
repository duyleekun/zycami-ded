/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.TransportScheduleCallback;

public interface Transport {
    public void schedule(Event var1, TransportScheduleCallback var2);

    public void send(Event var1);
}

