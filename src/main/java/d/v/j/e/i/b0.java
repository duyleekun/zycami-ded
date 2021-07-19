/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.arch.core.util.Function;
import d.v.j.e.i.c1;
import java.util.List;

public final class b0
implements Function {
    public final /* synthetic */ List a;

    public /* synthetic */ b0(List list) {
        this.a = list;
    }

    public final Object apply(Object object) {
        List list = this.a;
        object = (List)object;
        return c1.E(list, (List)object);
    }
}

