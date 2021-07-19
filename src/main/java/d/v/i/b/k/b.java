/*
 * Decompiled with CFR 0.151.
 */
package d.v.i.b.k;

import java.util.List;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ List a;

    public /* synthetic */ b(List list) {
        this.a = list;
    }

    public final void accept(Object object) {
        List list = this.a;
        object = (Integer)object;
        list.remove(object);
    }
}

