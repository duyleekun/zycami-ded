/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.g.d.s;

import android.util.Size;
import d.v.d.g.d.s.h;
import java.util.Comparator;

public final class e
implements Comparator {
    public static final /* synthetic */ e a;

    static {
        e e10;
        a = e10 = new e();
    }

    public final int compare(Object object, Object object2) {
        object = (Size)object;
        object2 = (Size)object2;
        return h.m1((Size)object, (Size)object2);
    }
}
