/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.y1.f.x;

import android.view.View;
import android.widget.PopupWindow;
import d.v.c.y1.f.x.f0;

public final class a
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ View a;

    public /* synthetic */ a(View view) {
        this.a = view;
    }

    public final void onDismiss() {
        f0.E(this.a);
    }
}

