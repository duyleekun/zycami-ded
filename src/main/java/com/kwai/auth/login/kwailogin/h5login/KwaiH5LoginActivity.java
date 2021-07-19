/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.ProgressBar
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.kwai.auth.common.InternalResponse;
import com.kwai.auth.login.kwailogin.h5login.H5LoginResponse;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity$a;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity$b;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity$c;
import d.l.a.g.d;

public class KwaiH5LoginActivity
extends Activity {
    private static final String f = "KwaiH5LoginActivity";
    public static final String g = "extra_url";
    public static final String h = "extra_state";
    public static final String i = "extra_request_code";
    public static final int j = 1000;
    public static final int k = 100;
    private static final String l = "kwai://opensdk/webview/close";
    private WebView a;
    private ProgressBar b;
    private String c;
    private String d;
    private int e;

    public static /* synthetic */ InternalResponse a(KwaiH5LoginActivity kwaiH5LoginActivity) {
        return kwaiH5LoginActivity.e();
    }

    public static /* synthetic */ int b(KwaiH5LoginActivity kwaiH5LoginActivity) {
        return kwaiH5LoginActivity.e;
    }

    public static /* synthetic */ String c(KwaiH5LoginActivity kwaiH5LoginActivity) {
        return kwaiH5LoginActivity.d;
    }

    public static /* synthetic */ ProgressBar d(KwaiH5LoginActivity kwaiH5LoginActivity) {
        return kwaiH5LoginActivity.b;
    }

    private InternalResponse e() {
        H5LoginResponse h5LoginResponse = new H5LoginResponse(null);
        h5LoginResponse.setErrorCode(-1);
        return h5LoginResponse;
    }

    private void f() {
        WebView webView;
        this.a = webView = (WebView)d.l.a.g.d.f(this, "webview");
        webView = (ProgressBar)d.l.a.g.d.f(this, "progressBar");
        this.b = webView;
        webView = d.l.a.g.d.f(this, "root_view");
        this.b.setVisibility(0);
        this.b.setMax(100);
        this.i();
        this.g();
        Object object = this.a;
        String string2 = this.c;
        object.loadUrl(string2);
        this.a.resumeTimers();
        object = new KwaiH5LoginActivity$a(this);
        webView.setOnClickListener((View.OnClickListener)object);
    }

    private void g() {
        this.a.setScrollBarStyle(0);
        WebView webView = this.a;
        int n10 = 2;
        webView.setOverScrollMode(n10);
        webView = this.a.getSettings();
        boolean bl2 = true;
        webView.setJavaScriptEnabled(bl2);
        webView = this.a.getSettings();
        WebSettings.PluginState pluginState = WebSettings.PluginState.ON;
        webView.setPluginState(pluginState);
        this.a.getSettings().setSupportZoom(bl2);
        this.a.getSettings().setBuiltInZoomControls(false);
        this.a.getSettings().setUseWideViewPort(bl2);
        this.a.getSettings().setLoadWithOverviewMode(bl2);
        this.a.getSettings().setDefaultTextEncodingName("UTF-8");
        this.a.getSettings().setJavaScriptCanOpenWindowsAutomatically(bl2);
        this.a.getSettings().setCacheMode(n10);
        this.a.getSettings().setSavePassword(false);
        this.a.getSettings().setAllowFileAccess(false);
        this.a.clearCache(bl2);
        webView = this.a;
        Object object = new KwaiH5LoginActivity$b(this);
        webView.setWebViewClient((WebViewClient)object);
        webView = this.a;
        object = new KwaiH5LoginActivity$c(this);
        webView.setWebChromeClient((WebChromeClient)object);
    }

    private void h(Intent intent) {
        if (intent != null && (intent = intent.getExtras()) != null) {
            int n10;
            String string2;
            this.c = string2 = intent.getString(g);
            this.d = string2 = intent.getString(h);
            string2 = null;
            String string3 = i;
            this.e = n10 = intent.getInt(string3, 0);
        }
    }

    private void i() {
        CookieSyncManager.createInstance((Context)this.a.getContext());
        CookieManager.getInstance().removeAllCookie();
    }

    public void onBackPressed() {
        WebView webView = this.a;
        boolean bl2 = webView.canGoBack();
        if (bl2) {
            webView = this.a;
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate(object);
        int n10 = d.l.a.g.d.d((Context)this, "activity_kwai_login_h5");
        this.setContentView(n10);
        object = this.getIntent();
        this.h((Intent)object);
        object = this.c;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0) {
            this.finish();
            return;
        }
        this.f();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDestroy() {
        super.onDestroy();
        WebView webView = this.a;
        if (webView != null) {
            try {
                webView = webView.getParent();
                if (webView != null) {
                    webView = this.a;
                    webView = webView.getParent();
                    webView = (ViewGroup)webView;
                    WebView webView2 = this.a;
                    webView.removeView((View)webView2);
                }
                webView = this.a;
                webView.clearHistory();
                webView = this.a;
                boolean bl2 = true;
                webView.clearCache(bl2);
                webView = this.a;
                String string2 = "about:blank";
                webView.loadUrl(string2);
                webView = this.a;
                webView.freeMemory();
                webView = this.a;
                webView.destroy();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                illegalArgumentException.printStackTrace();
            }
            webView = null;
            this.a = null;
        }
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.h(intent);
        this.f();
    }
}

