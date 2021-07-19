/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package com.geetest.sdk.views;

import android.app.Activity;
import com.geetest.sdk.a$d;
import com.geetest.sdk.views.GT3GeetestButton;
import com.geetest.sdk.views.GT3GeetestButton$b$a;
import com.geetest.sdk.views.GT3GeetestButton$b$b;
import com.geetest.sdk.views.GT3GeetestButton$b$c;
import com.geetest.sdk.views.GT3GeetestButton$b$d;
import com.geetest.sdk.views.GT3GeetestButton$b$e;
import com.geetest.sdk.views.GT3GeetestButton$b$f;
import com.geetest.sdk.views.GT3GeetestButton$b$g;

public class GT3GeetestButton$b
implements a$d {
    public final /* synthetic */ GT3GeetestButton a;

    public GT3GeetestButton$b(GT3GeetestButton gT3GeetestButton) {
        this.a = gT3GeetestButton;
    }

    public void a() {
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = true;
        GT3GeetestButton.access$902(gT3GeetestButton, bl2);
        gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
        boolean bl3 = gT3GeetestButton.isFinishing();
        if (!bl3 && (gT3GeetestButton = GT3GeetestButton.access$300(this.a)) != null) {
            gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            GT3GeetestButton$b$e gT3GeetestButton$b$e = new GT3GeetestButton$b$e(this);
            gT3GeetestButton.runOnUiThread(gT3GeetestButton$b$e);
        }
    }

    public void a(String string2, String string3) {
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = true;
        GT3GeetestButton.access$002(gT3GeetestButton, bl2);
        GT3GeetestButton.access$902(this.a, bl2);
        gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
        boolean bl3 = gT3GeetestButton.isFinishing();
        if (!bl3 && (gT3GeetestButton = GT3GeetestButton.access$300(this.a)) != null) {
            gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            GT3GeetestButton$b$g gT3GeetestButton$b$g = new GT3GeetestButton$b$g(this, string3, string2);
            gT3GeetestButton.runOnUiThread(gT3GeetestButton$b$g);
        }
    }

    public void b() {
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = true;
        GT3GeetestButton.access$602(gT3GeetestButton, bl2);
        GT3GeetestButton.access$700(this.a).setClickable(bl2);
    }

    public void c() {
        Activity activity = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
        boolean bl2 = activity.isFinishing();
        if (!bl2 && (activity = GT3GeetestButton.access$300(this.a)) != null) {
            activity = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            GT3GeetestButton$b$d gT3GeetestButton$b$d = new GT3GeetestButton$b$d(this);
            activity.runOnUiThread((Runnable)gT3GeetestButton$b$d);
        }
    }

    public void d() {
        GT3GeetestButton gT3GeetestButton = this.a;
        GT3GeetestButton$b$c gT3GeetestButton$b$c = null;
        GT3GeetestButton.access$902(gT3GeetestButton, false);
        GT3GeetestButton.access$202(this.a, false);
        gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
        boolean bl2 = gT3GeetestButton.isFinishing();
        if (!bl2 && (gT3GeetestButton = GT3GeetestButton.access$300(this.a)) != null) {
            gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            gT3GeetestButton$b$c = new GT3GeetestButton$b$c(this);
            gT3GeetestButton.runOnUiThread(gT3GeetestButton$b$c);
        }
    }

    public void e() {
        GT3GeetestButton.access$602(this.a, false);
        GT3GeetestButton.access$700(this.a).setClickable(false);
    }

    public void f() {
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = true;
        GT3GeetestButton.access$002(gT3GeetestButton, bl2);
        GT3GeetestButton.access$202(this.a, bl2);
        GT3GeetestButton.access$1202(this.a, bl2);
    }

    public void g() {
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = true;
        GT3GeetestButton.access$002(gT3GeetestButton, bl2);
        GT3GeetestButton.access$902(this.a, bl2);
    }

    public void h() {
        Activity activity = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
        boolean bl2 = activity.isFinishing();
        if (!bl2 && (activity = GT3GeetestButton.access$300(this.a)) != null) {
            activity = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            GT3GeetestButton$b$f gT3GeetestButton$b$f = new GT3GeetestButton$b$f(this);
            activity.runOnUiThread((Runnable)gT3GeetestButton$b$f);
        }
    }

    public void i() {
        GT3GeetestButton.access$002(this.a, false);
    }

    public void j() {
        GT3GeetestButton.access$002(this.a, true);
        GT3GeetestButton gT3GeetestButton = this.a;
        boolean bl2 = GT3GeetestButton.access$100(gT3GeetestButton);
        Runnable runnable = null;
        if (bl2) {
            GT3GeetestButton.access$202(this.a, false);
            gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            bl2 = gT3GeetestButton.isFinishing();
            if (!bl2 && (gT3GeetestButton = GT3GeetestButton.access$300(this.a)) != null) {
                gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
                runnable = new GT3GeetestButton$b$a(this);
                gT3GeetestButton.runOnUiThread(runnable);
            }
        } else {
            GT3GeetestButton.access$202(this.a, false);
            gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
            bl2 = gT3GeetestButton.isFinishing();
            if (!bl2 && (gT3GeetestButton = GT3GeetestButton.access$300(this.a)) != null) {
                gT3GeetestButton = GT3GeetestButton.access$400(GT3GeetestButton.access$300(this.a));
                runnable = new GT3GeetestButton$b$b(this);
                gT3GeetestButton.runOnUiThread(runnable);
            }
        }
    }
}

