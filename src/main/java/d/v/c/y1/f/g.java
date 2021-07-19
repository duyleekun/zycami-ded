/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.y1.f;

import android.view.View;
import d.v.c.y1.f.s;

public final class g
implements View.OnClickListener {
    public final /* synthetic */ s a;
    public final /* synthetic */ int b;

    public /* synthetic */ g(s s10, int n10) {
        this.a = s10;
        this.b = n10;
    }

    public final void onClick(View view) {
        s s10 = this.a;
        int n10 = this.b;
        s10.q(n10, view);
    }
}

