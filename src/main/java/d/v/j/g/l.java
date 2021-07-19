/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import d.v.j.g.y;
import java.util.List;

public final class l
implements Function {
    public final /* synthetic */ Function a;

    public /* synthetic */ l(Function function) {
        this.a = function;
    }

    public final Object apply(Object object) {
        Function function = this.a;
        object = (List)object;
        y.j(function, (List)object);
        return object;
    }
}

