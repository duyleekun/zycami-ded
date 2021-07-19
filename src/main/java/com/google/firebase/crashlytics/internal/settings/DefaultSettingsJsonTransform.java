/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.FeaturesSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.SessionSettingsData;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONObject;

public class DefaultSettingsJsonTransform
implements SettingsJsonTransform {
    private static AppSettingsData buildAppDataFrom(JSONObject object) {
        String string2 = object.getString("status");
        String string3 = object.getString("url");
        String string4 = object.getString("reports_url");
        String string5 = object.getString("ndk_reports_url");
        boolean bl2 = object.optBoolean("update_required", false);
        object = new AppSettingsData(string2, string3, string4, string5, bl2);
        return object;
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        boolean bl2 = jSONObject.optBoolean("collect_reports", true);
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(bl2);
        return featuresSettingsData;
    }

    private static SessionSettingsData buildSessionDataFrom(JSONObject jSONObject) {
        int n10 = jSONObject.optInt("max_custom_exception_events", 8);
        SessionSettingsData sessionSettingsData = new SessionSettingsData(n10, 4);
        return sessionSettingsData;
    }

    public static Settings defaultSettings(CurrentTimeProvider object) {
        JSONObject jSONObject = new JSONObject();
        SessionSettingsData sessionSettingsData = DefaultSettingsJsonTransform.buildSessionDataFrom(jSONObject);
        FeaturesSettingsData featuresSettingsData = DefaultSettingsJsonTransform.buildFeaturesSessionDataFrom(jSONObject);
        long l10 = DefaultSettingsJsonTransform.getExpiresAtFrom((CurrentTimeProvider)object, 3600L, jSONObject);
        object = new SettingsData(l10, null, sessionSettingsData, featuresSettingsData, 0, 3600);
        return object;
    }

    private static long getExpiresAtFrom(CurrentTimeProvider currentTimeProvider, long l10, JSONObject jSONObject) {
        long l11;
        String string2 = "expires_at";
        boolean bl2 = jSONObject.has(string2);
        if (bl2) {
            l11 = jSONObject.optLong(string2);
        } else {
            long l12 = currentTimeProvider.getCurrentTimeMillis();
            long l13 = 1000L;
            l11 = l12 + (l10 *= l13);
        }
        return l11;
    }

    private JSONObject toAppJson(AppSettingsData appSettingsData) {
        JSONObject jSONObject = new JSONObject();
        String string2 = appSettingsData.status;
        jSONObject = jSONObject.put("status", (Object)string2);
        string2 = appSettingsData.url;
        jSONObject = jSONObject.put("url", (Object)string2);
        string2 = appSettingsData.reportsUrl;
        jSONObject = jSONObject.put("reports_url", (Object)string2);
        string2 = appSettingsData.ndkReportsUrl;
        jSONObject = jSONObject.put("ndk_reports_url", (Object)string2);
        boolean bl2 = appSettingsData.updateRequired;
        return jSONObject.put("update_required", bl2);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        JSONObject jSONObject = new JSONObject();
        boolean bl2 = featuresSettingsData.collectReports;
        return jSONObject.put("collect_reports", bl2);
    }

    private JSONObject toSessionJson(SessionSettingsData sessionSettingsData) {
        JSONObject jSONObject = new JSONObject();
        int n10 = sessionSettingsData.maxCustomExceptionEvents;
        jSONObject = jSONObject.put("max_custom_exception_events", n10);
        int n11 = sessionSettingsData.maxCompleteSessionsCount;
        return jSONObject.put("max_complete_sessions_count", n11);
    }

    public SettingsData buildFromJson(CurrentTimeProvider object, JSONObject jSONObject) {
        int n10 = jSONObject.optInt("settings_version", 0);
        int n11 = jSONObject.optInt("cache_duration", 3600);
        AppSettingsData appSettingsData = DefaultSettingsJsonTransform.buildAppDataFrom(jSONObject.getJSONObject("app"));
        SessionSettingsData sessionSettingsData = DefaultSettingsJsonTransform.buildSessionDataFrom(jSONObject.getJSONObject("session"));
        FeaturesSettingsData featuresSettingsData = DefaultSettingsJsonTransform.buildFeaturesSessionDataFrom(jSONObject.getJSONObject("features"));
        long l10 = n11;
        long l11 = DefaultSettingsJsonTransform.getExpiresAtFrom((CurrentTimeProvider)object, l10, jSONObject);
        object = new SettingsData(l11, appSettingsData, sessionSettingsData, featuresSettingsData, n10, n11);
        return object;
    }

    public JSONObject toJson(SettingsData object) {
        JSONObject jSONObject = new JSONObject();
        long l10 = ((SettingsData)object).expiresAtMillis;
        jSONObject = jSONObject.put("expires_at", l10);
        int n10 = ((SettingsData)object).cacheDuration;
        jSONObject = jSONObject.put("cache_duration", n10);
        n10 = ((SettingsData)object).settingsVersion;
        jSONObject = jSONObject.put("settings_version", n10);
        Object object2 = ((SettingsData)object).featuresData;
        object2 = this.toFeaturesJson((FeaturesSettingsData)object2);
        jSONObject = jSONObject.put("features", object2);
        object2 = ((SettingsData)object).appData;
        object2 = this.toAppJson((AppSettingsData)object2);
        jSONObject = jSONObject.put("app", object2);
        object = ((SettingsData)object).sessionData;
        object = this.toSessionJson((SessionSettingsData)object);
        return jSONObject.put("session", object);
    }
}

