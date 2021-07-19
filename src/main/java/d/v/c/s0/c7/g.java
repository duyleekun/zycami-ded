/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.AnimationDrawable
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.s0.c7;

import android.graphics.drawable.AnimationDrawable;
import android.widget.PopupWindow;
import d.v.c.s0.c7.p;
import d.v.c.s0.s6;

public final class g
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ AnimationDrawable a;
    public final /* synthetic */ s6 b;

    public /* synthetic */ g(AnimationDrawable animationDrawable, s6 s62) {
        this.a = animationDrawable;
        this.b = s62;
    }

    public final void onDismiss() {
        AnimationDrawable animationDrawable = this.a;
        s6 s62 = this.b;
        p.h(animationDrawable, s62);
    }
}

