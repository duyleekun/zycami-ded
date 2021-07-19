/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.swiperefreshlayout.widget;

import android.view.animation.Animation;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayout$5
implements Animation.AnimationListener {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$5(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void onAnimationEnd(Animation object) {
        object = this.this$0;
        boolean bl2 = ((SwipeRefreshLayout)object).mScale;
        if (!bl2) {
            bl2 = false;
            ((SwipeRefreshLayout)object).startScaleDownAnimation(null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}

