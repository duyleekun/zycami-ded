/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.w0;

import android.view.View;
import d.v.c.y1.h.i$a;

public class o6$b
implements View.OnClickListener {
    private i$a a;

    public o6$b b(i$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.c(view);
    }
}

