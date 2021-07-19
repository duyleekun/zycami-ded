/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.q1.h0;

import android.view.View;
import d.v.c.q1.h0.n0;

public final class h0
implements View.OnClickListener {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ h0(n0 n02, int n10) {
        this.a = n02;
        this.b = n10;
    }

    public final void onClick(View view) {
        n0 n02 = this.a;
        int n10 = this.b;
        n02.f(n10, view);
    }
}

