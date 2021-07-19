/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

public class FloatingActionButton$BaseBehavior
extends CoordinatorLayout$Behavior {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean autoHideEnabled;
    private FloatingActionButton$OnVisibilityChangedListener internalAutoHideListener;
    private Rect tmpRect;

    public FloatingActionButton$BaseBehavior() {
        this.autoHideEnabled = true;
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.FloatingActionButton_Behavior_Layout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide;
        n10 = (int)(context.getBoolean(n10, true) ? 1 : 0);
        this.autoHideEnabled = n10;
        context.recycle();
    }

    private static boolean isBottomSheet(View view) {
        boolean bl2 = (view = view.getLayoutParams()) instanceof CoordinatorLayout$LayoutParams;
        if (bl2) {
            return ((CoordinatorLayout$LayoutParams)view).getBehavior() instanceof BottomSheetBehavior;
        }
        return false;
    }

    private void offsetIfNeeded(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
        int n10;
        Rect rect = floatingActionButton.shadowPadding;
        if (rect != null && (n10 = rect.centerX()) > 0 && (n10 = rect.centerY()) > 0) {
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)floatingActionButton.getLayoutParams();
            int n11 = floatingActionButton.getRight();
            int n12 = coordinatorLayout.getWidth();
            int n13 = coordinatorLayout$LayoutParams.rightMargin;
            n12 -= n13;
            n13 = 0;
            n11 = n11 >= n12 ? rect.right : ((n11 = floatingActionButton.getLeft()) <= (n12 = coordinatorLayout$LayoutParams.leftMargin) ? -rect.left : 0);
            n12 = floatingActionButton.getBottom();
            int n14 = coordinatorLayout.getHeight();
            int n15 = coordinatorLayout$LayoutParams.bottomMargin;
            if (n12 >= (n14 -= n15)) {
                n13 = rect.bottom;
            } else {
                n14 = floatingActionButton.getTop();
                if (n14 <= (n10 = coordinatorLayout$LayoutParams.topMargin)) {
                    n14 = rect.top;
                    n13 = -n14;
                }
            }
            if (n13 != 0) {
                ViewCompat.offsetTopAndBottom((View)floatingActionButton, n13);
            }
            if (n11 != 0) {
                ViewCompat.offsetLeftAndRight((View)floatingActionButton, n11);
            }
        }
    }

    private boolean shouldUpdateVisibility(View view, FloatingActionButton floatingActionButton) {
        int n10;
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)floatingActionButton.getLayoutParams();
        boolean bl2 = this.autoHideEnabled;
        if (!bl2) {
            return false;
        }
        int n11 = coordinatorLayout$LayoutParams.getAnchorId();
        if (n11 != (n10 = view.getId())) {
            return false;
        }
        n10 = floatingActionButton.getUserSetVisibility();
        return n10 == 0;
    }

    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout object, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
        boolean bl2 = this.shouldUpdateVisibility((View)appBarLayout, floatingActionButton);
        if (!bl2) {
            return false;
        }
        Rect rect = this.tmpRect;
        if (rect == null) {
            this.tmpRect = rect = new Rect();
        }
        rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect((ViewGroup)object, (View)appBarLayout, rect);
        int n10 = rect.bottom;
        int n11 = appBarLayout.getMinimumHeightForVisibleOverlappingContent();
        if (n10 <= n11) {
            object = this.internalAutoHideListener;
            floatingActionButton.hide((FloatingActionButton$OnVisibilityChangedListener)object, false);
        } else {
            object = this.internalAutoHideListener;
            floatingActionButton.show((FloatingActionButton$OnVisibilityChangedListener)object, false);
        }
        return true;
    }

    private boolean updateFabVisibilityForBottomSheet(View object, FloatingActionButton floatingActionButton) {
        int n10 = this.shouldUpdateVisibility((View)object, floatingActionButton);
        if (n10 == 0) {
            return false;
        }
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)floatingActionButton.getLayoutParams();
        int n11 = object.getTop();
        int n12 = floatingActionButton.getHeight() / 2;
        n10 = coordinatorLayout$LayoutParams.topMargin;
        if (n11 < (n12 += n10)) {
            object = this.internalAutoHideListener;
            floatingActionButton.hide((FloatingActionButton$OnVisibilityChangedListener)object, false);
        } else {
            object = this.internalAutoHideListener;
            floatingActionButton.show((FloatingActionButton$OnVisibilityChangedListener)object, false);
        }
        return true;
    }

    public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
        coordinatorLayout = floatingActionButton.shadowPadding;
        int n10 = floatingActionButton.getLeft();
        int n11 = ((Rect)coordinatorLayout).left;
        n10 += n11;
        n11 = floatingActionButton.getTop();
        int n12 = ((Rect)coordinatorLayout).top;
        n11 += n12;
        n12 = floatingActionButton.getRight();
        int n13 = ((Rect)coordinatorLayout).right;
        int n14 = floatingActionButton.getBottom();
        int n15 = ((Rect)coordinatorLayout).bottom;
        rect.set(n10, n11, n12 -= n13, n14 -= n15);
        return true;
    }

    public boolean isAutoHideEnabled() {
        return this.autoHideEnabled;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        int n10 = coordinatorLayout$LayoutParams.dodgeInsetEdges;
        if (n10 == 0) {
            coordinatorLayout$LayoutParams.dodgeInsetEdges = n10 = 80;
        }
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View object) {
        boolean bl2 = object instanceof AppBarLayout;
        if (bl2) {
            object = (AppBarLayout)((Object)object);
            this.updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout)((Object)object), floatingActionButton);
        } else {
            boolean bl3 = FloatingActionButton$BaseBehavior.isBottomSheet(object);
            if (bl3) {
                this.updateFabVisibilityForBottomSheet((View)object, floatingActionButton);
            }
        }
        return false;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int n10) {
        boolean bl2;
        Object object;
        boolean bl3;
        List list = coordinatorLayout.getDependencies((View)floatingActionButton);
        int n11 = list.size();
        for (int i10 = 0; i10 < n11 && !((bl3 = (object = (View)list.get(i10)) instanceof AppBarLayout) ? (bl2 = this.updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout)((Object)(object = (AppBarLayout)((Object)object))), floatingActionButton)) : (bl3 = FloatingActionButton$BaseBehavior.isBottomSheet(object)) && (bl2 = this.updateFabVisibilityForBottomSheet((View)object, floatingActionButton))); ++i10) {
        }
        coordinatorLayout.onLayoutChild((View)floatingActionButton, n10);
        this.offsetIfNeeded(coordinatorLayout, floatingActionButton);
        return true;
    }

    public void setAutoHideEnabled(boolean bl2) {
        this.autoHideEnabled = bl2;
    }

    public void setInternalAutoHideListener(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        this.internalAutoHideListener = floatingActionButton$OnVisibilityChangedListener;
    }
}

