/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.InputFilter
 */
package d.v.g0;

import android.content.Context;
import android.text.InputFilter;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.ui.R$string;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k;
import d.v.g0.l;
import java.util.List;
import java.util.function.Consumer;

public abstract class k$a {
    private final Context a;
    private final l b;

    public k$a(Context object) {
        this.a = object;
        this.b = object;
    }

    private String e(int n10) {
        return g.m(this.a, n10);
    }

    public k$a A(int n10) {
        String string2;
        l l10 = this.b;
        l10.a = string2 = this.e(n10);
        return this.f();
    }

    public k$a B(String string2) {
        this.b.a = string2;
        return this.f();
    }

    public k$a C(boolean bl2) {
        this.b.q = bl2;
        return this.f();
    }

    public k D(FragmentManager fragmentManager) {
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
        k k10 = this.b();
        k10.q(fragmentManager);
        return k10;
    }

    public k$a E(boolean bl2) {
        this.b.c = bl2;
        return this.f();
    }

    public k$a a(InputFilter inputFilter) {
        if (inputFilter != null) {
            List list = this.b.t;
            list.add(inputFilter);
        }
        return this.f();
    }

    public k b() {
        k k10 = this.d();
        this.b.a(k10);
        return k10;
    }

    public k$a c() {
        this.b.n = true;
        return this.f();
    }

    public abstract k d();

    public abstract k$a f();

    public k$a g(int n10, int n11) {
        l l10 = this.b;
        l10.o = n10;
        l10.p = n11;
        return this.f();
    }

    public k$a h(int n10) {
        String string2;
        l l10 = this.b;
        l10.d = string2 = this.e(n10);
        return this.f();
    }

    public k$a i(String string2) {
        this.b.d = string2;
        return this.f();
    }

    public k$a j(int n10) {
        this.b.m = n10;
        return this.f();
    }

    public k$a k(String string2) {
        this.b.e = string2;
        return this.f();
    }

    public k$a l(int n10) {
        this.b.u = n10;
        return this.f();
    }

    public k$a m(int n10) {
        String string2;
        l l10 = this.b;
        l10.b = string2 = this.e(n10);
        return this.f();
    }

    public k$a n(String string2) {
        this.b.b = string2;
        return this.f();
    }

    public k$a o(int n10, a a10) {
        String string2;
        l l10 = this.b;
        l10.i = string2 = this.e(n10);
        this.b.j = a10;
        return this.f();
    }

    public k$a p(a a10) {
        int n10 = R$string.cancel;
        this.o(n10, a10);
        return this.f();
    }

    public k$a q(String string2, a a10) {
        l l10 = this.b;
        l10.i = string2;
        l10.j = a10;
        return this.f();
    }

    public k$a r(boolean bl2) {
        this.b.r = bl2;
        return this.f();
    }

    public k$a s() {
        this.b.f = true;
        return this.f();
    }

    public k$a t() {
        this.b.g = true;
        return this.f();
    }

    public k$a u(Consumer consumer) {
        this.b.v = consumer;
        return this.f();
    }

    public k$a v(int n10, a a10) {
        String string2;
        l l10 = this.b;
        l10.k = string2 = this.e(n10);
        this.b.l = a10;
        return this.f();
    }

    public k$a w(a a10) {
        int n10 = R$string.confirm;
        this.v(n10, a10);
        return this.f();
    }

    public k$a x(String string2, a a10) {
        l l10 = this.b;
        l10.k = string2;
        l10.l = a10;
        return this.f();
    }

    public k$a y(boolean bl2) {
        this.b.s = bl2;
        return this.f();
    }

    public k$a z(boolean bl2) {
        this.b.h = bl2;
        return this.f();
    }
}

