/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import d.v.j.g.y;
import java.util.List;

public final class n
implements Function {
    public final /* synthetic */ List a;
    public final /* synthetic */ Function b;

    public /* synthetic */ n(List list, Function function) {
        this.a = list;
        this.b = function;
    }

    public final Object apply(Object object) {
        List list = this.a;
        Function function = this.b;
        object = (List)object;
        y.i(list, function, (List)object);
        return object;
    }
}

