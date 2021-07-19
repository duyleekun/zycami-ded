/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.a$d;
import com.geetest.sdk.bb$a;
import com.geetest.sdk.g;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.model.beans.c;

public abstract class bb {
    private int a;
    private a b;
    private Context c;
    private GT3ConfigBean d;
    private g e;
    private b f;
    private long g;
    private a$d h;
    private int i;
    private c j;
    public bb$a k;

    public bb(int n10) {
        long l10;
        int n11;
        this.a = n11 = 1;
        this.i = n11;
        this.a = n10;
        this.g = l10 = System.currentTimeMillis();
    }

    public a$d a() {
        return this.h;
    }

    public void a(int n10) {
        this.i = n10;
    }

    public void a(Context context) {
        this.c = context;
    }

    public void a(GT3ConfigBean gT3ConfigBean) {
        this.d = gT3ConfigBean;
    }

    public void a(g g10) {
        this.e = g10;
    }

    public void a(a a10) {
        this.b = a10;
    }

    public void a(b b10) {
        this.f = b10;
    }

    public void a(c c10) {
        this.j = c10;
    }

    public GT3ConfigBean b() {
        return this.d;
    }

    public void b(int n10) {
        this.a = n10;
    }

    public Context c() {
        return this.c;
    }

    public b d() {
        return this.f;
    }

    public g e() {
        return this.e;
    }

    public a f() {
        return this.b;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.a;
    }

    public c i() {
        return this.j;
    }

    public long j() {
        return this.g;
    }

    public void setButtonListener(a$d a$d) {
        this.h = a$d;
    }
}

