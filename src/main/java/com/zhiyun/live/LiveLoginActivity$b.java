/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.zhiyun.live;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.zhiyun.live.LiveLoginActivity;
import d.v.n.l.d;

public class LiveLoginActivity$b
extends WebViewClient {
    public final /* synthetic */ LiveLoginActivity a;

    public LiveLoginActivity$b(LiveLoginActivity liveLoginActivity) {
        this.a = liveLoginActivity;
    }

    public void onPageFinished(WebView object, String string2) {
        super.onPageFinished(object, string2);
        object = "https://service.zhiyun-tech.com/thirdparty/restream/callback?code";
        boolean bl2 = string2.startsWith((String)object);
        if (!bl2 && !(bl2 = string2.startsWith((String)(object = "https://service.zhiyun-tech.com/thirdparty/kuaishou/callback?code")))) {
            object = "https://service.zhiyun-tech.com/thirdparty/restream/callback?result";
            bl2 = string2.startsWith((String)object);
            if (bl2 || (bl2 = string2.startsWith((String)(object = "https://service.zhiyun-tech.com/thirdparty/kuaishou/callback?result")))) {
                object = this.a;
                string2 = null;
                object.setResult(0);
                d.i().d.a();
                object = this.a;
                object.finish();
            }
            return;
        }
        d.i().v();
        this.a.setResult(-1);
        this.a.finish();
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        super.onPageStarted(webView, string2, bitmap);
    }
}

