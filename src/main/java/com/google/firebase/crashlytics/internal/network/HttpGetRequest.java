/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.network;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.network.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

public class HttpGetRequest {
    private static final int DEFAULT_TIMEOUT_MS = 10000;
    private static final String METHOD_GET = "GET";
    private static final int READ_BUFFER_SIZE = 8192;
    private final Map headers;
    private final Map queryParams;
    private final String url;

    public HttpGetRequest(String hashMap, Map map) {
        this.url = hashMap;
        this.queryParams = map;
        this.headers = hashMap = new HashMap();
    }

    private String createParamsString(Map object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.entrySet().iterator();
        Object object2 = (Map.Entry)object.next();
        StringBuilder stringBuilder2 = new StringBuilder();
        String string2 = (String)object2.getKey();
        stringBuilder2.append(string2);
        string2 = "=";
        stringBuilder2.append(string2);
        Object object3 = object2.getValue();
        String string3 = "";
        object2 = object3 != null ? (String)object2.getValue() : string3;
        stringBuilder2.append((String)object2);
        object2 = stringBuilder2.toString();
        stringBuilder.append((String)object2);
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("&");
            object3 = (String)object2.getKey();
            stringBuilder2.append((String)object3);
            stringBuilder2.append(string2);
            object3 = object2.getValue();
            object2 = object3 != null ? (String)object2.getValue() : string3;
            stringBuilder2.append((String)object2);
            object2 = stringBuilder2.toString();
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    private String createUrlWithParams(String string2, Map object) {
        boolean bl2 = ((String)(object = this.createParamsString((Map)object))).isEmpty();
        if (bl2) {
            return string2;
        }
        CharSequence charSequence = "?";
        boolean bl3 = string2.contains(charSequence);
        if (bl3) {
            charSequence = "&";
            bl3 = string2.endsWith((String)charSequence);
            if (!bl3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append((String)charSequence);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    private String readStream(InputStream object) {
        int n10;
        int n11;
        String string2 = "UTF-8";
        Object object2 = new InputStreamReader((InputStream)object, string2);
        BufferedReader bufferedReader = new BufferedReader((Reader)object2);
        int n12 = 8192;
        object = new char[n12];
        object2 = new StringBuilder();
        while ((n11 = bufferedReader.read((char[])object)) != (n10 = -1)) {
            n10 = 0;
            ((StringBuilder)object2).append((char[])object, 0, n11);
        }
        return ((StringBuilder)object2).toString();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public HttpResponse execute() {
        void var3_7;
        Object object;
        Object object2;
        block9: {
            int n10;
            Object object3;
            block10: {
                String string2;
                Object object4;
                object2 = null;
                try {
                    object = this.url;
                    object4 = this.queryParams;
                    object = this.createUrlWithParams((String)object, (Map)object4);
                    object4 = Logger.getLogger();
                    object3 = new StringBuilder();
                    string2 = "GET Request URL: ";
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append((String)object);
                    object3 = ((StringBuilder)object3).toString();
                    ((Logger)object4).v((String)object3);
                    object4 = new URL((String)object);
                    object = ((URL)object4).openConnection();
                    object = (HttpsURLConnection)object;
                    n10 = 10000;
                }
                catch (Throwable throwable) {
                    object = null;
                    break block9;
                }
                try {
                    boolean bl2;
                    ((URLConnection)object).setReadTimeout(n10);
                    ((URLConnection)object).setConnectTimeout(n10);
                    object4 = METHOD_GET;
                    ((HttpURLConnection)object).setRequestMethod((String)object4);
                    object4 = this.headers;
                    object4 = object4.entrySet();
                    object4 = object4.iterator();
                    while (bl2 = object4.hasNext()) {
                        object3 = object4.next();
                        object3 = (Map.Entry)object3;
                        string2 = object3.getKey();
                        object3 = object3.getValue();
                        object3 = (String)object3;
                        ((URLConnection)object).addRequestProperty(string2, (String)object3);
                    }
                    ((URLConnection)object).connect();
                    n10 = ((HttpURLConnection)object).getResponseCode();
                    object3 = ((URLConnection)object).getInputStream();
                    if (object3 == null) break block10;
                }
                catch (Throwable throwable) {
                    break block9;
                }
                try {
                    object2 = this.readStream((InputStream)object3);
                }
                catch (Throwable throwable) {
                    object2 = object3;
                    break block9;
                }
            }
            if (object3 != null) {
                ((InputStream)object3).close();
            }
            if (object == null) return new HttpResponse(n10, (String)object2);
            ((HttpURLConnection)object).disconnect();
            return new HttpResponse(n10, (String)object2);
        }
        if (object2 != null) {
            ((InputStream)object2).close();
        }
        if (object == null) throw var3_7;
        ((HttpURLConnection)object).disconnect();
        throw var3_7;
    }

    public HttpGetRequest header(String string2, String string3) {
        this.headers.put(string2, string3);
        return this;
    }

    public HttpGetRequest header(Map.Entry object) {
        String string2 = (String)object.getKey();
        object = (String)object.getValue();
        return this.header(string2, (String)object);
    }
}

