/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Transformation
 */
package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayout$6
extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$6(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation object) {
        int n10;
        object = this.this$0;
        int n11 = ((SwipeRefreshLayout)object).mUsingCustomStart;
        if (n11 == 0) {
            n11 = ((SwipeRefreshLayout)object).mSpinnerOffsetEnd;
            n10 = Math.abs(((SwipeRefreshLayout)object).mOriginalOffsetTop);
            n11 -= n10;
        } else {
            n11 = ((SwipeRefreshLayout)object).mSpinnerOffsetEnd;
        }
        object = this.this$0;
        int n12 = ((SwipeRefreshLayout)object).mFrom;
        n11 = (int)((float)(n11 - n12) * f10);
        n12 += n11;
        n10 = ((SwipeRefreshLayout)object).mCircleView.getTop();
        this.this$0.setTargetOffsetTopAndBottom(n12 -= n10);
        object = this.this$0.mProgress;
        float f11 = 1.0f - f10;
        ((CircularProgressDrawable)((Object)object)).setArrowScale(f11);
    }
}

