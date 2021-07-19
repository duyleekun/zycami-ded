/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk.decoration;

import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.decoration.DecorationUseCases;
import com.zhiyun.editorsdk.decoration.StickerUseCase$1;
import com.zhiyun.editorsdk.decoration.StickerUseCase$2;
import com.zhiyun.editorsdk.decoration.StickerUseCase$3;
import d.v.h.e.c;
import d.v.h.e.e;
import d.v.j.b;
import d.v.v.q.h;
import java.util.Collections;
import java.util.List;
import m.a.a;

public class StickerUseCase
extends CallChangeUseCase {
    private final c e;
    private final List f;

    public StickerUseCase(c c10, List list) {
        this.e = c10;
        this.f = list;
    }

    public void e(d.v.h.d.c c10, e e10) {
        this.f(c10, e10, true);
    }

    public void f(d.v.h.d.c objectArray, e e10, boolean bl2) {
        Object object;
        Object object2;
        Object object3;
        if (!(objectArray == null || (object3 = objectArray.g()) != (object2 = DecorationType.IMAGE_PASTER) && (object3 = objectArray.g()) != (object2 = DecorationType.GIF_PASTER) || (object = b.b((String)(object3 = objectArray.x()))))) {
            long l10;
            object3 = objectArray.e();
            object = h.m0((Long)object3);
            if (object) {
                objectArray = new Object[]{};
                String string2 = "\u5f53\u524d\u65f6\u95f4\u70b9\u5df2\u5b58\u5728\u8d34\u7eb8\u5bf9\u8c61";
                a.i(string2, objectArray);
                if (e10 != null) {
                    e10.a();
                }
                return;
            }
            long l11 = objectArray.i();
            long l12 = l11 - (l10 = 0L);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object) {
                long l13;
                long l14;
                DecorationType decorationType;
                DecorationType decorationType2;
                object3 = this.i();
                object2 = objectArray.e();
                long l15 = (Long)object2;
                l11 = DecorationUseCases.c((List)object3, l15);
                l15 = objectArray.i();
                long l16 = l15 - l10;
                Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object4 > 0) {
                    l15 = objectArray.i();
                    l11 = Math.min(l15, l11);
                }
                if ((decorationType2 = objectArray.g()) != (decorationType = DecorationType.GIF_PASTER) || (l14 = (l13 = (l15 = objectArray.i()) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                    objectArray.p(l11);
                }
            }
            object3 = this.e;
            object2 = new StickerUseCase$1(this, bl2, e10);
            object3.k0((d.v.h.d.c)objectArray, (e)object2);
            return;
        }
        if (e10 != null) {
            e10.a();
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
        this.e.d2(n10);
        this.b(bl2, 65536L);
    }

    public List i() {
        return this.e.X1();
    }

    public List j(DecorationType decorationType) {
        int[] nArray = StickerUseCase$3.a;
        int n10 = decorationType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                return Collections.emptyList();
            }
            return this.e.f0();
        }
        return this.e.R0();
    }

    public void k() {
        this.e.l2();
    }

    public void l(boolean bl2) {
        int n10;
        List list = this.i();
        while ((n10 = list.size()) > 0) {
            DecorationType decorationType = ((d.v.h.d.c)list.get(0)).g();
            this.n(0, decorationType, bl2);
        }
    }

    public void m(int n10) {
        this.o(n10, true);
    }

    public void n(int n10, DecorationType object, boolean bl2) {
        Object object2 = this.j((DecorationType)((Object)object));
        Object object3 = b.h(n10, (List)object2);
        if (object3 != 0) {
            return;
        }
        object2 = StickerUseCase$3.a;
        Object object4 = ((Enum)object).ordinal();
        object3 = 1;
        if ((object4 = (Object)object2[object4]) != object3) {
            object3 = 2;
            if (object4 == object3) {
                object = this.e;
                object.f2(n10);
                this.a(bl2);
            }
        } else {
            object = this.e;
            object.Z(n10);
            this.a(bl2);
        }
    }

    public void o(int n10, boolean bl2) {
        List list = this.i();
        boolean bl3 = b.h(n10, list);
        if (bl3) {
            return;
        }
        this.e.z0(n10);
        this.b(bl2, 32768L);
    }

    public void p(int n10, d.v.h.d.c c10, e e10) {
        Object object = this.i();
        boolean bl2 = b.h(n10, (List)object);
        if (!bl2) {
            object = this.e;
            object.z0(n10);
        }
        this.e(c10, e10);
    }

    public void q() {
        this.e.t0();
    }

    public void r(int n10, d.v.h.d.c c10, e e10, boolean bl2) {
        Object object = this.i();
        boolean bl3 = b.h(n10, (List)object);
        if (!bl3 && c10 != null) {
            object = this.e;
            StickerUseCase$2 stickerUseCase$2 = new StickerUseCase$2(this, bl2, e10);
            object.x0(c10, n10, stickerUseCase$2);
        }
    }

    public void s(int n10, Long l10, long l11) {
        this.t(n10, l10, l11, true);
    }

    public void t(int n10, Long l10, long l11, boolean bl2) {
        long l12;
        long l13;
        Object object = this.i();
        int n11 = b.h(n10, (List)object);
        if (n11 == 0 && (n11 = (l13 = l11 - (l12 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(",index:");
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(",attachTime:");
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(",period:");
            ((StringBuilder)object).append(l11);
            object = ((StringBuilder)object).toString();
            Object[] objectArray = new Object[]{};
            a.b((String)object, objectArray);
            object = this.e;
            object.I0(n10, l10, l11);
            long l14 = 131072L;
            this.b(bl2, l14);
        }
    }
}

