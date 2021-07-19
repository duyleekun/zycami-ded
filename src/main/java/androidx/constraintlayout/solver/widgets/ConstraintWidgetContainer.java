/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.WidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyGraph;
import androidx.constraintlayout.solver.widgets.analyzer.Direct;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ConstraintWidgetContainer
extends WidgetContainer {
    private static final boolean DEBUG = false;
    public static final boolean DEBUG_GRAPH = false;
    private static final boolean DEBUG_LAYOUT = false;
    private static final int MAX_ITERATIONS = 8;
    public static int mycounter;
    private WeakReference horizontalWrapMax;
    private WeakReference horizontalWrapMin;
    public BasicMeasure mBasicMeasureSolver;
    public int mDebugSolverPassCount;
    public DependencyGraph mDependencyGraph;
    public boolean mGroupsWrapOptimized;
    private boolean mHeightMeasuredTooSmall;
    public ChainHead[] mHorizontalChainsArray;
    public int mHorizontalChainsSize;
    public boolean mHorizontalWrapOptimized;
    private boolean mIsRtl;
    public BasicMeasure$Measure mMeasure;
    public BasicMeasure$Measurer mMeasurer;
    public Metrics mMetrics;
    private int mOptimizationLevel;
    public int mPaddingBottom;
    public int mPaddingLeft;
    public int mPaddingRight;
    public int mPaddingTop;
    public boolean mSkipSolver;
    public LinearSystem mSystem;
    public ChainHead[] mVerticalChainsArray;
    public int mVerticalChainsSize;
    public boolean mVerticalWrapOptimized;
    private boolean mWidthMeasuredTooSmall;
    public int mWrapFixedHeight;
    public int mWrapFixedWidth;
    private WeakReference verticalWrapMax;
    private WeakReference verticalWrapMin;

    public ConstraintWidgetContainer() {
        Object object = new BasicMeasure(this);
        this.mBasicMeasureSolver = object;
        this.mDependencyGraph = object = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        ChainHead[] chainHeadArray = new LinearSystem();
        this.mSystem = chainHeadArray;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        int n10 = 4;
        ChainHead[] chainHeadArray2 = new ChainHead[n10];
        this.mVerticalChainsArray = chainHeadArray2;
        chainHeadArray = new ChainHead[n10];
        this.mHorizontalChainsArray = chainHeadArray;
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = object = new BasicMeasure$Measure();
    }

    public ConstraintWidgetContainer(int n10, int n11) {
        super(n10, n11);
        Object object = new BasicMeasure(this);
        this.mBasicMeasureSolver = object;
        this.mDependencyGraph = object = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        ChainHead[] chainHeadArray = new LinearSystem();
        this.mSystem = chainHeadArray;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        int n12 = 4;
        ChainHead[] chainHeadArray2 = new ChainHead[n12];
        this.mVerticalChainsArray = chainHeadArray2;
        chainHeadArray = new ChainHead[n12];
        this.mHorizontalChainsArray = chainHeadArray;
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = object = new BasicMeasure$Measure();
    }

    public ConstraintWidgetContainer(int n10, int n11, int n12, int n13) {
        super(n10, n11, n12, n13);
        Object object = new BasicMeasure(this);
        this.mBasicMeasureSolver = object;
        this.mDependencyGraph = object = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        ChainHead[] chainHeadArray = new LinearSystem();
        this.mSystem = chainHeadArray;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        n12 = 4;
        ChainHead[] chainHeadArray2 = new ChainHead[n12];
        this.mVerticalChainsArray = chainHeadArray2;
        chainHeadArray = new ChainHead[n12];
        this.mHorizontalChainsArray = chainHeadArray;
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = object = new BasicMeasure$Measure();
    }

    public ConstraintWidgetContainer(String string2, int n10, int n11) {
        super(n10, n11);
        Object object = new BasicMeasure(this);
        this.mBasicMeasureSolver = object;
        this.mDependencyGraph = object = new DependencyGraph(this);
        this.mMeasurer = null;
        this.mIsRtl = false;
        ChainHead[] chainHeadArray = new LinearSystem();
        this.mSystem = chainHeadArray;
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
        int n12 = 4;
        ChainHead[] chainHeadArray2 = new ChainHead[n12];
        this.mVerticalChainsArray = chainHeadArray2;
        chainHeadArray = new ChainHead[n12];
        this.mHorizontalChainsArray = chainHeadArray;
        this.mGroupsWrapOptimized = false;
        this.mHorizontalWrapOptimized = false;
        this.mVerticalWrapOptimized = false;
        this.mWrapFixedWidth = 0;
        this.mWrapFixedHeight = 0;
        this.mOptimizationLevel = 257;
        this.mSkipSolver = false;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        this.mDebugSolverPassCount = 0;
        this.verticalWrapMin = null;
        this.horizontalWrapMin = null;
        this.verticalWrapMax = null;
        this.horizontalWrapMax = null;
        this.mMeasure = object = new BasicMeasure$Measure();
        this.setDebugName(string2);
    }

    private void addHorizontalChain(ConstraintWidget constraintWidget) {
        int n10;
        ChainHead chainHead;
        ChainHead[] chainHeadArray;
        int n11 = this.mHorizontalChainsSize + 1;
        ChainHead[] chainHeadArray2 = this.mHorizontalChainsArray;
        int n12 = chainHeadArray2.length;
        if (n11 >= n12) {
            n11 = chainHeadArray2.length * 2;
            this.mHorizontalChainsArray = chainHeadArray = Arrays.copyOf(chainHeadArray2, n11);
        }
        chainHeadArray = this.mHorizontalChainsArray;
        int n13 = this.mHorizontalChainsSize;
        boolean bl2 = this.isRtl();
        chainHeadArray[n13] = chainHead = new ChainHead(constraintWidget, 0, bl2);
        this.mHorizontalChainsSize = n10 = this.mHorizontalChainsSize + 1;
    }

    private void addMaxWrap(ConstraintAnchor object, SolverVariable solverVariable) {
        object = this.mSystem.createObjectVariable(object);
        this.mSystem.addGreaterThan(solverVariable, (SolverVariable)object, 0, 5);
    }

    private void addMinWrap(ConstraintAnchor object, SolverVariable solverVariable) {
        object = this.mSystem.createObjectVariable(object);
        this.mSystem.addGreaterThan((SolverVariable)object, solverVariable, 0, 5);
    }

    private void addVerticalChain(ConstraintWidget constraintWidget) {
        int n10;
        ChainHead chainHead;
        ChainHead[] chainHeadArray;
        int n11 = this.mVerticalChainsSize;
        int n12 = 1;
        ChainHead[] chainHeadArray2 = this.mVerticalChainsArray;
        int n13 = chainHeadArray2.length;
        if ((n11 += n12) >= n13) {
            n11 = chainHeadArray2.length * 2;
            this.mVerticalChainsArray = chainHeadArray = Arrays.copyOf(chainHeadArray2, n11);
        }
        chainHeadArray = this.mVerticalChainsArray;
        int n14 = this.mVerticalChainsSize;
        boolean bl2 = this.isRtl();
        chainHeadArray[n14] = chainHead = new ChainHead(constraintWidget, n12, bl2);
        this.mVerticalChainsSize = n10 = this.mVerticalChainsSize + n12;
    }

    public static boolean measure(ConstraintWidget constraintWidget, BasicMeasure$Measurer basicMeasure$Measurer, BasicMeasure$Measure basicMeasure$Measure, int n10) {
        int n11;
        int n12;
        float f10;
        float f11;
        int[] nArray;
        float f12;
        float f13;
        int n13;
        float f14;
        float f15;
        int n14;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        int n15 = 0;
        float f16 = 0.0f;
        Object object = null;
        if (basicMeasure$Measurer == null) {
            return false;
        }
        basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour = constraintWidget.getVerticalDimensionBehaviour();
        basicMeasure$Measure.horizontalDimension = n14 = constraintWidget.getWidth();
        basicMeasure$Measure.verticalDimension = n14 = constraintWidget.getHeight();
        basicMeasure$Measure.measuredNeedsSolverPass = false;
        basicMeasure$Measure.measureStrategy = n10;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = basicMeasure$Measure.horizontalBehavior;
        constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        int n16 = 1;
        float f17 = Float.MIN_VALUE;
        if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour) {
            n10 = n16;
            f15 = f17;
        } else {
            n10 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f15 = 0.0f;
        }
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = basicMeasure$Measure.verticalBehavior;
        if (constraintWidget$DimensionBehaviour3 == constraintWidget$DimensionBehaviour) {
            n14 = n16;
            f14 = f17;
        } else {
            n14 = 0;
            constraintWidget$DimensionBehaviour = null;
            f14 = 0.0f;
        }
        int n17 = 0;
        constraintWidget$DimensionBehaviour3 = null;
        if (n10 != 0 && (n13 = (f13 = (f12 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
            n13 = n16;
            f12 = f17;
        } else {
            n13 = 0;
            nArray = null;
            f12 = 0.0f;
        }
        if (n14 != 0 && (n17 = (f11 = (f10 = constraintWidget.mDimensionRatio) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0) {
            n17 = n16;
        } else {
            n17 = 0;
            constraintWidget$DimensionBehaviour3 = null;
        }
        if (n10 != 0 && (n12 = constraintWidget.hasDanglingDimension(0)) != 0 && (n12 = constraintWidget.mMatchConstraintDefaultWidth) == 0 && n13 == 0) {
            basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (n14 != 0 && (n10 = constraintWidget.mMatchConstraintDefaultHeight) == 0) {
                basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
            }
            n10 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f15 = 0.0f;
        }
        if (n14 != 0 && (n12 = constraintWidget.hasDanglingDimension(n16)) != 0 && (n12 = constraintWidget.mMatchConstraintDefaultHeight) == 0 && n17 == 0) {
            basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (n10 != 0 && (n14 = constraintWidget.mMatchConstraintDefaultWidth) == 0) {
                basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
            }
            n14 = 0;
            constraintWidget$DimensionBehaviour = null;
            f14 = 0.0f;
        }
        if ((n12 = constraintWidget.isResolvedHorizontally()) != 0) {
            basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
            n10 = 0;
            constraintWidget$DimensionBehaviour2 = null;
            f15 = 0.0f;
        }
        if ((n12 = (int)(constraintWidget.isResolvedVertically() ? 1 : 0)) != 0) {
            basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
            n14 = 0;
            constraintWidget$DimensionBehaviour = null;
            f14 = 0.0f;
        }
        n12 = -1;
        f10 = 0.0f / 0.0f;
        int n18 = 4;
        if (n13 != 0) {
            nArray = constraintWidget.mResolvedMatchConstraintDefault;
            n15 = nArray[0];
            if (n15 == n18) {
                object = (Object)ConstraintWidget$DimensionBehaviour.FIXED;
                basicMeasure$Measure.horizontalBehavior = (ConstraintWidget$DimensionBehaviour)((Object)object);
            } else if (n14 == 0) {
                object = (Object)basicMeasure$Measure.verticalBehavior;
                constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
                if (object == constraintWidget$DimensionBehaviour) {
                    n15 = basicMeasure$Measure.verticalDimension;
                } else {
                    object = (Object)ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    basicMeasure$Measure.horizontalBehavior = (ConstraintWidget$DimensionBehaviour)((Object)object);
                    basicMeasure$Measurer.measure(constraintWidget, basicMeasure$Measure);
                    n15 = basicMeasure$Measure.measuredHeight;
                }
                basicMeasure$Measure.horizontalBehavior = constraintWidget$DimensionBehaviour;
                n14 = constraintWidget.mDimensionRatioSide;
                if (n14 != 0 && n14 != n12) {
                    f14 = constraintWidget.getDimensionRatio();
                    f16 = n15;
                    basicMeasure$Measure.horizontalDimension = n15 = (int)(f14 /= f16);
                } else {
                    f14 = constraintWidget.getDimensionRatio();
                    f16 = n15;
                    basicMeasure$Measure.horizontalDimension = n15 = (int)(f14 *= f16);
                }
            }
        }
        if (n17 != 0) {
            object = constraintWidget.mResolvedMatchConstraintDefault;
            n15 = object[n16];
            if (n15 == n18) {
                basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
            } else if (n10 == 0) {
                constraintWidget$DimensionBehaviour2 = basicMeasure$Measure.horizontalBehavior;
                object = (Object)ConstraintWidget$DimensionBehaviour.FIXED;
                if (constraintWidget$DimensionBehaviour2 == object) {
                    n10 = basicMeasure$Measure.horizontalDimension;
                } else {
                    basicMeasure$Measure.verticalBehavior = constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    basicMeasure$Measurer.measure(constraintWidget, basicMeasure$Measure);
                    n10 = basicMeasure$Measure.measuredWidth;
                }
                basicMeasure$Measure.verticalBehavior = (ConstraintWidget$DimensionBehaviour)((Object)object);
                n15 = constraintWidget.mDimensionRatioSide;
                if (n15 != 0 && n15 != n12) {
                    f15 = n10;
                    f16 = constraintWidget.getDimensionRatio();
                    basicMeasure$Measure.verticalDimension = n10 = (int)(f15 *= f16);
                } else {
                    f15 = n10;
                    f16 = constraintWidget.getDimensionRatio();
                    basicMeasure$Measure.verticalDimension = n10 = (int)(f15 /= f16);
                }
            }
        }
        basicMeasure$Measurer.measure(constraintWidget, basicMeasure$Measure);
        int n19 = basicMeasure$Measure.measuredWidth;
        constraintWidget.setWidth(n19);
        n19 = basicMeasure$Measure.measuredHeight;
        constraintWidget.setHeight(n19);
        n19 = (int)(basicMeasure$Measure.measuredHasBaseline ? 1 : 0);
        constraintWidget.setHasBaseline(n19 != 0);
        n19 = basicMeasure$Measure.measuredBaseline;
        constraintWidget.setBaselineDistance(n19);
        basicMeasure$Measure.measureStrategy = n11 = BasicMeasure$Measure.SELF_DIMENSIONS;
        return basicMeasure$Measure.measuredNeedsSolverPass;
    }

    private void resetChains() {
        this.mHorizontalChainsSize = 0;
        this.mVerticalChainsSize = 0;
    }

    public void addChain(ConstraintWidget constraintWidget, int n10) {
        if (n10 == 0) {
            this.addHorizontalChain(constraintWidget);
        } else {
            int n11 = 1;
            if (n10 == n11) {
                this.addVerticalChain(constraintWidget);
            }
        }
    }

    public boolean addChildrenToSolver(LinearSystem linearSystem) {
        int n10;
        boolean bl2;
        Object object;
        int n11;
        boolean bl3 = this.optimizeFor(64);
        this.addToSolver(linearSystem, bl3);
        Object object2 = this.mChildren;
        int n12 = object2.size();
        int n13 = 0;
        Object object3 = null;
        int n14 = 0;
        Object object4 = null;
        while (true) {
            n11 = 1;
            if (n13 >= n12) break;
            object = (ConstraintWidget$DimensionBehaviour[])this.mChildren.get(n13);
            object.setInBarrier(0, false);
            object.setInBarrier(n11, false);
            bl2 = object instanceof Barrier;
            if (bl2) {
                n14 = n11;
            }
            ++n13;
        }
        if (n14 != 0) {
            object3 = null;
            for (n13 = 0; n13 < n12; ++n13) {
                object4 = (ConstraintWidget)this.mChildren.get(n13);
                bl2 = object4 instanceof Barrier;
                if (!bl2) continue;
                object4 = (Barrier)object4;
                ((Barrier)object4).markWidgets();
            }
        }
        object3 = null;
        for (n13 = 0; n13 < n12; ++n13) {
            object4 = (ConstraintWidget)this.mChildren.get(n13);
            bl2 = ((ConstraintWidget)object4).addFirst();
            if (!bl2) continue;
            ((ConstraintWidget)object4).addToSolver(linearSystem, bl3);
        }
        n13 = (int)(LinearSystem.USE_DEPENDENCY_ORDERING ? 1 : 0);
        if (n13 != 0) {
            object3 = new HashSet();
            object4 = null;
            for (n14 = 0; n14 < n12; ++n14) {
                object = (ConstraintWidget)this.mChildren.get(n14);
                boolean bl4 = object.addFirst();
                if (bl4) continue;
                ((HashSet)object3).add(object);
            }
            object2 = this.getHorizontalDimensionBehaviour();
            int n15 = object2 == (object4 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) ? 0 : n11;
            object = this;
            ConstraintWidgetContainer constraintWidgetContainer = this;
            LinearSystem linearSystem2 = linearSystem;
            HashSet<ConstraintWidget$DimensionBehaviour[]> hashSet = object3;
            this.addChildrenToSolverByDependency(this, linearSystem, (HashSet)object3, n15, false);
            object2 = ((HashSet)object3).iterator();
            while ((n13 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object3 = (ConstraintWidget)object2.next();
                Optimizer.checkMatchParent(this, linearSystem, (ConstraintWidget)object3);
                ((ConstraintWidget)object3).addToSolver(linearSystem, bl3);
            }
        } else {
            object3 = null;
            for (n13 = 0; n13 < n12; ++n13) {
                object4 = (ConstraintWidget)this.mChildren.get(n13);
                bl2 = object4 instanceof ConstraintWidgetContainer;
                if (bl2) {
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                    object = ((ConstraintWidget)object4).mListDimensionBehaviors;
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = object[0];
                    object = object[n11];
                    ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour3 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                        constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
                        ((ConstraintWidget)object4).setHorizontalDimensionBehaviour(constraintWidget$DimensionBehaviour);
                    }
                    if (object == constraintWidget$DimensionBehaviour3) {
                        constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
                        ((ConstraintWidget)object4).setVerticalDimensionBehaviour(constraintWidget$DimensionBehaviour);
                    }
                    ((ConstraintWidget)object4).addToSolver(linearSystem, bl3);
                    if (constraintWidget$DimensionBehaviour2 == constraintWidget$DimensionBehaviour3) {
                        ((ConstraintWidget)object4).setHorizontalDimensionBehaviour(constraintWidget$DimensionBehaviour2);
                    }
                    if (object != constraintWidget$DimensionBehaviour3) continue;
                    ((ConstraintWidget)object4).setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)((Object)object));
                    continue;
                }
                Optimizer.checkMatchParent(this, linearSystem, (ConstraintWidget)object4);
                bl2 = ((ConstraintWidget)object4).addFirst();
                if (bl2) continue;
                ((ConstraintWidget)object4).addToSolver(linearSystem, bl3);
            }
        }
        int n16 = this.mHorizontalChainsSize;
        n12 = 0;
        object2 = null;
        if (n16 > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, 0);
        }
        if ((n10 = this.mVerticalChainsSize) > 0) {
            Chain.applyChainConstraints(this, linearSystem, null, n11);
        }
        return n11 != 0;
    }

    public void addHorizontalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2;
        int n10;
        int n11;
        WeakReference weakReference = this.horizontalWrapMax;
        if (weakReference == null || (weakReference = weakReference.get()) == null || (n11 = constraintAnchor.getFinalValue()) > (n10 = (constraintAnchor2 = (ConstraintAnchor)this.horizontalWrapMax.get()).getFinalValue())) {
            this.horizontalWrapMax = weakReference = new WeakReference(constraintAnchor);
        }
    }

    public void addHorizontalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2;
        int n10;
        int n11;
        WeakReference weakReference = this.horizontalWrapMin;
        if (weakReference == null || (weakReference = weakReference.get()) == null || (n11 = constraintAnchor.getFinalValue()) > (n10 = (constraintAnchor2 = (ConstraintAnchor)this.horizontalWrapMin.get()).getFinalValue())) {
            this.horizontalWrapMin = weakReference = new WeakReference(constraintAnchor);
        }
    }

    public void addVerticalWrapMaxVariable(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2;
        int n10;
        int n11;
        WeakReference weakReference = this.verticalWrapMax;
        if (weakReference == null || (weakReference = weakReference.get()) == null || (n11 = constraintAnchor.getFinalValue()) > (n10 = (constraintAnchor2 = (ConstraintAnchor)this.verticalWrapMax.get()).getFinalValue())) {
            this.verticalWrapMax = weakReference = new WeakReference(constraintAnchor);
        }
    }

    public void addVerticalWrapMinVariable(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2;
        int n10;
        int n11;
        WeakReference weakReference = this.verticalWrapMin;
        if (weakReference == null || (weakReference = weakReference.get()) == null || (n11 = constraintAnchor.getFinalValue()) > (n10 = (constraintAnchor2 = (ConstraintAnchor)this.verticalWrapMin.get()).getFinalValue())) {
            this.verticalWrapMin = weakReference = new WeakReference(constraintAnchor);
        }
    }

    public void defineTerminalWidgets() {
        DependencyGraph dependencyGraph = this.mDependencyGraph;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = this.getHorizontalDimensionBehaviour();
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = this.getVerticalDimensionBehaviour();
        dependencyGraph.defineTerminalWidgets(constraintWidget$DimensionBehaviour, constraintWidget$DimensionBehaviour2);
    }

    public boolean directMeasure(boolean bl2) {
        return this.mDependencyGraph.directMeasure(bl2);
    }

    public boolean directMeasureSetup(boolean bl2) {
        return this.mDependencyGraph.directMeasureSetup(bl2);
    }

    public boolean directMeasureWithOrientation(boolean bl2, int n10) {
        return this.mDependencyGraph.directMeasureWithOrientation(bl2, n10);
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mSystem.fillMetrics(metrics);
    }

    public ArrayList getHorizontalGuidelines() {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<ConstraintWidget>();
        ArrayList arrayList2 = this.mChildren;
        int n10 = arrayList2.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            int n11 = constraintWidget instanceof Guideline;
            if (n11 == 0 || (n11 = ((Guideline)(constraintWidget = (Guideline)constraintWidget)).getOrientation()) != 0) continue;
            arrayList.add(constraintWidget);
        }
        return arrayList;
    }

    public BasicMeasure$Measurer getMeasurer() {
        return this.mMeasurer;
    }

    public int getOptimizationLevel() {
        return this.mOptimizationLevel;
    }

    public LinearSystem getSystem() {
        return this.mSystem;
    }

    public String getType() {
        return "ConstraintLayout";
    }

    public ArrayList getVerticalGuidelines() {
        ArrayList<ConstraintWidget> arrayList = new ArrayList<ConstraintWidget>();
        ArrayList arrayList2 = this.mChildren;
        int n10 = arrayList2.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            int n12 = constraintWidget instanceof Guideline;
            if (n12 == 0 || (n12 = ((Guideline)(constraintWidget = (Guideline)constraintWidget)).getOrientation()) != (n11 = 1)) continue;
            arrayList.add(constraintWidget);
        }
        return arrayList;
    }

    public boolean handlesInternalConstraints() {
        return false;
    }

    public void invalidateGraph() {
        this.mDependencyGraph.invalidateGraph();
    }

    public void invalidateMeasures() {
        this.mDependencyGraph.invalidateMeasures();
    }

    public boolean isHeightMeasuredTooSmall() {
        return this.mHeightMeasuredTooSmall;
    }

    public boolean isRtl() {
        return this.mIsRtl;
    }

    public boolean isWidthMeasuredTooSmall() {
        return this.mWidthMeasuredTooSmall;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void layout() {
        var1_1 = this;
        var2_2 = 0;
        var3_3 = 0.0f;
        var4_4 /* !! */  = null;
        this.mX = 0;
        this.mY = 0;
        this.mWidthMeasuredTooSmall = false;
        this.mHeightMeasuredTooSmall = false;
        var5_5 /* !! */  = this.mChildren;
        var6_7 = var5_5 /* !! */ .size();
        var7_8 /* !! */  = this.getWidth();
        var7_8 /* !! */  = Math.max(0, var7_8 /* !! */ );
        var8_9 = this.getHeight();
        var8_9 = Math.max(0, var8_9);
        var9_10 /* !! */  = this.mListDimensionBehaviors;
        var10_11 = 1;
        var11_12 = 1.4E-45f;
        var12_13 = var9_10 /* !! */ [var10_11];
        var9_10 /* !! */  = var9_10 /* !! */ [0];
        var13_14 /* !! */  = this.mMetrics;
        if (var13_14 /* !! */  != null) {
            var14_15 = var13_14 /* !! */ .layouts;
            var16_16 = 1L;
            var13_14 /* !! */ .layouts = var14_15 += var16_16;
        }
        if ((var18_17 = Optimizer.enabled(var1_1.mOptimizationLevel, var10_11)) != 0) {
            var13_14 /* !! */  = this.getMeasurer();
            Direct.solvingPass(var1_1, (BasicMeasure$Measurer)var13_14 /* !! */ );
            var13_14 /* !! */  = null;
            for (var18_17 = 0; var18_17 < var6_7; ++var18_17) {
                var19_18 = (ConstraintWidget)var1_1.mChildren.get(var18_17);
                var20_19 = (int)var19_18.isMeasureRequested();
                if (var20_19 == 0 || (var20_19 = var19_18 instanceof Guideline) != 0 || (var20_19 = var19_18 instanceof Barrier) != 0 || (var20_19 = var19_18 instanceof VirtualLayout) != 0 || (var20_19 = (int)var19_18.isInVirtualLayout()) != 0) continue;
                var21_20 /* !! */  = var19_18.getDimensionBehaviour(0);
                var22_21 /* !! */  = var19_18.getDimensionBehaviour(var10_11);
                var23_22 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                if (var21_20 /* !! */  == var23_22 /* !! */  && (var20_19 = var19_18.mMatchConstraintDefaultWidth) != var10_11 && var22_21 /* !! */  == var23_22 /* !! */  && (var20_19 = var19_18.mMatchConstraintDefaultHeight) != var10_11) {
                    var20_19 = var10_11;
                } else {
                    var20_19 = 0;
                    var21_20 /* !! */  = null;
                }
                if (var20_19 != 0) continue;
                var21_20 /* !! */  = new BasicMeasure$Measure();
                var22_21 /* !! */  = var1_1.mMeasurer;
                var24_23 = BasicMeasure$Measure.SELF_DIMENSIONS;
                ConstraintWidgetContainer.measure((ConstraintWidget)var19_18, (BasicMeasure$Measurer)var22_21 /* !! */ , (BasicMeasure$Measure)var21_20 /* !! */ , var24_23);
            }
        }
        if (var6_7 <= (var18_17 = 2) || var9_10 /* !! */  != (var19_18 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && var12_13 != var19_18) ** GOTO lbl-1000
        var20_19 = var1_1.mOptimizationLevel;
        var25_24 = 1024;
        if ((var20_19 = (int)Optimizer.enabled(var20_19, var25_24)) != 0 && (var20_19 = (int)Grouping.simpleSolvingPass(var1_1, var21_20 /* !! */  = this.getMeasurer())) != 0) {
            if (var9_10 /* !! */  == var19_18) {
                var20_19 = this.getWidth();
                if (var7_8 /* !! */  < var20_19 && var7_8 /* !! */  > 0) {
                    var1_1.setWidth(var7_8 /* !! */ );
                    var1_1.mWidthMeasuredTooSmall = var10_11;
                } else {
                    var7_8 /* !! */  = this.getWidth();
                }
            }
            if (var12_13 == var19_18) {
                var26_25 = this.getHeight();
                if (var8_9 < var26_25 && var8_9 > 0) {
                    var1_1.setHeight(var8_9);
                    var1_1.mHeightMeasuredTooSmall = var10_11;
                } else {
                    var8_9 = this.getHeight();
                }
            }
            var26_25 = var8_9;
            var8_9 = var7_8 /* !! */ ;
            var7_8 /* !! */  = var10_11;
            var27_26 = var11_12;
        } else lbl-1000:
        // 2 sources

        {
            var26_25 = var8_9;
            var8_9 = var7_8 /* !! */ ;
            var7_8 /* !! */  = 0;
            var5_5 /* !! */  = null;
            var27_26 = 0.0f;
        }
        var20_19 = 64;
        var25_24 = (int)var1_1.optimizeFor(var20_19);
        if (var25_24 == 0 && (var25_24 = (int)var1_1.optimizeFor(128)) == 0) {
            var25_24 = 0;
            var22_21 /* !! */  = null;
        } else {
            var25_24 = var10_11;
        }
        var23_22 /* !! */  = var1_1.mSystem;
        var23_22 /* !! */ .graphOptimizer = false;
        var23_22 /* !! */ .newgraphOptimizer = false;
        var28_27 = var1_1.mOptimizationLevel;
        if (var28_27 != 0 && var25_24 != 0) {
            var23_22 /* !! */ .newgraphOptimizer = var10_11;
        }
        var22_21 /* !! */  = var1_1.mChildren;
        var23_22 /* !! */  = this.getHorizontalDimensionBehaviour();
        if (var23_22 /* !! */  != (var29_28 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT) && (var23_22 /* !! */  = this.getVerticalDimensionBehaviour()) != var29_28) {
            var24_23 = 0;
            var23_22 /* !! */  = null;
        } else {
            var24_23 = var10_11;
        }
        this.resetChains();
        var29_28 = null;
        var30_29 = 0.0f;
        for (var28_27 = 0; var28_27 < var6_7; ++var28_27) {
            var31_30 /* !! */  = (ConstraintWidget)var1_1.mChildren.get(var28_27);
            var32_31 = var31_30 /* !! */  instanceof WidgetContainer;
            if (var32_31 == 0) continue;
            var31_30 /* !! */  = (WidgetContainer)var31_30 /* !! */ ;
            var31_30 /* !! */ .layout();
        }
        var20_19 = (int)var1_1.optimizeFor(var20_19);
        var28_27 = var7_8 /* !! */ ;
        var30_29 = var27_26;
        var7_8 /* !! */  = 0;
        var5_5 /* !! */  = null;
        var27_26 = 0.0f;
        var33_32 = var10_11;
        while (var33_32 != 0) {
            block88: {
                block87: {
                    var32_31 = var7_8 /* !! */  + 1;
                    var5_5 /* !! */  = var1_1.mSystem;
                    var5_5 /* !! */ .reset();
                    this.resetChains();
                    var5_5 /* !! */  = var1_1.mSystem;
                    var1_1.createObjectVariables((LinearSystem)var5_5 /* !! */ );
                    var5_5 /* !! */  = null;
                    var27_26 = 0.0f;
                    for (var7_8 /* !! */  = 0; var7_8 /* !! */  < var6_7; ++var7_8 /* !! */ ) {
                        var34_33 /* !! */  = var1_1.mChildren;
                        var34_33 /* !! */  = var34_33 /* !! */ .get(var7_8 /* !! */ );
                        var34_33 /* !! */  = (ConstraintWidget)var34_33 /* !! */ ;
                        var4_4 /* !! */  = var1_1.mSystem;
                        var34_33 /* !! */ .createObjectVariables((LinearSystem)var4_4 /* !! */ );
                        var2_2 = 0;
                        var3_3 = 0.0f;
                        var4_4 /* !! */  = null;
                        var10_11 = 1;
                        var11_12 = 1.4E-45f;
                        continue;
                    }
                    var5_5 /* !! */  = var1_1.mSystem;
                    var33_32 = (int)var1_1.addChildrenToSolver((LinearSystem)var5_5 /* !! */ );
                    var5_5 /* !! */  = var1_1.verticalWrapMin;
                    var2_2 = 0;
                    var3_3 = 0.0f;
                    var4_4 /* !! */  = null;
                    if (var5_5 /* !! */  == null) ** GOTO lbl171
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    if (var5_5 /* !! */  == null) ** GOTO lbl171
                    var5_5 /* !! */  = var1_1.verticalWrapMin;
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    var5_5 /* !! */  = (ConstraintAnchor)var5_5 /* !! */ ;
                    var34_33 /* !! */  = var1_1.mSystem;
                    var13_14 /* !! */  = var1_1.mTop;
                    var34_33 /* !! */  = var34_33 /* !! */ .createObjectVariable(var13_14 /* !! */ );
                    var1_1.addMinWrap((ConstraintAnchor)var5_5 /* !! */ , (SolverVariable)var34_33 /* !! */ );
                    var1_1.verticalWrapMin = null;
lbl171:
                    // 3 sources

                    if ((var5_5 /* !! */  = var1_1.verticalWrapMax) == null) ** GOTO lbl191
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    if (var5_5 /* !! */  == null) ** GOTO lbl191
                    var5_5 /* !! */  = var1_1.verticalWrapMax;
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    var5_5 /* !! */  = (ConstraintAnchor)var5_5 /* !! */ ;
                    var34_33 /* !! */  = var1_1.mSystem;
                    var13_14 /* !! */  = var1_1.mBottom;
                    var34_33 /* !! */  = var34_33 /* !! */ .createObjectVariable(var13_14 /* !! */ );
                    var1_1.addMaxWrap((ConstraintAnchor)var5_5 /* !! */ , (SolverVariable)var34_33 /* !! */ );
                    var1_1.verticalWrapMax = null;
lbl191:
                    // 3 sources

                    if ((var5_5 /* !! */  = var1_1.horizontalWrapMin) == null) ** GOTO lbl211
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    if (var5_5 /* !! */  == null) ** GOTO lbl211
                    var5_5 /* !! */  = var1_1.horizontalWrapMin;
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    var5_5 /* !! */  = (ConstraintAnchor)var5_5 /* !! */ ;
                    var34_33 /* !! */  = var1_1.mSystem;
                    var13_14 /* !! */  = var1_1.mLeft;
                    var34_33 /* !! */  = var34_33 /* !! */ .createObjectVariable(var13_14 /* !! */ );
                    var1_1.addMinWrap((ConstraintAnchor)var5_5 /* !! */ , (SolverVariable)var34_33 /* !! */ );
                    var1_1.horizontalWrapMin = null;
lbl211:
                    // 3 sources

                    if ((var5_5 /* !! */  = var1_1.horizontalWrapMax) == null) break block87;
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    if (var5_5 /* !! */  == null) break block87;
                    var5_5 /* !! */  = var1_1.horizontalWrapMax;
                    var5_5 /* !! */  = var5_5 /* !! */ .get();
                    var5_5 /* !! */  = (ConstraintAnchor)var5_5 /* !! */ ;
                    var34_33 /* !! */  = var1_1.mSystem;
                    var13_14 /* !! */  = var1_1.mRight;
                    var34_33 /* !! */  = var34_33 /* !! */ .createObjectVariable(var13_14 /* !! */ );
                    var1_1.addMaxWrap((ConstraintAnchor)var5_5 /* !! */ , (SolverVariable)var34_33 /* !! */ );
                    var1_1.horizontalWrapMax = null;
                }
                if (var33_32 == 0) break block88;
                var5_5 /* !! */  = var1_1.mSystem;
                try {
                    var5_5 /* !! */ .minimize();
                }
                catch (Exception var5_6) {
                    var5_6.printStackTrace();
                    var4_4 /* !! */  = System.out;
                    var34_33 /* !! */  = new StringBuilder();
                    var13_14 /* !! */  = "EXCEPTION : ";
                    var34_33 /* !! */ .append((String)var13_14 /* !! */ );
                    var34_33 /* !! */ .append(var5_6);
                    var5_5 /* !! */  = var34_33 /* !! */ .toString();
                    var4_4 /* !! */ .println((String)var5_5 /* !! */ );
                }
            }
            if (var33_32 != 0) {
                var5_5 /* !! */  = var1_1.mSystem;
                var4_4 /* !! */  = Optimizer.flags;
                var1_1.updateChildrenFromSolver((LinearSystem)var5_5 /* !! */ , (boolean[])var4_4 /* !! */ );
            } else {
                var5_5 /* !! */  = var1_1.mSystem;
                var1_1.updateFromSolver((LinearSystem)var5_5 /* !! */ , (boolean)var20_19);
                var27_26 = 0.0f;
                var5_5 /* !! */  = null;
                for (var7_8 /* !! */  = 0; var7_8 /* !! */  < var6_7; ++var7_8 /* !! */ ) {
                    var4_4 /* !! */  = (ConstraintWidget)var1_1.mChildren.get(var7_8 /* !! */ );
                    var34_33 /* !! */  = var1_1.mSystem;
                    var4_4 /* !! */ .updateFromSolver((LinearSystem)var34_33 /* !! */ , (boolean)var20_19);
                }
            }
            if (var24_23 == 0) ** GOTO lbl-1000
            var7_8 /* !! */  = 8;
            var27_26 = 1.1E-44f;
            if (var32_31 >= var7_8 /* !! */ ) ** GOTO lbl-1000
            var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])Optimizer.flags;
            var2_2 = 2;
            var3_3 = 2.8E-45f;
            var7_8 /* !! */  = (int)var5_5 /* !! */ [var2_2];
            if (var7_8 /* !! */  != 0) {
                var27_26 = 0.0f;
                var5_5 /* !! */  = null;
                var10_11 = 0;
                var11_12 = 0.0f;
                var34_33 /* !! */  = null;
                var18_17 = 0;
                var13_14 /* !! */  = null;
                for (var7_8 /* !! */  = 0; var7_8 /* !! */  < var6_7; ++var7_8 /* !! */ ) {
                    var31_30 /* !! */  = (ConstraintWidget)var1_1.mChildren.get(var7_8 /* !! */ );
                    var2_2 = var31_30 /* !! */ .mX;
                    var35_34 = var31_30 /* !! */ .getWidth();
                    var10_11 = Math.max(var10_11, var2_2 += var35_34);
                    var2_2 = var31_30 /* !! */ .mY;
                    var33_32 = var31_30 /* !! */ .getHeight();
                    var18_17 = Math.max(var18_17, var2_2 += var33_32);
                    var2_2 = 2;
                    var3_3 = 2.8E-45f;
                }
                var7_8 /* !! */  = Math.max(var1_1.mMinWidth, var10_11);
                var2_2 = Math.max(var1_1.mMinHeight, var18_17);
                var34_33 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                if (var9_10 /* !! */  == var34_33 /* !! */  && (var18_17 = this.getWidth()) < var7_8 /* !! */ ) {
                    var1_1.setWidth(var7_8 /* !! */ );
                    var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                    var18_17 = 0;
                    var13_14 /* !! */  = null;
                    var5_5 /* !! */ [0] = var34_33 /* !! */ ;
                    var7_8 /* !! */  = 1;
                    var27_26 = 1.4E-45f;
                    var28_27 = 1;
                    var30_29 = 1.4E-45f;
                } else {
                    var7_8 /* !! */  = 0;
                    var27_26 = 0.0f;
                    var5_5 /* !! */  = null;
                }
                if (var12_13 == var34_33 /* !! */  && (var18_17 = this.getHeight()) < var2_2) {
                    var1_1.setHeight(var2_2);
                    var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                    var2_2 = 1;
                    var3_3 = 1.4E-45f;
                    var5_5 /* !! */ [var2_2] = var34_33 /* !! */ ;
                    var7_8 /* !! */  = 1;
                    var27_26 = 1.4E-45f;
                    var28_27 = 1;
                    var30_29 = 1.4E-45f;
                }
            } else lbl-1000:
            // 3 sources

            {
                var7_8 /* !! */  = 0;
                var27_26 = 0.0f;
                var5_5 /* !! */  = null;
            }
            var2_2 = var1_1.mMinWidth;
            var10_11 = this.getWidth();
            if ((var2_2 = Math.max(var2_2, var10_11)) > (var10_11 = this.getWidth())) {
                var1_1.setWidth(var2_2);
                var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                var4_4 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                var10_11 = 0;
                var11_12 = 0.0f;
                var34_33 /* !! */  = null;
                var5_5 /* !! */ [0] = var4_4 /* !! */ ;
                var7_8 /* !! */  = 1;
                var27_26 = 1.4E-45f;
                var28_27 = 1;
                var30_29 = 1.4E-45f;
            }
            var2_2 = var1_1.mMinHeight;
            var10_11 = this.getHeight();
            if ((var2_2 = Math.max(var2_2, var10_11)) > (var10_11 = this.getHeight())) {
                var1_1.setHeight(var2_2);
                var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                var4_4 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                var10_11 = 1;
                var11_12 = 1.4E-45f;
                var5_5 /* !! */ [var10_11] = var4_4 /* !! */ ;
                var7_8 /* !! */  = var10_11;
                var27_26 = var11_12;
                var2_2 = var10_11;
                var3_3 = var11_12;
            } else {
                var10_11 = 1;
                var11_12 = 1.4E-45f;
                var2_2 = var28_27;
                var3_3 = var30_29;
            }
            if (var2_2 != 0) ** GOTO lbl-1000
            var13_14 /* !! */  = var1_1.mListDimensionBehaviors;
            var28_27 = 0;
            var30_29 = 0.0f;
            var29_28 = null;
            var31_30 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if ((var13_14 /* !! */  = var13_14 /* !! */ [0]) == var31_30 /* !! */  && var8_9 > 0 && (var18_17 = this.getWidth()) > var8_9) {
                var1_1.mWidthMeasuredTooSmall = var10_11;
                var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                var4_4 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                var5_5 /* !! */ [0] = var4_4 /* !! */ ;
                var1_1.setWidth(var8_9);
                var7_8 /* !! */  = var10_11;
                var27_26 = var11_12;
                var2_2 = var10_11;
                var3_3 = var11_12;
            }
            if ((var13_14 /* !! */  = var1_1.mListDimensionBehaviors[var10_11]) == var31_30 /* !! */  && var26_25 > 0 && (var18_17 = this.getHeight()) > var26_25) {
                var1_1.mHeightMeasuredTooSmall = var10_11;
                var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
                var4_4 /* !! */  = ConstraintWidget$DimensionBehaviour.FIXED;
                var5_5 /* !! */ [var10_11] = var4_4 /* !! */ ;
                var1_1.setHeight(var26_25);
                var28_27 = 1;
                var30_29 = 1.4E-45f;
                var33_32 = 1;
            } else lbl-1000:
            // 2 sources

            {
                var33_32 = var7_8 /* !! */ ;
                var28_27 = var2_2;
                var30_29 = var3_3;
            }
            var7_8 /* !! */  = var32_31;
            var2_2 = 0;
            var3_3 = 0.0f;
            var4_4 /* !! */  = null;
            var10_11 = 1;
            var11_12 = 1.4E-45f;
            var18_17 = 2;
        }
        var1_1.mChildren = var22_21 /* !! */ ;
        if (var28_27 != 0) {
            var5_5 /* !! */  = var1_1.mListDimensionBehaviors;
            var4_4 /* !! */  = null;
            var5_5 /* !! */ [0] = var9_10 /* !! */ ;
            var2_2 = 1;
            var3_3 = 1.4E-45f;
            var5_5 /* !! */ [var2_2] = var12_13;
        }
        var5_5 /* !! */  = var1_1.mSystem.getCache();
        var1_1.resetSolverVariables((Cache)var5_5 /* !! */ );
    }

    public long measure(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18) {
        this.mPaddingLeft = n17;
        this.mPaddingTop = n18;
        return this.mBasicMeasureSolver.solverMeasure(this, n10, n17, n18, n11, n12, n13, n14, n15, n16);
    }

    public boolean optimizeFor(int n10) {
        int n11 = this.mOptimizationLevel & n10;
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public void reset() {
        this.mSystem.reset();
        this.mPaddingLeft = 0;
        this.mPaddingRight = 0;
        this.mPaddingTop = 0;
        this.mPaddingBottom = 0;
        this.mSkipSolver = false;
        super.reset();
    }

    public void setMeasurer(BasicMeasure$Measurer basicMeasure$Measurer) {
        this.mMeasurer = basicMeasure$Measurer;
        this.mDependencyGraph.setMeasurer(basicMeasure$Measurer);
    }

    public void setOptimizationLevel(int n10) {
        this.mOptimizationLevel = n10;
        LinearSystem.USE_DEPENDENCY_ORDERING = this.optimizeFor(512);
    }

    public void setPadding(int n10, int n11, int n12, int n13) {
        this.mPaddingLeft = n10;
        this.mPaddingTop = n11;
        this.mPaddingRight = n12;
        this.mPaddingBottom = n13;
    }

    public void setRtl(boolean bl2) {
        this.mIsRtl = bl2;
    }

    public void updateChildrenFromSolver(LinearSystem linearSystem, boolean[] blArray) {
        blArray[2] = false;
        boolean bl2 = this.optimizeFor(64);
        this.updateFromSolver(linearSystem, bl2);
        ArrayList arrayList = this.mChildren;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            constraintWidget.updateFromSolver(linearSystem, bl2);
        }
    }

    public void updateFromRuns(boolean bl2, boolean bl3) {
        super.updateFromRuns(bl2, bl3);
        ArrayList arrayList = this.mChildren;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintWidget constraintWidget = (ConstraintWidget)this.mChildren.get(i10);
            constraintWidget.updateFromRuns(bl2, bl3);
        }
    }

    public void updateHierarchy() {
        this.mBasicMeasureSolver.updateHierarchy(this);
    }
}

