/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editorsdk;

import com.zhiyun.editorsdk.MainUseCase$1;
import com.zhiyun.editorsdk.fundation.EditorUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCaseEditorImpl;
import com.zhiyun.editorsdk.fundation.IUseCase;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editorsdk.fundation.UseCaseFactory;
import d.v.e.g.c;
import d.v.h.e.b;
import d.v.h.e.f;
import d.v.h.l.a;
import d.v.v.g.e;
import d.v.v.g.g;
import java.util.Collections;
import java.util.List;

public class MainUseCase {
    private d.v.h.e.c a;
    private boolean b;
    private List c;
    private UseCaseFactory d;
    private c e;
    private EditorUseCase f;
    private b g;

    public MainUseCase() {
        Object object = new MainUseCase$1(this);
        this.g = object;
        this.a = object = new e();
        object = this.g;
        this.f((b)object);
        d.v.h.e.c c10 = this.a;
        EditorUseCaseEditorImpl editorUseCaseEditorImpl = new EditorUseCaseEditorImpl(c10);
        this.f = object = new EditorUseCase(editorUseCaseEditorImpl);
    }

    public static /* synthetic */ boolean a(MainUseCase mainUseCase) {
        return mainUseCase.b;
    }

    public static /* synthetic */ boolean b(MainUseCase mainUseCase, boolean bl2) {
        mainUseCase.b = bl2;
        return bl2;
    }

    public static /* synthetic */ List c(MainUseCase mainUseCase, List list) {
        mainUseCase.c = list;
        return list;
    }

    public static /* synthetic */ d.v.h.e.c d(MainUseCase mainUseCase) {
        return mainUseCase.a;
    }

    public static /* synthetic */ void e(MainUseCase mainUseCase) {
        mainUseCase.y();
    }

