/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Looper
 *  android.webkit.WebView
 */
package com.baidu.location.b;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.webkit.WebView;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.b.n$1;
import com.baidu.location.b.n$a;
import com.baidu.location.b.n$c;
import com.baidu.location.b.n$d;
import com.baidu.location.b.n$e;
import com.baidu.location.b.n$f;
import java.util.List;

public class n {
    private static long j = 12000L;
    public n$e a;
    private Context b = null;
    private WebView c;
    private LocationClient d = null;
    private n$a e;
    private List f;
    private boolean g;
    private long h;
    private BDLocation i;
    private n$f k;
    private boolean l;

    private n() {
        n$e n$e;
        this.a = n$e = new n$e(this);
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = 0L;
        this.i = null;
        this.k = null;
        this.l = false;
    }

    public /* synthetic */ n(n$1 n$1) {
        this();
    }

    public static /* synthetic */ long a(long l10) {
        j = l10;
        return l10;
    }

    public static /* synthetic */ long a(n n10, long l10) {
        n10.h = l10;
        return l10;
    }

    public static /* synthetic */ BDLocation a(n n10, BDLocation bDLocation) {
        n10.i = bDLocation;
        return bDLocation;
    }

    public static /* synthetic */ n$f a(n n10, n$f n$f) {
        n10.k = n$f;
        return n$f;
    }

    public static n a() {
        return n$c.a();
    }

    public static /* synthetic */ List a(n n10, List list) {
        n10.f = list;
        return list;
    }

    private void a(WebView webView) {
        n$d n$d = new n$d(this, null);
        webView.addJavascriptInterface((Object)n$d, "BaiduLocAssistant");
    }

    public static /* synthetic */ boolean a(n n10) {
        return n10.g;
    }

    public static /* synthetic */ boolean a(n n10, boolean bl2) {
        n10.l = bl2;
        return bl2;
    }

    public static /* synthetic */ n$a b(n n10) {
        return n10.e;
    }

    public static /* synthetic */ long c() {
        return j;
    }

    public static /* synthetic */ boolean c(n n10) {
        return n10.l;
    }

    public static /* synthetic */ n$f d(n n10) {
        return n10.k;
    }

    public static /* synthetic */ List e(n n10) {
        return n10.f;
    }

    public static /* synthetic */ WebView f(n n10) {
        return n10.c;
    }

    public static /* synthetic */ LocationClient g(n n10) {
        return n10.d;
    }

    public static /* synthetic */ long h(n n10) {
        return n10.h;
    }

    public static /* synthetic */ BDLocation i(n n10) {
        return n10.i;
    }

    public void a(Context object, WebView webView, LocationClient locationClient) {
        int n10;
        int n11 = this.g;
        if (n11 != 0) {
            return;
        }
        Integer n12 = Build.VERSION.SDK_INT;
        n11 = n12;
        if (n11 < (n10 = 17)) {
            return;
        }
        this.b = object;
        this.c = webView;
        this.d = locationClient;
        locationClient = Looper.getMainLooper();
        object = new n$a(this, (Looper)locationClient);
        this.e = object;
        object.obtainMessage(3).sendToTarget();
        object = webView.getSettings();
        boolean bl2 = true;
        object.setJavaScriptEnabled(bl2);
        object = this.c;
        this.a((WebView)object);
        this.g = bl2;
    }

    public void b() {
        boolean bl2 = this.g;
        if (!bl2) {
            return;
        }
        this.e.obtainMessage(4).sendToTarget();
        this.g = false;
    }
}

