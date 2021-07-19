/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0;

import d.v.h0.i;
import java.util.function.Function;

public final class e
implements Function {
    public final /* synthetic */ i a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(i i10, int n10) {
        this.a = i10;
        this.b = n10;
    }

    public final Object apply(Object object) {
        i i10 = this.a;
        int n10 = this.b;
        object = (byte[])object;
        return i10.k(n10, (byte[])object);
    }
}

