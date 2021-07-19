/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.graphics.drawable.AnimationDrawable
 *  android.os.Build$VERSION
 */
package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$FrameInterpolator;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$Transition;

public class AnimatedStateListDrawableCompat$AnimationDrawableTransition
extends AnimatedStateListDrawableCompat$Transition {
    private final ObjectAnimator mAnim;
    private final boolean mHasReversibleFlag;

    public AnimatedStateListDrawableCompat$AnimationDrawableTransition(AnimationDrawable animationDrawable, boolean n10, boolean bl2) {
        String string2 = null;
        super(null);
        int n11 = animationDrawable.getNumberOfFrames();
        int n12 = n10 != 0 ? n11 + -1 : 0;
        int n13 = 1;
        if (n10 != 0) {
            n11 = 0;
            string2 = null;
        } else {
            n11 -= n13;
        }
        AnimatedStateListDrawableCompat$FrameInterpolator animatedStateListDrawableCompat$FrameInterpolator = new AnimatedStateListDrawableCompat$FrameInterpolator(animationDrawable, n10 != 0);
        int[] nArray = new int[2];
        nArray[0] = n12;
        nArray[n13] = n11;
        string2 = "currentIndex";
        animationDrawable = ObjectAnimator.ofInt((Object)animationDrawable, (String)string2, (int[])nArray);
        n10 = Build.VERSION.SDK_INT;
        n11 = 18;
        if (n10 >= n11) {
            animationDrawable.setAutoCancel(n13 != 0);
        }
        long l10 = animatedStateListDrawableCompat$FrameInterpolator.getTotalDuration();
        animationDrawable.setDuration(l10);
        animationDrawable.setInterpolator((TimeInterpolator)animatedStateListDrawableCompat$FrameInterpolator);
        this.mHasReversibleFlag = bl2;
        this.mAnim = animationDrawable;
    }

    public boolean canReverse() {
        return this.mHasReversibleFlag;
    }

    public void reverse() {
        this.mAnim.reverse();
    }

    public void start() {
        this.mAnim.start();
    }

    public void stop() {
        this.mAnim.cancel();
    }
}

