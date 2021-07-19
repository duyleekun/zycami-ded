/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import java.util.Comparator;

public final class b$l
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Comparator b;
    public final /* synthetic */ l c;

    public b$l(Comparator comparator, Comparator comparator2, l l10) {
        this.a = comparator;
        this.b = comparator2;
        this.c = l10;
    }

    public final int compare(Object object, Object object2) {
        Comparator comparator = this.a;
        int n10 = comparator.compare(object, object2);
        if (n10 == 0) {
            comparator = this.b;
            object2 = this.c.invoke(object2);
            l l10 = this.c;
            object = l10.invoke(object);
            n10 = comparator.compare(object2, object);
        }
        return n10;
    }
}

