/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.dialog.views;

import com.geetest.sdk.au;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.dialog.views.a$b;
import com.geetest.sdk.utils.l;

public class a$b$a
implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;
    public final /* synthetic */ a$b c;

    public a$b$a(a$b b10, int n10, String string2) {
        this.c = b10;
        this.a = n10;
        this.b = string2;
    }

    public void run() {
        int n10;
        Object object = com.geetest.sdk.dialog.views.a.f(this.c.a);
        if (object != null && (object = com.geetest.sdk.dialog.views.a.f(this.c.a).getListener()) != null) {
            object = com.geetest.sdk.dialog.views.a.f(this.c.a).getListener();
            n10 = this.a;
            object.onReceiveCaptchaCode(n10);
        } else {
            object = com.geetest.sdk.dialog.views.a.e();
            String string2 = "configBean is null !";
            l.b((String)object, string2);
        }
        object = com.geetest.sdk.dialog.views.a.a(this.c.a);
        if (object != null) {
            int n11 = this.a;
            n10 = 1;
            if (n11 == n10) {
                object = com.geetest.sdk.dialog.views.a.a(this.c.a);
                String string3 = this.b;
                ((au)object).a(n10 != 0, string3);
            } else {
                object = this.c.a;
                ((a)object).c();
            }
        }
    }
}

