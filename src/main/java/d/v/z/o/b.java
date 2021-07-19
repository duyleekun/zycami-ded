/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.o;

import d.v.z.o.i;
import java.util.HashMap;
import java.util.function.Consumer;

public final class b
implements Consumer {
    public final /* synthetic */ HashMap a;

    public /* synthetic */ b(HashMap hashMap) {
        this.a = hashMap;
    }

    public final void accept(Object object) {
        HashMap hashMap = this.a;
        object = (String)object;
        i.j(hashMap, (String)object);
    }
}

