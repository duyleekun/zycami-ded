/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Path$FillType
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.os.Handler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.GtWebView$b;
import com.geetest.sdk.dialog.views.GtWebView$c;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;
import java.util.HashMap;

public class GtWebView
extends WebView {
    private static final String n = GtWebView.class.getSimpleName();
    private Context a;
    private au b;
    private boolean c;
    private String d;
    private b e;
    private Runnable f;
    private Handler g;
    private int h;
    private int i;
    private int j;
    private Paint k;
    private Path l;
    private RectF m;

    public GtWebView(Context context) {
        super(context);
        new HashMap();
        this.c = false;
        this.g = null;
        this.a(context);
    }

    public static /* synthetic */ Context a(GtWebView gtWebView) {
        return gtWebView.a;
    }

    private void a(Context context) {
        this.a = context;
        this.b(context);
    }

    public static /* synthetic */ au b(GtWebView gtWebView) {
        return gtWebView.b;
    }

    private void b(Context context) {
        context = new Paint();
        this.k = context;
        context.setColor(0);
        context = this.k;
        Paint.Style style2 = Paint.Style.FILL;
        context.setStyle(style2);
        this.k.setAntiAlias(true);
        context = this.k;
        PorterDuff.Mode mode = PorterDuff.Mode.CLEAR;
        style2 = new PorterDuffXfermode(mode);
        context.setXfermode((Xfermode)style2);
    }

    public static /* synthetic */ Handler c(GtWebView gtWebView) {
        return gtWebView.g;
    }

    public static /* synthetic */ String c() {
        return n;
    }

    public static /* synthetic */ Runnable d(GtWebView gtWebView) {
        return gtWebView.f;
    }

    public static /* synthetic */ String e(GtWebView gtWebView) {
        return gtWebView.d;
    }

    public static /* synthetic */ b f(GtWebView gtWebView) {
        return gtWebView.e;
    }

    public void a() {
        Object object = this.getSettings();
        int n10 = 1;
        object.setJavaScriptEnabled(n10 != 0);
        object.setLoadWithOverviewMode(n10 != 0);
        object.setDomStorageEnabled(n10 != 0);
        object.setAppCacheEnabled(n10 != 0);
        object.setUseWideViewPort(n10 != 0);
        object.setCacheMode(n10);
        object.setTextZoom(100);
        n10 = 0;
        object.setSavePassword(false);
        object.setAllowFileAccess(false);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 16;
        if (n11 >= n12) {
            object.setAllowFileAccessFromFileURLs(false);
            object.setAllowUniversalAccessFromFileURLs(false);
        }
        object.setGeolocationEnabled(false);
        object.setAllowContentAccess(false);
        this.removeJavascriptInterface("searchBoxJavaBridge_");
        this.removeJavascriptInterface("accessibility");
        this.removeJavascriptInterface("accessibilityTraversal");
        this.setOverScrollMode(2);
        this.setScrollContainer(false);
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
        this.onResume();
        object = new GtWebView$b(this, null);
        super.setWebChromeClient((WebChromeClient)object);
        object = new GtWebView$c(this, this);
        super.setWebViewClient((WebViewClient)object);
    }

    public boolean b() {
        return this.c;
    }

    public void destroy() {
        com.geetest.sdk.utils.l.b(n, "GT3GtWebView-->destroy");
        this.a = null;
        this.b = null;
        super.destroy();
    }

    public Handler getMyHandler() {
        return this.g;
    }

    public Runnable getRunnable() {
        return this.f;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        boolean bl2 = this.c;
        if (bl2) {
            String string2 = " ";
            this.loadUrl(string2);
        }
    }

    public void onDraw(Canvas object) {
        super.onDraw(object);
        Object object2 = this.l;
        Object object3 = this.k;
        object.drawPath(object2, (Paint)object3);
        object2 = n;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("webView\u786c\u4ef6\u52a0\u901f\u662f\u5426\u5f00\u542f\uff1a");
        boolean bl2 = object.isHardwareAccelerated();
        ((StringBuilder)object3).append(bl2);
        object = ((StringBuilder)object3).toString();
        com.geetest.sdk.utils.l.d((String)object2, (String)object);
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.resumeTimers();
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        b b10;
        super.onSizeChanged(n10, n11, n12, n13);
        this.h = n10;
        this.i = n11;
        String string2 = n;
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "onSizeChanged-->newWidth-->";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        stringBuilder.append("-->newHeight");
        stringBuilder.append(n11);
        stringBuilder.append("-->oldWidth");
        stringBuilder.append(n12);
        stringBuilder.append("-->oldHeight");
        stringBuilder.append(n13);
        Object object = stringBuilder.toString();
        com.geetest.sdk.utils.l.b(string2, (String)object);
        object = this.e;
        if (object != null) {
            object = this.getContext();
            b10 = this.e;
            n11 = b10.d();
            f10 = n11;
            this.j = n10 = com.geetest.sdk.utils.g.a((Context)object, f10);
        }
        f10 = this.h;
        float f11 = this.i;
        object = new RectF(0.0f, 0.0f, f10, f11);
        this.m = object;
        object = new Path();
        this.l = object;
        b10 = Path.FillType.INVERSE_WINDING;
        object.setFillType((Path.FillType)b10);
        object = this.l;
        b10 = this.m;
        f11 = this.j;
        Path.Direction direction = Path.Direction.CW;
        object.addRoundRect((RectF)b10, f11, f11, direction);
    }

    public void setDataBean(b b10) {
        this.e = b10;
    }

    public void setMyHandler(Handler handler) {
        this.g = handler;
    }

    public void setObservable(au au2) {
        this.b = au2;
    }

    public void setRunnable(Runnable runnable) {
        this.f = runnable;
    }

    public void setStaticUrl(String string2) {
        this.d = string2;
    }

    public void setTimeout(int n10) {
    }

    public void setVoice(boolean bl2) {
        this.c = bl2;
    }
}

