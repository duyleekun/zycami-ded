/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.e.b.d$a;
import e.a.w0.e.b.d$b;
import i.g.c;
import java.util.Iterator;

public final class d
implements Iterable {
    public final c a;

    public d(c c10) {
        this.a = c10;
    }

    public Iterator iterator() {
        d$b d$b = new d$b();
        c c10 = this.a;
        d$a d$a = new d$a(c10, d$b);
        return d$a;
    }
}

