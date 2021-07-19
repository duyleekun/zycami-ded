/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.w0.e.e.d$a;
import e.a.w0.e.e.d$b;
import java.util.Iterator;

public final class d
implements Iterable {
    public final e0 a;

    public d(e0 e02) {
        this.a = e02;
    }

    public Iterator iterator() {
        d$b d$b = new d$b();
        e0 e02 = this.a;
        d$a d$a = new d$a(e02, d$b);
        return d$a;
    }
}

