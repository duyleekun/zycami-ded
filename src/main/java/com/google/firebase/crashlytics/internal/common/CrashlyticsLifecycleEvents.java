/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

public interface CrashlyticsLifecycleEvents {
    public void onBeginSession(String var1, long var2);

    public void onCustomKey(String var1, String var2);

    public void onLog(long var1, String var3);

    public void onUserId(String var1);
}

