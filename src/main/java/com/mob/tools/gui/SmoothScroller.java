/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 */
package com.mob.tools.gui;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.mob.tools.gui.SmoothScroller$DefaultInterpolator;
import com.mob.tools.gui.SmoothScroller$LinearACCInterpolator;
import com.mob.tools.gui.SmoothScroller$LinearDECInterpolator;
import com.mob.tools.gui.SmoothScroller$OverScrollInterpolator;

public final class SmoothScroller
extends Enum {
    private static final /* synthetic */ SmoothScroller[] $VALUES;
    public static final /* enum */ SmoothScroller DEFAULT;
    public static final /* enum */ SmoothScroller LINEAR_ACC;
    public static final /* enum */ SmoothScroller LINEAR_DEC;
    public static final /* enum */ SmoothScroller OVER_SCROLL;
    private Interpolator interpolator;

    static {
        SmoothScroller smoothScroller;
        Object object = new SmoothScroller$DefaultInterpolator(null);
        DEFAULT = smoothScroller = new SmoothScroller("DEFAULT", 0, (Interpolator)object);
        Object object2 = new SmoothScroller$OverScrollInterpolator(null);
        int n10 = 1;
        object = new SmoothScroller("OVER_SCROLL", n10, (Interpolator)object2);
        OVER_SCROLL = object;
        Object object3 = new SmoothScroller$LinearACCInterpolator(null);
        int n11 = 2;
        object2 = new SmoothScroller("LINEAR_ACC", n11, (Interpolator)object3);
        LINEAR_ACC = object2;
        SmoothScroller$LinearDECInterpolator smoothScroller$LinearDECInterpolator = new SmoothScroller$LinearDECInterpolator(null);
        int n12 = 3;
        object3 = new SmoothScroller("LINEAR_DEC", n12, (Interpolator)smoothScroller$LinearDECInterpolator);
        LINEAR_DEC = object3;
        SmoothScroller[] smoothScrollerArray = new SmoothScroller[4];
        smoothScrollerArray[0] = smoothScroller;
        smoothScrollerArray[n10] = object;
        smoothScrollerArray[n11] = object2;
        smoothScrollerArray[n12] = object3;
        $VALUES = smoothScrollerArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SmoothScroller() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.interpolator = var3_1;
    }

    public static SmoothScroller valueOf(String string2) {
        return Enum.valueOf(SmoothScroller.class, string2);
    }

    public static SmoothScroller[] values() {
        return (SmoothScroller[])$VALUES.clone();
    }

    public Scroller getScroller(Context context) {
        Interpolator interpolator2 = this.interpolator;
        Scroller scroller = new Scroller(context, interpolator2);
        return scroller;
    }
}

