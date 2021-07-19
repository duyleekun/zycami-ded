/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.webkit.ValueCallback
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebSettings$LayoutAlgorithm
 *  android.webkit.WebView
 */
package com.zhiyun.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.zhiyun.component.widget.JSWebView$a;
import d.v.e.l.k2;

public class JSWebView
extends WebView {
    public JSWebView(Context context) {
        this(context, null);
    }

    public JSWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e();
    }

    public JSWebView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.e();
    }

    public JSWebView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        this.e();
    }

    private void e() {
        WebSettings webSettings = this.getSettings();
        boolean bl2 = true;
        webSettings.setJavaScriptEnabled(bl2);
        webSettings.setAppCacheEnabled(bl2);
        String string2 = k2.V().getAbsolutePath();
        webSettings.setAppCachePath(string2);
        webSettings.setCacheMode(-1);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(bl2);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDomStorageEnabled(bl2);
        webSettings.setSupportMultipleWindows(false);
        webSettings.setNeedInitialFocus(false);
        webSettings.setDatabaseEnabled(bl2);
        webSettings.setAllowFileAccess(bl2);
        webSettings.setSupportZoom(bl2);
        string2 = WebSettings.LayoutAlgorithm.NARROW_COLUMNS;
        webSettings.setLayoutAlgorithm((WebSettings.LayoutAlgorithm)string2);
        webSettings.setUseWideViewPort(bl2);
        this.setScrollBarStyle(0x2000000);
        this.requestFocus();
        webSettings = new WebChromeClient();
        this.setWebChromeClient((WebChromeClient)webSettings);
    }

    private String f(String string2, Object ... objectArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(string2);
        string2 = "(";
        stringBuilder.append(string2);
        int n10 = objectArray.length;
        String string3 = "";
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            stringBuilder.append(string3);
            boolean bl2 = object instanceof String;
            String string4 = "'";
            if (bl2) {
                stringBuilder.append(string4);
            }
            object = object.toString();
            String string5 = "\\'";
            object = ((String)object).replace(string4, string5);
            stringBuilder.append((String)object);
            if (bl2) {
                stringBuilder.append(string4);
            }
            string3 = ",";
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void a(JSWebView$a jSWebView$a) {
        String string2 = jSWebView$a.a();
        super.addJavascriptInterface((Object)jSWebView$a, string2);
    }

    public void b(String string2, ValueCallback valueCallback, Object ... objectArray) {
        string2 = this.f(string2, objectArray);
        super.evaluateJavascript(string2, valueCallback);
    }

    public void c(String string2, Object ... objectArray) {
        this.b(string2, null, objectArray);
    }

    public void d(boolean bl2) {
        WebView.setWebContentsDebuggingEnabled((boolean)bl2);
    }
}

