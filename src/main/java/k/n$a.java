/*
 * Decompiled with CFR 0.151.
 */
package k;

import k.n;
import k.p;

public class n$a
extends n {
    public final /* synthetic */ n a;

    public n$a(n n10) {
        this.a = n10;
    }

    public void d(p p10, Iterable object) {
        boolean bl2;
        if (object == null) {
            return;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            n n10 = this.a;
            n10.a(p10, e10);
        }
    }
}

