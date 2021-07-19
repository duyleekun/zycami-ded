/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.e.e.j0$a;
import e.a.z;

public final class j0
extends z {
    public final Object[] a;

    public j0(Object[] objectArray) {
        this.a = objectArray;
    }

    public void K5(g0 g02) {
        Object[] objectArray = this.a;
        j0$a j0$a = new j0$a(g02, objectArray);
        g02.onSubscribe(j0$a);
        boolean bl2 = j0$a.d;
        if (bl2) {
            return;
        }
        j0$a.a();
    }
}

