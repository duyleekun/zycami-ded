/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import com.dianping.logan.CLoganProtocol;
import d.e.a.g;
import d.e.a.i;

public class f
implements g {
    private static f d;
    private g a;
    private boolean b;
    private i c;

    private f() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f g() {
        Object object = d;
        if (object != null) return d;
        object = f.class;
        synchronized (object) {
            f f10;
            d = f10 = new f();
            return d;
        }
    }

    public void a() {
        g g10 = this.a;
        if (g10 != null) {
            g10.a();
        }
    }

    public void b(String string2, String string3, int n10, String string4, String string5) {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        bl2 = CLoganProtocol.g();
        if (bl2) {
            boolean bl3;
            CLoganProtocol cLoganProtocol = CLoganProtocol.i();
            this.a = cLoganProtocol;
            i i10 = this.c;
            cLoganProtocol.c(i10);
            g g10 = this.a;
            g10.b(string2, string3, n10, string4, string5);
            this.b = bl3 = true;
        } else {
            boolean bl4 = false;
            string2 = null;
            this.a = null;
        }
    }

    public void c(i i10) {
        this.c = i10;
    }

    public void d(int n10, String string2, long l10, String string3, long l11, boolean bl2) {
        g g10 = this.a;
        if (g10 != null) {
            g10.d(n10, string2, l10, string3, l11, bl2);
        }
    }

    public void e(String string2) {
        g g10 = this.a;
        if (g10 != null) {
            g10.e(string2);
        }
    }

    public void f(boolean bl2) {
        g g10 = this.a;
        if (g10 != null) {
            g10.f(bl2);
        }
    }
}

