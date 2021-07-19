/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State$Direction;

public class BarrierReference$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        State$Direction state$Direction;
        int n12 = State$Direction.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Direction = nArray;
        try {
            state$Direction = State$Direction.LEFT;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
            state$Direction = State$Direction.START;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
            state$Direction = State$Direction.RIGHT;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
            state$Direction = State$Direction.END;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
            state$Direction = State$Direction.TOP;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Direction;
            state$Direction = State$Direction.BOTTOM;
            n11 = state$Direction.ordinal();
            nArray[n11] = n10 = 6;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

