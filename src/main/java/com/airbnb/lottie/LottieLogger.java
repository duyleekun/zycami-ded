/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

public interface LottieLogger {
    public void debug(String var1);

    public void debug(String var1, Throwable var2);

    public void error(String var1, Throwable var2);

    public void warning(String var1);

    public void warning(String var1, Throwable var2);
}

