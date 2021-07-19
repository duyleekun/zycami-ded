/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.l1.e0;

import androidx.fragment.app.FragmentManager;
import d.v.c.l1.e0.d;
import d.v.f.f.a;

public class d$a {
    private boolean a;
    private boolean b;
    private boolean c;
    private a d;
    private a e;
    private a f;
    private a g;

    public d a() {
        d d10 = new d();
        boolean bl2 = this.a;
        d10.E(bl2);
        bl2 = this.b;
        d10.x(bl2);
        bl2 = this.c;
        d10.y(bl2);
        a a10 = this.d;
        d10.C(a10);
        a10 = this.e;
        d10.z(a10);
        a10 = this.f;
        d10.B(a10);
        a10 = this.g;
        d10.A(a10);
        return d10;
    }

    public d$a b(boolean bl2) {
        this.b = bl2;
        return this;
    }

    public d$a c(boolean bl2) {
        this.c = bl2;
        return this;
    }

    public d$a d(a a10) {
        this.e = a10;
        return this;
    }

    public d$a e(a a10) {
        this.g = a10;
        return this;
    }

    public d$a f(a a10) {
        this.f = a10;
        return this;
    }

    public d$a g(a a10) {
        this.d = a10;
        return this;
    }

    public d$a h(boolean bl2) {
        this.a = bl2;
        return this;
    }

    public d i(FragmentManager fragmentManager) {
        block4: {
            try {
                boolean bl2 = fragmentManager.isDestroyed();
                if (!bl2) break block4;
                return null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
                return null;
            }
        }
        d d10 = this.a();
        d10.q(fragmentManager);
        return d10;
    }
}

