/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout$Measurer;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import androidx.constraintlayout.widget.Guideline;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout
extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.0.4";
    public SparseArray mChildrenByIds;
    private ArrayList mConstraintHelpers;
    public ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap mDesignIds;
    public boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    public int mLastMeasureHeightMode;
    public int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    public int mLastMeasureWidthMode;
    public int mLastMeasureWidthSize;
    public ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    public ConstraintLayout$Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray mTempMapIdToWidget;

    public ConstraintLayout(Context object) {
        super(object);
        Object object2;
        HashMap hashMap;
        int n10;
        int n11;
        super();
        this.mChildrenByIds = object;
        super(4);
        this.mConstraintHelpers = object;
        super();
        this.mLayoutWidget = object;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = n11 = -1 >>> 1;
        this.mMaxHeight = n11;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = n10 = -1;
        this.mDesignIds = hashMap = new HashMap();
        this.mLastMeasureWidth = n10;
        this.mLastMeasureHeight = n10;
        this.mLastMeasureWidthSize = n10;
        this.mLastMeasureHeightSize = n10;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = object2 = new SparseArray();
        super(this, this);
        this.mMeasurer = object2;
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(null, 0, 0);
    }

    public ConstraintLayout(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        Object object2;
        HashMap hashMap;
        int n10;
        super();
        this.mChildrenByIds = object;
        super(4);
        this.mConstraintHelpers = object;
        super();
        this.mLayoutWidget = object;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = n10 = -1 >>> 1;
        this.mMaxHeight = n10;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = n10 = -1;
        this.mDesignIds = hashMap = new HashMap();
        this.mLastMeasureWidth = n10;
        this.mLastMeasureHeight = n10;
        this.mLastMeasureWidthSize = n10;
        this.mLastMeasureHeightSize = n10;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = object2 = new SparseArray();
        super(this, this);
        this.mMeasurer = object2;
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        Object object2;
        HashMap hashMap;
        int n11;
        super();
        this.mChildrenByIds = object;
        super(4);
        this.mConstraintHelpers = object;
        super();
        this.mLayoutWidget = object;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = n11 = -1 >>> 1;
        this.mMaxHeight = n11;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = n11 = -1;
        this.mDesignIds = hashMap = new HashMap();
        this.mLastMeasureWidth = n11;
        this.mLastMeasureHeight = n11;
        this.mLastMeasureWidthSize = n11;
        this.mLastMeasureHeightSize = n11;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = object2 = new SparseArray();
        super(this, this);
        this.mMeasurer = object2;
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(attributeSet, n10, 0);
    }

    public ConstraintLayout(Context object, AttributeSet attributeSet, int n10, int n11) {
        super(object, attributeSet, n10, n11);
        Object object2;
        HashMap hashMap;
        int n12;
        super();
        this.mChildrenByIds = object;
        super(4);
        this.mConstraintHelpers = object;
        super();
        this.mLayoutWidget = object;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = n12 = -1 >>> 1;
        this.mMaxHeight = n12;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = n12 = -1;
        this.mDesignIds = hashMap = new HashMap();
        this.mLastMeasureWidth = n12;
        this.mLastMeasureHeight = n12;
        this.mLastMeasureWidthSize = n12;
        this.mLastMeasureHeightSize = n12;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = object2 = new SparseArray();
        super(this, this);
        this.mMeasurer = object2;
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        this.init(attributeSet, n10, n11);
    }

    public static /* synthetic */ int access$000(ConstraintLayout constraintLayout) {
        return constraintLayout.mOptimizationLevel;
    }

    public static /* synthetic */ ArrayList access$100(ConstraintLayout constraintLayout) {
        return constraintLayout.mConstraintHelpers;
    }

    private int getPaddingWidth() {
        int n10 = this.getPaddingLeft();
        int n11 = 0;
        n10 = Math.max(0, n10);
        int n12 = this.getPaddingRight();
        n12 = Math.max(0, n12);
        n10 += n12;
        n12 = Build.VERSION.SDK_INT;
        int n13 = 17;
        if (n12 >= n13) {
            n12 = this.getPaddingStart();
            n12 = Math.max(0, n12);
            n13 = this.getPaddingEnd();
            n11 = Math.max(0, n13) + n12;
        }
        if (n11 > 0) {
            n10 = n11;
        }
        return n10;
    }

    private final ConstraintWidget getTargetWidget(int n10) {
        ConstraintWidget constraintWidget;
        if (n10 == 0) {
            return this.mLayoutWidget;
        }
        View view = (View)this.mChildrenByIds.get(n10);
        if (view == null && (view = this.findViewById(n10)) != null && view != this && (constraintWidget = view.getParent()) == this) {
            this.onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            n10 = 0;
            constraintWidget = null;
        } else {
            constraintWidget = ((ConstraintLayout$LayoutParams)view.getLayoutParams()).widget;
        }
        return constraintWidget;
    }

    private void init(AttributeSet object, int n10, int n11) {
        this.mLayoutWidget.setCompanionWidget((Object)this);
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        ConstraintLayout$Measurer constraintLayout$Measurer = this.mMeasurer;
        constraintWidgetContainer.setMeasurer(constraintLayout$Measurer);
        constraintWidgetContainer = this.mChildrenByIds;
        int n12 = this.getId();
        constraintWidgetContainer.put(n12, (Object)this);
        constraintWidgetContainer = null;
        this.mConstraintSet = null;
        if (object != null) {
            constraintLayout$Measurer = this.getContext();
            int[] nArray = R$styleable.ConstraintLayout_Layout;
            object = constraintLayout$Measurer.obtainStyledAttributes((AttributeSet)object, nArray, n10, n11);
            n10 = object.getIndexCount();
            n11 = 0;
            constraintLayout$Measurer = null;
            for (n12 = 0; n12 < n10; ++n12) {
                int n13;
                int n14 = object.getIndex(n12);
                if (n14 == (n13 = R$styleable.ConstraintLayout_Layout_android_minWidth)) {
                    n13 = this.mMinWidth;
                    this.mMinWidth = n14 = object.getDimensionPixelOffset(n14, n13);
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_android_minHeight;
                if (n14 == n13) {
                    n13 = this.mMinHeight;
                    this.mMinHeight = n14 = object.getDimensionPixelOffset(n14, n13);
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_android_maxWidth;
                if (n14 == n13) {
                    n13 = this.mMaxWidth;
                    this.mMaxWidth = n14 = object.getDimensionPixelOffset(n14, n13);
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_android_maxHeight;
                if (n14 == n13) {
                    n13 = this.mMaxHeight;
                    this.mMaxHeight = n14 = object.getDimensionPixelOffset(n14, n13);
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_layout_optimizationLevel;
                if (n14 == n13) {
                    n13 = this.mOptimizationLevel;
                    this.mOptimizationLevel = n14 = object.getInt(n14, n13);
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_layoutDescription;
                if (n14 == n13) {
                    if ((n14 = object.getResourceId(n14, 0)) == 0) continue;
                    try {
                        this.parseLayoutDescription(n14);
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        this.mConstraintLayoutSpec = null;
                    }
                    continue;
                }
                n13 = R$styleable.ConstraintLayout_Layout_constraintSet;
                if (n14 != n13) continue;
                n14 = object.getResourceId(n14, 0);
                ConstraintSet constraintSet = new ConstraintSet();
                this.mConstraintSet = constraintSet;
                Context context = this.getContext();
                try {
                    constraintSet.load(context, n14);
                }
                catch (Resources.NotFoundException notFoundException) {
                    this.mConstraintSet = null;
                }
                this.mConstraintSetId = n14;
            }
            object.recycle();
        }
        object = this.mLayoutWidget;
        n10 = this.mOptimizationLevel;
        ((ConstraintWidgetContainer)object).setOptimizationLevel(n10);
    }

    private void markHierarchyDirty() {
        int n10;
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = n10 = -1;
        this.mLastMeasureHeight = n10;
        this.mLastMeasureWidthSize = n10;
        this.mLastMeasureHeightSize = n10;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setChildrenConstraints() {
        int n10;
        Integer n11;
        Object object;
        int n12;
        Object object2;
        int n13;
        boolean bl2 = this.isInEditMode();
        int n14 = this.getChildCount();
        Object var3_3 = null;
        Object object3 = null;
        for (n13 = 0; n13 < n14; ++n13) {
            object2 = this.getChildAt(n13);
            if ((object2 = this.getViewWidget((View)object2)) == null) continue;
            ((ConstraintWidget)object2).reset();
        }
        n13 = -1;
        if (bl2) {
            object2 = null;
            for (n12 = 0; n12 < n14; ++n12) {
                object = this.getChildAt(n12);
                try {
                    void var9_12;
                    Resources resources = this.getResources();
                    int n15 = object.getId();
                    String string2 = resources.getResourceName(n15);
                    n15 = object.getId();
                    n11 = n15;
                    this.setDesignInformation(0, string2, n11);
                    n15 = 47;
                    n15 = string2.indexOf(n15);
                    if (n15 != n13) {
                        String string3 = string2.substring(++n15);
                    }
                    n10 = object.getId();
                    object = this.getTargetWidget(n10);
                    object.setDebugName((String)var9_12);
                    continue;
                }
                catch (Resources.NotFoundException notFoundException) {}
            }
        }
        if ((n12 = this.mConstraintSetId) != n13) {
            object3 = null;
            for (n13 = 0; n13 < n14; ++n13) {
                int n16;
                object2 = this.getChildAt(n13);
                n10 = object2.getId();
                if (n10 != (n16 = this.mConstraintSetId) || (n10 = object2 instanceof Constraints) == 0) continue;
                this.mConstraintSet = object2 = ((Constraints)((Object)object2)).getConstraintSet();
            }
        }
        if ((object3 = this.mConstraintSet) != null) {
            n12 = 1;
            ((ConstraintSet)object3).applyToInternal(this, n12 != 0);
        }
        this.mLayoutWidget.removeAllChildren();
        object3 = this.mConstraintHelpers;
        n13 = ((ArrayList)object3).size();
        if (n13 > 0) {
            object2 = null;
            for (n12 = 0; n12 < n13; ++n12) {
                object = (ConstraintHelper)((Object)this.mConstraintHelpers.get(n12));
                object.updatePreLayout(this);
            }
        }
        object3 = null;
        for (n13 = 0; n13 < n14; ++n13) {
            object2 = this.getChildAt(n13);
            n10 = object2 instanceof Placeholder;
            if (n10 == 0) continue;
            object2 = (Placeholder)((Object)object2);
            ((Placeholder)((Object)object2)).updatePreLayout(this);
        }
        this.mTempMapIdToWidget.clear();
        object3 = this.mTempMapIdToWidget;
        object2 = this.mLayoutWidget;
        object3.put(0, object2);
        object3 = this.mTempMapIdToWidget;
        n12 = this.getId();
        object = this.mLayoutWidget;
        object3.put(n12, object);
        object3 = null;
        for (n13 = 0; n13 < n14; ++n13) {
            object2 = this.getChildAt(n13);
            object = this.getViewWidget((View)object2);
            SparseArray sparseArray = this.mTempMapIdToWidget;
            n12 = object2.getId();
            sparseArray.put(n12, object);
        }
        int n17 = 0;
        while (n17 < n14) {
            object2 = this.getChildAt(n17);
            object = this.getViewWidget((View)object2);
            if (object != null) {
                ViewGroup.LayoutParams layoutParams;
                ViewGroup.LayoutParams layoutParams2 = layoutParams = object2.getLayoutParams();
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)layoutParams;
                this.mLayoutWidget.add((ConstraintWidget)object);
                n11 = this.mTempMapIdToWidget;
                ConstraintLayout constraintLayout = this;
                n13 = bl2 ? 1 : 0;
                this.applyConstraintsFromLayoutParams(bl2, (View)object2, (ConstraintWidget)object, constraintLayout$LayoutParams, (SparseArray)n11);
            }
            ++n17;
        }
        return;
    }

    private boolean updateHierarchy() {
        int n10 = this.getChildCount();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            boolean bl3 = view.isLayoutRequested();
            if (!bl3) continue;
            bl2 = true;
            break;
        }
        if (bl2) {
            this.setChildrenConstraints();
        }
        return bl2;
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n10, layoutParams);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 < n11) {
            this.onViewAdded(view);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void applyConstraintsFromLayoutParams(boolean var1_1, View var2_2, ConstraintWidget var3_3, ConstraintLayout$LayoutParams var4_4, SparseArray var5_5) {
        block59: {
            block61: {
                block60: {
                    block58: {
                        var6_6 = this;
                        var7_7 = var2_2;
                        var8_8 = var3_3;
                        var9_9 = var4_4;
                        var10_10 = var5_5;
                        var11_11 = Build.VERSION.SDK_INT;
                        var4_4.validate();
                        var4_4.helped = false;
                        var12_12 = var2_2.getVisibility();
                        var3_3.setVisibility(var12_12);
                        var12_12 = (int)var4_4.isInPlaceholder;
                        var13_13 = true;
                        if (var12_12 != 0) {
                            var3_3.setInPlaceholder(var13_13);
                            var12_12 = 8;
                            var3_3.setVisibility(var12_12);
                        }
                        var8_8.setCompanionWidget(var7_7);
                        var12_12 = var7_7 instanceof ConstraintHelper;
                        if (var12_12 != 0) {
                            var7_7 = (ConstraintHelper)var7_7;
                            var14_14 /* !! */  = var6_6.mLayoutWidget;
                            var12_12 = (int)var14_14 /* !! */ .isRtl();
                            var7_7.resolveRtl(var8_8, (boolean)var12_12);
                        }
                        var15_15 = var9_9.isGuideline;
                        var12_12 = 17;
                        var16_16 = -1;
                        if (var15_15 == 0) break block58;
                        var7_7 = var8_8;
                        var7_7 = (androidx.constraintlayout.solver.widgets.Guideline)var8_8;
                        var17_17 = var9_9.resolvedGuideBegin;
                        var18_19 = var9_9.resolvedGuideEnd;
                        var19_21 = var9_9.resolvedGuidePercent;
                        if (var11_11 < var12_12) {
                            var17_17 = var9_9.guideBegin;
                            var18_19 = var9_9.guideEnd;
                            var19_21 = var9_9.guidePercent;
                        }
                        if ((var11_11 = (int)((cfr_temp_0 = var19_21 - (var20_22 = -1.0f)) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) != 0) {
                            var7_7.setGuidePercent(var19_21);
                        } else if (var17_17 != var16_16) {
                            var7_7.setGuideBegin(var17_17);
                        } else if (var18_19 != var16_16) {
                            var7_7.setGuideEnd(var18_19);
                        }
                        break block59;
                    }
                    var15_15 = var9_9.resolvedLeftToLeft;
                    var17_18 = var9_9.resolvedLeftToRight;
                    var18_20 = var9_9.resolvedRightToLeft;
                    var21_24 = var9_9.resolvedRightToRight;
                    var22_25 = var9_9.resolveGoneLeftMargin;
                    var23_26 = var9_9.resolveGoneRightMargin;
                    var24_27 = var9_9.resolvedHorizontalBias;
                    if (var11_11 >= var12_12) break block60;
                    var15_15 = var9_9.leftToLeft;
                    var11_11 = var9_9.leftToRight;
                    var18_20 = var9_9.rightToLeft;
                    var21_24 = var9_9.rightToRight;
                    var12_12 = var9_9.goneLeftMargin;
                    var17_18 = var9_9.goneRightMargin;
                    var24_27 = var9_9.horizontalBias;
                    if (var15_15 == var16_16 && var11_11 == var16_16) {
                        var22_25 = var9_9.startToStart;
                        if (var22_25 != var16_16) {
                            var15_15 = var22_25;
                        } else {
                            var22_25 = var9_9.startToEnd;
                            if (var22_25 != var16_16) {
                                var11_11 = var22_25;
                            }
                        }
                    }
                    if (var18_20 != var16_16 || var21_24 != var16_16) ** GOTO lbl-1000
                    var22_25 = var9_9.endToStart;
                    if (var22_25 == var16_16) {
                        var22_25 = var9_9.endToEnd;
                        ** if (var22_25 == var16_16) goto lbl-1000
lbl-1000:
                        // 1 sources

                        {
                            var21_24 = var12_12;
                            var23_26 = var22_25;
                            var22_25 = var18_20;
                            var25_28 = var24_27;
                            ** GOTO lbl85
                        }
                    }
                    ** GOTO lbl82
lbl-1000:
                    // 2 sources

                    {
                        var22_25 = var18_20;
lbl82:
                        // 2 sources

                        var23_26 = var21_24;
                        var25_28 = var24_27;
                        var21_24 = var12_12;
                    }
lbl85:
                    // 2 sources

                    var26_29 = var17_18;
                    var17_18 = var11_11;
                    break block61;
                }
                var27_30 = var22_25;
                var22_25 = var18_20;
                var25_28 = var24_27;
                var26_29 = var23_26;
                var23_26 = var21_24;
                var21_24 = var27_30;
            }
            var11_11 = var9_9.circleConstraint;
            if (var11_11 != var16_16) {
                var7_7 = (ConstraintWidget)var10_10.get(var11_11);
                if (var7_7 != null) {
                    var20_23 = var9_9.circleAngle;
                    var12_12 = var9_9.circleRadius;
                    var8_8.connectCircularConstraint((ConstraintWidget)var7_7, var20_23, var12_12);
                }
            } else {
                if (var15_15 != var16_16) {
                    var14_14 /* !! */  = var7_7 = var10_10.get(var15_15);
                    var14_14 /* !! */  = (ConstraintWidget)var7_7;
                    if (var14_14 /* !! */  != null) {
                        var28_31 = ConstraintAnchor$Type.LEFT;
                        var11_11 = var9_9.leftMargin;
                        var7_7 = var3_3;
                        var29_32 = var28_31;
                        var30_33 = var25_28;
                        var18_20 = var11_11;
                        var3_3.immediateConnect((ConstraintAnchor$Type)var28_31, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var11_11, var21_24);
                    } else {
                        var30_33 = var25_28;
                    }
                } else {
                    var30_33 = var25_28;
                    if (var17_18 != var16_16) {
                        var14_14 /* !! */  = var7_7 = var10_10.get(var17_18);
                        var14_14 /* !! */  = (ConstraintWidget)var7_7;
                        if (var14_14 /* !! */  != null) {
                            var29_32 = ConstraintAnchor$Type.LEFT;
                            var28_31 = ConstraintAnchor$Type.RIGHT;
                            var18_20 = var9_9.leftMargin;
                            var7_7 = var3_3;
                            var3_3.immediateConnect((ConstraintAnchor$Type)var29_32, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var21_24);
                        }
                    }
                }
                if (var22_25 != var16_16) {
                    var14_14 /* !! */  = var7_7 = var10_10.get(var22_25);
                    var14_14 /* !! */  = (ConstraintWidget)var7_7;
                    if (var14_14 /* !! */  != null) {
                        var29_32 = ConstraintAnchor$Type.RIGHT;
                        var28_31 = ConstraintAnchor$Type.LEFT;
                        var18_20 = var9_9.rightMargin;
                        var7_7 = var3_3;
                        var21_24 = var26_29;
                        var3_3.immediateConnect((ConstraintAnchor$Type)var29_32, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var26_29);
                    }
                } else if (var23_26 != var16_16) {
                    var14_14 /* !! */  = var7_7 = var10_10.get(var23_26);
                    var14_14 /* !! */  = (ConstraintWidget)var7_7;
                    if (var14_14 /* !! */  != null) {
                        var28_31 = ConstraintAnchor$Type.RIGHT;
                        var18_20 = var9_9.rightMargin;
                        var7_7 = var3_3;
                        var29_32 = var28_31;
                        var21_24 = var26_29;
                        var3_3.immediateConnect((ConstraintAnchor$Type)var28_31, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var26_29);
                    }
                }
                if ((var15_15 = var9_9.topToTop) != var16_16) {
                    var14_14 /* !! */  = var7_7 = var10_10.get(var15_15);
                    var14_14 /* !! */  = (ConstraintWidget)var7_7;
                    if (var14_14 /* !! */  != null) {
                        var28_31 = ConstraintAnchor$Type.TOP;
                        var18_20 = var9_9.topMargin;
                        var21_24 = var9_9.goneTopMargin;
                        var7_7 = var3_3;
                        var29_32 = var28_31;
                        var3_3.immediateConnect((ConstraintAnchor$Type)var28_31, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var21_24);
                    }
                } else {
                    var15_15 = var9_9.topToBottom;
                    if (var15_15 != var16_16) {
                        var14_14 /* !! */  = var7_7 = var10_10.get(var15_15);
                        var14_14 /* !! */  = (ConstraintWidget)var7_7;
                        if (var14_14 /* !! */  != null) {
                            var29_32 = ConstraintAnchor$Type.TOP;
                            var28_31 = ConstraintAnchor$Type.BOTTOM;
                            var18_20 = var9_9.topMargin;
                            var21_24 = var9_9.goneTopMargin;
                            var7_7 = var3_3;
                            var3_3.immediateConnect((ConstraintAnchor$Type)var29_32, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var21_24);
                        }
                    }
                }
                if ((var15_15 = var9_9.bottomToTop) != var16_16) {
                    var14_14 /* !! */  = var7_7 = var10_10.get(var15_15);
                    var14_14 /* !! */  = (ConstraintWidget)var7_7;
                    if (var14_14 /* !! */  != null) {
                        var29_32 = ConstraintAnchor$Type.BOTTOM;
                        var28_31 = ConstraintAnchor$Type.TOP;
                        var18_20 = var9_9.bottomMargin;
                        var21_24 = var9_9.goneBottomMargin;
                        var7_7 = var3_3;
                        var3_3.immediateConnect((ConstraintAnchor$Type)var29_32, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var21_24);
                    }
                } else {
                    var15_15 = var9_9.bottomToBottom;
                    if (var15_15 != var16_16) {
                        var14_14 /* !! */  = var7_7 = var10_10.get(var15_15);
                        var14_14 /* !! */  = (ConstraintWidget)var7_7;
                        if (var14_14 /* !! */  != null) {
                            var28_31 = ConstraintAnchor$Type.BOTTOM;
                            var18_20 = var9_9.bottomMargin;
                            var21_24 = var9_9.goneBottomMargin;
                            var7_7 = var3_3;
                            var29_32 = var28_31;
                            var3_3.immediateConnect((ConstraintAnchor$Type)var28_31, (ConstraintWidget)var14_14 /* !! */ , (ConstraintAnchor$Type)var28_31, var18_20, var21_24);
                        }
                    }
                }
                if ((var15_15 = var9_9.baselineToBaseline) != var16_16) {
                    var7_7 = (View)var6_6.mChildrenByIds.get(var15_15);
                    var11_11 = var9_9.baselineToBaseline;
                    var29_32 = (ConstraintWidget)var10_10.get(var11_11);
                    if (var29_32 != null && var7_7 != null && (var12_12 = (var14_14 /* !! */  = var7_7.getLayoutParams()) instanceof ConstraintLayout$LayoutParams) != 0) {
                        var7_7 = (ConstraintLayout$LayoutParams)var7_7.getLayoutParams();
                        var9_9.needsBaseline = var13_13;
                        var7_7.needsBaseline = var13_13;
                        var14_14 /* !! */  = ConstraintAnchor$Type.BASELINE;
                        var28_31 = var8_8.getAnchor((ConstraintAnchor$Type)var14_14 /* !! */ );
                        var29_32 = var29_32.getAnchor((ConstraintAnchor$Type)var14_14 /* !! */ );
                        var28_31.connect((ConstraintAnchor)var29_32, 0, var16_16, var13_13);
                        var8_8.setHasBaseline(var13_13);
                        var7_7.widget.setHasBaseline(var13_13);
                        var7_7 = ConstraintAnchor$Type.TOP;
                        var8_8.getAnchor((ConstraintAnchor$Type)var7_7).reset();
                        var7_7 = ConstraintAnchor$Type.BOTTOM;
                        var7_7 = var8_8.getAnchor((ConstraintAnchor$Type)var7_7);
                        var7_7.reset();
                    }
                }
                var15_15 = 0;
                var31_34 = 0.0f;
                var7_7 = null;
                var24_27 = var30_33;
                cfr_temp_1 = var30_33 - 0.0f;
                var11_11 = cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1);
                if (var11_11 >= 0) {
                    var8_8.setHorizontalBiasPercent(var30_33);
                }
                if ((var15_15 = (int)((cfr_temp_2 = (var20_23 = var9_9.verticalBias) - 0.0f) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1))) >= 0) {
                    var8_8.setVerticalBiasPercent(var20_23);
                }
            }
            if (var1_1 && ((var15_15 = var9_9.editorAbsoluteX) != var16_16 || (var11_11 = var9_9.editorAbsoluteY) != var16_16)) {
                var11_11 = var9_9.editorAbsoluteY;
                var8_8.setOrigin(var15_15, var11_11);
            }
            var15_15 = (int)var9_9.horizontalDimensionFixed;
            var11_11 = -2;
            var20_23 = 0.0f / 0.0f;
            if (var15_15 == 0) {
                var15_15 = var9_9.width;
                if (var15_15 == var16_16) {
                    var15_15 = (int)var9_9.constrainedWidth;
                    if (var15_15 != 0) {
                        var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                        var8_8.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    } else {
                        var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                        var8_8.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    }
                    var7_7 = ConstraintAnchor$Type.LEFT;
                    var7_7 = var8_8.getAnchor((ConstraintAnchor$Type)var7_7);
                    var7_7.mMargin = var12_12 = var9_9.leftMargin;
                    var7_7 = ConstraintAnchor$Type.RIGHT;
                    var7_7 = var8_8.getAnchor((ConstraintAnchor$Type)var7_7);
                    var7_7.mMargin = var12_12 = var9_9.rightMargin;
                } else {
                    var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    var8_8.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    var8_8.setWidth(0);
                }
            } else {
                var7_7 = ConstraintWidget$DimensionBehaviour.FIXED;
                var8_8.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                var15_15 = var9_9.width;
                var8_8.setWidth(var15_15);
                var15_15 = var9_9.width;
                if (var15_15 == var11_11) {
                    var7_7 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    var8_8.setHorizontalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                }
            }
            var15_15 = (int)var9_9.verticalDimensionFixed;
            if (var15_15 == 0) {
                var15_15 = var9_9.height;
                if (var15_15 == var16_16) {
                    var15_15 = (int)var9_9.constrainedHeight;
                    if (var15_15 != 0) {
                        var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                        var8_8.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    } else {
                        var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_PARENT;
                        var8_8.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    }
                    var7_7 = ConstraintAnchor$Type.TOP;
                    var7_7 = var8_8.getAnchor((ConstraintAnchor$Type)var7_7);
                    var7_7.mMargin = var11_11 = var9_9.topMargin;
                    var7_7 = ConstraintAnchor$Type.BOTTOM;
                    var7_7 = var8_8.getAnchor((ConstraintAnchor$Type)var7_7);
                    var7_7.mMargin = var11_11 = var9_9.bottomMargin;
                } else {
                    var7_7 = ConstraintWidget$DimensionBehaviour.MATCH_CONSTRAINT;
                    var8_8.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                    var8_8.setHeight(0);
                }
            } else {
                var7_7 = ConstraintWidget$DimensionBehaviour.FIXED;
                var8_8.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                var15_15 = var9_9.height;
                var8_8.setHeight(var15_15);
                var15_15 = var9_9.height;
                if (var15_15 == var11_11) {
                    var7_7 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                    var8_8.setVerticalDimensionBehaviour((ConstraintWidget$DimensionBehaviour)var7_7);
                }
            }
            var7_7 = var9_9.dimensionRatio;
            var8_8.setDimensionRatio((String)var7_7);
            var31_34 = var9_9.horizontalWeight;
            var8_8.setHorizontalWeight(var31_34);
            var31_34 = var9_9.verticalWeight;
            var8_8.setVerticalWeight(var31_34);
            var15_15 = var9_9.horizontalChainStyle;
            var8_8.setHorizontalChainStyle(var15_15);
            var15_15 = var9_9.verticalChainStyle;
            var8_8.setVerticalChainStyle(var15_15);
            var15_15 = var9_9.matchConstraintDefaultWidth;
            var11_11 = var9_9.matchConstraintMinWidth;
            var12_12 = var9_9.matchConstraintMaxWidth;
            var32_35 = var9_9.matchConstraintPercentWidth;
            var8_8.setHorizontalMatchStyle(var15_15, var11_11, var12_12, var32_35);
            var15_15 = var9_9.matchConstraintDefaultHeight;
            var11_11 = var9_9.matchConstraintMinHeight;
            var12_12 = var9_9.matchConstraintMaxHeight;
            var32_35 = var9_9.matchConstraintPercentHeight;
            var8_8.setVerticalMatchStyle(var15_15, var11_11, var12_12, var32_35);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ConstraintLayout$LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        int n10;
        float f10;
        int n11;
        ConstraintLayout constraintLayout = this;
        ArrayList arrayList = this.mConstraintHelpers;
        if (arrayList != null && (n11 = arrayList.size()) > 0) {
            f10 = 0.0f;
            for (n10 = 0; n10 < n11; ++n10) {
                ConstraintHelper constraintHelper = (ConstraintHelper)((Object)constraintLayout.mConstraintHelpers.get(n10));
                constraintHelper.updatePreDraw(constraintLayout);
            }
        }
        super.dispatchDraw(canvas);
        n11 = this.isInEditMode() ? 1 : 0;
        if (n11 != 0) {
            n11 = this.getChildCount();
            n10 = this.getWidth();
            f10 = n10;
            int n12 = this.getHeight();
            float f11 = n12;
            float f12 = 1080.0f;
            float f13 = 1920.0f;
            for (int i10 = 0; i10 < n11; ++i10) {
                int n13;
                Object object = constraintLayout.getChildAt(i10);
                int n14 = object.getVisibility();
                if (n14 == (n13 = 8) || (object = object.getTag()) == null || (n14 = object instanceof String) == 0) continue;
                object = (String)object;
                Object object2 = ",";
                n14 = ((Object)(object = ((String)object).split((String)object2))).length;
                if (n14 != (n13 = 4)) continue;
                object2 = object[0];
                n14 = Integer.parseInt((String)object2);
                n13 = Integer.parseInt((String)object[1]);
                Object object3 = object[2];
                int n15 = Integer.parseInt((String)object3);
                object = object[3];
                int n16 = Integer.parseInt((String)object);
                n14 = (int)((float)n14 / f12 * f10);
                n13 = (int)((float)n13 / f13 * f11);
                n15 = (int)((float)n15 / f12 * f10);
                n16 = (int)((float)n16 / f13 * f11);
                Paint paint = new Paint();
                int n17 = -65536;
                paint.setColor(n17);
                float f14 = n14;
                float f15 = n13;
                float f16 = n14 += n15;
                float f17 = f15;
                f15 = f14;
                float f18 = f14;
                f14 = f17;
                canvas.drawLine(f15, f17, f16, f17, paint);
                float f19 = n13 + n16;
                f15 = f16;
                canvas.drawLine(f16, f17, f16, f19, paint);
                f14 = f19;
                canvas.drawLine(f16, f19, f18, f19, paint);
                f15 = f18;
                canvas.drawLine(f18, f19, f18, f17, paint);
                n13 = -16711936;
                paint.setColor(n13);
                f14 = f17;
                canvas.drawLine(f18, f17, f16, f19, paint);
                f14 = f19;
                canvas.drawLine(f18, f19, f16, f17, paint);
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.fillMetrics(metrics);
    }

    public void forceLayout() {
        this.markHierarchyDirty();
        super.forceLayout();
    }

    public ConstraintLayout$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = new ConstraintLayout$LayoutParams(n10, n10);
        return constraintLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = new ConstraintLayout$LayoutParams(layoutParams);
        return constraintLayout$LayoutParams;
    }

    public ConstraintLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = new ConstraintLayout$LayoutParams(context, attributeSet);
        return constraintLayout$LayoutParams;
    }

    public Object getDesignInformation(int n10, Object object) {
        if (n10 == 0 && (n10 = object instanceof String) != 0) {
            object = (String)object;
            HashMap hashMap = this.mDesignIds;
            if (hashMap != null && (n10 = (int)(hashMap.containsKey(object) ? 1 : 0)) != 0) {
                return this.mDesignIds.get(object);
            }
        }
        return null;
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.getOptimizationLevel();
    }

    public View getViewById(int n10) {
        return (View)this.mChildrenByIds.get(n10);
    }

    public final ConstraintWidget getViewWidget(View object) {
        if (object == this) {
            return this.mLayoutWidget;
        }
        object = object == null ? null : ((ConstraintLayout$LayoutParams)object.getLayoutParams()).widget;
        return object;
    }

    public boolean isRtl() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        int n12 = 17;
        if (n10 >= n12) {
            ApplicationInfo applicationInfo = this.getContext().getApplicationInfo();
            n10 = applicationInfo.flags & 0x400000;
            n12 = 1;
            if (n10 != 0) {
                n10 = n12;
            } else {
                n10 = 0;
                applicationInfo = null;
            }
            if (n10 != 0 && n12 == (n10 = this.getLayoutDirection())) {
                n11 = n12;
            }
        }
        return n11 != 0;
    }

    public void loadLayoutDescription(int n10) {
        if (n10 != 0) {
            Context context = this.getContext();
            ConstraintLayoutStates constraintLayoutStates = new ConstraintLayoutStates(context, this, n10);
            try {
                this.mConstraintLayoutSpec = constraintLayoutStates;
            }
            catch (Resources.NotFoundException notFoundException) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        n10 = this.getChildCount();
        n11 = this.isInEditMode() ? 1 : 0;
        n12 = 0;
        for (n13 = 0; n13 < n10; ++n13) {
            int n15;
            int n16;
            View view = this.getChildAt(n13);
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams)view.getLayoutParams();
            ConstraintWidget constraintWidget = constraintLayout$LayoutParams.widget;
            int n17 = view.getVisibility();
            if (n17 == (n16 = 8) && (n17 = (int)(constraintLayout$LayoutParams.isGuideline ? 1 : 0)) == 0 && (n17 = (int)(constraintLayout$LayoutParams.isHelper ? 1 : 0)) == 0 && (n17 = (int)(constraintLayout$LayoutParams.isVirtualGroup ? 1 : 0)) == 0 && n11 == 0 || (n15 = constraintLayout$LayoutParams.isInPlaceholder) != 0) continue;
            n15 = constraintWidget.getX();
            n17 = constraintWidget.getY();
            n16 = constraintWidget.getWidth() + n15;
            int n18 = constraintWidget.getHeight() + n17;
            view.layout(n15, n17, n16, n18);
            boolean bl2 = view instanceof Placeholder;
            if (!bl2 || (view = ((Placeholder)view).getContent()) == null) continue;
            view.setVisibility(0);
            view.layout(n15, n17, n16, n18);
        }
        ArrayList arrayList = this.mConstraintHelpers;
        n10 = arrayList.size();
        if (n10 > 0) {
            while (n12 < n10) {
                ConstraintHelper constraintHelper = (ConstraintHelper)((Object)this.mConstraintHelpers.get(n12));
                constraintHelper.updatePostLayout(this);
                ++n12;
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13;
        ConstraintWidgetContainer constraintWidgetContainer;
        int n14 = this.mDirtyHierarchy;
        int n15 = 0;
        if (n14 == 0) {
            n14 = this.getChildCount();
            constraintWidgetContainer = null;
            for (n13 = 0; n13 < n14; ++n13) {
                View view = this.getChildAt(n13);
                n12 = view.isLayoutRequested();
                if (n12 == 0) continue;
                n14 = 1;
                this.mDirtyHierarchy = n14;
                break;
            }
        }
        if ((n14 = (int)(this.mDirtyHierarchy ? 1 : 0)) == 0) {
            n14 = this.mOnMeasureWidthMeasureSpec;
            if (n14 == n10 && (n13 = this.mOnMeasureHeightMeasureSpec) == n11) {
                int n16 = this.mLayoutWidget.getWidth();
                int n17 = this.mLayoutWidget.getHeight();
                boolean bl2 = this.mLayoutWidget.isWidthMeasuredTooSmall();
                boolean bl3 = this.mLayoutWidget.isHeightMeasuredTooSmall();
                n13 = n10;
                n12 = n11;
                this.resolveMeasuredDimension(n10, n11, n16, n17, bl2, bl3);
                return;
            }
            if (n14 == n10 && (n14 = View.MeasureSpec.getMode((int)n10)) == (n13 = 0x40000000) && (n14 = View.MeasureSpec.getMode((int)n11)) == (n13 = -1 << -1) && (n14 = View.MeasureSpec.getMode((int)this.mOnMeasureHeightMeasureSpec)) == n13 && (n14 = View.MeasureSpec.getSize((int)n11)) >= (n13 = (constraintWidgetContainer = this.mLayoutWidget).getHeight())) {
                this.mOnMeasureWidthMeasureSpec = n10;
                this.mOnMeasureHeightMeasureSpec = n11;
                int n18 = this.mLayoutWidget.getWidth();
                int n19 = this.mLayoutWidget.getHeight();
                boolean bl4 = this.mLayoutWidget.isWidthMeasuredTooSmall();
                boolean bl5 = this.mLayoutWidget.isHeightMeasuredTooSmall();
                n13 = n10;
                n12 = n11;
                this.resolveMeasuredDimension(n10, n11, n18, n19, bl4, bl5);
                return;
            }
        }
        this.mOnMeasureWidthMeasureSpec = n10;
        this.mOnMeasureHeightMeasureSpec = n11;
        ConstraintWidgetContainer constraintWidgetContainer2 = this.mLayoutWidget;
        n13 = this.isRtl() ? 1 : 0;
        constraintWidgetContainer2.setRtl(n13 != 0);
        n14 = this.mDirtyHierarchy ? 1 : 0;
        if (n14 != 0) {
            this.mDirtyHierarchy = false;
            n14 = this.updateHierarchy() ? 1 : 0;
            if (n14 != 0) {
                constraintWidgetContainer2 = this.mLayoutWidget;
                constraintWidgetContainer2.updateHierarchy();
            }
        }
        constraintWidgetContainer2 = this.mLayoutWidget;
        n15 = this.mOptimizationLevel;
        this.resolveSystem(constraintWidgetContainer2, n15, n10, n11);
        int n20 = this.mLayoutWidget.getWidth();
        int n21 = this.mLayoutWidget.getHeight();
        boolean bl6 = this.mLayoutWidget.isWidthMeasuredTooSmall();
        boolean bl7 = this.mLayoutWidget.isHeightMeasuredTooSmall();
        n13 = n10;
        n12 = n11;
        this.resolveMeasuredDimension(n10, n11, n20, n21, bl6, bl7);
    }

    public void onViewAdded(View view) {
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 >= n11) {
            super.onViewAdded(view);
        }
        Object object2 = this.getViewWidget(view);
        n11 = view instanceof Guideline;
        boolean bl2 = true;
        if (n11 != 0 && (n10 = object2 instanceof androidx.constraintlayout.solver.widgets.Guideline) == 0) {
            object2 = (ConstraintLayout$LayoutParams)view.getLayoutParams();
            object = new androidx.constraintlayout.solver.widgets.Guideline();
            ((ConstraintLayout$LayoutParams)object2).widget = object;
            ((ConstraintLayout$LayoutParams)object2).isGuideline = bl2;
            n10 = ((ConstraintLayout$LayoutParams)object2).orientation;
            ((androidx.constraintlayout.solver.widgets.Guideline)object).setOrientation(n10);
        }
        if ((n10 = view instanceof ConstraintHelper) != 0) {
            object2 = view;
            object2 = (ConstraintHelper)view;
            ((ConstraintHelper)((Object)object2)).validateParams();
            ((ConstraintLayout$LayoutParams)view.getLayoutParams()).isHelper = bl2;
            object = this.mConstraintHelpers;
            n11 = ((ArrayList)object).contains(object2) ? 1 : 0;
            if (n11 == 0) {
                object = this.mConstraintHelpers;
                ((ArrayList)object).add(object2);
            }
        }
        object2 = this.mChildrenByIds;
        n11 = view.getId();
        object2.put(n11, (Object)view);
        this.mDirtyHierarchy = bl2;
    }

    public void onViewRemoved(View view) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 >= n11) {
            super.onViewRemoved(view);
        }
        Object object = this.mChildrenByIds;
        n11 = view.getId();
        object.remove(n11);
        object = this.getViewWidget(view);
        this.mLayoutWidget.remove((ConstraintWidget)object);
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int n10) {
        ConstraintLayoutStates constraintLayoutStates;
        Context context = this.getContext();
        this.mConstraintLayoutSpec = constraintLayoutStates = new ConstraintLayoutStates(context, this, n10);
    }

    public void removeView(View view) {
        super.removeView(view);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 14;
        if (n10 < n11) {
            this.onViewRemoved(view);
        }
    }

    public void requestLayout() {
        this.markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int n10, int n11, int n12, int n13, boolean bl2, boolean bl3) {
        ConstraintLayout$Measurer constraintLayout$Measurer = this.mMeasurer;
        int n14 = constraintLayout$Measurer.paddingHeight;
        int n15 = constraintLayout$Measurer.paddingWidth;
        n12 += n15;
        n13 += n14;
        n15 = Build.VERSION.SDK_INT;
        n14 = 11;
        if (n15 >= n14) {
            n15 = 0;
            constraintLayout$Measurer = null;
            n10 = ViewGroup.resolveSizeAndState((int)n12, (int)n10, (int)0);
            n11 = ViewGroup.resolveSizeAndState((int)n13, (int)n11, (int)0);
            n12 = 0xFFFFFF;
            n10 &= n12;
            n11 &= n12;
            n10 = Math.min(this.mMaxWidth, n10);
            n11 = Math.min(this.mMaxHeight, n11);
            n12 = 0x1000000;
            if (bl2) {
                n10 |= n12;
            }
            if (bl3) {
                n11 |= n12;
            }
            this.setMeasuredDimension(n10, n11);
            this.mLastMeasureWidth = n10;
            this.mLastMeasureHeight = n11;
        } else {
            this.setMeasuredDimension(n12, n13);
            this.mLastMeasureWidth = n12;
            this.mLastMeasureHeight = n13;
        }
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        ConstraintLayout constraintLayout = this;
        int n13 = View.MeasureSpec.getMode((int)n11);
        int n14 = View.MeasureSpec.getSize((int)n11);
        int n15 = View.MeasureSpec.getMode((int)n12);
        int n16 = View.MeasureSpec.getSize((int)n12);
        int n17 = this.getPaddingTop();
        int n18 = 0;
        int n19 = Math.max(0, n17);
        n17 = this.getPaddingBottom();
        int n20 = Math.max(0, n17);
        n17 = n19 + n20;
        int n21 = this.getPaddingWidth();
        ConstraintLayout$Measurer constraintLayout$Measurer = this.mMeasurer;
        int n22 = n11;
        int n23 = n12;
        int n24 = n19;
        constraintLayout$Measurer.captureLayoutInfos(n11, n12, n19, n20, n21, n17);
        int n25 = Build.VERSION.SDK_INT;
        int n26 = 17;
        if (n25 >= n26) {
            n25 = this.getPaddingStart();
            n25 = Math.max(0, n25);
            n26 = this.getPaddingEnd();
            n26 = Math.max(0, n26);
            if (n25 <= 0 && n26 <= 0) {
                n25 = this.getPaddingLeft();
                n25 = Math.max(0, n25);
            } else {
                n18 = this.isRtl() ? 1 : 0;
                if (n18 != 0) {
                    n25 = n26;
                }
            }
            n24 = n25;
        } else {
            n25 = this.getPaddingLeft();
            n24 = n18 = Math.max(0, n25);
        }
        int n27 = n14 - n21;
        int n28 = n16 - n17;
        n17 = n13;
        n18 = n27;
        n21 = n15;
        n25 = n28;
        this.setSelfDimensionBehaviour(constraintWidgetContainer, n13, n27, n15, n28);
        n22 = constraintLayout.mLastMeasureWidth;
        n23 = constraintLayout.mLastMeasureHeight;
        n20 = n19;
        constraintWidgetContainer.measure(n10, n13, n27, n15, n28, n22, n23, n24, n19);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int n10, Object object, Object object2) {
        if (n10 == 0 && (n10 = object instanceof String) != 0 && (n10 = object2 instanceof Integer) != 0) {
            int n11;
            HashMap hashMap = this.mDesignIds;
            if (hashMap == null) {
                this.mDesignIds = hashMap = new HashMap();
            }
            if ((n10 = ((String)(object = (String)object)).indexOf((String)((Object)(hashMap = "/")))) != (n11 = -1)) {
                object = ((String)object).substring(++n10);
            }
            n10 = (Integer)object2;
            object2 = this.mDesignIds;
            hashMap = n10;
            ((HashMap)object2).put(object, hashMap);
        }
    }

    public void setId(int n10) {
        SparseArray sparseArray = this.mChildrenByIds;
        int n11 = this.getId();
        sparseArray.remove(n11);
        super.setId(n10);
        SparseArray sparseArray2 = this.mChildrenByIds;
        int n12 = this.getId();
        sparseArray2.put(n12, (Object)this);
    }

    public void setMaxHeight(int n10) {
        int n11 = this.mMaxHeight;
        if (n10 == n11) {
            return;
        }
        this.mMaxHeight = n10;
        this.requestLayout();
    }

    public void setMaxWidth(int n10) {
        int n11 = this.mMaxWidth;
        if (n10 == n11) {
            return;
        }
        this.mMaxWidth = n10;
        this.requestLayout();
    }

    public void setMinHeight(int n10) {
        int n11 = this.mMinHeight;
        if (n10 == n11) {
            return;
        }
        this.mMinHeight = n10;
        this.requestLayout();
    }

    public void setMinWidth(int n10) {
        int n11 = this.mMinWidth;
        if (n10 == n11) {
            return;
        }
        this.mMinWidth = n10;
        this.requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.setOnConstraintsChanged(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int n10) {
        this.mOptimizationLevel = n10;
        this.mLayoutWidget.setOptimizationLevel(n10);
    }

    /*
     * Unable to fully structure code
     */
    public void setSelfDimensionBehaviour(ConstraintWidgetContainer var1_1, int var2_2, int var3_3, int var4_4, int var5_5) {
        var6_6 = this.mMeasurer;
        var7_7 = var6_6.paddingHeight;
        var8_8 = var6_6.paddingWidth;
        var9_9 = ConstraintWidget$DimensionBehaviour.FIXED;
        var10_10 = this.getChildCount();
        var11_11 = 0x40000000;
        var12_12 = -1 << -1;
        if (var2_2 != var12_12) {
            if (var2_2 != 0) {
                if (var2_2 != var11_11) {
                    var13_13 = var9_9;
                    while (true) {
                        var3_3 = 0;
                        break;
                    }
                } else {
                    var2_2 = this.mMaxWidth - var8_8;
                    var3_3 = Math.min(var2_2, var3_3);
                    var13_13 = var9_9;
                }
            } else {
                var13_13 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                if (var10_10 != 0) ** continue;
                var3_3 = this.mMinWidth;
                var3_3 = Math.max(0, var3_3);
            }
        } else {
            var13_13 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (var10_10 == 0) {
                var3_3 = this.mMinWidth;
                var3_3 = Math.max(0, var3_3);
            }
        }
        if (var4_4 != var12_12) {
            if (var4_4 != 0) {
                if (var4_4 != var11_11) {
                    while (true) {
                        var5_5 = 0;
                        break;
                    }
                } else {
                    var4_4 = this.mMaxHeight - var7_7;
                    var5_5 = Math.min(var4_4, var5_5);
                }
            } else {
                var9_9 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
                if (var10_10 != 0) ** continue;
                var4_4 = this.mMinHeight;
                var5_5 = Math.max(0, var4_4);
            }
        } else {
            var9_9 = ConstraintWidget$DimensionBehaviour.WRAP_CONTENT;
            if (var10_10 == 0) {
                var4_4 = this.mMinHeight;
                var5_5 = Math.max(0, var4_4);
            }
        }
        var4_4 = var1_1.getWidth();
        if (var3_3 != var4_4 || var5_5 != (var4_4 = var1_1.getHeight())) {
            var1_1.invalidateMeasures();
        }
        var1_1.setX(0);
        var1_1.setY(0);
        var4_4 = this.mMaxWidth - var8_8;
        var1_1.setMaxWidth(var4_4);
        var4_4 = this.mMaxHeight - var7_7;
        var1_1.setMaxHeight(var4_4);
        var1_1.setMinWidth(0);
        var1_1.setMinHeight(0);
        var1_1.setHorizontalDimensionBehaviour(var13_13);
        var1_1.setWidth(var3_3);
        var1_1.setVerticalDimensionBehaviour(var9_9);
        var1_1.setHeight(var5_5);
        var2_2 = this.mMinWidth - var8_8;
        var1_1.setMinWidth(var2_2);
        var2_2 = this.mMinHeight - var7_7;
        var1_1.setMinHeight(var2_2);
    }

    public void setState(int n10, int n11, int n12) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            float f10 = n11;
            float f11 = n12;
            constraintLayoutStates.updateConstraints(n10, f10, f11);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}