    private void g(List object) {
        boolean bl2;
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            b b10 = (b)object.next();
            d.v.h.e.c c10 = this.a;
            c10.I(b10);
        }
    }

    private void y() {
        UseCaseFactory useCaseFactory;
        d.v.h.e.c c10 = this.a;
        List list = this.c;
        this.d = useCaseFactory = new UseCaseFactory(c10, list);
    }

    public boolean A(int n10, long l10, long l11, boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return false;
        }
        List list = this.c;
        bl3 = d.v.j.b.h(n10, list);
        if (bl3) {
            return false;
        }
        d.v.h.e.c c10 = this.a;
        if ((n10 = (int)(c10.Q(n10, l10, l11) ? 1 : 0)) != 0) {
            l10 = 8192L;
            this.l(bl2, l10);
        }
        return n10 != 0;
    }

    public void B() {
        this.f.i();
        this.a.release();
        d.v.h.l.a.a();
    }

    public void C(boolean bl2) {
        this.a.y0(bl2);
    }

    public c D() {
        return this.e;
    }

    public long E() {
        boolean bl2 = this.b;
        if (!bl2) {
            return 0L;
        }
        return this.a.A();
    }

    public int F() {
        boolean bl2 = this.b;
        if (!bl2) {
            return 0;
        }
        return this.a.b1();
    }

    public EditorUseCase G() {
        return this.f;
    }

    public List H() {
        boolean bl2 = this.b;
        if (!bl2) {
            return Collections.emptyList();
        }
        return this.c;
    }

    public long I(int n10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return 0L;
        }
        return this.a.G1(n10);
    }

    public long J() {
        boolean bl2 = this.b;
        if (!bl2) {
            return 0L;
        }
        return this.a.i();
    }

    public IUseCase K(Class clazz) {
        return this.d.a(clazz);
    }

    public String L() {
        return this.a.r0();
    }

    public void M(PlayerWrapperView playerWrapperView, List list) {
        this.O(playerWrapperView, list, null);
    }

    public void N(PlayerWrapperView frameLayout, List aArray, int n10, b object) {
        boolean bl2;
        if (frameLayout != null && !(bl2 = d.v.j.b.f((List)aArray))) {
            this.f((b)object);
            object = this.a;
            frameLayout = frameLayout.getPlayerView();
            bl2 = false;
            d.v.h.e.a[] aArray2 = new d.v.h.e.a[]{};
            aArray = aArray.toArray(aArray2);
            object.g2((f)frameLayout, aArray, n10);
        }
    }

    public void O(PlayerWrapperView playerWrapperView, List list, b b10) {
        this.N(playerWrapperView, list, -1, b10);
    }

    public boolean P(d.v.h.e.a[] aArray) {
        return this.a.x1(aArray);
    }

    public boolean Q() {
        boolean bl2 = this.b;
        if (!bl2) {
            return true;
        }
        return this.a.P0();
    }

    public boolean R() {
        return this.a.M();
    }

    public boolean S() {
        d.v.h.e.c c10;
        boolean bl2 = this.b;
        if (bl2 && (bl2 = (c10 = this.a).isPlaying())) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    public boolean T(int n10, long l10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        List list = this.c;
        bl2 = d.v.j.b.h(n10, list);
        if (bl2) {
            return false;
        }
        return this.a.p1(n10, l10);
    }

    public boolean U(long l10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        return this.a.H1(l10);
    }

    public boolean V(long l10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        return this.a.S(l10);
    }

    public void W() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.next();
    }

    public void X() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.pause();
    }

    public void Y() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.play();
    }

    public void Z() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.previous();
    }

    public void a0(b b10) {
        if (b10 == null) {
            return;
        }
        this.a.b(b10);
    }

    public boolean b0(int n10) {
        return this.c0(n10, true);
    }

    public boolean c0(int n10, boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return false;
        }
        Object object = this.c;
        bl3 = d.v.j.b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.a;
        if ((n10 = (int)(object.t(n10) ? 1 : 0)) != 0) {
            long l10 = 1024L;
            this.l(bl2, l10);
        }
        return n10 != 0;
    }

    public void d0(int n10, d.v.h.e.g g10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.e0(n10, g10);
    }

    public boolean e0(long l10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        return this.a.r1(l10);
    }

    public void f(b b10) {
        if (b10 == null) {
            return;
        }
        this.a.I(b10);
    }

    public void f0(c c10) {
        this.e = c10;
    }

    public void g0(boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return;
        }
        this.a.O0(bl2);
    }

    public boolean h(int n10, d.v.h.e.a a10, boolean bl2) {
        Object object;
        int n11 = this.b;
        if (n11 != 0 && n10 >= 0 && n10 <= (n11 = (object = this.c).size())) {
            object = this.a;
            if ((n10 = (int)(object.W1(n10, a10) ? 1 : 0)) != 0) {
                this.k(bl2);
            }
            return n10 != 0;
        }
        return false;
    }

    public void h0(int n10) {
        this.a.F1(n10);
    }

    public boolean i(d.v.h.e.a a10, boolean bl2) {
        int n10 = this.b;
        if (n10 == 0) {
            return false;
        }
        n10 = this.c.size();
        return this.h(n10, a10, bl2);
    }

    public void i0(long l10, long l11) {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.i1(l10, l11);
    }

    public void j(List list, List list2) {
        this.a.j0(list, list2);
    }

    public boolean j0(int n10, boolean bl2) {
        List list;
        int n11 = this.b;
        if (n11 != 0 && n10 >= 0 && n10 <= (n11 = (list = this.c).size())) {
            return this.a.T1(n10, bl2);
        }
        return false;
    }

    public void k(boolean bl2) {
        c c10 = this.e;
        if (c10 != null) {
            long l10 = -1;
            c10.a(bl2, l10);
        }
    }

    public boolean k0(boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return false;
        }
        return this.a.d0(bl2);
    }

    public void l(boolean bl2, long l10) {
        c c10 = this.e;
        if (c10 != null) {
            c10.a(bl2, l10);
        }
    }

    public void l0(boolean bl2, String string2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return;
        }
        this.a.m2(bl2, string2);
    }

    public void m() {
        this.a.h1();
    }

    public void m0() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        d.v.h.e.c c10 = this.a;
        bl2 = c10.isPlaying();
        if (bl2) {
            c10 = this.a;
            c10.pause();
        } else {
            c10 = this.a;
            c10.play();
        }
    }

    public void n() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.s0();
    }

    public void n0(boolean bl2) {
        this.a.X(bl2);
    }

    public boolean o(int n10, int n11, boolean bl2) {
        return this.p(n10, n11, bl2, true);
    }

    public boolean o0(int n10, String string2) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        return this.a.e1(n10, string2);
    }

    public boolean p(int n10, int n11, boolean bl2, boolean bl3) {
        boolean bl4 = this.b;
        if (!bl4) {
            return false;
        }
        d.v.h.e.c c10 = this.a;
        if ((n10 = (int)(c10.G0(n10, n11, bl2) ? 1 : 0)) != 0) {
            List list;
            this.c = list = this.a.o0();
            if (bl2) {
                this.k(bl3);
            }
        }
        return n10 != 0;
    }

    public void q(g g10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.M1(g10);
    }

    public void r() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        this.a.b0();
        this.k(true);
    }

    public void s() {
        this.a.c2();
    }

    public boolean t(int n10, long l10) {
        return this.u(n10, l10, true);
    }

    public boolean u(int n10, long l10, boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return false;
        }
        Object object = this.c;
        bl3 = d.v.j.b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.a;
        if ((n10 = (int)(object.I1(n10, l10) ? 1 : 0)) != 0) {
            l10 = 4096L;
            this.l(bl2, l10);
        }
        return n10 != 0;
    }

    public boolean v(long l10) {
        boolean bl2 = this.b;
        if (!bl2) {
            return false;
        }
        d.v.h.e.c c10 = this.a;
        boolean bl3 = c10.J0(l10);
        if (bl3) {
            boolean bl4 = true;
            long l11 = 4096L;
            this.l(bl4, l11);
        }
        return bl3;
    }

    public boolean w(int n10) {
        return this.x(n10, true);
    }

    public boolean x(int n10, boolean bl2) {
        boolean bl3 = this.b;
        if (!bl3) {
            return false;
        }
        Object object = this.c;
        bl3 = d.v.j.b.h(n10, (List)object);
        if (bl3) {
            return false;
        }
        object = this.a;
        if ((n10 = (int)(object.B0(n10) ? 1 : 0)) != 0) {
            long l10 = 2048L;
            this.l(bl2, l10);
        }
        return n10 != 0;
    }

    public boolean z(int n10, long l10, long l11) {
        return this.A(n10, l10, l11, true);
    }
}

