/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.h1;

import android.view.View;
import d.v.c.h1.o;

public final class c
implements View.OnLongClickListener {
    public final /* synthetic */ o a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    public /* synthetic */ c(o o10, int n10, int n11) {
        this.a = o10;
        this.b = n10;
        this.c = n11;
    }

    public final boolean onLongClick(View view) {
        o o10 = this.a;
        int n10 = this.b;
        int n11 = this.c;
        return o10.h(n10, n11, view);
    }
}

