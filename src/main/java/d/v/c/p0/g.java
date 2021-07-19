/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.p0;

import android.view.View;
import d.v.c.p0.m;

public final class g
implements View.OnClickListener {
    public final /* synthetic */ View.OnClickListener a;

    public /* synthetic */ g(View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    public final void onClick(View view) {
        m.o(this.a, view);
    }
}

