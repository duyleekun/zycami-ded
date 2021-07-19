/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;

public class ConstraintAnchor$1 {
    public static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        ConstraintAnchor$Type constraintAnchor$Type;
        int n12 = ConstraintAnchor$Type.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = nArray;
        try {
            constraintAnchor$Type = ConstraintAnchor$Type.CENTER;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.RIGHT;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.TOP;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.BOTTOM;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.BASELINE;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.CENTER_X;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.CENTER_Y;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
            constraintAnchor$Type = ConstraintAnchor$Type.NONE;
            n11 = constraintAnchor$Type.ordinal();
            nArray[n11] = n10 = 9;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

