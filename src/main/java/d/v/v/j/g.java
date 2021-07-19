/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.j;

import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.h.e.b;
import d.v.v.j.g$a;
import d.v.v.q.h;
import java.util.ArrayList;
import java.util.List;

public class g {
    private List a;

    public g() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public static g c() {
        return g$a.a();
    }

    public void a(b b10) {
        boolean bl2;
        List<b> list = this.a;
        if (list == null) {
            list = new List<b>();
            this.a = list;
        }
        if (!(bl2 = (list = this.a).contains(b10))) {
            list = this.a;
            list.add(b10);
        }
    }

    public void b() {
        this.a.clear();
    }

    public void d(b b10) {
        List list = this.a;
        if (list != null) {
            list.remove(b10);
        }
    }

    public void e() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.h();
            }
        }
    }

    public void f(Exception exception) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                String string2 = exception.getMessage();
                b10.a(exception, string2);
            }
        }
    }

    public void g(int n10) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.b(n10);
            }
        }
    }

    public void h(String string2) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.c(string2);
            }
        }
    }

    public void i(int n10, DecorationType decorationType) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.s(n10, decorationType);
            }
        }
    }

    public void j(int n10, DecorationType decorationType, int n11) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.k(n10, decorationType, n11);
            }
        }
    }

    public void k() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.i();
            }
        }
    }

    public void l(int n10, DecorationType decorationType) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.g(n10, decorationType);
            }
        }
    }

    public void m(boolean bl2) {
        Object object = this.a;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.q(bl2);
            }
        }
    }

    public void n(boolean bl2) {
        Object object = this.a;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.m(bl2);
            }
        }
    }

    public void o(int n10) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.d(n10);
            }
        }
    }

    public void p(int n10, int n11) {
        int n12 = -1;
        if (n10 == n12) {
            return;
        }
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.l(n10, n11);
            }
        }
    }

    public void q() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                int n10 = h.p();
                b10.t(n10);
            }
        }
    }

    public void r(int n10) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.p(n10);
            }
        }
    }

    public void s() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.u();
            }
        }
    }

    public void t(int n10) {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.j(n10);
            }
        }
    }

    public void u() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.e();
            }
        }
    }

    public void v() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.r();
            }
        }
    }

    public void w() {
        Object object = this.a;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                b b10 = (b)object.next();
                b10.f();
            }
        }
    }
}

