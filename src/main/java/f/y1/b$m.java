/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.p;
import java.util.Comparator;

public final class b$m
implements Comparator {
    public final /* synthetic */ Comparator a;
    public final /* synthetic */ p b;

    public b$m(Comparator comparator, p p10) {
        this.a = comparator;
        this.b = p10;
    }

    public final int compare(Object object, Object object2) {
        Object object3 = this.a;
        int n10 = object3.compare(object, object2);
        if (n10 == 0) {
            object3 = this.b;
            object = (Number)object3.invoke(object, object2);
            n10 = ((Number)object).intValue();
        }
        return n10;
    }
}

