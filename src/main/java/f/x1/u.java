/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.a;
import f.h2.t.f0;
import f.w0;
import f.x1.u$a;
import f.x1.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

public class u
extends CollectionsKt__CollectionsKt {
    private static final Iterable X(a a10) {
        u$a u$a = new u$a(a10);
        return u$a;
    }

    public static final int Y(Iterable iterable, int n10) {
        String string2 = "$this$collectionSizeOrDefault";
        f0.p(iterable, string2);
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = (Collection)iterable;
            n10 = iterable.size();
        }
        return n10;
    }

    public static final Integer Z(Iterable object) {
        String string2 = "$this$collectionSizeOrNull";
        f0.p(object, string2);
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            int n10 = ((Collection)object).size();
            object = n10;
        } else {
            boolean bl3 = false;
            object = null;
        }
        return object;
    }

    public static final Collection a0(Iterable object) {
        Object object2 = "$this$convertToSetForSetOperation";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof Set;
        if (bl2) {
            object = (Collection)object;
        } else {
            bl2 = object instanceof Collection;
            if (bl2) {
                object2 = object;
                object2 = (Collection)object;
                boolean bl3 = u.d0((Collection)object2);
                object = bl3 ? CollectionsKt___CollectionsKt.G5((Iterable)object) : object2;
            } else {
                object = CollectionsKt___CollectionsKt.G5((Iterable)object);
            }
        }
        return object;
    }

    public static final Collection b0(Iterable iterable, Iterable iterable2) {
        f0.p(iterable, "$this$convertToSetForSetOperationWith");
        String string2 = "source";
        f0.p(iterable2, string2);
        int n10 = iterable instanceof Set;
        if (n10 != 0) {
            iterable = (Collection)iterable;
        } else {
            n10 = iterable instanceof Collection;
            if (n10 != 0) {
                int n11;
                n10 = iterable2 instanceof Collection;
                if (n10 != 0 && (n11 = (iterable2 = (Collection)iterable2).size()) < (n10 = 2)) {
                    iterable = (Collection)iterable;
                } else {
                    iterable2 = iterable;
                    iterable2 = (Collection)iterable;
                    n10 = (int)(u.d0((Collection)iterable2) ? 1 : 0);
                    iterable = n10 != 0 ? CollectionsKt___CollectionsKt.G5(iterable) : iterable2;
                }
            } else {
                iterable = CollectionsKt___CollectionsKt.G5(iterable);
            }
        }
        return iterable;
    }

    public static final List c0(Iterable object) {
        boolean bl2;
        f0.p(object, "$this$flatten");
        ArrayList arrayList = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Iterable iterable = (Iterable)object.next();
            y.q0(arrayList, iterable);
        }
        return arrayList;
    }

    private static final boolean d0(Collection collection) {
        boolean bl2;
        int n10;
        int n11 = collection.size();
        if (n11 > (n10 = 2) && (bl2 = collection instanceof ArrayList)) {
            bl2 = true;
        } else {
            bl2 = false;
            collection = null;
        }
        return bl2;
    }

    public static final Pair e0(Iterable object) {
        Object object2 = "$this$unzip";
        f0.p(object, (String)object2);
        int n10 = u.Y((Iterable)object, 10);
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        ArrayList<Object> arrayList2 = new ArrayList<Object>(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Pair)object.next();
            Object object3 = ((Pair)object2).getFirst();
            arrayList.add(object3);
            object2 = ((Pair)object2).getSecond();
            arrayList2.add(object2);
        }
        return w0.a(arrayList, arrayList2);
    }
}

