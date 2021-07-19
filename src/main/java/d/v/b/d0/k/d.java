/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.view.View
 */
package d.v.b.d0.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import d.v.b.d0.k.a;
import d.v.b.d0.k.b;
import d.v.d.h.f;

public class d
extends d.v.b.c0.b {
    private static final String j = "BackgroundColor";
    private static final String k = "rotationY";
    public static final int l = 0;
    public static final int m = 1;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 4;
    public static final int q = 5;
    private View i;

    public d(View view) {
        Integer n10 = 0;
        Integer n11 = 5;
        super(n10, n10, n11);
        this.i = view;
    }

    private void o() {
        View view = this.i;
        int n10 = 2;
        Object object = new int[n10];
        object[0] = -16777216;
        object[1] = -16777216;
        String string2 = j;
        view = ObjectAnimator.ofArgb((Object)view, (String)string2, (int[])object);
        object = this.i;
        Object object2 = new float[n10];
        object2[0] = 0.0f;
        object2[1] = 180.0f;
        object = ObjectAnimator.ofFloat((Object)object, (String)k, (float[])object2);
        object2 = this.i;
        Object object3 = new int[n10];
        object3[0] = 0;
        object3[1] = 0;
        object3 = ObjectAnimator.ofArgb((Object)object2, (String)string2, (int[])object3);
        string2 = new AnimatorSet();
        string2.play((Animator)view).with((Animator)object);
        string2.setDuration(1200L);
        string2.start();
        object3.setStartDelay(1250L);
        object3.start();
    }

    private void p() {
        d.v.d.h.f.a("flash black");
        View view = this.i;
        int[] nArray = new int[]{-16777216, 0};
        view = ObjectAnimator.ofArgb((Object)view, (String)j, (int[])nArray);
        view.setDuration((long)80);
        view.start();
    }

    private void q() {
        View view = this.i;
        b b10 = new b(this);
        view.postDelayed((Runnable)b10, 500L);
    }

    private void r() {
        this.i.setBackgroundColor(-12303292);
    }

    private void s() {
        d.v.d.h.f.a("flash white");
        View view = this.i;
        int[] nArray = new int[]{-1, 0};
        view = ObjectAnimator.ofArgb((Object)view, (String)j, (int[])nArray);
        view.setDuration((long)100);
        view.start();
    }

    private /* synthetic */ void t() {
        this.i.setBackgroundColor(0);
    }

    private /* synthetic */ void v(Integer n10) {
        this.a = n10;
        int n11 = n10;
        this.y(n11);
    }

    private void y(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 == n11) {
                            String string2 = "set Mask FLASH_BLUR_END";
                            d.v.d.h.f.a(string2);
                            this.q();
                        }
                    } else {
                        String string3 = "set Mask FLASH_BLUR_START";
                        d.v.d.h.f.a(string3);
                        this.r();
                    }
                } else {
                    this.o();
                }
            } else {
                this.p();
            }
        } else {
            this.s();
        }
    }

    public void b() {
        super.b();
        this.i = null;
    }

    public /* synthetic */ void u() {
        this.t();
    }

    public /* synthetic */ void w(Integer n10) {
        this.v(n10);
    }

    public void x(Integer n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("set Mask animation =");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.i;
        a a10 = new a(this, n10);
        stringBuilder.postDelayed(a10, 5);
    }
}

