/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.g;

import androidx.arch.core.util.Function;
import androidx.core.util.Pair;
import d.v.g.g.c1;

public final class f
implements Function {
    public final /* synthetic */ c1 a;

    public /* synthetic */ f(c1 c12) {
        this.a = c12;
    }

    public final Object apply(Object object) {
        c1 c12 = this.a;
        object = (Pair)object;
        return c12.H((Pair)object);
    }
}

