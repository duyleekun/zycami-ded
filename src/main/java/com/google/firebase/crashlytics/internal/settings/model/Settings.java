/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.settings.model;

import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;

public interface Settings {
    public int getCacheDuration();

    public long getExpiresAtMillis();

    public FeaturesSettingsData getFeaturesData();

    public SessionSettingsData getSessionData();

    public int getSettingsVersion();

    public boolean isExpired(long var1);
}

