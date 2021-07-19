/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.VirtualLayout;

public class Flow$WidgetsList {
    private ConstraintWidget biggest = null;
    public int biggestDimension = 0;
    private ConstraintAnchor mBottom;
    private int mCount = 0;
    private int mHeight = 0;
    private ConstraintAnchor mLeft;
    private int mMax = 0;
    private int mNbMatchConstraintsWidgets = 0;
    private int mOrientation = 0;
    private int mPaddingBottom = 0;
    private int mPaddingLeft = 0;
    private int mPaddingRight = 0;
    private int mPaddingTop = 0;
    private ConstraintAnchor mRight;
    private int mStartIndex = 0;
    private ConstraintAnchor mTop;
    private int mWidth = 0;
    public final /* synthetic */ Flow this$0;

    public Flow$WidgetsList(Flow flow, int n10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n11) {
        int n12;
        this.this$0 = flow;
        this.mOrientation = n10;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = n10 = flow.getPaddingLeft();
        this.mPaddingTop = n10 = flow.getPaddingTop();
        this.mPaddingRight = n10 = flow.getPaddingRight();
        this.mPaddingBottom = n12 = flow.getPaddingBottom();
        this.mMax = n11;
    }

    public static /* synthetic */ ConstraintWidget access$2000(Flow$WidgetsList flow$WidgetsList) {
        return flow$WidgetsList.biggest;
    }

    private void recomputeDimensions() {
        Flow flow;
        int n10;
        int n11;
        this.mWidth = 0;
        this.mHeight = 0;
        this.biggest = null;
        this.biggestDimension = 0;
        int n12 = this.mCount;
        for (int i10 = 0; i10 < n12 && (n11 = this.mStartIndex + i10) < (n10 = Flow.access$400(flow = this.this$0)); ++i10) {
            ConstraintWidget constraintWidget;
            int n13;
            int n14;
            Flow flow2;
            Object object = Flow.access$500(this.this$0);
            n10 = this.mStartIndex + i10;
            object = object[n10];
            n10 = this.mOrientation;
            int n15 = 8;
            if (n10 == 0) {
                n10 = ((ConstraintWidget)object).getWidth();
                flow2 = this.this$0;
                n14 = Flow.access$000(flow2);
                n13 = ((ConstraintWidget)object).getVisibility();
                if (n13 == n15) {
                    n14 = 0;
                    flow2 = null;
                }
                n15 = this.mWidth;
                this.mWidth = n15 += (n10 += n14);
                flow = this.this$0;
                n15 = this.mMax;
                n10 = Flow.access$300(flow, (ConstraintWidget)object, n15);
                constraintWidget = this.biggest;
                if (constraintWidget != null && (n15 = this.biggestDimension) >= n10) continue;
                this.biggest = object;
                this.biggestDimension = n10;
                this.mHeight = n10;
                continue;
            }
            flow = this.this$0;
            n14 = this.mMax;
            n10 = Flow.access$200(flow, (ConstraintWidget)object, n14);
            flow2 = this.this$0;
            n13 = this.mMax;
            n14 = Flow.access$300(flow2, (ConstraintWidget)object, n13);
            Flow flow3 = this.this$0;
            n13 = Flow.access$100(flow3);
            int n16 = ((ConstraintWidget)object).getVisibility();
            if (n16 == n15) {
                n13 = 0;
                flow3 = null;
            }
            n15 = this.mHeight;
            this.mHeight = n15 += (n14 += n13);
            constraintWidget = this.biggest;
            if (constraintWidget != null && (n15 = this.biggestDimension) >= n10) continue;
            this.biggest = object;
            this.biggestDimension = n10;
            this.mWidth = n10;
        }
    }

