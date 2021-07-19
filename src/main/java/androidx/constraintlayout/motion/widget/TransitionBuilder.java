/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.MotionScene$Transition;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.ArrayList;

public class TransitionBuilder {
    private static final String TAG = "TransitionBuilder";

    public static MotionScene$Transition buildTransition(MotionScene motionScene, int n10, int n11, ConstraintSet constraintSet, int n12, ConstraintSet constraintSet2) {
        MotionScene$Transition motionScene$Transition = new MotionScene$Transition(n10, motionScene, n11, n12);
        TransitionBuilder.updateConstraintSetInMotionScene(motionScene, motionScene$Transition, constraintSet, constraintSet2);
        return motionScene$Transition;
    }

    private static void updateConstraintSetInMotionScene(MotionScene motionScene, MotionScene$Transition motionScene$Transition, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
        int n10 = motionScene$Transition.getStartConstraintSetId();
        int n11 = motionScene$Transition.getEndConstraintSetId();
        motionScene.setConstraintSet(n10, constraintSet);
        motionScene.setConstraintSet(n11, constraintSet2);
    }

    public static void validate(MotionLayout object) {
        MotionScene motionScene = ((MotionLayout)object).mScene;
        if (motionScene != null) {
            boolean bl2 = motionScene.validateLayout((MotionLayout)object);
            if (bl2) {
                object = motionScene.mCurrentTransition;
                if (object != null && !(bl2 = ((ArrayList)(object = motionScene.getDefinedTransitions())).isEmpty())) {
                    return;
                }
                object = new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
                throw object;
            }
            object = new RuntimeException("MotionLayout doesn't have the right motion scene.");
            throw object;
        }
        object = new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        throw object;
    }
}

