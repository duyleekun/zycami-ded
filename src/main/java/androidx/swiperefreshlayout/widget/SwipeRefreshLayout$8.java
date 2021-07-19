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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class SwipeRefreshLayout$8
extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$8(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation object) {
        object = this.this$0;
        float f11 = ((SwipeRefreshLayout)object).mStartingScale;
        float f12 = -f11 * f10;
        ((SwipeRefreshLayout)object).setAnimationProgress(f11 += f12);
        this.this$0.moveToStart(f10);
    }
}

