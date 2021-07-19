/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;

public class VirtualLayout
extends HelperWidget {
    public BasicMeasure$Measure mMeasure;
    private int mMeasuredHeight = 0;
    private int mMeasuredWidth = 0;
    public BasicMeasure$Measurer mMeasurer;
    private boolean mNeedsCallFromSolver = false;
    private int mPaddingBottom = 0;
    private int mPaddingEnd = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingStart = 0;
    private int mPaddingTop = 0;
    private int mResolvedPaddingLeft = 0;
    private int mResolvedPaddingRight = 0;

    public VirtualLayout() {
        BasicMeasure$Measure basicMeasure$Measure;
        this.mMeasure = basicMeasure$Measure = new BasicMeasure$Measure();
        this.mMeasurer = null;
    }

    public void applyRtl(boolean bl2) {
        int n10;
        int n11 = this.mPaddingStart;
        if (n11 > 0 || (n10 = this.mPaddingEnd) > 0) {
            if (bl2) {
                int n12;
                this.mResolvedPaddingLeft = n12 = this.mPaddingEnd;
                this.mResolvedPaddingRight = n11;
            } else {
                int n13;
                this.mResolvedPaddingLeft = n11;
                this.mResolvedPaddingRight = n13 = this.mPaddingEnd;
            }
        }
    }

    public void captureWidgets() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.mWidgetsCount); ++i10) {
            ConstraintWidget constraintWidget = this.mWidgets[i10];
            if (constraintWidget == null) continue;
            boolean bl2 = true;
            constraintWidget.setInVirtualLayout(bl2);
        }
    }

    public int getMeasuredHeight() {
        return this.mMeasuredHeight;
    }

    public int getMeasuredWidth() {
        return this.mMeasuredWidth;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mResolvedPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mResolvedPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public void measure(int n10, int n11, int n12, int n13) {
    }

    public void measure(ConstraintWidget constraintWidget, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour, int n10, ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2, int n11) {
        Object object;
        while ((object = this.mMeasurer) == null && (object = this.getParent()) != null) {
            this.mMeasurer = object = ((ConstraintWidgetContainer)this.getParent()).getMeasurer();
        }
        object = this.mMeasure;
        ((BasicMeasure$Measure)object).horizontalBehavior = constraintWidget$DimensionBehaviour;
        ((BasicMeasure$Measure)object).verticalBehavior = constraintWidget$DimensionBehaviour2;
        ((BasicMeasure$Measure)object).horizontalDimension = n10;
        ((BasicMeasure$Measure)object).verticalDimension = n11;
        this.mMeasurer.measure(constraintWidget, (BasicMeasure$Measure)object);
        int n12 = this.mMeasure.measuredWidth;
        constraintWidget.setWidth(n12);
        n12 = this.mMeasure.measuredHeight;
        constraintWidget.setHeight(n12);
        n12 = (int)(this.mMeasure.measuredHasBaseline ? 1 : 0);
        constraintWidget.setHasBaseline(n12 != 0);
        n12 = this.mMeasure.measuredBaseline;
        constraintWidget.setBaselineDistance(n12);
    }

    public boolean measureChildren() {
        int n10;
        Object object = this.mParent;
        object = object != null ? ((ConstraintWidgetContainer)object).getMeasurer() : null;
        if (object == null) {
            return false;
        }
        int n11 = 0;
        while (true) {
            int n12;
            int n13 = this.mWidgetsCount;
            n10 = 1;
            if (n11 >= n13) break;
            ConstraintWidget constraintWidget = this.mWidgets[n11];
            if (constraintWidget != null && (n12 = constraintWidget instanceof Guideline) == 0) {
                BasicMeasure$Measure basicMeasure$Measure;
                int n14;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = constraintWidget.getDimensionBehaviour(n10);
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (constraintWidget$DimensionBehaviour != constraintWidget$DimensionBehaviour3 || (n14 = constraintWidget.mMatchConstraintDefaultWidth) == n10 || constraintWidget$DimensionBehaviour2 != constraintWidget$DimensionBehaviour3 || (n14 = constraintWidget.mMatchConstraintDefaultHeight) == n10) {
                    n10 = 0;
                    basicMeasure$Measure = null;
                }
                if (n10 == 0) {
                    if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour3) {
                        constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    }
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                        constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    }
                    basicMeasure$Measure = this.mMeasure;
                    basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour;
                    basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour2;
                    basicMeasure$Measure.horizontalDimension = n12 = constraintWidget.getWidth();
                    basicMeasure$Measure = this.mMeasure;
                    basicMeasure$Measure.verticalDimension = n12 = constraintWidget.getHeight();
                    basicMeasure$Measure = this.mMeasure;
                    object.measure(constraintWidget, basicMeasure$Measure);
                    n10 = this.mMeasure.measuredWidth;
                    constraintWidget.setWidth(n10);
                    n10 = this.mMeasure.measuredHeight;
                    constraintWidget.setHeight(n10);
                    basicMeasure$Measure = this.mMeasure;
                    n10 = basicMeasure$Measure.measuredBaseline;
                    constraintWidget.setBaselineDistance(n10);
                }
            }
            ++n11;
        }
        return n10 != 0;
    }

    public boolean needSolverPass() {
        return this.mNeedsCallFromSolver;
    }

    public void needsCallbackFromSolver(boolean bl2) {
        this.mNeedsCallFromSolver = bl2;
    }

    public void setMeasure(int n10, int n11) {
        this.mMeasuredWidth = n10;
        this.mMeasuredHeight = n11;
    }

    public void setPadding(int n10) {
        this.mPaddingLeft = n10;
        this.mPaddingTop = n10;
        this.mPaddingRight = n10;
        this.mPaddingBottom = n10;
        this.mPaddingStart = n10;
        this.mPaddingEnd = n10;
    }

    public void setPaddingBottom(int n10) {
        this.mPaddingBottom = n10;
    }

    public void setPaddingEnd(int n10) {
        this.mPaddingEnd = n10;
    }

    public void setPaddingLeft(int n10) {
        this.mPaddingLeft = n10;
        this.mResolvedPaddingLeft = n10;
    }

    public void setPaddingRight(int n10) {
        this.mPaddingRight = n10;
        this.mResolvedPaddingRight = n10;
    }

    public void setPaddingStart(int n10) {
        this.mPaddingStart = n10;
        this.mResolvedPaddingLeft = n10;
        this.mResolvedPaddingRight = n10;
    }

    public void setPaddingTop(int n10) {
        this.mPaddingTop = n10;
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
        this.captureWidgets();
    }
}

