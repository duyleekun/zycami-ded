/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Direction;
import androidx.constraintlayout.solver.state.State$Helper;
import androidx.constraintlayout.solver.state.helpers.BarrierReference$1;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

public class BarrierReference
extends HelperReference {
    private Barrier mBarrierWidget;
    private State$Direction mDirection;
    private int mMargin;

    public BarrierReference(State state) {
        State$Helper state$Helper = State$Helper.BARRIER;
        super(state, state$Helper);
    }

    public void apply() {
        this.getHelperWidget();
        Object object = BarrierReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
        int n10 = this.mDirection.ordinal();
        int n11 = object[n10];
        n10 = 0;
        switch (n11) {
            default: {
                break;
            }
            case 6: {
                n10 = 3;
                break;
            }
            case 5: {
                n10 = 2;
                break;
            }
            case 3: 
            case 4: {
                n10 = 1;
            }
            case 1: 
            case 2: 
        }
        this.mBarrierWidget.setBarrierType(n10);
        object = this.mBarrierWidget;
        n10 = this.mMargin;
        ((Barrier)object).setMargin(n10);
    }

    public HelperWidget getHelperWidget() {
        Barrier barrier = this.mBarrierWidget;
        if (barrier == null) {
            this.mBarrierWidget = barrier = new Barrier();
        }
        return this.mBarrierWidget;
    }

    public void margin(int n10) {
        this.mMargin = n10;
    }

    public void margin(Object object) {
        int n10 = this.mState.convertDimension(object);
        this.margin(n10);
    }

    public void setBarrierDirection(State$Direction state$Direction) {
        this.mDirection = state$Direction;
    }
}

