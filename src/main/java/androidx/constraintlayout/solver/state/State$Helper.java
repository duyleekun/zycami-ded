/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

public final class State$Helper
extends Enum {
    private static final /* synthetic */ State$Helper[] $VALUES;
    public static final /* enum */ State$Helper ALIGN_HORIZONTALLY;
    public static final /* enum */ State$Helper ALIGN_VERTICALLY;
    public static final /* enum */ State$Helper BARRIER;
    public static final /* enum */ State$Helper FLOW;
    public static final /* enum */ State$Helper HORIZONTAL_CHAIN;
    public static final /* enum */ State$Helper LAYER;
    public static final /* enum */ State$Helper VERTICAL_CHAIN;

    static {
        State$Helper state$Helper;
        State$Helper state$Helper2;
        State$Helper state$Helper3;
        State$Helper state$Helper4;
        State$Helper state$Helper5;
        State$Helper state$Helper6;
        State$Helper state$Helper7;
        HORIZONTAL_CHAIN = state$Helper7 = new State$Helper("HORIZONTAL_CHAIN", 0);
        int n10 = 1;
        VERTICAL_CHAIN = state$Helper6 = new State$Helper("VERTICAL_CHAIN", n10);
        int n11 = 2;
        ALIGN_HORIZONTALLY = state$Helper5 = new State$Helper("ALIGN_HORIZONTALLY", n11);
        int n12 = 3;
        ALIGN_VERTICALLY = state$Helper4 = new State$Helper("ALIGN_VERTICALLY", n12);
        int n13 = 4;
        BARRIER = state$Helper3 = new State$Helper("BARRIER", n13);
        int n14 = 5;
        LAYER = state$Helper2 = new State$Helper("LAYER", n14);
        int n15 = 6;
        FLOW = state$Helper = new State$Helper("FLOW", n15);
        State$Helper[] state$HelperArray = new State$Helper[7];
        state$HelperArray[0] = state$Helper7;
        state$HelperArray[n10] = state$Helper6;
        state$HelperArray[n11] = state$Helper5;
        state$HelperArray[n12] = state$Helper4;
        state$HelperArray[n13] = state$Helper3;
        state$HelperArray[n14] = state$Helper2;
        state$HelperArray[n15] = state$Helper;
        $VALUES = state$HelperArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private State$Helper() {
        void var2_-1;
        void var1_-1;
    }

    public static State$Helper valueOf(String string2) {
        return Enum.valueOf(State$Helper.class, string2);
    }

    public static State$Helper[] values() {
        return (State$Helper[])$VALUES.clone();
    }
}

