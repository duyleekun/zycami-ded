/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.ne;

import d.v.e0.ne.k0;
import d.v.y.c.r0;
import java.util.concurrent.Callable;

public final class a
implements Callable {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ r0 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(k0 k02, r0 r02, String string2, long l10) {
        this.a = k02;
        this.b = r02;
        this.c = string2;
        this.d = l10;
    }

    public final Object call() {
        k0 k02 = this.a;
        r0 r02 = this.b;
        String string2 = this.c;
        long l10 = this.d;
        return k02.J(r02, string2, l10);
    }
}

