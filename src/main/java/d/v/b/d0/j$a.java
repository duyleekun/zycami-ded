/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package d.v.b.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d.v.b.d0.j;
import d.v.d.h.f;

public class j$a
extends AnimatorListenerAdapter {
    public final /* synthetic */ j a;

    public j$a(j j10) {
        this.a = j10;
    }

    public void onAnimationEnd(Animator animator2) {
        f.a("post delayed hide runnable ");
        j.e(this.a, false);
        animator2 = j.g(this.a);
        Runnable runnable = j.f(this.a);
        animator2.removeCallbacks(runnable);
        animator2 = j.g(this.a);
        runnable = j.f(this.a);
        animator2.postDelayed(runnable, 3000L);
    }
}

