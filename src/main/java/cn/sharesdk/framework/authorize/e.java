/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.authorize.SSOListener;
import cn.sharesdk.framework.authorize.a;
import cn.sharesdk.framework.authorize.d;

public abstract class e {
    public d a;
    public int b;
    public SSOListener c;

    public e(d object) {
        this.a = object;
        this.c = object = ((a)object).a().getSSOListener();
    }

    public abstract void a();

    public void a(int n10) {
        this.b = n10;
    }

    public void a(int n10, int n11, Intent intent) {
    }

    public void a(Intent intent) {
    }
}

