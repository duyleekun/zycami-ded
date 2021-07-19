/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State$Chain;

public class HorizontalChainReference$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        State$Chain state$Chain;
        int n12 = State$Chain.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$state$State$Chain = nArray;
        try {
            state$Chain = State$Chain.SPREAD;
            n11 = state$Chain.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
            state$Chain = State$Chain.SPREAD_INSIDE;
            n11 = state$Chain.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$state$State$Chain;
            state$Chain = State$Chain.PACKED;
            n11 = state$Chain.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

