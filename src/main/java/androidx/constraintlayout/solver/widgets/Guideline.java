/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline$1;
import java.util.HashMap;

public class Guideline
extends ConstraintWidget {
    public static final int HORIZONTAL = 0;
    public static final int RELATIVE_BEGIN = 1;
    public static final int RELATIVE_END = 2;
    public static final int RELATIVE_PERCENT = 0;
    public static final int RELATIVE_UNKNWON = 255;
    public static final int VERTICAL = 1;
    private ConstraintAnchor mAnchor;
    private int mMinimumPosition;
    private int mOrientation;
    public int mRelativeBegin;
    public int mRelativeEnd;
    public float mRelativePercent = -1.0f;
    private boolean resolved;

    public Guideline() {
        ConstraintAnchor constraintAnchor;
        int n10;
        this.mRelativeBegin = n10 = -1;
        this.mRelativeEnd = n10;
        this.mAnchor = constraintAnchor = this.mTop;
        constraintAnchor = null;
        this.mOrientation = 0;
        this.mMinimumPosition = 0;
        this.mAnchors.clear();
        ConstraintAnchor[] constraintAnchorArray = this.mAnchors;
        ConstraintAnchor[] constraintAnchorArray2 = this.mAnchor;
        constraintAnchorArray.add(constraintAnchorArray2);
        constraintAnchorArray = this.mListAnchors;
        int n11 = constraintAnchorArray.length;
        for (n10 = 0; n10 < n11; ++n10) {
            ConstraintAnchor constraintAnchor2;
            constraintAnchorArray2 = this.mListAnchors;
            constraintAnchorArray2[n10] = constraintAnchor2 = this.mAnchor;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean n10) {
        int n11;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        Object object = (ConstraintWidgetContainer)this.getParent();
        if (object == null) {
            return;
        }
        Object object2 = ConstraintAnchor$Type.LEFT;
        object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
        Object object3 = ConstraintAnchor$Type.RIGHT;
        object3 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object3));
        Object object4 = this.mParent;
        int n12 = 1;
        if (object4 != null && (object4 = object4.mListDimensionBehaviors[0]) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
            n11 = n12;
        } else {
            n11 = 0;
            object4 = null;
        }
        int n13 = this.mOrientation;
        if (n13 == 0) {
            object2 = ConstraintAnchor$Type.TOP;
            object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
            object3 = ConstraintAnchor$Type.BOTTOM;
            object3 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object3));
            object = this.mParent;
            if (object == null || (object = ((ConstraintWidget)object).mListDimensionBehaviors[n12]) != (object4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                n12 = 0;
            }
            n11 = n12;
        }
        n10 = this.resolved;
        n12 = -1;
        n13 = 5;
        if (n10 != 0 && (n10 = ((ConstraintAnchor)(object = this.mAnchor)).hasFinalValue()) != 0) {
            object = this.mAnchor;
            object = linearSystem.createObjectVariable(object);
            ConstraintAnchor constraintAnchor = this.mAnchor;
            int n14 = constraintAnchor.getFinalValue();
            linearSystem.addEquality((SolverVariable)object, n14);
            n14 = this.mRelativeBegin;
            if (n14 != n12) {
                if (n11 != 0) {
                    object2 = linearSystem.createObjectVariable(object3);
                    linearSystem.addGreaterThan((SolverVariable)object2, (SolverVariable)object, 0, n13);
                }
            } else {
                n14 = this.mRelativeEnd;
                if (n14 != n12 && n11 != 0) {
                    object3 = linearSystem.createObjectVariable(object3);
                    object2 = linearSystem.createObjectVariable(object2);
                    linearSystem.addGreaterThan((SolverVariable)object, (SolverVariable)object2, 0, n13);
                    linearSystem.addGreaterThan((SolverVariable)object3, (SolverVariable)object, 0, n13);
                }
            }
            this.resolved = false;
            return;
        }
        n10 = this.mRelativeBegin;
        int n15 = 8;
        if (n10 != n12) {
            object = this.mAnchor;
            object = linearSystem.createObjectVariable(object);
            object2 = linearSystem.createObjectVariable(object2);
            n12 = this.mRelativeBegin;
            linearSystem.addEquality((SolverVariable)object, (SolverVariable)object2, n12, n15);
            if (n11 != 0) {
                object2 = linearSystem.createObjectVariable(object3);
                linearSystem.addGreaterThan((SolverVariable)object2, (SolverVariable)object, 0, n13);
            }
        } else {
            n10 = this.mRelativeEnd;
            if (n10 != n12) {
                object = this.mAnchor;
                object = linearSystem.createObjectVariable(object);
                object3 = linearSystem.createObjectVariable(object3);
                n12 = -this.mRelativeEnd;
                linearSystem.addEquality((SolverVariable)object, (SolverVariable)object3, n12, n15);
                if (n11 != 0) {
                    object2 = linearSystem.createObjectVariable(object2);
                    linearSystem.addGreaterThan((SolverVariable)object, (SolverVariable)object2, 0, n13);
                    linearSystem.addGreaterThan((SolverVariable)object3, (SolverVariable)object, 0, n13);
                }
            } else {
                float f10 = this.mRelativePercent;
                float f11 = -1.0f;
                float f12 = f10 - f11;
                n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
                if (n10 != 0) {
                    object = this.mAnchor;
                    object = linearSystem.createObjectVariable(object);
                    object2 = linearSystem.createObjectVariable(object3);
                    float f13 = this.mRelativePercent;
                    object = LinearSystem.createRowDimensionPercent(linearSystem, (SolverVariable)object, (SolverVariable)object2, f13);
                    linearSystem.addConstraint((ArrayRow)object);
                }
            }
        }
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap hashMap) {
        int n10;
        float f10;
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Guideline)constraintWidget;
        this.mRelativePercent = f10 = ((Guideline)constraintWidget).mRelativePercent;
        this.mRelativeBegin = n10 = ((Guideline)constraintWidget).mRelativeBegin;
        this.mRelativeEnd = n10 = ((Guideline)constraintWidget).mRelativeEnd;
        int n11 = ((Guideline)constraintWidget).mOrientation;
        this.setOrientation(n11);
    }

    public void cyclePosition() {
        int n10 = this.mRelativeBegin;
        int n11 = -1;
        if (n10 != n11) {
            this.inferRelativePercentPosition();
        } else {
            float f10 = this.mRelativePercent;
            float f11 = -1.0f;
            float f12 = f10 - f11;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n10 != 0) {
                this.inferRelativeEndPosition();
            } else {
                n10 = this.mRelativeEnd;
                if (n10 != n11) {
                    this.inferRelativeBeginPosition();
                }
            }
        }
    }

    public ConstraintAnchor getAnchor() {
        return this.mAnchor;
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor$Type object) {
        Object object2 = Guideline$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                break;
            }
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                return null;
            }
            case 3: 
            case 4: {
                n11 = this.mOrientation;
                if (n11 != 0) break;
                return this.mAnchor;
            }
            case 1: 
            case 2: {
                n11 = this.mOrientation;
                n10 = 1;
                if (n11 != n10) break;
                return this.mAnchor;
            }
        }
        object2 = new AssertionError;
        object = object.name();
        object2(object);
        throw object2;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getRelativeBegin() {
        return this.mRelativeBegin;
    }

    public int getRelativeBehaviour() {
        float f10 = this.mRelativePercent;
        int n10 = -1082130432;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            return 0;
        }
        object = this.mRelativeBegin;
        n10 = -1;
        f11 = 0.0f / 0.0f;
        if (object != n10) {
            return 1;
        }
        object = this.mRelativeEnd;
        if (object != n10) {
            return 2;
        }
        return n10;
    }

    public int getRelativeEnd() {
        return this.mRelativeEnd;
    }

    public float getRelativePercent() {
        return this.mRelativePercent;
    }

    public String getType() {
        return "Guideline";
    }

    public void inferRelativeBeginPosition() {
        int n10 = this.getX();
        int n11 = this.mOrientation;
        if (n11 == 0) {
            n10 = this.getY();
        }
        this.setGuideBegin(n10);
    }

    public void inferRelativeEndPosition() {
        ConstraintWidget constraintWidget = this.getParent();
        int n10 = constraintWidget.getWidth();
        int n11 = this.getX();
        n10 -= n11;
        n11 = this.mOrientation;
        if (n11 == 0) {
            constraintWidget = this.getParent();
            n10 = constraintWidget.getHeight();
            n11 = this.getY();
            n10 -= n11;
        }
        this.setGuideEnd(n10);
    }

    public void inferRelativePercentPosition() {
        int n10 = this.getX();
        float f10 = n10;
        ConstraintWidget constraintWidget = this.getParent();
        float f11 = constraintWidget.getWidth();
        f10 /= f11;
        int n11 = this.mOrientation;
        if (n11 == 0) {
            n10 = this.getY();
            f10 = n10;
            constraintWidget = this.getParent();
            n11 = constraintWidget.getHeight();
            f11 = n11;
            f10 /= f11;
        }
        this.setGuidePercent(f10);
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isPercent() {
        void var4_9;
        float f10 = this.mRelativePercent;
        int n10 = -1082130432;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            int n11;
            int n12 = this.mRelativeBegin;
            n10 = -1;
            f11 = 0.0f / 0.0f;
            if (n12 == n10 && (n11 = this.mRelativeEnd) == n10) {
                return (boolean)var4_9;
            }
        }
        boolean bl2 = false;
        return (boolean)var4_9;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void setFinalValue(int n10) {
        this.mAnchor.setFinalValue(n10);
        this.resolved = true;
    }

    public void setGuideBegin(int n10) {
        int n11 = -1;
        if (n10 > n11) {
            float f10;
            this.mRelativePercent = f10 = -1.0f;
            this.mRelativeBegin = n10;
            this.mRelativeEnd = n11;
        }
    }

    public void setGuideEnd(int n10) {
        int n11 = -1;
        if (n10 > n11) {
            float f10;
            this.mRelativePercent = f10 = -1.0f;
            this.mRelativeBegin = n11;
            this.mRelativeEnd = n10;
        }
    }

    public void setGuidePercent(float f10) {
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            this.mRelativePercent = f10;
            int n10 = -1;
            f10 = 0.0f / 0.0f;
            this.mRelativeBegin = n10;
            this.mRelativeEnd = n10;
        }
    }

    public void setGuidePercent(int n10) {
        float f10 = (float)n10 / 100.0f;
        this.setGuidePercent(f10);
    }

    public void setMinimumPosition(int n10) {
        this.mMinimumPosition = n10;
    }

    public void setOrientation(int n10) {
        int n11 = this.mOrientation;
        if (n11 == n10) {
            return;
        }
        this.mOrientation = n10;
        ConstraintAnchor[] constraintAnchorArray = this.mAnchors;
        constraintAnchorArray.clear();
        n10 = this.mOrientation;
        n11 = 1;
        if (n10 == n11) {
            constraintAnchorArray = this.mLeft;
            this.mAnchor = constraintAnchorArray;
        } else {
            constraintAnchorArray = this.mTop;
            this.mAnchor = constraintAnchorArray;
        }
        constraintAnchorArray = this.mAnchors;
        ConstraintAnchor constraintAnchor = this.mAnchor;
        constraintAnchorArray.add(constraintAnchor);
        constraintAnchorArray = this.mListAnchors;
        n10 = constraintAnchorArray.length;
        constraintAnchor = null;
        for (n11 = 0; n11 < n10; ++n11) {
            ConstraintAnchor constraintAnchor2;
            ConstraintAnchor[] constraintAnchorArray2 = this.mListAnchors;
            constraintAnchorArray2[n11] = constraintAnchor2 = this.mAnchor;
        }
    }

    public void updateFromSolver(LinearSystem object, boolean bl2) {
        Object object2 = this.getParent();
        if (object2 == null) {
            return;
        }
        object2 = this.mAnchor;
        int n10 = ((LinearSystem)object).getObjectVariableValue(object2);
        int n11 = this.mOrientation;
        int n12 = 1;
        if (n11 == n12) {
            this.setX(n10);
            this.setY(0);
            object = this.getParent();
            n10 = ((ConstraintWidget)object).getHeight();
            this.setHeight(n10);
            this.setWidth(0);
        } else {
            this.setX(0);
            this.setY(n10);
            object = this.getParent();
            n10 = ((ConstraintWidget)object).getWidth();
            this.setWidth(n10);
            this.setHeight(0);
        }
    }
}

