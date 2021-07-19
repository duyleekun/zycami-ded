/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 */
package d.v.c.u1.n;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action;
import androidx.recyclerview.widget.RecyclerView$State;
import d.v.c.u1.n.e0;

public class e0$a
extends LinearSmoothScroller {
    public final /* synthetic */ e0 a;

    public e0$a(e0 e02, Context context) {
        this.a = e02;
        super(context);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        float f10 = displayMetrics.densityDpi;
        return 70.0f / f10;
    }

    public void onTargetFound(View object, RecyclerView$State object2, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        object2 = this.a;
        RecyclerView$LayoutManager recyclerView$LayoutManager = e0.a((e0)object2).getLayoutManager();
        object = ((e0)object2).calculateDistanceToFinalSnap(recyclerView$LayoutManager, (View)object);
        object2 = null;
        View view = object[0];
        View view2 = object[1];
        int n10 = Math.abs((int)view);
        int n11 = Math.abs((int)view2);
        n10 = Math.max(n10, n11);
        if ((n10 = this.calculateTimeForDeceleration(n10)) > 0) {
            DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
            recyclerView$SmoothScroller$Action.update((int)view, (int)view2, n10, (Interpolator)decelerateInterpolator);
        }
    }
}

