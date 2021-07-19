/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$1;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    public static final int DIMENSION_HORIZONTAL = 0;
    public static final int DIMENSION_VERTICAL = 1;
    public static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int SOLVER = 1;
    public static final int UNKNOWN = 255;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = 254;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    public ArrayList mAnchors;
    public ConstraintAnchor mBaseline;
    public int mBaselineDistance;
    public ConstraintAnchor mBottom;
    public boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    public ConstraintAnchor mCenterX;
    public ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    public int mDimensionRatioSide;
    public int mDistToBottom;
    public int mDistToLeft;
    public int mDistToRight;
    public int mDistToTop;
    public boolean mGroupsToSolver;
    public int mHeight;
    public float mHorizontalBiasPercent;
    public boolean mHorizontalChainFixedPosition;
    public int mHorizontalChainStyle;
    public ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    public boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    public boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public ConstraintWidget$DimensionBehaviour[] mListDimensionBehaviors;
    public ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    public int mMinHeight;
    public int mMinWidth;
    public ConstraintWidget[] mNextChainWidget;
    public int mOffsetX;
    public int mOffsetY;
    public ConstraintWidget mParent;
    public int mRelX;
    public int mRelY;
    public float mResolvedDimensionRatio;
    public int mResolvedDimensionRatioSide;
    public boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    public boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    public boolean mTopHasCentered;
    private String mType;
    public float mVerticalBiasPercent;
    public boolean mVerticalChainFixedPosition;
    public int mVerticalChainStyle;
    public ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    public boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    public int mWidth;
    public int mX;
    public int mY;
    public boolean measured = false;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    public ConstraintWidget() {
        ConstraintAnchor constraintAnchor;
        float f10;
        int n10;
        int n11 = 2;
        WidgetRun[] widgetRunArray = new WidgetRun[n11];
        this.run = widgetRunArray;
        this.horizontalRun = null;
        this.verticalRun = null;
        boolean[] blArray = new boolean[n11];
        blArray[0] = true;
        blArray[1] = true;
        this.isTerminalWidget = blArray;
        this.mResolvedHasRatio = false;
        int n12 = 1;
        this.mMeasureRequested = n12;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = n12;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = n10 = -1;
        this.mVerticalResolution = n10;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        Object[] objectArray = new int[n11];
        this.mResolvedMatchConstraintDefault = objectArray;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = f10 = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = f10;
        this.mResolvedDimensionRatioSide = n10;
        this.mResolvedDimensionRatio = f10;
        objectArray = new int[n11];
        objectArray[0] = -1 >>> 1;
        objectArray[1] = -1 >>> 1;
        this.mMaxDimension = objectArray;
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        Object object = ConstraintAnchor$Type.LEFT;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mLeft = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.TOP;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mTop = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.RIGHT;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mRight = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BOTTOM;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBottom = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BASELINE;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBaseline = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_X;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterX = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_Y;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterY = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenter = constraintWidget$DimensionBehaviourArray;
        object = new ConstraintAnchor[6];
        object[0] = constraintAnchor = this.mLeft;
        object[n12] = constraintAnchor = this.mRight;
        object[n11] = constraintAnchor = this.mTop;
        object[3] = constraintAnchor = this.mBottom;
        object[4] = constraintAnchor = this.mBaseline;
        object[5] = constraintWidget$DimensionBehaviourArray;
        this.mListAnchors = object;
        constraintWidget$DimensionBehaviourArray = new ArrayList();
        this.mAnchors = constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = (ConstraintWidget$DimensionBehaviour[])new boolean[n11];
        this.mIsInBarrier = (boolean[])constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = new ConstraintWidget$DimensionBehaviour[n11];
        constraintWidget$DimensionBehaviourArray[0] = object = ConstraintWidget$DimensionBehaviour.FIXED;
        constraintWidget$DimensionBehaviourArray[n12] = object;
        this.mListDimensionBehaviors = constraintWidget$DimensionBehaviourArray;
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = n10;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f10 = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        objectArray = new float[n11];
        objectArray[0] = (int)-1.0f;
        objectArray[1] = (int)-1.0f;
        this.mWeight = objectArray;
        objectArray = new ConstraintWidget[n11];
        objectArray[0] = (int)null;
        objectArray[n12] = (int)null;
        this.mListNextMatchConstraintsWidget = (ConstraintWidget[])objectArray;
        ConstraintWidget[] constraintWidgetArray = new ConstraintWidget[n11];
        constraintWidgetArray[0] = null;
        constraintWidgetArray[n12] = null;
        this.mNextChainWidget = constraintWidgetArray;
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = n10;
        this.verticalGroup = n10;
        this.addAnchors();
    }

    public ConstraintWidget(int n10, int n11) {
        this(0, 0, n10, n11);
    }

    public ConstraintWidget(int n10, int n11, int n12, int n13) {
        ConstraintAnchor constraintAnchor;
        float f10;
        int n14;
        int n15 = 2;
        WidgetRun[] widgetRunArray = new WidgetRun[n15];
        this.run = widgetRunArray;
        this.horizontalRun = null;
        this.verticalRun = null;
        boolean[] blArray = new boolean[n15];
        blArray[0] = true;
        blArray[1] = true;
        this.isTerminalWidget = blArray;
        this.mResolvedHasRatio = false;
        int n16 = 1;
        this.mMeasureRequested = n16;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = n16;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = n14 = -1;
        this.mVerticalResolution = n14;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        Object[] objectArray = new int[n15];
        this.mResolvedMatchConstraintDefault = objectArray;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = f10 = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = f10;
        this.mResolvedDimensionRatioSide = n14;
        this.mResolvedDimensionRatio = f10;
        objectArray = new int[n15];
        objectArray[0] = -1 >>> 1;
        objectArray[1] = -1 >>> 1;
        this.mMaxDimension = objectArray;
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        Object object = ConstraintAnchor$Type.LEFT;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mLeft = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.TOP;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mTop = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.RIGHT;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mRight = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BOTTOM;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBottom = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BASELINE;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBaseline = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_X;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterX = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_Y;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterY = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenter = constraintWidget$DimensionBehaviourArray;
        object = new ConstraintAnchor[6];
        object[0] = constraintAnchor = this.mLeft;
        object[n16] = constraintAnchor = this.mRight;
        object[n15] = constraintAnchor = this.mTop;
        object[3] = constraintAnchor = this.mBottom;
        object[4] = constraintAnchor = this.mBaseline;
        object[5] = constraintWidget$DimensionBehaviourArray;
        this.mListAnchors = object;
        constraintWidget$DimensionBehaviourArray = new ArrayList();
        this.mAnchors = constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = (ConstraintWidget$DimensionBehaviour[])new boolean[n15];
        this.mIsInBarrier = (boolean[])constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = new ConstraintWidget$DimensionBehaviour[n15];
        constraintWidget$DimensionBehaviourArray[0] = object = ConstraintWidget$DimensionBehaviour.FIXED;
        constraintWidget$DimensionBehaviourArray[n16] = object;
        this.mListDimensionBehaviors = constraintWidget$DimensionBehaviourArray;
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = n14;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f10 = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        objectArray = new float[n15];
        objectArray[0] = (int)-1.0f;
        objectArray[1] = (int)-1.0f;
        this.mWeight = objectArray;
        objectArray = new ConstraintWidget[n15];
        objectArray[0] = (int)null;
        objectArray[n16] = (int)null;
        this.mListNextMatchConstraintsWidget = (ConstraintWidget[])objectArray;
        ConstraintWidget[] constraintWidgetArray = new ConstraintWidget[n15];
        constraintWidgetArray[0] = null;
        constraintWidgetArray[n16] = null;
        this.mNextChainWidget = constraintWidgetArray;
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = n14;
        this.verticalGroup = n14;
        this.mX = n10;
        this.mY = n11;
        this.mWidth = n12;
        this.mHeight = n13;
        this.addAnchors();
    }

    public ConstraintWidget(String string2) {
        ConstraintAnchor constraintAnchor;
        float f10;
        int n10;
        int n11 = 2;
        WidgetRun[] widgetRunArray = new WidgetRun[n11];
        this.run = widgetRunArray;
        this.horizontalRun = null;
        this.verticalRun = null;
        boolean[] blArray = new boolean[n11];
        blArray[0] = true;
        blArray[1] = true;
        this.isTerminalWidget = blArray;
        this.mResolvedHasRatio = false;
        int n12 = 1;
        this.mMeasureRequested = n12;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = n12;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = n10 = -1;
        this.mVerticalResolution = n10;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        Object[] objectArray = new int[n11];
        this.mResolvedMatchConstraintDefault = objectArray;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = f10 = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = f10;
        this.mResolvedDimensionRatioSide = n10;
        this.mResolvedDimensionRatio = f10;
        objectArray = new int[n11];
        objectArray[0] = -1 >>> 1;
        objectArray[1] = -1 >>> 1;
        this.mMaxDimension = objectArray;
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        Object object = ConstraintAnchor$Type.LEFT;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mLeft = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.TOP;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mTop = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.RIGHT;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mRight = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BOTTOM;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBottom = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.BASELINE;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mBaseline = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_X;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterX = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER_Y;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenterY = constraintWidget$DimensionBehaviourArray;
        object = ConstraintAnchor$Type.CENTER;
        constraintWidget$DimensionBehaviourArray = new ConstraintAnchor(this, (ConstraintAnchor$Type)((Object)object));
        this.mCenter = constraintWidget$DimensionBehaviourArray;
        object = new ConstraintAnchor[6];
        object[0] = constraintAnchor = this.mLeft;
        object[n12] = constraintAnchor = this.mRight;
        object[n11] = constraintAnchor = this.mTop;
        object[3] = constraintAnchor = this.mBottom;
        object[4] = constraintAnchor = this.mBaseline;
        object[5] = constraintWidget$DimensionBehaviourArray;
        this.mListAnchors = object;
        constraintWidget$DimensionBehaviourArray = new ArrayList();
        this.mAnchors = constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = (ConstraintWidget$DimensionBehaviour[])new boolean[n11];
        this.mIsInBarrier = (boolean[])constraintWidget$DimensionBehaviourArray;
        constraintWidget$DimensionBehaviourArray = new ConstraintWidget$DimensionBehaviour[n11];
        constraintWidget$DimensionBehaviourArray[0] = object = ConstraintWidget$DimensionBehaviour.FIXED;
        constraintWidget$DimensionBehaviourArray[n12] = object;
        this.mListDimensionBehaviors = constraintWidget$DimensionBehaviourArray;
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = n10;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mHorizontalBiasPercent = f10 = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f10;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        objectArray = new float[n11];
        objectArray[0] = (int)-1.0f;
        objectArray[1] = (int)-1.0f;
        this.mWeight = objectArray;
        objectArray = new ConstraintWidget[n11];
        objectArray[0] = (int)null;
        objectArray[n12] = (int)null;
        this.mListNextMatchConstraintsWidget = (ConstraintWidget[])objectArray;
        ConstraintWidget[] constraintWidgetArray = new ConstraintWidget[n11];
        constraintWidgetArray[0] = null;
        constraintWidgetArray[n12] = null;
        this.mNextChainWidget = constraintWidgetArray;
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = n10;
        this.verticalGroup = n10;
        this.addAnchors();
        this.setDebugName(string2);
    }

    public ConstraintWidget(String string2, int n10, int n11) {
        this(n10, n11);
        this.setDebugName(string2);
    }

    public ConstraintWidget(String string2, int n10, int n11, int n12, int n13) {
        this(n10, n11, n12, n13);
        this.setDebugName(string2);
    }

    private void addAnchors() {
        ArrayList arrayList = this.mAnchors;
        ConstraintAnchor constraintAnchor = this.mLeft;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mTop;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mRight;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mBottom;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mCenterX;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mCenterY;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mCenter;
        arrayList.add(constraintAnchor);
        arrayList = this.mAnchors;
        constraintAnchor = this.mBaseline;
        arrayList.add(constraintAnchor);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void applyConstraints(LinearSystem var1_1, boolean var2_2, boolean var3_3, boolean var4_4, boolean var5_5, SolverVariable var6_6, SolverVariable var7_7, ConstraintWidget$DimensionBehaviour var8_8, boolean var9_9, ConstraintAnchor var10_10, ConstraintAnchor var11_11, int var12_12, int var13_13, int var14_14, int var15_15, float var16_16, boolean var17_17, boolean var18_18, boolean var19_19, boolean var20_20, boolean var21_21, int var22_22, int var23_23, int var24_24, int var25_25, float var26_26, boolean var27_27) {
        block130: {
            block132: {
                block131: {
                    block114: {
                        block112: {
                            block129: {
                                block105: {
                                    block116: {
                                        block128: {
                                            block127: {
                                                block106: {
                                                    block122: {
                                                        block125: {
                                                            block126: {
                                                                block117: {
                                                                    block119: {
                                                                        block123: {
                                                                            block124: {
                                                                                block121: {
                                                                                    block120: {
                                                                                        block118: {
                                                                                            block115: {
                                                                                                block113: {
                                                                                                    block104: {
                                                                                                        block111: {
                                                                                                            block110: {
                                                                                                                block109: {
                                                                                                                    block107: {
                                                                                                                        block108: {
                                                                                                                            var28_28 = this;
                                                                                                                            var29_29 = var1_1;
                                                                                                                            var30_30 = var6_6;
                                                                                                                            var31_31 = var7_7;
                                                                                                                            var32_32 = var10_10;
                                                                                                                            var33_33 = var11_11;
                                                                                                                            var34_34 = var14_14;
                                                                                                                            var35_35 = var15_15;
                                                                                                                            var36_36 = var23_23;
                                                                                                                            var37_37 = var24_24;
                                                                                                                            var38_38 = var25_25;
                                                                                                                            var39_39 = var1_1.createObjectVariable(var10_10);
                                                                                                                            var40_40 = var1_1.createObjectVariable(var11_11);
                                                                                                                            var41_41 /* !! */  = var10_10.getTarget();
                                                                                                                            var42_42 = var1_1.createObjectVariable(var41_41 /* !! */ );
                                                                                                                            var41_41 /* !! */  = var11_11.getTarget();
                                                                                                                            var43_43 /* !! */  = var1_1.createObjectVariable(var41_41 /* !! */ );
                                                                                                                            var41_41 /* !! */  = LinearSystem.getMetrics();
                                                                                                                            if (var41_41 /* !! */  != null) {
                                                                                                                                var41_41 /* !! */  = LinearSystem.getMetrics();
                                                                                                                                var44_44 = var41_41 /* !! */ .nonresolvedWidgets;
                                                                                                                                var46_45 = 1L;
                                                                                                                                var41_41 /* !! */ .nonresolvedWidgets = var44_44 += var46_45;
                                                                                                                            }
                                                                                                                            var48_46 = var10_10.isConnected();
                                                                                                                            var49_47 = var11_11.isConnected();
                                                                                                                            var41_41 /* !! */  = var28_28.mCenter;
                                                                                                                            var50_48 = var41_41 /* !! */ .isConnected();
                                                                                                                            var51_49 = var49_47 != 0 ? var48_46 + 1 : var48_46;
                                                                                                                            if (var50_48 != 0) {
                                                                                                                                ++var51_49;
                                                                                                                            }
                                                                                                                            var52_50 = var17_17 != false ? 3 : var22_22;
                                                                                                                            var53_51 = ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour;
                                                                                                                            var54_52 = var8_8.ordinal();
                                                                                                                            var36_36 = var53_51[var54_52];
                                                                                                                            var55_53 = 1;
                                                                                                                            if (var36_36 == var55_53 || var36_36 == (var55_53 = 2) || var36_36 == (var55_53 = 3) || var36_36 != (var55_53 = 4)) {
                                                                                                                                var36_36 = var52_50;
                                                                                                                                while (true) {
                                                                                                                                    var52_50 = 0;
                                                                                                                                    var56_54 = null;
                                                                                                                                    break;
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                var36_36 = var52_50;
                                                                                                                                if (var52_50 == var55_53) ** continue;
                                                                                                                                var52_50 = 1;
                                                                                                                            }
                                                                                                                            var55_53 = var28_28.mVisibility;
                                                                                                                            var57_55 = 8;
                                                                                                                            var58_56 = 1.1E-44f;
                                                                                                                            if (var55_53 == var57_55) {
                                                                                                                                var55_53 = 0;
                                                                                                                                var33_33 = null;
                                                                                                                                var52_50 = 0;
                                                                                                                                var56_54 = null;
                                                                                                                            } else {
                                                                                                                                var55_53 = var13_13;
                                                                                                                            }
                                                                                                                            if (!var27_27) break block107;
                                                                                                                            if (var48_46 != 0 || var49_47 != 0 || var50_48 != 0) break block108;
                                                                                                                            var57_55 = var12_12;
                                                                                                                            var29_29.addEquality(var39_39, var12_12);
                                                                                                                            ** GOTO lbl-1000
                                                                                                                        }
                                                                                                                        if (var48_46 != 0 && var49_47 == 0) {
                                                                                                                            var57_55 = var10_10.getMargin();
                                                                                                                            var59_57 = var43_43 /* !! */ ;
                                                                                                                            var60_58 = 8;
                                                                                                                            var61_59 = 1.1E-44f;
                                                                                                                            var29_29.addEquality(var39_39, (SolverVariable)var42_42, var57_55, var60_58);
                                                                                                                        } else lbl-1000:
                                                                                                                        // 2 sources

                                                                                                                        {
                                                                                                                            var59_57 = var43_43 /* !! */ ;
                                                                                                                            var60_58 = 8;
                                                                                                                            var61_59 = 1.1E-44f;
                                                                                                                        }
                                                                                                                        break block109;
                                                                                                                    }
                                                                                                                    var59_57 = var43_43 /* !! */ ;
                                                                                                                    var60_58 = var57_55;
                                                                                                                    var61_59 = var58_56;
                                                                                                                }
                                                                                                                if (var52_50 == 0) {
                                                                                                                    if (var9_9) {
                                                                                                                        var60_58 = 0;
                                                                                                                        var61_59 = 0.0f;
                                                                                                                        var43_43 /* !! */  = null;
                                                                                                                        var29_29.addEquality(var40_40, var39_39, 0, 3);
                                                                                                                        var57_55 = 8;
                                                                                                                        var58_56 = 1.1E-44f;
                                                                                                                        if (var34_34 > 0) {
                                                                                                                            var29_29.addGreaterThan(var40_40, var39_39, var34_34, var57_55);
                                                                                                                        }
                                                                                                                        if (var35_35 < (var55_53 = -1 >>> 1)) {
                                                                                                                            var29_29.addLowerThan(var40_40, var39_39, var35_35, var57_55);
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        var57_55 = var60_58;
                                                                                                                        var58_56 = var61_59;
                                                                                                                        var60_58 = 0;
                                                                                                                        var61_59 = 0.0f;
                                                                                                                        var43_43 /* !! */  = null;
                                                                                                                        var29_29.addEquality(var40_40, var39_39, var55_53, var57_55);
                                                                                                                    }
                                                                                                                    var62_60 = var37_37;
                                                                                                                    var35_35 = var38_38;
                                                                                                                    var54_52 = 0;
                                                                                                                    var33_33 = var42_42;
                                                                                                                    var63_61 = var40_40;
lbl104:
                                                                                                                    // 2 sources

                                                                                                                    while (true) {
                                                                                                                        var64_65 = var52_50;
                                                                                                                        var32_32 = var59_57;
                                                                                                                        var52_50 = (int)var5_5;
lbl108:
                                                                                                                        // 2 sources

                                                                                                                        while (true) {
                                                                                                                            var65_66 = var51_49;
                                                                                                                            break block104;
                                                                                                                            break;
                                                                                                                        }
                                                                                                                        break;
                                                                                                                    }
                                                                                                                }
                                                                                                                var35_35 = 2;
                                                                                                                var66_62 = 2.8E-45f;
                                                                                                                var60_58 = 0;
                                                                                                                var61_59 = 0.0f;
                                                                                                                var43_43 /* !! */  = null;
                                                                                                                if (var51_49 != var35_35 && !var17_17) {
                                                                                                                    var35_35 = 1;
                                                                                                                    var66_62 = 1.4E-45f;
                                                                                                                    if (var36_36 == var35_35 || var36_36 == 0) {
                                                                                                                        var35_35 = Math.max(var37_37, var55_53);
                                                                                                                        if (var38_38 > 0) {
                                                                                                                            var35_35 = Math.min(var38_38, var35_35);
                                                                                                                        }
                                                                                                                        var57_55 = 8;
                                                                                                                        var58_56 = 1.1E-44f;
                                                                                                                        var29_29.addEquality(var40_40, var39_39, var35_35, var57_55);
                                                                                                                        var52_50 = (int)var5_5;
                                                                                                                        var62_60 = var37_37;
                                                                                                                        var35_35 = var38_38;
                                                                                                                        var54_52 = 0;
                                                                                                                        var64_65 = 0;
                                                                                                                        var33_33 = var42_42;
                                                                                                                        var63_61 = var40_40;
                                                                                                                        var32_32 = var59_57;
                                                                                                                        ** continue;
                                                                                                                    }
                                                                                                                }
                                                                                                                var35_35 = -2;
                                                                                                                var66_62 = 0.0f / 0.0f;
                                                                                                                var57_55 = var37_37 == var35_35 ? var55_53 : var37_37;
                                                                                                                var35_35 = var38_38 == var35_35 ? var55_53 : var38_38;
                                                                                                                if (var55_53 > 0) {
                                                                                                                    var37_37 = 1;
                                                                                                                    var67_63 = 1.4E-45f;
                                                                                                                    if (var36_36 != var37_37) {
                                                                                                                        var55_53 = 0;
                                                                                                                        var33_33 = null;
                                                                                                                    }
                                                                                                                }
                                                                                                                if (var57_55 > 0) {
                                                                                                                    var37_37 = 8;
                                                                                                                    var67_63 = 1.1E-44f;
                                                                                                                    var29_29.addGreaterThan(var40_40, var39_39, var57_55, var37_37);
                                                                                                                    var55_53 = Math.max(var55_53, var57_55);
                                                                                                                }
                                                                                                                if (var35_35 <= 0) break block110;
                                                                                                                if (var3_3 == 0) ** GOTO lbl-1000
                                                                                                                var37_37 = 1;
                                                                                                                var67_63 = 1.4E-45f;
                                                                                                                if (var36_36 == var37_37) {
                                                                                                                    var37_37 = 0;
                                                                                                                    var68_64 /* !! */  = null;
                                                                                                                    var67_63 = 0.0f;
                                                                                                                } else lbl-1000:
                                                                                                                // 2 sources

                                                                                                                {
                                                                                                                    var37_37 = 1;
                                                                                                                    var67_63 = 1.4E-45f;
                                                                                                                }
                                                                                                                if (var37_37 != 0) {
                                                                                                                    var37_37 = 8;
                                                                                                                    var67_63 = 1.1E-44f;
                                                                                                                    var29_29.addLowerThan(var40_40, var39_39, var35_35, var37_37);
                                                                                                                } else {
                                                                                                                    var37_37 = 8;
                                                                                                                    var67_63 = 1.1E-44f;
                                                                                                                }
                                                                                                                var55_53 = Math.min(var55_53, var35_35);
                                                                                                                break block111;
                                                                                                            }
                                                                                                            var37_37 = 8;
                                                                                                            var67_63 = 1.1E-44f;
                                                                                                        }
                                                                                                        var38_38 = 1;
                                                                                                        if (var36_36 == var38_38) {
                                                                                                            if (var3_3 != 0) {
                                                                                                                var29_29.addEquality(var40_40, var39_39, var55_53, var37_37);
                                                                                                            } else if (var19_19) {
                                                                                                                var38_38 = 5;
                                                                                                                var29_29.addEquality(var40_40, var39_39, var55_53, var38_38);
                                                                                                                var29_29.addLowerThan(var40_40, var39_39, var55_53, var37_37);
                                                                                                            } else {
                                                                                                                var38_38 = 5;
                                                                                                                var29_29.addEquality(var40_40, var39_39, var55_53, var38_38);
                                                                                                                var29_29.addLowerThan(var40_40, var39_39, var55_53, var37_37);
                                                                                                            }
                                                                                                            var54_52 = 0;
                                                                                                            var33_33 = var42_42;
                                                                                                            var63_61 = var40_40;
                                                                                                            var62_60 = var57_55;
                                                                                                            ** continue;
                                                                                                        }
                                                                                                        var55_53 = 2;
                                                                                                        if (var36_36 == var55_53) {
                                                                                                            var68_64 /* !! */  = var10_10.getType();
                                                                                                            if (var68_64 /* !! */  != (var69_67 = ConstraintAnchor$Type.TOP) && (var68_64 /* !! */  = var10_10.getType()) != (var43_43 /* !! */  = ConstraintAnchor$Type.BOTTOM)) {
                                                                                                                var68_64 /* !! */  = var28_28.mParent;
                                                                                                                var69_67 = ConstraintAnchor$Type.LEFT;
                                                                                                                var68_64 /* !! */  = var68_64 /* !! */ .getAnchor((ConstraintAnchor$Type)var69_67);
                                                                                                                var68_64 /* !! */  = var29_29.createObjectVariable((Object)var68_64 /* !! */ );
                                                                                                                var69_67 = var28_28.mParent;
                                                                                                                var43_43 /* !! */  = ConstraintAnchor$Type.RIGHT;
                                                                                                                var69_67 = var69_67.getAnchor((ConstraintAnchor$Type)var43_43 /* !! */ );
                                                                                                                var69_67 = var29_29.createObjectVariable(var69_67);
                                                                                                            } else {
                                                                                                                var68_64 /* !! */  = var28_28.mParent.getAnchor((ConstraintAnchor$Type)var69_67);
                                                                                                                var68_64 /* !! */  = var29_29.createObjectVariable((Object)var68_64 /* !! */ );
                                                                                                                var69_67 = var28_28.mParent;
                                                                                                                var43_43 /* !! */  = ConstraintAnchor$Type.BOTTOM;
                                                                                                                var69_67 = var69_67.getAnchor((ConstraintAnchor$Type)var43_43 /* !! */ );
                                                                                                                var69_67 = var29_29.createObjectVariable(var69_67);
                                                                                                            }
                                                                                                            var56_54 = var68_64 /* !! */ ;
                                                                                                            var43_43 /* !! */  = var69_67;
                                                                                                            var68_64 /* !! */  = var1_1.createRow();
                                                                                                            var69_67 = var40_40;
                                                                                                            var55_53 = var51_49;
                                                                                                            var41_41 /* !! */  = var39_39;
                                                                                                            var9_9 = var57_55;
                                                                                                            var32_32 = var59_57;
                                                                                                            var54_52 = 0;
                                                                                                            var65_66 = var51_49;
                                                                                                            var33_33 = var42_42;
                                                                                                            var42_42 = var56_54;
                                                                                                            var63_61 = var40_40;
                                                                                                            var68_64 /* !! */  = var68_64 /* !! */ .createRowDimensionRatio(var40_40, var39_39, var43_43 /* !! */ , (SolverVariable)var56_54, var26_26);
                                                                                                            var29_29.addConstraint((ArrayRow)var68_64 /* !! */ );
                                                                                                            var52_50 = (int)var5_5;
                                                                                                            var62_60 = var57_55;
                                                                                                            var64_65 = 0;
                                                                                                        } else {
                                                                                                            var54_52 = 0;
                                                                                                            var33_33 = var42_42;
                                                                                                            var63_61 = var40_40;
                                                                                                            var9_9 = var57_55;
                                                                                                            var32_32 = var59_57;
                                                                                                            var65_66 = var51_49;
                                                                                                            var62_60 = var57_55;
                                                                                                            var64_65 = var52_50;
                                                                                                            var52_50 = 1;
                                                                                                        }
                                                                                                    }
                                                                                                    if (!var27_27) break block112;
                                                                                                    if (!var19_19) break block113;
                                                                                                    var70_68 /* !! */  = var6_6;
                                                                                                    var69_67 = var7_7;
                                                                                                    var71_71 = var63_61;
                                                                                                    var37_37 = 0;
                                                                                                    var68_64 /* !! */  = null;
                                                                                                    var67_63 = 0.0f;
                                                                                                    var51_49 = var65_66;
                                                                                                    var60_58 = 2;
                                                                                                    var61_59 = 2.8E-45f;
                                                                                                    var63_61 = var39_39;
                                                                                                    break block114;
                                                                                                }
                                                                                                if (var48_46 == 0 && var49_47 == 0 && var50_48 == 0 || var48_46 != 0 && var49_47 == 0) lbl-1000:
                                                                                                // 2 sources

                                                                                                {
                                                                                                    while (true) {
                                                                                                        var71_72 = var63_61;
                                                                                                        var37_37 = 0;
                                                                                                        var68_64 /* !! */  = null;
                                                                                                        var67_63 = 0.0f;
                                                                                                        break block105;
                                                                                                        break;
                                                                                                    }
                                                                                                }
                                                                                                if (var48_46 != 0 || var49_47 == 0) break block115;
                                                                                                var35_35 = -var11_11.getMargin();
                                                                                                var36_36 = 8;
                                                                                                var29_29.addEquality(var63_61, (SolverVariable)var32_32, var35_35, var36_36);
                                                                                                ** while (var3_3 == 0)
lbl271:
                                                                                                // 1 sources

                                                                                                var35_35 = (int)var28_28.OPTIMIZE_WRAP;
                                                                                                if (var35_35 != 0 && (var35_35 = (int)var39_39.isFinalValue) != 0 && (var70_69 = var28_28.mParent) != null) {
                                                                                                    var70_69 = (ConstraintWidgetContainer)var70_69;
                                                                                                    if (var2_2) {
                                                                                                        var42_42 = var10_10;
                                                                                                        var72_73 = false;
                                                                                                        var40_40 = null;
                                                                                                        var70_69.addHorizontalWrapMinVariable(var10_10);
                                                                                                    } else {
                                                                                                        var42_42 = var10_10;
                                                                                                        var72_74 = false;
                                                                                                        var40_40 = null;
                                                                                                        var70_69.addVerticalWrapMinVariable(var10_10);
                                                                                                    }
                                                                                                } else {
                                                                                                    var72_75 = false;
                                                                                                    var40_40 = null;
                                                                                                    var43_43 /* !! */  = var6_6;
                                                                                                    var35_35 = 5;
                                                                                                    var66_62 = 7.0E-45f;
                                                                                                    var29_29.addGreaterThan(var39_39, var6_6, 0, var35_35);
                                                                                                }
                                                                                                break block116;
                                                                                            }
                                                                                            var43_43 /* !! */  = var6_6;
                                                                                            var42_42 = var10_10;
                                                                                            var72_76 = 0;
                                                                                            var40_40 = null;
                                                                                            if (var48_46 == 0 || var49_47 == 0) break block116;
                                                                                            var68_64 /* !! */  = var10_10.mTarget;
                                                                                            var30_30 = var68_64 /* !! */ .mOwner;
                                                                                            var31_31 = var11_11;
                                                                                            var37_37 = 2;
                                                                                            var67_63 = 2.8E-45f;
                                                                                            var41_41 /* !! */  = var11_11.mTarget.mOwner;
                                                                                            var69_67 = this.getParent();
                                                                                            var50_48 = 6;
                                                                                            var73_77 = 8.4E-45f;
                                                                                            if (var64_65 == 0) break block117;
                                                                                            if (var36_36 != 0) break block118;
                                                                                            if (var35_35 == 0 && var62_60 == 0) {
                                                                                                var35_35 = (int)var33_33.isFinalValue;
                                                                                                if (var35_35 != 0 && (var35_35 = (int)var32_32.isFinalValue) != 0) {
                                                                                                    var35_35 = var10_10.getMargin();
                                                                                                    var36_36 = 8;
                                                                                                    var29_29.addEquality(var39_39, (SolverVariable)var33_33, var35_35, var36_36);
                                                                                                    var35_35 = -var11_11.getMargin();
                                                                                                    var29_29.addEquality(var63_61, (SolverVariable)var32_32, var35_35, var36_36);
                                                                                                    return;
                                                                                                }
                                                                                                var35_35 = 0;
                                                                                                var70_69 = null;
                                                                                                var66_62 = 0.0f;
                                                                                                var54_52 = 0;
                                                                                                var37_37 = 1;
                                                                                                var67_63 = 1.4E-45f;
                                                                                                var65_66 = 8;
                                                                                                var74_78 = 1.1E-44f;
                                                                                                var75_87 = 8;
                                                                                                var76_88 = 1.1E-44f;
                                                                                            } else {
                                                                                                var37_37 = 0;
                                                                                                var68_64 /* !! */  = null;
                                                                                                var67_63 = 0.0f;
                                                                                                var35_35 = 1;
                                                                                                var66_62 = 1.4E-45f;
                                                                                                var54_52 = 1;
                                                                                                var65_66 = 5;
                                                                                                var74_78 = 7.0E-45f;
                                                                                                var75_87 = 5;
                                                                                                var76_88 = 7.0E-45f;
                                                                                            }
                                                                                            var72_76 = var30_30 instanceof Barrier;
                                                                                            if (var72_76 == 0 && (var72_76 = var41_41 /* !! */  instanceof Barrier) == 0) {
                                                                                                var40_40 = var7_7;
                                                                                                var77_89 = var65_66;
                                                                                                var78_90 = var74_78;
                                                                                            } else {
                                                                                                var40_40 = var7_7;
                                                                                                var77_89 = var65_66;
                                                                                                var78_90 = var74_78;
                                                                                                var75_87 = 4;
                                                                                                var76_88 = 5.6E-45f;
                                                                                            }
                                                                                            var65_66 = var37_37;
                                                                                            var74_78 = var67_63;
                                                                                            var37_37 = var50_48;
                                                                                            var67_63 = var73_77;
                                                                                            break block106;
                                                                                        }
                                                                                        var72_76 = 1;
                                                                                        if (var36_36 == var72_76) {
                                                                                            var40_40 = var7_7;
                                                                                            var37_37 = var50_48;
                                                                                            var67_63 = var73_77;
                                                                                            var35_35 = 1;
                                                                                            var66_62 = 1.4E-45f;
                                                                                            var54_52 = 1;
                                                                                            var65_66 = 0;
                                                                                            var74_79 = 0.0f;
                                                                                            var59_57 = null;
                                                                                            var75_87 = 4;
                                                                                            var76_88 = 5.6E-45f;
lbl371:
                                                                                            // 2 sources

                                                                                            while (true) {
                                                                                                var77_89 = 8;
                                                                                                var78_90 = 1.1E-44f;
                                                                                                break block106;
                                                                                                break;
                                                                                            }
                                                                                        }
                                                                                        var72_76 = 3;
                                                                                        if (var36_36 != var72_76) break block119;
                                                                                        var72_76 = var28_28.mResolvedDimensionRatioSide;
                                                                                        var37_37 = -1;
                                                                                        var67_63 = 0.0f / 0.0f;
                                                                                        if (var72_76 == var37_37) {
                                                                                            if (var20_20) {
                                                                                                var40_40 = var7_7;
                                                                                                var35_35 = 1;
                                                                                                var66_62 = 1.4E-45f;
                                                                                                if (var3_3 != 0) {
                                                                                                    var37_37 = 5;
                                                                                                    var67_63 = 7.0E-45f;
                                                                                                } else {
                                                                                                    var37_37 = 4;
                                                                                                    var67_63 = 5.6E-45f;
                                                                                                }
                                                                                            } else {
                                                                                                var40_40 = var7_7;
                                                                                                var35_35 = 1;
                                                                                                var66_62 = 1.4E-45f;
                                                                                                var37_37 = 8;
                                                                                                var67_63 = 1.1E-44f;
                                                                                            }
                                                                                            var54_52 = 1;
                                                                                            var65_66 = 1;
                                                                                            var74_80 = 1.4E-45f;
                                                                                            var75_87 = 5;
                                                                                            var76_88 = 7.0E-45f;
                                                                                            ** continue;
                                                                                        }
                                                                                        if (!var17_17) break block120;
                                                                                        var37_37 = var23_23;
                                                                                        var72_76 = 2;
                                                                                        if (var23_23 == var72_76) ** GOTO lbl-1000
                                                                                        var35_35 = 1;
                                                                                        var66_62 = 1.4E-45f;
                                                                                        if (var23_23 != var35_35) {
                                                                                            var35_35 = 0;
                                                                                            var66_62 = 0.0f;
                                                                                            var70_69 = null;
                                                                                        } else lbl-1000:
                                                                                        // 2 sources

                                                                                        {
                                                                                            var35_35 = 1;
                                                                                            var66_62 = 1.4E-45f;
                                                                                        }
                                                                                        if (var35_35 == 0) {
                                                                                            var35_35 = 8;
                                                                                            var66_62 = 1.1E-44f;
                                                                                            var37_37 = 5;
                                                                                            var67_63 = 7.0E-45f;
                                                                                        } else {
                                                                                            var35_35 = 5;
                                                                                            var66_62 = 7.0E-45f;
                                                                                            var37_37 = 4;
                                                                                            var67_63 = 5.6E-45f;
                                                                                        }
                                                                                        var40_40 = var7_7;
                                                                                        var77_89 = var35_35;
                                                                                        var78_90 = var66_62;
                                                                                        var75_87 = var37_37;
                                                                                        var76_88 = var67_63;
                                                                                        var37_37 = var50_48;
                                                                                        var67_63 = var73_77;
                                                                                        var35_35 = 1;
                                                                                        var66_62 = 1.4E-45f;
                                                                                        var54_52 = 1;
                                                                                        var65_66 = 1;
                                                                                        var74_81 = 1.4E-45f;
                                                                                        break block106;
                                                                                    }
                                                                                    if (var35_35 <= 0) break block121;
                                                                                    var40_40 = var7_7;
                                                                                    var37_37 = var50_48;
                                                                                    var67_63 = var73_77;
                                                                                    var35_35 = 1;
                                                                                    var66_62 = 1.4E-45f;
                                                                                    var54_52 = 1;
                                                                                    var65_66 = 1;
                                                                                    var74_82 = 1.4E-45f;
                                                                                    var75_87 = 5;
                                                                                    var76_88 = 7.0E-45f;
                                                                                    break block122;
                                                                                }
                                                                                if (var35_35 != 0 || var62_60 != 0) break block123;
                                                                                if (var20_20) break block124;
                                                                                var40_40 = var7_7;
                                                                                var37_37 = var50_48;
                                                                                var67_63 = var73_77;
                                                                                var35_35 = 1;
                                                                                var66_62 = 1.4E-45f;
                                                                                var54_52 = 1;
                                                                                var65_66 = 1;
                                                                                var74_83 = 1.4E-45f;
                                                                                var75_87 = 8;
                                                                                var76_88 = 1.1E-44f;
                                                                                break block122;
                                                                            }
                                                                            if (var30_30 != var69_67 && var41_41 /* !! */  != var69_67) {
                                                                                var35_35 = 4;
                                                                                var66_62 = 5.6E-45f;
                                                                            } else {
                                                                                var35_35 = 5;
                                                                                var66_62 = 7.0E-45f;
                                                                            }
                                                                            var40_40 = var7_7;
                                                                            var77_89 = var35_35;
                                                                            var78_90 = var66_62;
                                                                            var37_37 = var50_48;
                                                                            var67_63 = var73_77;
                                                                            var35_35 = 1;
                                                                            var66_62 = 1.4E-45f;
                                                                            var54_52 = 1;
                                                                            var65_66 = 1;
                                                                            var74_84 = 1.4E-45f;
                                                                            var75_87 = 4;
                                                                            var76_88 = 5.6E-45f;
                                                                            break block106;
                                                                        }
                                                                        var40_40 = var7_7;
                                                                        var37_37 = var50_48;
                                                                        var67_63 = var73_77;
                                                                        var35_35 = 1;
                                                                        var66_62 = 1.4E-45f;
                                                                        var54_52 = 1;
                                                                        var65_66 = 1;
                                                                        var74_85 = 1.4E-45f;
                                                                        break block125;
                                                                    }
                                                                    var40_40 = var7_7;
                                                                    var37_37 = var50_48;
                                                                    var67_63 = var73_77;
                                                                    var35_35 = 0;
                                                                    var66_62 = 0.0f;
                                                                    var70_69 = null;
                                                                    var54_52 = 0;
                                                                    break block126;
                                                                }
                                                                var35_35 = (int)var33_33.isFinalValue;
                                                                if (var35_35 != 0 && (var35_35 = (int)var32_32.isFinalValue) != 0) {
                                                                    var35_35 = var10_10.getMargin();
                                                                    var36_36 = var11_11.getMargin();
                                                                    var37_37 = 8;
                                                                    var67_63 = 1.1E-44f;
                                                                    var20_20 = var35_35;
                                                                    var24_24 = var36_36;
                                                                    var25_25 = var37_37;
                                                                    var1_1.addCentering(var39_39, (SolverVariable)var33_33, var35_35, var16_16, (SolverVariable)var32_32, var63_61, var36_36, var37_37);
                                                                    if (var3_3 != 0 && var52_50 != 0) {
                                                                        var70_70 = var11_11.mTarget;
                                                                        if (var70_70 != null) {
                                                                            var35_35 = var11_11.getMargin();
                                                                            var40_40 = var7_7;
                                                                        } else {
                                                                            var40_40 = var7_7;
                                                                            var35_35 = 0;
                                                                            var66_62 = 0.0f;
                                                                            var70_70 = null;
                                                                        }
                                                                        if (var32_32 != var40_40) {
                                                                            var36_36 = 5;
                                                                            var29_29.addGreaterThan(var40_40, var63_61, var35_35, var36_36);
                                                                        }
                                                                    }
                                                                    return;
                                                                }
                                                                var40_40 = var7_7;
                                                                var37_37 = var50_48;
                                                                var67_63 = var73_77;
                                                                var35_35 = 1;
                                                                var66_62 = 1.4E-45f;
                                                                var54_52 = 1;
                                                            }
                                                            var65_66 = 0;
                                                            var74_86 = 0.0f;
                                                            var59_57 = null;
                                                        }
                                                        var75_87 = 4;
                                                        var76_88 = 5.6E-45f;
                                                    }
                                                    var77_89 = 5;
                                                    var78_90 = 7.0E-45f;
                                                }
                                                if (var54_52 != 0 && var33_33 == var32_32 && var30_30 != var69_67) {
                                                    var54_52 = 0;
                                                    var79_91 = 0;
                                                    var80_92 = 0.0f;
                                                } else {
                                                    var79_91 = 1;
                                                    var80_92 = 1.4E-45f;
                                                }
                                                if (var35_35 != 0) {
                                                    if (var64_65 == 0 && !var18_18 && !var20_20 && var33_33 == var43_43 /* !! */  && var32_32 == var40_40) {
                                                        var77_89 = 0;
                                                        var78_90 = 0.0f;
                                                        var79_91 = 8;
                                                        var80_92 = 1.1E-44f;
                                                        var81_93 = 0;
                                                        var82_94 = 0.0f;
                                                        var83_95 = 8;
                                                        var84_96 = 1.1E-44f;
                                                    } else {
                                                        var83_95 = var77_89;
                                                        var84_96 = var78_90;
                                                        var81_93 = var79_91;
                                                        var82_94 = var80_92;
                                                        var77_89 = var3_3;
                                                        var79_91 = var37_37;
                                                        var80_92 = var67_63;
                                                    }
                                                    var85_97 = var10_10.getMargin();
                                                    var86_98 = var11_11.getMargin();
                                                    var70_69 = var1_1;
                                                    var37_37 = var36_36;
                                                    var71_72 = var39_39;
                                                    var49_47 = var36_36;
                                                    var68_64 /* !! */  = var33_33;
                                                    var87_99 = var36_36;
                                                    var31_31 = var69_67;
                                                    var38_38 = var85_97;
                                                    var88_100 = var69_67;
                                                    var31_31 = var41_41 /* !! */ ;
                                                    var89_101 = var16_16;
                                                    var43_43 /* !! */  = var32_32;
                                                    var42_42 = var63_61;
                                                    var72_76 = var86_98;
                                                    var90_103 = var63_61;
                                                    var63_61 = var39_39;
                                                    var1_1.addCentering(var39_39, (SolverVariable)var33_33, var85_97, var16_16, (SolverVariable)var32_32, (SolverVariable)var42_42, var86_98, var79_91);
                                                    var79_91 = var81_93;
                                                    var80_92 = var82_94;
                                                } else {
                                                    var87_99 = var36_36;
                                                    var88_100 = var69_67;
                                                    var31_31 = var41_41 /* !! */ ;
                                                    var90_103 = var63_61;
                                                    var63_61 = var39_39;
                                                    var83_95 = var77_89;
                                                    var84_96 = var78_90;
                                                    var77_89 = var3_3;
                                                }
                                                var35_35 = var28_28.mVisibility;
                                                var36_36 = 8;
                                                if (var35_35 == var36_36 && (var35_35 = (int)var11_11.hasDependents()) == 0) {
                                                    return;
                                                }
                                                if (var54_52 != 0) {
                                                    if (var77_89 != 0 && var33_33 != var32_32 && var64_65 == 0 && ((var35_35 = var30_30 instanceof Barrier) != 0 || (var35_35 = var31_31 instanceof Barrier) != 0)) {
                                                        var35_35 = var50_48;
                                                        var66_62 = var73_77;
                                                    } else {
                                                        var35_35 = var83_95;
                                                        var66_62 = var84_96;
                                                    }
                                                    var36_36 = var10_10.getMargin();
                                                    var29_29.addGreaterThan(var63_61, (SolverVariable)var33_33, var36_36, var35_35);
                                                    var36_36 = -var11_11.getMargin();
                                                    var68_64 /* !! */  = var90_103;
                                                    var29_29.addLowerThan(var90_103, (SolverVariable)var32_32, var36_36, var35_35);
                                                    var83_95 = var35_35;
                                                    var84_96 = var66_62;
                                                } else {
                                                    var68_64 /* !! */  = var90_103;
                                                }
                                                if (var77_89 != 0 && var21_21 && (var35_35 = var30_30 instanceof Barrier) == 0 && (var35_35 = var31_31 instanceof Barrier) == 0) {
                                                    var35_35 = var50_48;
                                                    var66_62 = var73_77;
                                                    var36_36 = var50_48;
                                                    var79_91 = 1;
                                                    var80_92 = 1.4E-45f;
                                                } else {
                                                    var35_35 = var75_87;
                                                    var66_62 = var76_88;
                                                    var36_36 = var83_95;
                                                }
                                                if (var79_91 != 0) {
                                                    if (var65_66 != 0 && (!var20_20 || var4_4)) {
                                                        var69_67 = var88_100;
                                                        if (var30_30 != var88_100 && var31_31 != var88_100) {
                                                            var50_48 = var35_35;
                                                            var73_77 = var66_62;
                                                        }
                                                        if ((var51_49 = var30_30 instanceof Guideline) != 0 || (var51_49 = var31_31 instanceof Guideline) != 0) {
                                                            var50_48 = 5;
                                                            var73_77 = 7.0E-45f;
                                                        }
                                                        if ((var51_49 = var30_30 instanceof Barrier) != 0 || (var51_49 = var31_31 instanceof Barrier) != 0) {
                                                            var50_48 = 5;
                                                            var73_77 = 7.0E-45f;
                                                        }
                                                        if (var20_20) {
                                                            var51_49 = 5;
                                                            var89_101 = 7.0E-45f;
                                                        } else {
                                                            var51_49 = var50_48;
                                                            var89_101 = var73_77;
                                                        }
                                                        var35_35 = Math.max(var51_49, var35_35);
                                                    } else {
                                                        var69_67 = var88_100;
                                                    }
                                                    if (var77_89 != 0) {
                                                        var35_35 = Math.min(var36_36, var35_35);
                                                        if (var17_17 && !var20_20 && (var30_30 == var69_67 || var31_31 == var69_67)) {
                                                            var35_35 = 4;
                                                            var66_62 = 5.6E-45f;
                                                        }
                                                    }
                                                    var36_36 = var10_10.getMargin();
                                                    var29_29.addEquality(var63_61, (SolverVariable)var33_33, var36_36, var35_35);
                                                    var36_36 = -var11_11.getMargin();
                                                    var29_29.addEquality((SolverVariable)var68_64 /* !! */ , (SolverVariable)var32_32, var36_36, var35_35);
                                                }
                                                if (var77_89 != 0) {
                                                    var70_69 = var6_6;
                                                    if (var6_6 == var33_33) {
                                                        var36_36 = var10_10.getMargin();
                                                    } else {
                                                        var36_36 = 0;
                                                        var71_72 = null;
                                                    }
                                                    if (var33_33 != var70_69) {
                                                        var38_38 = 5;
                                                        var29_29.addGreaterThan(var63_61, (SolverVariable)var70_69, var36_36, var38_38);
                                                    }
                                                }
                                                if (var77_89 == 0 || var64_65 == 0) break block127;
                                                var71_72 = var68_64 /* !! */ ;
                                                if (var14_14 != 0 || var62_60 != 0) break block128;
                                                if (var64_65 == 0) ** GOTO lbl-1000
                                                var35_35 = var87_99;
                                                var37_37 = 3;
                                                var67_63 = 4.2E-45f;
                                                if (var87_99 == var37_37) {
                                                    var35_35 = 8;
                                                    var66_62 = 1.1E-44f;
                                                    var37_37 = 0;
                                                    var67_63 = 0.0f;
                                                    var68_64 /* !! */  = null;
                                                    var29_29.addGreaterThan((SolverVariable)var71_72, var63_61, 0, var35_35);
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    var37_37 = 0;
                                                    var67_63 = 0.0f;
                                                    var68_64 /* !! */  = null;
                                                    var35_35 = 5;
                                                    var66_62 = 7.0E-45f;
                                                    var29_29.addGreaterThan((SolverVariable)var71_72, var63_61, 0, var35_35);
                                                }
                                                break block129;
                                            }
                                            var71_72 = var68_64 /* !! */ ;
                                        }
                                        var37_37 = 0;
                                        var67_63 = 0.0f;
                                        var68_64 /* !! */  = null;
                                        break block129;
                                    }
                                    var37_37 = 0;
                                    var68_64 /* !! */  = null;
                                    var67_63 = 0.0f;
                                    var71_72 = var63_61;
                                }
                                var77_89 = var3_3;
                            }
                            if (var77_89 != 0 && var52_50 != 0) {
                                var70_69 = var11_11;
                                var69_67 = var11_11.mTarget;
                                if (var69_67 != null) {
                                    var37_37 = var11_11.getMargin();
                                }
                                var69_67 = var7_7;
                                if (var32_32 != var7_7) {
                                    var51_49 = (int)var28_28.OPTIMIZE_WRAP;
                                    if (var51_49 != 0 && (var51_49 = (int)var71_72.isFinalValue) != 0 && (var41_41 /* !! */  = var28_28.mParent) != null) {
                                        var41_41 /* !! */  = (ConstraintWidgetContainer)var41_41 /* !! */ ;
                                        if (var2_2) {
                                            var41_41 /* !! */ .addHorizontalWrapMaxVariable((ConstraintAnchor)var70_69);
                                        } else {
                                            var41_41 /* !! */ .addVerticalWrapMaxVariable((ConstraintAnchor)var70_69);
                                        }
                                        return;
                                    }
                                    var35_35 = 5;
                                    var66_62 = 7.0E-45f;
                                    var29_29.addGreaterThan((SolverVariable)var69_67, (SolverVariable)var71_72, var37_37, var35_35);
                                }
                            }
                            return;
                        }
                        var70_68 /* !! */  = var6_6;
                        var69_67 = var7_7;
                        var71_71 = var63_61;
                        var37_37 = 0;
                        var68_64 /* !! */  = null;
                        var67_63 = 0.0f;
                        var63_61 = var39_39;
                        var51_49 = var65_66;
                        var60_58 = 2;
                        var61_59 = 2.8E-45f;
                    }
                    if (var51_49 >= var60_58 || var3_3 == 0 || var52_50 == 0) break block130;
                    var51_49 = 8;
                    var89_102 = 1.1E-44f;
                    var29_29.addGreaterThan(var63_61, (SolverVariable)var70_68 /* !! */ , 0, var51_49);
                    if (!var2_2 && (var70_68 /* !! */  = var28_28.mBaseline.mTarget) != null) {
                        var57_55 = 0;
                        var32_32 = null;
                        var58_56 = 0.0f;
                    } else {
                        var57_55 = 1;
                        var58_56 = 1.4E-45f;
                    }
                    if (var2_2 || (var70_68 /* !! */  = var28_28.mBaseline.mTarget) == null) break block131;
                    var70_68 /* !! */  = var70_68 /* !! */ .mOwner;
                    var89_102 = var70_68 /* !! */ .mDimensionRatio;
                    var60_58 = 0;
                    var61_59 = 0.0f;
                    var43_43 /* !! */  = null;
                    cfr_temp_0 = var89_102 - 0.0f;
                    var51_49 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
                    if (var51_49 == 0 || (var41_41 /* !! */  = (var70_68 /* !! */  = var70_68 /* !! */ .mListDimensionBehaviors)[0]) != (var43_43 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) ** GOTO lbl-1000
                    var51_49 = 1;
                    var89_102 = 1.4E-45f;
                    if ((var70_68 /* !! */  = var70_68 /* !! */ [var51_49]) == var43_43 /* !! */ ) {
                        var55_53 = var51_49;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var55_53 = 0;
                        var33_33 = null;
                    }
                    break block132;
                }
                var55_53 = var57_55;
            }
            if (var55_53 != 0) {
                var35_35 = 8;
                var66_62 = 1.1E-44f;
                var29_29.addGreaterThan((SolverVariable)var69_67, var71_71, 0, var35_35);
            }
        }
    }

    private boolean isChainHead(int n10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor[] constraintAnchorArray = this.mListAnchors;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArray[n10 *= 2].mTarget;
        int n11 = 1;
        if (constraintAnchor3 == null || (constraintAnchor3 = constraintAnchorArray[n10].mTarget.mTarget) == (constraintAnchor2 = constraintAnchorArray[n10]) || (constraintAnchor3 = constraintAnchorArray[n10 += n11].mTarget) == null || (constraintAnchor3 = constraintAnchorArray[n10].mTarget.mTarget) != (constraintAnchor = constraintAnchorArray[n10])) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet hashSet, int n10, boolean bl2) {
        block12: {
            boolean bl3;
            ConstraintWidget constraintWidget;
            ConstraintAnchor constraintAnchor;
            boolean bl4;
            block11: {
                boolean bl5;
                ConstraintWidget constraintWidget2;
                ConstraintAnchor constraintAnchor2;
                boolean bl6;
                if (bl2) {
                    bl2 = hashSet.contains(this);
                    if (!bl2) {
                        return;
                    }
                    Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
                    hashSet.remove(this);
                    bl2 = constraintWidgetContainer.optimizeFor(64);
                    this.addToSolver(linearSystem, bl2);
                }
                if (n10 != 0) break block11;
                Object object = this.mLeft.getDependents();
                if (object != null) {
                    object = ((HashSet)object).iterator();
                    while (bl6 = object.hasNext()) {
                        constraintAnchor2 = (ConstraintAnchor)object.next();
                        constraintWidget2 = constraintAnchor2.mOwner;
                        bl5 = true;
                        constraintWidget2.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n10, bl5);
                    }
                }
                if ((object = this.mRight.getDependents()) == null) break block12;
                object = ((HashSet)object).iterator();
                while (bl6 = object.hasNext()) {
                    constraintAnchor2 = (ConstraintAnchor)object.next();
                    constraintWidget2 = constraintAnchor2.mOwner;
                    bl5 = true;
                    constraintWidget2.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n10, bl5);
                }
                break block12;
            }
            Object object = this.mTop.getDependents();
            if (object != null) {
                object = ((HashSet)object).iterator();
                while (bl4 = object.hasNext()) {
                    constraintAnchor = (ConstraintAnchor)object.next();
                    constraintWidget = constraintAnchor.mOwner;
                    bl3 = true;
                    constraintWidget.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n10, bl3);
                }
            }
            if ((object = this.mBottom.getDependents()) != null) {
                object = ((HashSet)object).iterator();
                while (bl4 = object.hasNext()) {
                    constraintAnchor = (ConstraintAnchor)object.next();
                    constraintWidget = constraintAnchor.mOwner;
                    bl3 = true;
                    constraintWidget.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n10, bl3);
                }
            }
            if ((object = this.mBaseline.getDependents()) != null) {
                object = ((HashSet)object).iterator();
                while (bl4 = object.hasNext()) {
                    constraintAnchor = (ConstraintAnchor)object.next();
                    constraintWidget = constraintAnchor.mOwner;
                    bl3 = true;
                    constraintWidget.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, n10, bl3);
                }
            }
        }
    }

    public boolean addFirst() {
        boolean bl2 = this instanceof VirtualLayout;
        bl2 = bl2 || (bl2 = this instanceof Guideline);
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void addToSolver(LinearSystem var1_1, boolean var2_2) {
        block101: {
            block100: {
                block98: {
                    block99: {
                        block96: {
                            block97: {
                                block95: {
                                    block92: {
                                        block93: {
                                            block94: {
                                                block91: {
                                                    block90: {
                                                        block89: {
                                                            block86: {
                                                                block81: {
                                                                    block80: {
                                                                        block88: {
                                                                            block84: {
                                                                                block87: {
                                                                                    block85: {
                                                                                        block83: {
                                                                                            block82: {
                                                                                                block79: {
                                                                                                    var3_3 = this;
                                                                                                    var4_4 /* !! */  = var1_1;
                                                                                                    var5_5 /* !! */  = this.mLeft;
                                                                                                    var6_6 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                                                                    var5_5 /* !! */  = this.mRight;
                                                                                                    var7_7 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                                                                    var5_5 /* !! */  = this.mTop;
                                                                                                    var8_8 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                                                                    var5_5 /* !! */  = this.mBottom;
                                                                                                    var9_9 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                                                                    var5_5 /* !! */  = this.mBaseline;
                                                                                                    var10_10 = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                                                                    var5_5 /* !! */  = this.mParent;
                                                                                                    var11_11 = 1;
                                                                                                    var12_12 = 1.4E-45f;
                                                                                                    var13_13 = 0;
                                                                                                    var14_14 /* !! */  = null;
                                                                                                    if (var5_5 /* !! */  != null) {
                                                                                                        if (var5_5 /* !! */  != null && (var15_15 /* !! */  = var5_5 /* !! */ .mListDimensionBehaviors[0]) == (var16_16 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                                                                                                            var17_17 = var11_11;
                                                                                                            var18_18 = var12_12;
                                                                                                        } else {
                                                                                                            var17_17 = 0;
                                                                                                            var15_15 /* !! */  = null;
                                                                                                            var18_18 = 0.0f;
                                                                                                        }
                                                                                                        if (var5_5 /* !! */  != null && (var5_5 /* !! */  = var5_5 /* !! */ .mListDimensionBehaviors[var11_11]) == (var16_16 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT)) {
                                                                                                            var19_19 = var11_11;
                                                                                                            var20_20 = var12_12;
                                                                                                        } else {
                                                                                                            var19_19 = 0;
                                                                                                            var5_5 /* !! */  = null;
                                                                                                            var20_20 = 0.0f;
                                                                                                        }
                                                                                                        var21_21 = var19_19;
                                                                                                        var22_22 = var20_20;
                                                                                                        var23_23 = var17_17;
                                                                                                        var24_24 = var18_18;
                                                                                                    } else {
                                                                                                        var23_23 = 0;
                                                                                                        var24_24 = 0.0f;
                                                                                                        var21_21 = 0;
                                                                                                        var25_25 /* !! */  = null;
                                                                                                        var22_22 = 0.0f;
                                                                                                    }
                                                                                                    var19_19 = var3_3.mVisibility;
                                                                                                    var26_26 = 8;
                                                                                                    var27_27 = 1.1E-44f;
                                                                                                    if (var19_19 == var26_26 && (var19_19 = (int)this.hasDependencies()) == 0 && (var17_17 = (int)(var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.mIsInBarrier)[0]) == 0 && (var19_19 = (int)var5_5 /* !! */ [var11_11]) == false) {
                                                                                                        return;
                                                                                                    }
                                                                                                    var19_19 = (int)var3_3.resolvedHorizontal;
                                                                                                    var28_28 = 5;
                                                                                                    if (var19_19 != 0 || (var17_17 = (int)var3_3.resolvedVertical) != 0) {
                                                                                                        if (var19_19 != 0) {
                                                                                                            var19_19 = var3_3.mX;
                                                                                                            var4_4 /* !! */ .addEquality((SolverVariable)var6_6 /* !! */ , var19_19);
                                                                                                            var19_19 = var3_3.mX;
                                                                                                            var17_17 = var3_3.mWidth;
                                                                                                            var4_4 /* !! */ .addEquality((SolverVariable)var7_7 /* !! */ , var19_19 += var17_17);
                                                                                                            if (var23_23 != 0 && (var5_5 /* !! */  = var3_3.mParent) != null) {
                                                                                                                var17_17 = (int)var3_3.OPTIMIZE_WRAP_ON_RESOLVED;
                                                                                                                if (var17_17 != 0) {
                                                                                                                    var5_5 /* !! */  = (ConstraintWidgetContainer)var5_5 /* !! */ ;
                                                                                                                    var15_15 /* !! */  = var3_3.mLeft;
                                                                                                                    var5_5 /* !! */ .addVerticalWrapMinVariable((ConstraintAnchor)var15_15 /* !! */ );
                                                                                                                    var15_15 /* !! */  = var3_3.mRight;
                                                                                                                    var5_5 /* !! */ .addHorizontalWrapMaxVariable((ConstraintAnchor)var15_15 /* !! */ );
                                                                                                                } else {
                                                                                                                    var5_5 /* !! */  = var5_5 /* !! */ .mRight;
                                                                                                                    var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                                                                                                                    var4_4 /* !! */ .addGreaterThan((SolverVariable)var5_5 /* !! */ , (SolverVariable)var7_7 /* !! */ , 0, var28_28);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        if ((var19_19 = (int)var3_3.resolvedVertical) != 0) {
                                                                                                            var19_19 = var3_3.mY;
                                                                                                            var4_4 /* !! */ .addEquality((SolverVariable)var8_8 /* !! */ , var19_19);
                                                                                                            var19_19 = var3_3.mY;
                                                                                                            var17_17 = var3_3.mHeight;
                                                                                                            var4_4 /* !! */ .addEquality((SolverVariable)var9_9 /* !! */ , var19_19 += var17_17);
                                                                                                            var5_5 /* !! */  = var3_3.mBaseline;
                                                                                                            var19_19 = (int)var5_5 /* !! */ .hasDependents();
                                                                                                            if (var19_19 != false) {
                                                                                                                var19_19 = var3_3.mY;
                                                                                                                var17_17 = var3_3.mBaselineDistance;
                                                                                                                var4_4 /* !! */ .addEquality(var10_10, var19_19 += var17_17);
                                                                                                            }
                                                                                                            if (var21_21 != 0 && (var5_5 /* !! */  = var3_3.mParent) != null) {
                                                                                                                var17_17 = (int)var3_3.OPTIMIZE_WRAP_ON_RESOLVED;
                                                                                                                if (var17_17 != 0) {
                                                                                                                    var5_5 /* !! */  = (ConstraintWidgetContainer)var5_5 /* !! */ ;
                                                                                                                    var15_15 /* !! */  = var3_3.mTop;
                                                                                                                    var5_5 /* !! */ .addVerticalWrapMinVariable((ConstraintAnchor)var15_15 /* !! */ );
                                                                                                                    var15_15 /* !! */  = var3_3.mBottom;
                                                                                                                    var5_5 /* !! */ .addVerticalWrapMaxVariable((ConstraintAnchor)var15_15 /* !! */ );
                                                                                                                } else {
                                                                                                                    var5_5 /* !! */  = var5_5 /* !! */ .mBottom;
                                                                                                                    var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                                                                                                                    var4_4 /* !! */ .addGreaterThan((SolverVariable)var5_5 /* !! */ , (SolverVariable)var9_9 /* !! */ , 0, var28_28);
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                        if ((var19_19 = (int)var3_3.resolvedHorizontal) != false && (var19_19 = (int)var3_3.resolvedVertical) != false) {
                                                                                                            var3_3.resolvedHorizontal = false;
                                                                                                            var3_3.resolvedVertical = false;
                                                                                                            return;
                                                                                                        }
                                                                                                    }
                                                                                                    var5_5 /* !! */  = LinearSystem.sMetrics;
                                                                                                    var29_29 = 1L;
                                                                                                    var31_30 = 4.9E-324;
                                                                                                    if (var5_5 /* !! */  != null) {
                                                                                                        var5_5 /* !! */ .widgets = var33_31 = var5_5 /* !! */ .widgets + var29_29;
                                                                                                    }
                                                                                                    if (!var2_2 || (var35_32 /* !! */  = var3_3.horizontalRun) == null || (var36_33 /* !! */  = var3_3.verticalRun) == null) break block79;
                                                                                                    var37_34 /* !! */  = var35_32 /* !! */ .start;
                                                                                                    var13_13 = var37_34 /* !! */ .resolved;
                                                                                                    if (var13_13 == 0) break block79;
                                                                                                    var35_32 /* !! */  = var35_32 /* !! */ .end;
                                                                                                    var28_28 = (int)var35_32 /* !! */ .resolved;
                                                                                                    if (var28_28 == 0) break block79;
                                                                                                    var35_32 /* !! */  = var36_33 /* !! */ .start;
                                                                                                    var28_28 = (int)var35_32 /* !! */ .resolved;
                                                                                                    if (var28_28 == 0) break block79;
                                                                                                    var35_32 /* !! */  = var36_33 /* !! */ .end;
                                                                                                    var28_28 = (int)var35_32 /* !! */ .resolved;
                                                                                                    if (var28_28 == 0) break block79;
                                                                                                    if (var5_5 /* !! */  != null) {
                                                                                                        var5_5 /* !! */ .graphSolved = var33_31 = var5_5 /* !! */ .graphSolved + var29_29;
                                                                                                    }
                                                                                                    var19_19 = var37_34 /* !! */ .value;
                                                                                                    var4_4 /* !! */ .addEquality((SolverVariable)var6_6 /* !! */ , var19_19);
                                                                                                    var19_19 = var3_3.horizontalRun.end.value;
                                                                                                    var4_4 /* !! */ .addEquality((SolverVariable)var7_7 /* !! */ , var19_19);
                                                                                                    var19_19 = var3_3.verticalRun.start.value;
                                                                                                    var4_4 /* !! */ .addEquality((SolverVariable)var8_8 /* !! */ , var19_19);
                                                                                                    var19_19 = var3_3.verticalRun.end.value;
                                                                                                    var4_4 /* !! */ .addEquality((SolverVariable)var9_9 /* !! */ , var19_19);
                                                                                                    var19_19 = var3_3.verticalRun.baseline.value;
                                                                                                    var4_4 /* !! */ .addEquality(var10_10, var19_19);
                                                                                                    var5_5 /* !! */  = var3_3.mParent;
                                                                                                    if (var5_5 /* !! */  == null) ** GOTO lbl-1000
                                                                                                    if (var23_23 != 0) {
                                                                                                        var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.isTerminalWidget;
                                                                                                        var17_17 = false;
                                                                                                        var18_18 = 0.0f;
                                                                                                        var15_15 /* !! */  = null;
                                                                                                        var19_19 = (int)var5_5 /* !! */ [0];
                                                                                                        if (var19_19 != 0 && (var19_19 = (int)this.isInHorizontalChain()) == 0) {
                                                                                                            var5_5 /* !! */  = var3_3.mParent.mRight;
                                                                                                            var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                                                                                                            var38_35 = 8;
                                                                                                            var39_37 = 1.1E-44f;
                                                                                                            var4_4 /* !! */ .addGreaterThan((SolverVariable)var5_5 /* !! */ , (SolverVariable)var7_7 /* !! */ , 0, var38_35);
                                                                                                        }
                                                                                                    }
                                                                                                    if (var21_21 == 0) ** GOTO lbl-1000
                                                                                                    var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.isTerminalWidget;
                                                                                                    var17_17 = true;
                                                                                                    var18_18 = 1.4E-45f;
                                                                                                    var19_19 = (int)var5_5 /* !! */ [var17_17];
                                                                                                    if (var19_19 != 0 && (var19_19 = (int)this.isInVerticalChain()) == 0) {
                                                                                                        var5_5 /* !! */  = var3_3.mParent.mBottom;
                                                                                                        var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                                                                                                        var17_17 = 8 != 0;
                                                                                                        var18_18 = 1.1E-44f;
                                                                                                        var38_35 = 0;
                                                                                                        var39_37 = 0.0f;
                                                                                                        var16_16 = null;
                                                                                                        var4_4 /* !! */ .addGreaterThan((SolverVariable)var5_5 /* !! */ , (SolverVariable)var9_9 /* !! */ , 0, var17_17);
                                                                                                    } else lbl-1000:
                                                                                                    // 3 sources

                                                                                                    {
                                                                                                        var38_35 = 0;
                                                                                                        var39_37 = 0.0f;
                                                                                                        var16_16 = null;
                                                                                                    }
                                                                                                    var3_3.resolvedHorizontal = false;
                                                                                                    var3_3.resolvedVertical = false;
                                                                                                    return;
                                                                                                }
                                                                                                if (var5_5 /* !! */  != null) {
                                                                                                    var5_5 /* !! */ .linearSolved = var33_31 = var5_5 /* !! */ .linearSolved + var29_29;
                                                                                                }
                                                                                                if ((var5_5 /* !! */  = var3_3.mParent) != null) {
                                                                                                    var19_19 = false;
                                                                                                    var20_20 = 0.0f;
                                                                                                    var5_5 /* !! */  = null;
                                                                                                    var17_17 = (int)var3_3.isChainHead(0);
                                                                                                    if (var17_17 != 0) {
                                                                                                        var15_15 /* !! */  = (ConstraintWidgetContainer)var3_3.mParent;
                                                                                                        var15_15 /* !! */ .addChain(var3_3, 0);
                                                                                                        var19_19 = true;
                                                                                                        var20_20 = 1.4E-45f;
                                                                                                    } else {
                                                                                                        var19_19 = (int)this.isInHorizontalChain();
                                                                                                    }
                                                                                                    var17_17 = true;
                                                                                                    var18_18 = 1.4E-45f;
                                                                                                    var38_36 = (int)var3_3.isChainHead(var17_17);
                                                                                                    if (var38_36 != 0) {
                                                                                                        var16_16 = (ConstraintWidgetContainer)var3_3.mParent;
                                                                                                        var16_16.addChain(var3_3, var17_17);
                                                                                                        var17_17 = true;
                                                                                                        var18_18 = 1.4E-45f;
                                                                                                    } else {
                                                                                                        var17_17 = (int)this.isInVerticalChain();
                                                                                                    }
                                                                                                    if (var19_19 == false && var23_23 != 0 && (var38_36 = var3_3.mVisibility) != (var28_28 = 8) && (var16_16 = var3_3.mLeft.mTarget) == null && (var16_16 = var3_3.mRight.mTarget) == null) {
                                                                                                        var16_16 = var3_3.mParent.mRight;
                                                                                                        var16_16 = var4_4 /* !! */ .createObjectVariable(var16_16);
                                                                                                        var28_28 = 1;
                                                                                                        var26_26 = 0;
                                                                                                        var27_27 = 0.0f;
                                                                                                        var36_33 /* !! */  = null;
                                                                                                        var4_4 /* !! */ .addGreaterThan((SolverVariable)var16_16, (SolverVariable)var7_7 /* !! */ , 0, var28_28);
                                                                                                    }
                                                                                                    if (var17_17 == 0 && var21_21 != 0 && (var38_36 = var3_3.mVisibility) != (var28_28 = 8) && (var16_16 = var3_3.mTop.mTarget) == null && (var16_16 = var3_3.mBottom.mTarget) == null && (var16_16 = var3_3.mBaseline) == null) {
                                                                                                        var16_16 = var3_3.mParent.mBottom;
                                                                                                        var16_16 = var4_4 /* !! */ .createObjectVariable(var16_16);
                                                                                                        var28_28 = 1;
                                                                                                        var26_26 = 0;
                                                                                                        var27_27 = 0.0f;
                                                                                                        var36_33 /* !! */  = null;
                                                                                                        var4_4 /* !! */ .addGreaterThan((SolverVariable)var16_16, (SolverVariable)var9_9 /* !! */ , 0, var28_28);
                                                                                                    }
                                                                                                    var40_39 = var19_19;
                                                                                                    var41_40 = var17_17;
                                                                                                } else {
                                                                                                    var41_40 = false;
                                                                                                    var40_39 = false;
                                                                                                }
                                                                                                var19_19 = var3_3.mWidth;
                                                                                                var17_17 = var3_3.mMinWidth;
                                                                                                if (var19_19 >= var17_17) {
                                                                                                    var17_17 = var19_19;
                                                                                                }
                                                                                                var38_36 = var3_3.mHeight;
                                                                                                var28_28 = var3_3.mMinHeight;
                                                                                                if (var38_36 >= var28_28) {
                                                                                                    var28_28 = var38_36;
                                                                                                }
                                                                                                var36_33 /* !! */  = var3_3.mListDimensionBehaviors;
                                                                                                var13_13 = 0;
                                                                                                var37_34 /* !! */  = var36_33 /* !! */ [0];
                                                                                                var14_14 /* !! */  = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                                                                                                var42_41 = var17_17;
                                                                                                if (var37_34 /* !! */  != var14_14 /* !! */ ) {
                                                                                                    var11_11 = 1;
                                                                                                    var12_12 = 1.4E-45f;
                                                                                                } else {
                                                                                                    var11_11 = 0;
                                                                                                    var12_12 = 0.0f;
                                                                                                    var37_34 /* !! */  = null;
                                                                                                }
                                                                                                var43_42 = true;
                                                                                                var44_43 = 1.4E-45f;
                                                                                                var15_15 /* !! */  = var36_33 /* !! */ [var43_42];
                                                                                                var45_44 /* !! */  = var28_28;
                                                                                                if (var15_15 /* !! */  != var14_14 /* !! */ ) {
                                                                                                    var17_17 = true;
                                                                                                    var18_18 = 1.4E-45f;
                                                                                                } else {
                                                                                                    var17_17 = false;
                                                                                                    var18_18 = 0.0f;
                                                                                                    var15_15 /* !! */  = null;
                                                                                                }
                                                                                                var3_3.mResolvedDimensionRatioSide = var28_28 = var3_3.mDimensionRatioSide;
                                                                                                var46_45 = var10_10;
                                                                                                var3_3.mResolvedDimensionRatio = var47_46 = var3_3.mDimensionRatio;
                                                                                                var48_47 = var9_9 /* !! */ ;
                                                                                                var49_48 = var3_3.mMatchConstraintDefaultWidth;
                                                                                                var50_49 = var8_8 /* !! */ ;
                                                                                                var51_50 = var3_3.mMatchConstraintDefaultHeight;
                                                                                                cfr_temp_0 = var47_46 - 0.0f;
                                                                                                var52_51 = cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1);
                                                                                                var53_52 = 4;
                                                                                                var54_53 /* !! */  = var7_7 /* !! */ ;
                                                                                                if (var52_51 <= 0) break block80;
                                                                                                var55_54 = var3_3.mVisibility;
                                                                                                var56_55 /* !! */  = var6_6 /* !! */ ;
                                                                                                var57_56 = 8;
                                                                                                if (var55_54 == var57_56) break block81;
                                                                                                var55_54 = 0;
                                                                                                var7_7 /* !! */  = null;
                                                                                                var6_6 /* !! */  = var36_33 /* !! */ [0];
                                                                                                if (var6_6 /* !! */  == var14_14 /* !! */  && var49_48 == 0) {
                                                                                                    var49_48 = 3;
                                                                                                    var58_57 = 4.2E-45f;
                                                                                                }
                                                                                                if ((var7_7 /* !! */  = var36_33 /* !! */ [var57_56 = 1]) == var14_14 /* !! */  && var51_50 == 0) {
                                                                                                    var51_50 = 3;
                                                                                                    var59_58 = 4.2E-45f;
                                                                                                }
                                                                                                var55_54 = 0;
                                                                                                var7_7 /* !! */  = null;
                                                                                                var4_4 /* !! */  = var36_33 /* !! */ [0];
                                                                                                if (var4_4 /* !! */  != var14_14 /* !! */  || (var7_7 /* !! */  = var36_33 /* !! */ [var57_56]) != var14_14 /* !! */ ) break block82;
                                                                                                var55_54 = 3;
                                                                                                if (var49_48 != var55_54 || var51_50 != var55_54) break block83;
                                                                                                var3_3.setupDimensionRatio((boolean)var23_23, (boolean)var21_21, (boolean)var11_11, (boolean)var17_17);
                                                                                                break block84;
                                                                                            }
                                                                                            var55_54 = 3;
                                                                                        }
                                                                                        var17_17 = false;
                                                                                        var18_18 = 0.0f;
                                                                                        var15_15 /* !! */  = null;
                                                                                        var37_34 /* !! */  = var36_33 /* !! */ [0];
                                                                                        if (var37_34 /* !! */  != var14_14 /* !! */  || var49_48 != var55_54) break block85;
                                                                                        var3_3.mResolvedDimensionRatioSide = 0;
                                                                                        var20_20 = var38_36;
                                                                                        var17_17 = (int)(var47_46 *= var20_20);
                                                                                        var38_36 = 1;
                                                                                        var39_38 = 1.4E-45f;
                                                                                        var5_5 /* !! */  = var36_33 /* !! */ [var38_36];
                                                                                        if (var5_5 /* !! */  != var14_14 /* !! */ ) {
                                                                                            var60_59 = var51_50;
                                                                                            var61_60 = var45_44 /* !! */ ;
                                                                                            var62_61 = var53_52;
                                                                                            var63_62 = 0;
                                                                                            var4_4 /* !! */  = null;
                                                                                        } else {
                                                                                            var63_62 = var38_36;
                                                                                            var62_61 = var49_48;
                                                                                            var60_59 = var51_50;
                                                                                            var61_60 = var45_44 /* !! */ ;
                                                                                        }
                                                                                        break block86;
                                                                                    }
                                                                                    var38_36 = 1;
                                                                                    var39_38 = 1.4E-45f;
                                                                                    var15_15 /* !! */  = var36_33 /* !! */ [var38_36];
                                                                                    if (var15_15 /* !! */  != var14_14 /* !! */ ) break block84;
                                                                                    var17_17 = 3;
                                                                                    var18_18 = 4.2E-45f;
                                                                                    if (var51_50 != var17_17) break block84;
                                                                                    var3_3.mResolvedDimensionRatioSide = var38_36;
                                                                                    var17_17 = -1;
                                                                                    var18_18 = 0.0f / 0.0f;
                                                                                    if (var28_28 == var17_17) {
                                                                                        var17_17 = 1065353216;
                                                                                        var3_3.mResolvedDimensionRatio = var18_18 = 1.0f / var47_46;
                                                                                    }
                                                                                    var18_18 = var3_3.mResolvedDimensionRatio;
                                                                                    var20_20 = var19_19;
                                                                                    var28_28 = (int)(var18_18 *= var20_20);
                                                                                    var5_5 /* !! */  = var36_33 /* !! */ [0];
                                                                                    var61_60 = var28_28;
                                                                                    var62_61 = var49_48;
                                                                                    if (var5_5 /* !! */  == var14_14 /* !! */ ) break block87;
                                                                                    var63_62 = 0;
                                                                                    var4_4 /* !! */  = null;
                                                                                    var17_17 = var42_41;
                                                                                    var60_59 = var53_52;
                                                                                    break block86;
                                                                                }
                                                                                var60_59 = var51_50;
                                                                                var17_17 = var42_41;
                                                                                break block88;
                                                                            }
                                                                            var62_61 = var49_48;
                                                                            var60_59 = var51_50;
                                                                            var17_17 = var42_41;
                                                                            var61_60 = var45_44 /* !! */ ;
                                                                        }
                                                                        var63_62 = 1;
                                                                        break block86;
                                                                    }
                                                                    var56_55 /* !! */  = var6_6 /* !! */ ;
                                                                }
                                                                var62_61 = var49_48;
                                                                var60_59 = var51_50;
                                                                var63_62 = 0;
                                                                var4_4 /* !! */  = null;
                                                                var17_17 = var42_41;
                                                                var61_60 = var45_44 /* !! */ ;
                                                            }
                                                            var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.mResolvedMatchConstraintDefault;
                                                            var5_5 /* !! */ [0] = var62_61;
                                                            var38_36 = 1;
                                                            var39_38 = 1.4E-45f;
                                                            var5_5 /* !! */ [var38_36] = var60_59;
                                                            var3_3.mResolvedHasRatio = var63_62;
                                                            if (var63_62 == 0) break block89;
                                                            var19_19 = var3_3.mResolvedDimensionRatioSide;
                                                            var38_36 = -1;
                                                            var39_38 = 0.0f / 0.0f;
                                                            if (var19_19 != 0 && var19_19 != var38_36) break block90;
                                                            var42_41 = true;
                                                            break block91;
                                                        }
                                                        var38_36 = -1;
                                                        var39_38 = 0.0f / 0.0f;
                                                    }
                                                    var42_41 = false;
                                                }
                                                var64_63 = var63_62 != 0 && ((var19_19 = var3_3.mResolvedDimensionRatioSide) == (var28_28 = 1) || var19_19 == var38_36);
                                                var5_5 /* !! */  = var3_3.mListDimensionBehaviors;
                                                var38_36 = 0;
                                                var39_38 = 0.0f;
                                                var16_16 = null;
                                                var5_5 /* !! */  = var5_5 /* !! */ [0];
                                                var6_6 /* !! */  = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                                                if (var5_5 /* !! */  == var6_6 /* !! */  && (var19_19 = var3_3 instanceof ConstraintWidgetContainer) != 0) {
                                                    var65_64 = 1;
                                                    var47_46 = 1.4E-45f;
                                                } else {
                                                    var65_64 = 0;
                                                    var47_46 = 0.0f;
                                                    var10_10 = null;
                                                }
                                                var45_44 /* !! */  = var65_64 != 0 ? 0 : var17_17;
                                                var19_19 = var3_3.mCenter.isConnected();
                                                var17_17 = 1;
                                                var18_18 = 1.4E-45f;
                                                var66_65 = var19_19 ^ true;
                                                var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.mIsInBarrier;
                                                var38_36 = 0;
                                                var39_38 = 0.0f;
                                                var16_16 = null;
                                                var67_66 = var5_5 /* !! */ [0];
                                                var68_67 = var5_5 /* !! */ [var17_17];
                                                var19_19 = var3_3.mHorizontalResolution;
                                                var55_54 = 2;
                                                if (var19_19 == var55_54 || (var19_19 = (int)var3_3.resolvedHorizontal) != 0) break block92;
                                                if (!var2_2 || (var5_5 /* !! */  = var3_3.horizontalRun) == null) break block93;
                                                var15_15 /* !! */  = var5_5 /* !! */ .start;
                                                var38_36 = (int)var15_15 /* !! */ .resolved;
                                                if (var38_36 == 0) break block93;
                                                var5_5 /* !! */  = var5_5 /* !! */ .end;
                                                var19_19 = (int)var5_5 /* !! */ .resolved;
                                                if (var19_19 == 0) break block93;
                                                if (!var2_2) break block94;
                                                var19_19 = var15_15 /* !! */ .value;
                                                var8_8 /* !! */  = var1_1;
                                                var9_9 /* !! */  = var56_55 /* !! */ ;
                                                var1_1.addEquality((SolverVariable)var56_55 /* !! */ , var19_19);
                                                var19_19 = var3_3.horizontalRun.end.value;
                                                var37_34 /* !! */  = var54_53 /* !! */ ;
                                                var1_1.addEquality((SolverVariable)var54_53 /* !! */ , var19_19);
                                                var5_5 /* !! */  = var3_3.mParent;
                                                if (var5_5 /* !! */  != null && var23_23 != 0) {
                                                    var5_5 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.isTerminalWidget;
                                                    var17_17 = 0;
                                                    var18_18 = 0.0f;
                                                    var15_15 /* !! */  = null;
                                                    var19_19 = (int)var5_5 /* !! */ [0];
                                                    if (var19_19 != 0 && (var19_19 = (int)this.isInHorizontalChain()) == 0) {
                                                        var5_5 /* !! */  = var3_3.mParent.mRight;
                                                        var5_5 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                                        var26_26 = 8;
                                                        var27_27 = 1.1E-44f;
                                                        var1_1.addGreaterThan((SolverVariable)var5_5 /* !! */ , (SolverVariable)var54_53 /* !! */ , 0, var26_26);
                                                    }
                                                }
                                                var69_68 = var23_23;
                                                var70_69 = var24_24;
                                                var71_70 = var21_21;
                                                var72_71 = var14_14 /* !! */ ;
                                                var54_53 /* !! */  = var37_34 /* !! */ ;
                                                var73_72 /* !! */  = var9_9 /* !! */ ;
                                                var74_73 /* !! */  = var6_6 /* !! */ ;
                                                var75_74 = var63_62;
                                                var76_75 = var46_45;
                                                var77_76 = var48_47;
                                                var78_77 = var50_49;
                                                break block95;
                                            }
                                            var8_8 /* !! */  = var1_1;
                                            break block92;
                                        }
                                        var8_8 /* !! */  = var1_1;
                                        var37_34 /* !! */  = var54_53 /* !! */ ;
                                        var9_9 /* !! */  = var56_55 /* !! */ ;
                                        var26_26 = 8;
                                        var27_27 = 1.1E-44f;
                                        var5_5 /* !! */  = var3_3.mParent;
                                        if (var5_5 /* !! */  != null) {
                                            var5_5 /* !! */  = var5_5 /* !! */ .mRight;
                                            var5_5 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                            var79_78 /* !! */  = var5_5 /* !! */ ;
                                        } else {
                                            var80_79 = false;
                                            var79_78 /* !! */  = null;
                                        }
                                        var5_5 /* !! */  = var3_3.mParent;
                                        if (var5_5 /* !! */  != null) {
                                            var5_5 /* !! */  = var5_5 /* !! */ .mLeft;
                                            var5_5 /* !! */  = var8_8 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                                            var54_53 /* !! */  = var5_5 /* !! */ ;
                                        } else {
                                            var54_53 /* !! */  = null;
                                        }
                                        var71_70 = var3_3.isTerminalWidget[0];
                                        var5_5 /* !! */  = var3_3.mListDimensionBehaviors;
                                        var73_72 /* !! */  = var5_5 /* !! */ [0];
                                        var35_32 /* !! */  = var3_3.mLeft;
                                        var15_15 /* !! */  = var3_3.mRight;
                                        var55_54 = var3_3.mX;
                                        var38_36 = var3_3.mMinWidth;
                                        var36_33 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.mMaxDimension;
                                        var81_80 = var36_33 /* !! */ [0];
                                        var27_27 = var3_3.mHorizontalBiasPercent;
                                        var43_42 = true;
                                        var44_43 = 1.4E-45f;
                                        var5_5 /* !! */  = var5_5 /* !! */ [var43_42];
                                        if (var5_5 /* !! */  == var14_14 /* !! */ ) {
                                            var82_81 = var43_42;
                                            var83_82 = var44_43;
                                        } else {
                                            var82_81 = false;
                                            var83_82 = 0.0f;
                                        }
                                        var52_51 = var3_3.mMatchConstraintMinWidth;
                                        var53_52 = var19_19 = var3_3.mMatchConstraintMaxWidth;
                                        var20_20 = var3_3.mMatchConstraintPercentWidth;
                                        var5_5 /* !! */  = this;
                                        var84_83 /* !! */  = var15_15 /* !! */ ;
                                        var15_15 /* !! */  = var1_1;
                                        var85_84 = var38_36;
                                        var38_36 = 1;
                                        var39_38 = 1.4E-45f;
                                        var28_28 = var23_23;
                                        var86_85 = var27_27;
                                        var26_26 = var21_21;
                                        var27_27 = var22_22;
                                        var69_68 = var23_23;
                                        var70_69 = var24_24;
                                        var23_23 = var71_70;
                                        var71_70 = var21_21;
                                        var25_25 /* !! */  = var54_53 /* !! */ ;
                                        var72_71 = var14_14 /* !! */ ;
                                        var14_14 /* !! */  = var79_78 /* !! */ ;
                                        var79_78 /* !! */  = var37_34 /* !! */ ;
                                        var37_34 /* !! */  = var73_72 /* !! */ ;
                                        var76_75 = var46_45;
                                        var87_86 = var9_9 /* !! */ ;
                                        var77_76 = var48_47;
                                        var9_9 /* !! */  = var35_32 /* !! */ ;
                                        var78_77 = var50_49;
                                        var8_8 /* !! */  = var84_83 /* !! */ ;
                                        var54_53 /* !! */  = var79_78 /* !! */ ;
                                        var74_73 /* !! */  = var6_6 /* !! */ ;
                                        var73_72 /* !! */  = var87_86;
                                        var57_56 = var45_44 /* !! */ ;
                                        var75_74 = var63_62;
                                        var63_62 = var85_84;
                                        var88_87 = var42_41;
                                        var43_42 = var82_81;
                                        var44_43 = var83_82;
                                        var42_41 = var41_40;
                                        var45_44 /* !! */  = (int)var67_66;
                                        var89_88 = var66_65;
                                        this.applyConstraints(var1_1, (boolean)var38_36, (boolean)var28_28, (boolean)var21_21, (boolean)var23_23, (SolverVariable)var25_25 /* !! */ , (SolverVariable)var14_14 /* !! */ , (ConstraintWidget$DimensionBehaviour)var37_34 /* !! */ , (boolean)var65_64, (ConstraintAnchor)var35_32 /* !! */ , (ConstraintAnchor)var84_83 /* !! */ , var55_54, var57_56, var85_84, (int)var81_80, var86_85, var88_87, var82_81, var40_39, var41_40, (boolean)var67_66, var62_61, var60_59, (int)var52_51, var19_19, var20_20, var66_65);
                                        break block95;
                                    }
                                    var69_68 = var23_23;
                                    var70_69 = var24_24;
                                    var72_71 = var14_14 /* !! */ ;
                                    var74_73 /* !! */  = var6_6 /* !! */ ;
                                    var75_74 = var63_62;
                                    var76_75 = var46_45;
                                    var77_76 = var48_47;
                                    var78_77 = var50_49;
                                    var73_72 /* !! */  = var56_55 /* !! */ ;
                                    var71_70 = var21_21;
                                }
                                if (!var2_2) break block96;
                                var3_3 = this;
                                var5_5 /* !! */  = this.verticalRun;
                                if (var5_5 /* !! */  == null) break block97;
                                var15_15 /* !! */  = var5_5 /* !! */ .start;
                                var38_36 = (int)var15_15 /* !! */ .resolved;
                                if (var38_36 == 0) break block97;
                                var5_5 /* !! */  = var5_5 /* !! */ .end;
                                var19_19 = (int)var5_5 /* !! */ .resolved;
                                if (var19_19 == 0) break block97;
                                var19_19 = var15_15 /* !! */ .value;
                                var4_4 /* !! */  = var1_1;
                                var6_6 /* !! */  = var78_77;
                                var1_1.addEquality(var78_77, var19_19);
                                var19_19 = this.verticalRun.end.value;
                                var7_7 /* !! */  = var77_76;
                                var1_1.addEquality(var77_76, var19_19);
                                var19_19 = this.verticalRun.baseline.value;
                                var15_15 /* !! */  = var76_75;
                                var1_1.addEquality(var76_75, var19_19);
                                var5_5 /* !! */  = this.mParent;
                                if (var5_5 /* !! */  != null && !var41_40 && var71_70 != 0) {
                                    var16_16 = this.isTerminalWidget;
                                    var51_50 = 1;
                                    var59_58 = 1.4E-45f;
                                    var38_36 = (int)var16_16[var51_50];
                                    if (var38_36 != 0) {
                                        var5_5 /* !! */  = var5_5 /* !! */ .mBottom;
                                        var5_5 /* !! */  = var1_1.createObjectVariable(var5_5 /* !! */ );
                                        var38_36 = 8;
                                        var39_38 = 1.1E-44f;
                                        var49_48 = 0;
                                        var58_57 = 0.0f;
                                        var9_9 /* !! */  = null;
                                        var1_1.addGreaterThan((SolverVariable)var5_5 /* !! */ , var77_76, 0, var38_36);
                                    } else {
                                        var38_36 = 8;
                                        var39_38 = 1.1E-44f;
                                        var49_48 = 0;
                                        var58_57 = 0.0f;
                                        var9_9 /* !! */  = null;
                                    }
                                } else {
                                    var38_36 = 8;
                                    var39_38 = 1.1E-44f;
                                    var49_48 = 0;
                                    var58_57 = 0.0f;
                                    var9_9 /* !! */  = null;
                                    var51_50 = 1;
                                    var59_58 = 1.4E-45f;
                                }
                                var11_11 = 0;
                                var37_34 /* !! */  = null;
                                var12_12 = 0.0f;
                                break block98;
                            }
                            var4_4 /* !! */  = var1_1;
                            var15_15 /* !! */  = var76_75;
                            var7_7 /* !! */  = var77_76;
                            var6_6 /* !! */  = var78_77;
                            var38_36 = 8;
                            var39_38 = 1.1E-44f;
                            var49_48 = 0;
                            var58_57 = 0.0f;
                            var9_9 /* !! */  = null;
                            var51_50 = 1;
                            var59_58 = 1.4E-45f;
                            break block99;
                        }
                        var38_36 = 8;
                        var39_38 = 1.1E-44f;
                        var49_48 = 0;
                        var58_57 = 0.0f;
                        var9_9 /* !! */  = null;
                        var51_50 = 1;
                        var59_58 = 1.4E-45f;
                        var3_3 = this;
                        var4_4 /* !! */  = var1_1;
                        var15_15 /* !! */  = var76_75;
                        var7_7 /* !! */  = var77_76;
                        var6_6 /* !! */  = var78_77;
                    }
                    var11_11 = var51_50;
                    var12_12 = var59_58;
                }
                var19_19 = var3_3.mVerticalResolution;
                var28_28 = 2;
                if (var19_19 == var28_28) {
                    var13_13 = 0;
                    var14_14 /* !! */  = null;
                } else {
                    var13_13 = var11_11;
                }
                if (var13_13 == 0 || (var19_19 = (int)var3_3.resolvedVertical) != 0) break block100;
                var5_5 /* !! */  = var3_3.mListDimensionBehaviors[var51_50];
                var35_32 /* !! */  = var74_73 /* !! */ ;
                if (var5_5 /* !! */  == var74_73 /* !! */  && (var19_19 = var3_3 instanceof ConstraintWidgetContainer) != 0) {
                    var65_64 = var51_50;
                    var47_46 = var59_58;
                } else {
                    var65_64 = 0;
                    var10_10 = null;
                    var47_46 = 0.0f;
                }
                if (var65_64 != 0) {
                    var61_60 = 0;
                }
                if ((var5_5 /* !! */  = var3_3.mParent) != null) {
                    var5_5 /* !! */  = var5_5 /* !! */ .mBottom;
                    var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                    var14_14 /* !! */  = var5_5 /* !! */ ;
                } else {
                    var13_13 = 0;
                    var14_14 /* !! */  = null;
                }
                var5_5 /* !! */  = var3_3.mParent;
                if (var5_5 /* !! */  != null) {
                    var5_5 /* !! */  = var5_5 /* !! */ .mTop;
                    var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                    var25_25 /* !! */  = var5_5 /* !! */ ;
                } else {
                    var21_21 = 0;
                    var25_25 /* !! */  = null;
                    var22_22 = 0.0f;
                }
                var19_19 = var3_3.mBaselineDistance;
                if (var19_19 <= 0 && (var19_19 = var3_3.mVisibility) != var38_36) ** GOTO lbl676
                var5_5 /* !! */  = var3_3.mBaseline.mTarget;
                if (var5_5 /* !! */  != null) {
                    var19_19 = this.getBaselineDistance();
                    var4_4 /* !! */ .addEquality((SolverVariable)var15_15 /* !! */ , (SolverVariable)var6_6 /* !! */ , var19_19, var38_36);
                    var5_5 /* !! */  = var3_3.mBaseline.mTarget;
                    var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                    var4_4 /* !! */ .addEquality((SolverVariable)var15_15 /* !! */ , (SolverVariable)var5_5 /* !! */ , 0, var38_36);
                    if (var71_70 != 0) {
                        var5_5 /* !! */  = var3_3.mBottom;
                        var5_5 /* !! */  = var4_4 /* !! */ .createObjectVariable(var5_5 /* !! */ );
                        var17_17 = 5;
                        var18_18 = 7.0E-45f;
                        var4_4 /* !! */ .addGreaterThan((SolverVariable)var14_14 /* !! */ , (SolverVariable)var5_5 /* !! */ , 0, var17_17);
                    }
                    var89_88 = false;
                    var50_49 = null;
                } else {
                    var19_19 = var3_3.mVisibility;
                    if (var19_19 == var38_36) {
                        var4_4 /* !! */ .addEquality((SolverVariable)var15_15 /* !! */ , (SolverVariable)var6_6 /* !! */ , 0, var38_36);
                    } else {
                        var19_19 = this.getBaselineDistance();
                        var4_4 /* !! */ .addEquality((SolverVariable)var15_15 /* !! */ , (SolverVariable)var6_6 /* !! */ , var19_19, var38_36);
                    }
lbl676:
                    // 3 sources

                    var89_88 = var66_65;
                }
                var23_23 = var3_3.isTerminalWidget[var51_50];
                var5_5 /* !! */  = var3_3.mListDimensionBehaviors;
                var37_34 /* !! */  = var5_5 /* !! */ [var51_50];
                var36_33 /* !! */  = var3_3.mTop;
                var35_32 /* !! */  = var3_3.mBottom;
                var17_17 = var3_3.mY;
                var38_36 = var3_3.mMinHeight;
                var9_9 /* !! */  = (ConstraintWidget$DimensionBehaviour[])var3_3.mMaxDimension;
                var80_79 = var9_9 /* !! */ [var51_50];
                var58_57 = var3_3.mVerticalBiasPercent;
                var88_87 = false;
                var5_5 /* !! */  = var5_5 /* !! */ [0];
                var8_8 /* !! */  = var72_71;
                if (var5_5 /* !! */  == var72_71) {
                    var43_42 = true;
                    var44_43 = 1.4E-45f;
                } else {
                    var43_42 = false;
                    var87_86 = null;
                    var44_43 = 0.0f;
                }
                var52_51 = var3_3.mMatchConstraintMinHeight;
                var53_52 = var19_19 = var3_3.mMatchConstraintMaxHeight;
                var20_20 = var3_3.mMatchConstraintPercentHeight;
                var5_5 /* !! */  = this;
                var15_15 /* !! */  = var1_1;
                var42_41 = var38_36;
                var38_36 = 0;
                var39_38 = 0.0f;
                var16_16 = null;
                var8_8 /* !! */  = var35_32 /* !! */ ;
                var28_28 = var71_70;
                var26_26 = var69_68;
                var27_27 = var70_69;
                var9_9 /* !! */  = var36_33 /* !! */ ;
                var56_55 /* !! */  = var7_7 /* !! */ ;
                var55_54 = var17_17;
                var90_89 /* !! */  = var6_6 /* !! */ ;
                var57_56 = var61_60;
                var63_62 = var42_41;
                var88_87 = var64_63;
                var42_41 = var40_39;
                var45_44 /* !! */  = var68_67;
                this.applyConstraints(var1_1, false, (boolean)var71_70, (boolean)var69_68, (boolean)var23_23, (SolverVariable)var25_25 /* !! */ , (SolverVariable)var14_14 /* !! */ , (ConstraintWidget$DimensionBehaviour)var37_34 /* !! */ , (boolean)var65_64, (ConstraintAnchor)var36_33 /* !! */ , (ConstraintAnchor)var35_32 /* !! */ , var17_17, var61_60, var63_62, var80_79, var58_57, var64_63, var43_42, var41_40, var40_39, (boolean)var68_67, var60_59, var62_61, (int)var52_51, var19_19, var20_20, var89_88);
                break block101;
            }
            var56_55 /* !! */  = var7_7 /* !! */ ;
            var90_89 /* !! */  = var6_6 /* !! */ ;
        }
        if (var75_74 != 0) {
            var21_21 = 8;
            var22_22 = 1.1E-44f;
            var14_14 /* !! */  = this;
            var19_19 = this.mResolvedDimensionRatioSide;
            var17_17 = 1;
            var18_18 = 1.4E-45f;
            if (var19_19 == var17_17) {
                var24_24 = this.mResolvedDimensionRatio;
                var5_5 /* !! */  = var1_1;
                var15_15 /* !! */  = var56_55 /* !! */ ;
                var16_16 = var90_89 /* !! */ ;
                var35_32 /* !! */  = var54_53 /* !! */ ;
                var36_33 /* !! */  = var73_72 /* !! */ ;
                var1_1.addRatio((SolverVariable)var56_55 /* !! */ , (SolverVariable)var90_89 /* !! */ , (SolverVariable)var54_53 /* !! */ , (SolverVariable)var73_72 /* !! */ , var24_24, var21_21);
            } else {
                var24_24 = this.mResolvedDimensionRatio;
                var21_21 = 8;
                var22_22 = 1.1E-44f;
                var5_5 /* !! */  = var1_1;
                var15_15 /* !! */  = var54_53 /* !! */ ;
                var16_16 = var73_72 /* !! */ ;
                var35_32 /* !! */  = var56_55 /* !! */ ;
                var36_33 /* !! */  = var90_89 /* !! */ ;
                var1_1.addRatio((SolverVariable)var54_53 /* !! */ , (SolverVariable)var73_72 /* !! */ , (SolverVariable)var56_55 /* !! */ , (SolverVariable)var90_89 /* !! */ , var24_24, var21_21);
            }
        } else {
            var14_14 /* !! */  = this;
        }
        var5_5 /* !! */  = var14_14 /* !! */ .mCenter;
        var19_19 = (int)var5_5 /* !! */ .isConnected();
        if (var19_19 != 0) {
            var5_5 /* !! */  = var14_14 /* !! */ .mCenter.getTarget().getOwner();
            var18_18 = var14_14 /* !! */ .mCircleConstraintAngle;
            var39_38 = 90.0f;
            var31_30 = Math.toRadians(var18_18 + var39_38);
            var18_18 = (float)var31_30;
            var16_16 = var14_14 /* !! */ .mCenter;
            var38_36 = var16_16.getMargin();
            var35_32 /* !! */  = var1_1;
            var1_1.addCenterPoint((ConstraintWidget)var14_14 /* !! */ , (ConstraintWidget)var5_5 /* !! */ , var18_18, var38_36);
        }
        var14_14 /* !! */ .resolvedHorizontal = false;
        var14_14 /* !! */ .resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        int n10 = this.mVisibility;
        int n11 = 8;
        n10 = n10 != n11 ? 1 : 0;
        return n10 != 0;
    }

    public void connect(ConstraintAnchor$Type constraintAnchor$Type, ConstraintWidget constraintWidget, ConstraintAnchor$Type constraintAnchor$Type2) {
        this.connect(constraintAnchor$Type, constraintWidget, constraintAnchor$Type2, 0);
    }

    public void connect(ConstraintAnchor$Type object, ConstraintWidget object2, ConstraintAnchor$Type object3, int n10) {
        Object object4 = ConstraintAnchor$Type.CENTER;
        ConstraintAnchor$Type constraintAnchor$Type = null;
        if (object == object4) {
            if (object3 == object4) {
                boolean bl2;
                boolean bl3;
                object = ConstraintAnchor$Type.LEFT;
                object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                ConstraintAnchor$Type constraintAnchor$Type2 = ConstraintAnchor$Type.RIGHT;
                ConstraintAnchor constraintAnchor = this.getAnchor(constraintAnchor$Type2);
                ConstraintAnchor$Type constraintAnchor$Type3 = ConstraintAnchor$Type.TOP;
                ConstraintAnchor constraintAnchor2 = this.getAnchor(constraintAnchor$Type3);
                ConstraintAnchor$Type constraintAnchor$Type4 = ConstraintAnchor$Type.BOTTOM;
                ConstraintAnchor constraintAnchor3 = this.getAnchor(constraintAnchor$Type4);
                boolean bl4 = true;
                if (object3 != null && (bl3 = ((ConstraintAnchor)object3).isConnected()) || constraintAnchor != null && (bl3 = constraintAnchor.isConnected())) {
                    bl2 = false;
                    object = null;
                } else {
                    this.connect((ConstraintAnchor$Type)((Object)object), (ConstraintWidget)object2, (ConstraintAnchor$Type)((Object)object), 0);
                    this.connect(constraintAnchor$Type2, (ConstraintWidget)object2, constraintAnchor$Type2, 0);
                    bl2 = bl4;
                }
                if (constraintAnchor2 != null && (bl3 = constraintAnchor2.isConnected()) || constraintAnchor3 != null && (bl3 = constraintAnchor3.isConnected())) {
                    bl4 = false;
                } else {
                    this.connect(constraintAnchor$Type3, (ConstraintWidget)object2, constraintAnchor$Type3, 0);
                    this.connect(constraintAnchor$Type4, (ConstraintWidget)object2, constraintAnchor$Type4, 0);
                }
                if (bl2 && bl4) {
                    object = this.getAnchor((ConstraintAnchor$Type)((Object)object4));
                    object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object4));
                    ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                } else if (bl2) {
                    object = ConstraintAnchor$Type.CENTER_X;
                    object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    ((ConstraintAnchor)object3).connect((ConstraintAnchor)object, 0);
                } else if (bl4) {
                    object = ConstraintAnchor$Type.CENTER_Y;
                    object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    ((ConstraintAnchor)object3).connect((ConstraintAnchor)object, 0);
                }
            } else {
                ConstraintAnchor$Type constraintAnchor$Type5;
                object = ConstraintAnchor$Type.LEFT;
                if (object3 != object && object3 != (constraintAnchor$Type5 = ConstraintAnchor$Type.RIGHT)) {
                    object = ConstraintAnchor$Type.TOP;
                    if (object3 == object || object3 == (constraintAnchor$Type5 = ConstraintAnchor$Type.BOTTOM)) {
                        this.connect((ConstraintAnchor$Type)((Object)object), (ConstraintWidget)object2, (ConstraintAnchor$Type)((Object)object3), 0);
                        object = ConstraintAnchor$Type.BOTTOM;
                        this.connect((ConstraintAnchor$Type)((Object)object), (ConstraintWidget)object2, (ConstraintAnchor$Type)((Object)object3), 0);
                        object = this.getAnchor((ConstraintAnchor$Type)((Object)object4));
                        object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                        ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                    }
                } else {
                    this.connect((ConstraintAnchor$Type)((Object)object), (ConstraintWidget)object2, (ConstraintAnchor$Type)((Object)object3), 0);
                    object = ConstraintAnchor$Type.RIGHT;
                    this.connect((ConstraintAnchor$Type)((Object)object), (ConstraintWidget)object2, (ConstraintAnchor$Type)((Object)object3), 0);
                    object = this.getAnchor((ConstraintAnchor$Type)((Object)object4));
                    object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                    ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                }
            }
        } else {
            Object object5;
            ConstraintAnchor$Type constraintAnchor$Type6;
            ConstraintAnchor$Type constraintAnchor$Type7 = ConstraintAnchor$Type.CENTER_X;
            if (object == constraintAnchor$Type7 && (object3 == (constraintAnchor$Type6 = ConstraintAnchor$Type.LEFT) || object3 == (object5 = ConstraintAnchor$Type.RIGHT))) {
                object = this.getAnchor(constraintAnchor$Type6);
                object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                object3 = ConstraintAnchor$Type.RIGHT;
                object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object3));
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                ((ConstraintAnchor)object3).connect((ConstraintAnchor)object2, 0);
                object = this.getAnchor(constraintAnchor$Type7);
                ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
            } else {
                ConstraintAnchor$Type constraintAnchor$Type8;
                constraintAnchor$Type6 = ConstraintAnchor$Type.CENTER_Y;
                if (object == constraintAnchor$Type6 && (object3 == (object5 = ConstraintAnchor$Type.TOP) || object3 == (constraintAnchor$Type8 = ConstraintAnchor$Type.BOTTOM))) {
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                    this.getAnchor((ConstraintAnchor$Type)((Object)object5)).connect((ConstraintAnchor)object, 0);
                    object2 = ConstraintAnchor$Type.BOTTOM;
                    this.getAnchor((ConstraintAnchor$Type)((Object)object2)).connect((ConstraintAnchor)object, 0);
                    object2 = this.getAnchor(constraintAnchor$Type6);
                    ((ConstraintAnchor)object2).connect((ConstraintAnchor)object, 0);
                } else if (object == constraintAnchor$Type7 && object3 == constraintAnchor$Type7) {
                    object = ConstraintAnchor$Type.LEFT;
                    ConstraintAnchor constraintAnchor = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    constraintAnchor.connect((ConstraintAnchor)object, 0);
                    object = ConstraintAnchor$Type.RIGHT;
                    constraintAnchor = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    constraintAnchor.connect((ConstraintAnchor)object, 0);
                    object = this.getAnchor(constraintAnchor$Type7);
                    object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                    ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                } else if (object == constraintAnchor$Type6 && object3 == constraintAnchor$Type6) {
                    object = ConstraintAnchor$Type.TOP;
                    ConstraintAnchor constraintAnchor = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    constraintAnchor.connect((ConstraintAnchor)object, 0);
                    object = ConstraintAnchor$Type.BOTTOM;
                    constraintAnchor = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    object = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object));
                    constraintAnchor.connect((ConstraintAnchor)object, 0);
                    object = this.getAnchor(constraintAnchor$Type6);
                    object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3));
                    ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, 0);
                } else {
                    object5 = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                    boolean bl5 = ((ConstraintAnchor)object5).isValidConnection((ConstraintAnchor)(object2 = ((ConstraintWidget)object2).getAnchor((ConstraintAnchor$Type)((Object)object3))));
                    if (bl5) {
                        object3 = ConstraintAnchor$Type.BASELINE;
                        if (object == object3) {
                            object = ConstraintAnchor$Type.TOP;
                            object = this.getAnchor((ConstraintAnchor$Type)((Object)object));
                            object3 = ConstraintAnchor$Type.BOTTOM;
                            object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object3));
                            if (object != null) {
                                ((ConstraintAnchor)object).reset();
                            }
                            if (object3 != null) {
                                ((ConstraintAnchor)object3).reset();
                            }
                            n10 = 0;
                            Object var7_11 = null;
                        } else {
                            constraintAnchor$Type = ConstraintAnchor$Type.TOP;
                            if (object != constraintAnchor$Type && object != (constraintAnchor$Type = ConstraintAnchor$Type.BOTTOM)) {
                                object3 = ConstraintAnchor$Type.LEFT;
                                if (object == object3 || object == (object3 = ConstraintAnchor$Type.RIGHT)) {
                                    object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object4));
                                    if ((object4 = ((ConstraintAnchor)object3).getTarget()) != object2) {
                                        ((ConstraintAnchor)object3).reset();
                                    }
                                    object = this.getAnchor((ConstraintAnchor$Type)((Object)object)).getOpposite();
                                    object3 = this.getAnchor(constraintAnchor$Type7);
                                    boolean bl6 = ((ConstraintAnchor)object3).isConnected();
                                    if (bl6) {
                                        ((ConstraintAnchor)object).reset();
                                        ((ConstraintAnchor)object3).reset();
                                    }
                                }
                            } else {
                                if ((object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object3))) != null) {
                                    ((ConstraintAnchor)object3).reset();
                                }
                                if ((object4 = ((ConstraintAnchor)(object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object4)))).getTarget()) != object2) {
                                    ((ConstraintAnchor)object3).reset();
                                }
                                object = this.getAnchor((ConstraintAnchor$Type)((Object)object)).getOpposite();
                                object3 = this.getAnchor(constraintAnchor$Type6);
                                boolean bl7 = ((ConstraintAnchor)object3).isConnected();
                                if (bl7) {
                                    ((ConstraintAnchor)object).reset();
                                    ((ConstraintAnchor)object3).reset();
                                }
                            }
                        }
                        ((ConstraintAnchor)object5).connect((ConstraintAnchor)object2, n10);
                    }
                }
            }
        }
    }

    public void connect(ConstraintAnchor object, ConstraintAnchor object2, int n10) {
        ConstraintWidget constraintWidget = object.getOwner();
        if (constraintWidget == this) {
            object = object.getType();
            constraintWidget = object2.getOwner();
            object2 = object2.getType();
            this.connect((ConstraintAnchor$Type)((Object)object), constraintWidget, (ConstraintAnchor$Type)((Object)object2), n10);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f10, int n10) {
        ConstraintAnchor$Type constraintAnchor$Type = ConstraintAnchor$Type.CENTER;
        this.immediateConnect(constraintAnchor$Type, constraintWidget, constraintAnchor$Type, n10, 0);
        this.mCircleConstraintAngle = f10;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap hashMap) {
        float f10;
        int n10;
        int n11;
        int n12;
        this.mHorizontalResolution = n12 = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = n12 = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = n12 = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = n12 = constraintWidget.mMatchConstraintDefaultHeight;
        Object object = this.mResolvedMatchConstraintDefault;
        Object object2 = constraintWidget.mResolvedMatchConstraintDefault;
        Object object3 = null;
        object[0] = n11 = object2[0];
        n11 = 1;
        object[n11] = n10 = object2[n11];
        this.mMatchConstraintMinWidth = n12 = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = n12 = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = n12 = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = n12 = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = f10 = constraintWidget.mMatchConstraintPercentHeight;
        n12 = constraintWidget.mIsWidthWrapContent ? 1 : 0;
        this.mIsWidthWrapContent = n12;
        n12 = constraintWidget.mIsHeightWrapContent ? 1 : 0;
        this.mIsHeightWrapContent = n12;
        this.mResolvedDimensionRatioSide = n12 = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = f10 = constraintWidget.mResolvedDimensionRatio;
        object = constraintWidget.mMaxDimension;
        n10 = ((int[])object).length;
        object = Arrays.copyOf(object, n10);
        this.mMaxDimension = object;
        this.mCircleConstraintAngle = f10 = constraintWidget.mCircleConstraintAngle;
        n12 = constraintWidget.hasBaseline ? 1 : 0;
        this.hasBaseline = n12;
        n12 = constraintWidget.inPlaceholder ? 1 : 0;
        this.inPlaceholder = n12;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        object = Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mListDimensionBehaviors = (ConstraintWidget$DimensionBehaviour[])object;
        object = this.mParent;
        n10 = 0;
        object2 = null;
        if (object == null) {
            n12 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            object = constraintWidget.mParent;
            object = (ConstraintWidget)hashMap.get(object);
        }
        this.mParent = object;
        this.mWidth = n12 = constraintWidget.mWidth;
        this.mHeight = n12 = constraintWidget.mHeight;
        this.mDimensionRatio = f10 = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = n12 = constraintWidget.mDimensionRatioSide;
        this.mX = n12 = constraintWidget.mX;
        this.mY = n12 = constraintWidget.mY;
        this.mRelX = n12 = constraintWidget.mRelX;
        this.mRelY = n12 = constraintWidget.mRelY;
        this.mOffsetX = n12 = constraintWidget.mOffsetX;
        this.mOffsetY = n12 = constraintWidget.mOffsetY;
        this.mBaselineDistance = n12 = constraintWidget.mBaselineDistance;
        this.mMinWidth = n12 = constraintWidget.mMinWidth;
        this.mMinHeight = n12 = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = f10 = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = f10 = constraintWidget.mVerticalBiasPercent;
        object = constraintWidget.mCompanionWidget;
        this.mCompanionWidget = object;
        this.mContainerItemSkip = n12 = constraintWidget.mContainerItemSkip;
        this.mVisibility = n12 = constraintWidget.mVisibility;
        object = constraintWidget.mDebugName;
        this.mDebugName = object;
        object = constraintWidget.mType;
        this.mType = object;
        this.mDistToTop = n12 = constraintWidget.mDistToTop;
        this.mDistToLeft = n12 = constraintWidget.mDistToLeft;
        this.mDistToRight = n12 = constraintWidget.mDistToRight;
        this.mDistToBottom = n12 = constraintWidget.mDistToBottom;
        n12 = constraintWidget.mLeftHasCentered ? 1 : 0;
        this.mLeftHasCentered = n12;
        n12 = constraintWidget.mRightHasCentered ? 1 : 0;
        this.mRightHasCentered = n12;
        n12 = constraintWidget.mTopHasCentered ? 1 : 0;
        this.mTopHasCentered = n12;
        n12 = constraintWidget.mBottomHasCentered ? 1 : 0;
        this.mBottomHasCentered = n12;
        n12 = constraintWidget.mHorizontalWrapVisited ? 1 : 0;
        this.mHorizontalWrapVisited = n12;
        n12 = constraintWidget.mVerticalWrapVisited ? 1 : 0;
        this.mVerticalWrapVisited = n12;
        this.mHorizontalChainStyle = n12 = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = n12 = constraintWidget.mVerticalChainStyle;
        n12 = constraintWidget.mHorizontalChainFixedPosition ? 1 : 0;
        this.mHorizontalChainFixedPosition = n12;
        n12 = constraintWidget.mVerticalChainFixedPosition ? 1 : 0;
        this.mVerticalChainFixedPosition = n12;
        object = this.mWeight;
        Object object4 = constraintWidget.mWeight;
        float f11 = object4[0];
        object[0] = (int)f11;
        float f12 = object4[n11];
        object[n11] = (int)f12;
        object = this.mListNextMatchConstraintsWidget;
        object4 = constraintWidget.mListNextMatchConstraintsWidget;
        float f13 = object4[0];
        object[0] = (int)f13;
        object4 = object4[n11];
        object[n11] = (int)object4;
        object = this.mNextChainWidget;
        object4 = constraintWidget.mNextChainWidget;
        f13 = object4[0];
        object[0] = (int)f13;
        object3 = object4[n11];
        object[n11] = (int)object3;
        object = constraintWidget.mHorizontalNextWidget;
        if (object == null) {
            n12 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            object = (ConstraintWidget)hashMap.get(object);
        }
        this.mHorizontalNextWidget = object;
        constraintWidget = constraintWidget.mVerticalNextWidget;
        if (constraintWidget != null) {
            constraintWidget = hashMap.get(constraintWidget);
            object2 = constraintWidget;
            object2 = constraintWidget;
        }
        this.mVerticalNextWidget = object2;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        ConstraintAnchor constraintAnchor = this.mLeft;
        linearSystem.createObjectVariable(constraintAnchor);
        constraintAnchor = this.mTop;
        linearSystem.createObjectVariable(constraintAnchor);
        constraintAnchor = this.mRight;
        linearSystem.createObjectVariable(constraintAnchor);
        constraintAnchor = this.mBottom;
        linearSystem.createObjectVariable(constraintAnchor);
        int n10 = this.mBaselineDistance;
        if (n10 > 0) {
            constraintAnchor = this.mBaseline;
            linearSystem.createObjectVariable(constraintAnchor);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        WidgetRun widgetRun = this.horizontalRun;
        if (widgetRun == null) {
            this.horizontalRun = widgetRun = new HorizontalWidgetRun(this);
        }
        if ((widgetRun = this.verticalRun) == null) {
            widgetRun = new VerticalWidgetRun(this);
            this.verticalRun = widgetRun;
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor$Type object) {
        Object object2 = ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                object2 = new AssertionError;
                object = object.name();
                object2(object);
                throw object2;
            }
            case 9: {
                return null;
            }
            case 8: {
                return this.mCenterY;
            }
            case 7: {
                return this.mCenterX;
            }
            case 6: {
                return this.mCenter;
            }
            case 5: {
                return this.mBaseline;
            }
            case 4: {
                return this.mBottom;
            }
            case 3: {
                return this.mRight;
            }
            case 2: {
                return this.mTop;
            }
            case 1: 
        }
        return this.mLeft;
    }

    public ArrayList getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int n10) {
        if (n10 == 0) {
            return this.mHorizontalBiasPercent;
        }
        int n11 = 1;
        if (n10 == n11) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        int n10 = this.getY();
        int n11 = this.mHeight;
        return n10 + n11;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public ConstraintWidget$DimensionBehaviour getDimensionBehaviour(int n10) {
        if (n10 == 0) {
            return this.getHorizontalDimensionBehaviour();
        }
        int n11 = 1;
        if (n10 == n11) {
            return this.getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        int n10 = this.mVisibility;
        int n11 = 8;
        if (n10 == n11) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        ConstraintWidget constraintWidget;
        block6: {
            boolean bl2 = this.isInHorizontalChain();
            constraintWidget = null;
            if (bl2) {
                Object object = this;
                bl2 = false;
                Object object2 = null;
                while (object2 == null && object != null) {
                    Object object3;
                    Object object4 = ConstraintAnchor$Type.LEFT;
                    object4 = (object4 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object4))) == null ? null : ((ConstraintAnchor)object4).getTarget();
                    if ((object4 = object4 == null ? null : ((ConstraintAnchor)object4).getOwner()) == (object3 = this.getParent())) {
                        constraintWidget = object;
                        break block6;
                    }
                    if (object4 == null) {
                        object3 = null;
                    } else {
                        object3 = ConstraintAnchor$Type.RIGHT;
                        object3 = ((ConstraintWidget)object4).getAnchor((ConstraintAnchor$Type)((Object)object3)).getTarget();
                    }
                    if (object3 != null && (object3 = ((ConstraintAnchor)object3).getOwner()) != object) {
                        object2 = object;
                        continue;
                    }
                    object = object4;
                }
                constraintWidget = object2;
            }
        }
        return constraintWidget;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public ConstraintWidget$DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        int n10;
        ConstraintAnchor constraintAnchor = this.mLeft;
        int n11 = 0;
        if (constraintAnchor != null) {
            n10 = constraintAnchor.mMargin;
            n11 = 0 + n10;
        }
        if ((constraintAnchor = this.mRight) != null) {
            n10 = constraintAnchor.mMargin;
            n11 += n10;
        }
        return n11;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return this.getX();
    }

    public int getLength(int n10) {
        if (n10 == 0) {
            return this.getWidth();
        }
        int n11 = 1;
        if (n10 == n11) {
            return this.getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int n10) {
        if (n10 == 0) {
            ConstraintAnchor constraintAnchor;
            ConstraintAnchor constraintAnchor2 = this.mRight;
            ConstraintAnchor constraintAnchor3 = constraintAnchor2.mTarget;
            if (constraintAnchor3 != null && (constraintAnchor = constraintAnchor3.mTarget) == constraintAnchor2) {
                return constraintAnchor3.mOwner;
            }
        } else {
            int n11 = 1;
            if (n10 == n11) {
                ConstraintAnchor constraintAnchor;
                ConstraintAnchor constraintAnchor4 = this.mBottom;
                ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
                if (constraintAnchor5 != null && (constraintAnchor = constraintAnchor5.mTarget) == constraintAnchor4) {
                    return constraintAnchor5.mOwner;
                }
            }
        }
        return null;
    }

    public int getOptimizerWrapHeight() {
        int n10 = this.mHeight;
        Object object = this.mListDimensionBehaviors;
        int n11 = 1;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if ((object = object[n11]) == constraintWidget$DimensionBehaviour) {
            int n12 = this.mMatchConstraintDefaultHeight;
            if (n12 == n11) {
                n12 = this.mMatchConstraintMinHeight;
                n10 = Math.max(n12, n10);
            } else {
                n10 = this.mMatchConstraintMinHeight;
                if (n10 > 0) {
                    this.mHeight = n10;
                } else {
                    n10 = 0;
                }
            }
            n12 = this.mMatchConstraintMaxHeight;
            if (n12 > 0 && n12 < n10) {
                n10 = n12;
            }
        }
        return n10;
    }

    public int getOptimizerWrapWidth() {
        int n10 = this.mWidth;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = this.mListDimensionBehaviors[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2) {
            int n11 = this.mMatchConstraintDefaultWidth;
            int n12 = 1;
            if (n11 == n12) {
                n11 = this.mMatchConstraintMinWidth;
                n10 = Math.max(n11, n10);
            } else {
                n10 = this.mMatchConstraintMinWidth;
                if (n10 > 0) {
                    this.mWidth = n10;
                } else {
                    n10 = 0;
                }
            }
            n11 = this.mMatchConstraintMaxWidth;
            if (n11 > 0 && n11 < n10) {
                n10 = n11;
            }
        }
        return n10;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int n10) {
        if (n10 == 0) {
            ConstraintAnchor constraintAnchor;
            ConstraintAnchor constraintAnchor2 = this.mLeft;
            ConstraintAnchor constraintAnchor3 = constraintAnchor2.mTarget;
            if (constraintAnchor3 != null && (constraintAnchor = constraintAnchor3.mTarget) == constraintAnchor2) {
                return constraintAnchor3.mOwner;
            }
        } else {
            int n11 = 1;
            if (n10 == n11) {
                ConstraintAnchor constraintAnchor;
                ConstraintAnchor constraintAnchor4 = this.mTop;
                ConstraintAnchor constraintAnchor5 = constraintAnchor4.mTarget;
                if (constraintAnchor5 != null && (constraintAnchor = constraintAnchor5.mTarget) == constraintAnchor4) {
                    return constraintAnchor5.mOwner;
                }
            }
        }
        return null;
    }

    public int getRelativePositioning(int n10) {
        if (n10 == 0) {
            return this.mRelX;
        }
        int n11 = 1;
        if (n10 == n11) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        int n10 = this.getX();
        int n11 = this.mWidth;
        return n10 + n11;
    }

    public int getRootX() {
        int n10 = this.mX;
        int n11 = this.mOffsetX;
        return n10 + n11;
    }

    public int getRootY() {
        int n10 = this.mY;
        int n11 = this.mOffsetY;
        return n10 + n11;
    }

    public WidgetRun getRun(int n10) {
        if (n10 == 0) {
            return this.horizontalRun;
        }
        int n11 = 1;
        if (n10 == n11) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return this.getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        ConstraintWidget constraintWidget;
        block6: {
            boolean bl2 = this.isInVerticalChain();
            constraintWidget = null;
            if (bl2) {
                Object object = this;
                bl2 = false;
                Object object2 = null;
                while (object2 == null && object != null) {
                    Object object3;
                    Object object4 = ConstraintAnchor$Type.TOP;
                    object4 = (object4 = ((ConstraintWidget)object).getAnchor((ConstraintAnchor$Type)((Object)object4))) == null ? null : ((ConstraintAnchor)object4).getTarget();
                    if ((object4 = object4 == null ? null : ((ConstraintAnchor)object4).getOwner()) == (object3 = this.getParent())) {
                        constraintWidget = object;
                        break block6;
                    }
                    if (object4 == null) {
                        object3 = null;
                    } else {
                        object3 = ConstraintAnchor$Type.BOTTOM;
                        object3 = ((ConstraintWidget)object4).getAnchor((ConstraintAnchor$Type)((Object)object3)).getTarget();
                    }
                    if (object3 != null && (object3 = ((ConstraintAnchor)object3).getOwner()) != object) {
                        object2 = object;
                        continue;
                    }
                    object = object4;
                }
                constraintWidget = object2;
            }
        }
        return constraintWidget;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public ConstraintWidget$DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int n10;
        ConstraintAnchor constraintAnchor = this.mLeft;
        int n11 = 0;
        if (constraintAnchor != null) {
            constraintAnchor = this.mTop;
            n10 = constraintAnchor.mMargin;
            n11 = 0 + n10;
        }
        if ((constraintAnchor = this.mRight) != null) {
            constraintAnchor = this.mBottom;
            n10 = constraintAnchor.mMargin;
            n11 += n10;
        }
        return n11;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        int n10 = this.mVisibility;
        int n11 = 8;
        if (n10 == n11) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        int n10;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (n10 = constraintWidget instanceof ConstraintWidgetContainer) != 0) {
            int n11 = ((ConstraintWidgetContainer)constraintWidget).mPaddingLeft;
            n10 = this.mX;
            return n11 + n10;
        }
        return this.mX;
    }

    public int getY() {
        int n10;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget != null && (n10 = constraintWidget instanceof ConstraintWidgetContainer) != 0) {
            int n11 = ((ConstraintWidgetContainer)constraintWidget).mPaddingTop;
            n10 = this.mY;
            return n11 + n10;
        }
        return this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int n10) {
        int n11;
        int n12 = 2;
        int n13 = 1;
        if (n10 == 0) {
            int n14;
            ConstraintAnchor constraintAnchor = this.mLeft.mTarget;
            if (constraintAnchor != null) {
                n10 = n13;
            } else {
                n10 = 0;
                constraintAnchor = null;
            }
            ConstraintAnchor constraintAnchor2 = this.mRight.mTarget;
            if (constraintAnchor2 != null) {
                n14 = n13;
            } else {
                n14 = 0;
                constraintAnchor2 = null;
            }
            if ((n10 += n14) >= n12) {
                n13 = 0;
            }
            return n13 != 0;
        }
        ConstraintAnchor constraintAnchor = this.mTop.mTarget;
        if (constraintAnchor != null) {
            n10 = n13;
        } else {
            n10 = 0;
            constraintAnchor = null;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom.mTarget;
        if (constraintAnchor3 != null) {
            n11 = n13;
        } else {
            n11 = 0;
            constraintAnchor3 = null;
        }
        n10 += n11;
        constraintAnchor3 = this.mBaseline.mTarget;
        if (constraintAnchor3 != null) {
            n11 = n13;
        } else {
            n11 = 0;
            constraintAnchor3 = null;
        }
        if ((n10 += n11) >= n12) {
            n13 = 0;
        }
        return n13 != 0;
    }

    public boolean hasDependencies() {
        ArrayList arrayList = this.mAnchors;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor)this.mAnchors.get(i10);
            boolean bl2 = constraintAnchor.hasDependents();
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor$Type object, ConstraintWidget object2, ConstraintAnchor$Type constraintAnchor$Type, int n10, int n11) {
        object = this.getAnchor((ConstraintAnchor$Type)((Object)object));
        object2 = ((ConstraintWidget)object2).getAnchor(constraintAnchor$Type);
        ((ConstraintAnchor)object).connect((ConstraintAnchor)object2, n10, n11, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        block3: {
            block2: {
                ConstraintAnchor constraintAnchor = this.mLeft;
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && (constraintAnchor2 = constraintAnchor2.mTarget) == constraintAnchor) break block2;
                constraintAnchor = this.mRight;
                constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || (constraintAnchor2 = constraintAnchor2.mTarget) != constraintAnchor) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        block3: {
            block2: {
                ConstraintAnchor constraintAnchor = this.mTop;
                ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 != null && (constraintAnchor2 = constraintAnchor2.mTarget) == constraintAnchor) break block2;
                constraintAnchor = this.mBottom;
                constraintAnchor2 = constraintAnchor.mTarget;
                if (constraintAnchor2 == null || (constraintAnchor2 = constraintAnchor2.mTarget) != constraintAnchor) break block3;
            }
            return true;
        }
        return false;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        int n10;
        int n11 = this.mMeasureRequested;
        n11 = n11 != 0 && (n11 = this.mVisibility) != (n10 = 8) ? 1 : 0;
        return n11 != 0;
    }

    public boolean isResolvedHorizontally() {
        ConstraintAnchor constraintAnchor;
        boolean bl2 = this.resolvedHorizontal;
        if (!(bl2 || (bl2 = (constraintAnchor = this.mLeft).hasFinalValue()) && (bl2 = (constraintAnchor = this.mRight).hasFinalValue()))) {
            bl2 = false;
            constraintAnchor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isResolvedVertically() {
        ConstraintAnchor constraintAnchor;
        boolean bl2 = this.resolvedVertical;
        if (!(bl2 || (bl2 = (constraintAnchor = this.mTop).hasFinalValue()) && (bl2 = (constraintAnchor = this.mBottom).hasFinalValue()))) {
            bl2 = false;
            constraintAnchor = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isRoot() {
        boolean bl2;
        ConstraintWidget constraintWidget = this.mParent;
        if (constraintWidget == null) {
            bl2 = true;
        } else {
            bl2 = false;
            constraintWidget = null;
        }
        return bl2;
    }

    public boolean isSpreadHeight() {
        int n10;
        block3: {
            block2: {
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
                int n11 = this.mMatchConstraintDefaultHeight;
                n10 = 1;
                if (n11 != 0) break block2;
                float f10 = this.mDimensionRatio;
                ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = null;
                float f11 = f10 - 0.0f;
                n11 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
                if (n11 == 0 && (n11 = this.mMatchConstraintMinHeight) == 0 && (n11 = this.mMatchConstraintMaxHeight) == 0 && (constraintWidget$DimensionBehaviour = this.mListDimensionBehaviors[n10]) == (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) break block3;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean isSpreadWidth() {
        int n10 = this.mMatchConstraintDefaultWidth;
        boolean bl2 = false;
        if (n10 == 0) {
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
            float f10 = this.mDimensionRatio;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = null;
            float f11 = f10 - 0.0f;
            n10 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (n10 == 0 && (n10 = this.mMatchConstraintMinWidth) == 0 && (n10 = this.mMatchConstraintMaxWidth) == 0 && (constraintWidget$DimensionBehaviour = this.mListDimensionBehaviors[0]) == (constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int n10) {
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        boolean bl2;
        boolean bl3 = true;
        if (n10 == 0) {
            bl2 = bl3;
        } else {
            bl2 = false;
            constraintWidget$DimensionBehaviour = null;
        }
        Object object = this.mListDimensionBehaviors;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = object[n10];
        constraintWidget$DimensionBehaviour = object[bl2];
        object = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        if (constraintWidget$DimensionBehaviour2 != object || constraintWidget$DimensionBehaviour != object) {
            bl3 = false;
        }
        return bl3;
    }

    public boolean oppositeDimensionsTied() {
        Object object = this.mListDimensionBehaviors;
        int n10 = 0;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = object[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
        int n11 = 1;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && (object = object[n11]) == constraintWidget$DimensionBehaviour2) {
            n10 = n11;
        }
        return n10 != 0;
    }

    public void reset() {
        float f10;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour;
        float f11;
        int n10;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = n10 = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mHorizontalBiasPercent = f11 = DEFAULT_BIAS;
        this.mVerticalBiasPercent = f11;
        ConstraintWidget$DimensionBehaviour[] constraintWidget$DimensionBehaviourArray = this.mListDimensionBehaviors;
        constraintWidget$DimensionBehaviourArray[0] = constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
        int n11 = 1;
        constraintWidget$DimensionBehaviourArray[n11] = constraintWidget$DimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        Object[] objectArray = this.mWeight;
        objectArray[0] = f11 = -1.0f;
        objectArray[n11] = f11;
        this.mHorizontalResolution = n10;
        this.mVerticalResolution = n10;
        objectArray = this.mMaxDimension;
        int n12 = -1 >>> 1;
        objectArray[0] = n12;
        objectArray[n11] = n12;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = f10 = 1.0f;
        this.mMatchConstraintPercentHeight = f10;
        this.mMatchConstraintMaxWidth = n12;
        this.mMatchConstraintMaxHeight = n12;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = n10;
        this.mResolvedDimensionRatio = f10;
        this.mGroupsToSolver = false;
        objectArray = this.isTerminalWidget;
        objectArray[0] = n11;
        objectArray[n11] = n11;
        this.mInVirtuaLayout = false;
        objectArray = this.mIsInBarrier;
        objectArray[0] = 0.0f;
        objectArray[n11] = 0.0f;
        this.mMeasureRequested = n11;
    }

    public void resetAllConstraints() {
        this.resetAnchors();
        float f10 = DEFAULT_BIAS;
        this.setVerticalBiasPercent(f10);
        f10 = DEFAULT_BIAS;
        this.setHorizontalBiasPercent(f10);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        boolean bl2;
        Object object = this.getParent();
        if (object != null && (bl2 = (object = this.getParent()) instanceof ConstraintWidgetContainer) && (bl2 = ((ConstraintWidgetContainer)(object = (ConstraintWidgetContainer)this.getParent())).handlesInternalConstraints())) {
            return;
        }
        object = ConstraintAnchor$Type.LEFT;
        object = this.getAnchor((ConstraintAnchor$Type)((Object)object));
        Object object2 = ConstraintAnchor$Type.RIGHT;
        object2 = this.getAnchor((ConstraintAnchor$Type)((Object)object2));
        Object object3 = ConstraintAnchor$Type.TOP;
        object3 = this.getAnchor((ConstraintAnchor$Type)((Object)object3));
        Object object4 = ConstraintAnchor$Type.BOTTOM;
        object4 = this.getAnchor((ConstraintAnchor$Type)((Object)object4));
        Object object5 = ConstraintAnchor$Type.CENTER;
        object5 = this.getAnchor((ConstraintAnchor$Type)((Object)object5));
        Object object6 = ConstraintAnchor$Type.CENTER_X;
        object6 = this.getAnchor((ConstraintAnchor$Type)((Object)object6));
        Object object7 = ConstraintAnchor$Type.CENTER_Y;
        object7 = this.getAnchor((ConstraintAnchor$Type)((Object)object7));
        float f10 = 0.5f;
        if (constraintAnchor == object5) {
            boolean bl3 = ((ConstraintAnchor)object).isConnected();
            if (bl3 && (bl3 = ((ConstraintAnchor)object2).isConnected()) && (object5 = ((ConstraintAnchor)object).getTarget()) == (object6 = ((ConstraintAnchor)object2).getTarget())) {
                ((ConstraintAnchor)object).reset();
                ((ConstraintAnchor)object2).reset();
            }
            if ((bl2 = ((ConstraintAnchor)object3).isConnected()) && (bl2 = ((ConstraintAnchor)object4).isConnected()) && (object = ((ConstraintAnchor)object3).getTarget()) == (object2 = ((ConstraintAnchor)object4).getTarget())) {
                ((ConstraintAnchor)object3).reset();
                ((ConstraintAnchor)object4).reset();
            }
            this.mHorizontalBiasPercent = f10;
            this.mVerticalBiasPercent = f10;
        } else if (constraintAnchor == object6) {
            boolean bl4 = ((ConstraintAnchor)object).isConnected();
            if (bl4 && (bl4 = ((ConstraintAnchor)object2).isConnected()) && (object3 = ((ConstraintAnchor)object).getTarget().getOwner()) == (object4 = ((ConstraintAnchor)object2).getTarget().getOwner())) {
                ((ConstraintAnchor)object).reset();
                ((ConstraintAnchor)object2).reset();
            }
            this.mHorizontalBiasPercent = f10;
        } else if (constraintAnchor == object7) {
            bl2 = ((ConstraintAnchor)object3).isConnected();
            if (bl2 && (bl2 = ((ConstraintAnchor)object4).isConnected()) && (object = ((ConstraintAnchor)object3).getTarget().getOwner()) == (object2 = ((ConstraintAnchor)object4).getTarget().getOwner())) {
                ((ConstraintAnchor)object3).reset();
                ((ConstraintAnchor)object4).reset();
            }
            this.mVerticalBiasPercent = f10;
        } else if (constraintAnchor != object && constraintAnchor != object2) {
            if ((constraintAnchor == object3 || constraintAnchor == object4) && (bl2 = ((ConstraintAnchor)object3).isConnected()) && (object = ((ConstraintAnchor)object3).getTarget()) == (object2 = ((ConstraintAnchor)object4).getTarget())) {
                ((ConstraintAnchor)object5).reset();
            }
        } else {
            boolean bl5 = ((ConstraintAnchor)object).isConnected();
            if (bl5 && (object = ((ConstraintAnchor)object).getTarget()) == (object2 = ((ConstraintAnchor)object2).getTarget())) {
                ((ConstraintAnchor)object5).reset();
            }
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        int n10;
        ConstraintWidget constraintWidget = this.getParent();
        if (constraintWidget != null && (n10 = constraintWidget instanceof ConstraintWidgetContainer) != 0 && (n10 = ((ConstraintWidgetContainer)(constraintWidget = (ConstraintWidgetContainer)this.getParent())).handlesInternalConstraints()) != 0) {
            return;
        }
        constraintWidget = null;
        ArrayList arrayList = this.mAnchors;
        int n11 = arrayList.size();
        for (n10 = 0; n10 < n11; ++n10) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor)this.mAnchors.get(n10);
            constraintAnchor.reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        ArrayList arrayList = this.mAnchors;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor)this.mAnchors.get(i10);
            constraintAnchor.resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int n10) {
        this.mBaselineDistance = n10;
        n10 = n10 > 0 ? 1 : 0;
        this.hasBaseline = n10;
    }

    public void setCompanionWidget(Object object) {
        this.mCompanionWidget = object;
    }

    public void setContainerItemSkip(int n10) {
        if (n10 >= 0) {
            this.mContainerItemSkip = n10;
        } else {
            n10 = 0;
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String string2) {
        this.mDebugName = string2;
    }

    public void setDebugSolverName(LinearSystem object, String string2) {
        this.mDebugName = string2;
        Object object2 = this.mLeft;
        object2 = ((LinearSystem)object).createObjectVariable(object2);
        Object object3 = this.mTop;
        object3 = ((LinearSystem)object).createObjectVariable(object3);
        Object object4 = this.mRight;
        object4 = ((LinearSystem)object).createObjectVariable(object4);
        Object object5 = this.mBottom;
        object5 = ((LinearSystem)object).createObjectVariable(object5);
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append(".left");
        charSequence = charSequence.toString();
        ((SolverVariable)object2).setName((String)charSequence);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(".top");
        object2 = ((StringBuilder)object2).toString();
        ((SolverVariable)object3).setName((String)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(".right");
        object2 = ((StringBuilder)object2).toString();
        ((SolverVariable)object4).setName((String)object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(".bottom");
        object2 = ((StringBuilder)object2).toString();
        ((SolverVariable)object5).setName((String)object2);
        object2 = this.mBaseline;
        object = ((LinearSystem)object).createObjectVariable(object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(".baseline");
        string2 = ((StringBuilder)object2).toString();
        ((SolverVariable)object).setName(string2);
    }

    public void setDimension(int n10, int n11) {
        this.mWidth = n10;
        int n12 = this.mMinWidth;
        if (n10 < n12) {
            this.mWidth = n12;
        }
        this.mHeight = n11;
        n10 = this.mMinHeight;
        if (n11 < n10) {
            this.mHeight = n10;
        }
    }

    public void setDimensionRatio(float f10, int n10) {
        this.mDimensionRatio = f10;
        this.mDimensionRatioSide = n10;
    }

    public void setDimensionRatio(String string2) {
        block13: {
            float f10;
            float f11;
            int n10;
            int n11;
            block12: {
                block15: {
                    int n12;
                    int n13;
                    block14: {
                        float f12;
                        float f13;
                        int n14;
                        n11 = 0;
                        if (string2 == null || (n10 = string2.length()) == 0) break block13;
                        n10 = -1;
                        n13 = string2.length();
                        int n15 = string2.indexOf(44);
                        n12 = 0;
                        String string3 = null;
                        int n16 = 1;
                        if (n15 > 0 && n15 < (n14 = n13 + -1)) {
                            String string4;
                            String string5 = string2.substring(0, n15);
                            boolean bl2 = string5.equalsIgnoreCase(string4 = "W");
                            if (bl2) {
                                n10 = 0;
                            } else {
                                string3 = "H";
                                n12 = string5.equalsIgnoreCase(string3) ? 1 : 0;
                                if (n12 != 0) {
                                    n10 = n16;
                                }
                            }
                            n12 = n15 + 1;
                        }
                        if ((n15 = string2.indexOf(58)) < 0 || n15 >= (n13 -= n16)) break block14;
                        String string6 = string2.substring(n12, n15);
                        string2 = string2.substring(n15 += n16);
                        n15 = string6.length();
                        if (n15 <= 0 || (n15 = string2.length()) <= 0) break block15;
                        try {
                            f13 = Float.parseFloat(string6);
                        }
                        catch (NumberFormatException numberFormatException) {}
                        f11 = Float.parseFloat(string2);
                        float f14 = f13 - 0.0f;
                        n15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                        if (n15 <= 0 || (n15 = (int)((f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) <= 0) break block15;
                        if (n10 == n16) {
                            f11 /= f13;
                            f11 = Math.abs(f11);
                            break block12;
                        }
                        f13 /= f11;
                        f11 = Math.abs(f13);
                        break block12;
                    }
                    n13 = (string2 = string2.substring(n12)).length();
                    if (n13 <= 0) break block15;
                    f11 = Float.parseFloat(string2);
                    break block12;
                }
                string2 = null;
                f11 = 0.0f;
            }
            n11 = (f10 = f11 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1);
            if (n11 > 0) {
                this.mDimensionRatio = f11;
                this.mDimensionRatioSide = n10;
            }
            return;
        }
        this.mDimensionRatio = 0.0f;
    }

    public void setFinalBaseline(int n10) {
        int n11 = this.hasBaseline;
        if (n11 == 0) {
            return;
        }
        n11 = this.mBaselineDistance;
        n11 = n10 - n11;
        int n12 = this.mHeight + n11;
        this.mY = n11;
        this.mTop.setFinalValue(n11);
        this.mBottom.setFinalValue(n12);
        this.mBaseline.setFinalValue(n10);
        this.resolvedVertical = true;
    }

    public void setFinalFrame(int n10, int n11, int n12, int n13, int n14, int n15) {
        this.setFrame(n10, n11, n12, n13);
        this.setBaselineDistance(n14);
        n10 = 0;
        n11 = 1;
        if (n15 == 0) {
            this.resolvedHorizontal = n11;
            this.resolvedVertical = false;
        } else if (n15 == n11) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = n11;
        } else {
            n12 = 2;
            if (n15 == n12) {
                this.resolvedHorizontal = n11;
                this.resolvedVertical = n11;
            } else {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
            }
        }
    }

    public void setFinalHorizontal(int n10, int n11) {
        this.mLeft.setFinalValue(n10);
        this.mRight.setFinalValue(n11);
        this.mX = n10;
        this.mWidth = n11 -= n10;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int n10) {
        this.mLeft.setFinalValue(n10);
        this.mX = n10;
    }

    public void setFinalTop(int n10) {
        this.mTop.setFinalValue(n10);
        this.mY = n10;
    }

    public void setFinalVertical(int n10, int n11) {
        this.mTop.setFinalValue(n10);
        ConstraintAnchor constraintAnchor = this.mBottom;
        constraintAnchor.setFinalValue(n11);
        this.mY = n10;
        this.mHeight = n11 -= n10;
        n11 = this.hasBaseline ? 1 : 0;
        if (n11 != 0) {
            ConstraintAnchor constraintAnchor2 = this.mBaseline;
            int n12 = this.mBaselineDistance;
            constraintAnchor2.setFinalValue(n10 += n12);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int n10, int n11, int n12) {
        if (n12 == 0) {
            this.setHorizontalDimension(n10, n11);
        } else {
            int n13 = 1;
            if (n12 == n13) {
                this.setVerticalDimension(n10, n11);
            }
        }
    }

    public void setFrame(int n10, int n11, int n12, int n13) {
        n12 -= n10;
        n13 -= n11;
        this.mX = n10;
        this.mY = n11;
        n10 = this.mVisibility;
        n11 = 0;
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = null;
        int n14 = 8;
        if (n10 == n14) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        Object object = this.mListDimensionBehaviors;
        constraintWidget$DimensionBehaviour = object[0];
        ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour2 = ConstraintWidget$DimensionBehaviour.FIXED;
        if (constraintWidget$DimensionBehaviour == constraintWidget$DimensionBehaviour2 && n12 < (n11 = this.mWidth)) {
            n12 = n11;
        }
        if ((object = object[n11 = 1]) == constraintWidget$DimensionBehaviour2 && n13 < (n10 = this.mHeight)) {
            n13 = n10;
        }
        this.mWidth = n12;
        this.mHeight = n13;
        n10 = this.mMinHeight;
        if (n13 < n10) {
            this.mHeight = n10;
        }
        if (n12 < (n10 = this.mMinWidth)) {
            this.mWidth = n10;
        }
    }

    public void setGoneMargin(ConstraintAnchor$Type object, int n10) {
        int[] nArray = ConstraintWidget$1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        int n11 = object.ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12) {
            n12 = 2;
            if (n11 != n12) {
                n12 = 3;
                if (n11 != n12) {
                    n12 = 4;
                    if (n11 == n12) {
                        object = this.mBottom;
                        ((ConstraintAnchor)object).mGoneMargin = n10;
                    }
                } else {
                    object = this.mRight;
                    ((ConstraintAnchor)object).mGoneMargin = n10;
                }
            } else {
                object = this.mTop;
                ((ConstraintAnchor)object).mGoneMargin = n10;
            }
        } else {
            object = this.mLeft;
            ((ConstraintAnchor)object).mGoneMargin = n10;
        }
    }

    public void setHasBaseline(boolean bl2) {
        this.hasBaseline = bl2;
    }

    public void setHeight(int n10) {
        this.mHeight = n10;
        int n11 = this.mMinHeight;
        if (n10 < n11) {
            this.mHeight = n11;
        }
    }

    public void setHeightWrapContent(boolean bl2) {
        this.mIsHeightWrapContent = bl2;
    }

    public void setHorizontalBiasPercent(float f10) {
        this.mHorizontalBiasPercent = f10;
    }

    public void setHorizontalChainStyle(int n10) {
        this.mHorizontalChainStyle = n10;
    }

    public void setHorizontalDimension(int n10, int n11) {
        this.mX = n10;
        this.mWidth = n11 -= n10;
        n10 = this.mMinWidth;
        if (n11 < n10) {
            this.mWidth = n10;
        }
    }

    public void setHorizontalDimensionBehaviour(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.mListDimensionBehaviors[0] = constraintWidget$DimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int n10, int n11, int n12, float f10) {
        float f11;
        this.mMatchConstraintDefaultWidth = n10;
        this.mMatchConstraintMinWidth = n11;
        n11 = -1 >>> 1;
        float f12 = 0.0f / 0.0f;
        if (n12 == n11) {
            n12 = 0;
        }
        this.mMatchConstraintMaxWidth = n12;
        this.mMatchConstraintPercentWidth = f10;
        f12 = 0.0f;
        float f13 = f10 - 0.0f;
        n11 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (n11 > 0 && (n11 = (int)((f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1))) < 0 && n10 == 0) {
            this.mMatchConstraintDefaultWidth = n10 = 2;
        }
    }

    public void setHorizontalWeight(float f10) {
        this.mWeight[0] = f10;
    }

    public void setInBarrier(int n10, boolean bl2) {
        this.mIsInBarrier[n10] = bl2;
    }

    public void setInPlaceholder(boolean bl2) {
        this.inPlaceholder = bl2;
    }

    public void setInVirtualLayout(boolean bl2) {
        this.mInVirtuaLayout = bl2;
    }

    public void setLastMeasureSpec(int n10, int n11) {
        this.mLastHorizontalMeasureSpec = n10;
        this.mLastVerticalMeasureSpec = n11;
        this.setMeasureRequested(false);
    }

    public void setLength(int n10, int n11) {
        if (n11 == 0) {
            this.setWidth(n10);
        } else {
            int n12 = 1;
            if (n11 == n12) {
                this.setHeight(n10);
            }
        }
    }

    public void setMaxHeight(int n10) {
        this.mMaxDimension[1] = n10;
    }

    public void setMaxWidth(int n10) {
        this.mMaxDimension[0] = n10;
    }

    public void setMeasureRequested(boolean bl2) {
        this.mMeasureRequested = bl2;
    }

    public void setMinHeight(int n10) {
        if (n10 < 0) {
            n10 = 0;
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = n10;
        }
    }

    public void setMinWidth(int n10) {
        if (n10 < 0) {
            n10 = 0;
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = n10;
        }
    }

    public void setOffset(int n10, int n11) {
        this.mOffsetX = n10;
        this.mOffsetY = n11;
    }

    public void setOrigin(int n10, int n11) {
        this.mX = n10;
        this.mY = n11;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    public void setRelativePositioning(int n10, int n11) {
        if (n11 == 0) {
            this.mRelX = n10;
        } else {
            int n12 = 1;
            if (n11 == n12) {
                this.mRelY = n10;
            }
        }
    }

    public void setType(String string2) {
        this.mType = string2;
    }

    public void setVerticalBiasPercent(float f10) {
        this.mVerticalBiasPercent = f10;
    }

    public void setVerticalChainStyle(int n10) {
        this.mVerticalChainStyle = n10;
    }

    public void setVerticalDimension(int n10, int n11) {
        this.mY = n10;
        this.mHeight = n11 -= n10;
        n10 = this.mMinHeight;
        if (n11 < n10) {
            this.mHeight = n10;
        }
    }

    public void setVerticalDimensionBehaviour(ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour) {
        this.mListDimensionBehaviors[1] = constraintWidget$DimensionBehaviour;
    }

    public void setVerticalMatchStyle(int n10, int n11, int n12, float f10) {
        float f11;
        this.mMatchConstraintDefaultHeight = n10;
        this.mMatchConstraintMinHeight = n11;
        n11 = -1 >>> 1;
        float f12 = 0.0f / 0.0f;
        if (n12 == n11) {
            n12 = 0;
        }
        this.mMatchConstraintMaxHeight = n12;
        this.mMatchConstraintPercentHeight = f10;
        f12 = 0.0f;
        float f13 = f10 - 0.0f;
        n11 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (n11 > 0 && (n11 = (int)((f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1))) < 0 && n10 == 0) {
            this.mMatchConstraintDefaultHeight = n10 = 2;
        }
    }

    public void setVerticalWeight(float f10) {
        this.mWeight[1] = f10;
    }

    public void setVisibility(int n10) {
        this.mVisibility = n10;
    }

    public void setWidth(int n10) {
        this.mWidth = n10;
        int n11 = this.mMinWidth;
        if (n10 < n11) {
            this.mWidth = n11;
        }
    }

    public void setWidthWrapContent(boolean bl2) {
        this.mIsWidthWrapContent = bl2;
    }

    public void setX(int n10) {
        this.mX = n10;
    }

    public void setY(int n10) {
        this.mY = n10;
    }

    public void setupDimensionRatio(boolean n10, boolean bl2, boolean bl3, boolean bl4) {
        ConstraintAnchor constraintAnchor;
        float f10;
        n10 = this.mResolvedDimensionRatioSide;
        float f11 = 1.0f;
        int n11 = -1;
        int n12 = 1;
        if (n10 == n11) {
            if (bl3 && !bl4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!bl3 && bl4) {
                this.mResolvedDimensionRatioSide = n12;
                n10 = this.mDimensionRatioSide;
                if (n10 == n11) {
                    f10 = this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatio = f10 = f11 / f10;
                }
            }
        }
        if ((n10 = this.mResolvedDimensionRatioSide) == 0 && ((n10 = (int)((constraintAnchor = this.mTop).isConnected() ? 1 : 0)) == 0 || (n10 = (int)((constraintAnchor = this.mBottom).isConnected() ? 1 : 0)) == 0)) {
            this.mResolvedDimensionRatioSide = n12;
        } else {
            n10 = this.mResolvedDimensionRatioSide;
            if (n10 == n12 && ((n10 = (int)((constraintAnchor = this.mLeft).isConnected() ? 1 : 0)) == 0 || (n10 = (int)((constraintAnchor = this.mRight).isConnected() ? 1 : 0)) == 0)) {
                this.mResolvedDimensionRatioSide = 0;
            }
        }
        n10 = this.mResolvedDimensionRatioSide;
        if (n10 == n11 && ((n10 = (int)((constraintAnchor = this.mTop).isConnected() ? 1 : 0)) == 0 || (n10 = (int)((constraintAnchor = this.mBottom).isConnected() ? 1 : 0)) == 0 || (n10 = (int)((constraintAnchor = this.mLeft).isConnected() ? 1 : 0)) == 0 || (n10 = (int)((constraintAnchor = this.mRight).isConnected() ? 1 : 0)) == 0)) {
            constraintAnchor = this.mTop;
            n10 = constraintAnchor.isConnected() ? 1 : 0;
            if (n10 != 0 && (n10 = (int)((constraintAnchor = this.mBottom).isConnected() ? 1 : 0)) != 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                constraintAnchor = this.mLeft;
                n10 = constraintAnchor.isConnected() ? 1 : 0;
                if (n10 != 0 && (n10 = (int)((constraintAnchor = this.mRight).isConnected() ? 1 : 0)) != 0) {
                    f10 = this.mResolvedDimensionRatio;
                    this.mResolvedDimensionRatio = f10 = f11 / f10;
                    this.mResolvedDimensionRatioSide = n12;
                }
            }
        }
        if ((n10 = this.mResolvedDimensionRatioSide) == n11) {
            n10 = this.mMatchConstraintMinWidth;
            if (n10 > 0 && !(bl3 = this.mMatchConstraintMinHeight)) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (n10 == 0 && (n10 = this.mMatchConstraintMinHeight) > 0) {
                f10 = this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatio = f11 /= f10;
                this.mResolvedDimensionRatioSide = n12;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        CharSequence charSequence = this.mType;
        String string2 = " ";
        String string3 = "";
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("type: ");
            String string4 = this.mType;
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
        } else {
            charSequence = string3;
        }
        stringBuilder.append((String)charSequence);
        charSequence = this.mDebugName;
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("id: ");
            string3 = this.mDebugName;
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string2);
            string3 = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append(string3);
        stringBuilder.append("(");
        int n10 = this.mX;
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        n10 = this.mY;
        stringBuilder.append(n10);
        stringBuilder.append(") - (");
        n10 = this.mWidth;
        stringBuilder.append(n10);
        stringBuilder.append(" x ");
        n10 = this.mHeight;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public void updateFromRuns(boolean n10, boolean bl2) {
        Object object;
        int n11 = this.horizontalRun.isResolved();
        n10 &= n11;
        n11 = this.verticalRun.isResolved();
        bl2 &= n11;
        Dependency dependency = this.horizontalRun;
        Object object2 = dependency.start;
        int n12 = object2.value;
        Dependency dependency2 = this.verticalRun;
        DependencyNode dependencyNode = dependency2.start;
        int n13 = dependencyNode.value;
        dependency = dependency.end;
        n11 = ((DependencyNode)dependency).value;
        dependency2 = dependency2.end;
        int n14 = ((DependencyNode)dependency2).value;
        int n15 = n11 - n12;
        int n16 = n14 - n13;
        if (n15 < 0 || n16 < 0 || n12 == (n15 = -1 << -1) || n12 == (n16 = -1 >>> 1) || n13 == n15 || n13 == n16 || n11 == n15 || n11 == n16 || n14 == n15 || n14 == n16) {
            n11 = 0;
            dependency = null;
            n12 = 0;
            object2 = null;
            n14 = 0;
            dependency2 = null;
            n13 = 0;
            dependencyNode = null;
        }
        n11 -= n12;
        n14 -= n13;
        if (n10 != 0) {
            this.mX = n12;
        }
        if (bl2) {
            this.mY = n13;
        }
        if ((n12 = this.mVisibility) == (n13 = 8)) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (n10 != 0) {
            object = this.mListDimensionBehaviors[0];
            object2 = ConstraintWidget$DimensionBehaviour.FIXED;
            if (object == object2 && n11 < (n10 = this.mWidth)) {
                n11 = n10;
            }
            this.mWidth = n11;
            n10 = this.mMinWidth;
            if (n11 < n10) {
                this.mWidth = n10;
            }
        }
        if (bl2) {
            object = this.mListDimensionBehaviors;
            bl2 = true;
            ConstraintWidget$DimensionBehaviour constraintWidget$DimensionBehaviour = ConstraintWidget$DimensionBehaviour.FIXED;
            if ((object = object[bl2]) == constraintWidget$DimensionBehaviour && n14 < (n10 = this.mHeight)) {
                n14 = n10;
            }
            this.mHeight = n14;
            n10 = this.mMinHeight;
            if (n14 < n10) {
                this.mHeight = n10;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean n10) {
        boolean bl2;
        Dependency dependency;
        DependencyNode dependencyNode;
        ConstraintAnchor constraintAnchor = this.mLeft;
        int n11 = linearSystem.getObjectVariableValue(constraintAnchor);
        ConstraintAnchor constraintAnchor2 = this.mTop;
        int n12 = linearSystem.getObjectVariableValue(constraintAnchor2);
        ConstraintAnchor constraintAnchor3 = this.mRight;
        int n13 = linearSystem.getObjectVariableValue(constraintAnchor3);
        Object object = this.mBottom;
        int n14 = linearSystem.getObjectVariableValue(object);
        if (n10 != 0 && (object = this.horizontalRun) != null) {
            dependencyNode = ((WidgetRun)object).start;
            boolean bl3 = dependencyNode.resolved;
            if (bl3) {
                object = ((WidgetRun)object).end;
                bl3 = ((DependencyNode)object).resolved;
                if (bl3) {
                    n11 = dependencyNode.value;
                    n13 = ((DependencyNode)object).value;
                }
            }
        }
        if (n10 != 0 && (dependency = this.verticalRun) != null) {
            object = dependency.start;
            bl2 = ((DependencyNode)object).resolved;
            if (bl2) {
                dependency = dependency.end;
                bl2 = ((DependencyNode)dependency).resolved;
                if (bl2) {
                    n12 = ((DependencyNode)object).value;
                    n14 = ((DependencyNode)dependency).value;
                }
            }
        }
        n10 = n13 - n11;
        int n15 = n14 - n12;
        bl2 = false;
        dependencyNode = null;
        if (n10 < 0 || n15 < 0 || n11 == (n10 = -1 << -1) || n11 == (n15 = -1 >>> 1) || n12 == n10 || n12 == n15 || n13 == n10 || n13 == n15 || n14 == n10 || n14 == n15) {
            n14 = 0;
            linearSystem = null;
            n11 = 0;
            constraintAnchor = null;
            n12 = 0;
            constraintAnchor2 = null;
            n13 = 0;
            constraintAnchor3 = null;
        }
        this.setFrame(n11, n12, n13, n14);
    }
}

