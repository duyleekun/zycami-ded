/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.r0;

import android.view.View;
import d.v.c.s0.h7.r0.t$b;

public final class j
implements View.OnClickListener {
    public final /* synthetic */ t$b a;
    public final /* synthetic */ int b;

    public /* synthetic */ j(t$b b10, int n10) {
        this.a = b10;
        this.b = n10;
    }

    public final void onClick(View view) {
        t$b t$b = this.a;
        int n10 = this.b;
        t$b.h(n10, view);
    }
}

