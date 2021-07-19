/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.c.s0;

import android.graphics.PointF;
import androidx.core.util.Supplier;
import d.v.c.s0.w6;
import d.v.e0.fe$b;

public class w6$b
implements fe$b {
    public final /* synthetic */ Supplier a;
    public final /* synthetic */ w6 b;

    public w6$b(w6 w62, Supplier supplier) {
        this.b = w62;
        this.a = supplier;
    }

    public PointF a() {
        return w6.d(this.b);
    }

    public float b() {
        return ((Float)this.a.get()).floatValue();
    }
}

