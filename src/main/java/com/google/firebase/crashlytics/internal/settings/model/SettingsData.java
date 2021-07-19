/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;

public class SettingsData
implements Settings {
    public final AppSettingsData appData;
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeaturesSettingsData featuresData;
    public final SessionSettingsData sessionData;
    public final int settingsVersion;

    public SettingsData(long l10, AppSettingsData appSettingsData, SessionSettingsData sessionSettingsData, FeaturesSettingsData featuresSettingsData, int n10, int n11) {
        this.expiresAtMillis = l10;
        this.appData = appSettingsData;
        this.sessionData = sessionSettingsData;
        this.featuresData = featuresSettingsData;
        this.settingsVersion = n10;
        this.cacheDuration = n11;
    }

    public AppSettingsData getAppSettingsData() {
        return this.appData;
    }

    public int getCacheDuration() {
        return this.cacheDuration;
    }

    public long getExpiresAtMillis() {
        return this.expiresAtMillis;
    }

    public FeaturesSettingsData getFeaturesData() {
        return this.featuresData;
    }

    public SessionSettingsData getSessionData() {
        return this.sessionData;
    }

    public int getSettingsVersion() {
        return this.settingsVersion;
    }

    public boolean isExpired(long l10) {
        long l11 = this.expiresAtMillis;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

