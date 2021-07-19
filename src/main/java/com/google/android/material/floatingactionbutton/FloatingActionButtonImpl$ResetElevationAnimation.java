/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ShadowAnimatorImpl;

public class FloatingActionButtonImpl$ResetElevationAnimation
extends FloatingActionButtonImpl$ShadowAnimatorImpl {
    public final /* synthetic */ FloatingActionButtonImpl this$0;

    public FloatingActionButtonImpl$ResetElevationAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
        super(floatingActionButtonImpl, null);
    }

    public float getTargetShadowSize() {
        return this.this$0.elevation;
    }
}

