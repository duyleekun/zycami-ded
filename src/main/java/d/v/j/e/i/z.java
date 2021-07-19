/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import d.v.j.e.i.b1;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class z
implements Consumer {
    public final /* synthetic */ List a;
    public final /* synthetic */ Map b;

    public /* synthetic */ z(List list, Map map) {
        this.a = list;
        this.b = map;
    }

    public final void accept(Object object) {
        List list = this.a;
        Map map = this.b;
        object = (List)object;
        b1.M0(list, map, (List)object);
    }
}

