/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.n1;

import android.view.View;
import d.v.c.n1.i2;

public final class w
implements View.OnClickListener {
    public final /* synthetic */ i2 a;
    public final /* synthetic */ String b;

    public /* synthetic */ w(i2 i22, String string2) {
        this.a = i22;
        this.b = string2;
    }

    public final void onClick(View view) {
        i2 i22 = this.a;
        String string2 = this.b;
        i22.H(string2, view);
    }
}

