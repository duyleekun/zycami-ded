/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.widget;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

public class ConstraintLayout$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n12 = ConstraintWidget$DimensionBehaviour.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = nArray;
        try {
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
            n11 = constraintWidget$DimensionBehaviour.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            n11 = constraintWidget$DimensionBehaviour.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
            n11 = constraintWidget$DimensionBehaviour.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
            n11 = constraintWidget$DimensionBehaviour.ordinal();
            nArray[n11] = n10 = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

