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

public class SwipeRefreshLayout$2
extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;

    public SwipeRefreshLayout$2(SwipeRefreshLayout swipeRefreshLayout) {
        this.this$0 = swipeRefreshLayout;
    }

    public void applyTransformation(float f10, Transformation transformation) {
        this.this$0.setAnimationProgress(f10);
    }
}

