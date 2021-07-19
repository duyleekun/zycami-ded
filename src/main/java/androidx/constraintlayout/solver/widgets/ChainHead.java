/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import java.util.ArrayList;

public class ChainHead {
    private boolean mDefined;
    public ConstraintWidget mFirst;
    public ConstraintWidget mFirstMatchConstraintWidget;
    public ConstraintWidget mFirstVisibleWidget;
    public boolean mHasComplexMatchWeights;
    public boolean mHasDefinedWeights;
    public boolean mHasRatio;
    public boolean mHasUndefinedWeights;
    public ConstraintWidget mHead;
    private boolean mIsRtl = false;
    public ConstraintWidget mLast;
    public ConstraintWidget mLastMatchConstraintWidget;
    public ConstraintWidget mLastVisibleWidget;
    public boolean mOptimizable;
    private int mOrientation;
    public int mTotalMargins;
    public int mTotalSize;
    public float mTotalWeight = 0.0f;
    public int mVisibleWidgets;
    public ArrayList mWeightedMatchConstraintsWidgets;
    public int mWidgetsCount;
    public int mWidgetsMatchCount;

    public ChainHead(ConstraintWidget constraintWidget, int n10, boolean bl2) {
        this.mFirst = constraintWidget;
        this.mOrientation = n10;
        this.mIsRtl = bl2;
    }

