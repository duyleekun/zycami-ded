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

public class SwipeRefreshLayout$3
extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$3(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation object) {
        object = this.this$0;
        float f11 = 1.0f - f10;
        ((SwipeRefreshLayout)object).setAnimationProgress(f11);
    }
}

