/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import f.y1.b;
import java.util.Comparator;

public final class b$i
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ l b;

    public b$i(Comparator comparator, l l10) {
        this.a = comparator;
        this.b = l10;
    }

    public final int compare(Object object, Object object2) {
        Object object3 = this.a;
        int n10 = object3.compare(object, object2);
        if (n10 == 0) {
            object = (Comparable)this.b.invoke(object);
            object3 = this.b;
            object2 = (Comparable)object3.invoke(object2);
            n10 = f.y1.b.g((Comparable)object, (Comparable)object2);
        }
        return n10;
    }
}

