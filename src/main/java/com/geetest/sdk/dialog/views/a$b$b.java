/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.geetest.sdk.dialog.views;

import android.os.Handler;
import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.dialog.views.a$b;

public class a$b$b
implements Runnable {
    public final /* synthetic */ a$b a;

    public a$b$b(a$b a$b) {
        this.a = a$b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        GtWebView gtWebView;
        boolean bl2;
        GtWebView gtWebView2 = com.geetest.sdk.dialog.views.a.g(this.a.a);
        if (gtWebView2 != null && !(bl2 = (gtWebView = com.geetest.sdk.dialog.views.a.g(this.a.a)).b())) {
            au au2;
            Handler handler = com.geetest.sdk.dialog.views.a.d(this.a.a);
            if (handler != null) {
                try {
                    a$b a$b = this.a;
                    a a10 = a$b.a;
                    Handler handler2 = com.geetest.sdk.dialog.views.a.d(a10);
                    Object object = this.a;
                    object = ((a$b)object).a;
                    object = com.geetest.sdk.dialog.views.a.h((a)object);
                    handler2.removeCallbacks((Runnable)object);
                    a$b a$b2 = this.a;
                    a a11 = a$b2.a;
                    Handler handler3 = com.geetest.sdk.dialog.views.a.d(a11);
                    int n10 = 1;
                    handler3.removeMessages(n10);
                }
                catch (Exception exception) {}
            }
            if ((au2 = com.geetest.sdk.dialog.views.a.a(this.a.a)) != null) {
                au au3 = com.geetest.sdk.dialog.views.a.a(this.a.a);
                au3.a();
            }
        }
    }
}

