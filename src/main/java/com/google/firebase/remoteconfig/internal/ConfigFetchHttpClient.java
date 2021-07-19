/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.util.Log
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigContainer$Builder;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler$FetchResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConfigFetchHttpClient {
    private static final String API_KEY_HEADER = "X-Goog-Api-Key";
    private static final String ETAG_HEADER = "ETag";
    private static final Pattern GMP_APP_ID_PATTERN = Pattern.compile("^[^:]+:([0-9]+):(android|ios|web):([0-9a-f]+)");
    private static final String IF_NONE_MATCH_HEADER = "If-None-Match";
    private static final String INSTALLATIONS_AUTH_TOKEN_HEADER = "X-Goog-Firebase-Installations-Auth";
    private static final String X_ANDROID_CERT_HEADER = "X-Android-Cert";
    private static final String X_ANDROID_PACKAGE_HEADER = "X-Android-Package";
    private static final String X_GOOGLE_GFE_CAN_RETRY = "X-Google-GFE-Can-Retry";
    private final String apiKey;
    private final String appId;
    private final long connectTimeoutInSeconds;
    private final Context context;
    private final String namespace;
    private final String projectNumber;
    private final long readTimeoutInSeconds;

    public ConfigFetchHttpClient(Context object, String string2, String string3, String string4, long l10, long l11) {
        this.context = object;
        this.appId = string2;
        this.apiKey = string3;
        object = ConfigFetchHttpClient.extractProjectNumberFromAppId(string2);
        this.projectNumber = object;
        this.namespace = string4;
        this.connectTimeoutInSeconds = l10;
        this.readTimeoutInSeconds = l11;
    }

    private boolean backendHasUpdates(JSONObject object) {
        boolean bl2 = true;
        String string2 = "state";
        try {
            object = object.get(string2);
            string2 = "NO_CHANGE";
        }
        catch (JSONException jSONException) {
            return bl2;
        }
        return object.equals(string2) ^ bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject createFetchRequestBody(String object, String string2, Map map) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        if (object == null) {
            object = new FirebaseRemoteConfigClientException("Fetch failed: Firebase installation id is null.");
            throw object;
        }
        hashMap.put("appInstanceId", object);
        hashMap.put("appInstanceIdToken", string2);
        object = this.appId;
        hashMap.put("appId", object);
        object = this.context.getResources().getConfiguration().locale;
        string2 = ((Locale)object).getCountry();
        String string3 = "countryCode";
        hashMap.put(string3, string2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        object = n10 >= n11 ? ((Locale)object).toLanguageTag() : ((Locale)object).toString();
        string3 = "languageCode";
        hashMap.put(string3, object);
        object = Integer.toString(n10);
        hashMap.put("platformVersion", object);
        object = TimeZone.getDefault().getID();
        string2 = "timeZone";
        hashMap.put(string2, object);
        try {
            object = this.context;
            object = object.getPackageManager();
            string2 = this.context;
            string2 = string2.getPackageName();
            n11 = 0;
            string3 = null;
            object = object.getPackageInfo(string2, 0);
            if (object != null) {
                string2 = "appVersion";
                object = ((PackageInfo)object).versionName;
                hashMap.put(string2, object);
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        object = this.context.getPackageName();
        hashMap.put("packageName", object);
        hashMap.put("sdkVersion", "20.0.2");
        object = new JSONObject(map);
        hashMap.put("analyticsUserProperties", object);
        return new JSONObject(hashMap);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static ConfigContainer extractConfigs(JSONObject jSONObject, Date object) {
        String string2;
        ConfigContainer$Builder configContainer$Builder;
        try {
            configContainer$Builder = ConfigContainer.newBuilder();
            object = configContainer$Builder.withFetchTime((Date)object);
            configContainer$Builder = null;
            string2 = "entries";
        }
        catch (JSONException jSONException) {
            object = new FirebaseRemoteConfigClientException("Fetch failed: fetch response could not be parsed.", jSONException);
            throw object;
        }
        try {
            string2 = jSONObject.getJSONObject(string2);
        }
        catch (JSONException jSONException) {
            string2 = null;
        }
        if (string2 != null) {
            ((ConfigContainer$Builder)object).replaceConfigsWith((JSONObject)string2);
        }
        string2 = "experimentDescriptions";
        try {
            string2 = jSONObject.getJSONArray(string2);
        }
        catch (JSONException jSONException) {
            string2 = null;
        }
        if (string2 != null) {
            ((ConfigContainer$Builder)object).withAbtExperiments((JSONArray)string2);
        }
        string2 = "personalizationMetadata";
        try {
            configContainer$Builder = jSONObject.getJSONObject(string2);
        }
        catch (JSONException jSONException) {}
        if (configContainer$Builder == null) return ((ConfigContainer$Builder)object).build();
        ((ConfigContainer$Builder)object).withPersonalizationMetadata((JSONObject)configContainer$Builder);
        return ((ConfigContainer$Builder)object).build();
    }

    private static String extractProjectNumberFromAppId(String object) {
        Pattern pattern = GMP_APP_ID_PATTERN;
        int n10 = (int)(((Matcher)(object = pattern.matcher((CharSequence)object))).matches() ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
            object = ((Matcher)object).group(n10);
        } else {
            object = null;
        }
        return object;
    }

    private JSONObject getFetchResponseBody(URLConnection object) {
        char c10;
        char c11;
        object = ((URLConnection)object).getInputStream();
        String string2 = "utf-8";
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object, string2);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        object = new StringBuilder();
        while ((c11 = bufferedReader.read()) != (c10 = '\uffffffff')) {
            c11 = c11;
            ((StringBuilder)object).append(c11);
        }
        object = ((StringBuilder)object).toString();
        bufferedReader = new JSONObject((String)object);
        return bufferedReader;
    }

    private String getFetchUrl(String string2, String string3) {
        Object[] objectArray = new Object[]{string2, string3};
        return String.format("https://firebaseremoteconfig.googleapis.com/v1/projects/%s/namespaces/%s:fetch", objectArray);
    }

    private String getFingerprintHashForPackage() {
        CharSequence charSequence;
        Object object;
        block11: {
            String string2 = "FirebaseRemoteConfig";
            try {
                object = this.context;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("No such package: ");
                String string3 = this.context.getPackageName();
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)string2, (String)charSequence, (Throwable)nameNotFoundException);
                return null;
            }
            charSequence = object.getPackageName();
            object = AndroidUtilsLight.getPackageCertificateHashBytes((Context)object, (String)charSequence);
            if (object != null) break block11;
            object = new StringBuilder();
            charSequence = "Could not get fingerprint hash for package: ";
            ((StringBuilder)object).append((String)charSequence);
            charSequence = this.context;
            charSequence = charSequence.getPackageName();
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            Log.e((String)string2, (String)object);
            return null;
        }
        charSequence = null;
        return Hex.bytesToStringUppercase((byte[])object, false);
    }

    private void setCommonRequestHeaders(HttpURLConnection httpURLConnection, String string2) {
        String string3 = this.apiKey;
        httpURLConnection.setRequestProperty(API_KEY_HEADER, string3);
        string3 = this.context.getPackageName();
        httpURLConnection.setRequestProperty(X_ANDROID_PACKAGE_HEADER, string3);
        string3 = this.getFingerprintHashForPackage();
        httpURLConnection.setRequestProperty(X_ANDROID_CERT_HEADER, string3);
        httpURLConnection.setRequestProperty(X_GOOGLE_GFE_CAN_RETRY, "yes");
        httpURLConnection.setRequestProperty(INSTALLATIONS_AUTH_TOKEN_HEADER, string2);
        string3 = "application/json";
        httpURLConnection.setRequestProperty("Content-Type", string3);
        httpURLConnection.setRequestProperty("Accept", string3);
    }

    private void setCustomRequestHeaders(HttpURLConnection httpURLConnection, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (String)object2.getValue();
            httpURLConnection.setRequestProperty(string2, (String)object2);
        }
    }

    private void setFetchRequestBody(HttpURLConnection object, byte[] byArray) {
        int n10 = byArray.length;
        ((HttpURLConnection)object).setFixedLengthStreamingMode(n10);
        object = ((URLConnection)object).getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream((OutputStream)object);
        ((OutputStream)bufferedOutputStream).write(byArray);
        ((OutputStream)bufferedOutputStream).flush();
        ((OutputStream)bufferedOutputStream).close();
    }

    private void setUpUrlConnection(HttpURLConnection httpURLConnection, String string2, String string3, Map map) {
        httpURLConnection.setDoOutput(true);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long l10 = this.connectTimeoutInSeconds;
        int n10 = (int)timeUnit.toMillis(l10);
        httpURLConnection.setConnectTimeout(n10);
        l10 = this.readTimeoutInSeconds;
        int n11 = (int)timeUnit.toMillis(l10);
        httpURLConnection.setReadTimeout(n11);
        httpURLConnection.setRequestProperty(IF_NONE_MATCH_HEADER, string2);
        this.setCommonRequestHeaders(httpURLConnection, string3);
        this.setCustomRequestHeaders(httpURLConnection, map);
    }

    public HttpURLConnection createHttpURLConnection() {
        Object object;
        try {
            object = this.projectNumber;
        }
        catch (IOException iOException) {
            String string2 = iOException.getMessage();
            object = new FirebaseRemoteConfigException(string2);
            throw object;
        }
        String string3 = this.namespace;
        object = this.getFetchUrl((String)object, string3);
        Object object2 = new URL((String)object);
        object2 = ((URL)object2).openConnection();
        return (HttpURLConnection)object2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ConfigFetchHandler$FetchResponse fetch(HttpURLConnection object, String object2, String object3, Map object4, String string2, Map map, Date date) {
        boolean bl2;
        block11: {
            Throwable throwable222;
            block12: {
                void var2_6;
                block13: {
                    int n10;
                    block10: {
                        this.setUpUrlConnection((HttpURLConnection)object, string2, (String)object3, map);
                        object2 = this.createFetchRequestBody((String)object2, (String)object3, (Map)object4);
                        object2 = object2.toString();
                        object3 = "utf-8";
                        object2 = ((String)object2).getBytes((String)object3);
                        this.setFetchRequestBody((HttpURLConnection)object, (byte[])object2);
                        ((URLConnection)object).connect();
                        n10 = ((HttpURLConnection)object).getResponseCode();
                        int n11 = 200;
                        if (n10 != n11) break block10;
                        object2 = ETAG_HEADER;
                        object2 = ((URLConnection)object).getHeaderField((String)object2);
                        object3 = this.getFetchResponseBody((URLConnection)object);
                        ((HttpURLConnection)object).disconnect();
                        try {
                            object = ((URLConnection)object).getInputStream();
                            ((InputStream)object).close();
                            break block11;
                        }
                        catch (IOException iOException) {}
                    }
                    try {
                        object4 = ((HttpURLConnection)object).getResponseMessage();
                        object3 = new FirebaseRemoteConfigServerException(n10, (String)object4);
                        throw object3;
                    }
                    catch (Throwable throwable222) {
                        break block12;
                    }
                    catch (JSONException jSONException) {
                        break block13;
                    }
                    catch (IOException iOException) {
                        // empty catch block
                    }
                }
                object4 = "The client had an error while calling the backend!";
                object3 = new FirebaseRemoteConfigClientException((String)object4, (Throwable)var2_6);
                throw object3;
            }
            ((HttpURLConnection)object).disconnect();
            try {
                object = ((URLConnection)object).getInputStream();
                ((InputStream)object).close();
            }
            catch (IOException iOException) {
                throw throwable222;
            }
            throw throwable222;
        }
        if (bl2 = this.backendHasUpdates((JSONObject)object3)) return ConfigFetchHandler$FetchResponse.forBackendUpdatesFetched(ConfigFetchHttpClient.extractConfigs((JSONObject)object3, date), (String)object2);
        return ConfigFetchHandler$FetchResponse.forBackendHasNoUpdates(date);
    }

    public long getConnectTimeoutInSeconds() {
        return this.connectTimeoutInSeconds;
    }

    public long getReadTimeoutInSeconds() {
        return this.readTimeoutInSeconds;
    }
}

