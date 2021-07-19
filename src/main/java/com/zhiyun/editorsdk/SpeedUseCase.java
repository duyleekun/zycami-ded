/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk;

import com.zhiyun.editorsdk.CallChangeUseCase;
import d.v.h.e.c;
import d.v.h.e.d;
import d.v.j.b;
import java.util.List;

public class SpeedUseCase
extends CallChangeUseCase {
    private c e;
    private List f;

    public SpeedUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public boolean e(int n10, String string2) {
        boolean bl2 = true;
        return this.g(n10, string2, bl2, bl2);
    }

    public boolean f(int n10, String string2, boolean bl2) {
        return this.g(n10, string2, bl2, true);
    }

    public boolean g(int n10, String string2, boolean bl2, boolean bl3) {
        Object object = this.f;
        boolean bl4 = b.h(n10, (List)object);
        if (bl4) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.N0(n10, string2, bl2) ? 1 : 0)) != 0) {
            this.a(bl3);
        }
        return n10 != 0;
    }

    public String h(int n10) {
        List list = this.f;
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return null;
        }
        return this.e.k2(n10);
    }

    public double i(int n10) {
        List list = this.f;
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return -1.0;
        }
        return ((d)this.f.get(n10)).I();
    }

    public double j(int n10) {
        List list = this.f;
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return -1.0;
        }
        return this.e.m1(n10);
    }

    public boolean k(double d10, int n10) {
        return this.l(d10, n10, true);
    }

    public boolean l(double d10, int n10, boolean bl2) {
        Object object = this.f;
        boolean bl3 = b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.e;
        boolean bl4 = object.o1(n10, d10);
        if (bl4) {
            this.a(bl2);
        }
        return bl4;
    }
}

