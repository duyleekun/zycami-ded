/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.d7;

import android.view.View;
import d.v.c.s0.d7.y;

public final class s
implements View.OnClickListener {
    public final /* synthetic */ y a;
    public final /* synthetic */ int b;

    public /* synthetic */ s(y y10, int n10) {
        this.a = y10;
        this.b = n10;
    }

    public final void onClick(View view) {
        y y10 = this.a;
        int n10 = this.b;
        y10.d(n10, view);
    }
}

