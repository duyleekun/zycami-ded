/*
 * Decompiled with CFR 0.151.
 */
package k;

import k.h;
import k.n;
import k.p;

public final class n$n
extends n {
    private final h a;
    private final boolean b;

    public n$n(h h10, boolean bl2) {
        this.a = h10;
        this.b = bl2;
    }

    public void a(p p10, Object object) {
        if (object == null) {
            return;
        }
        object = (String)this.a.convert(object);
        boolean bl2 = this.b;
        p10.g((String)object, null, bl2);
    }
}

