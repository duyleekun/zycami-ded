/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

public final class State$Chain
extends Enum {
    private static final /* synthetic */ State$Chain[] $VALUES;
    public static final /* enum */ State$Chain PACKED;
    public static final /* enum */ State$Chain SPREAD;
    public static final /* enum */ State$Chain SPREAD_INSIDE;

    static {
        State$Chain state$Chain;
        State$Chain state$Chain2;
        State$Chain state$Chain3;
        SPREAD = state$Chain3 = new State$Chain("SPREAD", 0);
        int n10 = 1;
        SPREAD_INSIDE = state$Chain2 = new State$Chain("SPREAD_INSIDE", n10);
        int n11 = 2;
        PACKED = state$Chain = new State$Chain("PACKED", n11);
        State$Chain[] state$ChainArray = new State$Chain[3];
        state$ChainArray[0] = state$Chain3;
        state$ChainArray[n10] = state$Chain2;
        state$ChainArray[n11] = state$Chain;
        $VALUES = state$ChainArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private State$Chain() {
        void var2_-1;
        void var1_-1;
    }

    public static State$Chain valueOf(String string2) {
        return Enum.valueOf(State$Chain.class, string2);
    }

    public static State$Chain[] values() {
        return (State$Chain[])$VALUES.clone();
    }
}

