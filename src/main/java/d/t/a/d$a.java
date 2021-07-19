/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.view.ViewPropertyAnimator
 *  android.view.animation.AccelerateInterpolator
 */
package d.t.a;

import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import d.t.a.d;
import d.t.a.d$j;
import d.t.a.e;
import d.t.a.j.b$b;

public class d$a
implements b$b {
    public final /* synthetic */ d a;

    public d$a(d d10) {
        this.a = d10;
    }

    public void a(float f10) {
        d.i(this.a, f10);
    }

    public void b() {
        ViewPropertyAnimator viewPropertyAnimator = d.j(this.a).animate().alpha(1.0f).setDuration(300L);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        viewPropertyAnimator.setInterpolator((TimeInterpolator)accelerateInterpolator);
        d.k(this.a).setClickable(false);
        d.l(this.a).b(false);
    }

    public void c(Exception object) {
        e e10 = d.l(this.a);
        object = this.a.u((Throwable)object);
        e10.a((d$j)object);
    }

    public void d(float f10) {
        d.h(this.a, f10);
    }
}

