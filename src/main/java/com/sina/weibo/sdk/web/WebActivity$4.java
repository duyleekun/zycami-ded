/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 */
package com.sina.weibo.sdk.web;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;

public final class WebActivity$4
extends WebChromeClient {
    public final /* synthetic */ WebActivity az;

    public WebActivity$4(WebActivity webActivity) {
        this.az = webActivity;
    }

    public final void onProgressChanged(WebView webView, int n10) {
        super.onProgressChanged(webView, n10);
        webView = WebActivity.e(this.az);
        webView.setProgress(n10);
        int n11 = 100;
        if (n10 == n11) {
            WebActivity.e(this.az).setVisibility(4);
            return;
        }
        WebActivity.e(this.az).setVisibility(0);
    }

    public final void onReceivedTitle(WebView webView, String string2) {
        super.onReceivedTitle(webView, string2);
    }
}

