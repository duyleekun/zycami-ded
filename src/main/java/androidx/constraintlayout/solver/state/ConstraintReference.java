/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference$1;
import androidx.constraintlayout.solver.state.ConstraintReference$IncorrectConstraintException;
import androidx.constraintlayout.solver.state.Dimension;
import androidx.constraintlayout.solver.state.Reference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.State$Constraint;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

public class ConstraintReference
implements Reference {
    private Object key;
    public Object mBaselineToBaseline;
    public Object mBottomToBottom;
    public Object mBottomToTop;
    private ConstraintWidget mConstraintWidget;
    public Object mEndToEnd;
    public Object mEndToStart;
    public float mHorizontalBias;
    public int mHorizontalChainStyle = 0;
    public Dimension mHorizontalDimension;
    public State$Constraint mLast;
    public Object mLeftToLeft;
    public Object mLeftToRight;
    public int mMarginBottom;
    public int mMarginBottomGone;
    public int mMarginEnd;
    public int mMarginEndGone;
    public int mMarginLeft;
    public int mMarginLeftGone;
    public int mMarginRight;
    public int mMarginRightGone;
    public int mMarginStart;
    public int mMarginStartGone;
    public int mMarginTop;
    public int mMarginTopGone;
    public Object mRightToLeft;
    public Object mRightToRight;
    public Object mStartToEnd;
    public Object mStartToStart;
    public final State mState;
    public Object mTopToBottom;
    public Object mTopToTop;
    public float mVerticalBias;
    public int mVerticalChainStyle = 0;
    public Dimension mVerticalDimension;
    private Object mView;

    public ConstraintReference(State state) {
        Dimension dimension;
        float f10;
        this.mHorizontalBias = f10 = 0.5f;
        this.mVerticalBias = f10;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mMarginStart = 0;
        this.mMarginEnd = 0;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mMarginLeftGone = 0;
        this.mMarginRightGone = 0;
        this.mMarginStartGone = 0;
        this.mMarginEndGone = 0;
        this.mMarginTopGone = 0;
        this.mMarginBottomGone = 0;
        this.mLeftToLeft = null;
        this.mLeftToRight = null;
        this.mRightToLeft = null;
        this.mRightToRight = null;
        this.mStartToStart = null;
        this.mStartToEnd = null;
        this.mEndToStart = null;
        this.mEndToEnd = null;
        this.mTopToTop = null;
        this.mTopToBottom = null;
        this.mBottomToTop = null;
        this.mBottomToBottom = null;
        this.mBaselineToBaseline = null;
        this.mLast = null;
        Object object = Dimension.WRAP_DIMENSION;
        this.mHorizontalDimension = dimension = Dimension.Fixed(object);
        this.mVerticalDimension = object = Dimension.Fixed(object);
        this.mState = state;
    }

    private void applyConnection(ConstraintWidget object, Object object2, State$Constraint state$Constraint) {
        ConstraintWidget constraintWidget = this.getTarget(object2);
        if (constraintWidget == null) {
            return;
        }
        object2 = ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        Object object3 = state$Constraint.ordinal();
        object3 = object2[object3];
        int n10 = state$Constraint.ordinal();
        Object object4 = object2[n10];
        n10 = 0;
        state$Constraint = null;
        switch (object4) {
            default: {
                break;
            }
            case 13: {
                ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.BASELINE;
                ((ConstraintWidget)object).immediateConnect(constraintAnchor$Type, constraintWidget, constraintAnchor$Type, 0, 0);
                break;
            }
            case 12: {
                object2 = ConstraintAnchor$Type.BOTTOM;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginBottom;
                int n11 = this.mMarginBottomGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n11, false);
                break;
            }
            case 11: {
                object2 = ConstraintAnchor$Type.BOTTOM;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.TOP;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginBottom;
                int n12 = this.mMarginBottomGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n12, false);
                break;
            }
            case 10: {
                object2 = ConstraintAnchor$Type.TOP;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.BOTTOM;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginTop;
                int n13 = this.mMarginTopGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n13, false);
                break;
            }
            case 9: {
                object2 = ConstraintAnchor$Type.TOP;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginTop;
                int n14 = this.mMarginTopGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n14, false);
                break;
            }
            case 8: {
                object2 = ConstraintAnchor$Type.RIGHT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginEnd;
                int n15 = this.mMarginEndGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n15, false);
                break;
            }
            case 7: {
                object2 = ConstraintAnchor$Type.RIGHT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.LEFT;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginEnd;
                int n16 = this.mMarginEndGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n16, false);
                break;
            }
            case 6: {
                object2 = ConstraintAnchor$Type.LEFT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.RIGHT;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginStart;
                int n17 = this.mMarginStartGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n17, false);
                break;
            }
            case 5: {
                object2 = ConstraintAnchor$Type.LEFT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginStart;
                int n18 = this.mMarginStartGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n18, false);
                break;
            }
            case 4: {
                object2 = ConstraintAnchor$Type.RIGHT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginRight;
                int n19 = this.mMarginRightGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n19, false);
                break;
            }
            case 3: {
                object2 = ConstraintAnchor$Type.RIGHT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.LEFT;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginRight;
                int n20 = this.mMarginRightGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n20, false);
                break;
            }
            case 2: {
                object2 = ConstraintAnchor$Type.LEFT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = ConstraintAnchor$Type.RIGHT;
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginLeft;
                int n21 = this.mMarginLeftGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n21, false);
                break;
            }
            case 1: {
                object2 = ConstraintAnchor$Type.LEFT;
                object = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object2));
                object2 = constraintWidget.getAnchor((ConstraintAnchor$Type)((Object)object2));
                object3 = this.mMarginLeft;
                int n22 = this.mMarginLeftGone;
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, (int)object3, n22, false);
            }
        }
    }

    private void dereference() {
        Object object = this.mLeftToLeft;
        this.mLeftToLeft = object = this.get(object);
        object = this.mLeftToRight;
        this.mLeftToRight = object = this.get(object);
        object = this.mRightToLeft;
        this.mRightToLeft = object = this.get(object);
        object = this.mRightToRight;
        this.mRightToRight = object = this.get(object);
        object = this.mStartToStart;
        this.mStartToStart = object = this.get(object);
        object = this.mStartToEnd;
        this.mStartToEnd = object = this.get(object);
        object = this.mEndToStart;
        this.mEndToStart = object = this.get(object);
        object = this.mEndToEnd;
        this.mEndToEnd = object = this.get(object);
        object = this.mTopToTop;
        this.mTopToTop = object = this.get(object);
        object = this.mTopToBottom;
        this.mTopToBottom = object = this.get(object);
        object = this.mBottomToTop;
        this.mBottomToTop = object = this.get(object);
        object = this.mBottomToBottom;
        this.mBottomToBottom = object = this.get(object);
        object = this.mBaselineToBaseline;
        this.mBaselineToBaseline = object = this.get(object);
    }

    private Object get(Object object) {
        if (object == null) {
            return null;
        }
        boolean bl2 = object instanceof ConstraintReference;
        if (!bl2) {
            State state = this.mState;
            object = state.reference(object);
        }
        return object;
    }

    private ConstraintWidget getTarget(Object object) {
        boolean bl2 = object instanceof Reference;
        if (bl2) {
            return ((Reference)object).getConstraintWidget();
        }
        return null;
    }

    public void apply() {
        Object object = this.mConstraintWidget;
        if (object == null) {
            return;
        }
        Object object2 = this.mHorizontalDimension;
        Object object3 = this.mState;
        ((Dimension)object2).apply((State)object3, (ConstraintWidget)object, 0);
        object = this.mVerticalDimension;
        object2 = this.mState;
        object3 = this.mConstraintWidget;
        int n10 = 1;
        ((Dimension)object).apply((State)object2, (ConstraintWidget)object3, n10);
        this.dereference();
        object = this.mConstraintWidget;
        object2 = this.mLeftToLeft;
        object3 = State$Constraint.LEFT_TO_LEFT;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mLeftToRight;
        object3 = State$Constraint.LEFT_TO_RIGHT;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mRightToLeft;
        object3 = State$Constraint.RIGHT_TO_LEFT;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mRightToRight;
        object3 = State$Constraint.RIGHT_TO_RIGHT;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mStartToStart;
        object3 = State$Constraint.START_TO_START;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mStartToEnd;
        object3 = State$Constraint.START_TO_END;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mEndToStart;
        object3 = State$Constraint.END_TO_START;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mEndToEnd;
        object3 = State$Constraint.END_TO_END;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mTopToTop;
        object3 = State$Constraint.TOP_TO_TOP;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mTopToBottom;
        object3 = State$Constraint.TOP_TO_BOTTOM;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mBottomToTop;
        object3 = State$Constraint.BOTTOM_TO_TOP;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mBottomToBottom;
        object3 = State$Constraint.BOTTOM_TO_BOTTOM;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        object = this.mConstraintWidget;
        object2 = this.mBaselineToBaseline;
        object3 = State$Constraint.BASELINE_TO_BASELINE;
        this.applyConnection((ConstraintWidget)object, object2, (State$Constraint)((Object)object3));
        int n11 = this.mHorizontalChainStyle;
        if (n11 != 0) {
            object2 = this.mConstraintWidget;
            ((ConstraintWidget)object2).setHorizontalChainStyle(n11);
        }
        if ((n11 = this.mVerticalChainStyle) != 0) {
            object2 = this.mConstraintWidget;
            ((ConstraintWidget)object2).setVerticalChainStyle(n11);
        }
        object = this.mConstraintWidget;
        float f10 = this.mHorizontalBias;
        ((ConstraintWidget)object).setHorizontalBiasPercent(f10);
        object = this.mConstraintWidget;
        f10 = this.mVerticalBias;
        ((ConstraintWidget)object).setVerticalBiasPercent(f10);
    }

    public ConstraintReference baseline() {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.BASELINE_TO_BASELINE;
        return this;
    }

    public ConstraintReference baselineToBaseline(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.BASELINE_TO_BASELINE;
        this.mBaselineToBaseline = object;
        return this;
    }

    public ConstraintReference bias(float f10) {
        State$Constraint state$Constraint = this.mLast;
        if (state$Constraint == null) {
            return this;
        }
        int[] nArray = ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
        int n10 = state$Constraint.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                break;
            }
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 15: {
                this.mVerticalBias = f10;
                break;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 14: {
                this.mHorizontalBias = f10;
            }
        }
        return this;
    }

    public ConstraintReference bottom() {
        Object object = this.mBottomToTop;
        if (object != null) {
            object = State$Constraint.BOTTOM_TO_TOP;
            this.mLast = object;
        } else {
            object = State$Constraint.BOTTOM_TO_BOTTOM;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference bottomToBottom(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.BOTTOM_TO_BOTTOM;
        this.mBottomToBottom = object;
        return this;
    }

    public ConstraintReference bottomToTop(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.BOTTOM_TO_TOP;
        this.mBottomToTop = object;
        return this;
    }

    public ConstraintReference centerHorizontally(Object object) {
        this.mStartToStart = object = this.get(object);
        this.mEndToEnd = object;
        object = State$Constraint.CENTER_HORIZONTALLY;
        this.mLast = object;
        this.mHorizontalBias = 0.5f;
        return this;
    }

    public ConstraintReference centerVertically(Object object) {
        this.mTopToTop = object = this.get(object);
        this.mBottomToBottom = object;
        object = State$Constraint.CENTER_VERTICALLY;
        this.mLast = object;
        this.mVerticalBias = 0.5f;
        return this;
    }

    public ConstraintReference clear() {
        State$Constraint state$Constraint = this.mLast;
        if (state$Constraint != null) {
            int[] nArray = ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            int n10 = state$Constraint.ordinal();
            n10 = nArray[n10];
            switch (n10) {
                default: {
                    break;
                }
                case 13: {
                    this.mBaselineToBaseline = null;
                    break;
                }
                case 11: 
                case 12: {
                    this.mBottomToTop = null;
                    this.mBottomToBottom = null;
                    this.mMarginBottom = 0;
                    this.mMarginBottomGone = 0;
                    break;
                }
                case 9: 
                case 10: {
                    this.mTopToTop = null;
                    this.mTopToBottom = null;
                    this.mMarginTop = 0;
                    this.mMarginTopGone = 0;
                    break;
                }
                case 7: 
                case 8: {
                    this.mEndToStart = null;
                    this.mEndToEnd = null;
                    this.mMarginEnd = 0;
                    this.mMarginEndGone = 0;
                    break;
                }
                case 5: 
                case 6: {
                    this.mStartToStart = null;
                    this.mStartToEnd = null;
                    this.mMarginStart = 0;
                    this.mMarginStartGone = 0;
                    break;
                }
                case 3: 
                case 4: {
                    this.mRightToLeft = null;
                    this.mRightToRight = null;
                    this.mMarginRight = 0;
                    this.mMarginRightGone = 0;
                    break;
                }
                case 1: 
                case 2: {
                    this.mLeftToLeft = null;
                    this.mLeftToRight = null;
                    this.mMarginLeft = 0;
                    this.mMarginLeftGone = 0;
                    break;
                }
            }
        } else {
            float f10;
            this.mLeftToLeft = null;
            this.mLeftToRight = null;
            this.mMarginLeft = 0;
            this.mRightToLeft = null;
            this.mRightToRight = null;
            this.mMarginRight = 0;
            this.mStartToStart = null;
            this.mStartToEnd = null;
            this.mMarginStart = 0;
            this.mEndToStart = null;
            this.mEndToEnd = null;
            this.mMarginEnd = 0;
            this.mTopToTop = null;
            this.mTopToBottom = null;
            this.mMarginTop = 0;
            this.mBottomToTop = null;
            this.mBottomToBottom = null;
            this.mMarginBottom = 0;
            this.mBaselineToBaseline = null;
            int n11 = 0x3F000000;
            this.mHorizontalBias = f10 = 0.5f;
            this.mVerticalBias = f10;
            this.mMarginLeftGone = 0;
            this.mMarginRightGone = 0;
            this.mMarginStartGone = 0;
            this.mMarginEndGone = 0;
            this.mMarginTopGone = 0;
            this.mMarginBottomGone = 0;
        }
        return this;
    }

    public ConstraintReference clearHorizontal() {
        this.start().clear();
        this.end().clear();
        this.left().clear();
        this.right().clear();
        return this;
    }

    public ConstraintReference clearVertical() {
        this.top().clear();
        this.baseline().clear();
        this.bottom().clear();
        return this;
    }

    public ConstraintWidget createConstraintWidget() {
        int n10 = this.getWidth().getValue();
        int n11 = this.getHeight().getValue();
        ConstraintWidget constraintWidget = new ConstraintWidget(n10, n11);
        return constraintWidget;
    }

    public ConstraintReference end() {
        Object object = this.mEndToStart;
        if (object != null) {
            object = State$Constraint.END_TO_START;
            this.mLast = object;
        } else {
            object = State$Constraint.END_TO_END;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference endToEnd(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.END_TO_END;
        this.mEndToEnd = object;
        return this;
    }

    public ConstraintReference endToStart(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.END_TO_START;
        this.mEndToStart = object;
        return this;
    }

    public ConstraintWidget getConstraintWidget() {
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget == null) {
            this.mConstraintWidget = constraintWidget = this.createConstraintWidget();
            Object object = this.mView;
            constraintWidget.setCompanionWidget(object);
        }
        return this.mConstraintWidget;
    }

    public Dimension getHeight() {
        return this.mVerticalDimension;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public Object getKey() {
        return this.key;
    }

    public int getVerticalChainStyle(int n10) {
        return this.mVerticalChainStyle;
    }

    public Object getView() {
        return this.mView;
    }

    public Dimension getWidth() {
        return this.mHorizontalDimension;
    }

    public ConstraintReference height(Dimension dimension) {
        return this.setHeight(dimension);
    }

    public ConstraintReference horizontalBias(float f10) {
        this.mHorizontalBias = f10;
        return this;
    }

    public ConstraintReference left() {
        Object object = this.mLeftToLeft;
        if (object != null) {
            object = State$Constraint.LEFT_TO_LEFT;
            this.mLast = object;
        } else {
            object = State$Constraint.LEFT_TO_RIGHT;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference leftToLeft(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.LEFT_TO_LEFT;
        this.mLeftToLeft = object;
        return this;
    }

    public ConstraintReference leftToRight(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.LEFT_TO_RIGHT;
        this.mLeftToRight = object;
        return this;
    }

    public ConstraintReference margin(int n10) {
        State$Constraint state$Constraint = this.mLast;
        if (state$Constraint != null) {
            int[] nArray = ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            int n11 = state$Constraint.ordinal();
            n11 = nArray[n11];
            switch (n11) {
                default: {
                    break;
                }
                case 11: 
                case 12: {
                    this.mMarginBottom = n10;
                    break;
                }
                case 9: 
                case 10: {
                    this.mMarginTop = n10;
                    break;
                }
                case 7: 
                case 8: {
                    this.mMarginEnd = n10;
                    break;
                }
                case 5: 
                case 6: {
                    this.mMarginStart = n10;
                    break;
                }
                case 3: 
                case 4: {
                    this.mMarginRight = n10;
                    break;
                }
                case 1: 
                case 2: {
                    this.mMarginLeft = n10;
                    break;
                }
            }
        } else {
            this.mMarginLeft = n10;
            this.mMarginRight = n10;
            this.mMarginStart = n10;
            this.mMarginEnd = n10;
            this.mMarginTop = n10;
            this.mMarginBottom = n10;
        }
        return this;
    }

    public ConstraintReference margin(Object object) {
        int n10 = this.mState.convertDimension(object);
        return this.margin(n10);
    }

    public ConstraintReference marginGone(int n10) {
        State$Constraint state$Constraint = this.mLast;
        if (state$Constraint != null) {
            int[] nArray = ConstraintReference$1.$SwitchMap$androidx$constraintlayout$solver$state$State$Constraint;
            int n11 = state$Constraint.ordinal();
            n11 = nArray[n11];
            switch (n11) {
                default: {
                    break;
                }
                case 11: 
                case 12: {
                    this.mMarginBottomGone = n10;
                    break;
                }
                case 9: 
                case 10: {
                    this.mMarginTopGone = n10;
                    break;
                }
                case 7: 
                case 8: {
                    this.mMarginEndGone = n10;
                    break;
                }
                case 5: 
                case 6: {
                    this.mMarginStartGone = n10;
                    break;
                }
                case 3: 
                case 4: {
                    this.mMarginRightGone = n10;
                    break;
                }
                case 1: 
                case 2: {
                    this.mMarginLeftGone = n10;
                    break;
                }
            }
        } else {
            this.mMarginLeftGone = n10;
            this.mMarginRightGone = n10;
            this.mMarginStartGone = n10;
            this.mMarginEndGone = n10;
            this.mMarginTopGone = n10;
            this.mMarginBottomGone = n10;
        }
        return this;
    }

    public ConstraintReference right() {
        Object object = this.mRightToLeft;
        if (object != null) {
            object = State$Constraint.RIGHT_TO_LEFT;
            this.mLast = object;
        } else {
            object = State$Constraint.RIGHT_TO_RIGHT;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference rightToLeft(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.RIGHT_TO_LEFT;
        this.mRightToLeft = object;
        return this;
    }

    public ConstraintReference rightToRight(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.RIGHT_TO_RIGHT;
        this.mRightToRight = object;
        return this;
    }

    public void setConstraintWidget(ConstraintWidget constraintWidget) {
        if (constraintWidget == null) {
            return;
        }
        this.mConstraintWidget = constraintWidget;
        Object object = this.mView;
        constraintWidget.setCompanionWidget(object);
    }

    public ConstraintReference setHeight(Dimension dimension) {
        this.mVerticalDimension = dimension;
        return this;
    }

    public void setHorizontalChainStyle(int n10) {
        this.mHorizontalChainStyle = n10;
    }

    public void setKey(Object object) {
        this.key = object;
    }

    public void setVerticalChainStyle(int n10) {
        this.mVerticalChainStyle = n10;
    }

    public void setView(Object object) {
        this.mView = object;
        ConstraintWidget constraintWidget = this.mConstraintWidget;
        if (constraintWidget != null) {
            constraintWidget.setCompanionWidget(object);
        }
    }

    public ConstraintReference setWidth(Dimension dimension) {
        this.mHorizontalDimension = dimension;
        return this;
    }

    public ConstraintReference start() {
        Object object = this.mStartToStart;
        if (object != null) {
            object = State$Constraint.START_TO_START;
            this.mLast = object;
        } else {
            object = State$Constraint.START_TO_END;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference startToEnd(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.START_TO_END;
        this.mStartToEnd = object;
        return this;
    }

    public ConstraintReference startToStart(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.START_TO_START;
        this.mStartToStart = object;
        return this;
    }

    public ConstraintReference top() {
        Object object = this.mTopToTop;
        if (object != null) {
            object = State$Constraint.TOP_TO_TOP;
            this.mLast = object;
        } else {
            object = State$Constraint.TOP_TO_BOTTOM;
            this.mLast = object;
        }
        return this;
    }

    public ConstraintReference topToBottom(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.TOP_TO_BOTTOM;
        this.mTopToBottom = object;
        return this;
    }

    public ConstraintReference topToTop(Object object) {
        State$Constraint state$Constraint;
        this.mLast = state$Constraint = State$Constraint.TOP_TO_TOP;
        this.mTopToTop = object;
        return this;
    }

    public void validate() {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object = this.mLeftToLeft;
        if (object != null && (object = this.mLeftToRight) != null) {
            object = "LeftToLeft and LeftToRight both defined";
            arrayList.add(object);
        }
        if ((object = this.mRightToLeft) != null && (object = this.mRightToRight) != null) {
            object = "RightToLeft and RightToRight both defined";
            arrayList.add(object);
        }
        if ((object = this.mStartToStart) != null && (object = this.mStartToEnd) != null) {
            object = "StartToStart and StartToEnd both defined";
            arrayList.add(object);
        }
        if ((object = this.mEndToStart) != null && (object = this.mEndToEnd) != null) {
            object = "EndToStart and EndToEnd both defined";
            arrayList.add(object);
        }
        if (!((object = this.mLeftToLeft) == null && (object = this.mLeftToRight) == null && (object = this.mRightToLeft) == null && (object = this.mRightToRight) == null || (object = this.mStartToStart) == null && (object = this.mStartToEnd) == null && (object = this.mEndToStart) == null && (object = this.mEndToEnd) == null)) {
            object = "Both left/right and start/end constraints defined";
            arrayList.add(object);
        }
        if ((n10 = arrayList.size()) <= 0) {
            return;
        }
        object = new ConstraintReference$IncorrectConstraintException(this, arrayList);
        throw object;
    }

    public ConstraintReference verticalBias(float f10) {
        this.mVerticalBias = f10;
        return this;
    }

    public ConstraintReference width(Dimension dimension) {
        return this.setWidth(dimension);
    }
}

