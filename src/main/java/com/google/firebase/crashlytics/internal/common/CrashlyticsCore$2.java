/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;

public class CrashlyticsCore$2
implements Runnable {
    public final /* synthetic */ CrashlyticsCore this$0;
    public final /* synthetic */ SettingsDataProvider val$settingsDataProvider;

    public CrashlyticsCore$2(CrashlyticsCore crashlyticsCore, SettingsDataProvider settingsDataProvider) {
        this.this$0 = crashlyticsCore;
        this.val$settingsDataProvider = settingsDataProvider;
    }

    public void run() {
        CrashlyticsCore crashlyticsCore = this.this$0;
        SettingsDataProvider settingsDataProvider = this.val$settingsDataProvider;
        CrashlyticsCore.access$000(crashlyticsCore, settingsDataProvider);
    }
}

