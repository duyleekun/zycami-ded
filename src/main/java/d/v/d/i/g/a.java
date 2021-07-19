/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.d.i.g;

import android.util.Size;
import d.v.d.i.g.k;
import java.util.function.Consumer;

public final class a
implements Consumer {
    public final /* synthetic */ k a;
    public final /* synthetic */ Integer b;
    public final /* synthetic */ int c;

    public /* synthetic */ a(k k10, Integer n10, int n11) {
        this.a = k10;
        this.b = n10;
        this.c = n11;
    }

    public final void accept(Object object) {
        k k10 = this.a;
        Integer n10 = this.b;
        int n11 = this.c;
        object = (Size)object;
        k10.w(n10, n11, (Size)object);
    }
}

