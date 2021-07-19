/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.ConstraintReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.helpers.ChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1;

public class VerticalChainReference
extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public VerticalChainReference(State state) {
        State$Helper state$Helper = State$Helper.VERTICAL_CHAIN;
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
            ((ConstraintReference)object2).clearVertical();
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
                object = this.mTopToTop;
                if (object != null) {
                    ((ConstraintReference)object4).topToTop(object);
                } else {
                    object = this.mTopToBottom;
                    if (object != null) {
                        ((ConstraintReference)object4).topToBottom(object);
                    } else {
                        object = State.PARENT;
                        ((ConstraintReference)object4).topToTop(object);
                    }
                }
                object = object4;
            }
            if (object2 != null) {
                object5 = ((ConstraintReference)object4).getKey();
                ((ConstraintReference)object2).bottomToTop(object5);
                object2 = ((ConstraintReference)object2).getKey();
                ((ConstraintReference)object4).topToBottom(object2);
            }
            object2 = object4;
        }
        if (object2 != null) {
            object3 = this.mBottomToTop;
            if (object3 != null) {
                ((ConstraintReference)object2).bottomToTop(object3);
            } else {
                object3 = this.mBottomToBottom;
                if (object3 != null) {
                    ((ConstraintReference)object2).bottomToBottom(object3);
                } else {
                    object3 = State.PARENT;
                    ((ConstraintReference)object2).bottomToBottom(object3);
                }
            }
        }
        if (object != null && (n11 = (int)((f11 = (f10 = this.mBias) - (f12 = 0.5f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
            ((ConstraintReference)object).verticalBias(f10);
        }
        object3 = VerticalChainReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
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
                    ((ConstraintReference)object).setVerticalChainStyle(n10);
                }
            } else {
                ((ConstraintReference)object).setVerticalChainStyle(n11);
            }
        } else {
            object6 = false;
            f10 = 0.0f;
            object3 = null;
            ((ConstraintReference)object).setVerticalChainStyle(0);
        }
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

