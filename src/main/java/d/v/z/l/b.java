/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import java.util.Map;
import java.util.function.BiConsumer;

public final class b
implements BiConsumer {
    public final /* synthetic */ Map a;

    public /* synthetic */ b(Map map) {
        this.a = map;
    }

    public final void accept(Object object, Object object2) {
        Map map = this.a;
        object = (String)object;
        object2 = (String)object2;
        map.put(object, object2);
    }
}

