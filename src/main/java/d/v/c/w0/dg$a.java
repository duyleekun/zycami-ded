/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import d.v.c.m1.d.k$a;

public class dg$a
implements View.OnClickListener {
    private k$a a;

    public dg$a b(k$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.c(view);
    }
}

