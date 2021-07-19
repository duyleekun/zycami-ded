/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

public final class State$Direction
extends Enum {
    private static final /* synthetic */ State$Direction[] $VALUES;
    public static final /* enum */ State$Direction BOTTOM;
    public static final /* enum */ State$Direction END;
    public static final /* enum */ State$Direction LEFT;
    public static final /* enum */ State$Direction RIGHT;
    public static final /* enum */ State$Direction START;
    public static final /* enum */ State$Direction TOP;

    static {
        State$Direction state$Direction;
        State$Direction state$Direction2;
        State$Direction state$Direction3;
        State$Direction state$Direction4;
        State$Direction state$Direction5;
        State$Direction state$Direction6;
        LEFT = state$Direction6 = new State$Direction("LEFT", 0);
        int n10 = 1;
        RIGHT = state$Direction5 = new State$Direction("RIGHT", n10);
        int n11 = 2;
        START = state$Direction4 = new State$Direction("START", n11);
        int n12 = 3;
        END = state$Direction3 = new State$Direction("END", n12);
        int n13 = 4;
        TOP = state$Direction2 = new State$Direction("TOP", n13);
        int n14 = 5;
        BOTTOM = state$Direction = new State$Direction("BOTTOM", n14);
        State$Direction[] state$DirectionArray = new State$Direction[6];
        state$DirectionArray[0] = state$Direction6;
        state$DirectionArray[n10] = state$Direction5;
        state$DirectionArray[n11] = state$Direction4;
        state$DirectionArray[n12] = state$Direction3;
        state$DirectionArray[n13] = state$Direction2;
        state$DirectionArray[n14] = state$Direction;
        $VALUES = state$DirectionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private State$Direction() {
        void var2_-1;
        void var1_-1;
    }

    public static State$Direction valueOf(String string2) {
        return Enum.valueOf(State$Direction.class, string2);
    }

    public static State$Direction[] values() {
        return (State$Direction[])$VALUES.clone();
    }
}

