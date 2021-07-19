/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;

public interface CrashlyticsUncaughtExceptionHandler$CrashListener {
    public void onUncaughtException(SettingsDataProvider var1, Thread var2, Throwable var3);
}

