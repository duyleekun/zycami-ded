/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.q;
import e.a.t;
import e.a.v0.c;
import e.a.w0.e.e.e1$a;

public final class e1
extends q {
    public final e0 a;
    public final c b;

    public e1(e0 e02, c c10) {
        this.a = e02;
        this.b = c10;
    }

    public void t1(t t10) {
        e0 e02 = this.a;
        c c10 = this.b;
        e1$a e1$a = new e1$a(t10, c10);
        e02.subscribe(e1$a);
    }
}

