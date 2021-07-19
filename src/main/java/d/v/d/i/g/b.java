/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.g;

import d.v.d.i.g.k;
import java.util.List;
import java.util.function.BiConsumer;

public final class b
implements BiConsumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(k k10, int n10) {
        this.a = k10;
        this.b = n10;
    }

    public final void accept(Object object, Object object2) {
        k k10 = this.a;
        int n10 = this.b;
        object = (Integer)object;
        object2 = (List)object2;
        k10.y(n10, (Integer)object, (List)object2);
    }
}

