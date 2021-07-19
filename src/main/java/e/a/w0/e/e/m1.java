/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.w0.e.e.a;
import e.a.w0.e.e.m1$a;

public final class m1
extends a {
    public final long b;

    public m1(e0 e02, long l10) {
        super(e02);
        this.b = l10;
    }

    public void K5(g0 g02) {
        e0 e02 = this.a;
        long l10 = this.b;
        m1$a m1$a = new m1$a(g02, l10);
        e02.subscribe(m1$a);
    }
}

