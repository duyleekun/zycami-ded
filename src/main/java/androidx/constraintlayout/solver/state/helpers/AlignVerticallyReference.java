/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Helper;
import java.util.Iterator;

public class AlignVerticallyReference
extends HelperReference {
    private float mBias;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State state) {
        State$Helper state$Helper = State$Helper.ALIGN_VERTICALLY;
        super(state, state$Helper);
        this.mBias = 0.5f;
    }

    public void apply() {
        boolean bl2;
        Iterator iterator2 = this.mReferences.iterator();
        while (bl2 = iterator2.hasNext()) {
            float f10;
            float f11;
            float f12;
            float f13;
            Object object = iterator2.next();
            object = this.mState.constraints(object);
            ((ConstraintReference)object).clearVertical();
            Object object2 = this.mTopToTop;
            if (object2 != null) {
                ((ConstraintReference)object).topToTop(object2);
            } else {
                object2 = this.mTopToBottom;
                if (object2 != null) {
                    ((ConstraintReference)object).topToBottom(object2);
                } else {
                    object2 = State.PARENT;
                    ((ConstraintReference)object).topToTop(object2);
                }
            }
            object2 = this.mBottomToTop;
            if (object2 != null) {
                ((ConstraintReference)object).bottomToTop(object2);
            } else {
                object2 = this.mBottomToBottom;
                if (object2 != null) {
                    ((ConstraintReference)object).bottomToBottom(object2);
                } else {
                    object2 = State.PARENT;
                    ((ConstraintReference)object).bottomToBottom(object2);
                }
            }
            if ((f13 = (f12 = (f11 = this.mBias) - (f10 = 0.5f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) == false) continue;
            ((ConstraintReference)object).verticalBias(f11);
        }
    }

    public void bias(float f10) {
        this.mBias = f10;
    }

    public void bottomToBottom(Object object) {
        this.mBottomToBottom = object;
    }

    public void bottomToTop(Object object) {
        this.mBottomToTop = object;
    }

    public void topToBottom(Object object) {
        this.mTopToBottom = object;
    }

    public void topToTop(Object object) {
        this.mTopToTop = object;
    }
}

