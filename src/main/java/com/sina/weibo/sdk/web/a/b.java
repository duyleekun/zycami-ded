/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.ShareResultActivity;
import com.sina.weibo.sdk.web.a;

public abstract class b
extends WebViewClient {
    public com.sina.weibo.sdk.auth.b aC;
    public Activity aD;
    public a aE;
    public com.sina.weibo.sdk.web.b.b aF;
    public WbAuthListener aG;

    public b(Activity activity, a a10, com.sina.weibo.sdk.web.b.b b10) {
        com.sina.weibo.sdk.auth.b b11;
        this.aC = b11 = com.sina.weibo.sdk.auth.b.f();
        this.aD = activity;
        this.aE = a10;
        this.aF = b10;
    }

    private void b(int n10, String string2) {
        Bundle bundle = this.aD.getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        Activity activity = this.aD;
        Intent intent = new Intent((Context)activity, ShareResultActivity.class);
        intent.setAction("com.sina.weibo.sdk.action.ACTION_SDK_REQ_ACTIVITY");
        intent.putExtras(bundle);
        intent.putExtra("_weibo_resp_errcode", n10);
        intent.putExtra("_weibo_resp_errstr", string2);
        this.aD.startActivity(intent);
    }

    public final void m(String string2) {
        this.b(0, string2);
    }

    public final void n(String string2) {
        this.b(2, string2);
    }

    public final void o(String string2) {
        this.b(1, string2);
    }

    public void onPageFinished(WebView webView, String string2) {
        super.onPageFinished(webView, string2);
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
    }

    public void onReceivedError(WebView object, WebResourceRequest webResourceRequest, WebResourceError object2) {
        super.onReceivedError((WebView)object, webResourceRequest, (WebResourceError)object2);
        object = this.aE;
        if (object != null) {
            object2.getErrorCode();
            object2 = object2.getDescription();
            object2.toString();
            webResourceRequest = webResourceRequest.getUrl();
            webResourceRequest.toString();
            object.s();
        }
    }

    public void p(String string2) {
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public void t() {
    }

    public boolean v() {
        return false;
    }
}

