/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.l;

import java.util.Map;
import java.util.function.BiConsumer;

public final class a
implements BiConsumer {
    public final /* synthetic */ Map a;

    public /* synthetic */ a(Map map) {
        this.a = map;
    }

    public final void accept(Object object, Object object2) {
        Map map = this.a;
        object = (String)object;
        object2 = (Float)object2;
        map.put(object, object2);
    }
}

