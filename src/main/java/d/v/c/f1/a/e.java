/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.f1.a;

import android.view.View;
import d.v.c.f1.a.e$a;

public final class e
implements View.OnLongClickListener {
    public final e$a a;
    public final int b;

    public e(e$a e$a, int n10) {
        this.a = e$a;
        this.b = n10;
    }

    public boolean onLongClick(View view) {
        e$a e$a = this.a;
        int n10 = this.b;
        return e$a.h(n10, view);
    }
}

