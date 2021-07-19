/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.voice.VoiceUseCases;
import d.v.h.e.c;
import d.v.j.b;
import java.util.List;

public class MusicUseCase
extends CallChangeUseCase {
    private final c e;
    private final List f;

    public MusicUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public boolean e(d.v.h.h.b b10) {
        return this.f(b10, true);
    }

    public boolean f(d.v.h.h.b b10, boolean bl2) {
        boolean bl3;
        boolean bl4 = VoiceUseCases.c(b10);
        if (bl4) {
            return false;
        }
        Object object = this.m();
        Long l10 = b10.d();
        long l11 = l10;
        String string2 = b10.k();
        boolean bl5 = true;
        long l12 = VoiceUseCases.e((List)object, l11, string2, bl5);
        long l13 = b10.f();
        long l14 = b10.m();
        long l15 = (l13 -= l14) - l12;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 > 0) {
            l13 = b10.m() + l12;
            b10.r(l13);
        }
        if (bl3 = (object = this.e).l(b10)) {
            this.a(bl2);
        }
        return bl3;
    }

    public boolean g(int n10, long l10) {
        Object object = this.m();
        boolean bl2 = VoiceUseCases.a(n10, l10, (List)object);
        if (bl2) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.L(n10, l10) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l11 = 0x1000000L;
            this.b(bl3, l11);
        }
        return n10 != 0;
    }

    public boolean h(long l10) {
        return this.i(l10, true);
    }

    public boolean i(long l10, boolean bl2) {
        c c10;
        boolean bl3;
        boolean bl4 = this.o(l10);
        bl3 = bl4 && (bl3 = (c10 = this.e).B(l10));
        if (bl3) {
            long l11 = 0x1000000L;
            this.b(bl2, l11);
        }
        return bl3;
    }

    public boolean j(int n10, long l10, long l11, long l12, boolean bl2) {
        return this.k(n10, l10, l11, l12, bl2, true);
    }

    public boolean k(int n10, long l10, long l11, long l12, boolean bl2, boolean bl3) {
        List list = this.m();
        int bl4 = n10;
        long l13 = l11;
        boolean bl5 = VoiceUseCases.b(n10, l11, l12, list);
        if (bl5) {
            return false;
        }
        c c10 = this.e;
        boolean bl6 = c10.m(n10, l10, l11, l12, bl2);
        if (bl6) {
            l13 = 0x2000000L;
            this.b(bl3, l13);
        }
        return bl6;
    }

    public boolean l(int n10, long l10, long l11, boolean bl2) {
        List list = this.m();
        int n11 = n10;
        n11 = (int)(VoiceUseCases.b(n10, l10, l11, list) ? 1 : 0);
        if (n11 != 0) {
            return false;
        }
        c c10 = this.e;
        if ((n10 = (int)(c10.r(n10, l10, l11, bl2) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l12 = 0x2000000L;
            this.b(bl3, l12);
        }
        return n10 != 0;
    }

    public List m() {
        return this.e.p();
    }

    public boolean n(int n10, long l10) {
        Object object = this.m();
        boolean bl2 = VoiceUseCases.a(n10, l10, (List)object);
        if (bl2) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.o(n10, l10) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            this.a(bl3);
        }
        return n10 != 0;
    }

    public boolean o(long l10) {
        return this.e.g(l10);
    }

    public boolean p() {
        return this.q(true);
    }

    public boolean q(boolean bl2) {
        c c10 = this.e;
        boolean bl3 = c10.E();
        if (bl3) {
            this.a(bl2);
        }
        return bl3;
    }

    public boolean r(int n10) {
        return this.s(n10, true);
    }

    public boolean s(int n10, boolean bl2) {
        Object object = this.m();
        boolean bl3 = b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.y(n10) ? 1 : 0)) != 0) {
            long l10 = 0x800000L;
            this.b(bl2, l10);
        }
        return n10 != 0;
    }

    public boolean t(int n10, d.v.h.h.b b10) {
        return this.u(n10, b10, true);
    }

    public boolean u(int n10, d.v.h.h.b b10, boolean bl2) {
        Object object = this.m();
        boolean bl3 = b.h(n10, (List)object);
        boolean bl4 = false;
        if (!bl3) {
            object = this.e;
            n10 = (int)(object.y(n10) ? 1 : 0);
        } else {
            n10 = 0;
        }
        boolean bl5 = this.e(b10);
        if (n10 != 0 || bl5) {
            this.a(bl2);
        }
        if (n10 != 0 && bl5) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean v(int n10, Long l10) {
        Object object = this.m();
        boolean bl2 = b.h(n10, (List)object);
        if (bl2) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.x(n10, l10) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l11 = 0x2000000L;
            this.b(bl3, l11);
        }
        return n10 != 0;
    }
}

