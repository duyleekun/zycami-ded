/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.f.f;

import android.view.View;
import d.v.e.l.p1;

public interface d
extends View.OnClickListener {
    public void a(View var1);

    default public void onClick(View view) {
        boolean bl2 = p1.a();
        if (!bl2) {
            this.a(view);
        }
    }
}

