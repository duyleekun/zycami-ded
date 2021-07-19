/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

public final class ConstraintAnchor$Type
extends Enum {
    private static final /* synthetic */ ConstraintAnchor$Type[] $VALUES;
    public static final /* enum */ ConstraintAnchor$Type BASELINE;
    public static final /* enum */ ConstraintAnchor$Type BOTTOM;
    public static final /* enum */ ConstraintAnchor$Type CENTER;
    public static final /* enum */ ConstraintAnchor$Type CENTER_X;
    public static final /* enum */ ConstraintAnchor$Type CENTER_Y;
    public static final /* enum */ ConstraintAnchor$Type LEFT;
    public static final /* enum */ ConstraintAnchor$Type NONE;
    public static final /* enum */ ConstraintAnchor$Type RIGHT;
    public static final /* enum */ ConstraintAnchor$Type TOP;

    static {
        ConstraintAnchor$Type constraintAnchor$Type;
        ConstraintAnchor$Type constraintAnchor$Type2;
        ConstraintAnchor$Type constraintAnchor$Type3;
        ConstraintAnchor$Type constraintAnchor$Type4;
        ConstraintAnchor$Type constraintAnchor$Type5;
        ConstraintAnchor$Type constraintAnchor$Type6;
        ConstraintAnchor$Type constraintAnchor$Type7;
        ConstraintAnchor$Type constraintAnchor$Type8;
        ConstraintAnchor$Type constraintAnchor$Type9;
        NONE = constraintAnchor$Type9 = new ConstraintAnchor$Type("NONE", 0);
        int n10 = 1;
        LEFT = constraintAnchor$Type8 = new ConstraintAnchor$Type("LEFT", n10);
        int n11 = 2;
        TOP = constraintAnchor$Type7 = new ConstraintAnchor$Type("TOP", n11);
        int n12 = 3;
        RIGHT = constraintAnchor$Type6 = new ConstraintAnchor$Type("RIGHT", n12);
        int n13 = 4;
        BOTTOM = constraintAnchor$Type5 = new ConstraintAnchor$Type("BOTTOM", n13);
        BASELINE = constraintAnchor$Type4 = new ConstraintAnchor$Type("BASELINE", 5);
        CENTER = constraintAnchor$Type3 = new ConstraintAnchor$Type("CENTER", 6);
        CENTER_X = constraintAnchor$Type2 = new ConstraintAnchor$Type("CENTER_X", 7);
        int n14 = 8;
        CENTER_Y = constraintAnchor$Type = new ConstraintAnchor$Type("CENTER_Y", n14);
        ConstraintAnchor$Type[] constraintAnchor$TypeArray = new ConstraintAnchor$Type[9];
        constraintAnchor$TypeArray[0] = constraintAnchor$Type9;
        constraintAnchor$TypeArray[n10] = constraintAnchor$Type8;
        constraintAnchor$TypeArray[n11] = constraintAnchor$Type7;
        constraintAnchor$TypeArray[n12] = constraintAnchor$Type6;
        constraintAnchor$TypeArray[n13] = constraintAnchor$Type5;
        constraintAnchor$TypeArray[5] = constraintAnchor$Type4;
        constraintAnchor$TypeArray[6] = constraintAnchor$Type3;
        constraintAnchor$TypeArray[7] = constraintAnchor$Type2;
        constraintAnchor$TypeArray[n14] = constraintAnchor$Type;
        $VALUES = constraintAnchor$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConstraintAnchor$Type() {
        void var2_-1;
        void var1_-1;
    }

    public static ConstraintAnchor$Type valueOf(String string2) {
        return Enum.valueOf(ConstraintAnchor$Type.class, string2);
    }

    public static ConstraintAnchor$Type[] values() {
        return (ConstraintAnchor$Type[])$VALUES.clone();
    }
}

