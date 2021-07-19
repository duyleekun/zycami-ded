/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

public final class ConstraintWidget$DimensionBehaviour
extends Enum {
    private static final /* synthetic */ ConstraintWidget$DimensionBehaviour[] $VALUES;
    public static final /* enum */ ConstraintWidget$DimensionBehaviour FIXED;
    public static final /* enum */ ConstraintWidget$DimensionBehaviour MATCH_CONSTRAINT;
    public static final /* enum */ ConstraintWidget$DimensionBehaviour MATCH_PARENT;
    public static final /* enum */ ConstraintWidget$DimensionBehaviour WRAP_CONTENT;

    static {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour4;
        FIXED = constraintWidget$DimensionBehaviour4 = new ConstraintWidget$DimensionBehaviour("FIXED", 0);
        int n10 = 1;
        WRAP_CONTENT = constraintWidget$DimensionBehaviour3 = new ConstraintWidget$DimensionBehaviour("WRAP_CONTENT", n10);
        int n11 = 2;
        MATCH_CONSTRAINT = constraintWidget$DimensionBehaviour2 = new ConstraintWidget$DimensionBehaviour("MATCH_CONSTRAINT", n11);
        int n12 = 3;
        MATCH_PARENT = constraintWidget$DimensionBehaviour = new ConstraintWidget$DimensionBehaviour("MATCH_PARENT", n12);
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = new ConstraintWidget$DimensionBehaviour[4];
        constraintWidget$DimensionBehaviourArray[0] = constraintWidget$DimensionBehaviour4;
        constraintWidget$DimensionBehaviourArray[n10] = constraintWidget$DimensionBehaviour3;
        constraintWidget$DimensionBehaviourArray[n11] = constraintWidget$DimensionBehaviour2;
        constraintWidget$DimensionBehaviourArray[n12] = constraintWidget$DimensionBehaviour;
        $VALUES = constraintWidget$DimensionBehaviourArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConstraintWidget$DimensionBehaviour() {
        void var2_-1;
        void var1_-1;
    }

    public static ConstraintWidget$DimensionBehaviour valueOf(String string2) {
        return Enum.valueOf(ConstraintWidget$DimensionBehaviour.class, string2);
    }

    public static ConstraintWidget$DimensionBehaviour[] values() {
        return (ConstraintWidget$DimensionBehaviour[])$VALUES.clone();
    }
}

