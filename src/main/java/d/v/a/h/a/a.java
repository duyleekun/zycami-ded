/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.h.a;

import android.view.View;
import d.v.a.h.a.a$a;

public final class a
implements View.OnClickListener {
    public final a$a a;
    public final int b;

    public a(a$a a$a, int n10) {
        this.a = a$a;
        this.b = n10;
    }

    public void onClick(View view) {
        a$a a$a = this.a;
        int n10 = this.b;
        a$a.a(n10, view);
    }
}

