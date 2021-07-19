/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.voice;

import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.voice.RecordUseCase$1;
import com.zhiyun.editorsdk.voice.VoiceUseCases;
import d.v.e.l.s1;
import d.v.h.e.c;
import d.v.h.h.a$a;
import d.v.h.h.b;
import d.v.v.q.h;
import java.io.File;
import java.util.List;
import m.a.a;

public class RecordUseCase
extends CallChangeUseCase {
    private final c e;
    private final List f;

    public RecordUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public boolean A(int n10, Long l10) {
        Object object = this.p();
        boolean bl2 = d.v.j.b.h(n10, (List)object);
        if (bl2) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.c1(n10, l10) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l11 = 0x20000000L;
            this.b(bl3, l11);
        }
        return n10 != 0;
    }

    public boolean e(b b10) {
        return this.f(b10, true);
    }

    public boolean f(b b10, boolean bl2) {
        boolean bl3;
        boolean bl4 = VoiceUseCases.c(b10);
        if (bl4) {
            return false;
        }
        Object object = this.p();
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
        if (bl3 = (object = this.e).Z0(b10)) {
            this.a(bl2);
        }
        return bl3;
    }

    public boolean g(List list) {
        c c10 = this.e;
        boolean bl2 = c10.p2(list);
        if (bl2) {
            boolean bl3 = true;
            this.a(bl3);
        }
        return bl2;
    }

    public boolean h() {
        return this.e.N();
    }

    public boolean i(int n10, long l10) {
        Object object = this.p();
        boolean bl2 = VoiceUseCases.a(n10, l10, (List)object);
        if (bl2) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.v1(n10, l10) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l11 = 0x10000000L;
            this.b(bl3, l11);
        }
        return n10 != 0;
    }

    public boolean j(long l10) {
        return this.k(l10, true);
    }

    public boolean k(long l10, boolean bl2) {
        c c10;
        boolean bl3;
        boolean bl4 = this.s(l10);
        bl3 = bl4 && (bl3 = (c10 = this.e).S1(l10));
        if (bl3) {
            long l11 = 0x10000000L;
            this.b(bl2, l11);
        }
        return bl3;
    }

    public boolean l(int n10, long l10, long l11, long l12, boolean bl2) {
        return this.m(n10, l10, l11, l12, bl2, true);
    }

    public boolean m(int n10, long l10, long l11, long l12, boolean bl2, boolean bl3) {
        List list = this.p();
        int bl4 = n10;
        long l13 = l11;
        boolean bl5 = VoiceUseCases.b(n10, l11, l12, list);
        if (bl5) {
            return false;
        }
        c c10 = this.e;
        boolean bl6 = c10.V1(n10, l10, l11, l12, bl2);
        if (bl6) {
            l13 = 0x20000000L;
            this.b(bl3, l13);
        }
        return bl6;
    }

    public boolean n(int n10, long l10, long l11, boolean bl2) {
        List list = this.p();
        int n11 = n10;
        n11 = (int)(VoiceUseCases.b(n10, l10, l11, list) ? 1 : 0);
        if (n11 != 0) {
            return false;
        }
        c c10 = this.e;
        if ((n10 = (int)(c10.k1(n10, l10, l11, bl2) ? 1 : 0)) != 0) {
            boolean bl3 = true;
            long l12 = 0x20000000L;
            this.b(bl3, l12);
        }
        return n10 != 0;
    }

    public long o() {
        return h.x();
    }

    public List p() {
        return this.e.b2();
    }

    public boolean q() {
        long l10;
        boolean bl2;
        long l11;
        boolean bl3;
        long l12;
        Object object;
        block4: {
            b b10;
            Long l13;
            long l14;
            long l15;
            object = this.p();
            c c10 = this.e;
            l12 = c10.A();
            int bl4 = h.o();
            bl3 = false;
            int n10 = -1;
            if (bl4 != n10) {
                return false;
            }
            object = object.iterator();
            do {
                boolean bl5 = object.hasNext();
                bl2 = true;
                l10 = 500000L;
                if (!bl5) break block4;
            } while ((l15 = (l14 = l12 - (l11 = (l13 = (b10 = (b)object.next()).d()).longValue())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0);
            object = b10.d();
            l11 = (Long)object - l12;
            long l16 = l11 - l10;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 > 0) {
                bl3 = bl2;
            }
            return bl3;
        }
        object = this.e;
        l11 = object.i() - l12;
        long l17 = l11 - l10;
        Object object3 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object3 > 0) {
            bl3 = bl2;
        }
        return bl3;
    }

    public boolean r() {
        return this.e.D();
    }

    public boolean s(long l10) {
        return this.e.q2(l10);
    }

    public boolean t() {
        return this.u(true);
    }

    public boolean u(boolean bl2) {
        c c10 = this.e;
        boolean bl3 = c10.j2();
        if (bl3) {
            this.a(bl2);
        }
        return bl3;
    }

    public boolean v(int n10) {
        return this.w(n10, true);
    }

    public boolean w(int n10, boolean bl2) {
        Object object = this.p();
        boolean bl3 = d.v.j.b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.e;
        if ((n10 = (int)(object.o2(n10) ? 1 : 0)) != 0) {
            long l10 = 0x8000000L;
            this.b(bl2, l10);
        }
        return n10 != 0;
    }

    public void x(a$a a$a) {
        c c10 = this.e;
        RecordUseCase$1 recordUseCase$1 = new RecordUseCase$1(this, a$a);
        c10.C(recordUseCase$1);
    }

    public boolean y(File object, long l10) {
        boolean bl2 = s1.p((File)object);
        if (!bl2 && !(bl2 = s1.c0((File)object))) {
            Object[] objectArray = new Object[]{};
            a.i("dir not exist and create un success", objectArray);
            return false;
        }
        c c10 = this.e;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(object);
        stringBuilder.append("/");
        long l11 = System.currentTimeMillis();
        stringBuilder.append(l11);
        object = stringBuilder.toString();
        Long l12 = l10;
        return c10.B1((String)object, l12);
    }

    public boolean z() {
        c c10 = this.e;
        boolean bl2 = c10.a();
        if (bl2) {
            boolean bl3 = true;
            this.a(bl3);
        }
        return bl2;
    }
}

