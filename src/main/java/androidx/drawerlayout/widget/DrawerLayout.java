/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnApplyWindowInsetsListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.WindowInsets
 */
package androidx.drawerlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.Openable;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.drawerlayout.R$attr;
import androidx.drawerlayout.R$dimen;
import androidx.drawerlayout.R$styleable;
import androidx.drawerlayout.widget.DrawerLayout$1;
import androidx.drawerlayout.widget.DrawerLayout$2;
import androidx.drawerlayout.widget.DrawerLayout$AccessibilityDelegate;
import androidx.drawerlayout.widget.DrawerLayout$ChildAccessibilityDelegate;
import androidx.drawerlayout.widget.DrawerLayout$DrawerListener;
import androidx.drawerlayout.widget.DrawerLayout$LayoutParams;
import androidx.drawerlayout.widget.DrawerLayout$SavedState;
import androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
extends ViewGroup
implements Openable {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.drawerlayout.widget.DrawerLayout";
    private static final boolean ALLOW_EDGE_LOCK = false;
    public static final boolean CAN_HIDE_DESCENDANTS = false;
    private static final boolean CHILDREN_DISALLOW_INTERCEPT = true;
    private static final int DEFAULT_SCRIM_COLOR = -1728053248;
    public static final int[] LAYOUT_ATTRS;
    public static final int LOCK_MODE_LOCKED_CLOSED = 1;
    public static final int LOCK_MODE_LOCKED_OPEN = 2;
    public static final int LOCK_MODE_UNDEFINED = 3;
    public static final int LOCK_MODE_UNLOCKED = 0;
    private static final int MIN_DRAWER_MARGIN = 64;
    private static final int MIN_FLING_VELOCITY = 400;
    private static final int PEEK_DELAY = 160;
    private static final boolean SET_DRAWER_SHADOW_FROM_ELEVATION = false;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "DrawerLayout";
    private static final int[] THEME_ATTRS;
    private static final float TOUCH_SLOP_SENSITIVITY = 1.0f;
    private static boolean sEdgeSizeUsingSystemGestureInsets;
    private final AccessibilityViewCommand mActionDismiss;
    private final DrawerLayout$ChildAccessibilityDelegate mChildAccessibilityDelegate;
    private Rect mChildHitRect;
    private Matrix mChildInvertedMatrix;
    private boolean mChildrenCanceledTouch;
    private boolean mDrawStatusBarBackground;
    private float mDrawerElevation;
    private int mDrawerState;
    private boolean mFirstLayout;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private Object mLastInsets;
    private final DrawerLayout$ViewDragCallback mLeftCallback;
    private final ViewDragHelper mLeftDragger;
    private DrawerLayout$DrawerListener mListener;
    private List mListeners;
    private int mLockModeEnd;
    private int mLockModeLeft;
    private int mLockModeRight;
    private int mLockModeStart;
    private int mMinDrawerMargin;
    private final ArrayList mNonDrawerViews;
    private final DrawerLayout$ViewDragCallback mRightCallback;
    private final ViewDragHelper mRightDragger;
    private int mScrimColor;
    private float mScrimOpacity;
    private Paint mScrimPaint;
    private Drawable mShadowEnd;
    private Drawable mShadowLeft;
    private Drawable mShadowLeftResolved;
    private Drawable mShadowRight;
    private Drawable mShadowRightResolved;
    private Drawable mShadowStart;
    private Drawable mStatusBarBackground;
    private CharSequence mTitleLeft;
    private CharSequence mTitleRight;

    static {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 16843828;
        THEME_ATTRS = nArray;
        nArray = new int[n10];
        nArray[0] = 16842931;
        LAYOUT_ATTRS = nArray;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        n12 = n11 >= n12 ? n10 : 0;
        CAN_HIDE_DESCENDANTS = n12;
        n12 = 21;
        n12 = n11 >= n12 ? n10 : 0;
        SET_DRAWER_SHADOW_FROM_ELEVATION = n12;
        n12 = 29;
        if (n11 < n12) {
            n10 = 0;
        }
        sEdgeSizeUsingSystemGestureInsets = n10;
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.drawerLayoutStyle;
        this(context, attributeSet, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public DrawerLayout(Context object, AttributeSet attributeSet, int n10) {
        super(object, (AttributeSet)resources, n13);
        ViewDragHelper viewDragHelper;
        int n11;
        int n12;
        Paint paint;
        DrawerLayout$ChildAccessibilityDelegate drawerLayout$ChildAccessibilityDelegate;
        int n13;
        Resources resources;
        this.mChildAccessibilityDelegate = drawerLayout$ChildAccessibilityDelegate = new DrawerLayout$ChildAccessibilityDelegate();
        this.mScrimColor = -1728053248;
        this.mScrimPaint = paint = new Paint();
        int n14 = 1;
        this.mFirstLayout = n14;
        this.mLockModeLeft = n12 = 3;
        this.mLockModeRight = n12;
        this.mLockModeStart = n12;
        this.mLockModeEnd = n12;
        Drawable drawable2 = null;
        this.mShadowStart = null;
        this.mShadowEnd = null;
        this.mShadowLeft = null;
        this.mShadowRight = null;
        DrawerLayout$1 drawerLayout$1 = new DrawerLayout$1(this);
        this.mActionDismiss = drawerLayout$1;
        int n15 = 262144;
        this.setDescendantFocusability(n15);
        drawerLayout$1 = this.getResources().getDisplayMetrics();
        float f10 = ((DisplayMetrics)drawerLayout$1).density;
        this.mMinDrawerMargin = n11 = (int)(64.0f * f10 + 0.5f);
        n11 = 1137180672;
        float f11 = 400.0f;
        Object object2 = new DrawerLayout$ViewDragCallback(this, n12);
        this.mLeftCallback = object2;
        Object object3 = new DrawerLayout$ViewDragCallback(this, 5);
        this.mRightCallback = object3;
        float f12 = 1.0f;
        this.mLeftDragger = viewDragHelper = ViewDragHelper.create(this, f12, (ViewDragHelper$Callback)object2);
        viewDragHelper.setEdgeTrackingEnabled(n14);
        viewDragHelper.setMinVelocity(f10 *= f11);
        ((DrawerLayout$ViewDragCallback)object2).setDragger(viewDragHelper);
        this.mRightDragger = object2 = ViewDragHelper.create(this, f12, (ViewDragHelper$Callback)object3);
        int n16 = 2;
        f12 = 2.8E-45f;
        ((ViewDragHelper)object2).setEdgeTrackingEnabled(n16);
        ((ViewDragHelper)object2).setMinVelocity(f10);
        ((DrawerLayout$ViewDragCallback)object3).setDragger((ViewDragHelper)object2);
        this.setFocusableInTouchMode(n14 != 0);
        ViewCompat.setImportantForAccessibility((View)this, n14);
        DrawerLayout$AccessibilityDelegate drawerLayout$AccessibilityDelegate = new DrawerLayout$AccessibilityDelegate(this);
        ViewCompat.setAccessibilityDelegate((View)this, drawerLayout$AccessibilityDelegate);
        n14 = 0;
        Object var4_11 = null;
        this.setMotionEventSplittingEnabled(false);
        n12 = (int)(ViewCompat.getFitsSystemWindows((View)this) ? 1 : 0);
        if (n12 != 0) {
            n12 = Build.VERSION.SDK_INT;
            n15 = 21;
            f10 = 2.9E-44f;
            if (n12 >= n15) {
                object3 = new DrawerLayout$2(this);
                this.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener)object3);
                n12 = 1280;
                this.setSystemUiVisibility(n12);
                object3 = THEME_ATTRS;
                object3 = object.obtainStyledAttributes((int[])object3);
                try {
                    this.mStatusBarBackground = drawable2 = object3.getDrawable(0);
                }
                finally {
                    object3.recycle();
                }
            } else {
                this.mStatusBarBackground = null;
            }
        }
        object3 = R$styleable.DrawerLayout;
        TypedArray typedArray = object.obtainStyledAttributes((AttributeSet)resources, (int[])object3, n13, 0);
        try {
            ArrayList arrayList;
            int n17 = R$styleable.DrawerLayout_elevation;
            n13 = typedArray.hasValue(n17);
            if (n13 != 0) {
                float f13;
                n13 = 0;
                this.mDrawerElevation = f13 = typedArray.getDimension(n17, 0.0f);
            } else {
                float f14;
                resources = this.getResources();
                n13 = R$dimen.def_drawer_elevation;
                this.mDrawerElevation = f14 = resources.getDimension(n13);
            }
            this.mNonDrawerViews = arrayList = new ArrayList();
            return;
        }
        finally {
            typedArray.recycle();
        }
    }

    private boolean dispatchTransformedGenericPointerEvent(MotionEvent motionEvent, View view) {
        boolean bl2;
        Matrix matrix = view.getMatrix();
        int n10 = matrix.isIdentity();
        if (n10 == 0) {
            motionEvent = this.getTransformedMotionEvent(motionEvent, view);
            bl2 = view.dispatchGenericMotionEvent(motionEvent);
            motionEvent.recycle();
        } else {
            n10 = this.getScrollX();
            int n11 = view.getLeft();
            float f10 = n10 -= n11;
            n11 = this.getScrollY();
            int n12 = view.getTop();
            float f11 = n11 -= n12;
            motionEvent.offsetLocation(f10, f11);
            bl2 = view.dispatchGenericMotionEvent(motionEvent);
            f10 = -f10;
            f11 = -f11;
            motionEvent.offsetLocation(f10, f11);
        }
        return bl2;
    }

    private MotionEvent getTransformedMotionEvent(MotionEvent motionEvent, View view) {
        int n10 = this.getScrollX();
        int n11 = view.getLeft();
        float f10 = n10 - n11;
        n11 = this.getScrollY();
        int n12 = view.getTop();
        float f11 = n11 -= n12;
        motionEvent = MotionEvent.obtain((MotionEvent)motionEvent);
        motionEvent.offsetLocation(f10, f11);
        view = view.getMatrix();
        n10 = (int)(view.isIdentity() ? 1 : 0);
        if (n10 == 0) {
            Matrix matrix = this.mChildInvertedMatrix;
            if (matrix == null) {
                this.mChildInvertedMatrix = matrix = new Matrix();
            }
            matrix = this.mChildInvertedMatrix;
            view.invert(matrix);
            view = this.mChildInvertedMatrix;
            motionEvent.transform((Matrix)view);
        }
        return motionEvent;
    }

    public static String gravityToString(int n10) {
        int n11 = n10 & 3;
        int n12 = 3;
        if (n11 == n12) {
            return "LEFT";
        }
        n11 = n10 & 5;
        n12 = 5;
        if (n11 == n12) {
            return "RIGHT";
        }
        return Integer.toHexString(n10);
    }

    private static boolean hasOpaqueBackground(View view) {
        int n10;
        int n11;
        view = view.getBackground();
        boolean bl2 = false;
        if (view != null && (n11 = view.getOpacity()) == (n10 = -1)) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean hasPeekingDrawer() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)this.getChildAt(i10).getLayoutParams();
            boolean bl2 = drawerLayout$LayoutParams.isPeeking;
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    private boolean hasVisibleDrawer() {
        boolean bl2;
        View view = this.findVisibleDrawer();
        if (view != null) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public static boolean includeChildForAccessibility(View view) {
        int n10;
        int n11;
        int n12 = ViewCompat.getImportantForAccessibility(view);
        if (n12 != (n11 = 4) && (n10 = ViewCompat.getImportantForAccessibility(view)) != (n12 = 2)) {
            n10 = 1;
        } else {
            n10 = 0;
            view = null;
        }
        return n10 != 0;
    }

    private boolean isInBoundsOfChild(float f10, float f11, View view) {
        Rect rect = this.mChildHitRect;
        if (rect == null) {
            this.mChildHitRect = rect = new Rect();
        }
        rect = this.mChildHitRect;
        view.getHitRect(rect);
        view = this.mChildHitRect;
        int n10 = (int)f10;
        int n11 = (int)f11;
        return view.contains(n10, n11);
    }

    private void mirror(Drawable drawable2, int n10) {
        boolean bl2;
        if (drawable2 != null && (bl2 = DrawableCompat.isAutoMirrored(drawable2))) {
            DrawableCompat.setLayoutDirection(drawable2, n10);
        }
    }

    private Drawable resolveLeftShadow() {
        int n10 = ViewCompat.getLayoutDirection((View)this);
        if (n10 == 0) {
            Drawable drawable2 = this.mShadowStart;
            if (drawable2 != null) {
                this.mirror(drawable2, n10);
                return this.mShadowStart;
            }
        } else {
            Drawable drawable3 = this.mShadowEnd;
            if (drawable3 != null) {
                this.mirror(drawable3, n10);
                return this.mShadowEnd;
            }
        }
        return this.mShadowLeft;
    }

    private Drawable resolveRightShadow() {
        int n10 = ViewCompat.getLayoutDirection((View)this);
        if (n10 == 0) {
            Drawable drawable2 = this.mShadowEnd;
            if (drawable2 != null) {
                this.mirror(drawable2, n10);
                return this.mShadowEnd;
            }
        } else {
            Drawable drawable3 = this.mShadowStart;
            if (drawable3 != null) {
                this.mirror(drawable3, n10);
                return this.mShadowStart;
            }
        }
        return this.mShadowRight;
    }

    private void resolveShadowDrawables() {
        Drawable drawable2;
        boolean bl2 = SET_DRAWER_SHADOW_FROM_ELEVATION;
        if (bl2) {
            return;
        }
        this.mShadowLeftResolved = drawable2 = this.resolveLeftShadow();
        this.mShadowRightResolved = drawable2 = this.resolveRightShadow();
    }

    private void updateChildAccessibilityAction(View view) {
        int n10;
        AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat = AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_DISMISS;
        int n11 = accessibilityNodeInfoCompat$AccessibilityActionCompat.getId();
        ViewCompat.removeAccessibilityAction(view, n11);
        n11 = (int)(this.isDrawerOpen(view) ? 1 : 0);
        if (n11 != 0 && (n11 = this.getDrawerLockMode(view)) != (n10 = 2)) {
            n11 = 0;
            AccessibilityViewCommand accessibilityViewCommand = this.mActionDismiss;
            ViewCompat.replaceAccessibilityAction(view, accessibilityNodeInfoCompat$AccessibilityActionCompat, null, accessibilityViewCommand);
        }
    }

    private void updateChildrenImportantForAccessibility(View view, boolean bl2) {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            View view2 = this.getChildAt(i10);
            if (!bl2 && (n11 = this.isDrawerView(view2)) == 0 || bl2 && view2 == view) {
                n11 = 1;
                ViewCompat.setImportantForAccessibility(view2, n11);
                continue;
            }
            n11 = 4;
            ViewCompat.setImportantForAccessibility(view2, n11);
        }
    }

    public void addDrawerListener(DrawerLayout$DrawerListener drawerLayout$DrawerListener) {
        if (drawerLayout$DrawerListener == null) {
            return;
        }
        ArrayList arrayList = this.mListeners;
        if (arrayList == null) {
            this.mListeners = arrayList = new ArrayList();
        }
        this.mListeners.add(drawerLayout$DrawerListener);
    }

    public void addFocusables(ArrayList arrayList, int n10, int n11) {
        int n12;
        int n13 = this.getDescendantFocusability();
        if (n13 == (n12 = 393216)) {
            return;
        }
        n13 = this.getChildCount();
        n12 = 0;
        View view = null;
        int n14 = 0;
        for (int i10 = 0; i10 < n13; ++i10) {
            View view2 = this.getChildAt(i10);
            boolean bl2 = this.isDrawerView(view2);
            if (bl2) {
                bl2 = this.isDrawerOpen(view2);
                if (!bl2) continue;
                view2.addFocusables(arrayList, n10, n11);
                n14 = 1;
                continue;
            }
            ArrayList arrayList2 = this.mNonDrawerViews;
            arrayList2.add(view2);
        }
        if (n14 == 0) {
            ArrayList arrayList3 = this.mNonDrawerViews;
            n13 = arrayList3.size();
            while (n12 < n13) {
                view = (View)this.mNonDrawerViews.get(n12);
                n14 = view.getVisibility();
                if (n14 == 0) {
                    view.addFocusables(arrayList, n10, n11);
                }
                ++n12;
            }
        }
        this.mNonDrawerViews.clear();
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, n10, layoutParams);
        Object object = this.findOpenDrawer();
        if (object == null && (n10 = (int)(this.isDrawerView(view) ? 1 : 0)) == 0) {
            n10 = 1;
            ViewCompat.setImportantForAccessibility(view, n10);
        } else {
            n10 = 4;
            ViewCompat.setImportantForAccessibility(view, n10);
        }
        n10 = (int)(CAN_HIDE_DESCENDANTS ? 1 : 0);
        if (n10 == 0) {
            object = this.mChildAccessibilityDelegate;
            ViewCompat.setAccessibilityDelegate(view, (AccessibilityDelegateCompat)object);
        }
    }

    public void cancelChildViewTouch() {
        boolean bl2 = this.mChildrenCanceledTouch;
        if (!bl2) {
            long l10 = SystemClock.uptimeMillis();
            int n10 = 3;
            MotionEvent motionEvent = MotionEvent.obtain((long)l10, (long)l10, (int)n10, (float)0.0f, (float)0.0f, (int)0);
            int n11 = this.getChildCount();
            for (int i10 = 0; i10 < n11; ++i10) {
                View view = this.getChildAt(i10);
                view.dispatchTouchEvent(motionEvent);
            }
            motionEvent.recycle();
            this.mChildrenCanceledTouch = bl2 = true;
        }
    }

    public boolean checkDrawerViewAbsoluteGravity(View view, int n10) {
        int n11 = this.getDrawerViewAbsoluteGravity(view) & n10;
        if (n11 == n10) {
            n11 = 1;
        } else {
            n11 = 0;
            view = null;
        }
        return n11 != 0;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2;
        boolean bl3 = layoutParams instanceof DrawerLayout$LayoutParams;
        if (bl3 && (bl2 = super.checkLayoutParams(layoutParams))) {
            bl2 = true;
        } else {
            bl2 = false;
            layoutParams = null;
        }
        return bl2;
    }

    public void close() {
        this.closeDrawer(0x800003);
    }

    public void closeDrawer(int n10) {
        this.closeDrawer(n10, true);
    }

    public void closeDrawer(int n10, boolean bl2) {
        Object object = this.findDrawerWithGravity(n10);
        if (object != null) {
            this.closeDrawer((View)object, bl2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No drawer view found with gravity ");
        String string2 = DrawerLayout.gravityToString(n10);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void closeDrawer(View view) {
        this.closeDrawer(view, true);
    }

    public void closeDrawer(View object, boolean bl2) {
        int n10 = this.isDrawerView((View)object);
        if (n10 != 0) {
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)object.getLayoutParams();
            int n11 = this.mFirstLayout;
            if (n11 != 0) {
                drawerLayout$LayoutParams.onScreen = 0.0f;
                drawerLayout$LayoutParams.openState = 0;
            } else {
                n11 = 4;
                if (bl2) {
                    int n12;
                    drawerLayout$LayoutParams.openState = n12 = drawerLayout$LayoutParams.openState | n11;
                    boolean bl3 = this.checkDrawerViewAbsoluteGravity((View)object, 3);
                    if (bl3) {
                        ViewDragHelper illegalArgumentException = this.mLeftDragger;
                        n10 = -object.getWidth();
                        n11 = object.getTop();
                        illegalArgumentException.smoothSlideViewTo((View)object, n10, n11);
                    } else {
                        ViewDragHelper viewDragHelper = this.mRightDragger;
                        n10 = this.getWidth();
                        n11 = object.getTop();
                        viewDragHelper.smoothSlideViewTo((View)object, n10, n11);
                    }
                } else {
                    this.moveDrawerToOffset((View)object, 0.0f);
                    this.updateDrawerState(0, (View)object);
                    object.setVisibility(n11);
                }
            }
            this.invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a sliding drawer");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void closeDrawers() {
        this.closeDrawers(false);
    }

    public void closeDrawers(boolean bl2) {
        int n10 = this.getChildCount();
        boolean bl3 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl4;
            int n11;
            View view = this.getChildAt(i10);
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            int n12 = this.isDrawerView(view);
            if (n12 == 0 || bl2 && (n12 = drawerLayout$LayoutParams.isPeeking) == 0) continue;
            n12 = view.getWidth();
            int n13 = this.checkDrawerViewAbsoluteGravity(view, 3);
            if (n13 != 0) {
                ViewDragHelper viewDragHelper = this.mLeftDragger;
                n12 = -n12;
                n11 = view.getTop();
                bl4 = viewDragHelper.smoothSlideViewTo(view, n12, n11);
            } else {
                ViewDragHelper viewDragHelper = this.mRightDragger;
                n13 = this.getWidth();
                n11 = view.getTop();
                bl4 = viewDragHelper.smoothSlideViewTo(view, n13, n11);
            }
            bl3 |= bl4;
            drawerLayout$LayoutParams.isPeeking = false;
        }
        this.mLeftCallback.removeCallbacks();
        DrawerLayout$ViewDragCallback drawerLayout$ViewDragCallback = this.mRightCallback;
        drawerLayout$ViewDragCallback.removeCallbacks();
        if (bl3) {
            this.invalidate();
        }
    }

    public void computeScroll() {
        int n10 = this.getChildCount();
        boolean bl2 = false;
        float f10 = 0.0f;
        ViewDragHelper viewDragHelper = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)this.getChildAt(i10).getLayoutParams();
            float f11 = drawerLayout$LayoutParams.onScreen;
            f10 = Math.max(f10, f11);
        }
        this.mScrimOpacity = f10;
        ViewDragHelper viewDragHelper2 = this.mLeftDragger;
        bl2 = true;
        f10 = Float.MIN_VALUE;
        n10 = (int)(viewDragHelper2.continueSettling(bl2) ? 1 : 0);
        viewDragHelper = this.mRightDragger;
        bl2 = viewDragHelper.continueSettling(bl2);
        if (n10 != 0 || bl2) {
            ViewCompat.postInvalidateOnAnimation((View)this);
        }
    }

    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getSource() & 2;
        if (n10 != 0) {
            n10 = motionEvent.getAction();
            int n11 = 10;
            float f10 = 1.4E-44f;
            if (n10 != n11) {
                float f11 = this.mScrimOpacity;
                n11 = 0;
                f10 = 0.0f;
                float f12 = f11 - 0.0f;
                n10 = (int)(f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1));
                if (n10 > 0) {
                    n10 = this.getChildCount();
                    if (n10 != 0) {
                        f10 = motionEvent.getX();
                        float f13 = motionEvent.getY();
                        int n12 = 1;
                        n10 -= n12;
                        while (n10 >= 0) {
                            boolean bl2;
                            View view = this.getChildAt(n10);
                            boolean bl3 = this.isInBoundsOfChild(f10, f13, view);
                            if (bl3 && !(bl3 = this.isContentView(view)) && (bl2 = this.dispatchTransformedGenericPointerEvent(motionEvent, view))) {
                                return n12 != 0;
                            }
                            n10 += -1;
                        }
                    }
                    return false;
                }
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    public void dispatchOnDrawerClosed(View view) {
        Object object = (DrawerLayout$LayoutParams)view.getLayoutParams();
        int n10 = ((DrawerLayout$LayoutParams)object).openState;
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            int n12;
            n10 = 0;
            ((DrawerLayout$LayoutParams)object).openState = 0;
            object = this.mListeners;
            if (object != null) {
                for (n12 = object.size() - n11; n12 >= 0; n12 += -1) {
                    DrawerLayout$DrawerListener drawerLayout$DrawerListener = (DrawerLayout$DrawerListener)this.mListeners.get(n12);
                    drawerLayout$DrawerListener.onDrawerClosed(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, false);
            this.updateChildAccessibilityAction(view);
            boolean bl2 = this.hasWindowFocus();
            if (bl2 && (view = this.getRootView()) != null) {
                n12 = 32;
                view.sendAccessibilityEvent(n12);
            }
        }
    }

    public void dispatchOnDrawerOpened(View view) {
        Object object = (DrawerLayout$LayoutParams)view.getLayoutParams();
        int n10 = ((DrawerLayout$LayoutParams)object).openState;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            ((DrawerLayout$LayoutParams)object).openState = n11;
            object = this.mListeners;
            if (object != null) {
                for (int i10 = object.size() - n11; i10 >= 0; i10 += -1) {
                    DrawerLayout$DrawerListener drawerLayout$DrawerListener = (DrawerLayout$DrawerListener)this.mListeners.get(i10);
                    drawerLayout$DrawerListener.onDrawerOpened(view);
                }
            }
            this.updateChildrenImportantForAccessibility(view, n11 != 0);
            this.updateChildAccessibilityAction(view);
            int n12 = this.hasWindowFocus();
            if (n12 != 0) {
                n12 = 32;
                this.sendAccessibilityEvent(n12);
            }
        }
    }

    public void dispatchOnDrawerSlide(View view, float f10) {
        List list = this.mListeners;
        if (list != null) {
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                DrawerLayout$DrawerListener drawerLayout$DrawerListener = (DrawerLayout$DrawerListener)this.mListeners.get(i10);
                drawerLayout$DrawerListener.onDrawerSlide(view, f10);
            }
        }
    }

    public boolean drawChild(Canvas canvas, View view, long l10) {
        int n10;
        float f10;
        ViewDragHelper viewDragHelper;
        int n11;
        DrawerLayout drawerLayout = this;
        View view2 = view;
        int n12 = this.getHeight();
        int n13 = this.isContentView(view);
        int n14 = this.getWidth();
        int n15 = canvas.save();
        int n16 = 3;
        int n17 = 0;
        float f11 = 0.0f;
        ViewDragHelper viewDragHelper2 = null;
        if (n13 != 0) {
            n11 = this.getChildCount();
            viewDragHelper = null;
            f10 = 0.0f;
            int n18 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                int n19;
                int n20;
                View view3 = this.getChildAt(n10);
                if (view3 == view2 || (n20 = view3.getVisibility()) != 0 || (n20 = (int)(DrawerLayout.hasOpaqueBackground(view3) ? 1 : 0)) == 0 || (n20 = (int)(this.isDrawerView(view3) ? 1 : 0)) == 0 || (n20 = view3.getHeight()) < n12) continue;
                n20 = (int)(this.checkDrawerViewAbsoluteGravity(view3, n16) ? 1 : 0);
                if (n20 != 0) {
                    n19 = view3.getRight();
                    if (n19 <= n18) continue;
                    n18 = n19;
                    continue;
                }
                n19 = view3.getLeft();
                if (n19 >= n14) continue;
                n14 = n19;
            }
            n12 = this.getHeight();
            canvas.clipRect(n18, 0, n14, n12);
            n17 = n18;
        }
        n11 = (int)(super.drawChild(canvas, view, l10) ? 1 : 0);
        canvas.restoreToCount(n15);
        float f12 = drawerLayout.mScrimOpacity;
        n15 = 0;
        Paint paint = null;
        float f13 = f12 - 0.0f;
        n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        if (n10 > 0 && n13 != 0) {
            int n21 = drawerLayout.mScrimColor;
            n12 = (int)((float)((0xFF000000 & n21) >>> 24) * f12) << 24;
            n13 = 0xFFFFFF;
            n21 = n21 & n13 | n12;
            drawerLayout.mScrimPaint.setColor(n21);
            float f14 = n17;
            n12 = 0;
            f12 = 0.0f;
            Object var27_28 = null;
            float f15 = n14;
            n14 = this.getHeight();
            float f16 = n14;
            paint = drawerLayout.mScrimPaint;
            canvas.drawRect(f14, 0.0f, f15, f16, paint);
        } else {
            Drawable drawable2 = drawerLayout.mShadowLeftResolved;
            n13 = 1132396544;
            float f17 = 255.0f;
            n14 = 1065353216;
            float f18 = 1.0f;
            if (drawable2 != null && (n12 = (int)(this.checkDrawerViewAbsoluteGravity(view2, n16) ? 1 : 0)) != 0) {
                drawable2 = drawerLayout.mShadowLeftResolved;
                n12 = drawable2.getIntrinsicWidth();
                n16 = view.getRight();
                viewDragHelper2 = drawerLayout.mLeftDragger;
                n17 = viewDragHelper2.getEdgeSize();
                f10 = n16;
                f11 = n17;
                f18 = Math.min(f10 /= f11, f18);
                f18 = Math.max(0.0f, f18);
                paint = drawerLayout.mShadowLeftResolved;
                n17 = view.getTop();
                int n22 = view.getBottom();
                paint.setBounds(n16, n17, n12 += n16, n22);
                view2 = drawerLayout.mShadowLeftResolved;
                n12 = (int)(f18 *= f17);
                view2.setAlpha(n12);
                view2 = drawerLayout.mShadowLeftResolved;
                view2.draw(canvas);
            } else {
                drawable2 = drawerLayout.mShadowRightResolved;
                if (drawable2 != null) {
                    f12 = 7.0E-45f;
                    n12 = (int)(this.checkDrawerViewAbsoluteGravity(view2, 5) ? 1 : 0);
                    if (n12 != 0) {
                        drawable2 = drawerLayout.mShadowRightResolved;
                        n12 = drawable2.getIntrinsicWidth();
                        n16 = view.getLeft();
                        n17 = this.getWidth() - n16;
                        viewDragHelper = drawerLayout.mRightDragger;
                        n10 = viewDragHelper.getEdgeSize();
                        f11 = n17;
                        f10 = n10;
                        f18 = Math.min(f11 /= f10, f18);
                        f18 = Math.max(0.0f, f18);
                        paint = drawerLayout.mShadowRightResolved;
                        n12 = n16 - n12;
                        n17 = view.getTop();
                        int n23 = view.getBottom();
                        paint.setBounds(n12, n17, n16, n23);
                        view2 = drawerLayout.mShadowRightResolved;
                        n12 = (int)(f18 *= f17);
                        view2.setAlpha(n12);
                        view2 = drawerLayout.mShadowRightResolved;
                        view2.draw(canvas);
                    }
                }
            }
        }
        return n11 != 0;
    }

    public View findDrawerWithGravity(int n10) {
        int n11 = ViewCompat.getLayoutDirection((View)this);
        n10 = GravityCompat.getAbsoluteGravity(n10, n11) & 7;
        n11 = this.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.getChildAt(i10);
            int n12 = this.getDrawerViewAbsoluteGravity(view) & 7;
            if (n12 != n10) continue;
            return view;
        }
        return null;
    }

    public View findOpenDrawer() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
            int n11 = drawerLayout$LayoutParams.openState;
            int n12 = 1;
            if ((n11 &= n12) != n12) continue;
            return view;
        }
        return null;
    }

    public View findVisibleDrawer() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            boolean bl2 = this.isDrawerView(view);
            if (!bl2 || !(bl2 = this.isDrawerVisible(view))) continue;
            return view;
        }
        return null;
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        int n10 = -1;
        DrawerLayout$LayoutParams drawerLayout$LayoutParams = new DrawerLayout$LayoutParams(n10, n10);
        return drawerLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        DrawerLayout$LayoutParams drawerLayout$LayoutParams = new DrawerLayout$LayoutParams(context, attributeSet);
        return drawerLayout$LayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        DrawerLayout$LayoutParams drawerLayout$LayoutParams;
        boolean bl2 = object instanceof DrawerLayout$LayoutParams;
        if (bl2) {
            object = (DrawerLayout$LayoutParams)((Object)object);
            drawerLayout$LayoutParams = new DrawerLayout$LayoutParams((DrawerLayout$LayoutParams)((Object)object));
        } else {
            bl2 = object instanceof ViewGroup.MarginLayoutParams;
            if (bl2) {
                object = (ViewGroup.MarginLayoutParams)object;
                drawerLayout$LayoutParams = new DrawerLayout$LayoutParams((ViewGroup.MarginLayoutParams)object);
            } else {
                drawerLayout$LayoutParams = new DrawerLayout$LayoutParams((ViewGroup.LayoutParams)object);
            }
        }
        return drawerLayout$LayoutParams;
    }

    public float getDrawerElevation() {
        boolean bl2 = SET_DRAWER_SHADOW_FROM_ELEVATION;
        if (bl2) {
            return this.mDrawerElevation;
        }
        return 0.0f;
    }

    public int getDrawerLockMode(int n10) {
        int n11 = ViewCompat.getLayoutDirection((View)this);
        int n12 = 3;
        if (n10 != n12) {
            int n13 = 5;
            if (n10 != n13) {
                n13 = 0x800003;
                if (n10 != n13) {
                    n13 = 0x800005;
                    if (n10 == n13) {
                        n10 = this.mLockModeEnd;
                        if (n10 != n12) {
                            return n10;
                        }
                        n10 = n11 == 0 ? this.mLockModeRight : this.mLockModeLeft;
                        if (n10 != n12) {
                            return n10;
                        }
                    }
                } else {
                    n10 = this.mLockModeStart;
                    if (n10 != n12) {
                        return n10;
                    }
                    n10 = n11 == 0 ? this.mLockModeLeft : this.mLockModeRight;
                    if (n10 != n12) {
                        return n10;
                    }
                }
            } else {
                n10 = this.mLockModeRight;
                if (n10 != n12) {
                    return n10;
                }
                n10 = n11 == 0 ? this.mLockModeEnd : this.mLockModeStart;
                if (n10 != n12) {
                    return n10;
                }
            }
        } else {
            n10 = this.mLockModeLeft;
            if (n10 != n12) {
                return n10;
            }
            n10 = n11 == 0 ? this.mLockModeStart : this.mLockModeEnd;
            if (n10 != n12) {
                return n10;
            }
        }
        return 0;
    }

    public int getDrawerLockMode(View object) {
        boolean bl2 = this.isDrawerView((View)object);
        if (bl2) {
            int n10 = ((DrawerLayout$LayoutParams)object.getLayoutParams()).gravity;
            return this.getDrawerLockMode(n10);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a drawer");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public CharSequence getDrawerTitle(int n10) {
        int n11 = ViewCompat.getLayoutDirection((View)this);
        if ((n10 = GravityCompat.getAbsoluteGravity(n10, n11)) == (n11 = 3)) {
            return this.mTitleLeft;
        }
        n11 = 5;
        if (n10 == n11) {
            return this.mTitleRight;
        }
        return null;
    }

    public int getDrawerViewAbsoluteGravity(View view) {
        int n10 = ((DrawerLayout$LayoutParams)view.getLayoutParams()).gravity;
        int n11 = ViewCompat.getLayoutDirection((View)this);
        return GravityCompat.getAbsoluteGravity(n10, n11);
    }

    public float getDrawerViewOffset(View view) {
        return ((DrawerLayout$LayoutParams)view.getLayoutParams()).onScreen;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.mStatusBarBackground;
    }

    public boolean isContentView(View object) {
        object = (DrawerLayout$LayoutParams)object.getLayoutParams();
        int n10 = object.gravity;
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean isDrawerOpen(int n10) {
        View view = this.findDrawerWithGravity(n10);
        if (view != null) {
            return this.isDrawerOpen(view);
        }
        return false;
    }

    public boolean isDrawerOpen(View object) {
        int n10 = (int)(this.isDrawerView((View)object) ? 1 : 0);
        if (n10 != 0) {
            object = (DrawerLayout$LayoutParams)object.getLayoutParams();
            int n11 = object.openState;
            n10 = 1;
            if ((n11 &= n10) != n10) {
                n10 = 0;
                Object var4_4 = null;
            }
            return n10 != 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a drawer");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean isDrawerView(View view) {
        DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        int n10 = drawerLayout$LayoutParams.gravity;
        int n11 = ViewCompat.getLayoutDirection(view);
        n11 = GravityCompat.getAbsoluteGravity(n10, n11);
        n10 = n11 & 3;
        boolean bl2 = true;
        if (n10 != 0) {
            return bl2;
        }
        if ((n11 &= 5) != 0) {
            return bl2;
        }
        return false;
    }

    public boolean isDrawerVisible(int n10) {
        View view = this.findDrawerWithGravity(n10);
        if (view != null) {
            return this.isDrawerVisible(view);
        }
        return false;
    }

    public boolean isDrawerVisible(View object) {
        boolean bl2 = this.isDrawerView((View)object);
        if (bl2) {
            object = (DrawerLayout$LayoutParams)object.getLayoutParams();
            float f10 = object.onScreen;
            bl2 = false;
            Object var4_4 = null;
            float f11 = f10 - 0.0f;
            Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                object2 = true;
                f10 = Float.MIN_VALUE;
            } else {
                object2 = false;
                f10 = 0.0f;
                object = null;
            }
            return (boolean)object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a drawer");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean isOpen() {
        return this.isDrawerOpen(0x800003);
    }

    public void moveDrawerToOffset(View view, float f10) {
        float f11 = this.getDrawerViewOffset(view);
        float f12 = view.getWidth();
        int n10 = (int)(f11 * f12);
        int n11 = (int)(f12 *= f10) - n10;
        f11 = 4.2E-45f;
        n10 = (int)(this.checkDrawerViewAbsoluteGravity(view, 3) ? 1 : 0);
        if (n10 == 0) {
            n11 = -n11;
        }
        view.offsetLeftAndRight(n11);
        this.setDrawerViewOffset(view, f10);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mFirstLayout = true;
    }

    public void onDraw(Canvas canvas) {
        Object object;
        super.onDraw(canvas);
        int n10 = this.mDrawStatusBarBackground;
        if (n10 != 0 && (object = this.mStatusBarBackground) != null) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11 && (object = this.mLastInsets) != null) {
                object = (WindowInsets)object;
                n10 = object.getSystemWindowInsetTop();
            } else {
                n10 = 0;
                object = null;
            }
            if (n10 > 0) {
                Drawable drawable2 = this.mStatusBarBackground;
                int n12 = this.getWidth();
                drawable2.setBounds(0, 0, n12, n10);
                object = this.mStatusBarBackground;
                object.draw(canvas);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent object) {
        int n10;
        float f10;
        int n11;
        ViewDragHelper viewDragHelper;
        boolean bl2;
        block8: {
            ViewDragHelper viewDragHelper2;
            int n12;
            block4: {
                float f11;
                block7: {
                    block5: {
                        int n13;
                        block6: {
                            n12 = object.getActionMasked();
                            ViewDragHelper viewDragHelper3 = this.mLeftDragger;
                            bl2 = viewDragHelper3.shouldInterceptTouchEvent((MotionEvent)object);
                            viewDragHelper = this.mRightDragger;
                            n11 = viewDragHelper.shouldInterceptTouchEvent((MotionEvent)object);
                            bl2 |= n11;
                            n11 = 1;
                            f10 = Float.MIN_VALUE;
                            if (n12 == 0) break block4;
                            if (n12 == n11) break block5;
                            n10 = 2;
                            f11 = 2.8E-45f;
                            n13 = 3;
                            float f12 = 4.2E-45f;
                            if (n12 == n10) break block6;
                            if (n12 == n13) break block5;
                            break block7;
                        }
                        object = this.mLeftDragger;
                        n10 = (int)(((ViewDragHelper)object).checkTouchSlop(n13) ? 1 : 0);
                        if (n10 != 0) {
                            this.mLeftCallback.removeCallbacks();
                            object = this.mRightCallback;
                            ((DrawerLayout$ViewDragCallback)object).removeCallbacks();
                        }
                        break block7;
                    }
                    this.closeDrawers(n11 != 0);
                    this.mChildrenCanceledTouch = false;
                }
                n10 = 0;
                object = null;
                f11 = 0.0f;
                break block8;
            }
            float f13 = object.getX();
            float f14 = object.getY();
            this.mInitialMotionX = f13;
            this.mInitialMotionY = f14;
            float f15 = this.mScrimOpacity;
            float f16 = f15 - 0.0f;
            Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 > 0 && (object = (viewDragHelper2 = this.mLeftDragger).findTopChildUnder(n12 = (int)f13, n10 = (int)f14)) != null && (n10 = (int)(this.isContentView((View)object) ? 1 : 0)) != 0) {
                n10 = n11;
                f14 = f10;
            } else {
                n10 = 0;
                object = null;
                f14 = 0.0f;
            }
            this.mChildrenCanceledTouch = false;
        }
        if (!bl2 && n10 == 0 && (n10 = (int)(this.hasPeekingDrawer() ? 1 : 0)) == 0 && (n10 = (int)(this.mChildrenCanceledTouch ? 1 : 0)) == 0) {
            n11 = 0;
            viewDragHelper = null;
            f10 = 0.0f;
        }
        return n11 != 0;
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11 && (n11 = (int)(this.hasVisibleDrawer() ? 1 : 0)) != 0) {
            keyEvent.startTracking();
            return true;
        }
        return super.onKeyDown(n10, keyEvent);
    }

    public boolean onKeyUp(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11) {
            int n12;
            View view = this.findVisibleDrawer();
            if (view != null && (n12 = this.getDrawerLockMode(view)) == 0) {
                this.closeDrawers();
            }
            if (view != null) {
                n10 = 1;
            } else {
                n10 = 0;
                view = null;
            }
            return n10 != 0;
        }
        return super.onKeyUp(n10, keyEvent);
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        Object object;
        int n14;
        DrawerLayout drawerLayout = this;
        int n15 = 1;
        float f10 = Float.MIN_VALUE;
        this.mInLayout = n15;
        int n16 = n12 - n10;
        int n17 = this.getChildCount();
        for (int i10 = 0; i10 < n17; ++i10) {
            int n18;
            View view = drawerLayout.getChildAt(i10);
            int n19 = view.getVisibility();
            if (n19 != (n18 = 8)) {
                int n20;
                int n21;
                int n22;
                DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
                n18 = (int)(drawerLayout.isContentView(view) ? 1 : 0);
                if (n18 != 0) {
                    n18 = drawerLayout$LayoutParams.leftMargin;
                    n22 = drawerLayout$LayoutParams.topMargin;
                    n21 = view.getMeasuredWidth() + n18;
                    n19 = drawerLayout$LayoutParams.topMargin;
                    n20 = view.getMeasuredHeight();
                    view.layout(n18, n22, n21, n19 += n20);
                } else {
                    float f11;
                    int n23;
                    float f12;
                    n18 = view.getMeasuredWidth();
                    n22 = view.getMeasuredHeight();
                    float f13 = 4.2E-45f;
                    n21 = (int)(drawerLayout.checkDrawerViewAbsoluteGravity(view, 3) ? 1 : 0);
                    if (n21 != 0) {
                        n21 = -n18;
                        f12 = n18;
                        n23 = (int)(drawerLayout$LayoutParams.onScreen * f12);
                        n21 += n23;
                        n23 = n18 + n21;
                        f11 = (float)n23 / f12;
                    } else {
                        f13 = n18;
                        f12 = drawerLayout$LayoutParams.onScreen * f13;
                        n20 = (int)f12;
                        n20 = n16 - n20;
                        n23 = n16 - n20;
                        f11 = (float)n23 / f13;
                        n21 = n20;
                    }
                    f12 = drawerLayout$LayoutParams.onScreen;
                    n20 = (int)(f11 == f12 ? 0 : (f11 > f12 ? 1 : -1));
                    if (n20 != 0) {
                        n20 = n15;
                        f12 = f10;
                    } else {
                        n20 = 0;
                        f12 = 0.0f;
                    }
                    int n24 = drawerLayout$LayoutParams.gravity & 0x70;
                    int n25 = 16;
                    if (n24 != n25) {
                        n25 = 80;
                        if (n24 != n25) {
                            n24 = drawerLayout$LayoutParams.topMargin;
                            view.layout(n21, n24, n18 += n21, n22 += n24);
                        } else {
                            n22 = n13 - n11;
                            n24 = drawerLayout$LayoutParams.bottomMargin;
                            n24 = n22 - n24;
                            n25 = view.getMeasuredHeight();
                            n24 -= n25;
                            n25 = drawerLayout$LayoutParams.bottomMargin;
                            view.layout(n21, n24, n18 += n21, n22 -= n25);
                        }
                    } else {
                        n24 = n13 - n11;
                        n25 = (n24 - n22) / 2;
                        int n26 = drawerLayout$LayoutParams.topMargin;
                        if (n25 < n26) {
                            n25 = n26;
                        } else {
                            n26 = n25 + n22;
                            n15 = drawerLayout$LayoutParams.bottomMargin;
                            n14 = n24 - n15;
                            if (n26 > n14) {
                                n25 = (n24 -= n15) - n22;
                            }
                        }
                        view.layout(n21, n25, n18 += n21, n22 += n25);
                    }
                    if (n20 != 0) {
                        drawerLayout.setDrawerViewOffset(view, f11);
                    }
                    f10 = drawerLayout$LayoutParams.onScreen;
                    n14 = 0;
                    float f14 = f10 - 0.0f;
                    n15 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
                    if (n15 > 0) {
                        n15 = 0;
                        f10 = 0.0f;
                        object = null;
                    } else {
                        n15 = 4;
                        f10 = 5.6E-45f;
                    }
                    n14 = view.getVisibility();
                    if (n14 != n15) {
                        view.setVisibility(n15);
                    }
                }
            }
            n15 = 1;
            f10 = Float.MIN_VALUE;
        }
        n15 = sEdgeSizeUsingSystemGestureInsets;
        if (n15 != 0 && (object = this.getRootWindowInsets()) != null) {
            object = WindowInsetsCompat.toWindowInsetsCompat(object).getSystemGestureInsets();
            ViewDragHelper viewDragHelper = drawerLayout.mLeftDragger;
            n17 = viewDragHelper.getDefaultEdgeSize();
            n14 = object.left;
            n17 = Math.max(n17, n14);
            viewDragHelper.setEdgeSize(n17);
            viewDragHelper = drawerLayout.mRightDragger;
            n17 = viewDragHelper.getDefaultEdgeSize();
            n15 = object.right;
            n15 = Math.max(n17, n15);
            viewDragHelper.setEdgeSize(n15);
        }
        drawerLayout.mInLayout = false;
        drawerLayout.mFirstLayout = false;
    }

    public void onMeasure(int n10, int n11) {
        block24: {
            float f10;
            int n12;
            float f11;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            DrawerLayout drawerLayout;
            block23: {
                drawerLayout = this;
                n19 = Build.VERSION.SDK_INT;
                n18 = View.MeasureSpec.getMode((int)n10);
                n17 = View.MeasureSpec.getMode((int)n11);
                n16 = View.MeasureSpec.getSize((int)n10);
                n15 = View.MeasureSpec.getSize((int)n11);
                n14 = 300;
                n13 = 0x40000000;
                f11 = 2.0f;
                if (n18 == n13 && n17 == n13) break block23;
                n12 = this.isInEditMode();
                if (n12 == 0) break block24;
                if (n18 == 0) {
                    n16 = n14;
                }
                if (n17 == 0) {
                    n15 = n14;
                }
            }
            drawerLayout.setMeasuredDimension(n16, n15);
            Object object = drawerLayout.mLastInsets;
            n14 = 0;
            if (object != null && (n18 = (int)(ViewCompat.getFitsSystemWindows((View)this) ? 1 : 0)) != 0) {
                n18 = 1;
                f10 = Float.MIN_VALUE;
            } else {
                n18 = 0;
                object = null;
                f10 = 0.0f;
            }
            n12 = ViewCompat.getLayoutDirection((View)this);
            int n20 = this.getChildCount();
            boolean bl2 = false;
            boolean bl3 = false;
            for (int i10 = 0; i10 < n20; ++i10) {
                View view;
                block32: {
                    float f12;
                    int n21;
                    block31: {
                        float f13;
                        WindowInsets windowInsets;
                        DrawerLayout$LayoutParams drawerLayout$LayoutParams;
                        int n22;
                        int n23;
                        block30: {
                            block26: {
                                block29: {
                                    block27: {
                                        block28: {
                                            block25: {
                                                view = drawerLayout.getChildAt(i10);
                                                n23 = view.getVisibility();
                                                if (n23 != (n22 = 8)) break block25;
                                                n21 = n18;
                                                f12 = f10;
                                                n17 = n13;
                                                break block26;
                                            }
                                            drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
                                            n22 = 3;
                                            if (n18 == 0) break block27;
                                            n17 = GravityCompat.getAbsoluteGravity(drawerLayout$LayoutParams.gravity, n12);
                                            boolean bl4 = ViewCompat.getFitsSystemWindows(view);
                                            n13 = 21;
                                            f11 = 2.9E-44f;
                                            if (!bl4) break block28;
                                            if (n19 < n13) break block27;
                                            windowInsets = (WindowInsets)drawerLayout.mLastInsets;
                                            if (n17 == n22) {
                                                n17 = windowInsets.getSystemWindowInsetLeft();
                                                n22 = windowInsets.getSystemWindowInsetTop();
                                                n21 = n18;
                                                f12 = f10;
                                                n18 = windowInsets.getSystemWindowInsetBottom();
                                                windowInsets = windowInsets.replaceSystemWindowInsets(n17, n22, 0, n18);
                                            } else {
                                                n21 = n18;
                                                f12 = f10;
                                                n18 = 5;
                                                f10 = 7.0E-45f;
                                                if (n17 == n18) {
                                                    n18 = windowInsets.getSystemWindowInsetTop();
                                                    n17 = windowInsets.getSystemWindowInsetRight();
                                                    n22 = windowInsets.getSystemWindowInsetBottom();
                                                    windowInsets = windowInsets.replaceSystemWindowInsets(0, n18, n17, n22);
                                                }
                                            }
                                            view.dispatchApplyWindowInsets(windowInsets);
                                            break block29;
                                        }
                                        n21 = n18;
                                        f12 = f10;
                                        if (n19 >= n13) {
                                            object = (WindowInsets)drawerLayout.mLastInsets;
                                            n13 = 3;
                                            f11 = 4.2E-45f;
                                            if (n17 == n13) {
                                                n17 = object.getSystemWindowInsetLeft();
                                                n13 = object.getSystemWindowInsetTop();
                                                n22 = object.getSystemWindowInsetBottom();
                                                object = object.replaceSystemWindowInsets(n17, n13, 0, n22);
                                            } else {
                                                n13 = 5;
                                                f11 = 7.0E-45f;
                                                if (n17 == n13) {
                                                    n17 = object.getSystemWindowInsetTop();
                                                    n13 = object.getSystemWindowInsetRight();
                                                    n22 = object.getSystemWindowInsetBottom();
                                                    object = object.replaceSystemWindowInsets(0, n17, n13, n22);
                                                }
                                            }
                                            drawerLayout$LayoutParams.leftMargin = n17 = object.getSystemWindowInsetLeft();
                                            drawerLayout$LayoutParams.topMargin = n17 = object.getSystemWindowInsetTop();
                                            drawerLayout$LayoutParams.rightMargin = n17 = object.getSystemWindowInsetRight();
                                            drawerLayout$LayoutParams.bottomMargin = n18 = object.getSystemWindowInsetBottom();
                                        }
                                        break block29;
                                    }
                                    n21 = n18;
                                    f12 = f10;
                                }
                                n18 = (int)(drawerLayout.isContentView(view) ? 1 : 0);
                                if (n18 == 0) break block30;
                                n18 = drawerLayout$LayoutParams.leftMargin;
                                n18 = n16 - n18;
                                n17 = drawerLayout$LayoutParams.rightMargin;
                                n18 -= n17;
                                n17 = 0x40000000;
                                n18 = View.MeasureSpec.makeMeasureSpec((int)n18, (int)n17);
                                n13 = drawerLayout$LayoutParams.topMargin;
                                n13 = n15 - n13;
                                n23 = drawerLayout$LayoutParams.bottomMargin;
                                n13 = View.MeasureSpec.makeMeasureSpec((int)(n13 - n23), (int)n17);
                                view.measure(n18, n13);
                            }
                            n22 = n10;
                            n23 = n11;
                            break block31;
                        }
                        n17 = 0x40000000;
                        n18 = (int)(drawerLayout.isDrawerView(view) ? 1 : 0);
                        if (n18 == 0) break block32;
                        n18 = (int)(SET_DRAWER_SHADOW_FROM_ELEVATION ? 1 : 0);
                        if (n18 != 0 && (n18 = (int)((f13 = (f10 = ViewCompat.getElevation(view)) - (f11 = drawerLayout.mDrawerElevation)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) != 0) {
                            ViewCompat.setElevation(view, f11);
                        }
                        n18 = drawerLayout.getDrawerViewAbsoluteGravity(view) & 7;
                        n13 = 3;
                        f11 = 4.2E-45f;
                        if (n18 == n13) {
                            n13 = 1;
                            f11 = Float.MIN_VALUE;
                        } else {
                            n13 = 0;
                            windowInsets = null;
                            f11 = 0.0f;
                        }
                        if (n13 != 0 && bl2 || n13 == 0 && bl3) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Child drawer has absolute gravity ");
                            object = DrawerLayout.gravityToString(n18);
                            stringBuilder.append((String)object);
                            stringBuilder.append(" but this ");
                            stringBuilder.append(TAG);
                            stringBuilder.append(" already has a drawer view along that edge");
                            object = stringBuilder.toString();
                            IllegalStateException illegalStateException = new IllegalStateException((String)object);
                            throw illegalStateException;
                        }
                        if (n13 != 0) {
                            bl2 = true;
                        } else {
                            bl3 = true;
                        }
                        n18 = drawerLayout.mMinDrawerMargin;
                        n13 = drawerLayout$LayoutParams.leftMargin;
                        n18 += n13;
                        n13 = drawerLayout$LayoutParams.rightMargin;
                        n18 += n13;
                        n13 = drawerLayout$LayoutParams.width;
                        n22 = n10;
                        n18 = ViewGroup.getChildMeasureSpec((int)n10, (int)n18, (int)n13);
                        n13 = drawerLayout$LayoutParams.topMargin;
                        n17 = drawerLayout$LayoutParams.bottomMargin;
                        n13 += n17;
                        n17 = drawerLayout$LayoutParams.height;
                        n23 = n11;
                        n17 = ViewGroup.getChildMeasureSpec((int)n11, (int)n13, (int)n17);
                        view.measure(n18, n17);
                    }
                    n18 = n21;
                    f10 = f12;
                    n13 = 0x40000000;
                    f11 = 2.0f;
                    continue;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Child ");
                ((StringBuilder)object).append(view);
                ((StringBuilder)object).append(" at index ");
                ((StringBuilder)object).append(i10);
                ((StringBuilder)object).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                object = ((StringBuilder)object).toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)object);
                throw illegalStateException;
            }
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
        throw illegalArgumentException;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int n10;
        int n11;
        int n12;
        int n13 = parcelable instanceof DrawerLayout$SavedState;
        if (n13 == 0) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (DrawerLayout$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(parcelable2);
        n13 = parcelable.openDrawerGravity;
        if (n13 != 0 && (parcelable2 = this.findDrawerWithGravity(n13)) != null) {
            this.openDrawer((View)parcelable2);
        }
        if ((n13 = parcelable.lockModeLeft) != (n12 = 3)) {
            this.setDrawerLockMode(n13, n12);
        }
        if ((n13 = parcelable.lockModeRight) != n12) {
            n11 = 5;
            this.setDrawerLockMode(n13, n11);
        }
        if ((n13 = parcelable.lockModeStart) != n12) {
            n11 = 0x800003;
            this.setDrawerLockMode(n13, n11);
        }
        if ((n10 = parcelable.lockModeEnd) != n12) {
            n13 = 0x800005;
            this.setDrawerLockMode(n10, n13);
        }
    }

    public void onRtlPropertiesChanged(int n10) {
        this.resolveShadowDrawables();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        DrawerLayout$SavedState drawerLayout$SavedState = new DrawerLayout$SavedState(parcelable);
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)this.getChildAt(i10).getLayoutParams();
            int n11 = drawerLayout$LayoutParams.openState;
            int n12 = 1;
            int n13 = n11 == n12 ? n12 : 0;
            int n14 = 2;
            if (n11 != n14) {
                n12 = 0;
            }
            if (n13 == 0 && n12 == 0) {
                continue;
            }
            drawerLayout$SavedState.openDrawerGravity = n10 = drawerLayout$LayoutParams.gravity;
            break;
        }
        drawerLayout$SavedState.lockModeLeft = n10 = this.mLockModeLeft;
        drawerLayout$SavedState.lockModeRight = n10 = this.mLockModeRight;
        drawerLayout$SavedState.lockModeStart = n10 = this.mLockModeStart;
        drawerLayout$SavedState.lockModeEnd = n10 = this.mLockModeEnd;
        return drawerLayout$SavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        block7: {
            block5: {
                int n11;
                block9: {
                    block8: {
                        float f10;
                        float f11;
                        int n12;
                        int n13;
                        block6: {
                            this.mLeftDragger.processTouchEvent(motionEvent);
                            ViewDragHelper viewDragHelper = this.mRightDragger;
                            viewDragHelper.processTouchEvent(motionEvent);
                            n13 = motionEvent.getAction() & 0xFF;
                            n11 = 0;
                            n10 = 1;
                            if (n13 == 0) break block5;
                            if (n13 == n10) break block6;
                            int n14 = 3;
                            float f12 = 4.2E-45f;
                            if (n13 == n14) {
                                this.closeDrawers(n10 != 0);
                                this.mChildrenCanceledTouch = false;
                            }
                            break block7;
                        }
                        float f13 = motionEvent.getX();
                        float f14 = motionEvent.getY();
                        ViewDragHelper viewDragHelper = this.mLeftDragger;
                        int n15 = (int)f13;
                        int n16 = (int)f14;
                        if ((viewDragHelper = viewDragHelper.findTopChildUnder(n15, n16)) == null || (n12 = this.isContentView((View)viewDragHelper)) == 0) break block8;
                        float f15 = this.mInitialMotionX;
                        f13 -= f15;
                        f15 = this.mInitialMotionY;
                        f14 -= f15;
                        viewDragHelper = this.mLeftDragger;
                        n12 = viewDragHelper.getTouchSlop();
                        f13 *= f13;
                        f14 *= f14;
                        if ((f11 = (f10 = (f13 += f14) - (f14 = (float)(n12 *= n12))) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1)) >= 0 || (motionEvent = this.findOpenDrawer()) == null) break block8;
                        f11 = this.getDrawerLockMode((View)motionEvent);
                        n13 = 2;
                        f13 = 2.8E-45f;
                        if (f11 != n13) break block9;
                    }
                    n11 = n10;
                }
                this.closeDrawers(n11 != 0);
                break block7;
            }
            float f16 = motionEvent.getX();
            float f17 = motionEvent.getY();
            this.mInitialMotionX = f16;
            this.mInitialMotionY = f17;
            this.mChildrenCanceledTouch = false;
        }
        return n10 != 0;
    }

    public void open() {
        this.openDrawer(0x800003);
    }

    public void openDrawer(int n10) {
        this.openDrawer(n10, true);
    }

    public void openDrawer(int n10, boolean bl2) {
        Object object = this.findDrawerWithGravity(n10);
        if (object != null) {
            this.openDrawer((View)object, bl2);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("No drawer view found with gravity ");
        String string2 = DrawerLayout.gravityToString(n10);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void openDrawer(View view) {
        this.openDrawer(view, true);
    }

    public void openDrawer(View object, boolean bl2) {
        int n10 = this.isDrawerView((View)object);
        if (n10 != 0) {
            DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)object.getLayoutParams();
            int n11 = this.mFirstLayout;
            float f10 = 1.0f;
            if (n11 != 0) {
                drawerLayout$LayoutParams.onScreen = f10;
                boolean bl3 = true;
                drawerLayout$LayoutParams.openState = bl3;
                this.updateChildrenImportantForAccessibility((View)object, bl3);
                this.updateChildAccessibilityAction((View)object);
            } else {
                n11 = 0;
                if (bl2) {
                    int n12;
                    drawerLayout$LayoutParams.openState = n12 = drawerLayout$LayoutParams.openState | 2;
                    boolean bl4 = this.checkDrawerViewAbsoluteGravity((View)object, 3);
                    if (bl4) {
                        ViewDragHelper viewDragHelper = this.mLeftDragger;
                        n10 = object.getTop();
                        viewDragHelper.smoothSlideViewTo((View)object, 0, n10);
                    } else {
                        ViewDragHelper viewDragHelper = this.mRightDragger;
                        n10 = this.getWidth();
                        n11 = object.getWidth();
                        n10 -= n11;
                        n11 = object.getTop();
                        viewDragHelper.smoothSlideViewTo((View)object, n10, n11);
                    }
                } else {
                    this.moveDrawerToOffset((View)object, f10);
                    this.updateDrawerState(0, (View)object);
                    object.setVisibility(0);
                }
            }
            this.invalidate();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a sliding drawer");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void removeDrawerListener(DrawerLayout$DrawerListener drawerLayout$DrawerListener) {
        if (drawerLayout$DrawerListener == null) {
            return;
        }
        List list = this.mListeners;
        if (list == null) {
            return;
        }
        list.remove(drawerLayout$DrawerListener);
    }

    public void requestDisallowInterceptTouchEvent(boolean bl2) {
        super.requestDisallowInterceptTouchEvent(bl2);
        if (bl2) {
            bl2 = true;
            this.closeDrawers(bl2);
        }
    }

    public void requestLayout() {
        boolean bl2 = this.mInLayout;
        if (!bl2) {
            super.requestLayout();
        }
    }

    public void setChildInsets(Object object, boolean bl2) {
        boolean bl3;
        this.mLastInsets = object;
        this.mDrawStatusBarBackground = bl2;
        if (!bl2 && (object = this.getBackground()) == null) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        this.setWillNotDraw(bl3);
        this.requestLayout();
    }

    public void setDrawerElevation(float f10) {
        int n10;
        this.mDrawerElevation = f10;
        f10 = 0.0f;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            View view = this.getChildAt(i10);
            boolean bl2 = this.isDrawerView(view);
            if (!bl2) continue;
            float f11 = this.mDrawerElevation;
            ViewCompat.setElevation(view, f11);
        }
    }

    public void setDrawerListener(DrawerLayout$DrawerListener drawerLayout$DrawerListener) {
        DrawerLayout$DrawerListener drawerLayout$DrawerListener2 = this.mListener;
        if (drawerLayout$DrawerListener2 != null) {
            this.removeDrawerListener(drawerLayout$DrawerListener2);
        }
        if (drawerLayout$DrawerListener != null) {
            this.addDrawerListener(drawerLayout$DrawerListener);
        }
        this.mListener = drawerLayout$DrawerListener;
    }

    public void setDrawerLockMode(int n10) {
        this.setDrawerLockMode(n10, 3);
        this.setDrawerLockMode(n10, 5);
    }

    public void setDrawerLockMode(int n10, int n11) {
        int n12 = ViewCompat.getLayoutDirection((View)this);
        n12 = GravityCompat.getAbsoluteGravity(n11, n12);
        int n13 = 3;
        if (n11 != n13) {
            int n14 = 5;
            if (n11 != n14) {
                n14 = 0x800003;
                if (n11 != n14) {
                    n14 = 0x800005;
                    if (n11 == n14) {
                        this.mLockModeEnd = n10;
                    }
                } else {
                    this.mLockModeStart = n10;
                }
            } else {
                this.mLockModeRight = n10;
            }
        } else {
            this.mLockModeLeft = n10;
        }
        if (n10 != 0) {
            ViewDragHelper viewDragHelper = n12 == n13 ? this.mLeftDragger : this.mRightDragger;
            viewDragHelper.cancel();
        }
        if (n10 != (n11 = 1)) {
            View view;
            n11 = 2;
            if (n10 == n11 && (view = this.findDrawerWithGravity(n12)) != null) {
                this.openDrawer(view);
            }
        } else {
            View view = this.findDrawerWithGravity(n12);
            if (view != null) {
                this.closeDrawer(view);
            }
        }
    }

    public void setDrawerLockMode(int n10, View object) {
        boolean bl2 = this.isDrawerView((View)object);
        if (bl2) {
            int n11 = ((DrawerLayout$LayoutParams)object.getLayoutParams()).gravity;
            this.setDrawerLockMode(n10, n11);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("View ");
        stringBuilder.append(object);
        stringBuilder.append(" is not a drawer with appropriate layout_gravity");
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public void setDrawerShadow(int n10, int n11) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setDrawerShadow(drawable2, n11);
    }

    public void setDrawerShadow(Drawable drawable2, int n10) {
        block8: {
            block5: {
                int n11;
                block7: {
                    int n12;
                    block6: {
                        block4: {
                            n11 = SET_DRAWER_SHADOW_FROM_ELEVATION;
                            if (n11 != 0) {
                                return;
                            }
                            n11 = 0x800003;
                            n12 = n10 & n11;
                            if (n12 != n11) break block4;
                            this.mShadowStart = drawable2;
                            break block5;
                        }
                        n11 = 0x800005;
                        n12 = n10 & n11;
                        if (n12 != n11) break block6;
                        this.mShadowEnd = drawable2;
                        break block5;
                    }
                    n11 = n10 & 3;
                    n12 = 3;
                    if (n11 != n12) break block7;
                    this.mShadowLeft = drawable2;
                    break block5;
                }
                n11 = 5;
                if ((n10 &= n11) != n11) break block8;
                this.mShadowRight = drawable2;
            }
            this.resolveShadowDrawables();
            this.invalidate();
        }
    }

    public void setDrawerTitle(int n10, CharSequence charSequence) {
        int n11 = ViewCompat.getLayoutDirection((View)this);
        if ((n10 = GravityCompat.getAbsoluteGravity(n10, n11)) == (n11 = 3)) {
            this.mTitleLeft = charSequence;
        } else {
            n11 = 5;
            if (n10 == n11) {
                this.mTitleRight = charSequence;
            }
        }
    }

    public void setDrawerViewOffset(View view, float f10) {
        DrawerLayout$LayoutParams drawerLayout$LayoutParams = (DrawerLayout$LayoutParams)view.getLayoutParams();
        float f11 = drawerLayout$LayoutParams.onScreen;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return;
        }
        drawerLayout$LayoutParams.onScreen = f10;
        this.dispatchOnDrawerSlide(view, f10);
    }

    public void setScrimColor(int n10) {
        this.mScrimColor = n10;
        this.invalidate();
    }

    public void setStatusBarBackground(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = ContextCompat.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.mStatusBarBackground = drawable2;
        this.invalidate();
    }

    public void setStatusBarBackground(Drawable drawable2) {
        this.mStatusBarBackground = drawable2;
        this.invalidate();
    }

    public void setStatusBarBackgroundColor(int n10) {
        ColorDrawable colorDrawable = new ColorDrawable(n10);
        this.mStatusBarBackground = colorDrawable;
        this.invalidate();
    }

    public void updateDrawerState(int n10, View object) {
        Object object2;
        ViewDragHelper viewDragHelper = this.mLeftDragger;
        int n11 = viewDragHelper.getViewDragState();
        ViewDragHelper viewDragHelper2 = this.mRightDragger;
        int n12 = viewDragHelper2.getViewDragState();
        int n13 = 2;
        int n14 = 1;
        if (n11 != n14 && n12 != n14) {
            if (n11 != n13 && n12 != n13) {
                n13 = 0;
            }
        } else {
            n13 = n14;
        }
        if (object != null && n10 == 0) {
            object2 = (DrawerLayout$LayoutParams)object.getLayoutParams();
            float f10 = ((DrawerLayout$LayoutParams)object2).onScreen;
            float f11 = 0.0f;
            viewDragHelper = null;
            float f12 = f10 - 0.0f;
            n11 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n11 == 0) {
                this.dispatchOnDrawerClosed((View)object);
            } else {
                n11 = 1065353216;
                f11 = 1.0f;
                float f13 = f10 - f11;
                n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
                if (n10 == 0) {
                    this.dispatchOnDrawerOpened((View)object);
                }
            }
        }
        if (n13 != (n10 = this.mDrawerState)) {
            this.mDrawerState = n13;
            object2 = this.mListeners;
            if (object2 != null) {
                for (n10 = object2.size() - n14; n10 >= 0; n10 += -1) {
                    object = (DrawerLayout$DrawerListener)this.mListeners.get(n10);
                    object.onDrawerStateChanged(n13);
                }
            }
        }
    }
}

