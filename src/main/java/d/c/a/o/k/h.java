/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.k.h$a;
import d.c.a.o.k.h$b;
import d.c.a.o.k.h$c;
import d.c.a.o.k.h$d;
import d.c.a.o.k.h$e;

public abstract class h {
    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;

    static {
        h h10 = new h$a();
        a = h10;
        h10 = new h$b();
        b = h10;
        h10 = new h$c();
        c = h10;
        h10 = new h$d();
        d = h10;
        h10 = new h$e();
        e = h10;
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource var1);

    public abstract boolean d(boolean var1, DataSource var2, EncodeStrategy var3);
}

