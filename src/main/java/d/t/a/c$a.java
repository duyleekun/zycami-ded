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
import d.t.a.c;
import d.t.a.j.b$b;

public class c$a
implements b$b {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void a(float f10) {
        c.f(this.a, f10);
    }

    public void b() {
        ViewPropertyAnimator viewPropertyAnimator = c.h(this.a).animate().alpha(1.0f).setDuration(300L);
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        viewPropertyAnimator.setInterpolator((TimeInterpolator)accelerateInterpolator);
        c.i(this.a).setClickable(false);
        c.j(this.a, false);
        this.a.supportInvalidateOptionsMenu();
    }

    public void c(Exception exception) {
        this.a.B(exception);
        this.a.finish();
    }

    public void d(float f10) {
        c.d(this.a, f10);
    }
}

