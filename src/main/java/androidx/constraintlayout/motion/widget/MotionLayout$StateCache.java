/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package androidx.constraintlayout.motion.widget;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionState;

public class MotionLayout$StateCache {
    public final String KeyEndState;
    public final String KeyProgress;
    public final String KeyStartState;
    public final String KeyVelocity;
    public int endState;
    public float mProgress;
    public float mVelocity;
    public int startState;
    public final /* synthetic */ MotionLayout this$0;

    public MotionLayout$StateCache(MotionLayout motionLayout) {
        int n10;
        float f10;
        this.this$0 = motionLayout;
        this.mProgress = f10 = 0.0f / 0.0f;
        this.mVelocity = f10;
        this.startState = n10 = -1;
        this.endState = n10;
        this.KeyProgress = "motion.progress";
        this.KeyVelocity = "motion.velocity";
        this.KeyStartState = "motion.StartState";
        this.KeyEndState = "motion.EndState";
    }

    public void apply() {
        float f10;
        MotionLayout motionLayout;
        int n10;
        int n11 = this.startState;
        int n12 = -1;
        float f11 = 0.0f / 0.0f;
        if (n11 != n12 || (n10 = this.endState) != n12) {
            Object object;
            if (n11 == n12) {
                motionLayout = this.this$0;
                n10 = this.endState;
                motionLayout.transitionToState(n10);
            } else {
                n10 = this.endState;
                if (n10 == n12) {
                    object = this.this$0;
                    object.setState(n11, n12, n12);
                } else {
                    MotionLayout motionLayout2 = this.this$0;
                    motionLayout2.setTransition(n11, n10);
                }
            }
            motionLayout = this.this$0;
            object = MotionLayout$TransitionState.SETUP;
            motionLayout.setState((MotionLayout$TransitionState)((Object)object));
        }
        if ((n11 = (int)(Float.isNaN(f10 = this.mVelocity) ? 1 : 0)) != 0) {
            f10 = this.mProgress;
            n11 = Float.isNaN(f10) ? 1 : 0;
            if (n11 != 0) {
                return;
            }
            motionLayout = this.this$0;
            f11 = this.mProgress;
            motionLayout.setProgress(f11);
            return;
        }
        motionLayout = this.this$0;
        float f12 = this.mProgress;
        float f13 = this.mVelocity;
        motionLayout.setProgress(f12, f13);
        this.mProgress = f10 = 0.0f / 0.0f;
        this.mVelocity = f10;
        this.startState = n12;
        this.endState = n12;
    }

    public Bundle getTransitionState() {
        Bundle bundle = new Bundle();
        float f10 = this.mProgress;
        bundle.putFloat("motion.progress", f10);
        f10 = this.mVelocity;
        bundle.putFloat("motion.velocity", f10);
        int n10 = this.startState;
        bundle.putInt("motion.StartState", n10);
        n10 = this.endState;
        bundle.putInt("motion.EndState", n10);
        return bundle;
    }

    public void recordState() {
        float f10;
        int n10;
        this.endState = n10 = MotionLayout.access$000(this.this$0);
        this.startState = n10 = MotionLayout.access$100(this.this$0);
        this.mVelocity = f10 = this.this$0.getVelocity();
        this.mProgress = f10 = this.this$0.getProgress();
    }

    public void setEndState(int n10) {
        this.endState = n10;
    }

    public void setProgress(float f10) {
        this.mProgress = f10;
    }

    public void setStartState(int n10) {
        this.startState = n10;
    }

    public void setTransitionState(Bundle bundle) {
        int n10;
        int n11;
        float f10;
        this.mProgress = f10 = bundle.getFloat("motion.progress");
        this.mVelocity = f10 = bundle.getFloat("motion.velocity");
        this.startState = n11 = bundle.getInt("motion.StartState");
        this.endState = n10 = bundle.getInt("motion.EndState");
    }

    public void setVelocity(float f10) {
        this.mVelocity = f10;
    }
}

