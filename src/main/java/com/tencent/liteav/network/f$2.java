/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  org.json.JSONException
 */
package com.tencent.liteav.network;

import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONException;

public class f$2
extends Thread {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;
    public final /* synthetic */ String f;
    public final /* synthetic */ f g;

    public f$2(f f10, String string2, int n10, String string3, String string4, String string5, int n11, String string6) {
        this.g = f10;
        this.a = n10;
        this.b = string3;
        this.c = string4;
        this.d = string5;
        this.e = n11;
        this.f = string6;
        super(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = "TXCVodPlayerNetApi";
        int n10 = -2;
        try {
            Object object2;
            String string2;
            Looper.prepare();
            Object object3 = this.g;
            boolean bl2 = com.tencent.liteav.network.f.a((f)object3);
            int n11 = 2;
            int n12 = 1;
            int n13 = 0;
            Object object4 = null;
            int n14 = 3;
            String string3 = "%s/%d/%s";
            if (bl2) {
                object3 = new Object[n14];
                string2 = "https://playvideo.qcloud.com/getplayinfo/v2";
                object3[0] = string2;
                n13 = this.a;
                object3[n12] = object4 = Integer.valueOf(n13);
                object3[n11] = object2 = this.b;
                object3 = String.format(string3, (Object[])object3);
            } else {
                object3 = new Object[n14];
                string2 = "http://playvideo.qcloud.com/getplayinfo/v2";
                object3[0] = string2;
                n13 = this.a;
                object3[n12] = object4 = Integer.valueOf(n13);
                object3[n11] = object2 = this.b;
                object3 = String.format(string3, (Object[])object3);
            }
            Object object5 = this.g;
            object2 = this.c;
            object4 = this.d;
            n14 = this.e;
            string3 = this.f;
            object5 = com.tencent.liteav.network.f.a((f)object5, (String)object2, (String)object4, n14, string3);
            if (object5 != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object3);
                object3 = "?";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append((String)object5);
                object3 = ((StringBuilder)object2).toString();
            }
            object5 = new URL((String)object3);
            object2 = new StringBuilder();
            object4 = "getplayinfo: ";
            ((StringBuilder)object2).append((String)object4);
            ((StringBuilder)object2).append((String)object3);
            object3 = ((StringBuilder)object2).toString();
            TXCLog.d((String)object, (String)object3);
            object3 = ((URL)object5).openConnection();
            object3 = FirebasePerfUrlConnection.instrument(object3);
            object3 = (URLConnection)object3;
            object3 = (HttpURLConnection)object3;
            ((URLConnection)object3).connect();
            n11 = ((HttpURLConnection)object3).getResponseCode();
            n12 = 200;
            if (n11 != n12) {
                object3 = this.g;
                object5 = "Request failed";
                n12 = -1;
                ((f)object3).a((String)object5, n12);
                return;
            }
            object3 = ((URLConnection)object3).getInputStream();
            object2 = new InputStreamReader((InputStream)object3);
            object5 = new BufferedReader((Reader)object2);
            object3 = new StringBuilder();
            while (true) {
                if ((object2 = ((BufferedReader)object5).readLine()) == null) {
                    object5 = this.g;
                    object3 = ((StringBuilder)object3).toString();
                    com.tencent.liteav.network.f.a((f)object5, (String)object3);
                    return;
                }
                ((StringBuilder)object3).append((String)object2);
            }
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "http exception: ";
            stringBuilder.append(string4);
            String string5 = exception.getMessage();
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
            TXCLog.d((String)object, string5);
            object = this.g;
            string5 = "The request was exceptional";
            ((f)object).a(string5, n10);
            return;
        }
        catch (JSONException jSONException) {
            object = this.g;
            String string6 = "Incorrect format";
            ((f)object).a(string6, n10);
        }
    }
}

