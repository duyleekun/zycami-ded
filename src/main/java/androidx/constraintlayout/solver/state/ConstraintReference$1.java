/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State$Constraint;

public class ConstraintReference$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        State$Constraint state$Constraint;
        int n12 = State$Constraint.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint = nArray;
        try {
            state$Constraint = State$Constraint.LEFT_TO_LEFT;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.LEFT_TO_RIGHT;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.RIGHT_TO_LEFT;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.RIGHT_TO_RIGHT;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.START_TO_START;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.START_TO_END;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.END_TO_START;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.END_TO_END;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.TOP_TO_TOP;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.TOP_TO_BOTTOM;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.BOTTOM_TO_TOP;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.BOTTOM_TO_BOTTOM;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.BASELINE_TO_BASELINE;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.CENTER_HORIZONTALLY;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            state$Constraint = State$Constraint.CENTER_VERTICALLY;
            n11 = state$Constraint.ordinal();
            nArray[n11] = n10 = 15;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

