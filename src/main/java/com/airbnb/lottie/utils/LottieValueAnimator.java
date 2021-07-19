/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 */
package com.airbnb.lottie.utils;

import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.utils.BaseLottieAnimator;
import com.airbnb.lottie.utils.MiscUtils;

public class LottieValueAnimator
extends BaseLottieAnimator
implements Choreographer.FrameCallback {
    private LottieComposition composition;
    private float frame = 0.0f;
    private long lastFrameTimeNs = 0L;
    private float maxFrame = 2.14748365E9f;
    private float minFrame = -2.14748365E9f;
    private int repeatCount = 0;
    public boolean running = false;
    private float speed = 1.0f;
    private boolean speedReversedForRepeatMode = false;

    private float getFrameDurationNs() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return Float.MAX_VALUE;
        }
        float f10 = lottieComposition.getFrameRate();
        float f11 = 1.0E9f / f10;
        f10 = Math.abs(this.speed);
        return f11 / f10;
    }

    private boolean isReversed() {
        float f10 = this.getSpeed();
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object < 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    private void verifyFrame() {
        float f10;
        float f11;
        Object object = this.composition;
        if (object == null) {
            return;
        }
        float f12 = this.frame;
        float f13 = this.minFrame;
        float f14 = f12 - f13;
        Object object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object2 >= 0 && (f11 = (f10 = f12 - (f13 = this.maxFrame)) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) <= 0) {
            return;
        }
        Object object3 = new Object[3];
        Float f15 = Float.valueOf(this.minFrame);
        object3[0] = f15;
        f15 = Float.valueOf(this.maxFrame);
        object3[1] = f15;
        f15 = Float.valueOf(this.frame);
        object3[2] = f15;
        object3 = String.format("Frame must be [%f,%f]. It is %f", object3);
        object = new IllegalStateException((String)object3);
        throw object;
    }

    public void cancel() {
        this.notifyCancel();
        this.removeFrameCallback();
    }

    public void clearComposition() {
        this.composition = null;
        this.minFrame = -2.14748365E9f;
        this.maxFrame = 2.14748365E9f;
    }

    public void doFrame(long l10) {
        boolean bl2;
        this.postFrameCallback();
        Object object = this.composition;
        if (object != null && (bl2 = this.isRunning())) {
            object = "LottieValueAnimator#doFrame";
            L.beginSection((String)object);
            long l11 = this.lastFrameTimeNs;
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 != false) {
                l12 = l10 - l11;
            }
            float f10 = this.getFrameDurationNs();
            float f11 = (float)l12 / f10;
            f10 = this.frame;
            boolean bl3 = this.isReversed();
            if (bl3) {
                f11 = -f11;
            }
            this.frame = f10 += f11;
            f11 = this.getMinFrame();
            float f12 = this.getMaxFrame();
            int n10 = MiscUtils.contains(f10, f11, f12) ^ 1;
            f11 = this.frame;
            f12 = this.getMinFrame();
            float f13 = this.getMaxFrame();
            this.frame = f11 = MiscUtils.clamp(f11, f12, f13);
            this.lastFrameTimeNs = l10;
            this.notifyUpdate();
            if (n10 != 0) {
                n10 = this.getRepeatCount();
                int n11 = -1;
                f11 = 0.0f / 0.0f;
                if (n10 != n11 && (n10 = this.repeatCount) >= (n11 = this.getRepeatCount())) {
                    float f14 = this.speed;
                    float f15 = f14 - 0.0f;
                    Object object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                    f14 = object2 < 0 ? this.getMinFrame() : this.getMaxFrame();
                    this.frame = f14;
                    this.removeFrameCallback();
                    object2 = this.isReversed();
                    this.notifyEnd((boolean)object2);
                } else {
                    this.notifyRepeat();
                    this.repeatCount = n10 = this.repeatCount + 1;
                    n10 = this.getRepeatMode();
                    n11 = 2;
                    f11 = 2.8E-45f;
                    if (n10 == n11) {
                        n10 = this.speedReversedForRepeatMode ^ 1;
                        this.speedReversedForRepeatMode = n10;
                        this.reverseAnimationSpeed();
                    } else {
                        n10 = (int)(this.isReversed() ? 1 : 0);
                        f10 = n10 != 0 ? this.getMaxFrame() : this.getMinFrame();
                        this.frame = f10;
                    }
                    this.lastFrameTimeNs = l10;
                }
            }
            this.verifyFrame();
            L.endSection((String)object);
        }
    }

    public void endAnimation() {
        this.removeFrameCallback();
        boolean bl2 = this.isReversed();
        this.notifyEnd(bl2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public float getAnimatedFraction() {
        float f10;
        float f11;
        float f12;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        boolean bl2 = this.isReversed();
        if (bl2) {
            f12 = this.getMaxFrame();
            f11 = this.frame;
            f12 -= f11;
            f11 = this.getMaxFrame();
            f10 = this.getMinFrame();
            return f12 / (f11 -= f10);
        }
        f12 = this.frame;
        f11 = this.getMinFrame();
        f12 -= f11;
        f11 = this.getMaxFrame();
        f10 = this.getMinFrame();
        return f12 / (f11 -= f10);
    }

    public Object getAnimatedValue() {
        return Float.valueOf(this.getAnimatedValueAbsolute());
    }

    public float getAnimatedValueAbsolute() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.frame;
        float f11 = lottieComposition.getStartFrame();
        f10 -= f11;
        f11 = this.composition.getEndFrame();
        float f12 = this.composition.getStartFrame();
        return f10 / (f11 -= f12);
    }

    public long getDuration() {
        long l10;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            l10 = 0L;
        } else {
            float f10 = lottieComposition.getDuration();
            l10 = (long)f10;
        }
        return l10;
    }

    public float getFrame() {
        return this.frame;
    }

    public float getMaxFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.maxFrame;
        float f11 = 2.14748365E9f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = lottieComposition.getEndFrame();
        }
        return f10;
    }

    public float getMinFrame() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f10 = this.minFrame;
        float f11 = -2.14748365E9f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = lottieComposition.getStartFrame();
        }
        return f10;
    }

    public float getSpeed() {
        return this.speed;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void pauseAnimation() {
        this.removeFrameCallback();
    }

    public void playAnimation() {
        float f10 = Float.MIN_VALUE;
        this.running = true;
        boolean bl2 = this.isReversed();
        this.notifyStart(bl2);
        bl2 = this.isReversed();
        f10 = bl2 ? this.getMaxFrame() : this.getMinFrame();
        f10 = (int)f10;
        this.setFrame(f10);
        this.lastFrameTimeNs = 0L;
        this.repeatCount = 0;
        this.postFrameCallback();
    }

    public void postFrameCallback() {
        boolean bl2 = this.isRunning();
        if (bl2) {
            bl2 = false;
            this.removeFrameCallback(false);
            Choreographer choreographer = Choreographer.getInstance();
            choreographer.postFrameCallback((Choreographer.FrameCallback)this);
        }
    }

    public void removeFrameCallback() {
        this.removeFrameCallback(true);
    }

    public void removeFrameCallback(boolean bl2) {
        Choreographer choreographer = Choreographer.getInstance();
        choreographer.removeFrameCallback((Choreographer.FrameCallback)this);
        if (bl2) {
            bl2 = false;
            this.running = false;
        }
    }

    public void resumeAnimation() {
        float f10;
        float f11;
        long l10;
        float f12 = Float.MIN_VALUE;
        this.running = true;
        this.postFrameCallback();
        this.lastFrameTimeNs = l10 = 0L;
        boolean bl2 = this.isReversed();
        if (bl2 && !(bl2 = (f11 = (f12 = this.getFrame()) - (f10 = this.getMinFrame())) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) {
            this.frame = f12 = this.getMaxFrame();
        } else {
            float f13;
            bl2 = this.isReversed();
            if (!bl2 && !(bl2 = (f13 = (f12 = this.getFrame()) - (f10 = this.getMaxFrame())) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) {
                this.frame = f12 = this.getMinFrame();
            }
        }
    }

    public void reverseAnimationSpeed() {
        float f10 = -this.getSpeed();
        this.setSpeed(f10);
    }

    public void setComposition(LottieComposition lottieComposition) {
        float f10;
        float f11;
        int n10;
        LottieComposition lottieComposition2 = this.composition;
        if (lottieComposition2 == null) {
            n10 = 1;
            f11 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f11 = 0.0f;
            lottieComposition2 = null;
        }
        this.composition = lottieComposition;
        if (n10 != 0) {
            f11 = this.minFrame;
            float f12 = lottieComposition.getStartFrame();
            n10 = (int)Math.max(f11, f12);
            f11 = n10;
            f12 = this.maxFrame;
            f10 = lottieComposition.getEndFrame();
            int n11 = (int)Math.min(f12, f10);
            f10 = n11;
            this.setMinAndMaxFrames(f11, f10);
        } else {
            n10 = (int)lottieComposition.getStartFrame();
            f11 = n10;
            int n12 = (int)lottieComposition.getEndFrame();
            f10 = n12;
            this.setMinAndMaxFrames(f11, f10);
        }
        f10 = this.frame;
        this.frame = 0.0f;
        f10 = (int)f10;
        this.setFrame(f10);
        this.notifyUpdate();
    }

    public void setFrame(float f10) {
        float f11 = this.frame;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return;
        }
        f11 = this.getMinFrame();
        float f13 = this.getMaxFrame();
        this.frame = f10 = MiscUtils.clamp(f10, f11, f13);
        this.lastFrameTimeNs = 0L;
        this.notifyUpdate();
    }

    public void setMaxFrame(float f10) {
        float f11 = this.minFrame;
        this.setMinAndMaxFrames(f11, f10);
    }

    public void setMinAndMaxFrames(float f10, float f11) {
        Object object;
        Object object2 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object2 <= 0) {
            float f12;
            float f13;
            LottieComposition lottieComposition = this.composition;
            if (lottieComposition == null) {
                object2 = -8388609;
                f13 = -3.4028235E38f;
            } else {
                f13 = lottieComposition.getStartFrame();
            }
            LottieComposition lottieComposition2 = this.composition;
            float f14 = lottieComposition2 == null ? Float.MAX_VALUE : lottieComposition2.getEndFrame();
            this.minFrame = f12 = MiscUtils.clamp(f10, f13, f14);
            this.maxFrame = f13 = MiscUtils.clamp(f11, f13, f14);
            f10 = (int)MiscUtils.clamp(this.frame, f10, f11);
            this.setFrame(f10);
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object = Float.valueOf(f10);
        Float f15 = Float.valueOf(f11);
        objectArray[1] = f15;
        object = String.format("minFrame (%s) must be <= maxFrame (%s)", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void setMinFrame(int n10) {
        float f10 = n10;
        float f11 = (int)this.maxFrame;
        this.setMinAndMaxFrames(f10, f11);
    }

    public void setRepeatMode(int n10) {
        super.setRepeatMode(n10);
        int n11 = 2;
        if (n10 != n11 && (n10 = (int)(this.speedReversedForRepeatMode ? 1 : 0)) != 0) {
            n10 = 0;
            this.speedReversedForRepeatMode = false;
            this.reverseAnimationSpeed();
        }
    }

    public void setSpeed(float f10) {
        this.speed = f10;
    }
}

