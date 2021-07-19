/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.h1;

import android.view.View;
import d.v.c.h1.o;

public final class b
implements View.OnClickListener {
    public final /* synthetic */ o a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ b(o o10, int n10, int n11) {
        this.a = o10;
        this.b = n10;
        this.c = n11;
    }

    public final void onClick(View view) {
        o o10 = this.a;
        int n10 = this.b;
        int n11 = this.c;
        o10.f(n10, n11, view);
    }
}

