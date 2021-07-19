/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.s0.c7;

import android.widget.PopupWindow;
import d.v.c.s0.c7.p;
import d.v.c.s0.s6;

public final class b
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ s6 a;

    public /* synthetic */ b(s6 s62) {
        this.a = s62;
    }

    public final void onDismiss() {
        p.l(this.a);
    }
}

