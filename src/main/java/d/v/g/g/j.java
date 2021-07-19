/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 */
package d.v.g.g;

import android.util.SparseArray;
import d.v.g.g.c1;
import java.util.function.IntPredicate;

public final class j
implements IntPredicate {
    public final /* synthetic */ SparseArray a;

    public /* synthetic */ j(SparseArray sparseArray) {
        this.a = sparseArray;
    }

    public final boolean test(int n10) {
        return c1.v(this.a, n10);
    }
}

