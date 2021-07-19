/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import java.util.Comparator;

public final class b$h
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ Comparator b;

    public b$h(Comparator comparator, Comparator comparator2) {
        this.a = comparator;
        this.b = comparator2;
    }

    public final int compare(Object object, Object object2) {
        Comparator comparator = this.a;
        int n10 = comparator.compare(object, object2);
        if (n10 == 0) {
            comparator = this.b;
            n10 = comparator.compare(object, object2);
        }
        return n10;
    }
}

