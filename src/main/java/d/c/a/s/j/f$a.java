/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package d.c.a.s.j;

import android.view.View;
import d.c.a.s.j.f;

public class f$a
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    public void onViewAttachedToWindow(View view) {
        this.a.q();
    }

    public void onViewDetachedFromWindow(View view) {
        this.a.o();
    }
}

