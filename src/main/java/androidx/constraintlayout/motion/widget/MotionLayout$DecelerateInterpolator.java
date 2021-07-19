/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;

public class MotionLayout$DecelerateInterpolator
extends MotionInterpolator {
    public float currentP = 0.0f;
    public float initalV = 0.0f;
    public float maxA;
    public final /* synthetic */ MotionLayout this$0;

    public MotionLayout$DecelerateInterpolator(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
    }

    public void config(float f10, float f11, float f12) {
        this.initalV = f10;
        this.currentP = f11;
        this.maxA = f12;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public float getInterpolation(float f10) {
        float f11;
        float f12 = this.initalV;
        float f13 = 0.0f;
        MotionLayout motionLayout = null;
        float f14 = f12 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        float f16 = 2.0f;
        if (f15 > 0) {
            f13 = this.maxA;
            float f17 = f12 / f13;
            float f18 = f17 - f10;
            Object object = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
            if (object < 0) {
                f10 = f12 / f13;
            }
            MotionLayout motionLayout2 = this.this$0;
            float f19 = f13 * f10;
            motionLayout2.mLastVelocity = f19 = f12 - f19;
            f12 *= f10;
            f13 = f13 * f10 * f10 / f16;
            f12 -= f13;
            f10 = this.currentP;
            return f12 + f10;
        }
        f13 = -f12;
        float f20 = this.maxA;
        float f21 = (f13 /= f20) - f10;
        Object object = f21 == 0.0f ? 0 : (f21 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = -f12 / f20;
        }
        motionLayout = this.this$0;
        motionLayout.mLastVelocity = f11 = f20 * f10 + f12;
        f12 *= f10;
        f20 = f20 * f10 * f10 / f16;
        f12 += f20;
        f10 = this.currentP;
        return f12 + f10;
    }

    public float getVelocity() {
        return this.this$0.mLastVelocity;
    }
}

