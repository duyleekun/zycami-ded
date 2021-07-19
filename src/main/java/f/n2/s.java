/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.h2.t.f0;
import f.n2.e;
import f.n2.m;
import f.n2.s$a;
import java.util.Iterator;
import kotlin.sequences.SequencesKt__SequencesKt;

public final class s
implements m,
e {
    private final m a;
    private final int b;
    private final int c;

    public s(m object, int n10, int n11) {
        f0.p(object, "sequence");
        this.a = object;
        this.b = n10;
        this.c = n11;
        boolean bl2 = true;
        boolean bl3 = n10 >= 0 ? bl2 : false;
        if (bl3) {
            bl3 = n11 >= 0 ? bl2 : false;
            if (bl3) {
                if (n11 < n10) {
                    bl2 = false;
                    object = null;
                }
                if (bl2) {
                    return;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("endIndex should be not less than startIndex, but was ");
                ((StringBuilder)object).append(n11);
                ((StringBuilder)object).append(" < ");
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                object = object.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("endIndex should be non-negative, but is ");
            ((StringBuilder)object).append(n11);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
            throw illegalArgumentException;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("startIndex should be non-negative, but is ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static final /* synthetic */ int c(s s10) {
        return s10.c;
    }

    public static final /* synthetic */ m d(s s10) {
        return s10.a;
    }

    public static final /* synthetic */ int e(s s10) {
        return s10.b;
    }

    private final int f() {
        int n10 = this.c;
        int n11 = this.b;
        return n10 - n11;
    }

    public m a(int n10) {
        m m10;
        int n11 = this.f();
        if (n10 >= n11) {
            m10 = SequencesKt__SequencesKt.j();
        } else {
            m m11 = this.a;
            int n12 = this.b + n10;
            n10 = this.c;
            s s10 = new s(m11, n12, n10);
            m10 = s10;
        }
        return m10;
    }

    public m b(int n10) {
        s s10;
        int n11 = this.f();
        if (n10 >= n11) {
            s10 = this;
        } else {
            m m10 = this.a;
            int n12 = this.b;
            s10 = new s(m10, n12, n10 += n12);
        }
        return s10;
    }

    public Iterator iterator() {
        s$a s$a = new s$a(this);
        return s$a;
    }
}

