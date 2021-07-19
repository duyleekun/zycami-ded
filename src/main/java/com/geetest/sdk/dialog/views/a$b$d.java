/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.ViewGroup$LayoutParams
 */
package com.geetest.sdk.dialog.views;

import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewGroup;
import com.geetest.sdk.d;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.dialog.views.a$b;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.i;

public class a$b$d
implements Runnable {
    public final /* synthetic */ a$b a;

    public a$b$d(a$b a$b) {
        this.a = a$b;
    }

    public void run() {
        Object object = com.geetest.sdk.dialog.views.a.g(this.a.a);
        int n10 = 1;
        ((GtWebView)((Object)object)).setVoice(n10 != 0);
        com.geetest.sdk.dialog.views.a.c(this.a.a).j("voice");
        object = com.geetest.sdk.dialog.views.a.e(this.a.a);
        int n11 = i.a((Context)object);
        Object object2 = com.geetest.sdk.dialog.views.a.e(this.a.a);
        int n12 = i.b(object2);
        Context context = com.geetest.sdk.dialog.views.a.e(this.a.a);
        float f10 = 275.0f;
        int n13 = g.a(context, f10);
        Context context2 = com.geetest.sdk.dialog.views.a.e(this.a.a);
        float f11 = 348.0f;
        int n14 = g.a(context2, f11);
        Context context3 = com.geetest.sdk.dialog.views.a.e(this.a.a);
        float f12 = 300.0f;
        int n15 = g.a(context3, f12);
        Configuration configuration = com.geetest.sdk.dialog.views.a.e(this.a.a).getApplicationContext().getResources().getConfiguration();
        int n16 = configuration.orientation;
        if (n16 == n10) {
            if ((n12 = n12 * 4 / 5) >= n15) {
                n15 = n12;
            }
            if (n12 <= n14) {
                n14 = n15;
            }
            com.geetest.sdk.dialog.views.a.n = n14;
            object = this.a.a;
            n11 = com.geetest.sdk.dialog.views.a.i((a)object);
            com.geetest.sdk.dialog.views.a.o = n14 = n14 * n11 / 100;
        } else {
            object2 = com.geetest.sdk.dialog.views.a.e(this.a.a);
            context3 = com.geetest.sdk.dialog.views.a.e(this.a.a);
            float f13 = n11;
            n11 = g.a(object2, f13 = (float)(g.b(context3, f13) + -44));
            if (n11 >= n13) {
                n13 = n11;
            }
            if (n11 <= n14) {
                n14 = n13;
            }
            com.geetest.sdk.dialog.views.a.o = n14;
            n14 *= 100;
            object = this.a.a;
            n11 = com.geetest.sdk.dialog.views.a.i((a)object);
            com.geetest.sdk.dialog.views.a.n = n14 /= n11;
        }
        object = com.geetest.sdk.dialog.views.a.g(this.a.a);
        if (object != null && (object = com.geetest.sdk.dialog.views.a.g(this.a.a).getLayoutParams()) != null) {
            object = com.geetest.sdk.dialog.views.a.g(this.a.a).getLayoutParams();
            ((ViewGroup.LayoutParams)object).width = n12 = com.geetest.sdk.dialog.views.a.n;
            ((ViewGroup.LayoutParams)object).height = n12 = com.geetest.sdk.dialog.views.a.o;
            object2 = com.geetest.sdk.dialog.views.a.g(this.a.a);
            object2.setLayoutParams((ViewGroup.LayoutParams)object);
        }
        if ((object = com.geetest.sdk.dialog.views.a.b(this.a.a)) != null) {
            com.geetest.sdk.utils.d.a = n10;
            object = this.a;
            object = ((a$b)object).a;
            object = com.geetest.sdk.dialog.views.a.b((a)object);
            try {
                ((d)((Object)object)).show();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        com.geetest.sdk.utils.d.a = false;
    }
}

