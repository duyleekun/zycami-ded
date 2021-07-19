/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.z1;

import d.v.c.z1.e;
import java.util.List;
import java.util.function.Supplier;

public final class c
implements Supplier {
    public final /* synthetic */ String a;
    public final /* synthetic */ List b;

    public /* synthetic */ c(String string2, List list) {
        this.a = string2;
        this.b = list;
    }

    public final Object get() {
        String string2 = this.a;
        List list = this.b;
        return e.j(string2, list);
    }
}

