/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.viewpager.widget;

import android.view.animation.Interpolator;

public final class ViewPager$2
implements Interpolator {
    public float getInterpolation(float f10) {
        float f11 = 1.0f;
        return (f10 -= f11) * f10 * f10 * f10 * f10 + f11;
    }
}

