/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.editorsdk.decoration;

import android.text.TextUtils;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import com.zhiyun.editorsdk.decoration.TextUseCase$1;
import d.v.h.d.d;
import d.v.h.d.d$a;
import d.v.h.e.c;
import d.v.h.e.e;
import d.v.j.b;
import d.v.v.q.h;
import java.util.List;
import m.a.a;

public class TextUseCase
extends CallChangeUseCase {
    private final c e;
    private final List f;

    public TextUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public void e(d d10) {
        this.f(d10, true);
    }

    public void f(d objectArray, boolean bl2) {
        Object object;
        Object object2;
        if (objectArray != null && ((object2 = objectArray.g()) == (object = DecorationType.FONT) || (object2 = objectArray.g()) == (object = DecorationType.CAPTION))) {
            long l10;
            object2 = objectArray.e();
            boolean bl3 = h.k0((Long)object2);
            if (bl3) {
                objectArray = new Object[]{};
                a.i("\u5f53\u524d\u65f6\u95f4\u70b9\u5df2\u5b58\u5728\u6587\u5b57\u5bf9\u8c61", objectArray);
                return;
            }
            object2 = this.i();
            object = objectArray.e();
            long l11 = (Long)object;
            long l12 = DecorationUseCases.c((List)object2, l11);
            long l13 = objectArray.i();
            long l14 = l13 - (l10 = 0L);
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 == false) {
                objectArray.p(l12);
            }
            object2 = this.e;
            object2.u0((d)objectArray);
            this.a(bl2);
        }
    }

    public void g(int n10) {
        this.h(n10, true);
    }

    public void h(int n10, boolean bl2) {
        List list = this.i();
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return;
        }
        this.e.i2(n10);
        this.b(bl2, 0x100000L);
    }

    public List i() {
        return this.e.Q0();
    }

    public void j() {
        this.e.Y();
    }

    public void k(boolean bl2) {
        int n10;
        List list = this.i();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            this.m(i10, bl2);
        }
    }

    public void l(int n10) {
        this.m(n10, true);
    }

    public void m(int n10, boolean bl2) {
        List list = this.i();
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return;
        }
        this.e.c0(n10);
        this.b(bl2, 524288L);
    }

    public void n(int n10, d d10) {
        Object object = this.i();
        boolean bl2 = b.h(n10, (List)object);
        if (bl2) {
            return;
        }
        object = this.e;
        object.c0(n10);
        if (d10 != null) {
            this.e(d10);
        }
    }

    public void o() {
        this.e.u1();
    }

    public void p(int n10, d$a d$a) {
        this.q(n10, d$a, true);
    }

    public void q(int n10, d$a d$a, boolean bl2) {
        List list = this.e.Q0();
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return;
        }
        this.e.f(n10, d$a);
        this.b(bl2, 0x200000L);
    }

    public void r(int n10, int n11) {
        this.s(n10, n11, true);
    }

    public void s(int n10, int n11, boolean bl2) {
        List list = this.e.Q0();
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return;
        }
        this.e.c(n10, n11);
        this.b(bl2, 0x200000L);
    }

    public void t(int n10, String string2) {
        this.u(n10, string2, true);
    }

    public void u(int n10, String string2, boolean bl2) {
        Object object = this.e.Q0();
        boolean bl3 = b.h(n10, (List)object);
        if (!bl3 && !(bl3 = TextUtils.isEmpty((CharSequence)string2))) {
            object = this.e;
            object.v(n10, string2);
            long l10 = 0x200000L;
            this.b(bl2, l10);
        }
    }

    public void v(int n10, String string2, int n11) {
        this.w(n10, string2, n11, true);
    }

    public void w(int n10, String string2, int n11, boolean bl2) {
        Object object = this.e.Q0();
        boolean bl3 = b.h(n10, (List)object);
        if (!bl3 && n11 > 0) {
            object = this.e;
            object.d(n10, string2, n11);
            long l10 = 0x200000L;
            this.b(bl2, l10);
        }
    }

    public void x(int n10, d d10, e e10, boolean bl2) {
        Object object = this.e.Q0();
        boolean bl3 = b.h(n10, (List)object);
        if (!bl3 && d10 != null) {
            object = this.e;
            TextUseCase$1 textUseCase$1 = new TextUseCase$1(this, bl2, e10);
            object.f1(d10, n10, textUseCase$1);
        }
    }

    public void y(int n10, Long l10, long l11) {
        this.z(n10, l10, l11, true);
    }

    public void z(int n10, Long l10, long l11, boolean bl2) {
        long l12;
        long l13;
        Object object = this.i();
        int n11 = b.h(n10, (List)object);
        if (n11 == 0 && (n11 = (l13 = l11 - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
            object = this.e;
            object.q0(n10, l10, l11);
            long l14 = 0x200000L;
            this.b(bl2, l14);
        }
    }
}

