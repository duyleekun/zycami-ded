/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.floatingactionbutton;

import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$ShadowAnimatorImpl;

public class FloatingActionButtonImpl$ElevateToPressedTranslationZAnimation
extends FloatingActionButtonImpl$ShadowAnimatorImpl {
    public final /* synthetic */ FloatingActionButtonImpl this$0;

    public FloatingActionButtonImpl$ElevateToPressedTranslationZAnimation(FloatingActionButtonImpl floatingActionButtonImpl) {
        this.this$0 = floatingActionButtonImpl;
        super(floatingActionButtonImpl, null);
    }

    public float getTargetShadowSize() {
        FloatingActionButtonImpl floatingActionButtonImpl = this.this$0;
        float f10 = floatingActionButtonImpl.elevation;
        float f11 = floatingActionButtonImpl.pressedTranslationZ;
        return f10 + f11;
    }
}

