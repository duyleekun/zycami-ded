/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Chain;
import androidx.constraintlayout.solver.state.State$Helper;

public class ChainReference
extends HelperReference {
    public float mBias = 0.5f;
    public State$Chain mStyle;

    public ChainReference(State object, State$Helper state$Helper) {
        super((State)object, state$Helper);
        object = State$Chain.SPREAD;
        this.mStyle = object;
    }

    public void bias(float f10) {
        this.mBias = f10;
    }

    public float getBias() {
        return this.mBias;
    }

    public State$Chain getStyle() {
        return State$Chain.SPREAD;
    }

    public void style(State$Chain state$Chain) {
        this.mStyle = state$Chain;
    }
}

