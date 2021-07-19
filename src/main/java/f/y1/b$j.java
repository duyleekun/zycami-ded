/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import java.util.Comparator;

public final class b$j
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Comparator b;
    public final /* synthetic */ l c;

    public b$j(Comparator comparator, Comparator comparator2, l l10) {
        this.a = comparator;
        this.b = comparator2;
        this.c = l10;
    }

    public final int compare(Object object, Object object2) {
        Comparator comparator = this.a;
        int n10 = comparator.compare(object, object2);
        if (n10 == 0) {
            comparator = this.b;
            object = this.c.invoke(object);
            l l10 = this.c;
            object2 = l10.invoke(object2);
            n10 = comparator.compare(object, object2);
        }
        return n10;
    }
}

