/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.Animation
 */
package d.v.f.e;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import d.v.e.l.h2;
import d.v.f.f.d;

public class c {
    public static void a(View view, boolean n10) {
        n10 = n10 != 0 ? 0 : 8;
        view.setVisibility(n10);
    }

    public static void b(View view, Animation animation) {
        if (animation != null) {
            view.startAnimation(animation);
            boolean bl2 = false;
            animation = null;
            view.setVisibility(0);
        } else {
            view.clearAnimation();
            int n10 = 8;
            view.setVisibility(n10);
        }
    }

    public static void c(View view, Animation animation) {
        if (animation != null) {
            view.startAnimation(animation);
            boolean bl2 = false;
            animation = null;
            view.setVisibility(0);
        } else {
            view.clearAnimation();
            int n10 = 4;
            view.setVisibility(n10);
        }
    }

    public static void d(View view, String string2) {
        Object object = view.getParent();
        int n10 = object instanceof ConstraintLayout;
        if (n10 == 0) {
            return;
        }
        n10 = string2.indexOf(58);
        if (n10 < 0) {
            n10 = string2.indexOf(47);
        }
        if (n10 < 0) {
            return;
        }
        object = (ConstraintLayout$LayoutParams)view.getLayoutParams();
        object.dimensionRatio = string2;
        view.setLayoutParams((ViewGroup.LayoutParams)object);
    }

    public static void e(View view, int n10, int n11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams)view.getLayoutParams();
        marginLayoutParams.topMargin = n10 = h2.b(n10);
        marginLayoutParams.bottomMargin = n10 = h2.b(n11);
        view.setLayoutParams((ViewGroup.LayoutParams)marginLayoutParams);
    }

    public static void f(View view, d d10) {
        view.setOnClickListener((View.OnClickListener)d10);
    }
}

