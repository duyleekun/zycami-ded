/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import java.util.concurrent.Callable;

public class CrashlyticsCore$1
implements Callable {
    public final /* synthetic */ CrashlyticsCore this$0;
    public final /* synthetic */ SettingsDataProvider val$settingsProvider;

    public CrashlyticsCore$1(CrashlyticsCore crashlyticsCore, SettingsDataProvider settingsDataProvider) {
        this.this$0 = crashlyticsCore;
        this.val$settingsProvider = settingsDataProvider;
    }

    public Task call() {
        CrashlyticsCore crashlyticsCore = this.this$0;
        SettingsDataProvider settingsDataProvider = this.val$settingsProvider;
        return CrashlyticsCore.access$000(crashlyticsCore, settingsDataProvider);
    }
}

