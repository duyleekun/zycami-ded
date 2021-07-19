/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import d.v.c.s0.a7.l1$b;

public class k2$b
implements View.OnClickListener {
    private l1$b a;

    public k2$b b(l1$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.g(view);
    }
}

