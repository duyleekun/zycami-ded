/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.o;

import d.v.z.o.i;
import java.util.function.Predicate;

public final class a
implements Predicate {
    public final /* synthetic */ byte[] a;

    public /* synthetic */ a(byte[] byArray) {
        this.a = byArray;
    }

    public final boolean test(Object object) {
        byte[] byArray = this.a;
        object = (Enum)object;
        return i.h(byArray, (Enum)object);
    }
}

