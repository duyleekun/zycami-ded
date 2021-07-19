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
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import java.util.Locale;
import org.json.JSONObject;

public class SettingsV3JsonTransform
implements SettingsJsonTransform {
    private static final String CRASHLYTICS_APP_URL = "https://update.crashlytics.com/spi/v1/platforms/android/apps";
    private static final String CRASHLYTICS_APP_URL_FORMAT = "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s";
    private static final String NDK_REPORTS_URL_FORMAT = "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps";
    private static final String REPORTS_URL_FORMAT = "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports";

    private static AppSettingsData buildAppDataFrom(JSONObject object, JSONObject jSONObject) {
        Object object2;
        Object[] objectArray;
        String string2 = jSONObject.getString("status");
        Object object3 = "new";
        boolean bl2 = object3.equals(string2);
        String string3 = object.getString("bundle_id");
        String string4 = object.getString("org_id");
        int n10 = 1;
        if (bl2) {
            object3 = CRASHLYTICS_APP_URL;
        } else {
            object3 = Locale.US;
            objectArray = new Object[n10];
            objectArray[0] = string3;
            object2 = CRASHLYTICS_APP_URL_FORMAT;
            object3 = String.format((Locale)object3, (String)object2, objectArray);
        }
        objectArray = object3;
        object3 = Locale.US;
        object2 = new Object[n10];
        object2[0] = string3;
        object2 = String.format((Locale)object3, REPORTS_URL_FORMAT, object2);
        object = new Object[n10];
        object[0] = string3;
        String string5 = String.format((Locale)object3, NDK_REPORTS_URL_FORMAT, object);
        boolean bl3 = jSONObject.optBoolean("update_required", false);
        int n11 = jSONObject.optInt("report_upload_variant", 0);
        int n12 = jSONObject.optInt("native_report_upload_variant", 0);
        object = new AppSettingsData(string2, (String)objectArray, (String)object2, string5, string3, string4, bl3, n11, n12);
        return object;
    }

    private static FeaturesSettingsData buildFeaturesSessionDataFrom(JSONObject jSONObject) {
        boolean bl2 = jSONObject.optBoolean("collect_reports", true);
        FeaturesSettingsData featuresSettingsData = new FeaturesSettingsData(bl2);
        return featuresSettingsData;
    }

    private static SessionSettingsData defaultSessionData() {
        SessionSettingsData sessionSettingsData = new SessionSettingsData(8, 4);
        return sessionSettingsData;
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
        int n10 = appSettingsData.updateRequired;
        jSONObject = jSONObject.put("update_required", n10 != 0);
        n10 = appSettingsData.reportUploadVariant;
        jSONObject = jSONObject.put("report_upload_variant", n10);
        int n11 = appSettingsData.nativeReportUploadVariant;
        return jSONObject.put("native_report_upload_variant", n11);
    }

    private JSONObject toFabricJson(AppSettingsData object) {
        JSONObject jSONObject = new JSONObject();
        String string2 = ((AppSettingsData)object).bundleId;
        jSONObject = jSONObject.put("bundle_id", (Object)string2);
        object = ((AppSettingsData)object).organizationId;
        return jSONObject.put("org_id", object);
    }

    private JSONObject toFeaturesJson(FeaturesSettingsData featuresSettingsData) {
        JSONObject jSONObject = new JSONObject();
        boolean bl2 = featuresSettingsData.collectReports;
        return jSONObject.put("collect_reports", bl2);
    }

    public SettingsData buildFromJson(CurrentTimeProvider object, JSONObject jSONObject) {
        int n10 = jSONObject.optInt("settings_version", 0);
        int n11 = jSONObject.optInt("cache_duration", 3600);
        JSONObject jSONObject2 = jSONObject.getJSONObject("fabric");
        JSONObject jSONObject3 = jSONObject.getJSONObject("app");
        AppSettingsData appSettingsData = SettingsV3JsonTransform.buildAppDataFrom(jSONObject2, jSONObject3);
        SessionSettingsData sessionSettingsData = SettingsV3JsonTransform.defaultSessionData();
        FeaturesSettingsData featuresSettingsData = SettingsV3JsonTransform.buildFeaturesSessionDataFrom(jSONObject.getJSONObject("features"));
        long l10 = n11;
        long l11 = SettingsV3JsonTransform.getExpiresAtFrom((CurrentTimeProvider)object, l10, jSONObject);
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
        object = ((SettingsData)object).appData;
        object = this.toFabricJson((AppSettingsData)object);
        return jSONObject.put("fabric", object);
    }
}

