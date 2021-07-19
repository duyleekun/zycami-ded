/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.zhiyun.live;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import com.zhiyun.live.LiveLoginActivity$a;
import com.zhiyun.live.LiveLoginActivity$b;
import com.zhiyun.live.R$id;
import com.zhiyun.live.R$layout;
import d.v.n.b;
import d.v.n.l.d;

public class LiveLoginActivity
extends d.v.f.c.d {
    private static final String e = "https://service.zhiyun-tech.com/thirdparty/restream/callback?code";
    private static final String f = "https://service.zhiyun-tech.com/thirdparty/restream/callback?result";
    private static final String g = "https://service.zhiyun-tech.com/thirdparty/kuaishou/callback?code";
    private static final String h = "https://service.zhiyun-tech.com/thirdparty/kuaishou/callback?result";
    private String b = "LiveThirdLoginManager";
    private WebView c;
    private View d;

    public static /* synthetic */ WebView d(LiveLoginActivity liveLoginActivity) {
        return liveLoginActivity.c;
    }

    private /* synthetic */ void f(View view) {
        this.setResult(0);
        this.finish();
    }

    private void i() {
        this.c.setBackgroundColor(0);
        Object object = this.c;
        LiveLoginActivity$b liveLoginActivity$b = new LiveLoginActivity$b(this);
        object.setWebViewClient((WebViewClient)liveLoginActivity$b);
        object = d.v.n.l.d.i().a.uri;
        this.c.loadUrl((String)object);
    }

    private void j() {
        Window window = this.getWindow();
        if (window != null) {
            this.getWindow().getDecorView().setSystemUiVisibility(1792);
            window = this.getWindow();
            window.setStatusBarColor(0);
        }
    }

    public /* synthetic */ void h(View view) {
        this.f(view);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        int n10 = R$layout.activity_live_login;
        this.setContentView(n10);
        this.j();
        object = this.getOnBackPressedDispatcher();
        Object object2 = new LiveLoginActivity$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback(this, (OnBackPressedCallback)object2);
        n10 = R$id.web;
        object = (WebView)this.findViewById(n10);
        this.c = object;
        n10 = R$id.iv_back;
        object = this.findViewById(n10);
        this.d = object;
        this.i();
        object = this.d;
        object2 = new b(this);
        object.setOnClickListener((View.OnClickListener)object2);
    }
}

