/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.c.z0;

import android.view.View;
import android.view.ViewTreeObserver;
import d.v.c.z0.k;

public class k$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ k a;

    public k$a(k k10) {
        this.a = k10;
    }

    public void onGlobalLayout() {
        int n10;
        k k10 = this.a;
        int n11 = k.u(k10);
        if (n11 == (n10 = -2)) {
            k10 = this.a;
            View view = k10.getView();
            n10 = view.getHeight();
            k.v(k10, n10);
        }
        this.a.getView().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
        k.w(this.a);
    }
}

