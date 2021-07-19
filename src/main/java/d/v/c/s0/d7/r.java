/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.d7;

import android.view.View;
import d.v.c.s0.d7.x;

public final class r
implements View.OnClickListener {
    public final /* synthetic */ x a;
    public final /* synthetic */ int b;

    public /* synthetic */ r(x x10, int n10) {
        this.a = x10;
        this.b = n10;
    }

    public final void onClick(View view) {
        x x10 = this.a;
        int n10 = this.b;
        x10.c(n10, view);
    }
}

