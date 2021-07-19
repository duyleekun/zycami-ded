/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.StackSize;
import java.util.concurrent.TimeUnit;

public interface LoggingApi {
    public LoggingApi atMostEvery(int var1, TimeUnit var2);

    public LoggingApi every(int var1);

    public boolean isEnabled();

    public void log();

    public void log(String var1);

    public void log(String var1, byte var2);

    public void log(String var1, byte var2, byte var3);

    public void log(String var1, byte var2, char var3);

    public void log(String var1, byte var2, double var3);

    public void log(String var1, byte var2, float var3);

    public void log(String var1, byte var2, int var3);

    public void log(String var1, byte var2, long var3);

    public void log(String var1, byte var2, Object var3);

    public void log(String var1, byte var2, short var3);

    public void log(String var1, byte var2, boolean var3);

    public void log(String var1, char var2);

    public void log(String var1, char var2, byte var3);

    public void log(String var1, char var2, char var3);

    public void log(String var1, char var2, double var3);

    public void log(String var1, char var2, float var3);

    public void log(String var1, char var2, int var3);

    public void log(String var1, char var2, long var3);

    public void log(String var1, char var2, Object var3);

    public void log(String var1, char var2, short var3);

    public void log(String var1, char var2, boolean var3);

    public void log(String var1, double var2, byte var4);

    public void log(String var1, double var2, char var4);

    public void log(String var1, double var2, double var4);

    public void log(String var1, double var2, float var4);

    public void log(String var1, double var2, int var4);

    public void log(String var1, double var2, long var4);

    public void log(String var1, double var2, Object var4);

    public void log(String var1, double var2, short var4);

    public void log(String var1, double var2, boolean var4);

    public void log(String var1, float var2, byte var3);

    public void log(String var1, float var2, char var3);

    public void log(String var1, float var2, double var3);

    public void log(String var1, float var2, float var3);

    public void log(String var1, float var2, int var3);

    public void log(String var1, float var2, long var3);

    public void log(String var1, float var2, Object var3);

    public void log(String var1, float var2, short var3);

    public void log(String var1, float var2, boolean var3);

    public void log(String var1, int var2);

    public void log(String var1, int var2, byte var3);

    public void log(String var1, int var2, char var3);

    public void log(String var1, int var2, double var3);

    public void log(String var1, int var2, float var3);

    public void log(String var1, int var2, int var3);

    public void log(String var1, int var2, long var3);

    public void log(String var1, int var2, Object var3);

    public void log(String var1, int var2, short var3);

    public void log(String var1, int var2, boolean var3);

    public void log(String var1, long var2);

    public void log(String var1, long var2, byte var4);

    public void log(String var1, long var2, char var4);

    public void log(String var1, long var2, double var4);

    public void log(String var1, long var2, float var4);

    public void log(String var1, long var2, int var4);

    public void log(String var1, long var2, long var4);

    public void log(String var1, long var2, Object var4);

    public void log(String var1, long var2, short var4);

    public void log(String var1, long var2, boolean var4);

    public void log(String var1, Object var2);

    public void log(String var1, Object var2, byte var3);

    public void log(String var1, Object var2, char var3);

    public void log(String var1, Object var2, double var3);

    public void log(String var1, Object var2, float var3);

    public void log(String var1, Object var2, int var3);

    public void log(String var1, Object var2, long var3);

    public void log(String var1, Object var2, Object var3);

    public void log(String var1, Object var2, Object var3, Object var4);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11);

    public void log(String var1, Object var2, Object var3, Object var4, Object var5, Object var6, Object var7, Object var8, Object var9, Object var10, Object var11, Object ... var12);

    public void log(String var1, Object var2, short var3);

    public void log(String var1, Object var2, boolean var3);

    public void log(String var1, short var2);

    public void log(String var1, short var2, byte var3);

    public void log(String var1, short var2, char var3);

    public void log(String var1, short var2, double var3);

    public void log(String var1, short var2, float var3);

    public void log(String var1, short var2, int var3);

    public void log(String var1, short var2, long var3);

    public void log(String var1, short var2, Object var3);

    public void log(String var1, short var2, short var3);

    public void log(String var1, short var2, boolean var3);

    public void log(String var1, boolean var2, byte var3);

    public void log(String var1, boolean var2, char var3);

    public void log(String var1, boolean var2, double var3);

    public void log(String var1, boolean var2, float var3);

    public void log(String var1, boolean var2, int var3);

    public void log(String var1, boolean var2, long var3);

    public void log(String var1, boolean var2, Object var3);

    public void log(String var1, boolean var2, short var3);

    public void log(String var1, boolean var2, boolean var3);

    public void logVarargs(String var1, Object[] var2);

    public LoggingApi withCause(Throwable var1);

    public LoggingApi withInjectedLogSite(LogSite var1);

    public LoggingApi withInjectedLogSite(String var1, String var2, int var3, String var4);

    public LoggingApi withStackTrace(StackSize var1);
}

