/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 */
package d.q.a.f0;

import android.os.Build;
import android.view.View;
import com.uber.autodispose.OutsideScopeException;
import d.q.a.f0.b$a;
import d.q.a.f0.e.c;
import e.a.d;
import e.a.g;
import e.a.q0.a;

public final class b
implements g {
    private final View a;

    public b(View view) {
        this.a = view;
    }

    public void f(d d10) {
        View view = this.a;
        Object object = new b$a(view, d10);
        d10.onSubscribe((e.a.s0.b)object);
        int n10 = c.a();
        if (n10 == 0) {
            object = new IllegalStateException("Views can only be bound to on the main thread!");
            d10.onError((Throwable)object);
            return;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (n10 = (int)((view = this.a).isAttachedToWindow() ? 1 : 0)) != 0 || (view = this.a.getWindowToken()) != null) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        if (n10 == 0) {
            object = new OutsideScopeException("View is not attached!");
            d10.onError((Throwable)object);
            return;
        }
        d10 = this.a;
        d10.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
        boolean bl2 = ((a)object).isDisposed();
        if (bl2) {
            d10 = this.a;
            d10.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)object);
        }
    }
}

