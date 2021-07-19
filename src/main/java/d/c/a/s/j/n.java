/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s.j;

import d.c.a.s.j.b;
import d.c.a.s.j.o;
import d.c.a.u.m;

public abstract class n
extends b {
    private final int b;
    private final int c;

    public n() {
        int n10 = -1 << -1;
        this(n10, n10);
    }

    public n(int n10, int n11) {
        this.b = n10;
        this.c = n11;
    }

    public void a(o o10) {
    }

    public final void p(o object) {
        int n10 = this.b;
        int n11 = this.c;
        if ((n10 = (int)(m.v(n10, n11) ? 1 : 0)) != 0) {
            n10 = this.b;
            n11 = this.c;
            object.d(n10, n11);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: ");
        n11 = this.b;
        charSequence.append(n11);
        charSequence.append(" and height: ");
        n11 = this.c;
        charSequence.append(n11);
        charSequence.append(", either provide dimensions in the constructor or call override()");
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }
}