    public void add(ConstraintWidget constraintWidget) {
        int n10;
        int n11 = this.mOrientation;
        int n12 = 8;
        int n13 = 0;
        if (n11 == 0) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            Flow flow = this.this$0;
            int n14 = this.mMax;
            n11 = Flow.access$200(flow, constraintWidget, n14);
            Object object = constraintWidget.getHorizontalDimensionBehaviour();
            if (object == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                this.mNbMatchConstraintsWidgets = n11 = this.mNbMatchConstraintsWidgets + 1;
                n11 = 0;
                flow = null;
            }
            object = this.this$0;
            n14 = Flow.access$000((Flow)object);
            int n15 = constraintWidget.getVisibility();
            if (n15 != n12) {
                n13 = n14;
            }
            n12 = this.mWidth;
            this.mWidth = n12 += (n11 += n13);
            flow = this.this$0;
            n12 = this.mMax;
            n11 = Flow.access$300(flow, constraintWidget, n12);
            ConstraintWidget constraintWidget2 = this.biggest;
            if (constraintWidget2 == null || (n12 = this.biggestDimension) < n11) {
                this.biggest = constraintWidget;
                this.biggestDimension = n11;
                this.mHeight = n11;
            }
        } else {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            Flow flow = this.this$0;
            int n16 = this.mMax;
            n11 = Flow.access$200(flow, constraintWidget, n16);
            Flow flow2 = this.this$0;
            int n17 = this.mMax;
            n16 = Flow.access$300(flow2, constraintWidget, n17);
            Object object = constraintWidget.getVerticalDimensionBehaviour();
            if (object == (constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                this.mNbMatchConstraintsWidgets = n16 = this.mNbMatchConstraintsWidgets + 1;
                n16 = 0;
                flow2 = null;
            }
            object = this.this$0;
            n17 = Flow.access$100((Flow)object);
            int n18 = constraintWidget.getVisibility();
            if (n18 != n12) {
                n13 = n17;
            }
            n12 = this.mHeight;
            this.mHeight = n12 += (n16 += n13);
            ConstraintWidget constraintWidget3 = this.biggest;
            if (constraintWidget3 == null || (n12 = this.biggestDimension) < n11) {
                this.biggest = constraintWidget;
                this.biggestDimension = n11;
                this.mWidth = n11;
            }
        }
        this.mCount = n10 = this.mCount + 1;
    }

