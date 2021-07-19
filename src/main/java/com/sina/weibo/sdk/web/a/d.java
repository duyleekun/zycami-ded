/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 */
package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.web.a;
import com.sina.weibo.sdk.web.a.b;

public final class d
extends b {
    public d(Activity activity, a a10, com.sina.weibo.sdk.web.b.b b10) {
        super(activity, a10, b10);
    }

    public final void onPageFinished(WebView webView, String string2) {
        super.onPageFinished(webView, string2);
    }

    public final void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
    }

    public final void p(String string2) {
        this.n(string2);
    }

    public final boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest object2) {
        object = object2.getUrl().toString();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && (bl2 = ((String)object).startsWith((String)(object2 = "sinaweibo://browser/close")))) {
            if ((object = e.h((String)object)) != null) {
                object2 = object.getString("code");
                String string2 = "msg";
                object = object.getString(string2);
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                if (bl3) {
                    object = "code is null!!!";
                    this.o((String)object);
                } else {
                    string2 = "0";
                    bl2 = string2.equals(object2);
                    if (bl2) {
                        this.m((String)object);
                    } else {
                        this.n((String)object);
                    }
                }
            } else {
                object = "bundle is null!!!";
                this.n((String)object);
            }
            object = this.aE;
            if (object != null) {
                object.t();
            }
            return true;
        }
        return false;
    }

    public final boolean shouldOverrideUrlLoading(WebView object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = string2.startsWith((String)(object = "sinaweibo://browser/close")))) {
            object = e.h(string2);
            if (object != null) {
                string2 = object.getString("code");
                object = object.getString("msg");
                String string3 = "0";
                boolean bl3 = string3.equals(string2);
                if (bl3) {
                    this.m((String)object);
                } else {
                    this.n((String)object);
                }
            } else {
                object = "bundle is null!!!";
                this.n((String)object);
            }
            object = this.aE;
            if (object != null) {
                object.t();
            }
            return true;
        }
        return false;
    }

    public final void t() {
        this.o("cancel share!!!");
        a a10 = this.aE;
        if (a10 != null) {
            a10.t();
        }
    }

    public final boolean v() {
        this.t();
        return true;
    }
}

