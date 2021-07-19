/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package com.mob.tools.gui;

import android.view.animation.Interpolator;
import com.mob.tools.gui.MobViewPager;

public class MobViewPager$1
implements Interpolator {
    public final /* synthetic */ MobViewPager this$0;

    public MobViewPager$1(MobViewPager mobViewPager) {
        this.this$0 = mobViewPager;
    }

    public float getInterpolation(float f10) {
        return (2.0f - f10) * f10;
    }
}

