/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.scheduler;

import com.google.android.exoplayer2.scheduler.Requirements;

public interface Scheduler {
    public boolean cancel();

    public Requirements getSupportedRequirements(Requirements var1);

    public boolean schedule(Requirements var1, String var2, String var3);
}

