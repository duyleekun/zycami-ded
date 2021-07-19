/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.j.d;
import d.c.a.o.l.f$c;
import d.c.a.o.l.f$d;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;
import java.io.File;

public class f
implements n {
    private static final String b = "FileLoader";
    private final f$d a;

    public f(f$d f$d) {
        this.a = f$d;
    }

    public n$a c(File file, int n10, int n11, d.c.a.o.f object) {
        e e10 = new e(file);
        f$d f$d = this.a;
        object = new f$c(file, f$d);
        n$a n$a = new n$a(e10, (d)object);
        return n$a;
    }

    public boolean d(File file) {
        return true;
    }
}

