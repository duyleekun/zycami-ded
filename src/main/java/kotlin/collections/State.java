/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

public final class State
extends Enum {
    public static final /* enum */ State Done;
    public static final /* enum */ State Failed;
    public static final /* enum */ State NotReady;
    public static final /* enum */ State Ready;
    private static final /* synthetic */ State[] a;

    static {
        State state;
        State[] stateArray = new State[4];
        Ready = state = new State("Ready", 0);
        stateArray[0] = state;
        int n10 = 1;
        NotReady = state = new State("NotReady", n10);
        stateArray[n10] = state;
        n10 = 2;
        Done = state = new State("Done", n10);
        stateArray[n10] = state;
        n10 = 3;
        Failed = state = new State("Failed", n10);
        stateArray[n10] = state;
        a = stateArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private State() {
        void var2_-1;
        void var1_-1;
    }

    public static State valueOf(String string2) {
        return Enum.valueOf(State.class, string2);
    }

    public static State[] values() {
        return (State[])a.clone();
    }
}

