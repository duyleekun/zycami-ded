/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.zhiyun.account;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zhiyun.account.SimpleWebViewActivity;

public class SimpleWebViewActivity$b
extends WebViewClient {
    public final /* synthetic */ SimpleWebViewActivity a;

    public SimpleWebViewActivity$b(SimpleWebViewActivity simpleWebViewActivity) {
        this.a = simpleWebViewActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        webView.loadUrl(string2);
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}

