/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package d.q.a.f0;

import android.view.View;
import e.a.d;
import e.a.q0.a;

public final class b$a
extends a
implements View.OnAttachStateChangeListener {
    private final View b;
    private final d c;

    public b$a(View view, d d10) {
        this.b = view;
        this.c = d10;
    }

    public void a() {
        this.b.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View object) {
        boolean bl2 = this.isDisposed();
        if (!bl2) {
            object = this.c;
            object.onComplete();
        }
    }
}

