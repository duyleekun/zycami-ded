/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.util;

public interface Clock {
    public long currentThreadTimeMillis();

    public long currentTimeMillis();

    public long elapsedRealtime();

    public long nanoTime();
}

