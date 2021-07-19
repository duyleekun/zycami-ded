/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.t.a;

import android.view.View;
import d.t.a.d;

public class d$g
implements View.OnClickListener {
    public final /* synthetic */ d a;

    public d$g(d d10) {
        this.a = d10;
    }

    public void onClick(View view) {
        boolean bl2 = view.isSelected();
        if (!bl2) {
            d d10 = this.a;
            int n10 = view.getId();
            d.q(d10, n10);
        }
    }
}

