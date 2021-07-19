/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

public final class State$Constraint
extends Enum {
    private static final /* synthetic */ State$Constraint[] $VALUES;
    public static final /* enum */ State$Constraint BASELINE_TO_BASELINE;
    public static final /* enum */ State$Constraint BOTTOM_TO_BOTTOM;
    public static final /* enum */ State$Constraint BOTTOM_TO_TOP;
    public static final /* enum */ State$Constraint CENTER_HORIZONTALLY;
    public static final /* enum */ State$Constraint CENTER_VERTICALLY;
    public static final /* enum */ State$Constraint END_TO_END;
    public static final /* enum */ State$Constraint END_TO_START;
    public static final /* enum */ State$Constraint LEFT_TO_LEFT;
    public static final /* enum */ State$Constraint LEFT_TO_RIGHT;
    public static final /* enum */ State$Constraint RIGHT_TO_LEFT;
    public static final /* enum */ State$Constraint RIGHT_TO_RIGHT;
    public static final /* enum */ State$Constraint START_TO_END;
    public static final /* enum */ State$Constraint START_TO_START;
    public static final /* enum */ State$Constraint TOP_TO_BOTTOM;
    public static final /* enum */ State$Constraint TOP_TO_TOP;

    static {
        State$Constraint state$Constraint;
        State$Constraint state$Constraint2;
        State$Constraint state$Constraint3;
        State$Constraint state$Constraint4;
        State$Constraint state$Constraint5;
        State$Constraint state$Constraint6;
        State$Constraint state$Constraint7;
        State$Constraint state$Constraint8;
        State$Constraint state$Constraint9;
        State$Constraint state$Constraint10;
        State$Constraint state$Constraint11;
        State$Constraint state$Constraint12;
        State$Constraint state$Constraint13;
        State$Constraint state$Constraint14;
        State$Constraint state$Constraint15;
        LEFT_TO_LEFT = state$Constraint15 = new State$Constraint("LEFT_TO_LEFT", 0);
        LEFT_TO_RIGHT = state$Constraint14 = new State$Constraint("LEFT_TO_RIGHT", 1);
        RIGHT_TO_LEFT = state$Constraint13 = new State$Constraint("RIGHT_TO_LEFT", 2);
        RIGHT_TO_RIGHT = state$Constraint12 = new State$Constraint("RIGHT_TO_RIGHT", 3);
        START_TO_START = state$Constraint11 = new State$Constraint("START_TO_START", 4);
        START_TO_END = state$Constraint10 = new State$Constraint("START_TO_END", 5);
        END_TO_START = state$Constraint9 = new State$Constraint("END_TO_START", 6);
        END_TO_END = state$Constraint8 = new State$Constraint("END_TO_END", 7);
        TOP_TO_TOP = state$Constraint7 = new State$Constraint("TOP_TO_TOP", 8);
        TOP_TO_BOTTOM = state$Constraint6 = new State$Constraint("TOP_TO_BOTTOM", 9);
        BOTTOM_TO_TOP = state$Constraint5 = new State$Constraint("BOTTOM_TO_TOP", 10);
        BOTTOM_TO_BOTTOM = state$Constraint4 = new State$Constraint("BOTTOM_TO_BOTTOM", 11);
        BASELINE_TO_BASELINE = state$Constraint3 = new State$Constraint("BASELINE_TO_BASELINE", 12);
        CENTER_HORIZONTALLY = state$Constraint2 = new State$Constraint("CENTER_HORIZONTALLY", 13);
        int n10 = 14;
        CENTER_VERTICALLY = state$Constraint = new State$Constraint("CENTER_VERTICALLY", n10);
        State$Constraint[] state$ConstraintArray = new State$Constraint[15];
        state$ConstraintArray[0] = state$Constraint15;
        state$ConstraintArray[1] = state$Constraint14;
        state$ConstraintArray[2] = state$Constraint13;
        state$ConstraintArray[3] = state$Constraint12;
        state$ConstraintArray[4] = state$Constraint11;
        state$ConstraintArray[5] = state$Constraint10;
        state$ConstraintArray[6] = state$Constraint9;
        state$ConstraintArray[7] = state$Constraint8;
        state$ConstraintArray[8] = state$Constraint7;
        state$ConstraintArray[9] = state$Constraint6;
        state$ConstraintArray[10] = state$Constraint5;
        state$ConstraintArray[11] = state$Constraint4;
        state$ConstraintArray[12] = state$Constraint3;
        state$ConstraintArray[13] = state$Constraint2;
        state$ConstraintArray[n10] = state$Constraint;
        $VALUES = state$ConstraintArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private State$Constraint() {
        void var2_-1;
        void var1_-1;
    }

    public static State$Constraint valueOf(String string2) {
        return Enum.valueOf(State$Constraint.class, string2);
    }

    public static State$Constraint[] values() {
        return (State$Constraint[])$VALUES.clone();
    }
}

