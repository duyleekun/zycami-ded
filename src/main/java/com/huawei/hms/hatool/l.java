/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

public class l {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public int h = 5;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public Context n;

    public String a() {
        return this.d;
    }

    public void a(Context context) {
        this.n = context;
    }

    public void a(String string2) {
        this.j = string2;
    }

    public String b() {
        return this.e;
    }

    public void b(String string2) {
        this.e = string2;
    }

    public String c() {
        return this.c;
    }

    public void c(String string2) {
        this.i = string2;
    }

    public String d() {
        return this.i;
    }

    public void d(String string2) {
        this.m = string2;
    }

    public String e() {
        return this.j;
    }

    public void e(String string2) {
        this.a = string2;
    }

    public int f() {
        return this.h;
    }

    public void f(String string2) {
        this.g = string2;
    }

    public String g() {
        return this.m;
    }

    public void g(String string2) {
        this.f = string2;
    }

    public Context h() {
        return this.n;
    }

    public void h(String string2) {
        this.b = string2;
    }

    public String i() {
        return this.a;
    }

    public void i(String string2) {
        this.k = string2;
    }

    public int j() {
        return this.h * 2;
    }

    public void j(String string2) {
        this.l = string2;
    }

    public String k() {
        String string2 = this.g;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return this.f;
        }
        return this.g;
    }

    public void k(String string2) {
    }

    public String l() {
        return this.f;
    }

    public void l(String string2) {
        this.d = string2;
    }

    public String m() {
        return this.b;
    }

    public void m(String string2) {
        this.c = string2;
    }

    public String n() {
        return this.k;
    }

    public String o() {
        return this.l;
    }
}

