/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

public final class Dimension$Type
extends Enum {
    private static final /* synthetic */ Dimension$Type[] $VALUES;
    public static final /* enum */ Dimension$Type FIXED;
    public static final /* enum */ Dimension$Type MATCH_CONSTRAINT;
    public static final /* enum */ Dimension$Type MATCH_PARENT;
    public static final /* enum */ Dimension$Type WRAP;

    static {
        Dimension$Type dimension$Type;
        Dimension$Type dimension$Type2;
        Dimension$Type dimension$Type3;
        Dimension$Type dimension$Type4;
        FIXED = dimension$Type4 = new Dimension$Type("FIXED", 0);
        int n10 = 1;
        WRAP = dimension$Type3 = new Dimension$Type("WRAP", n10);
        int n11 = 2;
        MATCH_PARENT = dimension$Type2 = new Dimension$Type("MATCH_PARENT", n11);
        int n12 = 3;
        MATCH_CONSTRAINT = dimension$Type = new Dimension$Type("MATCH_CONSTRAINT", n12);
        Dimension$Type[] dimension$TypeArray = new Dimension$Type[4];
        dimension$TypeArray[0] = dimension$Type4;
        dimension$TypeArray[n10] = dimension$Type3;
        dimension$TypeArray[n11] = dimension$Type2;
        dimension$TypeArray[n12] = dimension$Type;
        $VALUES = dimension$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Dimension$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static Dimension$Type valueOf(String string2) {
        return Enum.valueOf(Dimension$Type.class, string2);
    }

    public static Dimension$Type[] values() {
        return (Dimension$Type[])$VALUES.clone();
    }
}

