/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package d.c.a.s.j;

import android.view.View;
import d.c.a.s.j.r;

public class r$a
implements View.OnAttachStateChangeListener {
    public final /* synthetic */ r a;

    public r$a(r r10) {
        this.a = r10;
    }

    public void onViewAttachedToWindow(View view) {
        this.a.o();
    }

    public void onViewDetachedFromWindow(View view) {
        this.a.n();
    }
}

