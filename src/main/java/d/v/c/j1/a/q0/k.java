/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.widget.PopupWindow
 */
package d.v.c.j1.a.q0;

import android.view.View;
import android.widget.PopupWindow;
import d.v.c.j1.a.q0.l;

public final class k
implements View.OnClickListener {
    public final /* synthetic */ PopupWindow a;

    public /* synthetic */ k(PopupWindow popupWindow) {
        this.a = popupWindow;
    }

    public final void onClick(View view) {
        l.b(this.a, view);
    }
}

