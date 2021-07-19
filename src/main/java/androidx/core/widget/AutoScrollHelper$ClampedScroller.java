/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.AnimationUtils
 */
package androidx.core.widget;

import android.view.animation.AnimationUtils;
import androidx.core.widget.AutoScrollHelper;

public class AutoScrollHelper$ClampedScroller {
    private long mDeltaTime = 0L;
    private int mDeltaX = 0;
    private int mDeltaY = 0;
    private int mEffectiveRampDown;
    private int mRampDownDuration;
    private int mRampUpDuration;
    private long mStartTime = Long.MIN_VALUE;
    private long mStopTime = -1;
    private float mStopValue;
    private float mTargetVelocityX;
    private float mTargetVelocityY;

    private float getValueAt(long l10) {
        long l11 = this.mStartTime;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            return 0.0f;
        }
        long l13 = this.mStopTime;
        long l14 = 0L;
        object = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        float f10 = 1.0f;
        if (object >= 0 && (object = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) >= 0) {
            float f11 = this.mStopValue;
            float f12 = f10 - f11;
            float f13 = l10 -= l13;
            float f14 = this.mEffectiveRampDown;
            f13 = AutoScrollHelper.constrain(f13 / f14, 0.0f, f10);
            return f12 + (f11 *= f13);
        }
        float f15 = l10 - l11;
        float f16 = this.mRampUpDuration;
        return AutoScrollHelper.constrain(f15 / f16, 0.0f, f10) * 0.5f;
    }

    private float interpolateValue(float f10) {
        float f11 = -4.0f * f10 * f10;
        return f11 + (f10 *= 4.0f);
    }

    public void computeScrollDelta() {
        long l10 = this.mDeltaTime;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            int n10;
            l10 = AnimationUtils.currentAnimationTimeMillis();
            float f10 = this.getValueAt(l10);
            f10 = this.interpolateValue(f10);
            long l13 = this.mDeltaTime;
            l13 = l10 - l13;
            this.mDeltaTime = l10;
            float f11 = (float)l13 * f10;
            this.mDeltaX = n10 = (int)(this.mTargetVelocityX * f11);
            float f12 = this.mTargetVelocityY;
            object = (int)(f11 * f12);
            this.mDeltaY = (int)object;
            return;
        }
        RuntimeException runtimeException = new RuntimeException("Cannot compute scroll delta before calling start()");
        throw runtimeException;
    }

    public int getDeltaX() {
        return this.mDeltaX;
    }

    public int getDeltaY() {
        return this.mDeltaY;
    }

    public int getHorizontalDirection() {
        float f10 = this.mTargetVelocityX;
        float f11 = Math.abs(f10);
        return (int)(f10 / f11);
    }

    public int getVerticalDirection() {
        float f10 = this.mTargetVelocityY;
        float f11 = Math.abs(f10);
        return (int)(f10 / f11);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isFinished() {
        void var5_7;
        long l10 = this.mStopTime;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            l10 = AnimationUtils.currentAnimationTimeMillis();
            l11 = this.mStopTime;
            int n10 = this.mEffectiveRampDown;
            long l13 = n10;
            long l14 = l10 - (l11 += l13);
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 > 0) {
                return (boolean)var5_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var5_7;
    }

    public void requestStop() {
        float f10;
        long l10 = AnimationUtils.currentAnimationTimeMillis();
        long l11 = this.mStartTime;
        int n10 = (int)(l10 - l11);
        int n11 = this.mRampDownDuration;
        this.mEffectiveRampDown = n10 = AutoScrollHelper.constrain(n10, 0, n11);
        this.mStopValue = f10 = this.getValueAt(l10);
        this.mStopTime = l10;
    }

    public void setRampDownDuration(int n10) {
        this.mRampDownDuration = n10;
    }

    public void setRampUpDuration(int n10) {
        this.mRampUpDuration = n10;
    }

    public void setTargetVelocity(float f10, float f11) {
        this.mTargetVelocityX = f10;
        this.mTargetVelocityY = f11;
    }

    public void start() {
        long l10;
        this.mStartTime = l10 = AnimationUtils.currentAnimationTimeMillis();
        this.mStopTime = -1;
        this.mDeltaTime = l10;
        this.mStopValue = 0.5f;
        this.mDeltaX = 0;
        this.mDeltaY = 0;
    }
}

