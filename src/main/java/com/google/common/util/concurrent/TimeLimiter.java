/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public interface TimeLimiter {
    public Object callUninterruptiblyWithTimeout(Callable var1, long var2, TimeUnit var4);

    public Object callWithTimeout(Callable var1, long var2, TimeUnit var4);

    public Object newProxy(Object var1, Class var2, long var3, TimeUnit var5);

    public void runUninterruptiblyWithTimeout(Runnable var1, long var2, TimeUnit var4);

    public void runWithTimeout(Runnable var1, long var2, TimeUnit var4);
}

