/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.frame;

import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.h.e.c;
import d.v.h.e.d;
import d.v.j.b;
import java.util.List;

public class FrameSizeUseCase
implements IUseCase {
    private final c c;
    private final List d;

    public FrameSizeUseCase(c c10, List list) {
        this.c = c10;
        this.d = list;
    }

    private boolean d(int n10, boolean bl2, int n11, boolean bl3) {
        boolean bl4 = b.i(n11);
        if (bl4) {
            return false;
        }
        if (bl2) {
            return this.c.A0(n11, bl3);
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.c.T(n10, n11, bl3);
    }

    private boolean h(int n10, boolean bl2, int n11, boolean bl3) {
        boolean bl4 = b.m(n11);
        if (bl4) {
            return false;
        }
        if (bl2) {
            return this.c.T0(n11, bl3);
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.c.K1(n10, n11, bl3);
    }

    private int q(int n10, boolean bl2) {
        if (bl2) {
            return this.c.n0();
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return 0;
        }
        return ((d)this.d.get(n10)).y();
    }

    private int t(int n10, boolean bl2) {
        if (bl2) {
            return this.c.g0();
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return 0;
        }
        return ((d)this.d.get(n10)).A();
    }

    public boolean A(boolean bl2) {
        return this.c.J1(bl2);
    }

    public boolean a(int n10) {
        boolean bl2 = b.g(n10);
        if (bl2) {
            return false;
        }
        return this.c.C1(n10);
    }

    public boolean b(int n10, int n11, boolean bl2) {
        return this.d(n10, false, n11, bl2);
    }

    public boolean c(int n10, boolean bl2) {
        return this.d(-1, true, n10, bl2);
    }

    public void e(int n10, int n11, int n12) {
        this.c.L0(n10, n11, n12);
    }

    public boolean f(int n10, int n11, boolean bl2) {
        return this.h(n10, false, n11, bl2);
    }

    public boolean g(int n10, boolean bl2) {
        return this.h(-1, true, n10, bl2);
    }

    public void i() {
        this.c.D0();
    }

    public void j(int n10) {
        this.c.Q1(n10);
    }

    public int k() {
        return this.c.e2();
    }

    public int l(int n10) {
        return this.c.l1(n10);
    }

    public int m(int n10) {
        return this.c.n1(n10);
    }

    public float n(int n10) {
        return this.c.L1(n10);
    }

    public int o() {
        return this.q(-1, true);
    }

    public int p(int n10) {
        return this.q(n10, false);
    }

    public int r() {
        return this.t(-1, true);
    }

    public int s(int n10) {
        return this.t(n10, false);
    }

    public boolean u(int n10, int n11, boolean bl2) {
        List list = this.d;
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return false;
        }
        return this.c.O1(n10, n11, bl2);
    }

    public void v() {
        this.c.w1();
    }

    public boolean w(int n10, int n11, boolean bl2) {
        List list = this.d;
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return false;
        }
        return this.c.K0(n10, n11, bl2);
    }

    public void x(int n10, float f10) {
        this.c.E0(n10, f10);
    }

    public void y(int n10, float f10, float f11) {
        this.c.M0(n10, f10, f11);
    }

    public boolean z(boolean bl2) {
        return this.c.j1(bl2);
    }
}

