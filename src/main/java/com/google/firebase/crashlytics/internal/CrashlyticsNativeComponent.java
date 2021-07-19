/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;

public interface CrashlyticsNativeComponent {
    public boolean finalizeSession(String var1);

    public NativeSessionFileProvider getSessionFileProvider(String var1);

    public boolean hasCrashDataForSession(String var1);

    public boolean openSession(String var1);

    public void writeBeginSession(String var1, String var2, long var3);

    public void writeSessionApp(String var1, String var2, String var3, String var4, String var5, int var6, String var7);

    public void writeSessionDevice(String var1, int var2, String var3, int var4, long var5, long var7, boolean var9, int var10, String var11, String var12);

    public void writeSessionOs(String var1, String var2, String var3, boolean var4);
}

