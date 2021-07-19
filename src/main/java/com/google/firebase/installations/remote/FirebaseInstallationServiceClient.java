/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 *  android.util.JsonReader
 *  android.util.Log
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException$Status;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.InstallationResponse$Builder;
import com.google.firebase.installations.remote.InstallationResponse$ResponseCode;
import com.google.firebase.installations.remote.RequestLimiter;
import com.google.firebase.installations.remote.TokenResult;
import com.google.firebase.installations.remote.TokenResult$Builder;
import com.google.firebase.installations.remote.TokenResult$ResponseCode;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseInstallationServiceClient {
    private static final String ACCEPT_HEADER_KEY = "Accept";
    private static final String API_KEY_HEADER = "x-goog-api-key";
    private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
    private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
    private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
    private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
    private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
    private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
    private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
    private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
    private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
    private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
    private static final String FIS_TAG = "Firebase-Installations";
    private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
    private static final String GZIP_CONTENT_ENCODING = "gzip";
    private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final int MAX_RETRIES = 1;
    private static final int NETWORK_TIMEOUT_MILLIS = 10000;
    public static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
    private static final String SDK_VERSION_PREFIX = "a:";
    private static final String USER_AGENT_HEADER = "x-firebase-client";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
    private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
    private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
    private final Context context;
    private final Provider heartbeatInfo;
    private final RequestLimiter requestLimiter;
    private boolean shouldServerErrorRetry;
    private final Provider userAgentPublisher;

    public FirebaseInstallationServiceClient(Context object, Provider provider, Provider provider2) {
        this.context = object;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.requestLimiter = object;
    }

    private static String availableFirebaseOptions(String string2, String charSequence, String string3) {
        int n10 = 3;
        Object[] objectArray = new Object[n10];
        objectArray[0] = charSequence;
        objectArray[1] = string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = "";
        } else {
            charSequence = new StringBuilder();
            string3 = ", ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
        }
        objectArray[2] = string2;
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", objectArray);
    }

    private static JSONObject buildCreateFirebaseInstallationRequestBody(String string2, String object) {
        String string3;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            string3 = "fid";
        }
        catch (JSONException jSONException) {
            object = new IllegalStateException(jSONException);
            throw object;
        }
        jSONObject.put(string3, (Object)string2);
        string2 = "appId";
        jSONObject.put(string2, object);
        string2 = "authVersion";
        object = FIREBASE_INSTALLATION_AUTH_VERSION;
        jSONObject.put(string2, object);
        string2 = "sdkVersion";
        object = "a:16.3.5";
        jSONObject.put(string2, object);
        return jSONObject;
    }

    private static JSONObject buildGenerateAuthTokenRequestBody() {
        String string2;
        Object object;
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            object = "sdkVersion";
            string2 = "a:16.3.5";
        }
        catch (JSONException jSONException) {
            object = new IllegalStateException(jSONException);
            throw object;
        }
        jSONObject.put((String)object, (Object)string2);
        object = new JSONObject();
        string2 = "installation";
        object.put(string2, (Object)jSONObject);
        return object;
    }

    private String getFingerprintHashForPackage() {
        CharSequence charSequence;
        Object object;
        block11: {
            String string2 = "ContentValues";
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

    private URL getFullyQualifiedRequestUri(String string2) {
        Serializable serializable;
        String string3;
        int n10;
        Object[] objectArray;
        Object object = "https://%s/%s/%s";
        int n11 = 3;
        try {
            objectArray = new Object[n11];
            n10 = 0;
            string3 = FIREBASE_INSTALLATIONS_API_DOMAIN;
        }
        catch (MalformedURLException malformedURLException) {
            String string4 = malformedURLException.getMessage();
            object = FirebaseInstallationsException$Status.UNAVAILABLE;
            serializable = new FirebaseInstallationsException(string4, (FirebaseInstallationsException$Status)((Object)object));
            throw serializable;
        }
        objectArray[0] = string3;
        n10 = 1;
        string3 = FIREBASE_INSTALLATIONS_API_VERSION;
        objectArray[n10] = string3;
        n10 = 2;
        objectArray[n10] = string2;
        string2 = String.format(object, objectArray);
        serializable = new URL(string2);
        return serializable;
    }

    private static byte[] getJsonBytes(JSONObject jSONObject) {
        return jSONObject.toString().getBytes("UTF-8");
    }

    private static boolean isSuccessfulResponseCode(int n10) {
        int n11 = 200;
        n10 = n10 >= n11 && n10 < (n11 = 300) ? 1 : 0;
        return n10 != 0;
    }

    private static void logBadConfigError() {
        Log.e((String)FIS_TAG, (String)"Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    private static void logFisCommunicationError(HttpURLConnection object, String string2, String string3, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = FirebaseInstallationServiceClient.readErrorResponse((HttpURLConnection)object)));
        if (!bl2) {
            String string5 = FIS_TAG;
            Log.w((String)string5, (String)object);
            object = FirebaseInstallationServiceClient.availableFirebaseOptions(string2, string3, string4);
            Log.w((String)string5, (String)object);
        }
    }

    private HttpURLConnection openHttpURLConnection(URL object, String object2) {
        try {
            object = ((URL)object).openConnection();
        }
        catch (IOException iOException) {
            object2 = FirebaseInstallationsException$Status.UNAVAILABLE;
            object = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", (FirebaseInstallationsException$Status)((Object)object2));
            throw object;
        }
        object = (HttpURLConnection)object;
        int n10 = 10000;
        ((URLConnection)object).setConnectTimeout(n10);
        ((URLConnection)object).setUseCaches(false);
        ((URLConnection)object).setReadTimeout(n10);
        Object object3 = JSON_CONTENT_TYPE;
        ((URLConnection)object).addRequestProperty(CONTENT_TYPE_HEADER_KEY, (String)object3);
        ((URLConnection)object).addRequestProperty(ACCEPT_HEADER_KEY, (String)object3);
        ((URLConnection)object).addRequestProperty(CONTENT_ENCODING_HEADER_KEY, GZIP_CONTENT_ENCODING);
        ((URLConnection)object).addRequestProperty(CACHE_CONTROL_HEADER_KEY, CACHE_CONTROL_DIRECTIVE);
        Object object4 = this.context.getPackageName();
        object3 = X_ANDROID_PACKAGE_HEADER_KEY;
        ((URLConnection)object).addRequestProperty((String)object3, (String)object4);
        object4 = this.heartbeatInfo.get();
        if (object4 != null && (object4 = this.userAgentPublisher.get()) != null && (object4 = ((HeartBeatInfo)this.heartbeatInfo.get()).getHeartBeatCode(FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG)) != (object3 = HeartBeatInfo$HeartBeat.NONE)) {
            object3 = ((UserAgentPublisher)this.userAgentPublisher.get()).getUserAgent();
            String string2 = USER_AGENT_HEADER;
            ((URLConnection)object).addRequestProperty(string2, (String)object3);
            n10 = ((HeartBeatInfo$HeartBeat)((Object)object4)).getCode();
            object4 = Integer.toString(n10);
            object3 = HEART_BEAT_HEADER;
            ((URLConnection)object).addRequestProperty((String)object3, (String)object4);
        }
        object4 = this.getFingerprintHashForPackage();
        ((URLConnection)object).addRequestProperty(X_ANDROID_CERT_HEADER_KEY, (String)object4);
        ((URLConnection)object).addRequestProperty(API_KEY_HEADER, (String)object2);
        return object;
    }

    public static long parseTokenExpirationTimestamp(String string2) {
        long l10;
        Matcher matcher = EXPIRATION_TIMESTAMP_PATTERN.matcher(string2);
        int n10 = matcher.matches();
        String string3 = PARSING_EXPIRATION_TIME_ERROR_MESSAGE;
        Preconditions.checkArgument(n10 != 0, string3);
        if (string2 != null && (n10 = string2.length()) != 0) {
            n10 = 0;
            matcher = null;
            int n11 = string2.length() + -1;
            string2 = string2.substring(0, n11);
            l10 = Long.parseLong(string2);
        } else {
            l10 = 0L;
        }
        return l10;
    }

    private InstallationResponse readCreateResponse(HttpURLConnection object) {
        boolean bl2;
        object = ((URLConnection)object).getInputStream();
        Object object2 = UTF_8;
        Object object3 = new InputStreamReader((InputStream)object, (Charset)object2);
        JsonReader jsonReader = new JsonReader((Reader)object3);
        object3 = TokenResult.builder();
        object2 = InstallationResponse.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            String string2;
            Object object4 = jsonReader.nextName();
            boolean bl3 = ((String)object4).equals(string2 = "name");
            if (bl3) {
                object4 = jsonReader.nextString();
                ((InstallationResponse$Builder)object2).setUri((String)object4);
                continue;
            }
            string2 = "fid";
            bl3 = ((String)object4).equals(string2);
            if (bl3) {
                object4 = jsonReader.nextString();
                ((InstallationResponse$Builder)object2).setFid((String)object4);
                continue;
            }
            string2 = "refreshToken";
            bl3 = ((String)object4).equals(string2);
            if (bl3) {
                object4 = jsonReader.nextString();
                ((InstallationResponse$Builder)object2).setRefreshToken((String)object4);
                continue;
            }
            string2 = "authToken";
            bl2 = ((String)object4).equals(string2);
            if (bl2) {
                jsonReader.beginObject();
                while (bl2 = jsonReader.hasNext()) {
                    object4 = jsonReader.nextName();
                    bl3 = ((String)object4).equals(string2 = "token");
                    if (bl3) {
                        object4 = jsonReader.nextString();
                        ((TokenResult$Builder)object3).setToken((String)object4);
                        continue;
                    }
                    string2 = "expiresIn";
                    bl2 = ((String)object4).equals(string2);
                    if (bl2) {
                        object4 = jsonReader.nextString();
                        long l10 = FirebaseInstallationServiceClient.parseTokenExpirationTimestamp((String)object4);
                        ((TokenResult$Builder)object3).setTokenExpirationTimestamp(l10);
                        continue;
                    }
                    jsonReader.skipValue();
                }
                object4 = ((TokenResult$Builder)object3).build();
                ((InstallationResponse$Builder)object2).setAuthToken((TokenResult)object4);
                jsonReader.endObject();
                continue;
            }
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        jsonReader.close();
        ((InputStream)object).close();
        object = InstallationResponse$ResponseCode.OK;
        return ((InstallationResponse$Builder)object2).setResponseCode((InstallationResponse$ResponseCode)((Object)object)).build();
    }

    /*
     * Unable to fully structure code
     */
    private static String readErrorResponse(HttpURLConnection var0) {
        var1_2 = var0.getErrorStream();
        if (var1_2 == null) {
            return null;
        }
        var4_5 = FirebaseInstallationServiceClient.UTF_8;
        var3_4 = new InputStreamReader((InputStream)var1_2, (Charset)var4_5);
        var2_3 = new BufferedReader((Reader)var3_4);
        var1_2 = new StringBuilder();
        ** while ((var3_4 = var2_3.readLine()) != null)
lbl-1000:
        // 1 sources

        {
            var1_2.append((String)var3_4);
            var5_6 = '\n';
            var1_2.append(var5_6);
            continue;
        }
lbl18:
        // 1 sources

        var3_4 = "Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]";
        var6_7 = 3;
        var4_5 = new Object[var6_7];
        var7_8 = 0;
        var8_9 = var0.getResponseCode();
        var9_10 = var8_9;
        var4_5[0] = var9_10;
        var7_8 = 1;
        var0 = var0.getResponseMessage();
        var4_5[var7_8] = var0;
        var10_11 = 2;
        var4_5[var10_11] = var1_2;
        var0 = String.format((String)var3_4, var4_5);
        var2_3.close();
lbl41:
        // 2 sources

        return var0;
        catch (Throwable var0_1) {
            var2_3.close();
lbl46:
            // 2 sources

            throw var0_1;
        }
        catch (IOException v0) {
            var2_3.close();
lbl51:
            // 2 sources

            return null;
        }
        catch (IOException v1) {
            ** continue;
        }
        {
            catch (IOException v2) {
                ** continue;
            }
        }
        {
            catch (IOException v3) {
                ** continue;
            }
        }
    }

    private TokenResult readGenerateAuthTokenResponse(HttpURLConnection object) {
        boolean bl2;
        object = ((URLConnection)object).getInputStream();
        Object object2 = UTF_8;
        Object object3 = new InputStreamReader((InputStream)object, (Charset)object2);
        JsonReader jsonReader = new JsonReader((Reader)object3);
        object3 = TokenResult.builder();
        jsonReader.beginObject();
        while (bl2 = jsonReader.hasNext()) {
            String string2;
            object2 = jsonReader.nextName();
            boolean bl3 = ((String)object2).equals(string2 = "token");
            if (bl3) {
                object2 = jsonReader.nextString();
                ((TokenResult$Builder)object3).setToken((String)object2);
                continue;
            }
            string2 = "expiresIn";
            bl2 = ((String)object2).equals(string2);
            if (bl2) {
                object2 = jsonReader.nextString();
                long l10 = FirebaseInstallationServiceClient.parseTokenExpirationTimestamp((String)object2);
                ((TokenResult$Builder)object3).setTokenExpirationTimestamp(l10);
                continue;
            }
            jsonReader.skipValue();
        }
        jsonReader.endObject();
        jsonReader.close();
        ((InputStream)object).close();
        object = TokenResult$ResponseCode.OK;
        return ((TokenResult$Builder)object3).setResponseCode((TokenResult$ResponseCode)((Object)object)).build();
    }

    private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection httpURLConnection, String object, String string2) {
        object = FirebaseInstallationServiceClient.getJsonBytes(FirebaseInstallationServiceClient.buildCreateFirebaseInstallationRequestBody((String)object, string2));
        FirebaseInstallationServiceClient.writeRequestBodyToOutputStream(httpURLConnection, (byte[])object);
    }

    private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection httpURLConnection) {
        byte[] byArray = FirebaseInstallationServiceClient.getJsonBytes(FirebaseInstallationServiceClient.buildGenerateAuthTokenRequestBody());
        FirebaseInstallationServiceClient.writeRequestBodyToOutputStream(httpURLConnection, byArray);
    }

    private static void writeRequestBodyToOutputStream(URLConnection object, byte[] byArray) {
        GZIPOutputStream gZIPOutputStream;
        if ((object = ((URLConnection)object).getOutputStream()) != null) {
            gZIPOutputStream = new GZIPOutputStream((OutputStream)object);
            gZIPOutputStream.write(byArray);
            return;
        }
        object = new IOException("Cannot send request to FIS servers. No OutputStream available.");
        throw object;
        finally {
            gZIPOutputStream.close();
            ((OutputStream)object).close();
        }
    }

    public InstallationResponse createFirebaseInstallation(String object, String object2, String string2, String string3, String string4) {
        RequestLimiter requestLimiter = this.requestLimiter;
        boolean n10 = requestLimiter.isRequestAllowed();
        String string5 = "Firebase Installations Service is unavailable. Please try again later.";
        if (n10) {
            int n11 = 1;
            Object object3 = new Object[n11];
            object3[0] = string2;
            Object object4 = CREATE_REQUEST_RESOURCE_NAME_FORMAT;
            object3 = String.format((String)object4, object3);
            object3 = this.getFullyQualifiedRequestUri((String)object3);
            for (int i10 = 0; i10 <= n11; ++i10) {
                block22: {
                    Object object5;
                    Object object6;
                    block21: {
                        int n12;
                        int n13;
                        block20: {
                            block19: {
                                object4 = this.openHttpURLConnection((URL)object3, (String)object);
                                object6 = "POST";
                                ((HttpURLConnection)object4).setRequestMethod((String)object6);
                                ((URLConnection)object4).setDoOutput(n11 != 0);
                                if (string4 == null) break block19;
                                object6 = X_ANDROID_IID_MIGRATION_KEY;
                                ((URLConnection)object4).addRequestProperty((String)object6, string4);
                            }
                            this.writeFIDCreateRequestBodyToOutputStream((HttpURLConnection)object4, (String)object2, string3);
                            n13 = ((HttpURLConnection)object4).getResponseCode();
                            object5 = this.requestLimiter;
                            ((RequestLimiter)object5).setNextRequestTime(n13);
                            n12 = FirebaseInstallationServiceClient.isSuccessfulResponseCode(n13);
                            if (n12 == 0) break block20;
                            object = this.readCreateResponse((HttpURLConnection)object4);
                            ((HttpURLConnection)object4).disconnect();
                            return object;
                        }
                        FirebaseInstallationServiceClient.logFisCommunicationError((HttpURLConnection)object4, string3, (String)object, string2);
                        n12 = 429;
                        if (n13 == n12) break block21;
                        n12 = 500;
                        if (n13 >= n12 && n13 < (n12 = 600)) break block22;
                        FirebaseInstallationServiceClient.logBadConfigError();
                        object6 = InstallationResponse.builder();
                        object5 = InstallationResponse$ResponseCode.BAD_CONFIG;
                        object6 = ((InstallationResponse$Builder)object6).setResponseCode((InstallationResponse$ResponseCode)((Object)object5));
                        object = ((InstallationResponse$Builder)object6).build();
                        ((HttpURLConnection)object4).disconnect();
                        return object;
                    }
                    object5 = "Firebase servers have received too many requests from this client in a short period of time. Please try again later.";
                    FirebaseInstallationsException$Status firebaseInstallationsException$Status = FirebaseInstallationsException$Status.TOO_MANY_REQUESTS;
                    try {
                        object6 = new FirebaseInstallationsException((String)object5, firebaseInstallationsException$Status);
                        throw object6;
                    }
                    catch (Throwable throwable) {
                        ((HttpURLConnection)object4).disconnect();
                        throw throwable;
                    }
                    catch (IOException | AssertionError object7) {}
                }
                ((HttpURLConnection)object4).disconnect();
            }
            object2 = FirebaseInstallationsException$Status.UNAVAILABLE;
            object = new FirebaseInstallationsException(string5, (FirebaseInstallationsException$Status)((Object)object2));
            throw object;
        }
        object2 = FirebaseInstallationsException$Status.UNAVAILABLE;
        object = new FirebaseInstallationsException(string5, (FirebaseInstallationsException$Status)((Object)object2));
        throw object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void deleteFirebaseInstallation(String object, String object2, String string2, String string3) {
        void var3_7;
        int n10 = 2;
        Object object3 = new Object[n10];
        int n11 = 0;
        object3[0] = var3_7;
        int n12 = 1;
        object3[n12] = object2;
        String string4 = String.format(DELETE_REQUEST_RESOURCE_NAME_FORMAT, (Object[])object3);
        URL uRL = this.getFullyQualifiedRequestUri(string4);
        while (true) {
            block7: {
                if (n11 > n12) {
                    FirebaseInstallationsException$Status firebaseInstallationsException$Status = FirebaseInstallationsException$Status.UNAVAILABLE;
                    object = new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", firebaseInstallationsException$Status);
                    throw object;
                }
                object3 = this.openHttpURLConnection(uRL, (String)object);
                Object object4 = "DELETE";
                try {
                    void var4_8;
                    ((HttpURLConnection)object3).setRequestMethod((String)object4);
                    object4 = "Authorization";
                    StringBuilder stringBuilder = new StringBuilder();
                    String string5 = "FIS_v2 ";
                    stringBuilder.append(string5);
                    stringBuilder.append((String)var4_8);
                    String string6 = stringBuilder.toString();
                    ((URLConnection)object3).addRequestProperty((String)object4, string6);
                    int n13 = ((HttpURLConnection)object3).getResponseCode();
                    int n14 = 200;
                    if (n13 != n14 && n13 != (n14 = 401) && n13 != (n14 = 404)) {
                        n14 = 0;
                        Object var10_14 = null;
                        FirebaseInstallationServiceClient.logFisCommunicationError((HttpURLConnection)object3, null, (String)object, (String)var3_7);
                        n14 = 429;
                        if (n13 != n14 && (n13 < (n14 = 500) || n13 >= (n14 = 600))) {
                            FirebaseInstallationServiceClient.logBadConfigError();
                            String string7 = "Bad config while trying to delete FID";
                            FirebaseInstallationsException$Status firebaseInstallationsException$Status = FirebaseInstallationsException$Status.BAD_CONFIG;
                            object4 = new FirebaseInstallationsException(string7, firebaseInstallationsException$Status);
                            throw object4;
                        }
                        break block7;
                    }
                    ((HttpURLConnection)object3).disconnect();
                    return;
                }
                catch (Throwable throwable) {
                    ((HttpURLConnection)object3).disconnect();
                    throw throwable;
                }
                catch (IOException iOException) {}
            }
            ++n11;
            ((HttpURLConnection)object3).disconnect();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public TokenResult generateAuthToken(String var1_1, String var2_3, String var3_4, String var4_5) {
        block28: {
            var5_6 = this.requestLimiter;
            var6_7 = var5_6.isRequestAllowed();
            var7_8 = "Firebase Installations Service is unavailable. Please try again later.";
            if (var6_7 == 0) break block28;
            var6_7 = 2;
            var5_6 = new Object[var6_7];
            var5_6[0] = var3_4;
            var9_10 = true;
            var5_6[var9_10] = var2_3 /* !! */ ;
            var2_3 /* !! */  = String.format("projects/%s/installations/%s/authTokens:generate", (Object[])var5_6);
            var2_3 /* !! */  = this.getFullyQualifiedRequestUri(var2_3 /* !! */ );
            for (var8_9 = false; var8_9 <= var9_10; var8_9 += 1) {
                block27: {
                    block26: {
                        block25: {
                            var5_6 = this.openHttpURLConnection((URL)var2_3 /* !! */ , (String)var1_1);
                            var10_11 = "POST";
                            var5_6.setRequestMethod((String)var10_11);
                            var10_11 = "Authorization";
                            var11_12 /* !! */  = new StringBuilder();
                            var12_13 /* !! */  = "FIS_v2 ";
                            var11_12 /* !! */ .append(var12_13 /* !! */ );
                            var11_12 /* !! */ .append(var4_5);
                            var11_12 /* !! */  = var11_12 /* !! */ .toString();
                            var5_6.addRequestProperty((String)var10_11, (String)var11_12 /* !! */ );
                            var5_6.setDoOutput(var9_10);
                            this.writeGenerateAuthTokenRequestBodyToOutputStream((HttpURLConnection)var5_6);
                            var13_14 = var5_6.getResponseCode();
                            var11_12 /* !! */  = this.requestLimiter;
                            var11_12 /* !! */ .setNextRequestTime(var13_14);
                            var14_15 = FirebaseInstallationServiceClient.isSuccessfulResponseCode(var13_14);
                            if (var14_15 == 0) break block25;
                            var1_1 = this.readGenerateAuthTokenResponse((HttpURLConnection)var5_6);
                            var5_6.disconnect();
                            return var1_1;
                        }
                        var14_15 = 0;
                        var11_12 /* !! */  = null;
                        FirebaseInstallationServiceClient.logFisCommunicationError((HttpURLConnection)var5_6, null, (String)var1_1, var3_4);
                        var14_15 = 401;
                        if (var13_14 == var14_15 || var13_14 == (var14_15 = 404)) ** GOTO lbl74
                        var14_15 = 429;
                        if (var13_14 == var14_15) break block26;
                        var14_15 = 500;
                        if (var13_14 >= var14_15 && var13_14 < (var14_15 = 600)) break block27;
                        FirebaseInstallationServiceClient.logBadConfigError();
                        var10_11 = TokenResult.builder();
                        var11_12 /* !! */  = TokenResult$ResponseCode.BAD_CONFIG;
                        var10_11 = var10_11.setResponseCode((TokenResult$ResponseCode)var11_12 /* !! */ );
                        var1_1 = var10_11.build();
                        var5_6.disconnect();
                        return var1_1;
                    }
                    var11_12 /* !! */  = "Firebase servers have received too many requests from this client in a short period of time. Please try again later.";
                    var12_13 /* !! */  = FirebaseInstallationsException$Status.TOO_MANY_REQUESTS;
                    var10_11 = new FirebaseInstallationsException((String)var11_12 /* !! */ , (FirebaseInstallationsException$Status)var12_13 /* !! */ );
                    throw var10_11;
lbl74:
                    // 1 sources

                    var10_11 = TokenResult.builder();
                    var11_12 /* !! */  = TokenResult$ResponseCode.AUTH_ERROR;
                    var10_11 = var10_11.setResponseCode((TokenResult$ResponseCode)var11_12 /* !! */ );
                    try {
                        var1_1 = var10_11.build();
                        var5_6.disconnect();
                        return var1_1;
                    }
                    catch (Throwable var1_2) {
                        var5_6.disconnect();
                        throw var1_2;
                    }
                    catch (IOException | AssertionError v0) {}
                }
                var5_6.disconnect();
            }
            var2_3 /* !! */  = FirebaseInstallationsException$Status.UNAVAILABLE;
            var1_1 = new FirebaseInstallationsException(var7_8, (FirebaseInstallationsException$Status)var2_3 /* !! */ );
            throw var1_1;
        }
        var2_3 /* !! */  = FirebaseInstallationsException$Status.UNAVAILABLE;
        var1_1 = new FirebaseInstallationsException(var7_8, (FirebaseInstallationsException$Status)var2_3 /* !! */ );
        throw var1_1;
    }
}

