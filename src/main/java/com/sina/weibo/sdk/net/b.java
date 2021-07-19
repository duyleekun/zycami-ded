/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.net;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.sina.weibo.sdk.net.a;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.f;
import com.sina.weibo.sdk.net.g;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;

public final class b
implements a {
    private static void a(OutputStream object, d object2) {
        String string2;
        object2 = object2.h();
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator2 = object2.keySet().iterator();
        boolean bl2 = true;
        while (true) {
            String string3;
            boolean bl3 = iterator2.hasNext();
            string2 = "UTF-8";
            if (!bl3) break;
            String string4 = (String)iterator2.next();
            if (bl2) {
                bl2 = false;
            } else {
                string3 = "&";
                stringBuilder.append(string3);
            }
            string3 = String.valueOf(object2.get(string4));
            string4 = URLEncoder.encode(string4, string2);
            stringBuilder.append(string4);
            string4 = "=";
            stringBuilder.append(string4);
            string4 = URLEncoder.encode(string3, string2);
            try {
                stringBuilder.append(string4);
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }
        }
        try {
            object2 = new DataOutputStream((OutputStream)object);
            object = stringBuilder.toString();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
        object = ((String)object).getBytes(string2);
        ((FilterOutputStream)object2).write((byte[])object);
        ((FilterOutputStream)object2).close();
    }

    private static void a(HttpURLConnection httpURLConnection, Bundle bundle) {
        boolean bl2;
        Iterator iterator2 = bundle.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            String string3 = String.valueOf(bundle.get(string2));
            httpURLConnection.addRequestProperty(string2, string3);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final f a(d d10) {
        Throwable throwable2222222;
        Object object;
        Object object2;
        int n10;
        Object object3 = d10.getUrl();
        Object object4 = d10.getParams();
        if (object4 != null && (n10 = object4.size()) != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) == 0) {
            boolean bl2;
            object2 = Uri.parse((String)object3);
            if (object4 != null && !(bl2 = object4.isEmpty())) {
                boolean bl3;
                object2 = object2.buildUpon();
                object = object4.keySet().iterator();
                while (bl3 = object.hasNext()) {
                    String string2 = (String)object.next();
                    String string3 = String.valueOf(object4.get(string2));
                    object2.appendQueryParameter(string2, string3);
                }
                object2 = object2.build();
            }
            if (object2 != null) {
                object3 = object2.toString();
            }
        }
        object4 = new URL((String)object3);
        object3 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object4).openConnection()));
        object4 = "POST";
        ((HttpURLConnection)object3).setRequestMethod((String)object4);
        object4 = "Connection";
        object2 = "Keep-Alive";
        ((URLConnection)object3).setRequestProperty((String)object4, (String)object2);
        object4 = "Charset";
        object2 = "UTF-8";
        ((URLConnection)object3).setRequestProperty((String)object4, (String)object2);
        object4 = new Bundle();
        object2 = "Content-Type";
        object = "application/x-www-form-urlencoded";
        object4.putString((String)object2, (String)object);
        b.a((HttpURLConnection)object3, (Bundle)object4);
        int n11 = 1;
        ((URLConnection)object3).setDoInput(n11 != 0);
        ((URLConnection)object3).setDoOutput(n11 != 0);
        n11 = 0;
        object4 = null;
        ((URLConnection)object3).setUseCaches(false);
        n11 = d10.getReadTimeout();
        ((URLConnection)object3).setReadTimeout(n11);
        n11 = d10.getConnectTimeout();
        ((URLConnection)object3).setConnectTimeout(n11);
        ((URLConnection)object3).connect();
        object4 = ((URLConnection)object3).getOutputStream();
        b.a((OutputStream)object4, d10);
        int n12 = ((HttpURLConnection)object3).getResponseCode();
        n11 = 200;
        object4 = n12 == n11 ? ((URLConnection)object3).getInputStream() : ((HttpURLConnection)object3).getErrorStream();
        object2 = new g(n12, (InputStream)object4);
        if (object3 != null) {
            ((HttpURLConnection)object3).disconnect();
        }
        return object2;
        {
            catch (Throwable throwable2222222) {
            }
            catch (Exception exception) {}
            {
                String string4 = exception.getMessage();
                object4 = new Throwable(string4);
                throw object4;
            }
        }
        if (object3 != null) {
            ((HttpURLConnection)object3).disconnect();
        }
        throw throwable2222222;
    }
}

