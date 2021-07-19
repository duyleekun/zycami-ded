/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.CircleImageView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayout$1
implements Animation.AnimationListener {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$1(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation object) {
        object = this.this$0;
        int n10 = ((SwipeRefreshLayout)object).mRefreshing;
        if (n10 != 0) {
            ((SwipeRefreshLayout)object).mProgress.setAlpha(255);
            this.this$0.mProgress.start();
            object = this.this$0;
            n10 = ((SwipeRefreshLayout)object).mNotify;
            if (n10 != 0 && (object = ((SwipeRefreshLayout)object).mListener) != null) {
                object.onRefresh();
            }
            object = this.this$0;
            CircleImageView circleImageView = ((SwipeRefreshLayout)object).mCircleView;
            ((SwipeRefreshLayout)object).mCurrentTargetOffsetTop = n10 = circleImageView.getTop();
        } else {
            ((SwipeRefreshLayout)object).reset();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

