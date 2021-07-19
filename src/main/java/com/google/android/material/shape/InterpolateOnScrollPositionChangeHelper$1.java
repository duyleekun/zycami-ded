/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 */
package com.google.android.material.shape;

import android.view.ViewTreeObserver;
import com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper;

public class InterpolateOnScrollPositionChangeHelper$1
implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ InterpolateOnScrollPositionChangeHelper this$0;

    public InterpolateOnScrollPositionChangeHelper$1(InterpolateOnScrollPositionChangeHelper interpolateOnScrollPositionChangeHelper) {
        this.this$0 = interpolateOnScrollPositionChangeHelper;
    }

    public void onScrollChanged() {
        this.this$0.updateInterpolationForScreenPosition();
    }
}

