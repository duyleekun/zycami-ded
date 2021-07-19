/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

public final class MotionLayout$TransitionState
extends Enum {
    private static final /* synthetic */ MotionLayout$TransitionState[] $VALUES;
    public static final /* enum */ MotionLayout$TransitionState FINISHED;
    public static final /* enum */ MotionLayout$TransitionState MOVING;
    public static final /* enum */ MotionLayout$TransitionState SETUP;
    public static final /* enum */ MotionLayout$TransitionState UNDEFINED;

    static {
        MotionLayout$TransitionState motionLayout$TransitionState;
        MotionLayout$TransitionState motionLayout$TransitionState2;
        MotionLayout$TransitionState motionLayout$TransitionState3;
        MotionLayout$TransitionState motionLayout$TransitionState4;
        UNDEFINED = motionLayout$TransitionState4 = new MotionLayout$TransitionState("UNDEFINED", 0);
        int n10 = 1;
        SETUP = motionLayout$TransitionState3 = new MotionLayout$TransitionState("SETUP", n10);
        int n11 = 2;
        MOVING = motionLayout$TransitionState2 = new MotionLayout$TransitionState("MOVING", n11);
        int n12 = 3;
        FINISHED = motionLayout$TransitionState = new MotionLayout$TransitionState("FINISHED", n12);
        MotionLayout$TransitionState[] motionLayout$TransitionStateArray = new MotionLayout$TransitionState[4];
        motionLayout$TransitionStateArray[0] = motionLayout$TransitionState4;
        motionLayout$TransitionStateArray[n10] = motionLayout$TransitionState3;
        motionLayout$TransitionStateArray[n11] = motionLayout$TransitionState2;
        motionLayout$TransitionStateArray[n12] = motionLayout$TransitionState;
        $VALUES = motionLayout$TransitionStateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private MotionLayout$TransitionState() {
        void var2_-1;
        void var1_-1;
    }

    public static MotionLayout$TransitionState valueOf(String string2) {
        return Enum.valueOf(MotionLayout$TransitionState.class, string2);
    }

    public static MotionLayout$TransitionState[] values() {
        return (MotionLayout$TransitionState[])$VALUES.clone();
    }
}

