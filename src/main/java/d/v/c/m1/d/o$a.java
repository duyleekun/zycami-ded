/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.m1.d;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import d.v.c.m1.d.n;
import d.v.c.m1.d.o;
import d.v.f.f.a;
import d.v.f.i.g;

public class o$a {
    private final Context a;
    private final n b;

    public o$a(Context object) {
        this.a = object;
        this.b = object;
    }

    private String c(int n10) {
        return g.m(this.a, n10);
    }

    public o a() {
        o o10 = new o();
        this.b.b(o10);
        return o10;
    }

    public o$a b() {
        this.b.m = true;
        return this;
    }

    public o$a d(int n10, int n11) {
        n n12 = this.b;
        n12.n = n10;
        n12.o = n11;
        return this;
    }

    public o$a e(String string2) {
        this.b.d = string2;
        return this;
    }

    public o$a f(int n10) {
        this.b.l = n10;
        return this;
    }

    public o$a g(String string2) {
        this.b.e = string2;
        return this;
    }

    public o$a h(int n10) {
        String string2;
        n n11 = this.b;
        n11.b = string2 = this.c(n10);
        return this;
    }

    public o$a i(String string2) {
        this.b.b = string2;
        return this;
    }

    public o$a j(int n10, a a10) {
        String string2;
        n n11 = this.b;
        n11.h = string2 = this.c(n10);
        this.b.i = a10;
        return this;
    }

    public o$a k(a a10) {
        this.j(2131951996, a10);
        return this;
    }

    public o$a l(String string2, a a10) {
        n n10 = this.b;
        n10.h = string2;
        n10.i = a10;
        return this;
    }

    public o$a m() {
        this.b.f = true;
        return this;
    }

    public o$a n() {
        this.b.g = true;
        return this;
    }

    public o$a o(int n10, a a10) {
        String string2;
        n n11 = this.b;
        n11.j = string2 = this.c(n10);
        this.b.k = a10;
        return this;
    }

    public o$a p(a a10) {
        this.o(2131951997, a10);
        return this;
    }

    public o$a q(String string2, a a10) {
        n n10 = this.b;
        n10.j = string2;
        n10.k = a10;
        return this;
    }

    public o$a r(int n10) {
        String string2;
        n n11 = this.b;
        n11.a = string2 = this.c(n10);
        return this;
    }

    public o$a s(String string2) {
        this.b.a = string2;
        return this;
    }

    public o t(FragmentManager fragmentManager) {
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
        o o10 = this.a();
        String string2 = "PrimeConfirmDialog";
        o10.show(fragmentManager, string2);
        return o10;
    }

    public o$a u(boolean bl2) {
        this.b.c = bl2;
        return this;
    }
}

