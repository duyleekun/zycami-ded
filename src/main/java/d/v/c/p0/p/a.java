/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0.p;

import android.view.View;
import d.v.c.p0.p.e;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ e a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(e e10, int n10) {
        this.a = e10;
        this.b = n10;
    }

    public final void onClick(View view) {
        e e10 = this.a;
        int n10 = this.b;
        e10.o(n10, view);
    }
}

