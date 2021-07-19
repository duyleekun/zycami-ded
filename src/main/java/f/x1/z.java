/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.l2.k;
import f.x1.y;
import f.x1.y0;
import f.x1.z0;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

public class z
extends y {
    public static final /* synthetic */ int W0(List list, int n10) {
        return z.a1(list, n10);
    }

    public static final /* synthetic */ int X0(List list, int n10) {
        return z.b1(list, n10);
    }

    public static final List Y0(List list) {
        f0.p(list, "$this$asReversed");
        z0 z02 = new z0(list);
        return z02;
    }

    public static final List Z0(List list) {
        f0.p(list, "$this$asReversed");
        y0 y02 = new y0(list);
        return y02;
    }

    private static final int a1(List object, int n10) {
        int n11 = CollectionsKt__CollectionsKt.G((List)object);
        if (n10 >= 0 && n11 >= n10) {
            return CollectionsKt__CollectionsKt.G((List)object) - n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Element index ");
        stringBuilder.append(n10);
        stringBuilder.append(" must be in range [");
        int n12 = CollectionsKt__CollectionsKt.G((List)object);
        k k10 = new k(0, n12);
        stringBuilder.append(k10);
        stringBuilder.append("].");
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }

    private static final int b1(List object, int n10) {
        int n11 = object.size();
        if (n10 >= 0 && n11 >= n10) {
            return object.size() - n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Position index ");
        stringBuilder.append(n10);
        stringBuilder.append(" must be in range [");
        int n12 = object.size();
        k k10 = new k(0, n12);
        stringBuilder.append(k10);
        stringBuilder.append("].");
        object = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException((String)object);
        throw indexOutOfBoundsException;
    }
}

