/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.z0;

import android.view.View;
import d.v.c.z0.h;

public class h$a {
    public final /* synthetic */ h a;

    public h$a(h h10) {
        this.a = h10;
    }

    public void a(View view) {
        this.a.dismissAllowingStateLoss();
        View.OnClickListener onClickListener = h.u(this.a);
        if (onClickListener != null) {
            onClickListener = h.u(this.a);
            onClickListener.onClick(view);
        }
    }

    public void b(View object) {
        object = this.a.getActivity();
        if (object != null) {
            object = this.a.getActivity();
            object.finish();
        }
    }
}

