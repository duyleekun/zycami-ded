/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.a.g;

import android.view.View;
import d.v.a.i.a.v0.m$b;

public class d$c
implements View.OnClickListener {
    private m$b a;

    public d$c b(m$b object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void onClick(View view) {
        this.a.a(view);
    }
}

