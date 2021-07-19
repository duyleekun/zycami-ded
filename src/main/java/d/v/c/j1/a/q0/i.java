/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow
 */
package d.v.c.j1.a.q0;

import android.view.View;
import android.widget.PopupWindow;
import d.v.c.j1.a.q0.l;

public final class i
implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ PopupWindow b;

    public /* synthetic */ i(View view, PopupWindow popupWindow) {
        this.a = view;
        this.b = popupWindow;
    }

    public final void run() {
        View view = this.a;
        PopupWindow popupWindow = this.b;
        l.f(view, popupWindow);
    }
}

