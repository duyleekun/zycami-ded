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

public class SwipeRefreshLayout$4
extends Animation {
    public final /* synthetic */ SwipeRefreshLayout this$0;
    public final /* synthetic */ int val$endingAlpha;
    public final /* synthetic */ int val$startingAlpha;

    public SwipeRefreshLayout$4(SwipeRefreshLayout swipeRefreshLayout, int n10, int n11) {
        this.this$0 = swipeRefreshLayout;
        this.val$startingAlpha = n10;
        this.val$endingAlpha = n11;
    }

    public void applyTransformation(float f10, Transformation object) {
        object = this.this$0.mProgress;
        int n10 = this.val$startingAlpha;
        float f11 = n10;
        float f12 = (float)(this.val$endingAlpha - n10) * f10;
        int n11 = (int)(f11 + f12);
        ((CircularProgressDrawable)((Object)object)).setAlpha(n11);
    }
}

