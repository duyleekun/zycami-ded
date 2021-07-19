/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g;

import androidx.arch.core.util.Function;
import d.v.j.g.y;
import java.util.Comparator;

public final class m
implements Comparator {
    public final /* synthetic */ Function a;

    public /* synthetic */ m(Function function) {
        this.a = function;
    }

    public final int compare(Object object, Object object2) {
        return y.h(this.a, object, object2);
    }
}

