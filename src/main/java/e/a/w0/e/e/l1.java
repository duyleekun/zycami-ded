/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.w0.e.e.l1$a;

public final class l1
extends i0 {
    public final e0 a;
    public final Object b;

    public l1(e0 e02, Object object) {
        this.a = e02;
        this.b = object;
    }

    public void e1(l0 l02) {
        e0 e02 = this.a;
        Object object = this.b;
        l1$a l1$a = new l1$a(l02, object);
        e02.subscribe(l1$a);
    }
}

