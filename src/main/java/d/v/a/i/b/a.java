/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.i.b;

import android.view.View;
import d.v.a.i.b.d;
import d.v.a.i.b.e;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ e c;

    public /* synthetic */ a(d d10, int n10, e e10) {
        this.a = d10;
        this.b = n10;
        this.c = e10;
    }

    public final void onClick(View view) {
        d d10 = this.a;
        int n10 = this.b;
        e e10 = this.c;
        d10.f(n10, e10, view);
    }
}

