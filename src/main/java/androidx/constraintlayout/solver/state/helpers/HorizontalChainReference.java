/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.helpers.ChainReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1;

public class HorizontalChainReference
extends ChainReference {
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public HorizontalChainReference(State state) {
        State$Helper state$Helper = State$Helper.HORIZONTAL_CHAIN;
        super(state, state$Helper);
    }

    public void apply() {
        float f10;
        float f11;
        int n10;
        Object object;
        Object object2;
        int n11;
        Object object3 = this.mReferences.iterator();
        while ((n11 = object3.hasNext()) != 0) {
            object2 = object3.next();
            object = this.mState;
            object2 = ((State)object).constraints(object2);
            ((ConstraintReference)object2).clearHorizontal();
        }
        object3 = this.mReferences.iterator();
        n11 = 0;
        float f12 = 0.0f;
        object2 = null;
        object = null;
        while ((n10 = object3.hasNext()) != 0) {
            Object object4 = object3.next();
            Object object5 = this.mState;
            object4 = ((State)object5).constraints(object4);
            if (object == null) {
                object = this.mStartToStart;
                if (object != null) {
                    ((ConstraintReference)object4).startToStart(object);
                } else {
                    object = this.mStartToEnd;
                    if (object != null) {
                        ((ConstraintReference)object4).startToEnd(object);
                    } else {
                        object = State.PARENT;
                        ((ConstraintReference)object4).startToStart(object);
                    }
                }
                object = object4;
            }
            if (object2 != null) {
                object5 = ((ConstraintReference)object4).getKey();
                ((ConstraintReference)object2).endToStart(object5);
                object2 = ((ConstraintReference)object2).getKey();
                ((ConstraintReference)object4).startToEnd(object2);
            }
            object2 = object4;
        }
        if (object2 != null) {
            object3 = this.mEndToStart;
            if (object3 != null) {
                ((ConstraintReference)object2).endToStart(object3);
            } else {
                object3 = this.mEndToEnd;
                if (object3 != null) {
                    ((ConstraintReference)object2).endToEnd(object3);
                } else {
                    object3 = State.PARENT;
                    ((ConstraintReference)object2).endToEnd(object3);
                }
            }
        }
        if (object != null && (n11 = (int)((f11 = (f10 = this.mBias) - (f12 = 0.5f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
            ((ConstraintReference)object).horizontalBias(f10);
        }
        object3 = HorizontalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
        object2 = this.mStyle;
        n11 = ((Enum)object2).ordinal();
        Object object6 = object3[n11];
        n11 = 1;
        f12 = Float.MIN_VALUE;
        if (object6 != n11) {
            n10 = 2;
            if (object6 != n10) {
                n11 = 3;
                f12 = 4.2E-45f;
                if (object6 == n11) {
                    ((ConstraintReference)object).setHorizontalChainStyle(n10);
                }
            } else {
                ((ConstraintReference)object).setHorizontalChainStyle(n11);
            }
        } else {
            object6 = false;
            f10 = 0.0f;
            object3 = null;
            ((ConstraintReference)object).setHorizontalChainStyle(0);
        }
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

