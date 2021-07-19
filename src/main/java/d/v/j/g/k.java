/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseIntArray
 */
package d.v.j.g;

import android.util.SparseIntArray;
import androidx.arch.core.util.Function;
import d.v.j.g.y;
import java.util.Comparator;

public final class k
implements Comparator {
    public final /* synthetic */ SparseIntArray a;
    public final /* synthetic */ Function b;

    public /* synthetic */ k(SparseIntArray sparseIntArray, Function function) {
        this.a = sparseIntArray;
        this.b = function;
    }

    public final int compare(Object object, Object object2) {
        SparseIntArray sparseIntArray = this.a;
        Function function = this.b;
        return y.g(sparseIntArray, function, object, object2);
    }
}

