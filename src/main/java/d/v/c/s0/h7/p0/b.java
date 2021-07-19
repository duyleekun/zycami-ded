/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.h7.p0;

import android.view.View;
import d.v.c.s0.h7.p0.o;
import d.v.c.w0.kc;

public final class b
implements View.OnClickListener {
    public final /* synthetic */ o a;
    public final /* synthetic */ kc b;

    public /* synthetic */ b(o o10, kc kc2) {
        this.a = o10;
        this.b = kc2;
    }

    public final void onClick(View view) {
        o o10 = this.a;
        kc kc2 = this.b;
        o10.f(kc2, view);
    }
}

