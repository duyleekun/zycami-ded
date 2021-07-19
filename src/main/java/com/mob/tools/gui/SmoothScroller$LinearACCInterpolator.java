/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package com.mob.tools.gui;

import android.view.animation.Interpolator;
import com.mob.tools.gui.SmoothScroller$1;

public class SmoothScroller$LinearACCInterpolator
implements Interpolator {
    private SmoothScroller$LinearACCInterpolator() {
    }

    public /* synthetic */ SmoothScroller$LinearACCInterpolator(SmoothScroller$1 smoothScroller$1) {
        this();
    }

    public float getInterpolation(float f10) {
        return f10 * f10;
    }
}

