/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package d.v.c.s0.h7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import d.v.c.s0.h7.k0;
import e.a.b0;

public class k0$b
extends AnimatorListenerAdapter {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ k0 b;

    public k0$b(k0 k02, b0 b02) {
        this.b = k02;
        this.a = b02;
    }

    public void onAnimationEnd(Animator animator2) {
        this.a.onComplete();
    }
}

