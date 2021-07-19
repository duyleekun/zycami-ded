/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.y1.f.x;

import android.view.View;
import d.v.c.y1.f.x.j0;

public final class w
implements View.OnLongClickListener {
    public final /* synthetic */ j0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ w(j0 j02, int n10) {
        this.a = j02;
        this.b = n10;
    }

    public final boolean onLongClick(View view) {
        j0 j02 = this.a;
        int n10 = this.b;
        return j02.t(n10, view);
    }
}

