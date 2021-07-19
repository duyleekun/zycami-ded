/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings;

import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.settings.model.Settings;

public interface SettingsDataProvider {
    public Task getAppSettings();

    public Settings getSettings();
}

