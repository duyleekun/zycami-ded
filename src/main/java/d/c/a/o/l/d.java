/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.f;
import d.c.a.o.l.d$a;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;
import java.io.File;

public class d
implements n {
    private static final String a = "ByteBufferFileLoader";

    public n$a c(File file, int n10, int n11, f object) {
        e e10 = new e(file);
        object = new d$a(file);
        n$a n$a = new n$a(e10, (d.c.a.o.j.d)object);
        return n$a;
    }

    public boolean d(File file) {
        return true;
    }
}

