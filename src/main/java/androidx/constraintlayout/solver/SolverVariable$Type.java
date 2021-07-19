/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

public final class SolverVariable$Type
extends Enum {
    private static final /* synthetic */ SolverVariable$Type[] $VALUES;
    public static final /* enum */ SolverVariable$Type CONSTANT;
    public static final /* enum */ SolverVariable$Type ERROR;
    public static final /* enum */ SolverVariable$Type SLACK;
    public static final /* enum */ SolverVariable$Type UNKNOWN;
    public static final /* enum */ SolverVariable$Type UNRESTRICTED;

    static {
        SolverVariable$Type solverVariable$Type;
        SolverVariable$Type solverVariable$Type2;
        SolverVariable$Type solverVariable$Type3;
        SolverVariable$Type solverVariable$Type4;
        SolverVariable$Type solverVariable$Type5;
        UNRESTRICTED = solverVariable$Type5 = new SolverVariable$Type("UNRESTRICTED", 0);
        int n10 = 1;
        CONSTANT = solverVariable$Type4 = new SolverVariable$Type("CONSTANT", n10);
        int n11 = 2;
        SLACK = solverVariable$Type3 = new SolverVariable$Type("SLACK", n11);
        int n12 = 3;
        ERROR = solverVariable$Type2 = new SolverVariable$Type("ERROR", n12);
        int n13 = 4;
        UNKNOWN = solverVariable$Type = new SolverVariable$Type("UNKNOWN", n13);
        SolverVariable$Type[] solverVariable$TypeArray = new SolverVariable$Type[5];
        solverVariable$TypeArray[0] = solverVariable$Type5;
        solverVariable$TypeArray[n10] = solverVariable$Type4;
        solverVariable$TypeArray[n11] = solverVariable$Type3;
        solverVariable$TypeArray[n12] = solverVariable$Type2;
        solverVariable$TypeArray[n13] = solverVariable$Type;
        $VALUES = solverVariable$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private SolverVariable$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static SolverVariable$Type valueOf(String string2) {
        return Enum.valueOf(SolverVariable$Type.class, string2);
    }

    public static SolverVariable$Type[] values() {
        return (SolverVariable$Type[])$VALUES.clone();
    }
}

