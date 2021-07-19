/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.BoxWorkingMode;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.core.entities.ErrorStatus;
import com.zhiyun.protocol.message.bl.ccs.CCSParams;
import com.zhiyun.stabilizer.Stabilizer$f;
import com.zhiyun.stabilizer.Stabilizer$g;
import com.zhiyun.stabilizer.Stabilizer$h;
import com.zhiyun.stabilizer.Stabilizer$j;
import com.zhiyun.stabilizer.Stabilizer$k;
import com.zhiyun.stabilizer.Stabilizer$l;
import d.v.y.c.s1.l.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class be {
    private static final be n;
    private List a;
    private List b;
    private List c;
    private List d;
    private List e;
    private List f;
    private Stabilizer$k g;
    private Stabilizer$j h;
    private Stabilizer$f i;
    private Stabilizer$f j;
    private Stabilizer$l k;
    private Stabilizer$h l;
    private Stabilizer$g m;

    static {
        be be2;
        n = be2 = new be();
    }

    public be() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        this.a = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.b = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.c = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.d = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.e = copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.f = copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

    public static be m() {
        return n;
    }

    public void A(WorkingMode workingMode) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            stabilizer$k.j(workingMode);
        }
        object = this.g;
        if (object != null) {
            ((Stabilizer$k)object).j(workingMode);
        }
    }

    public void B(Stabilizer$f stabilizer$f) {
        this.d.remove(stabilizer$f);
    }

    public void C(Stabilizer$f stabilizer$f) {
        this.c.remove(stabilizer$f);
    }

    public void D(Stabilizer$h stabilizer$h) {
        this.f.remove(stabilizer$h);
    }

    public void E(Stabilizer$j stabilizer$j) {
        this.b.remove(stabilizer$j);
    }

    public void F(Stabilizer$k stabilizer$k) {
        this.a.remove(stabilizer$k);
    }

    public void G(Stabilizer$l stabilizer$l) {
        this.e.remove(stabilizer$l);
    }

    public void H(Stabilizer$f stabilizer$f) {
        this.j = stabilizer$f;
    }

    public void I(Stabilizer$f stabilizer$f) {
        this.i = stabilizer$f;
    }

    public void J(Stabilizer$g stabilizer$g) {
        this.m = stabilizer$g;
    }

    public void K(Stabilizer$h stabilizer$h) {
        this.l = stabilizer$h;
    }

    public void L(Stabilizer$j stabilizer$j) {
        this.h = stabilizer$j;
    }

    public void M(Stabilizer$k stabilizer$k) {
        this.g = stabilizer$k;
    }

    public void N(Stabilizer$l stabilizer$l) {
        this.k = stabilizer$l;
    }

    public void a(Stabilizer$f stabilizer$f) {
        this.d.add(stabilizer$f);
    }

    public void b(Stabilizer$f stabilizer$f) {
        this.c.add(stabilizer$f);
    }

    public void c(Stabilizer$h stabilizer$h) {
        this.f.add(stabilizer$h);
    }

    public void d(Stabilizer$j stabilizer$j) {
        this.b.add(stabilizer$j);
    }

    public void e(Stabilizer$k stabilizer$k) {
        this.a.add(stabilizer$k);
    }

    public void f(Stabilizer$l stabilizer$l) {
        this.e.add(stabilizer$l);
    }

    public void g() {
        this.f.clear();
    }

    public void h() {
        this.e.clear();
    }

    public void i() {
        this.d.clear();
    }

    public void j() {
        this.c.clear();
    }

    public void k() {
        this.b.clear();
    }

    public void l() {
        this.a.clear();
    }

    public void n(Integer n10) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            int n11 = n10;
            stabilizer$k.d(n11);
        }
        object = this.g;
        if (object != null) {
            int n12 = n10;
            ((Stabilizer$k)object).d(n12);
        }
    }

    public void o(BoxWorkingMode boxWorkingMode) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            stabilizer$k.e(boxWorkingMode);
        }
        object = this.g;
        if (object != null) {
            ((Stabilizer$k)object).e(boxWorkingMode);
        }
    }

    public void p(CCSParams cCSParams) {
        boolean bl2;
        Object object = this.d.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$f stabilizer$f = (Stabilizer$f)object.next();
            stabilizer$f.a(cCSParams);
        }
        object = this.j;
        if (object != null) {
            object.a(cCSParams);
        }
    }

    public void q(CCSParams cCSParams) {
        boolean bl2;
        Object object = this.c.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$f stabilizer$f = (Stabilizer$f)object.next();
            stabilizer$f.a(cCSParams);
        }
        object = this.i;
        if (object != null) {
            object.a(cCSParams);
        }
    }

    public void r(Integer n10) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            int n11 = n10;
            stabilizer$k.f(n11);
        }
        object = this.g;
        if (object != null) {
            int n12 = n10;
            ((Stabilizer$k)object).f(n12);
        }
    }

    public void s(Integer n10) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            int n11 = n10;
            stabilizer$k.g(n11);
        }
        object = this.g;
        if (object != null) {
            int n12 = n10;
            ((Stabilizer$k)object).g(n12);
        }
    }

    public void t(boolean bl2, int n10, ErrorStatus errorStatus) {
        Stabilizer$g stabilizer$g = this.m;
        if (stabilizer$g != null) {
            stabilizer$g.a(bl2, n10, errorStatus);
        }
    }

    public void u() {
        boolean bl2;
        Object object = this.f.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$h stabilizer$h = (Stabilizer$h)object.next();
            stabilizer$h.a();
        }
        object = this.l;
        if (object != null) {
            object.a();
        }
    }

    public void v(int n10) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            stabilizer$k.h(n10);
        }
        object = this.g;
        if (object != null) {
            ((Stabilizer$k)object).h(n10);
        }
    }

    public void w(c c10) {
        boolean bl2;
        Object object = this.b.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$j stabilizer$j = (Stabilizer$j)object.next();
            stabilizer$j.a(c10);
        }
        object = this.h;
        if (object != null) {
            object.a(c10);
        }
    }

    public void x(Integer n10) {
        boolean bl2;
        Object object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)object.next();
            int n11 = n10;
            stabilizer$k.i(n11);
        }
        object = this.g;
        if (object != null) {
            int n12 = n10;
            ((Stabilizer$k)object).i(n12);
        }
    }

    public void y(boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.a.iterator();
        while (bl3 = iterator2.hasNext()) {
            Stabilizer$k stabilizer$k = (Stabilizer$k)iterator2.next();
            if (bl2) {
                stabilizer$k.a();
            } else {
                stabilizer$k.b();
            }
            if ((stabilizer$k = this.g) == null) continue;
            if (bl2) {
                stabilizer$k.a();
                continue;
            }
            stabilizer$k.b();
        }
    }

    public void z(int n10, int n11) {
        boolean bl2;
        Object object = this.e.iterator();
        while (bl2 = object.hasNext()) {
            Stabilizer$l stabilizer$l = (Stabilizer$l)object.next();
            stabilizer$l.a(n10, n11);
        }
        object = this.k;
        if (object != null) {
            object.a(n10, n11);
        }
    }
}

