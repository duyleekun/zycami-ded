/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Bundle
 *  android.webkit.WebView
 */
package cn.sharesdk.twitter;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.twitter.b$1;
import cn.sharesdk.twitter.b$2;
import cn.sharesdk.twitter.c;
import com.mob.tools.utils.ResHelper;

public class b
extends cn.sharesdk.framework.authorize.c {
    private boolean a;

    public b(g g10) {
        super(g10);
    }

    public void onComplete(String object) {
        int n10;
        int n11 = (int)(this.a ? 1 : 0);
        if (n11 != 0) {
            return;
        }
        n11 = 1;
        this.a = n11;
        c c10 = c.a(this.activity.a().getPlatform());
        object = c10.c((String)object);
        if (object != null && (n10 = ((String)object).length()) > 0) {
            object = ((String)object).split("&");
            c10 = new Bundle();
            for (Object object2 : object) {
                int n12;
                String string2;
                int n13;
                if (object2 == null || (n13 = ((String[])(object2 = object2.split(string2 = "="))).length) < (n12 = 2)) continue;
                string2 = object2[0];
                object2 = object2[n11];
                c10.putString(string2, (String)object2);
            }
            int n14 = c10.size();
            if (n14 <= 0) {
                object = this.listener;
                if (object != null) {
                    Throwable throwable = new Throwable();
                    object.onError(throwable);
                }
                return;
            }
            object = this.listener;
            if (object != null) {
                object.onComplete((Bundle)c10);
            }
            return;
        }
        object = this.listener;
        if (object != null) {
            Throwable throwable = new Throwable();
            object.onError(throwable);
        }
    }

    public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
        boolean bl2;
        String string3 = this.redirectUri;
        if (string3 != null && (bl2 = string2.startsWith(string3))) {
            webView.stopLoading();
            this.activity.finish();
            string3 = String.valueOf(ResHelper.urlToBundle(string2).get("oauth_verifier"));
            b$2 b$2 = new b$2(this, string3);
            b$2.start();
        }
        super.onPageStarted(webView, string2, bitmap);
    }

    public boolean shouldOverrideUrlLoading(WebView object, String object2) {
        boolean bl2;
        String string2 = this.redirectUri;
        if (string2 != null && (bl2 = ((String)object2).startsWith(string2))) {
            object.stopLoading();
            this.activity.finish();
            object = String.valueOf(ResHelper.urlToBundle((String)object2).get("oauth_verifier"));
            object2 = new b$1(this, (String)object);
            ((Thread)object2).start();
            return true;
        }
        return super.shouldOverrideUrlLoading((WebView)object, (String)object2);
    }
}

