/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import java.util.Comparator;

public final class b$f
implements Comparator {
    public final /* synthetic */ Comparator a;

    public b$f(Comparator comparator) {
        this.a = comparator;
    }

    public final int compare(Object object, Object object2) {
        int n10;
        if (object == object2) {
            n10 = 0;
            object = null;
        } else if (object == null) {
            n10 = -1;
        } else if (object2 == null) {
            n10 = 1;
        } else {
            Comparator comparator = this.a;
            n10 = comparator.compare(object, object2);
        }
        return n10;
    }
}

