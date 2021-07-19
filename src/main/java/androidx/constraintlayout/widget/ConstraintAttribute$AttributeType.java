/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.widget;

public final class ConstraintAttribute$AttributeType
extends Enum {
    private static final /* synthetic */ ConstraintAttribute$AttributeType[] $VALUES;
    public static final /* enum */ ConstraintAttribute$AttributeType BOOLEAN_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType COLOR_DRAWABLE_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType COLOR_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType DIMENSION_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType FLOAT_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType INT_TYPE;
    public static final /* enum */ ConstraintAttribute$AttributeType STRING_TYPE;

    static {
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType2;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType3;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType4;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType5;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType6;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType7;
        INT_TYPE = constraintAttribute$AttributeType7 = new ConstraintAttribute$AttributeType("INT_TYPE", 0);
        int n10 = 1;
        FLOAT_TYPE = constraintAttribute$AttributeType6 = new ConstraintAttribute$AttributeType("FLOAT_TYPE", n10);
        int n11 = 2;
        COLOR_TYPE = constraintAttribute$AttributeType5 = new ConstraintAttribute$AttributeType("COLOR_TYPE", n11);
        int n12 = 3;
        COLOR_DRAWABLE_TYPE = constraintAttribute$AttributeType4 = new ConstraintAttribute$AttributeType("COLOR_DRAWABLE_TYPE", n12);
        int n13 = 4;
        STRING_TYPE = constraintAttribute$AttributeType3 = new ConstraintAttribute$AttributeType("STRING_TYPE", n13);
        int n14 = 5;
        BOOLEAN_TYPE = constraintAttribute$AttributeType2 = new ConstraintAttribute$AttributeType("BOOLEAN_TYPE", n14);
        int n15 = 6;
        DIMENSION_TYPE = constraintAttribute$AttributeType = new ConstraintAttribute$AttributeType("DIMENSION_TYPE", n15);
        ConstraintAttribute$AttributeType[] constraintAttribute$AttributeTypeArray = new ConstraintAttribute$AttributeType[7];
        constraintAttribute$AttributeTypeArray[0] = constraintAttribute$AttributeType7;
        constraintAttribute$AttributeTypeArray[n10] = constraintAttribute$AttributeType6;
        constraintAttribute$AttributeTypeArray[n11] = constraintAttribute$AttributeType5;
        constraintAttribute$AttributeTypeArray[n12] = constraintAttribute$AttributeType4;
        constraintAttribute$AttributeTypeArray[n13] = constraintAttribute$AttributeType3;
        constraintAttribute$AttributeTypeArray[n14] = constraintAttribute$AttributeType2;
        constraintAttribute$AttributeTypeArray[n15] = constraintAttribute$AttributeType;
        $VALUES = constraintAttribute$AttributeTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConstraintAttribute$AttributeType() {
        void var2_-1;
        void var1_-1;
    }

    public static ConstraintAttribute$AttributeType valueOf(String string2) {
        return Enum.valueOf(ConstraintAttribute$AttributeType.class, string2);
    }

    public static ConstraintAttribute$AttributeType[] values() {
        return (ConstraintAttribute$AttributeType[])$VALUES.clone();
    }
}

