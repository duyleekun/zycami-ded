/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.DefaultSettingsJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsV3JsonTransform;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    public SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.currentTimeProvider = currentTimeProvider;
    }

    private static SettingsJsonTransform getJsonTransformForVersion(int n10) {
        int n11 = 3;
        if (n10 != n11) {
            DefaultSettingsJsonTransform defaultSettingsJsonTransform = new DefaultSettingsJsonTransform();
            return defaultSettingsJsonTransform;
        }
        SettingsV3JsonTransform settingsV3JsonTransform = new SettingsV3JsonTransform();
        return settingsV3JsonTransform;
    }

    public SettingsData parseSettingsJson(JSONObject jSONObject) {
        SettingsJsonTransform settingsJsonTransform = SettingsJsonParser.getJsonTransformForVersion(jSONObject.getInt("settings_version"));
        CurrentTimeProvider currentTimeProvider = this.currentTimeProvider;
        return settingsJsonTransform.buildFromJson(currentTimeProvider, jSONObject);
    }
}

