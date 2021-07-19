/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import f.y1.b;
import java.util.Comparator;

public final class b$k
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ l b;

    public b$k(Comparator comparator, l l10) {
        this.a = comparator;
        this.b = l10;
    }

    public final int compare(Object object, Object object2) {
        Object object3 = this.a;
        int n10 = object3.compare(object, object2);
        if (n10 == 0) {
            object2 = (Comparable)this.b.invoke(object2);
            object3 = this.b;
            object = (Comparable)object3.invoke(object);
            n10 = f.y1.b.g((Comparable)object2, (Comparable)object);
        }
        return n10;
    }
}

