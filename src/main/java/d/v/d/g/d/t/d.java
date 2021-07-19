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

public final class d
implements Comparator {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final int compare(Object object, Object object2) {
        object = (Size)object;
        object2 = (Size)object2;
        return f.e1((Size)object, (Size)object2);
    }
}

