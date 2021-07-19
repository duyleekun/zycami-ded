/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.t.a;

import android.view.View;
import d.t.a.c;

public class c$g
implements View.OnClickListener {
    public final /* synthetic */ c a;

    public c$g(c c10) {
        this.a = c10;
    }

    public void onClick(View view) {
        boolean bl2 = view.isSelected();
        if (!bl2) {
            c c10 = this.a;
            int n10 = view.getId();
            c.o(c10, n10);
        }
    }
}

