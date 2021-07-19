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

public final class d
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ p a;
    public final /* synthetic */ s6 b;

    public /* synthetic */ d(p p10, s6 s62) {
        this.a = p10;
        this.b = s62;
    }

    public final void onDismiss() {
        p p10 = this.a;
        s6 s62 = this.b;
        p10.j(s62);
    }
}

