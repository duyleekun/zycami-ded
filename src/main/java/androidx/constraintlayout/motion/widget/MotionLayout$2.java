/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout$TransitionState;

public class MotionLayout$2 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        MotionLayout$TransitionState motionLayout$TransitionState;
        int n12 = MotionLayout$TransitionState.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = nArray;
        try {
            motionLayout$TransitionState = MotionLayout$TransitionState.UNDEFINED;
            n11 = motionLayout$TransitionState.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;
            motionLayout$TransitionState = MotionLayout$TransitionState.SETUP;
            n11 = motionLayout$TransitionState.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;
            motionLayout$TransitionState = MotionLayout$TransitionState.MOVING;
            n11 = motionLayout$TransitionState.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;
            motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
            n11 = motionLayout$TransitionState.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

