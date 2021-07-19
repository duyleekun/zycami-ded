/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import com.zhiyun.editorsdk.fundation.IUseCase;
import d.v.h.e.c;
import d.v.h.e.d;
import d.v.j.b;
import java.util.List;

public class VoiceUseCase
implements IUseCase {
    private final c c;
    private final List d;

    public VoiceUseCase(c c10, List list) {
        this.c = c10;
        this.d = list;
    }

    private boolean c(int n10, boolean bl2, float f10) {
        boolean bl3 = b.k(f10);
        if (bl3) {
            return false;
        }
        if (bl2) {
            return this.c.U(f10);
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.c.i0(n10, f10);
    }

    private float i(int n10, boolean bl2) {
        if (bl2) {
            return this.c.u();
        }
        List list = this.d;
        bl2 = b.h(n10, list);
        if (bl2) {
            return 1.0f;
        }
        return ((d)this.d.get(n10)).O();
    }

    public boolean a(float f10) {
        return this.c(-1, true, f10);
    }

    public boolean b(int n10, float f10) {
        return this.c(n10, false, f10);
    }

    public boolean d(int n10, float f10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (!bl2 && !(bl2 = b.k(f10))) {
            return this.c.h2(n10, f10);
        }
        return false;
    }

    public boolean e(int n10, float f10) {
        List list = this.c.b2();
        boolean bl2 = b.h(n10, list);
        if (!bl2 && !(bl2 = b.k(f10))) {
            return this.c.h0(n10, f10);
        }
        return false;
    }

    public float f() {
        return this.c.u();
    }

    public float g() {
        return this.i(-1, true);
    }

    public float h(int n10) {
        return this.i(n10, false);
    }

    public long j(int n10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return 0L;
        }
        return this.c.Z1(n10);
    }

    public long k(int n10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return 0L;
        }
        return this.c.d1(n10);
    }

    public float l(int n10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return 1.0f;
        }
        return ((d.v.h.h.b)this.c.p().get(n10)).n();
    }

    public float m(int n10) {
        List list = this.c.b2();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return 1.0f;
        }
        return ((d.v.h.h.b)this.c.b2().get(n10)).n();
    }

    public boolean n() {
        return this.c.J();
    }

    public boolean o(int n10, boolean bl2) {
        return this.c.R1(n10, bl2);
    }

    public boolean p(boolean bl2) {
        return this.c.s1(bl2);
    }

    public void q(int n10, long l10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return;
        }
        this.c.V(n10, l10);
    }

    public void r(int n10, long l10) {
        List list = this.c.p();
        boolean bl2 = b.h(n10, list);
        if (bl2) {
            return;
        }
        this.c.y1(n10, l10);
    }

    public boolean s(boolean bl2) {
        return this.c.Y0(bl2);
    }
}

