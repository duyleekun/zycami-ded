/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.graphics.drawable.AnimationDrawable
 */
package androidx.appcompat.graphics.drawable;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

public class AnimatedStateListDrawableCompat$FrameInterpolator
implements TimeInterpolator {
    private int[] mFrameTimes;
    private int mFrames;
    private int mTotalDuration;

    public AnimatedStateListDrawableCompat$FrameInterpolator(AnimationDrawable animationDrawable, boolean bl2) {
        this.updateFrames(animationDrawable, bl2);
    }

    public float getInterpolation(float f10) {
        float f11;
        int n10;
        int n11;
        float f12 = this.mTotalDuration;
        f10 *= f12;
        f12 = 0.5f;
        int n12 = (int)(f10 += f12);
        int n13 = this.mFrames;
        int[] nArray = this.mFrameTimes;
        for (n10 = 0; n10 < n13 && n12 >= (n11 = nArray[n10]); n12 -= n11, ++n10) {
            n11 = nArray[n10];
        }
        if (n10 < n13) {
            f10 = n12;
            int n14 = this.mTotalDuration;
            f11 = n14;
            f10 /= f11;
        } else {
            n12 = 0;
            f10 = 0.0f;
        }
        f11 = n10;
        f12 = n13;
        return f11 / f12 + f10;
    }

    public int getTotalDuration() {
        return this.mTotalDuration;
    }

    public int updateFrames(AnimationDrawable animationDrawable, boolean bl2) {
        int n10;
        int n11;
        this.mFrames = n11 = animationDrawable.getNumberOfFrames();
        int[] nArray = this.mFrameTimes;
        if (nArray == null || (n10 = nArray.length) < n11) {
            this.mFrameTimes = nArray = new int[n11];
        }
        nArray = this.mFrameTimes;
        int n12 = 0;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = bl2 ? n11 - i10 + -1 : i10;
            nArray[i10] = n13 = animationDrawable.getDuration(n13);
            n12 += n13;
        }
        this.mTotalDuration = n12;
        return n12;
    }
}

