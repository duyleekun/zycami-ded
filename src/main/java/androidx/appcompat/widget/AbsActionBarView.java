/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources$Theme
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.AbsActionBarView$1;
import androidx.appcompat.widget.AbsActionBarView$VisibilityAnimListener;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

public abstract class AbsActionBarView
extends ViewGroup {
    private static final int FADE_DURATION = 200;
    public ActionMenuPresenter mActionMenuPresenter;
    public int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    public ActionMenuView mMenuView;
    public final Context mPopupContext;
    public final AbsActionBarView$VisibilityAnimListener mVisAnimListener;
    public ViewPropertyAnimatorCompat mVisibilityAnim;

    public AbsActionBarView(Context context) {
        this(context, null);
    }

    public AbsActionBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsActionBarView(Context context, AttributeSet object, int n10) {
        super(context, object, n10);
        super(this);
        this.mVisAnimListener = object;
        super();
        Resources.Theme theme = context.getTheme();
        int n11 = R$attr.actionBarPopupTheme;
        boolean bl2 = true;
        n10 = theme.resolveAttribute(n11, (TypedValue)object, bl2) ? 1 : 0;
        if (n10 != 0 && (n10 = object.resourceId) != 0) {
            int n12 = object.resourceId;
            super(context, n12);
            this.mPopupContext = theme;
        } else {
            this.mPopupContext = context;
        }
    }

    public static /* synthetic */ void access$001(AbsActionBarView absActionBarView, int n10) {
        super.setVisibility(n10);
    }

    public static /* synthetic */ void access$101(AbsActionBarView absActionBarView, int n10) {
        super.setVisibility(n10);
    }

    public static int next(int n10, int n11, boolean bl2) {
        n10 = bl2 ? (n10 -= n11) : (n10 += n11);
        return n10;
    }

    public void animateToVisibility(int n10) {
        this.setupAnimatorToVisibility(n10, 200L).start();
    }

    public boolean canShowOverflowMenu() {
        boolean bl2 = this.isOverflowReserved();
        bl2 = bl2 && !(bl2 = this.getVisibility());
        return bl2;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.dismissPopupMenus();
        }
    }

    public int getAnimatedVisibility() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            return this.mVisAnimListener.mFinalVisibility;
        }
        return this.getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowPending();
        }
        return false;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isOverflowReserved() {
        boolean bl2;
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null && (bl2 = actionMenuPresenter.isOverflowReserved())) {
            bl2 = true;
        } else {
            bl2 = false;
            actionMenuPresenter = null;
        }
        return bl2;
    }

    public int measureChildView(View view, int n10, int n11, int n12) {
        int n13 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)(-1 << -1));
        view.measure(n13, n11);
        int n14 = view.getMeasuredWidth();
        n10 = n10 - n14 - n12;
        return Math.max(0, n10);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Object object = this.getContext();
        int[] nArray = R$styleable.ActionBar;
        int n10 = R$attr.actionBarStyle;
        object = object.obtainStyledAttributes(null, nArray, n10, 0);
        int n11 = R$styleable.ActionBar_height;
        n11 = object.getLayoutDimension(n11, 0);
        this.setContentHeight(n11);
        object.recycle();
        object = this.mActionMenuPresenter;
        if (object != null) {
            ((ActionMenuPresenter)object).onConfigurationChanged(configuration);
        }
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int n10;
        int n11;
        int n12 = motionEvent.getActionMasked();
        if (n12 == (n11 = 9)) {
            this.mEatingHover = false;
        }
        boolean bl2 = this.mEatingHover;
        boolean bl3 = true;
        if (!bl2) {
            n10 = super.onHoverEvent(motionEvent) ? 1 : 0;
            if (n12 == n11 && n10 == 0) {
                this.mEatingHover = bl3;
            }
        }
        if (n12 == (n10 = 10) || n12 == (n10 = 3)) {
            this.mEatingHover = false;
        }
        return bl3;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getActionMasked();
        if (!n11) {
            this.mEatingTouch = false;
        }
        boolean bl2 = this.mEatingTouch;
        int n12 = 1;
        if (!bl2) {
            n10 = super.onTouchEvent(motionEvent);
            if (!n11 && !n10) {
                this.mEatingTouch = n12;
            }
        }
        if (n11 == n12 || n11 == (n10 = 3)) {
            this.mEatingTouch = false;
        }
        return n12 != 0;
    }

    public int positionChild(View view, int n10, int n11, int n12, boolean bl2) {
        int n13 = view.getMeasuredWidth();
        int n14 = view.getMeasuredHeight();
        n12 = (n12 - n14) / 2;
        n11 += n12;
        if (bl2) {
            n12 = n10 - n13;
            view.layout(n12, n11, n10, n14 += n11);
        } else {
            n12 = n10 + n13;
            view.layout(n10, n11, n12, n14 += n11);
        }
        if (bl2) {
            n13 = -n13;
        }
        return n13;
    }

    public void postShowOverflowMenu() {
        AbsActionBarView$1 absActionBarView$1 = new AbsActionBarView$1(this);
        this.post(absActionBarView$1);
    }

    public void setContentHeight(int n10) {
        this.mContentHeight = n10;
        this.requestLayout();
    }

    public void setVisibility(int n10) {
        int n11 = this.getVisibility();
        if (n10 != n11) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
            if (viewPropertyAnimatorCompat != null) {
                viewPropertyAnimatorCompat.cancel();
            }
            super.setVisibility(n10);
        }
    }

    public ViewPropertyAnimatorCompat setupAnimatorToVisibility(int n10, long l10) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mVisibilityAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
        viewPropertyAnimatorCompat = null;
        if (n10 == 0) {
            int n11 = this.getVisibility();
            if (n11 != 0) {
                this.setAlpha(0.0f);
            }
            viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(1.0f);
            viewPropertyAnimatorCompat.setDuration(l10);
            AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener = this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorCompat, n10);
            viewPropertyAnimatorCompat.setListener(absActionBarView$VisibilityAnimListener);
            return viewPropertyAnimatorCompat;
        }
        viewPropertyAnimatorCompat = ViewCompat.animate((View)this).alpha(0.0f);
        viewPropertyAnimatorCompat.setDuration(l10);
        AbsActionBarView$VisibilityAnimListener absActionBarView$VisibilityAnimListener = this.mVisAnimListener.withFinalVisibility(viewPropertyAnimatorCompat, n10);
        viewPropertyAnimatorCompat.setListener(absActionBarView$VisibilityAnimListener);
        return viewPropertyAnimatorCompat;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }
}

