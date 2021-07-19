/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import f.y1.b;
import java.util.Comparator;

public final class b$b
implements Comparator {
    public final /* synthetic */ l a;

    public b$b(l l10) {
        this.a = l10;
    }

    public final int compare(Object object, Object object2) {
        object = (Comparable)this.a.invoke(object);
        object2 = (Comparable)this.a.invoke(object2);
        return b.g((Comparable)object, (Comparable)object2);
    }
}

