/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import d.k.a.a$a;
import d.k.a.a$d;
import e.a.g0;
import e.a.z;

public final class a$c
extends z {
    private final z a;
    private final a$a b;

    public a$c(z z10, a$a a$a) {
        this.a = z10;
        this.b = a$a;
    }

    public void K5(g0 g02) {
        z z10 = this.a;
        a$a a$a = this.b;
        a$d a$d = new a$d(g02, a$a);
        z10.subscribe(a$d);
    }
}

