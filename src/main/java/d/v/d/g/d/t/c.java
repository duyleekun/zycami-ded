/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.g.d.t;

import android.util.Size;
import d.v.d.g.d.t.f;
import java.util.Comparator;

public final class c
implements Comparator {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final int compare(Object object, Object object2) {
        object = (Size)object;
        object2 = (Size)object2;
        return f.f1((Size)object, (Size)object2);
    }
}

