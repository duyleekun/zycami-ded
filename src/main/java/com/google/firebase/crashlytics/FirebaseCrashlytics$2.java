/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.concurrent.Callable;

public class FirebaseCrashlytics$2
implements Callable {
    public final /* synthetic */ CrashlyticsCore val$core;
    public final /* synthetic */ boolean val$finishCoreInBackground;
    public final /* synthetic */ SettingsController val$settingsController;

    public FirebaseCrashlytics$2(boolean bl2, CrashlyticsCore crashlyticsCore, SettingsController settingsController) {
        this.val$finishCoreInBackground = bl2;
        this.val$core = crashlyticsCore;
        this.val$settingsController = settingsController;
    }

    public Void call() {
        boolean bl2 = this.val$finishCoreInBackground;
        if (bl2) {
            CrashlyticsCore crashlyticsCore = this.val$core;
            SettingsController settingsController = this.val$settingsController;
            crashlyticsCore.doBackgroundInitializationAsync(settingsController);
        }
        return null;
    }
}

