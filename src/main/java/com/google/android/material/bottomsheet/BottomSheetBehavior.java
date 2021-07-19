/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 */
package com.google.android.material.bottomsheet;

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.bottomsheet.BottomSheetBehavior$1;
import com.google.android.material.bottomsheet.BottomSheetBehavior$2;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState;
import com.google.android.material.bottomsheet.BottomSheetBehavior$SettleRunnable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class BottomSheetBehavior
extends CoordinatorLayout$Behavior {
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    public static final int PEEK_HEIGHT_AUTO = 255;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    public int activePointerId;
    private BottomSheetBehavior$BottomSheetCallback callback;
    public int collapsedOffset;
    private final ViewDragHelper$Callback dragCallback;
    private boolean fitToContents;
    public int fitToContentsOffset;
    public int halfExpandedOffset;
    public boolean hideable;
    private boolean ignoreEvents;
    private Map importantForAccessibilityMap;
    private int initialY;
    private int lastNestedScrollDy;
    private int lastPeekHeight;
    private float maximumVelocity;
    private boolean nestedScrolled;
    public WeakReference nestedScrollingChildRef;
    public int parentHeight;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightMin;
    private boolean skipCollapsed;
    public int state;
    public boolean touchingScrollingChild;
    private VelocityTracker velocityTracker;
    public ViewDragHelper viewDragHelper;
    public WeakReference viewRef;

    public BottomSheetBehavior() {
        this.fitToContents = true;
        this.state = 4;
        BottomSheetBehavior$2 bottomSheetBehavior$2 = new BottomSheetBehavior$2(this);
        this.dragCallback = bottomSheetBehavior$2;
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        int n10;
        boolean bl2;
        this.fitToContents = bl2 = true;
        this.state = 4;
        Object object = new BottomSheetBehavior$2(this);
        this.dragCallback = object;
        object = R$styleable.BottomSheetBehavior_Layout;
        attributeSet = context.obtainStyledAttributes(attributeSet, (int[])object);
        int n11 = R$styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue typedValue = attributeSet.peekValue(n11);
        int n12 = -1;
        if (typedValue != null && (n10 = typedValue.data) == n12) {
            this.setPeekHeight(n10);
        } else {
            n11 = attributeSet.getDimensionPixelSize(n11, n12);
            this.setPeekHeight(n11);
        }
        n11 = R$styleable.BottomSheetBehavior_Layout_behavior_hideable;
        n11 = (int)(attributeSet.getBoolean(n11, false) ? 1 : 0);
        this.setHideable(n11 != 0);
        n11 = R$styleable.BottomSheetBehavior_Layout_behavior_fitToContents;
        boolean bl3 = attributeSet.getBoolean(n11, bl2);
        this.setFitToContents(bl3);
        int n13 = R$styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed;
        boolean bl4 = attributeSet.getBoolean(n13, false);
        this.setSkipCollapsed(bl4);
        attributeSet.recycle();
        this.maximumVelocity = f10 = (float)ViewConfiguration.get((Context)context).getScaledMaximumFlingVelocity();
    }

    public static /* synthetic */ boolean access$000(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.fitToContents;
    }

    public static /* synthetic */ int access$100(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.getExpandedOffset();
    }

    private void calculateCollapsedOffset() {
        int n10 = this.fitToContents;
        if (n10 != 0) {
            n10 = this.parentHeight;
            int n11 = this.lastPeekHeight;
            n10 -= n11;
            n11 = this.fitToContentsOffset;
            this.collapsedOffset = n10 = Math.max(n10, n11);
        } else {
            n10 = this.parentHeight;
            int n12 = this.lastPeekHeight;
            this.collapsedOffset = n10 -= n12;
        }
    }

    public static BottomSheetBehavior from(View object) {
        boolean bl2 = (object = object.getLayoutParams()) instanceof CoordinatorLayout$LayoutParams;
        if (bl2) {
            bl2 = (object = ((CoordinatorLayout$LayoutParams)((Object)object)).getBehavior()) instanceof BottomSheetBehavior;
            if (bl2) {
                return (BottomSheetBehavior)object;
            }
            object = new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
            throw object;
        }
        object = new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        throw object;
    }

    private int getExpandedOffset() {
        int n10 = this.fitToContents;
        n10 = n10 != 0 ? this.fitToContentsOffset : 0;
        return n10;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        float f10 = this.maximumVelocity;
        velocityTracker.computeCurrentVelocity(1000, f10);
        velocityTracker = this.velocityTracker;
        int n10 = this.activePointerId;
        return velocityTracker.getYVelocity(n10);
    }

    private void reset() {
        int n10;
        this.activePointerId = n10 = -1;
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            n10 = 0;
            velocityTracker = null;
            this.velocityTracker = null;
        }
    }

    private void updateImportantForAccessibility(boolean bl2) {
        HashMap hashMap;
        int n10 = Build.VERSION.SDK_INT;
        Object object = this.viewRef;
        if (object == null) {
            return;
        }
        int n11 = (object = ((View)((Reference)object).get()).getParent()) instanceof CoordinatorLayout;
        if (n11 == 0) {
            return;
        }
        object = (CoordinatorLayout)object;
        n11 = object.getChildCount();
        int n12 = 16;
        if (n10 >= n12 && bl2) {
            hashMap = this.importantForAccessibilityMap;
            if (hashMap == null) {
                this.importantForAccessibilityMap = hashMap = new HashMap(n11);
            } else {
                return;
            }
        }
        hashMap = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13;
            Object object2;
            View view = object.getChildAt(i10);
            if (view == (object2 = this.viewRef.get())) continue;
            if (!bl2) {
                object2 = this.importantForAccessibilityMap;
                if (object2 == null || (n13 = (int)(object2.containsKey(view) ? 1 : 0)) == 0) continue;
                object2 = (Integer)this.importantForAccessibilityMap.get(view);
                n13 = (Integer)object2;
                ViewCompat.setImportantForAccessibility(view, n13);
                continue;
            }
            if (n10 >= n12) {
                object2 = this.importantForAccessibilityMap;
                int n14 = view.getImportantForAccessibility();
                Integer n15 = n14;
                object2.put((View)view, (Integer)n15);
            }
            n13 = 4;
            ViewCompat.setImportantForAccessibility(view, n13);
        }
        if (!bl2) {
            bl2 = false;
            this.importantForAccessibilityMap = null;
        }
    }

    public void dispatchOnSlide(int n10) {
        BottomSheetBehavior$BottomSheetCallback bottomSheetBehavior$BottomSheetCallback;
        View view = (View)this.viewRef.get();
        if (view != null && (bottomSheetBehavior$BottomSheetCallback = this.callback) != null) {
            int n11 = this.collapsedOffset;
            if (n10 > n11) {
                n10 = n11 - n10;
                float f10 = n10;
                int n12 = this.parentHeight - n11;
                float f11 = n12;
                bottomSheetBehavior$BottomSheetCallback.onSlide(view, f10 /= f11);
            } else {
                n10 = n11 - n10;
                float f12 = n10;
                int n13 = this.getExpandedOffset();
                float f13 = n11 -= n13;
                bottomSheetBehavior$BottomSheetCallback.onSlide(view, f12 /= f13);
            }
        }
    }

    public View findScrollingChild(View view) {
        int n10 = ViewCompat.isNestedScrollingEnabled(view);
        if (n10 != 0) {
            return view;
        }
        n10 = view instanceof ViewGroup;
        if (n10 != 0) {
            view = (ViewGroup)view;
            int n11 = view.getChildCount();
            for (n10 = 0; n10 < n11; ++n10) {
                View view2 = view.getChildAt(n10);
                if ((view2 = this.findScrollingChild(view2)) == null) continue;
                return view2;
            }
        }
        return null;
    }

    public final int getPeekHeight() {
        int n10 = this.peekHeightAuto;
        n10 = n10 != 0 ? -1 : this.peekHeight;
        return n10;
    }

    public int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public final int getState() {
        return this.state;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean onInterceptTouchEvent(CoordinatorLayout object, View object2, MotionEvent motionEvent) {
        float f10;
        Object object3;
        float f11;
        int n10;
        VelocityTracker velocityTracker;
        int n11;
        int n12;
        int n13;
        block17: {
            int n14;
            int n15;
            int n16;
            float f12;
            block15: {
                block16: {
                    n13 = object2.isShown();
                    n12 = 0;
                    n11 = 1;
                    f12 = Float.MIN_VALUE;
                    if (n13 == 0) {
                        this.ignoreEvents = n11;
                        return false;
                    }
                    n13 = motionEvent.getActionMasked();
                    if (n13 == 0) {
                        this.reset();
                    }
                    if ((velocityTracker = this.velocityTracker) == null) {
                        this.velocityTracker = velocityTracker = VelocityTracker.obtain();
                    }
                    this.velocityTracker.addMovement(motionEvent);
                    velocityTracker = null;
                    n16 = -1;
                    if (n13 == 0) break block15;
                    if (n13 == n11) break block16;
                    n10 = 3;
                    f11 = 4.2E-45f;
                    if (n13 != n10) break block17;
                }
                this.touchingScrollingChild = false;
                this.activePointerId = n16;
                n10 = (int)(this.ignoreEvents ? 1 : 0);
                if (n10 != 0) {
                    this.ignoreEvents = false;
                    return false;
                }
                break block17;
            }
            float f13 = motionEvent.getX();
            int n17 = (int)f13;
            float f14 = motionEvent.getY();
            this.initialY = n15 = (int)f14;
            WeakReference weakReference = this.nestedScrollingChildRef;
            if (weakReference != null) {
                weakReference = (View)weakReference.get();
            } else {
                n15 = 0;
                weakReference = null;
                f14 = 0.0f;
            }
            if (weakReference != null && (n15 = (int)(((CoordinatorLayout)object).isPointInChildBounds((View)weakReference, n17, n14 = this.initialY) ? 1 : 0)) != 0) {
                n15 = motionEvent.getActionIndex();
                this.activePointerId = n15 = motionEvent.getPointerId(n15);
                this.touchingScrollingChild = n11;
            }
            if ((n15 = this.activePointerId) == n16 && (n10 = (int)(((CoordinatorLayout)object).isPointInChildBounds((View)object2, n17, n16 = this.initialY) ? 1 : 0)) == 0) {
                n10 = n11;
                f11 = f12;
            } else {
                n10 = 0;
                object2 = null;
                f11 = 0.0f;
            }
            this.ignoreEvents = n10;
        }
        n10 = (int)(this.ignoreEvents ? 1 : 0);
        if (n10 == 0 && (object2 = this.viewDragHelper) != null && (n10 = (int)(((ViewDragHelper)object2).shouldInterceptTouchEvent(motionEvent) ? 1 : 0)) != 0) {
            return n11 != 0;
        }
        object2 = this.nestedScrollingChildRef;
        if (object2 != null) {
            object2 = ((Reference)object2).get();
            velocityTracker = object2;
            velocityTracker = object2;
        }
        n10 = 2;
        f11 = 2.8E-45f;
        if (n13 == n10 && velocityTracker != null && (n10 = (int)(this.ignoreEvents ? 1 : 0)) == 0 && (n10 = this.state) != n11 && (object3 = ((CoordinatorLayout)object).isPointInChildBounds((View)velocityTracker, n10 = (int)(f11 = motionEvent.getX()), n13 = (int)(f10 = motionEvent.getY()))) == 0 && (object = this.viewDragHelper) != null) {
            float f15 = this.initialY;
            f11 = motionEvent.getY();
            float f16 = (f15 = Math.abs(f15 - f11)) - (f11 = (float)(n10 = ((ViewDragHelper)(object2 = this.viewDragHelper)).getTouchSlop()));
            object3 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object3 > 0) {
                n12 = n11;
            }
        }
        return n12 != 0;
    }

    public boolean onLayoutChild(CoordinatorLayout weakReference, View view, int n10) {
        int n11;
        int n12;
        Object object;
        int n13 = ViewCompat.getFitsSystemWindows((View)weakReference);
        int n14 = 1;
        if (n13 != 0 && (n13 = ViewCompat.getFitsSystemWindows(view)) == 0) {
            view.setFitsSystemWindows(n14 != 0);
        }
        n13 = view.getTop();
        ((CoordinatorLayout)((Object)weakReference)).onLayoutChild(view, n10);
        this.parentHeight = n10 = weakReference.getHeight();
        n10 = (int)(this.peekHeightAuto ? 1 : 0);
        if (n10 != 0) {
            n10 = this.peekHeightMin;
            if (n10 == 0) {
                object = weakReference.getResources();
                n12 = R$dimen.design_bottom_sheet_peek_height_min;
                this.peekHeightMin = n10 = object.getDimensionPixelSize(n12);
            }
            n10 = this.peekHeightMin;
            n12 = this.parentHeight;
            n11 = weakReference.getWidth() * 9 / 16;
            this.lastPeekHeight = n10 = Math.max(n10, n12 -= n11);
        } else {
            this.lastPeekHeight = n10 = this.peekHeight;
        }
        object = null;
        n12 = this.parentHeight;
        n11 = view.getHeight();
        this.fitToContentsOffset = n10 = Math.max(0, n12 -= n11);
        n10 = this.parentHeight;
        n12 = 2;
        this.halfExpandedOffset = n10 /= n12;
        this.calculateCollapsedOffset();
        n10 = this.state;
        n11 = 3;
        if (n10 == n11) {
            n10 = this.getExpandedOffset();
            ViewCompat.offsetTopAndBottom(view, n10);
        } else {
            n11 = 6;
            if (n10 == n11) {
                n10 = this.halfExpandedOffset;
                ViewCompat.offsetTopAndBottom(view, n10);
            } else {
                n11 = (int)(this.hideable ? 1 : 0);
                if (n11 != 0 && n10 == (n11 = 5)) {
                    n10 = this.parentHeight;
                    ViewCompat.offsetTopAndBottom(view, n10);
                } else {
                    n11 = 4;
                    if (n10 == n11) {
                        n10 = this.collapsedOffset;
                        ViewCompat.offsetTopAndBottom(view, n10);
                    } else if (n10 == n14 || n10 == n12) {
                        n10 = view.getTop();
                        ViewCompat.offsetTopAndBottom(view, n13 -= n10);
                    }
                }
            }
        }
        object = this.viewDragHelper;
        if (object == null) {
            object = this.dragCallback;
            weakReference = ViewDragHelper.create(weakReference, (ViewDragHelper$Callback)object);
            this.viewDragHelper = weakReference;
        }
        weakReference = new WeakReference<View>(view);
        this.viewRef = weakReference;
        view = this.findScrollingChild(view);
        this.nestedScrollingChildRef = weakReference = new WeakReference<View>(view);
        return n14 != 0;
    }

    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, View view, View view2, float f10, float f11) {
        boolean bl2;
        int n10;
        int n11;
        Object t10 = this.nestedScrollingChildRef.get();
        if (view2 == t10 && ((n11 = this.state) != (n10 = 3) || (bl2 = super.onNestedPreFling(coordinatorLayout, view, view2, f10, f11)))) {
            bl2 = true;
        } else {
            bl2 = false;
            coordinatorLayout = null;
        }
        return bl2;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int[] nArray, int n12) {
        int n13;
        int n14;
        int n15 = 1;
        if (n12 == n15) {
            return;
        }
        View view3 = (View)this.nestedScrollingChildRef.get();
        if (view2 != view3) {
            return;
        }
        n10 = view.getTop();
        n12 = n10 - n11;
        if (n11 > 0) {
            int n16 = this.getExpandedOffset();
            if (n12 < n16) {
                n16 = this.getExpandedOffset();
                nArray[n15] = n10 -= n16;
                n16 = -nArray[n15];
                ViewCompat.offsetTopAndBottom(view, n16);
                n16 = 3;
                this.setStateInternal(n16);
            } else {
                nArray[n15] = n11;
                n16 = -n11;
                ViewCompat.offsetTopAndBottom(view, n16);
                this.setStateInternal(n15);
            }
        } else if (n11 < 0 && (n14 = view2.canScrollVertically(n13 = -1)) == 0) {
            n14 = this.collapsedOffset;
            if (n12 > n14 && (n12 = (int)(this.hideable ? 1 : 0)) == 0) {
                nArray[n15] = n10 -= n14;
                n14 = -nArray[n15];
                ViewCompat.offsetTopAndBottom(view, n14);
                n14 = 4;
                this.setStateInternal(n14);
            } else {
                nArray[n15] = n11;
                n14 = -n11;
                ViewCompat.offsetTopAndBottom(view, n14);
                this.setStateInternal(n15);
            }
        }
        int n17 = view.getTop();
        this.dispatchOnSlide(n17);
        this.lastNestedScrollDy = n11;
        this.nestedScrolled = n15;
    }

    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
        parcelable = (BottomSheetBehavior$SavedState)parcelable;
        Parcelable parcelable2 = parcelable.getSuperState();
        super.onRestoreInstanceState(coordinatorLayout, view, parcelable2);
        int n10 = parcelable.state;
        int n11 = 1;
        this.state = n10 != n11 && n10 != (n11 = 2) ? n10 : (n10 = 4);
    }

    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, View view) {
        coordinatorLayout = super.onSaveInstanceState(coordinatorLayout, view);
        int n10 = this.state;
        BottomSheetBehavior$SavedState bottomSheetBehavior$SavedState = new BottomSheetBehavior$SavedState((Parcelable)coordinatorLayout, n10);
        return bottomSheetBehavior$SavedState;
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10, int n11) {
        boolean bl2 = false;
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        int n12 = n10 & 2;
        if (n12 != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void onStopNestedScroll(CoordinatorLayout object, View view, View view2, int n10) {
        block3: {
            int n11;
            float f10;
            int n12;
            int n13;
            block5: {
                block10: {
                    block7: {
                        block14: {
                            int n14;
                            block13: {
                                block11: {
                                    block12: {
                                        block8: {
                                            block9: {
                                                block6: {
                                                    block4: {
                                                        n13 = view.getTop();
                                                        n10 = this.getExpandedOffset();
                                                        n12 = 3;
                                                        if (n13 == n10) {
                                                            this.setStateInternal(n12);
                                                            return;
                                                        }
                                                        object = this.nestedScrollingChildRef.get();
                                                        if (view2 != object || (n13 = (int)(this.nestedScrolled ? 1 : 0)) == 0) break block3;
                                                        n13 = this.lastNestedScrollDy;
                                                        view2 = null;
                                                        n10 = 4;
                                                        if (n13 <= 0) break block4;
                                                        n13 = this.getExpandedOffset();
                                                        break block5;
                                                    }
                                                    n13 = (int)(this.hideable ? 1 : 0);
                                                    if (n13 == 0 || (n13 = (int)(this.shouldHide(view, f10 = this.getYVelocity()) ? 1 : 0)) == 0) break block6;
                                                    n13 = this.parentHeight;
                                                    n12 = 5;
                                                    break block5;
                                                }
                                                n13 = this.lastNestedScrollDy;
                                                if (n13 != 0) break block7;
                                                n13 = view.getTop();
                                                n11 = (int)(this.fitToContents ? 1 : 0);
                                                n14 = 6;
                                                if (n11 == 0) break block8;
                                                n11 = this.fitToContentsOffset;
                                                if ((n11 = Math.abs(n13 - n11)) >= (n13 = Math.abs(n13 - (n14 = this.collapsedOffset)))) break block9;
                                                n13 = this.fitToContentsOffset;
                                                break block5;
                                            }
                                            n13 = this.collapsedOffset;
                                            break block10;
                                        }
                                        n11 = this.halfExpandedOffset;
                                        if (n13 >= n11) break block11;
                                        n10 = this.collapsedOffset;
                                        if (n13 >= (n10 = Math.abs(n13 - n10))) break block12;
                                        n13 = 0;
                                        object = null;
                                        f10 = 0.0f;
                                        break block5;
                                    }
                                    n13 = this.halfExpandedOffset;
                                    break block13;
                                }
                                n12 = Math.abs(n13 - n11);
                                if (n12 >= (n13 = Math.abs(n13 - (n11 = this.collapsedOffset)))) break block14;
                                n13 = this.halfExpandedOffset;
                            }
                            n12 = n14;
                            break block5;
                        }
                        n13 = this.collapsedOffset;
                        break block10;
                    }
                    n13 = this.collapsedOffset;
                }
                n12 = n10;
            }
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            n11 = view.getLeft();
            n13 = (int)(viewDragHelper.smoothSlideViewTo(view, n11, n13) ? 1 : 0);
            if (n13 != 0) {
                n13 = 2;
                f10 = 2.8E-45f;
                this.setStateInternal(n13);
                object = new BottomSheetBehavior$SettleRunnable(this, view, n12);
                ViewCompat.postOnAnimation(view, (Runnable)object);
            } else {
                this.setStateInternal(n12);
            }
            this.nestedScrolled = false;
        }
    }

    public boolean onTouchEvent(CoordinatorLayout object, View view, MotionEvent motionEvent) {
        int n10 = view.isShown();
        if (n10 == 0) {
            return false;
        }
        n10 = motionEvent.getActionMasked();
        int n11 = this.state;
        int n12 = 1;
        if (n11 == n12 && n10 == 0) {
            return n12 != 0;
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
        }
        if (n10 == 0) {
            this.reset();
        }
        if ((viewDragHelper = this.velocityTracker) == null) {
            viewDragHelper = VelocityTracker.obtain();
            this.velocityTracker = viewDragHelper;
        }
        viewDragHelper = this.velocityTracker;
        viewDragHelper.addMovement(motionEvent);
        n11 = 2;
        float f10 = 2.8E-45f;
        if (n10 == n11 && (n10 = (int)(this.ignoreEvents ? 1 : 0)) == 0) {
            float f11 = this.initialY;
            f10 = motionEvent.getY();
            float f12 = (f11 = Math.abs(f11 - f10)) - (f10 = (float)(n11 = (viewDragHelper = this.viewDragHelper).getTouchSlop()));
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n10 > 0) {
                object = this.viewDragHelper;
                n11 = motionEvent.getActionIndex();
                int n13 = motionEvent.getPointerId(n11);
                ((ViewDragHelper)object).captureChildView(view, n13);
            }
        }
        return (this.ignoreEvents ^ n12) != 0;
    }

    public void setBottomSheetCallback(BottomSheetBehavior$BottomSheetCallback bottomSheetBehavior$BottomSheetCallback) {
        this.callback = bottomSheetBehavior$BottomSheetCallback;
    }

    public void setFitToContents(boolean n10) {
        int n11 = this.fitToContents;
        if (n11 == n10) {
            return;
        }
        this.fitToContents = n10;
        WeakReference weakReference = this.viewRef;
        if (weakReference != null) {
            this.calculateCollapsedOffset();
        }
        n10 = (n10 = this.fitToContents) != 0 && (n10 = this.state) == (n11 = 6) ? 3 : this.state;
        this.setStateInternal(n10);
    }

    public void setHideable(boolean bl2) {
        this.hideable = bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void setPeekHeight(int n10) {
        int n11 = 1;
        int n12 = 0;
        int n13 = -1;
        if (n10 == n13) {
            n10 = (int)(this.peekHeightAuto ? 1 : 0);
            if (n10 != 0) return;
            this.peekHeightAuto = n11;
        } else {
            n13 = (int)(this.peekHeightAuto ? 1 : 0);
            if (n13 == 0) {
                n13 = this.peekHeight;
                if (n13 == n10) return;
            }
            this.peekHeightAuto = false;
            this.peekHeight = n12 = Math.max(0, n10);
            this.collapsedOffset = n12 = this.parentHeight - n10;
        }
        if (n11 == 0) return;
        n10 = this.state;
        n11 = 4;
        if (n10 != n11) return;
        WeakReference weakReference = this.viewRef;
        if (weakReference == null) return;
        if ((weakReference = (View)weakReference.get()) == null) return;
        weakReference.requestLayout();
    }

    public void setSkipCollapsed(boolean bl2) {
        this.skipCollapsed = bl2;
    }

    public final void setState(int n10) {
        boolean bl2;
        int n11 = this.state;
        if (n10 == n11) {
            return;
        }
        WeakReference weakReference = this.viewRef;
        if (weakReference == null) {
            n11 = 4;
            if (n10 == n11 || n10 == (n11 = 3) || n10 == (n11 = 6) || (n11 = (int)(this.hideable ? 1 : 0)) != 0 && n10 == (n11 = 5)) {
                this.state = n10;
            }
            return;
        }
        if ((weakReference = (View)weakReference.get()) == null) {
            return;
        }
        Object object = weakReference.getParent();
        if (object != null && (bl2 = object.isLayoutRequested()) && (bl2 = ViewCompat.isAttachedToWindow((View)weakReference))) {
            object = new BottomSheetBehavior$1(this, (View)weakReference, n10);
            weakReference.post((Runnable)object);
        } else {
            this.startSettlingAnimation((View)weakReference, n10);
        }
    }

    public void setStateInternal(int n10) {
        BottomSheetBehavior$BottomSheetCallback bottomSheetBehavior$BottomSheetCallback;
        View view;
        int n11 = this.state;
        if (n11 == n10) {
            return;
        }
        this.state = n10;
        n11 = 6;
        if (n10 != n11 && n10 != (n11 = 3)) {
            n11 = 5;
            if (n10 == n11 || n10 == (n11 = 4)) {
                n11 = 0;
                view = null;
                this.updateImportantForAccessibility(false);
            }
        } else {
            n11 = 1;
            this.updateImportantForAccessibility(n11 != 0);
        }
        if ((view = (View)this.viewRef.get()) != null && (bottomSheetBehavior$BottomSheetCallback = this.callback) != null) {
            bottomSheetBehavior$BottomSheetCallback.onStateChanged(view, n10);
        }
    }

    public boolean shouldHide(View view, float f10) {
        int n10;
        int n11 = this.skipCollapsed;
        boolean bl2 = true;
        if (n11 != 0) {
            return bl2;
        }
        n11 = view.getTop();
        if (n11 < (n10 = this.collapsedOffset)) {
            return false;
        }
        float f11 = view.getTop();
        n11 = 0x3DCCCCCD;
        float f12 = 0.1f;
        f11 += (f10 *= f12);
        f10 = this.collapsedOffset;
        f11 = Math.abs(f11 - f10);
        f10 = this.peekHeight;
        float f13 = (f11 /= f10) - (f10 = 0.5f);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public void startSettlingAnimation(View object, int n10) {
        block11: {
            int n11;
            int n12;
            block8: {
                block10: {
                    block9: {
                        int n13;
                        block7: {
                            n12 = 3;
                            n13 = 4;
                            if (n10 != n13) break block7;
                            n12 = this.collapsedOffset;
                            break block8;
                        }
                        n13 = 6;
                        if (n10 != n13) break block9;
                        n13 = this.halfExpandedOffset;
                        n11 = (int)(this.fitToContents ? 1 : 0);
                        if (n11 != 0 && n13 <= (n11 = this.fitToContentsOffset)) {
                            n10 = n12;
                            n12 = n11;
                        } else {
                            n12 = n13;
                        }
                        break block8;
                    }
                    if (n10 != n12) break block10;
                    n12 = this.getExpandedOffset();
                    break block8;
                }
                n12 = (int)(this.hideable ? 1 : 0);
                if (n12 == 0 || n10 != (n12 = 5)) break block11;
                n12 = this.parentHeight;
            }
            ViewDragHelper viewDragHelper = this.viewDragHelper;
            n11 = object.getLeft();
            n12 = (int)(viewDragHelper.smoothSlideViewTo((View)object, n11, n12) ? 1 : 0);
            if (n12 != 0) {
                n12 = 2;
                this.setStateInternal(n12);
                BottomSheetBehavior$SettleRunnable bottomSheetBehavior$SettleRunnable = new BottomSheetBehavior$SettleRunnable(this, (View)object, n10);
                ViewCompat.postOnAnimation(object, bottomSheetBehavior$SettleRunnable);
            } else {
                this.setStateInternal(n10);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Illegal state argument: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

