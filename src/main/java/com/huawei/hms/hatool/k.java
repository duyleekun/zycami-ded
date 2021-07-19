/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.j;
import java.util.Map;

public class k {
    public boolean a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public j g;
    public String h;
    public Map i;
    public String j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public String p;
    public long q;

    public k() {
        boolean bl2;
        j j10;
        String string2;
        this.e = string2 = "";
        this.f = string2;
        this.g = j10 = new j();
        this.h = string2;
        this.j = string2;
        this.k = 10;
        this.l = 7;
        this.m = bl2 = true;
        this.n = bl2;
        this.o = false;
        this.q = 0L;
    }

    public k(k k10) {
        boolean bl2;
        j j10;
        Object object = "";
        this.e = object;
        this.f = object;
        this.g = j10 = new j();
        this.h = object;
        this.j = object;
        this.k = 10;
        this.l = 7;
        this.m = bl2 = true;
        this.n = bl2;
        this.o = false;
        this.q = 0L;
        this.g = object = k10.g;
        boolean bl3 = k10.a;
        this.b(bl3);
        object = k10.c;
        this.a((String)object);
        object = k10.d;
        this.b((String)object);
        object = k10.e;
        this.e((String)object);
        object = k10.f;
        this.g((String)object);
        object = k10.h;
        this.d((String)object);
        object = k10.j;
        this.f((String)object);
        boolean bl4 = k10.b;
        this.c(bl4);
        int n10 = k10.k;
        this.a(n10);
        int n11 = k10.l;
        this.b(n11);
        boolean bl5 = k10.m;
        this.d(bl5);
        boolean bl6 = k10.n;
        this.a(bl6);
        boolean bl7 = k10.o;
        this.e(bl7);
        object = k10.i;
        this.a((Map)object);
        object = k10.p;
        this.c((String)object);
        long l10 = k10.q;
        this.a(l10);
    }

    public void a(int n10) {
        this.k = n10;
    }

    public void a(long l10) {
        this.q = l10;
    }

    public void a(String string2) {
        this.c = string2;
    }

    public void a(Map map) {
        this.i = map;
    }

    public void a(boolean bl2) {
        this.n = bl2;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.k;
    }

    public void b(int n10) {
        this.l = n10;
    }

    public void b(String string2) {
        this.d = string2;
    }

    public void b(boolean bl2) {
        this.a = bl2;
    }

    public void c(String string2) {
        this.p = string2;
    }

    public void c(boolean bl2) {
        this.b = bl2;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.l;
    }

    public void d(String string2) {
        this.h = string2;
    }

    public void d(boolean bl2) {
        this.m = bl2;
    }

    public void e(String string2) {
        this.e = string2;
    }

    public void e(boolean bl2) {
        this.o = bl2;
    }

    public boolean e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public void f(String string2) {
        this.j = string2;
    }

    public void g(String string2) {
        this.f = string2;
    }

    public boolean g() {
        return this.m;
    }

    public String h() {
        return this.d;
    }

    public boolean i() {
        return this.o;
    }

    public j j() {
        return this.g;
    }

    public Map k() {
        return this.i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.h;
    }

    public String o() {
        return this.e;
    }

    public String p() {
        return this.j;
    }

    public String q() {
        return this.f;
    }
}

