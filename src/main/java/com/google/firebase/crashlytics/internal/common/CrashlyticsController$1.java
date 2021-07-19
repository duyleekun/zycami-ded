/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler$CrashListener;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;

public class CrashlyticsController$1
implements CrashlyticsUncaughtExceptionHandler$CrashListener {
    public final /* synthetic */ CrashlyticsController this$0;

    public CrashlyticsController$1(CrashlyticsController crashlyticsController) {
        this.this$0 = crashlyticsController;
    }

    public void onUncaughtException(SettingsDataProvider settingsDataProvider, Thread thread, Throwable throwable) {
        this.this$0.handleUncaughtException(settingsDataProvider, thread, throwable);
    }
}

