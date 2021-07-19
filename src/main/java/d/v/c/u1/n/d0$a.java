/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.c.u1.n;

import android.view.ViewTreeObserver;
import d.v.c.u1.n.d0;

public class d0$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ d0 a;

    public d0$a(d0 d02) {
        this.a = d02;
    }

    public void onGlobalLayout() {
        d0.x(this.a).getRoot().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        d0.y(this.a);
    }
}

