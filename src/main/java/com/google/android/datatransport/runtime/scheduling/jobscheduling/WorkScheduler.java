/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;

public interface WorkScheduler {
    public void schedule(TransportContext var1, int var2);

    public void schedule(TransportContext var1, int var2, boolean var3);
}

