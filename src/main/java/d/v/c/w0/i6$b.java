/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import d.v.c.n1.h2$b;

public class i6$b
implements View.OnClickListener {
    private h2$b a;

    public i6$b b(h2$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.c(view);
    }
}

