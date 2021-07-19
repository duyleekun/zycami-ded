/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 */
package com.kwai.auth.login.kwailogin.h5login;

import android.app.Activity;
import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.kwai.auth.common.InternalResponse;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity;
import com.kwai.auth.login.kwailogin.h5login.KwaiH5LoginActivity$b$a;
import d.l.a.c;
import d.l.a.e.a;

public class KwaiH5LoginActivity$b
extends WebViewClient {
    public final /* synthetic */ KwaiH5LoginActivity a;

    public KwaiH5LoginActivity$b(KwaiH5LoginActivity kwaiH5LoginActivity) {
        this.a = kwaiH5LoginActivity;
    }

    public boolean shouldOverrideUrlLoading(WebView object, String object2) {
        int n10;
        Object object3 = this.a;
        int n11 = KwaiH5LoginActivity.b(object3);
        if (n11 == (n10 = 1000)) {
            String string2;
            object3 = ((String)object2).trim().toLowerCase();
            String string3 = d.l.a.e.a.b((Context)this.a).trim().toLowerCase();
            n11 = (int)(((String)object3).startsWith(string3) ? 1 : 0);
            n10 = 1;
            if (n11) {
                object = this.a;
                object3 = new KwaiH5LoginActivity$b$a(this, (String)object2);
                object.runOnUiThread((Runnable)object3);
                return n10 != 0;
            }
            object3 = ((String)object2).trim().toLowerCase();
            n11 = (int)(((String)object3).equals(string2 = "kwai://opensdk/webview/close") ? 1 : 0);
            if (n11) {
                object = c.f();
                object2 = KwaiH5LoginActivity.a(this.a);
                object3 = this.a;
                ((c)object).h((InternalResponse)object2, (Activity)object3);
                return n10 != 0;
            }
        }
        return super.shouldOverrideUrlLoading((WebView)object, (String)object2);
    }
}

