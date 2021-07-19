/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;

public class GuidelineReference
implements Reference {
    private Object key;
    private int mEnd;
    private Guideline mGuidelineWidget;
    private int mOrientation;
    private float mPercent;
    private int mStart;
    public final State mState;

    public GuidelineReference(State state) {
        int n10;
        this.mStart = n10 = -1;
        this.mEnd = n10;
        this.mPercent = 0.0f;
        this.mState = state;
    }

    public void apply() {
        Guideline guideline = this.mGuidelineWidget;
        int n10 = this.mOrientation;
        guideline.setOrientation(n10);
        int n11 = this.mStart;
        n10 = -1;
        float f10 = 0.0f / 0.0f;
        if (n11 != n10) {
            Guideline guideline2 = this.mGuidelineWidget;
            guideline2.setGuideBegin(n11);
        } else {
            n11 = this.mEnd;
            if (n11 != n10) {
                Guideline guideline3 = this.mGuidelineWidget;
                guideline3.setGuideEnd(n11);
            } else {
                guideline = this.mGuidelineWidget;
                f10 = this.mPercent;
                guideline.setGuidePercent(f10);
            }
        }
    }

    public void end(Object object) {
        int n10;
        this.mStart = -1;
        this.mEnd = n10 = this.mState.convertDimension(object);
        this.mPercent = 0.0f;
    }

    public ConstraintWidget getConstraintWidget() {
        Guideline guideline = this.mGuidelineWidget;
        if (guideline == null) {
            this.mGuidelineWidget = guideline = new Guideline();
        }
        return this.mGuidelineWidget;
    }

    public Object getKey() {
        return this.key;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void percent(float f10) {
        int n10;
        this.mStart = n10 = -1;
        this.mEnd = n10;
        this.mPercent = f10;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        boolean bl2 = constraintWidget instanceof Guideline;
        if (bl2) {
            constraintWidget = (Guideline)constraintWidget;
            this.mGuidelineWidget = constraintWidget;
        } else {
            constraintWidget = null;
            this.mGuidelineWidget = null;
        }
    }

    public void setKey(Object object) {
        this.key = object;
    }

    public void setOrientation(int n10) {
        this.mOrientation = n10;
    }

    public void start(Object object) {
        int n10;
        this.mStart = n10 = this.mState.convertDimension(object);
        this.mEnd = -1;
        this.mPercent = 0.0f;
    }
}