    private void defineChainProperties() {
        Object object;
        int n10;
        int n11 = this.mOrientation;
        Object object2 = 2;
        n11 *= object2;
        ConstraintWidget[] constraintWidgetArray = this.mFirst;
        int n12 = 1;
        this.mOptimizable = n12;
        Object object3 = constraintWidgetArray;
        int n13 = 0;
        while (n13 == 0) {
            Object object4;
            Object object5;
            Object object6;
            Object object7;
            block32: {
                reference var18_18;
                block34: {
                    float f10;
                    Object object8;
                    int n14;
                    float f11;
                    Object object9;
                    block33: {
                        this.mWidgetsCount = object7 = this.mWidgetsCount + n12;
                        object6 = constraintWidgetArray.mNextChainWidget;
                        object9 = this.mOrientation;
                        object5 = null;
                        object6[object9] = null;
                        object6 = constraintWidgetArray.mListNextMatchConstraintsWidget;
                        object6[object9] = null;
                        object7 = constraintWidgetArray.getVisibility();
                        object9 = 8;
                        f11 = 1.1E-44f;
                        if (object7 == object9) break block32;
                        this.mVisibleWidgets = object7 = this.mVisibleWidgets + n12;
                        object7 = this.mOrientation;
                        object6 = constraintWidgetArray.getDimensionBehaviour((int)object7);
                        if (object6 != (object4 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                            object7 = this.mTotalSize;
                            n14 = this.mOrientation;
                            n14 = constraintWidgetArray.getLength(n14);
                            this.mTotalSize = object7 += n14;
                        }
                        object7 = this.mTotalSize;
                        n14 = constraintWidgetArray.mListAnchors[n11].getMargin();
                        this.mTotalSize = object7 += n14;
                        Object object10 = constraintWidgetArray.mListAnchors;
                        int n15 = n11 + 1;
                        n14 = object10[n15].getMargin();
                        this.mTotalSize = object7 += n14;
                        object7 = this.mTotalMargins;
                        n14 = constraintWidgetArray.mListAnchors[n11].getMargin();
                        this.mTotalMargins = object7 += n14;
                        object10 = constraintWidgetArray.mListAnchors[n15];
                        n14 = ((ConstraintAnchor)object10).getMargin();
                        this.mTotalMargins = object7 += n14;
                        object6 = this.mFirstVisibleWidget;
                        if (object6 == null) {
                            this.mFirstVisibleWidget = constraintWidgetArray;
                        }
                        this.mLastVisibleWidget = constraintWidgetArray;
                        object6 = constraintWidgetArray.mListDimensionBehaviors;
                        n14 = this.mOrientation;
                        if ((object6 = object6[n14]) != object4) break block32;
                        object6 = constraintWidgetArray.mResolvedMatchConstraintDefault;
                        object9 = object6[n14];
                        n15 = 0;
                        if (object9 == 0) break block33;
                        object9 = object6[n14];
                        object8 = 3;
                        f10 = 4.2E-45f;
                        if (object9 != object8 && (object7 = (Object)object6[n14]) != object2) break block34;
                    }
                    this.mWidgetsMatchCount = object7 = this.mWidgetsMatchCount + n12;
                    object6 = constraintWidgetArray.mWeight;
                    f11 = (float)object6[n14];
                    float f12 = f11 - 0.0f;
                    object8 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                    if (object8 > 0) {
                        f10 = this.mTotalWeight;
                        var18_18 = object6[n14];
                        this.mTotalWeight = f10 += var18_18;
                    }
                    if ((object7 = (Object)ChainHead.isMatchConstraintEqualityCandidate((ConstraintWidget)constraintWidgetArray, n14)) != 0) {
                        float f13 = f11 - 0.0f;
                        object7 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
                        if (object7 < 0) {
                            this.mHasUndefinedWeights = n12;
                        } else {
                            this.mHasDefinedWeights = n12;
                        }
                        object6 = this.mWeightedMatchConstraintsWidgets;
                        if (object6 == null) {
                            object6 = new ArrayList();
                            this.mWeightedMatchConstraintsWidgets = object6;
                        }
                        object6 = this.mWeightedMatchConstraintsWidgets;
                        object6.add(constraintWidgetArray);
                    }
                    if ((object6 = this.mFirstMatchConstraintWidget) == null) {
                        this.mFirstMatchConstraintWidget = constraintWidgetArray;
                    }
                    if ((object6 = this.mLastMatchConstraintWidget) != null) {
                        object6 = object6.mListNextMatchConstraintsWidget;
                        object9 = this.mOrientation;
                        object6[object9] = constraintWidgetArray;
                    }
                    this.mLastMatchConstraintWidget = constraintWidgetArray;
                }
                if ((object7 = this.mOrientation) == 0) {
                    object7 = constraintWidgetArray.mMatchConstraintDefaultWidth;
                    if (object7 != 0) {
                        this.mOptimizable = false;
                    } else {
                        object7 = constraintWidgetArray.mMatchConstraintMinWidth;
                        if (object7 != 0 || (object7 = constraintWidgetArray.mMatchConstraintMaxWidth) != 0) {
                            this.mOptimizable = false;
                        }
                    }
                } else {
                    object7 = constraintWidgetArray.mMatchConstraintDefaultHeight;
                    if (object7 != 0) {
                        this.mOptimizable = false;
                    } else {
                        object7 = constraintWidgetArray.mMatchConstraintMinHeight;
                        if (object7 != 0 || (object7 = constraintWidgetArray.mMatchConstraintMaxHeight) != 0) {
                            this.mOptimizable = false;
                        }
                    }
                }
                var18_18 = (reference)constraintWidgetArray.mDimensionRatio;
                reference cfr_temp_2 = var18_18 - 0.0f;
                object7 = cfr_temp_2 == 0 ? 0 : (cfr_temp_2 > 0 ? 1 : -1);
                if (object7 != 0) {
                    this.mOptimizable = false;
                    this.mHasRatio = n12;
                }
            }
            if (object3 != constraintWidgetArray) {
                object3 = object3.mNextChainWidget;
                object7 = this.mOrientation;
                object3[object7] = constraintWidgetArray;
            }
            object3 = constraintWidgetArray.mListAnchors;
            object7 = n11 + 1;
            object3 = ((ConstraintAnchor)object3[object7]).mTarget;
            if (object3 != null) {
                object3 = object3.mOwner;
                object6 = object3.mListAnchors;
                object4 = ((ConstraintAnchor)object6[n11]).mTarget;
                if (object4 != null && (object6 = object6[n11].mTarget.mOwner) == constraintWidgetArray) {
                    object5 = object3;
                }
            }
            if (object5 == null) {
                object5 = constraintWidgetArray;
                n13 = n12;
            }
            object3 = constraintWidgetArray;
            constraintWidgetArray = object5;
        }
        Object object11 = this.mFirstVisibleWidget;
        if (object11 != null) {
            n10 = this.mTotalSize;
            object11 = object11.mListAnchors[n11];
            object2 = object11.getMargin();
            this.mTotalSize = n10 -= object2;
        }
        if ((object11 = this.mLastVisibleWidget) != null) {
            n10 = this.mTotalSize;
            object11 = object11.mListAnchors;
            object = object11[n11 += n12];
            n11 = ((ConstraintAnchor)object).getMargin();
            this.mTotalSize = n10 -= n11;
        }
        this.mLast = constraintWidgetArray;
        n11 = this.mOrientation;
        if (n11 == 0 && (n11 = (int)(this.mIsRtl ? 1 : 0)) != 0) {
            this.mHead = constraintWidgetArray;
        } else {
            object = this.mFirst;
            this.mHead = object;
        }
        n11 = this.mHasDefinedWeights ? 1 : 0;
        if (n11 == 0 || (n11 = (int)(this.mHasUndefinedWeights ? 1 : 0)) == 0) {
            n12 = 0;
        }
        this.mHasComplexMatchWeights = n12;
    }

    private static boolean isMatchConstraintEqualityCandidate(ConstraintWidget object, int n10) {
        Object object2;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
        int n11;
        Object object3 = ((ConstraintWidget)object).getVisibility();
        if (object3 != (n11 = 8) && (constraintWidget$DimensionBehaviour2 = ((ConstraintWidget)object).mListDimensionBehaviors[n10]) == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) && ((object3 = (Object)(object = (Object)((ConstraintWidget)object).mResolvedMatchConstraintDefault)[n10]) == 0 || (object2 = object[n10]) == (n10 = 3))) {
            object2 = true;
        } else {
            object2 = false;
            object = null;
        }
        return object2;
    }

    public void define() {
        boolean bl2 = this.mDefined;
        if (!bl2) {
            this.defineChainProperties();
        }
        this.mDefined = true;
    }

    public ConstraintWidget getFirst() {
        return this.mFirst;
    }

    public ConstraintWidget getFirstMatchConstraintWidget() {
        return this.mFirstMatchConstraintWidget;
    }

    public ConstraintWidget getFirstVisibleWidget() {
        return this.mFirstVisibleWidget;
    }

    public ConstraintWidget getHead() {
        return this.mHead;
    }

    public ConstraintWidget getLast() {
        return this.mLast;
    }

    public ConstraintWidget getLastMatchConstraintWidget() {
        return this.mLastMatchConstraintWidget;
    }

    public ConstraintWidget getLastVisibleWidget() {
        return this.mLastVisibleWidget;
    }

    public float getTotalWeight() {
        return this.mTotalWeight;
    }
}

