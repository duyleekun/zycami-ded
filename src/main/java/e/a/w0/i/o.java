/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class o
implements e.a.v0.o {
    public final Comparator a;

    public o(Comparator comparator) {
        this.a = comparator;
    }

    public List a(List list) {
        Comparator comparator = this.a;
        Collections.sort(list, comparator);
        return list;
    }
}

