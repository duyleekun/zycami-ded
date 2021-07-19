/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 */
package d.v.c.s0;

import android.graphics.RectF;
import androidx.core.util.Supplier;
import d.v.c.s0.w6;
import e.a.l;
import e.a.m;

public final class j6
implements m {
    public final /* synthetic */ w6 a;
    public final /* synthetic */ RectF b;
    public final /* synthetic */ Supplier c;

    public /* synthetic */ j6(w6 w62, RectF rectF, Supplier supplier) {
        this.a = w62;
        this.b = rectF;
        this.c = supplier;
    }

    public final void subscribe(l l10) {
        w6 w62 = this.a;
        RectF rectF = this.b;
        Supplier supplier = this.c;
        w62.t(rectF, supplier, l10);
    }
}

