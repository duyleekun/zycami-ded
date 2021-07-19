/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.k.y.a;
import d.c.a.o.k.y.a$a;
import d.c.a.o.k.y.d$a;
import d.c.a.o.k.y.d$b;
import d.c.a.o.k.y.d$c;
import d.c.a.o.k.y.e;
import java.io.File;

public class d
implements a$a {
    private final long c;
    private final d$c d;

    public d(d$c d$c, long l10) {
        this.c = l10;
        this.d = d$c;
    }

    public d(String string2, long l10) {
        d$a d$a = new d$a(string2);
        this(d$a, l10);
    }

    public d(String string2, String string3, long l10) {
        d$b d$b = new d$b(string2, string3);
        this(d$b, l10);
    }

    public a build() {
        File file = this.d.a();
        if (file == null) {
            return null;
        }
        boolean bl2 = file.mkdirs();
        if (!(bl2 || (bl2 = file.exists()) && (bl2 = file.isDirectory()))) {
            return null;
        }
        long l10 = this.c;
        return e.d(file, l10);
    }
}

