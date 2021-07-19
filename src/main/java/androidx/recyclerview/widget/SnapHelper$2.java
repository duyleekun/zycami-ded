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
package androidx.recyclerview.widget;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.SnapHelper;

public class SnapHelper$2
extends LinearSmoothScroller {
    public final /* synthetic */ SnapHelper this$0;

    public SnapHelper$2(SnapHelper snapHelper, Context context) {
        this.this$0 = snapHelper;
        super(context);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        float f10 = displayMetrics.densityDpi;
        return 100.0f / f10;
    }

    public void onTargetFound(View object, RecyclerView$State object2, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        object2 = this.this$0;
        Object object3 = ((SnapHelper)object2).mRecyclerView;
        if (object3 == null) {
            return;
        }
        object3 = ((RecyclerView)object3).getLayoutManager();
        object = ((SnapHelper)object2).calculateDistanceToFinalSnap((RecyclerView$LayoutManager)object3, (View)object);
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

