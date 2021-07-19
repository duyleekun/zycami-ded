/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.n2.e;
import f.n2.m;
import f.n2.s;
import f.n2.t$a;
import java.util.Iterator;
import kotlin.sequences.SequencesKt__SequencesKt;

public final class t
implements m,
e {
    private final m a;
    private final int b;

    public t(m object, int n10) {
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

    public static final /* synthetic */ int c(t t10) {
        return t10.b;
    }

    public static final /* synthetic */ m d(t t10) {
        return t10.a;
    }

    public m a(int n10) {
        m m10;
        int n11 = this.b;
        if (n10 >= n11) {
            m10 = SequencesKt__SequencesKt.j();
        } else {
            m m11 = this.a;
            s s10 = new s(m11, n10, n11);
            m10 = s10;
        }
        return m10;
    }

    public m b(int n10) {
        t t10;
        int n11 = this.b;
        if (n10 >= n11) {
            t10 = this;
        } else {
            m m10 = this.a;
            t10 = new t(m10, n10);
        }
        return t10;
    }

    public Iterator iterator() {
        t$a t$a = new t$a(this);
        return t$a;
    }
}

