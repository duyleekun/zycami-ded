/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.HashMap;

public class Barrier
extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private boolean mAllowsGoneWidget = true;
    private int mBarrierType = 0;
    private int mMargin = 0;
    public boolean resolved = false;

    public Barrier() {
    }

    public Barrier(String string2) {
        this.setDebugName(string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void addToSolver(LinearSystem linearSystem, boolean n10) {
        int n11;
        ConstraintAnchor constraintAnchor;
        Object object;
        int n12;
        Object object2;
        int n13;
        int n14;
        ConstraintAnchor constraintAnchor2;
        int n15;
        int n16;
        int n17;
        int n18;
        block21: {
            ConstraintAnchor[] constraintAnchorArray;
            ConstraintAnchor constraintAnchor3;
            ConstraintAnchor[] constraintAnchorArray2 = this.mListAnchors;
            constraintAnchorArray2[0] = constraintAnchor3 = this.mLeft;
            ConstraintAnchor constraintAnchor4 = this.mTop;
            n18 = 2;
            constraintAnchorArray2[n18] = constraintAnchor4;
            ConstraintAnchor constraintAnchor5 = this.mRight;
            n17 = 1;
            constraintAnchorArray2[n17] = constraintAnchor5;
            ConstraintAnchor constraintAnchor6 = this.mBottom;
            n16 = 3;
            constraintAnchorArray2[n16] = constraintAnchor6;
            Object var3_4 = null;
            for (n10 = 0; n10 < (n15 = (constraintAnchorArray = this.mListAnchors).length); ++n10) {
                SolverVariable solverVariable;
                ConstraintAnchor constraintAnchor7 = constraintAnchorArray[n10];
                ConstraintAnchor constraintAnchor8 = constraintAnchorArray[n10];
                constraintAnchor7.mSolverVariable = solverVariable = linearSystem.createObjectVariable(constraintAnchor8);
            }
            n10 = this.mBarrierType;
            if (n10 < 0) return;
            n15 = 4;
            if (n10 >= n15) return;
            constraintAnchor2 = constraintAnchorArray[n10];
            n14 = this.resolved;
            if (!n14) {
                this.allSolved();
            }
            if (n14 = this.resolved) {
                this.resolved = false;
                n10 = this.mBarrierType;
                if (n10 != 0 && n10 != n17) {
                    if (n10 != n18) {
                        if (n10 != n16) return;
                    }
                    SolverVariable solverVariable = this.mTop.mSolverVariable;
                    n14 = this.mY;
                    linearSystem.addEquality(solverVariable, n14);
                    SolverVariable solverVariable2 = this.mBottom.mSolverVariable;
                    n14 = this.mY;
                    linearSystem.addEquality(solverVariable2, n14);
                    return;
                }
                SolverVariable solverVariable = this.mLeft.mSolverVariable;
                n14 = this.mX;
                linearSystem.addEquality(solverVariable, n14);
                SolverVariable solverVariable3 = this.mRight.mSolverVariable;
                n14 = this.mX;
                linearSystem.addEquality(solverVariable3, n14);
                return;
            }
            Object var4_30 = null;
            for (n14 = 0; n14 < (n13 = this.mWidgetsCount); n14 += 1) {
                ConstraintAnchor constraintAnchor9;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                ConstraintAnchor constraintAnchor10;
                ConstraintAnchor constraintAnchor11;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
                object2 = this.mWidgets[n14];
                n12 = this.mAllowsGoneWidget;
                if (n12 == 0 && (n12 = ((ConstraintWidget)object2).allowedInBarrier()) == 0 || ((n12 = this.mBarrierType) != 0 && n12 != n17 || (constraintWidget$DimensionBehaviour2 = ((ConstraintWidget)object2).getHorizontalDimensionBehaviour()) != (object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (constraintAnchor11 = object2.mLeft.mTarget) == null || (constraintAnchor10 = object2.mRight.mTarget) == null) && ((n12 = this.mBarrierType) != n18 && n12 != n16 || (constraintWidget$DimensionBehaviour = ((ConstraintWidget)object2).getVerticalDimensionBehaviour()) != (object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (constraintAnchor9 = object2.mTop.mTarget) == null || (object2 = object2.mBottom.mTarget) == null)) continue;
                n14 = n17;
                break block21;
            }
            n14 = 0;
            Object var4_31 = null;
        }
        object2 = this.mLeft;
        n13 = (int)(((ConstraintAnchor)object2).hasCenteredDependents() ? 1 : 0);
        if (n13 == 0 && (n13 = (int)(((ConstraintAnchor)(object2 = this.mRight)).hasCenteredDependents() ? 1 : 0)) == 0) {
            n13 = 0;
            object2 = null;
        } else {
            n13 = n17;
        }
        ConstraintAnchor constraintAnchor12 = this.mTop;
        n12 = (int)(constraintAnchor12.hasCenteredDependents() ? 1 : 0);
        if (n12 == 0 && (n12 = (int)((constraintAnchor = this.mBottom).hasCenteredDependents() ? 1 : 0)) == 0) {
            n12 = 0;
            Object var14_59 = null;
        } else {
            n12 = n17;
        }
        if (!n14 && ((n11 = this.mBarrierType) == 0 && n13 != 0 || n11 == n18 && n12 != 0 || n11 == n17 && n13 != 0 || n11 == n16 && n12 != 0)) {
            n13 = n17;
        } else {
            n13 = 0;
            object2 = null;
        }
        n12 = 5;
        if (n13 == 0) {
            n12 = n15;
        }
        object2 = null;
        for (n13 = 0; n13 < (n11 = this.mWidgetsCount); ++n13) {
            int n19;
            SolverVariable solverVariable;
            object = this.mWidgets[n13];
            boolean bl2 = this.mAllowsGoneWidget;
            if (!bl2 && !(bl2 = ((ConstraintWidget)object).allowedInBarrier())) continue;
            ConstraintAnchor[] constraintAnchorArray = ((ConstraintWidget)object).mListAnchors;
            int n20 = this.mBarrierType;
            ConstraintAnchor constraintAnchor13 = constraintAnchorArray[n20];
            SolverVariable solverVariable4 = linearSystem.createObjectVariable(constraintAnchor13);
            object = ((ConstraintWidget)object).mListAnchors;
            n20 = this.mBarrierType;
            ((ConstraintAnchor)object[n20]).mSolverVariable = solverVariable4;
            Object object3 = ((ConstraintAnchor)object[n20]).mTarget;
            if (object3 != null && (object3 = object[n20].mTarget.mOwner) == this) {
                object = object[n20];
                n11 = ((ConstraintAnchor)object).mMargin + 0;
            } else {
                n11 = 0;
                object = null;
            }
            if (n20 != 0 && n20 != n18) {
                solverVariable = constraintAnchor2.mSolverVariable;
                n19 = this.mMargin + n11;
                linearSystem.addGreaterBarrier(solverVariable, solverVariable4, n19, n14 != 0);
            } else {
                solverVariable = constraintAnchor2.mSolverVariable;
                n19 = this.mMargin - n11;
                linearSystem.addLowerBarrier(solverVariable, solverVariable4, n19, n14 != 0);
            }
            solverVariable = constraintAnchor2.mSolverVariable;
            n19 = this.mMargin + n11;
            linearSystem.addEquality(solverVariable, solverVariable4, n19, n12);
        }
        n10 = this.mBarrierType;
        n14 = 8;
        if (n10 == 0) {
            SolverVariable solverVariable = this.mRight.mSolverVariable;
            SolverVariable solverVariable5 = this.mLeft.mSolverVariable;
            linearSystem.addEquality(solverVariable, solverVariable5, 0, n14);
            SolverVariable solverVariable6 = this.mLeft.mSolverVariable;
            SolverVariable solverVariable7 = this.mParent.mRight.mSolverVariable;
            linearSystem.addEquality(solverVariable6, solverVariable7, 0, n15);
            SolverVariable solverVariable8 = this.mLeft.mSolverVariable;
            SolverVariable solverVariable9 = this.mParent.mLeft.mSolverVariable;
            linearSystem.addEquality(solverVariable8, solverVariable9, 0, 0);
            return;
        }
        if (n10 == n17) {
            SolverVariable solverVariable = this.mLeft.mSolverVariable;
            SolverVariable solverVariable10 = this.mRight.mSolverVariable;
            linearSystem.addEquality(solverVariable, solverVariable10, 0, n14);
            SolverVariable solverVariable11 = this.mLeft.mSolverVariable;
            SolverVariable solverVariable12 = this.mParent.mLeft.mSolverVariable;
            linearSystem.addEquality(solverVariable11, solverVariable12, 0, n15);
            SolverVariable solverVariable13 = this.mLeft.mSolverVariable;
            SolverVariable solverVariable14 = this.mParent.mRight.mSolverVariable;
            linearSystem.addEquality(solverVariable13, solverVariable14, 0, 0);
            return;
        }
        if (n10 == n18) {
            SolverVariable solverVariable = this.mBottom.mSolverVariable;
            SolverVariable solverVariable15 = this.mTop.mSolverVariable;
            linearSystem.addEquality(solverVariable, solverVariable15, 0, n14);
            SolverVariable solverVariable16 = this.mTop.mSolverVariable;
            SolverVariable solverVariable17 = this.mParent.mBottom.mSolverVariable;
            linearSystem.addEquality(solverVariable16, solverVariable17, 0, n15);
            SolverVariable solverVariable18 = this.mTop.mSolverVariable;
            SolverVariable solverVariable19 = this.mParent.mTop.mSolverVariable;
            linearSystem.addEquality(solverVariable18, solverVariable19, 0, 0);
            return;
        }
        if (n10 != n16) return;
        SolverVariable solverVariable = this.mTop.mSolverVariable;
        SolverVariable solverVariable20 = this.mBottom.mSolverVariable;
        linearSystem.addEquality(solverVariable, solverVariable20, 0, n14);
        SolverVariable solverVariable21 = this.mTop.mSolverVariable;
        SolverVariable solverVariable22 = this.mParent.mTop.mSolverVariable;
        linearSystem.addEquality(solverVariable21, solverVariable22, 0, n15);
        SolverVariable solverVariable23 = this.mTop.mSolverVariable;
        SolverVariable solverVariable24 = this.mParent.mBottom.mSolverVariable;
        linearSystem.addEquality(solverVariable23, solverVariable24, 0, 0);
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean allSolved() {
        int n10;
        Object object;
        int n11;
        int n12;
        int n13;
        int n14 = 0;
        int n15 = 1;
        int n16 = 0;
        Object object2 = null;
        int n17 = n15;
        while (true) {
            n13 = this.mWidgetsCount;
            n12 = 3;
            n11 = 2;
            if (n16 >= n13) break;
            object = this.mWidgets[n16];
            n10 = this.mAllowsGoneWidget;
            if (!(n10 == 0 && (n10 = ((ConstraintWidget)object).allowedInBarrier()) == 0 || ((n10 = this.mBarrierType) != 0 && n10 != n15 || (n10 = (int)(((ConstraintWidget)object).isResolvedHorizontally() ? 1 : 0)) != 0) && ((n10 = this.mBarrierType) != n11 && n10 != n12 || (n13 = (int)(((ConstraintWidget)object).isResolvedVertically() ? 1 : 0)) != 0))) {
                n17 = 0;
            }
            ++n16;
        }
        if (n17 != 0 && n13 > 0) {
            n16 = 0;
            object2 = null;
            n17 = 0;
        } else {
            return false;
        }
        while (n14 < (n13 = this.mWidgetsCount)) {
            object = this.mWidgets[n14];
            n10 = (int)(this.mAllowsGoneWidget ? 1 : 0);
            if (n10 != 0 || (n10 = (int)(((ConstraintWidget)object).allowedInBarrier() ? 1 : 0)) != 0) {
                ConstraintAnchor$Type constraintAnchor$Type;
                if (n17 == 0) {
                    n17 = this.mBarrierType;
                    if (n17 == 0) {
                        object2 = ConstraintAnchor$Type.LEFT;
                        object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                        n16 = ((ConstraintAnchor)object2).getFinalValue();
                    } else if (n17 == n15) {
                        object2 = ConstraintAnchor$Type.RIGHT;
                        object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                        n16 = ((ConstraintAnchor)object2).getFinalValue();
                    } else if (n17 == n11) {
                        object2 = ConstraintAnchor$Type.TOP;
                        object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                        n16 = ((ConstraintAnchor)object2).getFinalValue();
                    } else if (n17 == n12) {
                        object2 = ConstraintAnchor$Type.BOTTOM;
                        object2 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                        n16 = ((ConstraintAnchor)object2).getFinalValue();
                    }
                    n17 = n15;
                }
                if ((n10 = this.mBarrierType) == 0) {
                    constraintAnchor$Type = ConstraintAnchor$Type.LEFT;
                    object = ((ConstraintWidget)object).getAnchor(constraintAnchor$Type);
                    n13 = ((ConstraintAnchor)object).getFinalValue();
                    n16 = Math.min(n16, n13);
                } else if (n10 == n15) {
                    constraintAnchor$Type = ConstraintAnchor$Type.RIGHT;
                    object = ((ConstraintWidget)object).getAnchor(constraintAnchor$Type);
                    n13 = ((ConstraintAnchor)object).getFinalValue();
                    n16 = Math.max(n16, n13);
                } else if (n10 == n11) {
                    constraintAnchor$Type = ConstraintAnchor$Type.TOP;
                    object = ((ConstraintWidget)object).getAnchor(constraintAnchor$Type);
                    n13 = ((ConstraintAnchor)object).getFinalValue();
                    n16 = Math.min(n16, n13);
                } else if (n10 == n12) {
                    constraintAnchor$Type = ConstraintAnchor$Type.BOTTOM;
                    object = ((ConstraintWidget)object).getAnchor(constraintAnchor$Type);
                    n13 = ((ConstraintAnchor)object).getFinalValue();
                    n16 = Math.max(n16, n13);
                }
            }
            ++n14;
        }
        n14 = this.mMargin;
        n16 += n14;
        n14 = this.mBarrierType;
        if (n14 != 0 && n14 != n15) {
            this.setFinalVertical(n16, n16);
        } else {
            this.setFinalHorizontal(n16, n16);
        }
        this.resolved = n15;
        return n15 != 0;
    }

    public boolean allowedInBarrier() {
        return true;
    }

    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap hashMap) {
        int n10;
        int n11;
        super.copy(constraintWidget, hashMap);
        constraintWidget = (Barrier)constraintWidget;
        this.mBarrierType = n11 = ((Barrier)constraintWidget).mBarrierType;
        n11 = (int)(((Barrier)constraintWidget).mAllowsGoneWidget ? 1 : 0);
        this.mAllowsGoneWidget = n11;
        this.mMargin = n10 = ((Barrier)constraintWidget).mMargin;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int n10;
        int n11 = this.mBarrierType;
        if (n11 != 0 && n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 != n12 && n11 != (n12 = 3)) {
                return -1;
            }
            return n10;
        }
        return 0;
    }

    public boolean isResolvedHorizontally() {
        return this.resolved;
    }

    public boolean isResolvedVertically() {
        return this.resolved;
    }

    public void markWidgets() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.mWidgetsCount); ++i10) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            boolean bl2 = this.mBarrierType;
            boolean bl3 = true;
            if (bl2 && bl2 != bl3) {
                boolean bl4 = 2 != 0;
                if (bl2 != bl4 && bl2 != (bl4 = 3 != 0)) continue;
                constraintWidget.setInBarrier((int)(bl3 ? 1 : 0), bl3);
                continue;
            }
            constraintWidget.setInBarrier(0, bl3);
        }
    }

    public void setAllowsGoneWidget(boolean bl2) {
        this.mAllowsGoneWidget = bl2;
    }

    public void setBarrierType(int n10) {
        this.mBarrierType = n10;
    }

    public void setMargin(int n10) {
        this.mMargin = n10;
    }

    public String toString() {
        int n10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[Barrier] ");
        CharSequence charSequence2 = this.getDebugName();
        charSequence.append((String)charSequence2);
        charSequence.append(" {");
        charSequence = charSequence.toString();
        charSequence2 = null;
        for (int i10 = 0; i10 < (n10 = this.mWidgetsCount); ++i10) {
            StringBuilder stringBuilder;
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (i10 > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append((String)charSequence);
                stringBuilder.append(", ");
                charSequence = stringBuilder.toString();
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            charSequence = constraintWidget.getDebugName();
            stringBuilder.append((String)charSequence);
            charSequence = stringBuilder.toString();
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append("}");
        return ((StringBuilder)charSequence2).toString();
    }
}

