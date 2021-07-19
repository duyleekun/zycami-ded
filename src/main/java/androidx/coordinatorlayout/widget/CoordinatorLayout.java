/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.Region$Op
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout$1;
import androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$DefaultBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout$OnPreDrawListener;
import androidx.coordinatorlayout.widget.CoordinatorLayout$SavedState;
import androidx.coordinatorlayout.widget.CoordinatorLayout$ViewElevationComparator;
import androidx.coordinatorlayout.widget.DirectedAcyclicGraph;
import androidx.coordinatorlayout.widget.ViewGroupUtils;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.GravityCompat;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout
extends ViewGroup
implements NestedScrollingParent2 {
    public static final Class[] CONSTRUCTOR_PARAMS;
    public static final int EVENT_NESTED_SCROLL = 1;
    public static final int EVENT_PRE_DRAW = 0;
    public static final int EVENT_VIEW_REMOVED = 2;
    public static final String TAG = "CoordinatorLayout";
    public static final Comparator TOP_SORTED_CHILDREN_COMPARATOR;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    public static final String WIDGET_PACKAGE_NAME;
    public static final ThreadLocal sConstructors;
    private static final Pools$Pool sRectPool;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private View mBehaviorTouchView;
    private final DirectedAcyclicGraph mChildDag;
    private final List mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private CoordinatorLayout$OnPreDrawListener mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List mTempDependenciesList;
    private final int[] mTempIntPair;
    private final List mTempList1;

    static {
        int n10;
        Object object = CoordinatorLayout.class.getPackage();
        if (object != null) {
            object = object.getName();
        } else {
            n10 = 0;
            object = null;
        }
        WIDGET_PACKAGE_NAME = object;
        n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        TOP_SORTED_CHILDREN_COMPARATOR = n10 >= n11 ? (object = new CoordinatorLayout$ViewElevationComparator()) : null;
        object = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTOR_PARAMS = object;
        sConstructors = object = new ThreadLocal();
        sRectPool = object = new Pools$SynchronizedPool(12);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.coordinatorLayoutStyle;
        this(context, attributeSet, n10);
    }

    public CoordinatorLayout(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        int[] nArray;
        int[] nArray2;
        Object object2 = new ArrayList();
        this.mDependencySortedChildren = object2;
        this.mChildDag = object2 = new DirectedAcyclicGraph();
        object2 = new ArrayList();
        this.mTempList1 = object2;
        object2 = new ArrayList();
        this.mTempDependenciesList = object2;
        object2 = new int[2];
        this.mTempIntPair = (int[])object2;
        this.mNestedScrollingParentHelper = object2 = new NestedScrollingParentHelper(this);
        int n11 = 0;
        object2 = null;
        if (n10 == 0) {
            nArray2 = R$styleable.CoordinatorLayout;
            int n12 = R$style.Widget_Support_CoordinatorLayout;
            attributeSet = object.obtainStyledAttributes(attributeSet, nArray2, 0, n12);
        } else {
            nArray = R$styleable.CoordinatorLayout;
            attributeSet = object.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        }
        n10 = R$styleable.CoordinatorLayout_keylines;
        n10 = attributeSet.getResourceId(n10, 0);
        if (n10 != 0) {
            object = object.getResources();
            nArray2 = object.getIntArray(n10);
            this.mKeylines = nArray2;
            object = object.getDisplayMetrics();
            float f10 = object.density;
            nArray2 = this.mKeylines;
            n10 = nArray2.length;
            while (n11 < n10) {
                int n13;
                nArray = this.mKeylines;
                float f11 = (float)nArray[n11] * f10;
                nArray[n11] = n13 = (int)f11;
                ++n11;
            }
        }
        int n14 = R$styleable.CoordinatorLayout_statusBarBackground;
        object = attributeSet.getDrawable(n14);
        this.mStatusBarBackground = object;
        attributeSet.recycle();
        this.setupForInsets();
        super(this);
        super.setOnHierarchyChangeListener((ViewGroup.OnHierarchyChangeListener)object);
    }

    private static Rect acquireTempRect() {
        Rect rect = (Rect)sRectPool.acquire();
        if (rect == null) {
            rect = new Rect();
        }
        return rect;
    }

    private static int clamp(int n10, int n11, int n12) {
        if (n10 < n11) {
            return n11;
        }
        if (n10 > n12) {
            return n12;
        }
        return n10;
    }

    private void constrainChildRect(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams, Rect rect, int n10, int n11) {
        int n12 = this.getWidth();
        int n13 = this.getHeight();
        int n14 = this.getPaddingLeft();
        int n15 = coordinatorLayout$LayoutParams.leftMargin;
        n14 += n15;
        n15 = rect.left;
        int n16 = this.getPaddingRight();
        n12 = n12 - n16 - n10;
        n16 = coordinatorLayout$LayoutParams.rightMargin;
        n12 -= n16;
        n12 = Math.min(n15, n12);
        n12 = Math.max(n14, n12);
        n14 = this.getPaddingTop();
        n15 = coordinatorLayout$LayoutParams.topMargin;
        n14 += n15;
        n15 = rect.top;
        n16 = this.getPaddingBottom();
        n13 = n13 - n16 - n11;
        int n17 = coordinatorLayout$LayoutParams.bottomMargin;
        n13 -= n17;
        n17 = Math.min(n15, n13);
        n17 = Math.max(n14, n17);
        rect.set(n12, n17, n10 += n12, n11 += n17);
    }

    private WindowInsetsCompat dispatchApplyWindowInsetsToBehaviors(WindowInsetsCompat windowInsetsCompat) {
        boolean bl2;
        CoordinatorLayout$Behavior coordinatorLayout$Behavior;
        View view;
        boolean bl3;
        int n10 = windowInsetsCompat.isConsumed();
        if (n10 != 0) {
            return windowInsetsCompat;
        }
        int n11 = this.getChildCount();
        for (n10 = 0; !(n10 >= n11 || (bl3 = ViewCompat.getFitsSystemWindows(view = this.getChildAt(n10))) && (coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getBehavior()) != null && (bl2 = (windowInsetsCompat = coordinatorLayout$Behavior.onApplyWindowInsets(this, view, windowInsetsCompat)).isConsumed())); ++n10) {
        }
        return windowInsetsCompat;
    }

    private void getDesiredAnchoredChildRectWithoutConstraints(View view, int n10, Rect rect, Rect rect2, CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams, int n11, int n12) {
        int n13;
        int n14;
        int n15 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveAnchoredChildGravity(coordinatorLayout$LayoutParams.gravity), n10);
        n10 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveGravity(coordinatorLayout$LayoutParams.anchorGravity), n10);
        int n16 = n15 & 7;
        n15 &= 0x70;
        int n17 = n10 & 7;
        n10 &= 0x70;
        int n18 = 5;
        int n19 = 1;
        if (n17 != n19) {
            n17 = n17 != n18 ? rect.left : rect.right;
        } else {
            n17 = rect.left;
            n14 = rect.width() / 2;
            n17 += n14;
        }
        n14 = 80;
        int n20 = 16;
        if (n10 != n20) {
            n10 = n10 != n14 ? rect.top : rect.bottom;
        } else {
            n10 = rect.top;
            n13 = rect.height() / 2;
            n10 += n13;
        }
        if (n16 != n19) {
            if (n16 != n18) {
                n17 -= n11;
            }
        } else {
            n13 = n11 / 2;
            n17 -= n13;
        }
        if (n15 != n20) {
            if (n15 != n14) {
                n10 -= n12;
            }
        } else {
            n15 = n12 / 2;
            n10 -= n15;
        }
        rect2.set(n17, n10, n11 += n17, n12 += n10);
    }

    private int getKeyline(int n10) {
        int n11;
        Object object = this.mKeylines;
        String string2 = TAG;
        if (object == null) {
            object = new StringBuilder;
            ((StringBuilder)object)();
            ((StringBuilder)object).append("No keylines defined for ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(" - attempted index lookup ");
            ((StringBuilder)object).append(n10);
            String string3 = ((StringBuilder)object).toString();
            Log.e((String)string2, (String)string3);
            return 0;
        }
        if (n10 >= 0 && n10 < (n11 = ((int[])object).length)) {
            return (int)object[n10];
        }
        object = new StringBuilder;
        ((StringBuilder)object)();
        ((StringBuilder)object).append("Keyline index ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" out of range for ");
        ((StringBuilder)object).append(this);
        String string4 = ((StringBuilder)object).toString();
        Log.e((String)string2, (String)string4);
        return 0;
    }

    private void getTopSortedChildren(List list) {
        list.clear();
        boolean bl2 = this.isChildrenDrawingOrderEnabled();
        int n10 = this.getChildCount();
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            int n11 = bl2 ? this.getChildDrawingOrder(n10, i10) : i10;
            View view = this.getChildAt(n11);
            list.add(view);
        }
        Comparator comparator = TOP_SORTED_CHILDREN_COMPARATOR;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean hasDependencies(View view) {
        return this.mChildDag.hasOutgoingEdges(view);
    }

    private void layoutChild(View view, int n10) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        Rect rect = CoordinatorLayout.acquireTempRect();
        int n11 = this.getPaddingLeft();
        int n12 = coordinatorLayout$LayoutParams.leftMargin;
        n11 += n12;
        n12 = this.getPaddingTop();
        int n13 = coordinatorLayout$LayoutParams.topMargin;
        n12 += n13;
        n13 = this.getWidth();
        int n14 = this.getPaddingRight();
        n13 -= n14;
        n14 = coordinatorLayout$LayoutParams.rightMargin;
        n13 -= n14;
        n14 = this.getHeight();
        int n15 = this.getPaddingBottom();
        n14 -= n15;
        n15 = coordinatorLayout$LayoutParams.bottomMargin;
        rect.set(n11, n12, n13, n14 -= n15);
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        if (windowInsetsCompat != null && (n11 = (int)(ViewCompat.getFitsSystemWindows((View)this) ? 1 : 0)) != 0 && (n11 = (int)(ViewCompat.getFitsSystemWindows(view) ? 1 : 0)) == 0) {
            n11 = rect.left;
            n12 = this.mLastInsets.getSystemWindowInsetLeft();
            rect.left = n11 += n12;
            n11 = rect.top;
            n12 = this.mLastInsets.getSystemWindowInsetTop();
            rect.top = n11 += n12;
            n11 = rect.right;
            n12 = this.mLastInsets.getSystemWindowInsetRight();
            rect.right = n11 -= n12;
            n11 = rect.bottom;
            WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
            n12 = windowInsetsCompat2.getSystemWindowInsetBottom();
            rect.bottom = n11 -= n12;
        }
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        n11 = CoordinatorLayout.resolveGravity(coordinatorLayout$LayoutParams.gravity);
        n12 = view.getMeasuredWidth();
        n13 = view.getMeasuredHeight();
        GravityCompat.apply(n11, n12, n13, rect, rect2, n10);
        n10 = rect2.left;
        int n16 = rect2.top;
        n11 = rect2.right;
        n12 = rect2.bottom;
        view.layout(n10, n16, n11, n12);
        CoordinatorLayout.releaseTempRect(rect);
        CoordinatorLayout.releaseTempRect(rect2);
    }

    private void layoutChildWithAnchor(View view, View view2, int n10) {
        Rect rect = CoordinatorLayout.acquireTempRect();
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        try {
            this.getDescendantRect(view2, rect);
            this.getDesiredAnchoredChildRect(view, n10, rect, rect2);
            int n11 = rect2.left;
            n10 = rect2.top;
            int n12 = rect2.right;
            int n13 = rect2.bottom;
            view.layout(n11, n10, n12, n13);
            return;
        }
        finally {
            CoordinatorLayout.releaseTempRect(rect);
            CoordinatorLayout.releaseTempRect(rect2);
        }
    }

    private void layoutChildWithKeyline(View view, int n10, int n11) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        int n12 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveKeylineGravity(coordinatorLayout$LayoutParams.gravity), n11);
        int n13 = n12 & 7;
        n12 &= 0x70;
        int n14 = this.getWidth();
        int n15 = this.getHeight();
        int n16 = view.getMeasuredWidth();
        int n17 = view.getMeasuredHeight();
        int n18 = 1;
        if (n11 == n18) {
            n10 = n14 - n10;
        }
        n10 = this.getKeyline(n10) - n16;
        n11 = 0;
        if (n13 != n18) {
            n18 = 5;
            if (n13 == n18) {
                n10 += n16;
            }
        } else {
            n13 = n16 / 2;
            n10 += n13;
        }
        n13 = 16;
        if (n12 != n13) {
            n13 = 80;
            if (n12 == n13) {
                n11 = n17 + 0;
            }
        } else {
            n12 = n17 / 2;
            n11 = 0 + n12;
        }
        n12 = this.getPaddingLeft();
        n13 = coordinatorLayout$LayoutParams.leftMargin;
        n12 += n13;
        n13 = this.getPaddingRight();
        n14 = n14 - n13 - n16;
        n13 = coordinatorLayout$LayoutParams.rightMargin;
        n10 = Math.min(n10, n14 -= n13);
        n10 = Math.max(n12, n10);
        n12 = this.getPaddingTop();
        n13 = coordinatorLayout$LayoutParams.topMargin;
        n12 += n13;
        n13 = this.getPaddingBottom();
        n15 = n15 - n13 - n17;
        int n19 = coordinatorLayout$LayoutParams.bottomMargin;
        n11 = Math.min(n11, n15 -= n19);
        n11 = Math.max(n12, n11);
        view.layout(n10, n11, n16 += n10, n17 += n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void offsetChildByInset(View var1_1, Rect var2_2, int var3_3) {
        block15: {
            var4_4 = ViewCompat.isLaidOut(var1_1 /* !! */ );
            if (var4_4 == 0) {
                return;
            }
            var4_4 = var1_1 /* !! */ .getWidth();
            if (var4_4 <= 0 || (var4_4 = var1_1 /* !! */ .getHeight()) <= 0) break block15;
            var5_5 = (CoordinatorLayout$LayoutParams)var1_1 /* !! */ .getLayoutParams();
            var6_6 = var5_5.getBehavior();
            var7_7 = CoordinatorLayout.acquireTempRect();
            var8_8 = CoordinatorLayout.acquireTempRect();
            var9_9 = var1_1 /* !! */ .getLeft();
            var10_10 = var1_1 /* !! */ .getTop();
            var11_11 = var1_1 /* !! */ .getRight();
            var12_12 = var1_1 /* !! */ .getBottom();
            var8_8.set(var9_9, var10_10, var11_11, var12_12);
            if (var6_6 != null && (var13_13 = var6_6.getInsetDodgeRect(this, var1_1 /* !! */ , var7_7)) != 0) {
                var13_13 = var8_8.contains(var7_7);
                if (var13_13 == 0) {
                    var2_2 = new StringBuilder();
                    var2_2.append("Rect should be within the child's bounds. Rect:");
                    var14_14 = var7_7.toShortString();
                    var2_2.append(var14_14);
                    var2_2.append(" | Bounds:");
                    var14_14 = var8_8.toShortString();
                    var2_2.append(var14_14);
                    var2_2 = var2_2.toString();
                    var1_1 /* !! */  = new IllegalArgumentException((String)var2_2);
                    throw var1_1 /* !! */ ;
                }
            } else {
                var7_7.set(var8_8);
            }
            CoordinatorLayout.releaseTempRect(var8_8);
            var13_13 = var7_7.isEmpty();
            if (var13_13 != 0) {
                CoordinatorLayout.releaseTempRect(var7_7);
                return;
            }
            var3_3 = GravityCompat.getAbsoluteGravity(var5_5.dodgeInsetEdges, var3_3);
            var13_13 = var3_3 & 48;
            var15_15 = 48;
            var9_9 = 1;
            var16_16 = 1.4E-45f;
            var10_10 = 0;
            if (var13_13 != var15_15) ** GOTO lbl-1000
            var13_13 = var7_7.top;
            var15_15 = var5_5.topMargin;
            var13_13 -= var15_15;
            var15_15 = var5_5.mInsetOffsetY;
            if ((var13_13 -= var15_15) < (var15_15 = var2_2.top)) {
                this.setInsetOffsetY(var1_1 /* !! */ , var15_15 -= var13_13);
                var13_13 = var9_9;
                var17_17 = var16_16;
            } else lbl-1000:
            // 2 sources

            {
                var13_13 = 0;
                var6_6 = null;
                var17_17 = 0.0f;
            }
            var15_15 = var3_3 & 80;
            var11_11 = 80;
            if (var15_15 == var11_11) {
                var15_15 = this.getHeight();
                var11_11 = var7_7.bottom;
                var15_15 -= var11_11;
                var11_11 = var5_5.bottomMargin;
                var15_15 -= var11_11;
                var11_11 = var5_5.mInsetOffsetY;
                if ((var15_15 += var11_11) < (var11_11 = var2_2.bottom)) {
                    this.setInsetOffsetY(var1_1 /* !! */ , var15_15 -= var11_11);
                    var13_13 = var9_9;
                    var17_17 = var16_16;
                }
            }
            if (var13_13 == 0) {
                this.setInsetOffsetY(var1_1 /* !! */ , 0);
            }
            if ((var13_13 = var3_3 & 3) != (var15_15 = 3)) ** GOTO lbl-1000
            var13_13 = var7_7.left;
            var15_15 = var5_5.leftMargin;
            var13_13 -= var15_15;
            var15_15 = var5_5.mInsetOffsetX;
            if ((var13_13 -= var15_15) < (var15_15 = var2_2.left)) {
                this.setInsetOffsetX(var1_1 /* !! */ , var15_15 -= var13_13);
                var13_13 = var9_9;
                var17_17 = var16_16;
            } else lbl-1000:
            // 2 sources

            {
                var13_13 = 0;
                var6_6 = null;
                var17_17 = 0.0f;
            }
            var15_15 = 5;
            if ((var3_3 &= var15_15) != var15_15) ** GOTO lbl-1000
            var3_3 = this.getWidth();
            var15_15 = var7_7.right;
            var3_3 -= var15_15;
            var15_15 = var5_5.rightMargin;
            var3_3 -= var15_15;
            var4_4 = var5_5.mInsetOffsetX;
            var18_18 = var2_2.right;
            if ((var3_3 += var4_4) < var18_18) {
                this.setInsetOffsetX(var1_1 /* !! */ , var3_3 -= var18_18);
            } else lbl-1000:
            // 2 sources

            {
                var9_9 = var13_13;
                var16_16 = var17_17;
            }
            if (var9_9 == 0) {
                this.setInsetOffsetX(var1_1 /* !! */ , 0);
            }
            CoordinatorLayout.releaseTempRect(var7_7);
        }
    }

    public static CoordinatorLayout$Behavior parseBehavior(Context object, AttributeSet object2, String string2) {
        Class[] classArray;
        int n10;
        Object[] objectArray;
        Object object3;
        block25: {
            boolean bl2;
            block24: {
                char c10 = TextUtils.isEmpty((CharSequence)string2);
                if (c10 != '\u0000') {
                    return null;
                }
                object3 = ".";
                c10 = string2.startsWith((String)object3);
                if (c10 != '\u0000') {
                    object3 = new StringBuilder();
                    objectArray = object.getPackageName();
                    ((StringBuilder)object3).append((String)objectArray);
                    ((StringBuilder)object3).append(string2);
                    string2 = ((StringBuilder)object3).toString();
                } else {
                    c10 = '.';
                    n10 = string2.indexOf(c10);
                    if (n10 < 0 && !(bl2 = TextUtils.isEmpty((CharSequence)(objectArray = WIDGET_PACKAGE_NAME)))) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String)objectArray);
                        stringBuilder.append(c10);
                        stringBuilder.append(string2);
                        string2 = stringBuilder.toString();
                    }
                }
                try {
                    object3 = sConstructors;
                }
                catch (Exception exception) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Could not inflate Behavior subclass ");
                    ((StringBuilder)object3).append(string2);
                    string2 = ((StringBuilder)object3).toString();
                    object2 = new RuntimeException(string2, exception);
                    throw object2;
                }
                objectArray = ((ThreadLocal)object3).get();
                objectArray = (Map)objectArray;
                if (objectArray != null) break block24;
                objectArray = new HashMap();
                ((ThreadLocal)object3).set(objectArray);
            }
            object3 = objectArray.get(string2);
            object3 = (Constructor)object3;
            bl2 = true;
            if (object3 != null) break block25;
            object3 = object.getClassLoader();
            object3 = ((ClassLoader)object3).loadClass(string2);
            classArray = CONSTRUCTOR_PARAMS;
            object3 = ((Class)object3).getConstructor(classArray);
            ((Constructor)object3).setAccessible(bl2);
            objectArray.put(string2, object3);
        }
        n10 = 2;
        objectArray = new Object[n10];
        classArray = null;
        objectArray[0] = object;
        objectArray[bl2] = object2;
        object = ((Constructor)object3).newInstance(objectArray);
        return (CoordinatorLayout$Behavior)object;
    }

    private boolean performIntercept(MotionEvent motionEvent, int n10) {
        CoordinatorLayout coordinatorLayout = this;
        MotionEvent motionEvent2 = motionEvent;
        int n11 = n10;
        int n12 = motionEvent.getActionMasked();
        List list = this.mTempList1;
        this.getTopSortedChildren(list);
        int n13 = list.size();
        MotionEvent motionEvent3 = null;
        boolean bl2 = false;
        int n14 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            View view = (View)list.get(i10);
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = coordinatorLayout$LayoutParams.getBehavior();
            int n15 = 1;
            if ((bl2 || n14 != 0) && n12 != 0) {
                if (coordinatorLayout$Behavior == null) continue;
                if (motionEvent3 == null) {
                    long l10 = SystemClock.uptimeMillis();
                    int n16 = 3;
                    motionEvent3 = MotionEvent.obtain((long)l10, (long)l10, (int)n16, (float)0.0f, (float)0.0f, (int)0);
                }
                if (n11 != 0) {
                    if (n11 != n15) continue;
                    coordinatorLayout$Behavior.onTouchEvent(coordinatorLayout, view, motionEvent3);
                    continue;
                }
                coordinatorLayout$Behavior.onInterceptTouchEvent(coordinatorLayout, view, motionEvent3);
                continue;
            }
            if (!bl2 && coordinatorLayout$Behavior != null) {
                if (n11 != 0) {
                    if (n11 == n15) {
                        bl2 = coordinatorLayout$Behavior.onTouchEvent(coordinatorLayout, view, motionEvent2);
                    }
                } else {
                    bl2 = coordinatorLayout$Behavior.onInterceptTouchEvent(coordinatorLayout, view, motionEvent2);
                }
                if (bl2) {
                    coordinatorLayout.mBehaviorTouchView = view;
                }
            }
            n14 = coordinatorLayout$LayoutParams.didBlockInteraction();
            boolean bl3 = coordinatorLayout$LayoutParams.isBlockingInteractionBelow(coordinatorLayout, view);
            n14 = bl3 && n14 == 0 ? n15 : 0;
            if (bl3 && n14 == 0) break;
        }
        list.clear();
        return bl2;
    }

    private void prepareChildren() {
        this.mDependencySortedChildren.clear();
        Object object = this.mChildDag;
        ((DirectedAcyclicGraph)object).clear();
        int n10 = this.getChildCount();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = this.getResolvedLayoutParams(view);
            coordinatorLayout$LayoutParams.findAnchorView(this, view);
            this.mChildDag.addNode(view);
            for (int i11 = 0; i11 < n10; ++i11) {
                View view2;
                boolean bl2;
                if (i11 == i10 || !(bl2 = coordinatorLayout$LayoutParams.dependsOn(this, view, view2 = this.getChildAt(i11)))) continue;
                DirectedAcyclicGraph directedAcyclicGraph = this.mChildDag;
                bl2 = directedAcyclicGraph.contains(view2);
                if (!bl2) {
                    directedAcyclicGraph = this.mChildDag;
                    directedAcyclicGraph.addNode(view2);
                }
                directedAcyclicGraph = this.mChildDag;
                directedAcyclicGraph.addEdge(view2, view);
            }
        }
        object = this.mDependencySortedChildren;
        arrayList = this.mChildDag.getSortedList();
        object.addAll(arrayList);
        Collections.reverse(this.mDependencySortedChildren);
    }

    private static void releaseTempRect(Rect rect) {
        rect.setEmpty();
        sRectPool.release(rect);
    }

    private void resetTouchBehaviors(boolean n10) {
        int n11 = this.getChildCount();
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.getChildAt(i10);
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getBehavior();
            if (coordinatorLayout$Behavior == null) continue;
            long l10 = SystemClock.uptimeMillis();
            int n12 = 3;
            MotionEvent motionEvent = MotionEvent.obtain((long)l10, (long)l10, (int)n12, (float)0.0f, (float)0.0f, (int)0);
            if (n10 != 0) {
                coordinatorLayout$Behavior.onInterceptTouchEvent(this, view, motionEvent);
            } else {
                coordinatorLayout$Behavior.onTouchEvent(this, view, motionEvent);
            }
            motionEvent.recycle();
        }
        for (n10 = 0; n10 < n11; ++n10) {
            coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)this.getChildAt(n10).getLayoutParams();
            coordinatorLayout$LayoutParams.resetTouchBehaviorTracking();
        }
        this.mBehaviorTouchView = null;
        this.mDisallowInterceptReset = false;
    }

    private static int resolveAnchoredChildGravity(int n10) {
        if (n10 == 0) {
            n10 = 17;
        }
        return n10;
    }

    private static int resolveGravity(int n10) {
        int n11 = n10 & 7;
        if (n11 == 0) {
            n11 = 0x800003;
            n10 |= n11;
        }
        if ((n11 = n10 & 0x70) == 0) {
            n10 |= 0x30;
        }
        return n10;
    }

    private static int resolveKeylineGravity(int n10) {
        if (n10 == 0) {
            n10 = 8388661;
        }
        return n10;
    }

    private void setInsetOffsetX(View view, int n10) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        int n11 = coordinatorLayout$LayoutParams.mInsetOffsetX;
        if (n11 != n10) {
            n11 = n10 - n11;
            ViewCompat.offsetLeftAndRight(view, n11);
            coordinatorLayout$LayoutParams.mInsetOffsetX = n10;
        }
    }

    private void setInsetOffsetY(View view, int n10) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        int n11 = coordinatorLayout$LayoutParams.mInsetOffsetY;
        if (n11 != n10) {
            n11 = n10 - n11;
            ViewCompat.offsetTopAndBottom(view, n11);
            coordinatorLayout$LayoutParams.mInsetOffsetY = n10;
        }
    }

    private void setupForInsets() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            return;
        }
        n10 = (int)(ViewCompat.getFitsSystemWindows((View)this) ? 1 : 0);
        if (n10 != 0) {
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
            if (onApplyWindowInsetsListener == null) {
                this.mApplyWindowInsetsListener = onApplyWindowInsetsListener = new CoordinatorLayout$1(this);
            }
            onApplyWindowInsetsListener = this.mApplyWindowInsetsListener;
            ViewCompat.setOnApplyWindowInsetsListener((View)this, onApplyWindowInsetsListener);
            n10 = 1280;
            this.setSystemUiVisibility(n10);
        } else {
            n10 = 0;
            Object var3_4 = null;
            ViewCompat.setOnApplyWindowInsetsListener((View)this, null);
        }
    }

    public void addPreDrawListener() {
        boolean bl2 = this.mIsAttachedToWindow;
        if (bl2) {
            CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener = this.mOnPreDrawListener;
            if (coordinatorLayout$OnPreDrawListener == null) {
                this.mOnPreDrawListener = coordinatorLayout$OnPreDrawListener = new CoordinatorLayout$OnPreDrawListener(this);
            }
            coordinatorLayout$OnPreDrawListener = this.getViewTreeObserver();
            CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener2 = this.mOnPreDrawListener;
            coordinatorLayout$OnPreDrawListener.addOnPreDrawListener(coordinatorLayout$OnPreDrawListener2);
        }
        this.mNeedsPreDrawListener = true;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = layoutParams instanceof CoordinatorLayout$LayoutParams;
        if (bl3 && (bl2 = super.checkLayoutParams(layoutParams))) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public void dispatchDependentViewsChanged(View view) {
        int n10;
        List list = this.mChildDag.getIncomingEdges(view);
        if (list != null && (n10 = list.isEmpty()) == 0) {
            int n11;
            for (n10 = 0; n10 < (n11 = list.size()); ++n10) {
                View view2 = (View)list.get(n10);
                CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view2.getLayoutParams()).getBehavior();
                if (coordinatorLayout$Behavior == null) continue;
                coordinatorLayout$Behavior.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public boolean doViewsOverlap(View view, View view2) {
        int n10 = view.getVisibility();
        int n11 = 0;
        if (n10 == 0 && (n10 = view2.getVisibility()) == 0) {
            Rect rect;
            block14: {
                int n12;
                int n13;
                rect = CoordinatorLayout.acquireTempRect();
                ViewParent viewParent = view.getParent();
                int n14 = 1;
                if (viewParent != this) {
                    n13 = n14;
                } else {
                    n13 = 0;
                    viewParent = null;
                }
                this.getChildRect(view, n13 != 0, rect);
                view = CoordinatorLayout.acquireTempRect();
                viewParent = view2.getParent();
                if (viewParent != this) {
                    n13 = n14;
                } else {
                    n13 = 0;
                    viewParent = null;
                }
                this.getChildRect(view2, n13 != 0, (Rect)view);
                try {
                    n12 = rect.left;
                }
                catch (Throwable throwable) {
                    CoordinatorLayout.releaseTempRect(rect);
                    CoordinatorLayout.releaseTempRect((Rect)view);
                    throw throwable;
                }
                n13 = view.right;
                if (n12 > n13) break block14;
                n12 = rect.top;
                n13 = view.bottom;
                if (n12 > n13) break block14;
                n12 = rect.right;
                n13 = view.left;
                if (n12 < n13) break block14;
                n12 = rect.bottom;
                n13 = view.top;
                if (n12 < n13) break block14;
                n11 = n14;
            }
            CoordinatorLayout.releaseTempRect(rect);
            CoordinatorLayout.releaseTempRect((Rect)view);
            return n11 != 0;
        }
        return false;
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = coordinatorLayout$LayoutParams.mBehavior;
        if (coordinatorLayout$Behavior != null) {
            float f10 = coordinatorLayout$Behavior.getScrimOpacity(this, view);
            Paint paint = null;
            float f11 = f10 - 0.0f;
            Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object > 0) {
                Region.Op op;
                float f12;
                float f13;
                float f14;
                paint = this.mScrimPaint;
                if (paint == null) {
                    this.mScrimPaint = paint = new Paint();
                }
                paint = this.mScrimPaint;
                int n10 = coordinatorLayout$LayoutParams.mBehavior.getScrimColor(this, view);
                paint.setColor(n10);
                coordinatorLayout$LayoutParams = this.mScrimPaint;
                int n11 = Math.round(f10 *= 255.0f);
                object = false;
                paint = null;
                int n12 = 255;
                float f15 = 3.57E-43f;
                n11 = CoordinatorLayout.clamp(n11, 0, n12);
                coordinatorLayout$LayoutParams.setAlpha(n11);
                n10 = canvas.save();
                n11 = (int)(view.isOpaque() ? 1 : 0);
                if (n11 != 0) {
                    f15 = view.getLeft();
                    f14 = view.getTop();
                    f13 = view.getRight();
                    n11 = view.getBottom();
                    f12 = n11;
                    op = Region.Op.DIFFERENCE;
                    paint = canvas;
                    canvas.clipRect(f15, f14, f13, f12, op);
                }
                f15 = this.getPaddingLeft();
                f14 = this.getPaddingTop();
                n11 = this.getWidth();
                object = this.getPaddingRight();
                f13 = n11 - object;
                n11 = this.getHeight();
                object = this.getPaddingBottom();
                f12 = n11 -= object;
                op = this.mScrimPaint;
                paint = canvas;
                canvas.drawRect(f15, f14, f13, f12, (Paint)op);
                canvas.restoreToCount(n10);
            }
        }
        return super.drawChild(canvas, view, l10);
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable2 = this.mStatusBarBackground;
        boolean bl3 = false;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            boolean bl4 = drawable2.setState(nArray);
            bl3 = false | bl4;
        }
        if (bl3) {
            this.invalidate();
        }
    }

    public void ensurePreDrawListener() {
        int n10 = this.getChildCount();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            boolean bl2 = this.hasDependencies(view);
            if (!bl2) continue;
            n11 = 1;
            break;
        }
        if (n11 != (n10 = (int)(this.mNeedsPreDrawListener ? 1 : 0))) {
            if (n11 != 0) {
                this.addPreDrawListener();
            } else {
                this.removePreDrawListener();
            }
        }
    }

    public CoordinatorLayout$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = new CoordinatorLayout$LayoutParams(n10, n10);
        return coordinatorLayout$LayoutParams;
    }

    public CoordinatorLayout$LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = new CoordinatorLayout$LayoutParams(context, attributeSet);
        return coordinatorLayout$LayoutParams;
    }

    public CoordinatorLayout$LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        boolean bl2 = object instanceof CoordinatorLayout$LayoutParams;
        if (bl2) {
            object = (CoordinatorLayout$LayoutParams)((Object)object);
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = new CoordinatorLayout$LayoutParams((CoordinatorLayout$LayoutParams)((Object)object));
            return coordinatorLayout$LayoutParams;
        }
        bl2 = object instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            object = (ViewGroup.MarginLayoutParams)object;
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = new CoordinatorLayout$LayoutParams((ViewGroup.MarginLayoutParams)object);
            return coordinatorLayout$LayoutParams;
        }
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = new CoordinatorLayout$LayoutParams((ViewGroup.LayoutParams)object);
        return coordinatorLayout$LayoutParams;
    }

    /*
     * WARNING - void declaration
     */
    public void getChildRect(View view, boolean bl2, Rect rect) {
        void var3_4;
        int n10;
        int n11 = view.isLayoutRequested();
        if (n11 == 0 && (n11 = view.getVisibility()) != (n10 = 8)) {
            if (bl2) {
                this.getDescendantRect(view, (Rect)var3_4);
            } else {
                int n12 = view.getLeft();
                n11 = view.getTop();
                n10 = view.getRight();
                int n13 = view.getBottom();
                var3_4.set(n12, n11, n10, n13);
            }
            return;
        }
        var3_4.setEmpty();
    }

    public List getDependencies(View object) {
        object = this.mChildDag.getOutgoingEdges(object);
        List list = this.mTempDependenciesList;
        list.clear();
        if (object != null) {
            list = this.mTempDependenciesList;
            list.addAll(object);
        }
        return this.mTempDependenciesList;
    }

    public final List getDependencySortedChildren() {
        this.prepareChildren();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    public List getDependents(View object) {
        object = this.mChildDag.getIncomingEdges(object);
        List list = this.mTempDependenciesList;
        list.clear();
        if (object != null) {
            list = this.mTempDependenciesList;
            list.addAll(object);
        }
        return this.mTempDependenciesList;
    }

    public void getDescendantRect(View view, Rect rect) {
        ViewGroupUtils.getDescendantRect(this, view, rect);
    }

    public void getDesiredAnchoredChildRect(View view, int n10, Rect rect, Rect rect2) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
        int n11 = view.getMeasuredWidth();
        int n12 = view.getMeasuredHeight();
        this.getDesiredAnchoredChildRectWithoutConstraints(view, n10, rect, rect2, coordinatorLayout$LayoutParams, n11, n12);
        this.constrainChildRect(coordinatorLayout$LayoutParams, rect2, n11, n12);
    }

    public void getLastChildRect(View view, Rect rect) {
        view = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getLastChildRect();
        rect.set((Rect)view);
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public CoordinatorLayout$LayoutParams getResolvedLayoutParams(View object) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)object.getLayoutParams();
        boolean bl2 = coordinatorLayout$LayoutParams.mBehaviorResolved;
        if (!bl2) {
            bl2 = object instanceof CoordinatorLayout$AttachedBehavior;
            String string2 = TAG;
            boolean bl3 = true;
            if (bl2) {
                if ((object = ((CoordinatorLayout$AttachedBehavior)object).getBehavior()) == null) {
                    String string3 = "Attached behavior class is null";
                    Log.e((String)string2, (String)string3);
                }
                coordinatorLayout$LayoutParams.setBehavior((CoordinatorLayout$Behavior)object);
                coordinatorLayout$LayoutParams.mBehaviorResolved = bl3;
            } else {
                bl2 = false;
                Object object2 = null;
                for (object = object.getClass(); object != null && (object2 = object.getAnnotation(CoordinatorLayout$DefaultBehavior.class)) == null; object = object.getSuperclass()) {
                }
                if (object2 != null) {
                    object = object2.value();
                    Object[] objectArray = null;
                    Class[] classArray = new Class[]{};
                    object = object.getDeclaredConstructor(classArray);
                    objectArray = new Object[]{};
                    object = object.newInstance(objectArray);
                    object = (CoordinatorLayout$Behavior)object;
                    try {
                        coordinatorLayout$LayoutParams.setBehavior((CoordinatorLayout$Behavior)object);
                    }
                    catch (Exception exception) {
                        objectArray = new StringBuilder();
                        classArray = "Default behavior class ";
                        objectArray.append((String)classArray);
                        object2 = object2.value().getName();
                        objectArray.append((String)object2);
                        objectArray.append(" could not be instantiated. Did you forget");
                        objectArray.append(" a default constructor?");
                        object2 = objectArray.toString();
                        Log.e((String)string2, (String)object2, (Throwable)exception);
                    }
                }
                coordinatorLayout$LayoutParams.mBehaviorResolved = bl3;
            }
        }
        return coordinatorLayout$LayoutParams;
    }

    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    public int getSuggestedMinimumHeight() {
        int n10 = super.getSuggestedMinimumHeight();
        int n11 = this.getPaddingTop();
        int n12 = this.getPaddingBottom();
        return Math.max(n10, n11 += n12);
    }

    public int getSuggestedMinimumWidth() {
        int n10 = super.getSuggestedMinimumWidth();
        int n11 = this.getPaddingLeft();
        int n12 = this.getPaddingRight();
        return Math.max(n10, n11 += n12);
    }

    public boolean isPointInChildBounds(View view, int n10, int n11) {
        Rect rect = CoordinatorLayout.acquireTempRect();
        this.getDescendantRect(view, rect);
        try {
            boolean bl2 = rect.contains(n10, n11);
            return bl2;
        }
        finally {
            CoordinatorLayout.releaseTempRect(rect);
        }
    }

    public void offsetChildToAnchor(View view, int n10) {
        Object object;
        CoordinatorLayout coordinatorLayout = this;
        View view2 = view;
        Object object2 = object = view.getLayoutParams();
        object2 = (CoordinatorLayout$LayoutParams)((Object)object);
        object = ((CoordinatorLayout$LayoutParams)object2).mAnchorView;
        if (object != null) {
            Rect rect = CoordinatorLayout.acquireTempRect();
            Rect rect2 = CoordinatorLayout.acquireTempRect();
            Rect rect3 = CoordinatorLayout.acquireTempRect();
            object = ((CoordinatorLayout$LayoutParams)object2).mAnchorView;
            this.getDescendantRect((View)object, rect);
            boolean bl2 = false;
            this.getChildRect(view, false, rect2);
            int n11 = view.getMeasuredWidth();
            int n12 = view.getMeasuredHeight();
            object = this;
            View view3 = view;
            int n13 = n10;
            n10 = n12;
            this.getDesiredAnchoredChildRectWithoutConstraints(view, n13, rect, rect3, (CoordinatorLayout$LayoutParams)((Object)object2), n11, n12);
            int n14 = rect3.left;
            int n15 = rect2.left;
            if (n14 != n15 || (n14 = rect3.top) != (n15 = rect2.top)) {
                bl2 = true;
            }
            n14 = n10;
            coordinatorLayout.constrainChildRect((CoordinatorLayout$LayoutParams)((Object)object2), rect3, n11, n10);
            n14 = rect3.left;
            n15 = rect2.left;
            n14 -= n15;
            n15 = rect3.top;
            n13 = rect2.top;
            n15 -= n13;
            if (n14 != 0) {
                ViewCompat.offsetLeftAndRight(view2, n14);
            }
            if (n15 != 0) {
                ViewCompat.offsetTopAndBottom(view2, n15);
            }
            if (bl2 && (object = ((CoordinatorLayout$LayoutParams)((Object)object2)).getBehavior()) != null) {
                view3 = ((CoordinatorLayout$LayoutParams)object2).mAnchorView;
                ((CoordinatorLayout$Behavior)object).onDependentViewChanged(coordinatorLayout, view2, view3);
            }
            CoordinatorLayout.releaseTempRect(rect);
            CoordinatorLayout.releaseTempRect(rect2);
            CoordinatorLayout.releaseTempRect(rect3);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Object object = null;
        this.resetTouchBehaviors(false);
        boolean bl2 = this.mNeedsPreDrawListener;
        if (bl2) {
            object = this.mOnPreDrawListener;
            if (object == null) {
                this.mOnPreDrawListener = object = new CoordinatorLayout$OnPreDrawListener(this);
            }
            object = this.getViewTreeObserver();
            CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener = this.mOnPreDrawListener;
            object.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)coordinatorLayout$OnPreDrawListener);
        }
        if ((object = this.mLastInsets) == null && (bl2 = ViewCompat.getFitsSystemWindows((View)this))) {
            ViewCompat.requestApplyInsets((View)this);
        }
        this.mIsAttachedToWindow = true;
    }

    public final void onChildViewsChanged(int n10) {
        CoordinatorLayout coordinatorLayout = this;
        int n11 = n10;
        int n12 = ViewCompat.getLayoutDirection((View)this);
        List list = this.mDependencySortedChildren;
        int n13 = list.size();
        Rect rect = CoordinatorLayout.acquireTempRect();
        Rect rect2 = CoordinatorLayout.acquireTempRect();
        Rect rect3 = CoordinatorLayout.acquireTempRect();
        for (int i10 = 0; i10 < n13; ++i10) {
            int n14;
            int n15;
            View view;
            int n16;
            int n17;
            View view2 = (View)coordinatorLayout.mDependencySortedChildren.get(i10);
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view2.getLayoutParams();
            if (n11 == 0 && (n17 = view2.getVisibility()) == (n16 = 8)) continue;
            for (n17 = 0; n17 < i10; ++n17) {
                view = coordinatorLayout$LayoutParams.mAnchorDirectChild;
                View view3 = (View)coordinatorLayout.mDependencySortedChildren.get(n17);
                if (view != view3) continue;
                coordinatorLayout.offsetChildToAnchor(view2, n12);
            }
            n17 = 1;
            coordinatorLayout.getChildRect(view2, n17 != 0, rect2);
            n16 = coordinatorLayout$LayoutParams.insetEdge;
            if (n16 != 0 && (n16 = (int)(rect2.isEmpty() ? 1 : 0)) == 0) {
                int n18;
                n16 = GravityCompat.getAbsoluteGravity(coordinatorLayout$LayoutParams.insetEdge, n12);
                n15 = n16 & 0x70;
                if (n15 != (n18 = 48)) {
                    n18 = 80;
                    if (n15 == n18) {
                        n15 = rect.bottom;
                        n18 = this.getHeight();
                        int n19 = rect2.top;
                        n15 = Math.max(n15, n18 -= n19);
                        rect.bottom = n15;
                    }
                } else {
                    n15 = rect.top;
                    n18 = rect2.bottom;
                    n15 = Math.max(n15, n18);
                    rect.top = n15;
                }
                n15 = 3;
                if ((n16 &= 7) != n15) {
                    n15 = 5;
                    if (n16 == n15) {
                        n16 = rect.right;
                        n15 = this.getWidth();
                        n18 = rect2.left;
                        n16 = Math.max(n16, n15 -= n18);
                        rect.right = n16;
                    }
                } else {
                    n16 = rect.left;
                    n15 = rect2.right;
                    n16 = Math.max(n16, n15);
                    rect.left = n16;
                }
            }
            if ((n14 = coordinatorLayout$LayoutParams.dodgeInsetEdges) != 0 && (n14 = view2.getVisibility()) == 0) {
                coordinatorLayout.offsetChildByInset(view2, rect, n12);
            }
            if (n11 != (n14 = 2)) {
                coordinatorLayout.getLastChildRect(view2, rect3);
                n16 = (int)(rect3.equals((Object)rect2) ? 1 : 0);
                if (n16 != 0) continue;
                coordinatorLayout.recordLastChildRect(view2, rect2);
            }
            for (n16 = i10 + 1; n16 < n13; ++n16) {
                boolean bl2;
                view = (View)coordinatorLayout.mDependencySortedChildren.get(n16);
                CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams2 = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
                CoordinatorLayout$Behavior coordinatorLayout$Behavior = coordinatorLayout$LayoutParams2.getBehavior();
                if (coordinatorLayout$Behavior == null || !(bl2 = coordinatorLayout$Behavior.layoutDependsOn(coordinatorLayout, view, view2))) continue;
                if (n11 == 0 && (bl2 = coordinatorLayout$LayoutParams2.getChangedAfterNestedScroll())) {
                    coordinatorLayout$LayoutParams2.resetChangedAfterNestedScroll();
                    continue;
                }
                if (n11 != n14) {
                    n15 = (int)(coordinatorLayout$Behavior.onDependentViewChanged(coordinatorLayout, view, view2) ? 1 : 0);
                } else {
                    coordinatorLayout$Behavior.onDependentViewRemoved(coordinatorLayout, view, view2);
                    n15 = n17;
                }
                if (n11 != n17) continue;
                coordinatorLayout$LayoutParams2.setChangedAfterNestedScroll(n15 != 0);
            }
        }
        CoordinatorLayout.releaseTempRect(rect);
        CoordinatorLayout.releaseTempRect(rect2);
        CoordinatorLayout.releaseTempRect(rect3);
    }

    public void onDetachedFromWindow() {
        CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener;
        super.onDetachedFromWindow();
        this.resetTouchBehaviors(false);
        boolean bl2 = this.mNeedsPreDrawListener;
        if (bl2 && (coordinatorLayout$OnPreDrawListener = this.mOnPreDrawListener) != null) {
            coordinatorLayout$OnPreDrawListener = this.getViewTreeObserver();
            CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener2 = this.mOnPreDrawListener;
            coordinatorLayout$OnPreDrawListener.removeOnPreDrawListener(coordinatorLayout$OnPreDrawListener2);
        }
        if ((coordinatorLayout$OnPreDrawListener = this.mNestedScrollingTarget) != null) {
            this.onStopNestedScroll((View)coordinatorLayout$OnPreDrawListener);
        }
        this.mIsAttachedToWindow = false;
    }

    public void onDraw(Canvas canvas) {
        Object object;
        super.onDraw(canvas);
        int n10 = this.mDrawStatusBarBackground;
        if (n10 != 0 && (object = this.mStatusBarBackground) != null) {
            object = this.mLastInsets;
            if (object != null) {
                n10 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 > 0) {
                Drawable drawable2 = this.mStatusBarBackground;
                int n11 = this.getWidth();
                drawable2.setBounds(0, 0, n11, n10);
                object = this.mStatusBarBackground;
                object.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getActionMasked();
        int n11 = 1;
        if (n10 == 0) {
            this.resetTouchBehaviors(n11 != 0);
        }
        int n12 = 0;
        boolean bl2 = this.performIntercept(motionEvent, 0);
        if (n10 == n11 || n10 == (n12 = 3)) {
            this.resetTouchBehaviors(n11 != 0);
        }
        return bl2;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14 = ViewCompat.getLayoutDirection((View)this);
        List list = this.mDependencySortedChildren;
        int n15 = list.size();
        for (int i10 = 0; i10 < n15; ++i10) {
            CoordinatorLayout$Behavior coordinatorLayout$Behavior;
            int n16;
            View view = (View)this.mDependencySortedChildren.get(i10);
            int n17 = view.getVisibility();
            if (n17 == (n16 = 8) || (coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getBehavior()) != null && (n17 = (int)(coordinatorLayout$Behavior.onLayoutChild(this, view, n14) ? 1 : 0)) != 0) continue;
            this.onLayoutChild(view, n14);
        }
    }

    public void onLayoutChild(View object, int n10) {
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)object.getLayoutParams();
        boolean bl2 = coordinatorLayout$LayoutParams.checkAnchorChanged();
        if (!bl2) {
            View view = coordinatorLayout$LayoutParams.mAnchorView;
            if (view != null) {
                this.layoutChildWithAnchor((View)object, view, n10);
            } else {
                int n11 = coordinatorLayout$LayoutParams.keyline;
                if (n11 >= 0) {
                    this.layoutChildWithKeyline((View)object, n11, n10);
                } else {
                    this.layoutChild((View)object, n10);
                }
            }
            return;
        }
        object = new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        throw object;
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13;
        CoordinatorLayout coordinatorLayout = this;
        this.prepareChildren();
        this.ensurePreDrawListener();
        int n14 = this.getPaddingLeft();
        int n15 = this.getPaddingTop();
        int n16 = this.getPaddingRight();
        int n17 = this.getPaddingBottom();
        int n18 = ViewCompat.getLayoutDirection((View)this);
        int n19 = 1;
        int n20 = n18 == n19 ? n19 : 0;
        int n21 = View.MeasureSpec.getMode((int)n10);
        int n22 = View.MeasureSpec.getSize((int)n10);
        int n23 = View.MeasureSpec.getMode((int)n11);
        int n24 = View.MeasureSpec.getSize((int)n11);
        int n25 = n14 + n16;
        int n26 = n15 + n17;
        n15 = this.getSuggestedMinimumWidth();
        n17 = this.getSuggestedMinimumHeight();
        WindowInsetsCompat windowInsetsCompat = coordinatorLayout.mLastInsets;
        int n27 = windowInsetsCompat != null && (n13 = ViewCompat.getFitsSystemWindows((View)this)) != 0 ? n19 : 0;
        int n28 = coordinatorLayout.mDependencySortedChildren.size();
        int n29 = n15;
        int n30 = n17;
        n19 = 0;
        Object object = null;
        n13 = 0;
        windowInsetsCompat = null;
        while (n13 < n28) {
            int n31;
            int n32;
            int n33;
            block4: {
                int n34;
                int n35;
                Object object2;
                Object object3;
                Object object4;
                block10: {
                    int n36;
                    int n37;
                    Object object5;
                    block11: {
                        block9: {
                            WindowInsetsCompat windowInsetsCompat2;
                            block7: {
                                block8: {
                                    block5: {
                                        block6: {
                                            block3: {
                                                object5 = coordinatorLayout.mDependencySortedChildren.get(n13);
                                                object4 = object5;
                                                object4 = (View)object5;
                                                n15 = object4.getVisibility();
                                                if (n15 != (n17 = 8)) break block3;
                                                n33 = n13;
                                                n32 = n28;
                                                n31 = n14;
                                                break block4;
                                            }
                                            object5 = object4.getLayoutParams();
                                            object3 = object5;
                                            object3 = (CoordinatorLayout$LayoutParams)((Object)object5);
                                            n15 = ((CoordinatorLayout$LayoutParams)object3).keyline;
                                            if (n15 < 0 || n21 == 0) break block5;
                                            n15 = coordinatorLayout.getKeyline(n15);
                                            n12 = GravityCompat.getAbsoluteGravity(CoordinatorLayout.resolveKeylineGravity(((CoordinatorLayout$LayoutParams)object3).gravity), n18) & 7;
                                            n33 = n19;
                                            n19 = 3;
                                            if ((n12 != n19 || n20 != 0) && (n12 != (n19 = 5) || n20 == 0)) break block6;
                                            n19 = n22 - n16 - n15;
                                            n15 = 0;
                                            object5 = null;
                                            n19 = Math.max(0, n19);
                                            n12 = 0;
                                            windowInsetsCompat2 = null;
                                            n37 = n19;
                                            break block7;
                                        }
                                        if ((n12 != n19 || n20 != 0) && (n12 != (n19 = 3) || n20 == 0)) break block8;
                                        n15 -= n14;
                                        n12 = 0;
                                        windowInsetsCompat2 = null;
                                        n37 = n15 = Math.max(0, n15);
                                        break block7;
                                    }
                                    n33 = n19;
                                }
                                n12 = 0;
                                windowInsetsCompat2 = null;
                                n37 = 0;
                            }
                            if (n27 != 0 && (n15 = (int)(ViewCompat.getFitsSystemWindows(object4) ? 1 : 0)) == 0) {
                                object5 = coordinatorLayout.mLastInsets;
                                n15 = ((WindowInsetsCompat)object5).getSystemWindowInsetLeft();
                                n19 = coordinatorLayout.mLastInsets.getSystemWindowInsetRight();
                                n15 += n19;
                                object = coordinatorLayout.mLastInsets;
                                n19 = ((WindowInsetsCompat)object).getSystemWindowInsetTop();
                                windowInsetsCompat2 = coordinatorLayout.mLastInsets;
                                n12 = windowInsetsCompat2.getSystemWindowInsetBottom();
                                n19 += n12;
                                n15 = View.MeasureSpec.makeMeasureSpec((int)(n22 - n15), (int)n21);
                                n19 = View.MeasureSpec.makeMeasureSpec((int)(n24 - n19), (int)n23);
                                n12 = n15;
                                n36 = n19;
                            } else {
                                n12 = n10;
                                n36 = n11;
                            }
                            object5 = ((CoordinatorLayout$LayoutParams)((Object)object3)).getBehavior();
                            if (object5 == null) break block9;
                            object = object3;
                            object3 = this;
                            object2 = object;
                            n35 = n33;
                            object = object4;
                            n33 = n13;
                            n13 = n12;
                            n34 = n30;
                            n30 = n37;
                            n31 = n14;
                            n14 = n29;
                            n29 = n36;
                            n32 = n28;
                            n28 = 0;
                            n15 = (int)(((CoordinatorLayout$Behavior)object5).onMeasureChild(this, (View)object4, n12, n37, n36, 0) ? 1 : 0);
                            if (n15 != 0) break block10;
                            break block11;
                        }
                        object2 = object3;
                        n34 = n30;
                        n32 = n28;
                        n31 = n14;
                        n35 = n33;
                        n33 = n13;
                        n14 = n29;
                    }
                    n29 = 0;
                    object5 = this;
                    object3 = object4;
                    n19 = n12;
                    n13 = n37;
                    n30 = n36;
                    this.onMeasureChild((View)object4, n12, n37, n36, 0);
                }
                n15 = object4.getMeasuredWidth();
                n15 = n25 + n15;
                object3 = object2;
                n19 = ((ViewGroup.MarginLayoutParams)object2).leftMargin;
                n15 += n19;
                n19 = ((ViewGroup.MarginLayoutParams)object2).rightMargin;
                n15 += n19;
                n15 = Math.max(n14, n15);
                n19 = object4.getMeasuredHeight();
                n19 = n26 + n19;
                n13 = ((ViewGroup.MarginLayoutParams)object2).topMargin;
                n19 += n13;
                n17 = ((ViewGroup.MarginLayoutParams)object2).bottomMargin;
                n19 += n17;
                n17 = n34;
                n17 = Math.max(n34, n19);
                n19 = object4.getMeasuredState();
                n12 = n35;
                n19 = View.combineMeasuredStates((int)n35, (int)n19);
                n29 = n15;
                n30 = n17;
            }
            n13 = n33 + 1;
            n14 = n31;
            n28 = n32;
        }
        n12 = n19;
        n17 = n30;
        n14 = n29;
        n15 = 0xFF000000 & n19;
        n19 = n10;
        n15 = View.resolveSizeAndState((int)n29, (int)n10, (int)n15);
        n19 = n12 << 16;
        n13 = n11;
        n17 = View.resolveSizeAndState((int)n30, (int)n11, (int)n19);
        coordinatorLayout.setMeasuredDimension(n15, n17);
    }

    public void onMeasureChild(View view, int n10, int n11, int n12, int n13) {
        this.measureChildWithMargins(view, n10, n11, n12, n13);
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        int n10 = this.getChildCount();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            int n12;
            View view2 = this.getChildAt(i10);
            int n13 = view2.getVisibility();
            if (n13 == (n12 = 8) || (n12 = (int)(((CoordinatorLayout$LayoutParams)((Object)(object = (CoordinatorLayout$LayoutParams)view2.getLayoutParams()))).isNestedScrollAccepted(0) ? 1 : 0)) == 0 || (object = ((CoordinatorLayout$LayoutParams)((Object)object)).getBehavior()) == null) continue;
            n13 = (int)(((CoordinatorLayout$Behavior)object).onNestedFling(this, view2, view, f10, f11, bl2) ? 1 : 0);
            n11 |= n13;
        }
        if (n11 != 0) {
            int n14 = 1;
            this.onChildViewsChanged(n14);
        }
        return n11 != 0;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        int n10 = this.getChildCount();
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object;
            int n12;
            View view2 = this.getChildAt(i10);
            int n13 = view2.getVisibility();
            if (n13 == (n12 = 8) || (n12 = (int)(((CoordinatorLayout$LayoutParams)((Object)(object = (CoordinatorLayout$LayoutParams)view2.getLayoutParams()))).isNestedScrollAccepted(0) ? 1 : 0)) == 0 || (object = ((CoordinatorLayout$LayoutParams)((Object)object)).getBehavior()) == null) continue;
            n13 = (int)(((CoordinatorLayout$Behavior)object).onNestedPreFling(this, view2, view, f10, f11) ? 1 : 0);
            n11 |= n13;
        }
        return n11 != 0;
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray) {
        this.onNestedPreScroll(view, n10, n11, nArray, 0);
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray, int n12) {
        Object object;
        int n13;
        CoordinatorLayout coordinatorLayout = this;
        int n14 = this.getChildCount();
        boolean n15 = false;
        Object object2 = null;
        int n16 = 0;
        Object object3 = 0;
        Object object4 = 0;
        while (true) {
            Object object5;
            int n17;
            n13 = 1;
            if (n16 >= n14) break;
            View view2 = coordinatorLayout.getChildAt(n16);
            int n18 = view2.getVisibility();
            if (n18 != (n17 = 8) && (n17 = (int)((object5 = (CoordinatorLayout$LayoutParams)view2.getLayoutParams()).isNestedScrollAccepted(n12) ? 1 : 0)) != 0 && (object5 = object5.getBehavior()) != null) {
                int[] nArray2 = coordinatorLayout.mTempIntPair;
                nArray2[n13] = 0;
                nArray2[0] = 0;
                object2 = object5;
                object5 = this;
                ((CoordinatorLayout$Behavior)object2).onNestedPreScroll(this, view2, view, n10, n11, nArray2, n12);
                object2 = coordinatorLayout.mTempIntPair;
                if (n10 > 0) {
                    Object object = object2[0];
                    object = Math.max(object3, (int)object);
                } else {
                    Object object = object2[0];
                    object = Math.min(object3, (int)object);
                }
                object3 = object;
                object2 = coordinatorLayout.mTempIntPair;
                if (n11 > 0) {
                    Object object = object2[n13];
                    object = Math.max(object4, (int)object);
                } else {
                    Object object = object2[n13];
                    object = Math.min(object4, (int)object);
                }
                object4 = object;
                object = n13;
            }
            ++n16;
        }
        nArray[0] = object3;
        nArray[n13] = object4;
        if (object != false) {
            coordinatorLayout.onChildViewsChanged(n13);
        }
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13) {
        this.onNestedScroll(view, n10, n11, n12, n13, 0);
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14) {
        int n15;
        int n16 = this.getChildCount();
        int n17 = 0;
        Object object = null;
        int n18 = 0;
        while (true) {
            Object object2;
            int n19;
            n15 = 1;
            if (n18 >= n16) break;
            View view2 = this.getChildAt(n18);
            int n20 = view2.getVisibility();
            if (n20 != (n19 = 8) && (n19 = (int)((object2 = (CoordinatorLayout$LayoutParams)view2.getLayoutParams()).isNestedScrollAccepted(n14) ? 1 : 0)) != 0 && (object2 = object2.getBehavior()) != null) {
                object = object2;
                object2 = this;
                ((CoordinatorLayout$Behavior)object).onNestedScroll(this, view2, view, n10, n11, n12, n13, n14);
                n17 = n15;
            }
            ++n18;
        }
        if (n17 != 0) {
            this.onChildViewsChanged(n15);
        }
    }

    public void onNestedScrollAccepted(View view, View view2, int n10) {
        this.onNestedScrollAccepted(view, view2, n10, 0);
    }

    public void onNestedScrollAccepted(View view, View view2, int n10, int n11) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        nestedScrollingParentHelper.onNestedScrollAccepted(view, view2, n10, n11);
        this.mNestedScrollingTarget = view2;
        int n12 = this.getChildCount();
        for (int i10 = 0; i10 < n12; ++i10) {
            View view3 = this.getChildAt(i10);
            Object object = (CoordinatorLayout$LayoutParams)view3.getLayoutParams();
            boolean bl2 = object.isNestedScrollAccepted(n11);
            if (!bl2 || (object = object.getBehavior()) == null) continue;
            ((CoordinatorLayout$Behavior)object).onNestedScrollAccepted(this, view3, view, view2, n10, n11);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int n10 = parcelable instanceof CoordinatorLayout$SavedState;
        if (n10 == 0) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (CoordinatorLayout$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable2);
        parcelable = parcelable.behaviorStates;
        parcelable2 = null;
        int n11 = this.getChildCount();
        for (n10 = 0; n10 < n11; ++n10) {
            Parcelable parcelable3;
            View view = this.getChildAt(n10);
            int n12 = view.getId();
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = this.getResolvedLayoutParams(view).getBehavior();
            int n13 = -1;
            if (n12 == n13 || coordinatorLayout$Behavior == null || (parcelable3 = (Parcelable)parcelable.get(n12)) == null) continue;
            coordinatorLayout$Behavior.onRestoreInstanceState(this, view, parcelable3);
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        CoordinatorLayout$SavedState coordinatorLayout$SavedState = new CoordinatorLayout$SavedState(parcelable);
        parcelable = new SparseArray();
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            int n11 = view.getId();
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getBehavior();
            int n12 = -1;
            if (n11 == n12 || coordinatorLayout$Behavior == null || (view = coordinatorLayout$Behavior.onSaveInstanceState(this, view)) == null) continue;
            parcelable.append(n11, (Object)view);
        }
        coordinatorLayout$SavedState.behaviorStates = parcelable;
        return coordinatorLayout$SavedState;
    }

    public boolean onStartNestedScroll(View view, View view2, int n10) {
        return this.onStartNestedScroll(view, view2, n10, 0);
    }

    public boolean onStartNestedScroll(View view, View view2, int n10, int n11) {
        int n12 = n11;
        int n13 = this.getChildCount();
        int n14 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            Object object;
            int n15;
            View view3 = this.getChildAt(i10);
            int n16 = view3.getVisibility();
            if (n16 == (n15 = 8)) continue;
            Object object2 = object = view3.getLayoutParams();
            object2 = (CoordinatorLayout$LayoutParams)((Object)object);
            if ((object = object2.getBehavior()) != null) {
                n16 = (int)(((CoordinatorLayout$Behavior)object).onStartNestedScroll(this, view3, view, view2, n10, n11) ? 1 : 0);
                n14 |= n16;
                object2.setNestedScrollAccepted(n12, n16 != 0);
                continue;
            }
            object2.setNestedScrollAccepted(n12, false);
        }
        return n14 != 0;
    }

    public void onStopNestedScroll(View view) {
        this.onStopNestedScroll(view, 0);
    }

    public void onStopNestedScroll(View view, int n10) {
        NestedScrollingParentHelper nestedScrollingParentHelper = this.mNestedScrollingParentHelper;
        nestedScrollingParentHelper.onStopNestedScroll(view, n10);
        int n11 = this.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view2 = this.getChildAt(i10);
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view2.getLayoutParams();
            boolean bl2 = coordinatorLayout$LayoutParams.isNestedScrollAccepted(n10);
            if (!bl2) continue;
            CoordinatorLayout$Behavior coordinatorLayout$Behavior = coordinatorLayout$LayoutParams.getBehavior();
            if (coordinatorLayout$Behavior != null) {
                coordinatorLayout$Behavior.onStopNestedScroll(this, view2, view, n10);
            }
            coordinatorLayout$LayoutParams.resetNestedScroll(n10);
            coordinatorLayout$LayoutParams.resetChangedAfterNestedScroll();
        }
        this.mNestedScrollingTarget = null;
    }

    /*
     * Unable to fully structure code
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block8: {
            block7: {
                var2_2 = this;
                var3_3 = var1_1;
                var4_4 = var1_1.getActionMasked();
                var5_5 = this.mBehaviorTouchView;
                var6_6 = 1;
                if (var5_5 != null) break block7;
                var7_7 = this.performIntercept(var1_1, var6_6);
                if (!var7_7) ** GOTO lbl-1000
                break block8;
            }
            var7_7 = false;
            var5_5 = null;
        }
        var8_8 = ((CoordinatorLayout$LayoutParams)var2_2.mBehaviorTouchView.getLayoutParams()).getBehavior();
        if (var8_8 != null) {
            var9_9 = var2_2.mBehaviorTouchView;
            var10_10 = var8_8.onTouchEvent(var2_2, var9_9, var3_3);
        } else lbl-1000:
        // 2 sources

        {
            var10_10 = false;
            var8_8 = null;
        }
        var9_9 = var2_2.mBehaviorTouchView;
        var11_11 = null;
        if (var9_9 == null) {
            var12_12 = super.onTouchEvent(var1_1);
            var10_10 |= var12_12;
        } else if (var7_7) {
            var13_13 = SystemClock.uptimeMillis();
            var15_14 = 3;
            var11_11 = MotionEvent.obtain((long)var13_13, (long)var13_13, (int)var15_14, (float)0.0f, (float)0.0f, (int)0);
            super.onTouchEvent(var11_11);
        }
        if (var11_11 != null) {
            var11_11.recycle();
        }
        if (var4_4 == var6_6 || var4_4 == (var12_12 = 3)) {
            var2_2.resetTouchBehaviors(false);
        }
        return var10_10;
    }

    public void recordLastChildRect(View view, Rect rect) {
        ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).setLastChildRect(rect);
    }

    public void removePreDrawListener() {
        CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener;
        boolean bl2 = this.mIsAttachedToWindow;
        if (bl2 && (coordinatorLayout$OnPreDrawListener = this.mOnPreDrawListener) != null) {
            coordinatorLayout$OnPreDrawListener = this.getViewTreeObserver();
            CoordinatorLayout$OnPreDrawListener coordinatorLayout$OnPreDrawListener2 = this.mOnPreDrawListener;
            coordinatorLayout$OnPreDrawListener.removeOnPreDrawListener(coordinatorLayout$OnPreDrawListener2);
        }
        this.mNeedsPreDrawListener = false;
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean bl2) {
        boolean bl3;
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view.getLayoutParams()).getBehavior();
        if (coordinatorLayout$Behavior != null && (bl3 = coordinatorLayout$Behavior.onRequestChildRectangleOnScreen(this, view, rect, bl2))) {
            return true;
        }
        return super.requestChildRectangleOnScreen(view, rect, bl2);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        super.requestDisallowInterceptTouchEvent(bl2);
        if (bl2 && !(bl2 = this.mDisallowInterceptReset)) {
            this.resetTouchBehaviors(false);
            this.mDisallowInterceptReset = bl2 = true;
        }
    }

    public void setFitsSystemWindows(boolean bl2) {
        super.setFitsSystemWindows(bl2);
        this.setupForInsets();
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    /*
     * WARNING - void declaration
     */
    public void setStatusBarBackground(Drawable drawable2) {
        Object object = this.mStatusBarBackground;
        if (object != drawable2) {
            Drawable drawable3 = null;
            if (object != null) {
                object.setCallback(null);
            }
            if (drawable2 != null) {
                drawable3 = drawable2.mutate();
            }
            this.mStatusBarBackground = drawable3;
            if (drawable3 != null) {
                void var5_9;
                boolean bl2 = drawable3.isStateful();
                if (bl2) {
                    drawable2 = this.mStatusBarBackground;
                    object = this.getDrawableState();
                    drawable2.setState((int[])object);
                }
                drawable2 = this.mStatusBarBackground;
                int bl3 = ViewCompat.getLayoutDirection((View)this);
                DrawableCompat.setLayoutDirection(drawable2, bl3);
                drawable2 = this.mStatusBarBackground;
                int n10 = this.getVisibility();
                drawable3 = null;
                if (n10 == 0) {
                    boolean bl4 = true;
                } else {
                    boolean bl5 = false;
                    object = null;
                }
                drawable2.setVisible((boolean)var5_9, false);
                drawable2 = this.mStatusBarBackground;
                drawable2.setCallback((Drawable.Callback)this);
            }
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public void setStatusBarBackgroundColor(int n10) {
        ColorDrawable colorDrawable = new ColorDrawable(n10);
        this.setStatusBarBackground((Drawable)colorDrawable);
    }

    public void setStatusBarBackgroundResource(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = ContextCompat.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setStatusBarBackground(drawable2);
    }

    public void setVisibility(int n10) {
        int n11;
        super.setVisibility(n10);
        n10 = n10 == 0 ? 1 : 0;
        Drawable drawable2 = this.mStatusBarBackground;
        if (drawable2 != null && (n11 = drawable2.isVisible()) != n10) {
            drawable2 = this.mStatusBarBackground;
            drawable2.setVisible(n10 != 0, false);
        }
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = this.mLastInsets;
        boolean bl2 = ObjectsCompat.equals(windowInsetsCompat2, windowInsetsCompat);
        if (!bl2) {
            Drawable drawable2;
            int n10;
            this.mLastInsets = windowInsetsCompat;
            bl2 = true;
            if (windowInsetsCompat != null && (n10 = windowInsetsCompat.getSystemWindowInsetTop()) > 0) {
                n10 = (int)(bl2 ? 1 : 0);
            } else {
                n10 = 0;
                drawable2 = null;
            }
            this.mDrawStatusBarBackground = n10;
            if (n10 != 0 || (drawable2 = this.getBackground()) != null) {
                bl2 = false;
                windowInsetsCompat2 = null;
            }
            this.setWillNotDraw(bl2);
            windowInsetsCompat = this.dispatchApplyWindowInsetsToBehaviors(windowInsetsCompat);
            this.requestLayout();
        }
        return windowInsetsCompat;
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!bl3 && drawable2 != (drawable3 = this.mStatusBarBackground)) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

