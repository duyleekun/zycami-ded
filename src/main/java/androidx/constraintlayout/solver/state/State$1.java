/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State$Helper;

public class State$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        State$Helper state$Helper;
        int n12 = State$Helper.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Helper = nArray;
        try {
            state$Helper = State$Helper.HORIZONTAL_CHAIN;
            n11 = state$Helper.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
            state$Helper = State$Helper.VERTICAL_CHAIN;
            n11 = state$Helper.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
            state$Helper = State$Helper.ALIGN_HORIZONTALLY;
            n11 = state$Helper.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
            state$Helper = State$Helper.ALIGN_VERTICALLY;
            n11 = state$Helper.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Helper;
            state$Helper = State$Helper.BARRIER;
            n11 = state$Helper.ordinal();
            nArray[n11] = n10 = 5;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

