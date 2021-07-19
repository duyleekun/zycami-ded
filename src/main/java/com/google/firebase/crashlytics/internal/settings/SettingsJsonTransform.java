/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

public interface SettingsJsonTransform {
    public SettingsData buildFromJson(CurrentTimeProvider var1, JSONObject var2);

    public JSONObject toJson(SettingsData var1);
}

