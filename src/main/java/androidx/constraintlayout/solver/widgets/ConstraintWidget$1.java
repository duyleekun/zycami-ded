/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;

public class ConstraintWidget$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        Enum enum_;
        int n11;
        Object object2;
        int n12;
        Object object3;
        int n13;
        Object object4;
        int n14 = ConstraintWidget$DimensionBehaviour.values().length;
        int[] nArray = new int[n14];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = nArray;
        int n15 = 1;
        try {
            object4 = ConstraintWidget$DimensionBehaviour.FIXED;
            n13 = object4.ordinal();
            nArray[n13] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 2;
        try {
            object4 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            object3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            n12 = object3.ordinal();
            object4[n12] = (ConstraintWidget$DimensionBehaviour)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 3;
        try {
            object3 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            object2 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
            n11 = ((Enum)object2).ordinal();
            object3[n11] = (ConstraintWidget$DimensionBehaviour)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = 4;
        try {
            object2 = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
            enum_ = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
            n10 = enum_.ordinal();
            object2[n10] = (ConstraintWidget$DimensionBehaviour)n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n11 = ConstraintAnchor$Type.values().length;
        object2 = new int[n11];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = (int[])object2;
        try {
            enum_ = ConstraintAnchor$Type.LEFT;
            n10 = enum_.ordinal();
            object2[n10] = (ConstraintWidget$DimensionBehaviour)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object2 = ConstraintAnchor$Type.TOP;
            n11 = ((Enum)object2).ordinal();
            object[n11] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = (Object)ConstraintAnchor$Type.RIGHT;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.BOTTOM;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.BASELINE;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.CENTER;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.CENTER_X;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.CENTER_Y;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            object = ConstraintAnchor$Type.NONE;
            n15 = ((Enum)object).ordinal();
            nArray[n15] = n13 = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

