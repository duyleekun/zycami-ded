/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.c.s0.h7.p0;

import android.view.ViewTreeObserver;
import d.v.c.s0.h7.p0.p;

public class p$b
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ p b;

    public p$b(p p10, int n10) {
        this.b = p10;
        this.a = n10;
    }

    public void onGlobalLayout() {
        p.o((p)this.b).g.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        p p10 = this.b;
        int n10 = this.a;
        p.p(p10, n10);
        p.k(this.b, true);
    }
}

