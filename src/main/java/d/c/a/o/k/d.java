/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.a;
import d.c.a.o.f;
import d.c.a.o.k.y.a$b;
import java.io.File;

public class d
implements a$b {
    private final a a;
    private final Object b;
    private final f c;

    public d(a a10, Object object, f f10) {
        this.a = a10;
        this.b = object;
        this.c = f10;
    }

    public boolean a(File file) {
        a a10 = this.a;
        Object object = this.b;
        f f10 = this.c;
        return a10.a(object, file, f10);
    }
}

