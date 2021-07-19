/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.c;
import d.c.a.o.k.n;
import d.c.a.o.k.s;
import d.c.a.u.k;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public final class a$d
extends WeakReference {
    public final c a;
    public final boolean b;
    public s c;

    public a$d(c object, n n10, ReferenceQueue referenceQueue, boolean bl2) {
        super(n10, referenceQueue);
        object = (c)k.d(object);
        this.a = object;
        boolean bl3 = n10.d();
        if (bl3 && bl2) {
            object = (s)k.d(n10.c());
        } else {
            bl3 = false;
            object = null;
        }
        this.c = object;
        this.b = bl3 = n10.d();
    }

    public void a() {
        this.c = null;
        this.clear();
    }
}

