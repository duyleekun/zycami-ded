/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.apache.http.conn.ssl.SSLSocketFactory
 */
package com.huawei.updatesdk.b.d;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.updatesdk.a.b.a.a;
import d.j.f.a.a.j.g;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class d {
    private static volatile d a;

    public static d a() {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            d d10 = a;
            if (d10 == null) {
                a = d10 = new d();
            }
            d10 = a;
            return d10;
        }
    }

    public static String b() {
        String string2 = com.huawei.updatesdk.a.b.a.a.c().b();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "";
        if (bl2) {
            return string3;
        }
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        ((StringBuilder)comparable).append(string2);
        ((StringBuilder)comparable).append("/updatesdk");
        string2 = ((StringBuilder)comparable).toString();
        comparable = new Comparable<StringBuilder>(string2);
        boolean bl3 = ((File)comparable).exists();
        if (!bl3 && !(bl2 = ((File)comparable).mkdirs())) {
            return string3;
        }
        return string2;
    }

    public HttpURLConnection a(String object) {
        Object object2 = new URL((String)object);
        object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object2).openConnection()));
        ((URLConnection)object).setConnectTimeout(7000);
        ((URLConnection)object).setReadTimeout(10000);
        object2 = null;
        ((URLConnection)object).setUseCaches(false);
        boolean bl2 = true;
        ((URLConnection)object).setDoInput(bl2);
        Object object3 = "Accept-Encoding";
        String string2 = "identity";
        ((URLConnection)object).setRequestProperty((String)object3, string2);
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl2);
        bl2 = object instanceof HttpsURLConnection;
        if (bl2) {
            object2 = object;
            object2 = (HttpsURLConnection)object;
            object3 = g.f(com.huawei.updatesdk.a.b.a.a.c().a());
            ((HttpsURLConnection)object2).setSSLSocketFactory((SSLSocketFactory)object3);
            object3 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            ((HttpsURLConnection)object2).setHostnameVerifier((HostnameVerifier)object3);
        }
        return (HttpURLConnection)object;
    }
}

