/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.d.a;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.framework.common.Logger;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class a {
    public static HttpsURLConnection a(String object, Context object2, String charSequence) {
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            return null;
        }
        Object object3 = new URL((String)object);
        object = (URLConnection)FirebasePerfUrlConnection.instrument(((URL)object3).openConnection());
        n10 = object instanceof HttpsURLConnection;
        String string2 = "URLConnectionHelper";
        if (n10 != 0) {
            object = (HttpsURLConnection)object;
            object3 = com.huawei.hms.framework.network.grs.d.b.a.a(object2);
            ((HttpsURLConnection)object).setSSLSocketFactory((SSLSocketFactory)object3);
            object3 = com.huawei.hms.framework.network.grs.d.b.a.a();
            try {
                ((HttpsURLConnection)object).setHostnameVerifier((HostnameVerifier)object3);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object3 = "init https ssl socket failed.";
                Logger.w(string2, object3);
            }
            n10 = 10000;
            ((URLConnection)object).setConnectTimeout(n10);
            ((URLConnection)object).setReadTimeout(n10);
            object2 = com.huawei.hms.framework.network.grs.d.a.b(object2, "NetworkKit-grs", (String)charSequence);
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("request to grs server with a User-Agent header is:");
            ((StringBuilder)charSequence).append((String)object2);
            charSequence = ((StringBuilder)charSequence).toString();
            Logger.d(string2, charSequence);
            ((URLConnection)object).setRequestProperty("User-Agent", (String)object2);
            return object;
        }
        Logger.w(string2, "urlConnection is not an instance of HttpsURLConnection");
        return null;
    }
}

