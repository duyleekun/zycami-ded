/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7.o0;

import d.v.c.s0.h7.o0.w0;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public final class b0
implements Consumer {
    public final /* synthetic */ w0 a;
    public final /* synthetic */ List b;

    public /* synthetic */ b0(w0 w02, List list) {
        this.a = w02;
        this.b = list;
    }

    public final void accept(Object object) {
        w0 w02 = this.a;
        List list = this.b;
        object = (Map.Entry)object;
        w02.e0(list, (Map.Entry)object);
    }
}

