/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.h$a;
import d.c.a.o.l.j$a;
import java.util.Map;

public interface h {
    public static final h a;
    public static final h b;

    static {
        Object object = new h$a();
        a = object;
        object = new j$a();
        b = ((j$a)object).c();
    }

    public Map a();
}

