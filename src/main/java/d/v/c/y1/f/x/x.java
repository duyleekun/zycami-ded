/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.y1.f.x;

import android.view.View;
import d.v.c.y1.f.x.k0;

public final class x
implements View.OnClickListener {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ x(k0 k02, int n10) {
        this.a = k02;
        this.b = n10;
    }

    public final void onClick(View view) {
        k0 k02 = this.a;
        int n10 = this.b;
        k02.s(n10, view);
    }
}

