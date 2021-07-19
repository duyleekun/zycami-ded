/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.g0.u.a;

import android.view.View;
import d.v.g0.u.a.b$a;

public final class b
implements View.OnClickListener {
    public final b$a a;
    public final int b;

    public b(b$a b$a, int n10) {
        this.a = b$a;
        this.b = n10;
    }

    public void onClick(View view) {
        b$a b$a = this.a;
        int n10 = this.b;
        b$a.a(n10, view);
    }
}

