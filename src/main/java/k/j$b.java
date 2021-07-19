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

public final class j$b
extends j {
    private final e d;
    private final boolean e;

    public j$b(q q10, e$a e$a, h h10, e e10, boolean bl2) {
        super(q10, e$a, h10);
        this.d = e10;
        this.e = bl2;
    }

    public Object c(d object, Object[] object2) {
        block5: {
            block4: {
                e e10 = this.d;
                object = (d)e10.b((d)object);
                int n10 = ((Object[])object2).length + -1;
                object2 = (c)object2[n10];
                try {
                    n10 = (int)(this.e ? 1 : 0);
                    if (n10 == 0) break block4;
                }
                catch (Exception exception) {
                    return KotlinExtensions.e(exception, (c)object2);
                }
                object = KotlinExtensions.b((d)object, (c)object2);
                break block5;
            }
            object = KotlinExtensions.a((d)object, (c)object2);
        }
        return object;
    }
}

