/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

public class HelperReference {
    private HelperWidget mHelperWidget;
    public ArrayList mReferences;
    public final State mState;
    public final State.Helper mType;

    public HelperReference(State state, State.Helper helper) {
        ArrayList arrayList;
        this.mReferences = arrayList = new ArrayList();
        this.mState = state;
        this.mType = helper;
    }

    public HelperReference add(Object ... objectArray) {
        for (Object object : objectArray) {
            ArrayList arrayList = this.mReferences;
            arrayList.add(object);
        }
        return this;
    }

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }
}