    public void clear() {
        this.biggestDimension = 0;
        this.biggest = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mStartIndex = 0;
        this.mCount = 0;
        this.mNbMatchConstraintsWidgets = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void createConstraints(boolean bl2, int n10, boolean bl3) {
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        float f10;
        Object object4;
        int n17;
        int n18;
        Object object5;
        int n19;
        Flow$WidgetsList flow$WidgetsList;
        block60: {
            Object object6;
            int n20;
            int n21;
            float f11;
            Object object7;
            int n22;
            block53: {
                block58: {
                    int n23;
                    block59: {
                        block57: {
                            Object object8;
                            Flow flow;
                            flow$WidgetsList = this;
                            n19 = this.mCount;
                            object5 = null;
                            for (n22 = 0; n22 < n19 && (n18 = flow$WidgetsList.mStartIndex + n22) < (n17 = Flow.access$400(flow = flow$WidgetsList.this$0)); ++n22) {
                                object8 = Flow.access$500(flow$WidgetsList.this$0);
                                n17 = flow$WidgetsList.mStartIndex + n22;
                                if ((object8 = object8[n17]) == null) continue;
                                ((ConstraintWidget)object8).resetAnchors();
                            }
                            if (n19 == 0) return;
                            object5 = flow$WidgetsList.biggest;
                            if (object5 == null) {
                                return;
                            }
                            if (bl3 && n10 == 0) {
                                n18 = 1;
                            } else {
                                n18 = 0;
                                object8 = null;
                            }
                            n17 = -1;
                            object4 = null;
                            f10 = 0.0f;
                            n16 = n17;
                            n15 = n17;
                            for (n14 = 0; n14 < n19 && (n13 = flow$WidgetsList.mStartIndex + (n12 = bl2 ? n19 + -1 - n14 : n14)) < (n11 = Flow.access$400((Flow)(object3 = flow$WidgetsList.this$0))); ++n14) {
                                object2 = Flow.access$500(flow$WidgetsList.this$0);
                                object = object2[n11 = flow$WidgetsList.mStartIndex + n12];
                                n12 = ((ConstraintWidget)object).getVisibility();
                                if (n12 != 0) continue;
                                if (n16 == n17) {
                                    n16 = n14;
                                }
                                n15 = n14;
                            }
                            n14 = 0;
                            f10 = 0.0f;
                            object4 = null;
                            n12 = flow$WidgetsList.mOrientation;
                            if (n12 != 0) break block57;
                            object = flow$WidgetsList.biggest;
                            object2 = flow$WidgetsList.this$0;
                            n13 = Flow.access$600((Flow)object2);
                            ((ConstraintWidget)object).setVerticalChainStyle(n13);
                            n13 = flow$WidgetsList.mPaddingTop;
                            if (n10 > 0) {
                                object3 = flow$WidgetsList.this$0;
                                n11 = Flow.access$100((Flow)object3);
                                n13 += n11;
                            }
                            object3 = ((ConstraintWidget)object).mTop;
                            object7 = flow$WidgetsList.mTop;
                            ((ConstraintAnchor)object3).connect((ConstraintAnchor)object7, n13);
                            if (bl3) {
                                object2 = ((ConstraintWidget)object).mBottom;
                                object3 = flow$WidgetsList.mBottom;
                                n23 = flow$WidgetsList.mPaddingBottom;
                                ((ConstraintAnchor)object2).connect((ConstraintAnchor)object3, n23);
                            }
                            if (n10 > 0) {
                                object2 = flow$WidgetsList.mTop.mOwner.mBottom;
                                object3 = ((ConstraintWidget)object).mTop;
                                ((ConstraintAnchor)object2).connect((ConstraintAnchor)object3, 0);
                            }
                            object2 = flow$WidgetsList.this$0;
                            n13 = Flow.access$700((Flow)object2);
                            n11 = 3;
                            f11 = 4.2E-45f;
                            if (n13 != n11 || (n13 = (int)(((ConstraintWidget)object).hasBaseline() ? 1 : 0)) != 0) break block58;
                            object2 = null;
                            break block59;
                        }
                        object5 = flow$WidgetsList.biggest;
                        object = flow$WidgetsList.this$0;
                        n12 = Flow.access$800((Flow)object);
                        ((ConstraintWidget)object5).setHorizontalChainStyle(n12);
                        n12 = flow$WidgetsList.mPaddingLeft;
                        if (n10 > 0) {
                            object2 = flow$WidgetsList.this$0;
                            n13 = Flow.access$000((Flow)object2);
                            n12 += n13;
                        }
                        if (bl2) {
                            object2 = ((ConstraintWidget)object5).mRight;
                            object3 = flow$WidgetsList.mRight;
                            ((ConstraintAnchor)object2).connect((ConstraintAnchor)object3, n12);
                            if (bl3) {
                                object = ((ConstraintWidget)object5).mLeft;
                                object2 = flow$WidgetsList.mLeft;
                                n11 = flow$WidgetsList.mPaddingRight;
                                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, n11);
                            }
                            if (n10 > 0) {
                                object = flow$WidgetsList.mRight.mOwner.mLeft;
                                object2 = ((ConstraintWidget)object5).mRight;
                                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                            }
                            break block60;
                        } else {
                            object2 = ((ConstraintWidget)object5).mLeft;
                            object3 = flow$WidgetsList.mLeft;
                            ((ConstraintAnchor)object2).connect((ConstraintAnchor)object3, n12);
                            if (bl3) {
                                object = ((ConstraintWidget)object5).mRight;
                                object2 = flow$WidgetsList.mRight;
                                n11 = flow$WidgetsList.mPaddingRight;
                                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, n11);
                            }
                            if (n10 > 0) {
                                object = flow$WidgetsList.mLeft.mOwner.mRight;
                                object2 = ((ConstraintWidget)object5).mLeft;
                                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                            }
                        }
                        break block60;
                    }
                    for (n13 = 0; n13 < n19 && (n21 = flow$WidgetsList.mStartIndex + (n23 = bl2 ? n19 + -1 - n13 : n13)) < (n20 = Flow.access$400((Flow)(object6 = flow$WidgetsList.this$0))); ++n13) {
                        ConstraintWidget[] constraintWidgetArray = Flow.access$500(flow$WidgetsList.this$0);
                        object7 = constraintWidgetArray[n20 = flow$WidgetsList.mStartIndex + n23];
                        n21 = ((ConstraintWidget)object7).hasBaseline() ? 1 : 0;
                        if (n21 == 0) {
                            continue;
                        }
                        break block53;
                    }
                }
                object7 = object;
            }
            n13 = 0;
            object2 = null;
            while (n13 < n19) {
                block54: {
                    block61: {
                        block63: {
                            block62: {
                                n21 = bl2 ? n19 + -1 - n13 : n13;
                                n20 = flow$WidgetsList.mStartIndex + n21;
                                Object object9 = flow$WidgetsList.this$0;
                                int n24 = Flow.access$400((Flow)object9);
                                if (n20 >= n24) {
                                    return;
                                }
                                object6 = Flow.access$500(flow$WidgetsList.this$0);
                                n24 = flow$WidgetsList.mStartIndex + n21;
                                object6 = object6[n24];
                                if (n13 == 0) {
                                    object9 = ((ConstraintWidget)object6).mLeft;
                                    object3 = flow$WidgetsList.mLeft;
                                    n22 = flow$WidgetsList.mPaddingLeft;
                                    ((ConstraintWidget)object6).connect((ConstraintAnchor)object9, (ConstraintAnchor)object3, n22);
                                }
                                if (n21 == 0) {
                                    Flow flow;
                                    Flow flow2;
                                    object5 = flow$WidgetsList.this$0;
                                    n22 = Flow.access$800((Flow)object5);
                                    object3 = flow$WidgetsList.this$0;
                                    f11 = Flow.access$900((Flow)object3);
                                    n21 = flow$WidgetsList.mStartIndex;
                                    if (n21 == 0 && (n21 = Flow.access$1000(flow2 = flow$WidgetsList.this$0)) != n17) {
                                        object5 = flow$WidgetsList.this$0;
                                        n22 = Flow.access$1000((Flow)object5);
                                        object3 = flow$WidgetsList.this$0;
                                        f11 = Flow.access$1100((Flow)object3);
                                    } else if (bl3 && (n21 = Flow.access$1200(flow = flow$WidgetsList.this$0)) != n17) {
                                        object5 = flow$WidgetsList.this$0;
                                        n22 = Flow.access$1200((Flow)object5);
                                        object3 = flow$WidgetsList.this$0;
                                        f11 = Flow.access$1300((Flow)object3);
                                    }
                                    ((ConstraintWidget)object6).setHorizontalChainStyle(n22);
                                    ((ConstraintWidget)object6).setHorizontalBiasPercent(f11);
                                }
                                if (n13 == (n22 = n19 + -1)) {
                                    object5 = ((ConstraintWidget)object6).mRight;
                                    object3 = flow$WidgetsList.mRight;
                                    n21 = flow$WidgetsList.mPaddingRight;
                                    ((ConstraintWidget)object6).connect((ConstraintAnchor)object5, (ConstraintAnchor)object3, n21);
                                }
                                if (object4 != null) {
                                    object5 = ((ConstraintWidget)object6).mLeft;
                                    object3 = ((ConstraintWidget)object4).mRight;
                                    Flow flow = flow$WidgetsList.this$0;
                                    n21 = Flow.access$000(flow);
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, n21);
                                    if (n13 == n16) {
                                        object5 = ((ConstraintWidget)object6).mLeft;
                                        n11 = flow$WidgetsList.mPaddingLeft;
                                        ((ConstraintAnchor)object5).setGoneMargin(n11);
                                    }
                                    object5 = ((ConstraintWidget)object4).mRight;
                                    object3 = ((ConstraintWidget)object6).mLeft;
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                                    n22 = 1;
                                    n11 = n15 + 1;
                                    if (n13 == n11) {
                                        object5 = ((ConstraintWidget)object4).mRight;
                                        n14 = flow$WidgetsList.mPaddingRight;
                                        ((ConstraintAnchor)object5).setGoneMargin(n14);
                                    }
                                }
                                if (object6 == object) break block61;
                                object5 = flow$WidgetsList.this$0;
                                n22 = Flow.access$700((Flow)object5);
                                n14 = 3;
                                f10 = 4.2E-45f;
                                if (n22 != n14 || (n22 = (int)(((ConstraintWidget)object7).hasBaseline() ? 1 : 0)) == 0 || object6 == object7 || (n22 = (int)(((ConstraintWidget)object6).hasBaseline() ? 1 : 0)) == 0) break block62;
                                object5 = ((ConstraintWidget)object6).mBaseline;
                                object3 = ((ConstraintWidget)object7).mBaseline;
                                ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                                break block54;
                            }
                            object5 = flow$WidgetsList.this$0;
                            n22 = Flow.access$700((Flow)object5);
                            if (n22 == 0) break block63;
                            n11 = 1;
                            f11 = Float.MIN_VALUE;
                            if (n22 != n11) {
                                if (n18 != 0) {
                                    object5 = ((ConstraintWidget)object6).mTop;
                                    object3 = flow$WidgetsList.mTop;
                                    n21 = flow$WidgetsList.mPaddingTop;
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, n21);
                                    object5 = ((ConstraintWidget)object6).mBottom;
                                    object3 = flow$WidgetsList.mBottom;
                                    n21 = flow$WidgetsList.mPaddingBottom;
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, n21);
                                    break block54;
                                } else {
                                    object5 = ((ConstraintWidget)object6).mTop;
                                    object3 = ((ConstraintWidget)object).mTop;
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                                    object5 = ((ConstraintWidget)object6).mBottom;
                                    object3 = ((ConstraintWidget)object).mBottom;
                                    ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                                }
                                break block54;
                            } else {
                                object5 = ((ConstraintWidget)object6).mBottom;
                                object3 = ((ConstraintWidget)object).mBottom;
                                ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                            }
                            break block54;
                        }
                        object5 = ((ConstraintWidget)object6).mTop;
                        object3 = ((ConstraintWidget)object).mTop;
                        ((ConstraintAnchor)object5).connect((ConstraintAnchor)object3, 0);
                        break block54;
                    }
                    n14 = 3;
                    f10 = 4.2E-45f;
                }
                ++n13;
                n11 = n14;
                f11 = f10;
                object4 = object6;
            }
            return;
        }
        n12 = 0;
        object = null;
        while (n12 < n19) {
            block55: {
                int n25;
                float f12;
                block56: {
                    block64: {
                        block65: {
                            int n26;
                            Object object10;
                            n13 = flow$WidgetsList.mStartIndex + n12;
                            object3 = flow$WidgetsList.this$0;
                            n11 = Flow.access$400((Flow)object3);
                            if (n13 >= n11) {
                                return;
                            }
                            object2 = Flow.access$500(flow$WidgetsList.this$0);
                            n11 = flow$WidgetsList.mStartIndex + n12;
                            object2 = object2[n11];
                            if (n12 == 0) {
                                Flow flow;
                                Flow flow3;
                                object3 = ((ConstraintWidget)object2).mTop;
                                object10 = flow$WidgetsList.mTop;
                                n26 = flow$WidgetsList.mPaddingTop;
                                ((ConstraintWidget)object2).connect((ConstraintAnchor)object3, (ConstraintAnchor)object10, n26);
                                object3 = flow$WidgetsList.this$0;
                                n11 = Flow.access$600((Flow)object3);
                                object10 = flow$WidgetsList.this$0;
                                f12 = Flow.access$1400((Flow)object10);
                                n26 = flow$WidgetsList.mStartIndex;
                                if (n26 == 0 && (n26 = Flow.access$1500(flow3 = flow$WidgetsList.this$0)) != n17) {
                                    object3 = flow$WidgetsList.this$0;
                                    n11 = Flow.access$1500((Flow)object3);
                                    object10 = flow$WidgetsList.this$0;
                                    f12 = Flow.access$1600((Flow)object10);
                                } else if (bl3 && (n26 = Flow.access$1700(flow = flow$WidgetsList.this$0)) != n17) {
                                    object3 = flow$WidgetsList.this$0;
                                    n11 = Flow.access$1700((Flow)object3);
                                    object10 = flow$WidgetsList.this$0;
                                    f12 = Flow.access$1800((Flow)object10);
                                }
                                ((ConstraintWidget)object2).setVerticalChainStyle(n11);
                                ((ConstraintWidget)object2).setVerticalBiasPercent(f12);
                            }
                            if (n12 == (n11 = n19 + -1)) {
                                object3 = ((ConstraintWidget)object2).mBottom;
                                object10 = flow$WidgetsList.mBottom;
                                n26 = flow$WidgetsList.mPaddingBottom;
                                ((ConstraintWidget)object2).connect((ConstraintAnchor)object3, (ConstraintAnchor)object10, n26);
                            }
                            if (object4 != null) {
                                object3 = ((ConstraintWidget)object2).mTop;
                                object10 = ((ConstraintWidget)object4).mBottom;
                                Flow flow = flow$WidgetsList.this$0;
                                n26 = Flow.access$100(flow);
                                ((ConstraintAnchor)object3).connect((ConstraintAnchor)object10, n26);
                                if (n12 == n16) {
                                    object3 = ((ConstraintWidget)object2).mTop;
                                    n25 = flow$WidgetsList.mPaddingTop;
                                    ((ConstraintAnchor)object3).setGoneMargin(n25);
                                }
                                object3 = ((ConstraintWidget)object4).mBottom;
                                object10 = ((ConstraintWidget)object2).mTop;
                                ((ConstraintAnchor)object3).connect((ConstraintAnchor)object10, 0);
                                n11 = 1;
                                float f13 = Float.MIN_VALUE;
                                n25 = n15 + 1;
                                if (n12 == n25) {
                                    object4 = ((ConstraintWidget)object4).mBottom;
                                    n11 = flow$WidgetsList.mPaddingBottom;
                                    ((ConstraintAnchor)object4).setGoneMargin(n11);
                                }
                            }
                            if (object2 == object5) break block56;
                            n14 = 2;
                            f10 = 2.8E-45f;
                            if (bl2) break block64;
                            object3 = flow$WidgetsList.this$0;
                            n11 = Flow.access$1900((Flow)object3);
                            if (n11 == 0) break block65;
                            n25 = 1;
                            f12 = Float.MIN_VALUE;
                            if (n11 != n25) {
                                if (n11 == n14) {
                                    if (n18 != 0) {
                                        object4 = ((ConstraintWidget)object2).mLeft;
                                        object3 = flow$WidgetsList.mLeft;
                                        n26 = flow$WidgetsList.mPaddingLeft;
                                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, n26);
                                        object4 = ((ConstraintWidget)object2).mRight;
                                        object3 = flow$WidgetsList.mRight;
                                        n26 = flow$WidgetsList.mPaddingRight;
                                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, n26);
                                        break block55;
                                    } else {
                                        object4 = ((ConstraintWidget)object2).mLeft;
                                        object3 = ((ConstraintWidget)object5).mLeft;
                                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                                        object4 = ((ConstraintWidget)object2).mRight;
                                        object3 = ((ConstraintWidget)object5).mRight;
                                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                                    }
                                }
                                break block55;
                            } else {
                                object4 = ((ConstraintWidget)object2).mRight;
                                object3 = ((ConstraintWidget)object5).mRight;
                                ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                            }
                            break block55;
                        }
                        n25 = 1;
                        f12 = Float.MIN_VALUE;
                        object4 = ((ConstraintWidget)object2).mLeft;
                        object3 = ((ConstraintWidget)object5).mLeft;
                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                        break block55;
                    }
                    object3 = flow$WidgetsList.this$0;
                    n11 = Flow.access$1900((Flow)object3);
                    if (n11 != 0) {
                        n25 = 1;
                        f12 = Float.MIN_VALUE;
                        if (n11 != n25) {
                            if (n11 == n14) {
                                object4 = ((ConstraintWidget)object2).mLeft;
                                object3 = ((ConstraintWidget)object5).mLeft;
                                ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                                object4 = ((ConstraintWidget)object2).mRight;
                                object3 = ((ConstraintWidget)object5).mRight;
                                ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                            }
                        } else {
                            object4 = ((ConstraintWidget)object2).mLeft;
                            object3 = ((ConstraintWidget)object5).mLeft;
                            ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                        }
                    } else {
                        object4 = ((ConstraintWidget)object2).mRight;
                        object3 = ((ConstraintWidget)object5).mRight;
                        ((ConstraintAnchor)object4).connect((ConstraintAnchor)object3, 0);
                    }
                }
                n25 = 1;
                f12 = Float.MIN_VALUE;
            }
            ++n12;
            object4 = object2;
        }
    }

    public int getHeight() {
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 == n11) {
            n10 = this.mHeight;
            n11 = Flow.access$100(this.this$0);
            return n10 - n11;
        }
        return this.mHeight;
    }

    public int getWidth() {
        int n10 = this.mOrientation;
        if (n10 == 0) {
            n10 = this.mWidth;
            int n11 = Flow.access$000(this.this$0);
            return n10 - n11;
        }
        return this.mWidth;
    }

    public void measureMatchConstraints(int n10) {
        ConstraintWidget constraintWidget;
        int n11;
        int n12;
        int n13 = this.mNbMatchConstraintsWidgets;
        if (n13 == 0) {
            return;
        }
        int n14 = this.mCount;
        n10 /= n13;
        for (n13 = 0; n13 < n14 && (n12 = this.mStartIndex + n13) < (n11 = Flow.access$400((Flow)(constraintWidget = this.this$0))); ++n13) {
            int n15;
            int n16;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2;
            Object object = Flow.access$500(this.this$0);
            n11 = this.mStartIndex + n13;
            constraintWidget = object[n11];
            n12 = this.mOrientation;
            if (n12 == 0) {
                if (constraintWidget == null || (object = constraintWidget.getHorizontalDimensionBehaviour()) != (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (n12 = constraintWidget.mMatchConstraintDefaultWidth) != 0) continue;
                object = this.this$0;
                constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
                constraintWidget$DimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
                n16 = constraintWidget.getHeight();
                n15 = n10;
                ((VirtualLayout)object).measure(constraintWidget, constraintWidget$DimensionBehaviour2, n10, constraintWidget$DimensionBehaviour, n16);
                continue;
            }
            if (constraintWidget == null || (object = constraintWidget.getVerticalDimensionBehaviour()) != (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT) || (n12 = constraintWidget.mMatchConstraintDefaultHeight) != 0) continue;
            object = this.this$0;
            constraintWidget$DimensionBehaviour2 = constraintWidget.getHorizontalDimensionBehaviour();
            n15 = constraintWidget.getWidth();
            constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
            n16 = n10;
            ((VirtualLayout)object).measure(constraintWidget, constraintWidget$DimensionBehaviour2, n15, constraintWidget$DimensionBehaviour, n10);
        }
        this.recomputeDimensions();
    }

    public void setStartIndex(int n10) {
        this.mStartIndex = n10;
    }

    public void setup(int n10, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int n11, int n12, int n13, int n14, int n15) {
        this.mOrientation = n10;
        this.mLeft = constraintAnchor;
        this.mTop = constraintAnchor2;
        this.mRight = constraintAnchor3;
        this.mBottom = constraintAnchor4;
        this.mPaddingLeft = n11;
        this.mPaddingTop = n12;
        this.mPaddingRight = n13;
        this.mPaddingBottom = n14;
        this.mMax = n15;
    }
}

