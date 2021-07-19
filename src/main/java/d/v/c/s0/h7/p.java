/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import d.v.c.s0.h7.k0;
import e.a.b0;
import e.a.c0;

public final class p
implements c0 {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ float b;
    public final /* synthetic */ float c;
    public final /* synthetic */ long d;

    public /* synthetic */ p(k0 k02, float f10, float f11, long l10) {
        this.a = k02;
        this.b = f10;
        this.c = f11;
        this.d = l10;
    }

    public final void subscribe(b0 b02) {
        k0 k02 = this.a;
        float f10 = this.b;
        float f11 = this.c;
        long l10 = this.d;
        k02.B(f10, f11, l10, b02);
    }
}

