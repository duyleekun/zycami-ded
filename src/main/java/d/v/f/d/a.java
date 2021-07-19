/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.f.d;

import android.view.View;
import d.v.f.d.b;

public final class a
implements View.OnClickListener {
    public final /* synthetic */ b a;
    public final /* synthetic */ int b;

    public /* synthetic */ a(b b10, int n10) {
        this.a = b10;
        this.b = n10;
    }

    public final void onClick(View view) {
        b b10 = this.a;
        int n10 = this.b;
        b10.g(n10, view);
    }
}

