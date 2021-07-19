/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav;

import android.os.Handler;
import android.os.Looper;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.j;
import com.tencent.liteav.j$1$1;
import com.tencent.liteav.j$a;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class j$1
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ j$a d;
    public final /* synthetic */ j e;

    public j$1(j j10, int n10, String string2, String string3, j$a j$a) {
        this.e = j10;
        this.a = n10;
        this.b = string2;
        this.c = string3;
        this.d = j$a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        long l10;
        Object object;
        Object object2;
        Object object3;
        block8: {
            long l11;
            object3 = "TXCTimeShiftUtil";
            Object object4 = this.e;
            long l12 = System.currentTimeMillis();
            j.a((j)object4, l12);
            object4 = this.e;
            Object object5 = "";
            j.a((j)object4, (String)object5);
            object4 = this.e;
            int n10 = this.a;
            j.a((j)object4, n10);
            object4 = this.e;
            object2 = this.b;
            j.b((j)object4, (String)object2);
            object4 = this.e;
            object2 = TXCCommonUtil.getStreamIDByStreamUrl(this.c);
            j.a((j)object4, (String)object2);
            object4 = this.e;
            object2 = TXCCommonUtil.getAppNameByStreamUrl(this.c);
            j.c((j)object4, (String)object2);
            object4 = j.a(this.e);
            if (object4 == null) {
                object4 = this.e;
                object2 = "live";
                j.c((j)object4, (String)object2);
            }
            object4 = this.e;
            int n11 = j.b((j)object4);
            n10 = 3;
            int n12 = 2;
            boolean bl2 = true;
            if (n11 < 0) {
                object4 = new Object[n10];
                object4[0] = object2 = j.c(this.e);
                object4[bl2] = object2 = j.a(this.e);
                object4[n12] = object2 = j.d(this.e);
                object2 = "http://%s/timeshift/%s/%s/timeshift.m3u8?delay=0";
                object4 = String.format((String)object2, (Object[])object4);
            } else {
                Object object6;
                n11 = 4;
                object4 = new Object[n11];
                object4[0] = object6 = j.c(this.e);
                int n13 = j.b(this.e);
                object4[bl2] = object6 = Integer.valueOf(n13);
                object4[n12] = object6 = j.d(this.e);
                object4[n10] = object = j.e(this.e);
                object2 = "http://%s/%s/%s/timeshift.m3u8?delay=0&appid=%s&txKbps=0";
                object4 = String.format((String)object2, (Object[])object4);
            }
            try {
                object2 = new URL((String)object4);
                object4 = ((URL)object2).openConnection();
                object4 = FirebasePerfUrlConnection.instrument(object4);
                object4 = (URLConnection)object4;
                object4 = (HttpURLConnection)object4;
                ((URLConnection)object4).setDoOutput(bl2);
                ((URLConnection)object4).setDoInput(bl2);
                ((URLConnection)object4).setUseCaches(false);
                n10 = 5000;
                ((URLConnection)object4).setConnectTimeout(n10);
                ((URLConnection)object4).setReadTimeout(n10);
                object2 = "GET";
                ((HttpURLConnection)object4).setRequestMethod((String)object2);
                object2 = "Charsert";
                object = "UTF-8";
                ((URLConnection)object4).setRequestProperty((String)object2, (String)object);
                object2 = "Content-Type";
                object = "text/plain;";
                ((URLConnection)object4).setRequestProperty((String)object2, (String)object);
                object4 = ((URLConnection)object4).getInputStream();
                object = new InputStreamReader((InputStream)object4);
                object2 = new BufferedReader((Reader)object);
                while ((object4 = ((BufferedReader)object2).readLine()) != null) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append((String)object5);
                    ((StringBuilder)object).append((String)object4);
                    object5 = ((StringBuilder)object).toString();
                }
                object4 = new StringBuilder();
                object2 = "prepareSeekTime: receive response, strResponse = ";
                ((StringBuilder)object4).append((String)object2);
                ((StringBuilder)object4).append((String)object5);
                object4 = ((StringBuilder)object4).toString();
                TXCLog.i((String)object3, (String)object4);
                object4 = this.e;
                object4 = j.d((j)object4, (String)object5);
                if (object4 == null) break block8;
                object5 = this.e;
                l10 = Long.parseLong((String)object4);
                l11 = 1000L;
            }
            catch (Exception exception) {
                object5 = this.e;
                l10 = System.currentTimeMillis();
                j.a((j)object5, l10);
                object5 = new StringBuilder();
                object2 = "prepareSeekTime error ";
                ((StringBuilder)object5).append((String)object2);
                String string2 = exception.toString();
                ((StringBuilder)object5).append(string2);
                string2 = ((StringBuilder)object5).toString();
                TXCLog.e((String)object3, string2);
                break block8;
            }
            {
                j.a((j)object5, l10 *= l11);
            }
        }
        long l13 = System.currentTimeMillis();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("live start time:");
        long l14 = j.f(this.e);
        ((StringBuilder)object2).append(l14);
        ((StringBuilder)object2).append(",currentTime:");
        ((StringBuilder)object2).append(l13);
        ((StringBuilder)object2).append(",diff:");
        object = this.e;
        l14 = j.f((j)object);
        l14 = l13 - l14;
        ((StringBuilder)object2).append(l14);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object3, (String)object2);
        l10 = j.f(this.e);
        l13 -= l10;
        object3 = this.d;
        if (object3 != null) {
            object2 = Looper.getMainLooper();
            object3 = new Handler((Looper)object2);
            object2 = new j$1$1(this, l13);
            object3.post((Runnable)object2);
        }
    }
}

