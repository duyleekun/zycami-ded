/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.settings.network;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.network.HttpGetRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import com.google.firebase.crashlytics.internal.settings.model.SettingsRequest;
import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class DefaultSettingsSpiCall
implements SettingsSpiCall {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String BUILD_VERSION_PARAM = "build_version";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final String DISPLAY_VERSION_PARAM = "display_version";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVICE_MODEL = "X-CRASHLYTICS-DEVICE-MODEL";
    public static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
    public static final String HEADER_INSTALLATION_ID = "X-CRASHLYTICS-INSTALLATION-ID";
    public static final String HEADER_OS_BUILD_VERSION = "X-CRASHLYTICS-OS-BUILD-VERSION";
    public static final String HEADER_OS_DISPLAY_VERSION = "X-CRASHLYTICS-OS-DISPLAY-VERSION";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final String INSTANCE_PARAM = "instance";
    public static final String SOURCE_PARAM = "source";
    private final Logger logger;
    private final HttpRequestFactory requestFactory;
    private final String url;

    public DefaultSettingsSpiCall(String string2, HttpRequestFactory httpRequestFactory) {
        Logger logger = Logger.getLogger();
        this(string2, httpRequestFactory, logger);
    }

    public DefaultSettingsSpiCall(String object, HttpRequestFactory httpRequestFactory, Logger logger) {
        if (object != null) {
            this.logger = logger;
            this.requestFactory = httpRequestFactory;
            this.url = object;
            return;
        }
        object = new IllegalArgumentException("url must not be null.");
        throw object;
    }

    private HttpGetRequest applyHeadersTo(HttpGetRequest httpGetRequest, SettingsRequest object) {
        String string2 = ((SettingsRequest)object).googleAppId;
        this.applyNonNullHeader(httpGetRequest, HEADER_GOOGLE_APP_ID, string2);
        this.applyNonNullHeader(httpGetRequest, HEADER_CLIENT_TYPE, ANDROID_CLIENT_TYPE);
        string2 = CrashlyticsCore.getVersion();
        this.applyNonNullHeader(httpGetRequest, HEADER_CLIENT_VERSION, string2);
        this.applyNonNullHeader(httpGetRequest, HEADER_ACCEPT, ACCEPT_JSON_VALUE);
        string2 = ((SettingsRequest)object).deviceModel;
        this.applyNonNullHeader(httpGetRequest, HEADER_DEVICE_MODEL, string2);
        string2 = ((SettingsRequest)object).osBuildVersion;
        this.applyNonNullHeader(httpGetRequest, HEADER_OS_BUILD_VERSION, string2);
        string2 = ((SettingsRequest)object).osDisplayVersion;
        this.applyNonNullHeader(httpGetRequest, HEADER_OS_DISPLAY_VERSION, string2);
        object = ((SettingsRequest)object).installIdProvider.getCrashlyticsInstallId();
        this.applyNonNullHeader(httpGetRequest, HEADER_INSTALLATION_ID, (String)object);
        return httpGetRequest;
    }

    private void applyNonNullHeader(HttpGetRequest httpGetRequest, String string2, String string3) {
        if (string3 != null) {
            httpGetRequest.header(string2, string3);
        }
    }

    private JSONObject getJsonObjectFrom(String string2) {
        try {
            JSONObject jSONObject = new JSONObject(string2);
            return jSONObject;
        }
        catch (Exception exception) {
            Object object = this.logger;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Failed to parse settings JSON from ");
            String string3 = this.url;
            charSequence.append(string3);
            charSequence = charSequence.toString();
            ((Logger)object).w((String)charSequence, exception);
            Logger logger = this.logger;
            object = new StringBuilder();
            ((StringBuilder)object).append("Settings response ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            logger.w(string2);
            return null;
        }
    }

    private Map getQueryParamsFor(SettingsRequest object) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        String string2 = ((SettingsRequest)object).buildVersion;
        hashMap.put(BUILD_VERSION_PARAM, string2);
        string2 = ((SettingsRequest)object).displayVersion;
        hashMap.put(DISPLAY_VERSION_PARAM, string2);
        string2 = Integer.toString(((SettingsRequest)object).source);
        String string3 = SOURCE_PARAM;
        hashMap.put(string3, string2);
        object = ((SettingsRequest)object).instanceId;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            string2 = INSTANCE_PARAM;
            hashMap.put(string2, object);
        }
        return hashMap;
    }

    public HttpGetRequest createHttpGetRequest(Map object) {
        Object object2 = this.requestFactory;
        String string2 = this.url;
        object = ((HttpRequestFactory)object2).buildHttpGetRequest(string2, (Map)object);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(CRASHLYTICS_USER_AGENT);
        string2 = CrashlyticsCore.getVersion();
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        return ((HttpGetRequest)object).header(HEADER_USER_AGENT, (String)object2).header("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }

    public JSONObject handleResponse(HttpResponse object) {
        int n10 = ((HttpResponse)object).code();
        Object object2 = this.logger;
        CharSequence charSequence = new StringBuilder();
        String string2 = "Settings response code was: ";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        ((Logger)object2).v((String)charSequence);
        boolean bl2 = this.requestWasSuccessful(n10);
        if (bl2) {
            object = ((HttpResponse)object).body();
            object = this.getJsonObjectFrom((String)object);
        } else {
            object = this.logger;
            object2 = new StringBuilder();
            charSequence = "Settings request failed; (status: ";
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append(n10);
            ((StringBuilder)object2).append(") from ");
            String string3 = this.url;
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            ((Logger)object).e(string3);
            object = null;
        }
        return object;
    }

    public JSONObject invoke(SettingsRequest object, boolean bl2) {
        if (bl2) {
            Object object2 = this.getQueryParamsFor((SettingsRequest)object);
            Object object3 = this.createHttpGetRequest((Map)object2);
            object = this.applyHeadersTo((HttpGetRequest)object3, (SettingsRequest)object);
            object3 = this.logger;
            CharSequence charSequence = new StringBuilder();
            String string2 = "Requesting settings from ";
            ((StringBuilder)charSequence).append(string2);
            string2 = this.url;
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            ((Logger)object3).d((String)charSequence);
            object3 = this.logger;
            charSequence = new StringBuilder();
            string2 = "Settings query params were: ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object2);
            object2 = ((StringBuilder)charSequence).toString();
            ((Logger)object3).v((String)object2);
            object = ((HttpGetRequest)object).execute();
            try {
                object = this.handleResponse((HttpResponse)object);
            }
            catch (IOException iOException) {
                object2 = this.logger;
                object3 = "Settings request failed.";
                ((Logger)object2).e((String)object3, iOException);
                object = null;
            }
            return object;
        }
        object = new RuntimeException("An invalid data collection token was used.");
        throw object;
    }

    public boolean requestWasSuccessful(int n10) {
        int n11 = 200;
        n10 = n10 != n11 && n10 != (n11 = 201) && n10 != (n11 = 202) && n10 != (n11 = 203) ? 0 : 1;
        return n10 != 0;
    }
}

