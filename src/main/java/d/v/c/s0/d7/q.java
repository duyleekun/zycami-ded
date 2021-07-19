/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.d7;

import android.view.View;
import d.v.c.s0.d7.w;

public final class q
implements View.OnClickListener {
    public final /* synthetic */ w a;
    public final /* synthetic */ int b;

    public /* synthetic */ q(w w10, int n10) {
        this.a = w10;
        this.b = n10;
    }

    public final void onClick(View view) {
        w w10 = this.a;
        int n10 = this.b;
        w10.d(n10, view);
    }
}

