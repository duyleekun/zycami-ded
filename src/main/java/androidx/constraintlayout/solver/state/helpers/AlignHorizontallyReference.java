/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Helper;
import java.util.Iterator;

public class AlignHorizontallyReference
extends HelperReference {
    private float mBias;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State state) {
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
            ((ConstraintReference)object).clearHorizontal();
            Object object2 = this.mStartToStart;
            if (object2 != null) {
                ((ConstraintReference)object).startToStart(object2);
            } else {
                object2 = this.mStartToEnd;
                if (object2 != null) {
                    ((ConstraintReference)object).startToEnd(object2);
                } else {
                    object2 = State.PARENT;
                    ((ConstraintReference)object).startToStart(object2);
                }
            }
            object2 = this.mEndToStart;
            if (object2 != null) {
                ((ConstraintReference)object).endToStart(object2);
            } else {
                object2 = this.mEndToEnd;
                if (object2 != null) {
                    ((ConstraintReference)object).endToEnd(object2);
                } else {
                    object2 = State.PARENT;
                    ((ConstraintReference)object).endToEnd(object2);
                }
            }
            if ((f13 = (f12 = (f11 = this.mBias) - (f10 = 0.5f)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) == false) continue;
            ((ConstraintReference)object).horizontalBias(f11);
        }
    }

    public void bias(float f10) {
        this.mBias = f10;
    }

    public void endToEnd(Object object) {
        this.mEndToEnd = object;
    }

    public void endToStart(Object object) {
        this.mEndToStart = object;
    }

    public void startToEnd(Object object) {
        this.mStartToEnd = object;
    }

    public void startToStart(Object object) {
        this.mStartToStart = object;
    }
}

