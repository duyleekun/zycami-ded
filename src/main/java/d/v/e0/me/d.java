/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import d.v.e0.me.d$a;
import d.v.e0.me.d$b;
import e.a.c1.b;
import e.a.h0;
import e.a.i0;
import e.a.z;
import java.util.concurrent.Callable;

public class d {
    public static z a(int n10) {
        Object object = new d$a(n10);
        z z10 = z.D1((Callable)object);
        object = b.d();
        return z10.L5((h0)object);
    }

    public static i0 b(byte[] object, String object2, int n10) {
        d$b d$b = new d$b((String)object2, (byte[])object, n10);
        object = i0.H(d$b);
        object2 = b.d();
        return ((i0)object).f1((h0)object2);
    }
}

