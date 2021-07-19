/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.g0;
import e.a.e0;
import java.util.UUID;
import java.util.concurrent.Callable;

public class g0$b
implements Callable {
    public final /* synthetic */ UUID[] a;
    public final /* synthetic */ g0 b;

    public g0$b(g0 g02, UUID[] uUIDArray) {
        this.b = g02;
        this.a = uUIDArray;
    }

    public e0 a() {
        this.b.e.a(true);
        g0 g02 = this.b;
        UUID[] uUIDArray = this.a;
        return g02.q(uUIDArray);
    }
}

