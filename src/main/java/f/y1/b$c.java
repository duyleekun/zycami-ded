/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import java.util.Comparator;

public final class b$c
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ l b;

    public b$c(Comparator comparator, l l10) {
        this.a = comparator;
        this.b = l10;
    }

    public final int compare(Object object, Object object2) {
        Comparator comparator = this.a;
        object = this.b.invoke(object);
        object2 = this.b.invoke(object2);
        return comparator.compare(object, object2);
    }
}

