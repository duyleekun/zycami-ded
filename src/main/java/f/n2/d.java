/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.n2.d$a;
import f.n2.e;
import f.n2.m;
import f.n2.s;
import f.n2.t;
import java.util.Iterator;

public final class d
implements m,
e {
    private final m a;
    private final int b;

    public d(m object, int n10) {
        boolean bl2;
        String string2 = "sequence";
        f0.p(object, string2);
        this.a = object;
        this.b = n10;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("count must be non-negative, but was ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append('.');
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final /* synthetic */ int c(d d10) {
        return d10.b;
    }

    public static final /* synthetic */ m d(d d10) {
        return d10.a;
    }

    public m a(int n10) {
        d d10;
        int n11 = this.b + n10;
        if (n11 < 0) {
            d10 = new d(this, n10);
        } else {
            d d11;
            m m10 = this.a;
            d10 = d11 = new d(m10, n11);
        }
        return d10;
    }

    public m b(int n10) {
        e e10;
        int n11 = this.b;
        int n12 = n11 + n10;
        if (n12 < 0) {
            e10 = new t(this, n10);
        } else {
            m m10 = this.a;
            s s10 = new s(m10, n11, n12);
            e10 = s10;
        }
        return e10;
    }

    public Iterator iterator() {
        d$a d$a = new d$a(this);
        return d$a;
    }
}

