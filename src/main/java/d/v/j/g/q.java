/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import d.v.j.g.c0;

public final class q
implements Function {
    public final /* synthetic */ java.util.function.Function a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ q(java.util.function.Function function, boolean bl2) {
        this.a = function;
        this.b = bl2;
    }

    public final Object apply(Object object) {
        java.util.function.Function function = this.a;
        boolean bl2 = this.b;
        return c0.i(function, bl2, object);
    }
}

