/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 */
package cn.sharesdk.sina.weibo.sdk.a;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import cn.sharesdk.sina.weibo.sdk.a.a;

public class a$2
extends WebChromeClient {
    public final /* synthetic */ a a;

    public a$2(a a10) {
        this.a = a10;
    }

    public void onProgressChanged(WebView object, int n10) {
        super.onProgressChanged(object, n10);
        object = cn.sharesdk.sina.weibo.sdk.a.a.a(this.a);
        object.a(n10);
        int n11 = 100;
        if (n10 == n11) {
            object = cn.sharesdk.sina.weibo.sdk.a.a.a(this.a);
            n10 = 4;
            object.setVisibility(n10);
        } else {
            object = cn.sharesdk.sina.weibo.sdk.a.a.a(this.a);
            n10 = 0;
            object.setVisibility(0);
        }
    }
}

