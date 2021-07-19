/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 */
package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionScene;

public class MotionScene$1
implements Interpolator {
    public final /* synthetic */ MotionScene this$0;
    public final /* synthetic */ Easing val$easing;

    public MotionScene$1(MotionScene motionScene, Easing easing) {
        this.this$0 = motionScene;
        this.val$easing = easing;
    }

    public float getInterpolation(float f10) {
        Easing easing = this.val$easing;
        double d10 = f10;
        return (float)easing.get(d10);
    }
}

