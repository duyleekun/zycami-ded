/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.e1;
import d.v.a0.i1;
import java.util.Map;
import java.util.function.BiConsumer;

public final class n0
implements BiConsumer {
    public final /* synthetic */ Map a;

    public /* synthetic */ n0(Map map) {
        this.a = map;
    }

    public final void accept(Object object, Object object2) {
        Map map = this.a;
        object = (String)object;
        object2 = (e1)object2;
        i1.U(map, (String)object, (e1)object2);
    }
}

