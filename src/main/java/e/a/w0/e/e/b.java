/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.w0.e.e.b$a;
import e.a.z;
import java.util.Iterator;

public final class b
implements Iterable {
    public final e0 a;

    public b(e0 e02) {
        this.a = e02;
    }

    public Iterator iterator() {
        b$a b$a = new b$a();
        z.O7(this.a).I3().subscribe(b$a);
        return b$a;
    }
}

