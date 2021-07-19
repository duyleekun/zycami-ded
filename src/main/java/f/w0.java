/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class w0 {
    public static final Pair a(Object object, Object object2) {
        Pair pair = new Pair(object, object2);
        return pair;
    }

    public static final List b(Pair object) {
        f0.p(object, "$this$toList");
        Object object2 = ((Pair)object).getFirst();
        Object[] objectArray = new Object[]{object2, object = ((Pair)object).getSecond()};
        return CollectionsKt__CollectionsKt.L(objectArray);
    }

    public static final List c(Triple object) {
        f0.p(object, "$this$toList");
        Object object2 = ((Triple)object).getFirst();
        Object[] objectArray = new Object[]{object2, object2 = ((Triple)object).getSecond(), object = ((Triple)object).getThird()};
        return CollectionsKt__CollectionsKt.L(objectArray);
    }
}

