/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.webkit.WebView
 */
package com.sina.weibo.sdk.web;

import android.text.TextUtils;
import android.webkit.WebView;
import com.sina.weibo.sdk.web.WebActivity;
import com.sina.weibo.sdk.web.b.b$a;

public final class WebActivity$1
implements b$a {
    public final /* synthetic */ WebActivity az;

    public WebActivity$1(WebActivity webActivity) {
        this.az = webActivity;
    }

    public final void onComplete() {
        String string2 = WebActivity.a(this.az).getUrl();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = WebActivity.k(string2))) {
            WebView webView = WebActivity.b(this.az);
            webView.loadUrl(string2);
        }
    }

    public final void onError(String string2) {
        WebActivity.c(this.az).p(string2);
    }
}

