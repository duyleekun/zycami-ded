/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.e0;

import android.graphics.PointF;
import d.v.e0.ae;
import d.v.e0.fe;
import e.a.v0.o;

public final class kb
implements o {
    public final /* synthetic */ fe a;
    public final /* synthetic */ ae b;

    public /* synthetic */ kb(fe fe2, ae ae2) {
        this.a = fe2;
        this.b = ae2;
    }

    public final Object apply(Object object) {
        fe fe2 = this.a;
        ae ae2 = this.b;
        object = (PointF)object;
        return fe2.v(ae2, (PointF)object);
    }
}

