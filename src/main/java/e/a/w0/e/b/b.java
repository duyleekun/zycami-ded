/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.e.b.b$a;
import i.g.c;
import java.util.Iterator;

public final class b
implements Iterable {
    public final c a;

    public b(c c10) {
        this.a = c10;
    }

    public Iterator iterator() {
        b$a b$a = new b$a();
        j.f3(this.a).S3().l6(b$a);
        return b$a;
    }
}

