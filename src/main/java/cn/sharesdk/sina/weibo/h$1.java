/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package cn.sharesdk.sina.weibo;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.sharesdk.sina.weibo.h;

public class h$1
extends WebViewClient {
    public final /* synthetic */ h a;

    public h$1(h h10) {
        this.a = h10;
    }

    public void onPageFinished(WebView object, String string2) {
        int n10;
        object = this.a;
        int n11 = h.a((h)object);
        if (n11 == (n10 = -1)) {
            h.b(this.a).setVisibility(0);
            object = h.c(this.a);
            n10 = 8;
            object.setVisibility(n10);
        }
        h.a(this.a, 0);
    }

    public void onReceivedError(WebView object, int n10, String string2, String string3) {
        super.onReceivedError((WebView)object, n10, string2, string3);
        object = object.getUrl();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string3) ? 1 : 0)) == 0) {
            boolean bl2;
            object = Uri.parse((String)object);
            Object object2 = Uri.parse((String)string3);
            string2 = object.getHost();
            boolean bl3 = string2.equals(string3 = object2.getHost());
            if (bl3 && (bl2 = ((String)(object = object.getScheme())).equals(object2 = object2.getScheme()))) {
                object = this.a;
                n10 = -1;
                h.a((h)object, n10);
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView object, String string2) {
        object = "sinaweibo://browser/close";
        boolean bl2 = string2.startsWith((String)object);
        if (bl2) {
            object = h.d(this.a);
            if (object != null) {
                object = this.a;
                h.a((h)object, string2);
            }
            return true;
        }
        return false;
    }
}

