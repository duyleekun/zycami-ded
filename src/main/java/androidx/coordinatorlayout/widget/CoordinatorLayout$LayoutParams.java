/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 */
package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.R$styleable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

public class CoordinatorLayout$LayoutParams
extends ViewGroup.MarginLayoutParams {
    public int anchorGravity;
    public int dodgeInsetEdges;
    public int gravity;
    public int insetEdge;
    public int keyline;
    public View mAnchorDirectChild;
    public int mAnchorId;
    public View mAnchorView;
    public CoordinatorLayout$Behavior mBehavior;
    public boolean mBehaviorResolved;
    public Object mBehaviorTag;
    private boolean mDidAcceptNestedScrollNonTouch;
    private boolean mDidAcceptNestedScrollTouch;
    private boolean mDidBlockInteraction;
    private boolean mDidChangeAfterNestedScroll;
    public int mInsetOffsetX;
    public int mInsetOffsetY;
    public final Rect mLastChildRect;

    public CoordinatorLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
        Rect rect;
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = n11 = -1;
        this.mAnchorId = n11;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = rect = new Rect();
    }

    public CoordinatorLayout$LayoutParams(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        int n10;
        Object object2;
        int n11;
        String string2 = null;
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = n11 = -1;
        this.mAnchorId = n11;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        this.mLastChildRect = object2 = new Rect();
        object2 = R$styleable.CoordinatorLayout_Layout;
        object2 = object.obtainStyledAttributes(attributeSet, (int[])object2);
        int n12 = R$styleable.CoordinatorLayout_Layout_android_layout_gravity;
        this.gravity = n12 = object2.getInteger(n12, 0);
        n12 = R$styleable.CoordinatorLayout_Layout_layout_anchor;
        this.mAnchorId = n12 = object2.getResourceId(n12, n11);
        n12 = R$styleable.CoordinatorLayout_Layout_layout_anchorGravity;
        this.anchorGravity = n12 = object2.getInteger(n12, 0);
        n12 = R$styleable.CoordinatorLayout_Layout_layout_keyline;
        this.keyline = n11 = object2.getInteger(n12, n11);
        n11 = R$styleable.CoordinatorLayout_Layout_layout_insetEdge;
        this.insetEdge = n11 = object2.getInt(n11, 0);
        n11 = R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges;
        this.dodgeInsetEdges = n10 = object2.getInt(n11, 0);
        n10 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
        n11 = (int)(object2.hasValue(n10) ? 1 : 0);
        this.mBehaviorResolved = n11;
        if (n11 != 0) {
            string2 = object2.getString(n10);
            object = CoordinatorLayout.parseBehavior(object, attributeSet, string2);
            this.mBehavior = object;
        }
        object2.recycle();
        object = this.mBehavior;
        if (object != null) {
            object.onAttachedToLayoutParams(this);
        }
    }

    public CoordinatorLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        int n10;
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = n10 = -1;
        this.mAnchorId = n10;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        super();
        this.mLastChildRect = layoutParams;
    }

    public CoordinatorLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        int n10;
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = n10 = -1;
        this.mAnchorId = n10;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        super();
        this.mLastChildRect = marginLayoutParams;
    }

    public CoordinatorLayout$LayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        super((ViewGroup.MarginLayoutParams)coordinatorLayout$LayoutParams);
        int n10;
        this.mBehaviorResolved = false;
        this.gravity = 0;
        this.anchorGravity = 0;
        this.keyline = n10 = -1;
        this.mAnchorId = n10;
        this.insetEdge = 0;
        this.dodgeInsetEdges = 0;
        super();
        this.mLastChildRect = coordinatorLayout$LayoutParams;
    }

    private void resolveAnchorView(View object, CoordinatorLayout object2) {
        Object object3;
        int n10 = this.mAnchorId;
        this.mAnchorView = object3 = object2.findViewById(n10);
        StringBuilder stringBuilder = null;
        if (object3 != null) {
            if (object3 == object2) {
                boolean bl2 = object2.isInEditMode();
                if (bl2) {
                    this.mAnchorDirectChild = null;
                    this.mAnchorView = null;
                    return;
                }
                object = new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                throw object;
            }
            for (ViewParent viewParent = object3.getParent(); viewParent != object2 && viewParent != null; viewParent = viewParent.getParent()) {
                if (viewParent == object) {
                    boolean bl3 = object2.isInEditMode();
                    if (bl3) {
                        this.mAnchorDirectChild = null;
                        this.mAnchorView = null;
                        return;
                    }
                    object = new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    throw object;
                }
                boolean bl4 = viewParent instanceof View;
                if (!bl4) continue;
                object3 = viewParent;
                object3 = (View)viewParent;
            }
            this.mAnchorDirectChild = object3;
            return;
        }
        n10 = (int)(object2.isInEditMode() ? 1 : 0);
        if (n10 != 0) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Could not find CoordinatorLayout descendant view with id ");
        object2 = object2.getResources();
        int n11 = this.mAnchorId;
        object2 = object2.getResourceName(n11);
        stringBuilder.append((String)object2);
        stringBuilder.append(" to anchor view ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    private boolean shouldDodge(View object, int n10) {
        int n11;
        object = (CoordinatorLayout$LayoutParams)object.getLayoutParams();
        int n12 = GravityCompat.getAbsoluteGravity(object.insetEdge, n10);
        if (n12 != 0 && (n10 = GravityCompat.getAbsoluteGravity(n11 = this.dodgeInsetEdges, n10) & n12) == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            object = null;
        }
        return n12 != 0;
    }

    private boolean verifyAnchorView(View view, CoordinatorLayout coordinatorLayout) {
        int n10;
        View view2 = this.mAnchorView;
        int n11 = view2.getId();
        if (n11 != (n10 = this.mAnchorId)) {
            return false;
        }
        view2 = this.mAnchorView;
        for (ViewParent viewParent = view2.getParent(); viewParent != coordinatorLayout; viewParent = viewParent.getParent()) {
            if (viewParent != null && viewParent != view) {
                boolean bl2 = viewParent instanceof View;
                if (!bl2) continue;
                view2 = viewParent;
                view2 = (View)viewParent;
                continue;
            }
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return false;
        }
        this.mAnchorDirectChild = view2;
        return true;
    }

    public boolean checkAnchorChanged() {
        int n10;
        int n11;
        View view = this.mAnchorView;
        if (view == null && (n11 = this.mAnchorId) != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            view = null;
        }
        return n11 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean dependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        Object object = this.mAnchorDirectChild;
        if (view2 == object) return true;
        int n10 = ViewCompat.getLayoutDirection((View)coordinatorLayout);
        if ((n10 = (int)(this.shouldDodge(view2, n10) ? 1 : 0)) != 0) return true;
        object = this.mBehavior;
        if (object == null) return false;
        boolean bl2 = ((CoordinatorLayout$Behavior)object).layoutDependsOn(coordinatorLayout, view, view2);
        if (!bl2) return false;
        return true;
    }

    public boolean didBlockInteraction() {
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = this.mBehavior;
        if (coordinatorLayout$Behavior == null) {
            coordinatorLayout$Behavior = null;
            this.mDidBlockInteraction = false;
        }
        return this.mDidBlockInteraction;
    }

    public View findAnchorView(CoordinatorLayout coordinatorLayout, View view) {
        int n10 = this.mAnchorId;
        int n11 = -1;
        if (n10 == n11) {
            this.mAnchorDirectChild = null;
            this.mAnchorView = null;
            return null;
        }
        View view2 = this.mAnchorView;
        if (view2 == null || (n10 = (int)(this.verifyAnchorView(view, coordinatorLayout) ? 1 : 0)) == 0) {
            this.resolveAnchorView(view, coordinatorLayout);
        }
        return this.mAnchorView;
    }

    public int getAnchorId() {
        return this.mAnchorId;
    }

    public CoordinatorLayout$Behavior getBehavior() {
        return this.mBehavior;
    }

    public boolean getChangedAfterNestedScroll() {
        return this.mDidChangeAfterNestedScroll;
    }

    public Rect getLastChildRect() {
        return this.mLastChildRect;
    }

    public void invalidateAnchor() {
        this.mAnchorDirectChild = null;
        this.mAnchorView = null;
    }

    public boolean isBlockingInteractionBelow(CoordinatorLayout coordinatorLayout, View view) {
        boolean bl2;
        boolean bl3 = this.mDidBlockInteraction;
        if (bl3) {
            return true;
        }
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = this.mBehavior;
        if (coordinatorLayout$Behavior != null) {
            bl2 = coordinatorLayout$Behavior.blocksInteractionBelow(coordinatorLayout, view);
        } else {
            bl2 = false;
            coordinatorLayout = null;
        }
        this.mDidBlockInteraction = bl2 |= bl3;
        return bl2;
    }

    public boolean isNestedScrollAccepted(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return false;
            }
            return this.mDidAcceptNestedScrollNonTouch;
        }
        return this.mDidAcceptNestedScrollTouch;
    }

    public void resetChangedAfterNestedScroll() {
        this.mDidChangeAfterNestedScroll = false;
    }

    public void resetNestedScroll(int n10) {
        this.setNestedScrollAccepted(n10, false);
    }

    public void resetTouchBehaviorTracking() {
        this.mDidBlockInteraction = false;
    }

    public void setAnchorId(int n10) {
        this.invalidateAnchor();
        this.mAnchorId = n10;
    }

    public void setBehavior(CoordinatorLayout$Behavior coordinatorLayout$Behavior) {
        CoordinatorLayout$Behavior coordinatorLayout$Behavior2 = this.mBehavior;
        if (coordinatorLayout$Behavior2 != coordinatorLayout$Behavior) {
            boolean bl2;
            if (coordinatorLayout$Behavior2 != null) {
                coordinatorLayout$Behavior2.onDetachedFromLayoutParams();
            }
            this.mBehavior = coordinatorLayout$Behavior;
            coordinatorLayout$Behavior2 = null;
            this.mBehaviorTag = null;
            this.mBehaviorResolved = bl2 = true;
            if (coordinatorLayout$Behavior != null) {
                coordinatorLayout$Behavior.onAttachedToLayoutParams(this);
            }
        }
    }

    public void setChangedAfterNestedScroll(boolean bl2) {
        this.mDidChangeAfterNestedScroll = bl2;
    }

    public void setLastChildRect(Rect rect) {
        this.mLastChildRect.set(rect);
    }

    public void setNestedScrollAccepted(int n10, boolean bl2) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                this.mDidAcceptNestedScrollNonTouch = bl2;
            }
        } else {
            this.mDidAcceptNestedScrollTouch = bl2;
        }
    }
}

