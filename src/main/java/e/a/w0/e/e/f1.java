/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.i0;
import e.a.l0;
import e.a.v0.c;
import e.a.w0.e.e.f1$a;

public final class f1
extends i0 {
    public final e0 a;
    public final Object b;
    public final c c;

    public f1(e0 e02, Object object, c c10) {
        this.a = e02;
        this.b = object;
        this.c = c10;
    }

    public void e1(l0 l02) {
        e0 e02 = this.a;
        c c10 = this.c;
        Object object = this.b;
        f1$a f1$a = new f1$a(l02, c10, object);
        e02.subscribe(f1$a);
    }
}

