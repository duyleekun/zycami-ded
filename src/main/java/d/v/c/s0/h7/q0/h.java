/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.q0;

import android.view.View;
import d.v.c.s0.h7.q0.y$b;

public final class h
implements View.OnClickListener {
    public final /* synthetic */ y$b a;
    public final /* synthetic */ int b;

    public /* synthetic */ h(y$b b10, int n10) {
        this.a = b10;
        this.b = n10;
    }

    public final void onClick(View view) {
        y$b y$b = this.a;
        int n10 = this.b;
        y$b.y(n10, view);
    }
}

