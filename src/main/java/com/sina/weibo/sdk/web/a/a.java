/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 */
package com.sina.weibo.sdk.web.a;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.web.a.b;

public final class a
extends b {
    public a(Activity activity, com.sina.weibo.sdk.web.a a10, com.sina.weibo.sdk.web.b.b b10) {
        super(activity, a10, b10);
    }

    private boolean l(String string2) {
        boolean bl2;
        boolean bl3;
        Object object = this.aF.x().a();
        return object != null && (bl3 = string2.startsWith((String)(object = ((AuthInfo)object).getRedirectUrl()))) && (string2 = e.g(string2)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = string2.getString((String)(object = "access_token")))));
    }

    public final void onPageFinished(WebView object, String object2) {
        boolean bl2;
        super.onPageFinished((WebView)object, (String)object2);
        object = this.aF.x().a();
        if (object != null && (bl2 = ((String)object2).startsWith((String)(object = ((AuthInfo)object).getRedirectUrl())))) {
            object = this.aF.x().u();
            int n10 = TextUtils.isEmpty((CharSequence)object);
            if (n10 == 0) {
                WbAuthListener wbAuthListener;
                this.aG = wbAuthListener = this.aC.a((String)object);
                if (wbAuthListener != null) {
                    object2 = e.g((String)object2);
                    n10 = -1;
                    if (object2 != null) {
                        Object object3 = object2.getString("error");
                        String string2 = object2.getString("error_code");
                        String string3 = object2.getString("error_description");
                        boolean bl3 = TextUtils.isEmpty((CharSequence)object3);
                        if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)string2))) {
                            object2 = Oauth2AccessToken.parseAccessToken((Bundle)object2);
                            AccessTokenHelper.writeAccessToken((Context)this.aD, (Oauth2AccessToken)object2);
                            wbAuthListener = this.aG;
                            wbAuthListener.onComplete((Oauth2AccessToken)object2);
                        } else {
                            object2 = this.aG;
                            object3 = new UiError(n10, string2, string3);
                            object2.onError((UiError)object3);
                        }
                    } else {
                        object2 = this.aG;
                        String string4 = "bundle is null";
                        String string5 = "parse url error";
                        UiError uiError = new UiError(n10, string4, string5);
                        object2.onError(uiError);
                    }
                    object2 = this.aC;
                    ((com.sina.weibo.sdk.auth.b)object2).b((String)object);
                }
            }
            if ((object = this.aE) != null) {
                object.t();
            }
        }
    }

    public final void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
    }

    public final boolean shouldOverrideUrlLoading(WebView object, WebResourceRequest webResourceRequest) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object = webResourceRequest.getUrl().toString();
            return this.l((String)object);
        }
        return false;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        return this.l(string2);
    }

    public final void t() {
        super.t();
        Object object = this.aF.x().u();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            Object object2 = this.aC.a((String)object);
            this.aG = object2;
            if (object2 != null) {
                object2.onCancel();
            }
            object2 = this.aC;
            ((com.sina.weibo.sdk.auth.b)object2).b((String)object);
        }
        if ((object = this.aE) != null) {
            object.t();
        }
    }

    public final boolean v() {
        this.t();
        return true;
    }
}

