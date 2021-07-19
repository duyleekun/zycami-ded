/*
 * Decompiled with CFR 0.151.
 */
package k;

import f.b2.c;
import g.e$a;
import k.d;
import k.e;
import k.h;
import k.j;
import k.q;
import retrofit2.KotlinExtensions;

public final class j$c
extends j {
    private final e d;

    public j$c(q q10, e$a e$a, h h10, e e10) {
        super(q10, e$a, h10);
        this.d = e10;
    }

    public Object c(d d10, Object[] object) {
        e e10 = this.d;
        d10 = (d)e10.b(d10);
        int n10 = ((Object[])object).length + -1;
        object = (c)object[n10];
        try {
            return KotlinExtensions.c(d10, (c)object);
        }
        catch (Exception exception) {
            return KotlinExtensions.e(exception, (c)object);
        }
    }
}

