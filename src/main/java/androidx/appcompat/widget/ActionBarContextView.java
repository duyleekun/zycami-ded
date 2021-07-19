/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.appcompat.widget.ActionBarContextView$1;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.view.ViewCompat;

public class ActionBarContextView
extends AbsActionBarView {
    private View mClose;
    private View mCloseButton;
    private int mCloseItemLayout;
    private View mCustomView;
    private CharSequence mSubtitle;
    private int mSubtitleStyleRes;
    private TextView mSubtitleView;
    private CharSequence mTitle;
    private LinearLayout mTitleLayout;
    private boolean mTitleOptional;
    private int mTitleStyleRes;
    private TextView mTitleView;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.actionModeStyle;
        this(context, attributeSet, n10);
    }

    public ActionBarContextView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int[] nArray = R$styleable.ActionMode;
        object = TintTypedArray.obtainStyledAttributes((Context)object, attributeSet, nArray, n10, 0);
        int n11 = R$styleable.ActionMode_background;
        attributeSet = ((TintTypedArray)object).getDrawable(n11);
        ViewCompat.setBackground((View)this, (Drawable)attributeSet);
        n11 = R$styleable.ActionMode_titleTextStyle;
        this.mTitleStyleRes = n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n11 = R$styleable.ActionMode_subtitleTextStyle;
        this.mSubtitleStyleRes = n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n11 = R$styleable.ActionMode_height;
        this.mContentHeight = n11 = ((TintTypedArray)object).getLayoutDimension(n11, 0);
        n11 = R$styleable.ActionMode_closeItemLayout;
        n10 = R$layout.abc_action_mode_close_item_material;
        this.mCloseItemLayout = n11 = ((TintTypedArray)object).getResourceId(n11, n10);
        ((TintTypedArray)object).recycle();
    }

    private void initTitle() {
        CharSequence charSequence;
        int n10;
        int n11;
        Object object = this.mTitleLayout;
        if (object == null) {
            int n12;
            object = LayoutInflater.from((Context)this.getContext());
            n11 = R$layout.abc_action_bar_title_item;
            object.inflate(n11, (ViewGroup)this);
            n10 = this.getChildCount() + -1;
            this.mTitleLayout = object = (LinearLayout)this.getChildAt(n10);
            n11 = R$id.action_bar_title;
            object = (TextView)object.findViewById(n11);
            this.mTitleView = object;
            object = this.mTitleLayout;
            n11 = R$id.action_bar_subtitle;
            object = (TextView)object.findViewById(n11);
            this.mSubtitleView = object;
            n10 = this.mTitleStyleRes;
            if (n10 != 0) {
                object = this.mTitleView;
                charSequence = this.getContext();
                n12 = this.mTitleStyleRes;
                object.setTextAppearance((Context)charSequence, n12);
            }
            if ((n10 = this.mSubtitleStyleRes) != 0) {
                object = this.mSubtitleView;
                charSequence = this.getContext();
                n12 = this.mSubtitleStyleRes;
                object.setTextAppearance((Context)charSequence, n12);
            }
        }
        object = this.mTitleView;
        charSequence = this.mTitle;
        object.setText(charSequence);
        object = this.mSubtitleView;
        charSequence = this.mSubtitle;
        object.setText(charSequence);
        object = this.mTitle;
        n10 = TextUtils.isEmpty((CharSequence)object) ^ 1;
        charSequence = this.mSubtitle;
        n11 = TextUtils.isEmpty((CharSequence)charSequence) ^ 1;
        TextView textView = this.mSubtitleView;
        int n13 = 0;
        int n14 = 8;
        int n15 = n11 != 0 ? 0 : n14;
        textView.setVisibility(n15);
        textView = this.mTitleLayout;
        if (n10 == 0 && n11 == 0) {
            n13 = n14;
        }
        textView.setVisibility(n13);
        object = this.mTitleLayout.getParent();
        if (object == null) {
            object = this.mTitleLayout;
            this.addView((View)object);
        }
    }

    public void closeMode() {
        View view = this.mClose;
        if (view == null) {
            this.killMode();
        }
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        return marginLayoutParams;
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = this.getContext();
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(context, attributeSet);
        return marginLayoutParams;
    }

    public CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    public void initForMode(ActionMode object) {
        Context context;
        int n10;
        Object object2 = this.mClose;
        if (object2 == null) {
            object2 = LayoutInflater.from((Context)this.getContext());
            n10 = this.mCloseItemLayout;
            context = null;
            object2 = object2.inflate(n10, (ViewGroup)this, false);
            this.mClose = object2;
            this.addView((View)object2);
        } else if ((object2 = object2.getParent()) == null) {
            object2 = this.mClose;
            this.addView((View)object2);
        }
        object2 = this.mClose;
        n10 = R$id.action_mode_close_button;
        object2 = object2.findViewById(n10);
        this.mCloseButton = object2;
        Object object3 = new ActionBarContextView$1(this, (ActionMode)object);
        object2.setOnClickListener((View.OnClickListener)object3);
        object = (MenuBuilder)((ActionMode)object).getMenu();
        object2 = this.mActionMenuPresenter;
        if (object2 != null) {
            ((ActionMenuPresenter)object2).dismissPopupMenus();
        }
        object3 = this.getContext();
        this.mActionMenuPresenter = object2 = new ActionMenuPresenter((Context)object3);
        ((ActionMenuPresenter)object2).setReserveOverflow(true);
        object2 = new ViewGroup.LayoutParams(-2, -1);
        object3 = this.mActionMenuPresenter;
        context = this.mPopupContext;
        ((MenuBuilder)object).addMenuPresenter((MenuPresenter)object3, context);
        this.mMenuView = object = (ActionMenuView)this.mActionMenuPresenter.getMenuView(this);
        ViewCompat.setBackground((View)object, null);
        object = this.mMenuView;
        this.addView((View)object, (ViewGroup.LayoutParams)object2);
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    public boolean isTitleOptional() {
        return this.mTitleOptional;
    }

    public void killMode() {
        this.removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
        this.mActionMenuPresenter = null;
        View view = this.mCloseButton;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.hideOverflowMenu();
            actionMenuPresenter = this.mActionMenuPresenter;
            actionMenuPresenter.hideSubMenus();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int n10;
        int n11 = accessibilityEvent.getEventType();
        if (n11 == (n10 = 32)) {
            accessibilityEvent.setSource((View)this);
            CharSequence charSequence = ((Object)((Object)this)).getClass().getName();
            accessibilityEvent.setClassName(charSequence);
            charSequence = this.getContext().getPackageName();
            accessibilityEvent.setPackageName(charSequence);
            charSequence = this.mTitle;
            accessibilityEvent.setContentDescription(charSequence);
        } else {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        int n14;
        int n15;
        Object object;
        Object object2;
        int n16;
        int n17;
        bl2 = ViewUtils.isLayoutRtl((View)this);
        if (bl2) {
            n17 = n12 - n10;
            n16 = this.getPaddingRight();
            n17 -= n16;
        } else {
            n17 = this.getPaddingLeft();
        }
        int n18 = this.getPaddingTop();
        n13 -= n11;
        n11 = this.getPaddingTop();
        n13 -= n11;
        n11 = this.getPaddingBottom();
        n11 = n13 - n11;
        View view = this.mClose;
        int n19 = 8;
        if (view != null && (n13 = view.getVisibility()) != n19) {
            view = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
            n16 = bl2 ? view.rightMargin : view.leftMargin;
            n13 = bl2 ? view.leftMargin : view.rightMargin;
            int n20 = AbsActionBarView.next(n17, n16, bl2);
            object2 = this.mClose;
            object = this;
            n15 = n18;
            n14 = n11;
            n17 = this.positionChild((View)object2, n20, n18, n11, bl2);
            n20 += n17;
            n17 = AbsActionBarView.next(n20, n13, bl2);
        }
        n13 = n17;
        object = this.mTitleLayout;
        if (object != null && (object2 = this.mCustomView) == null && (n17 = object.getVisibility()) != n19) {
            object2 = this.mTitleLayout;
            object = this;
            n15 = n18;
            n14 = n11;
            n17 = this.positionChild((View)object2, n13, n18, n11, bl2);
            n13 += n17;
        }
        if ((object2 = this.mCustomView) != null) {
            object = this;
            n15 = n18;
            n14 = n11;
            this.positionChild((View)object2, n13, n18, n11, bl2);
        }
        if (bl2) {
            n15 = n10 = this.getPaddingLeft();
        } else {
            n12 -= n10;
            n10 = this.getPaddingRight();
            n15 = n12 -= n10;
        }
        ActionMenuView actionMenuView = this.mMenuView;
        if (actionMenuView != null) {
            object2 = this;
            n14 = n18;
            n18 = (int)((bl2 ^= true) ? 1 : 0);
            this.positionChild((View)actionMenuView, n15, n14, n11, bl2);
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        int n13 = View.MeasureSpec.getMode((int)n10);
        if (n13 == (n12 = 0x40000000)) {
            n13 = View.MeasureSpec.getMode((int)n11);
            if (n13 != 0) {
                View view;
                View view2;
                int n14;
                int n15;
                n10 = View.MeasureSpec.getSize((int)n10);
                n13 = this.mContentHeight;
                if (n13 <= 0) {
                    n13 = View.MeasureSpec.getSize((int)n11);
                }
                n11 = this.getPaddingTop();
                int n16 = this.getPaddingBottom();
                n11 += n16;
                n16 = this.getPaddingLeft();
                n16 = n10 - n16;
                int n17 = this.getPaddingRight();
                n16 -= n17;
                n17 = n13 - n11;
                int n18 = -1 << -1;
                float f10 = -0.0f;
                int n19 = View.MeasureSpec.makeMeasureSpec((int)n17, (int)n18);
                Object object = this.mClose;
                int n20 = 0;
                if (object != null) {
                    n16 = this.measureChildView((View)object, n16, n19, 0);
                    object = (ViewGroup.MarginLayoutParams)this.mClose.getLayoutParams();
                    n15 = object.leftMargin;
                    n14 = object.rightMargin;
                    n16 -= (n15 += n14);
                }
                if ((object = this.mMenuView) != null && (object = object.getParent()) == this) {
                    object = this.mMenuView;
                    n16 = this.measureChildView((View)object, n16, n19, 0);
                }
                if ((object = this.mTitleLayout) != null && (view2 = this.mCustomView) == null) {
                    n15 = (int)(this.mTitleOptional ? 1 : 0);
                    if (n15 != 0) {
                        n14 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                        view2 = this.mTitleLayout;
                        view2.measure(n14, n19);
                        view = this.mTitleLayout;
                        n19 = view.getMeasuredWidth();
                        if (n19 <= n16) {
                            n14 = 1;
                        } else {
                            n14 = 0;
                            object = null;
                        }
                        if (n14 != 0) {
                            n16 -= n19;
                        }
                        view = this.mTitleLayout;
                        if (n14 != 0) {
                            n14 = 0;
                            object = null;
                        } else {
                            n14 = 8;
                        }
                        view.setVisibility(n14);
                    } else {
                        n16 = this.measureChildView((View)object, n16, n19, 0);
                    }
                }
                if ((view = this.mCustomView) != null) {
                    view = view.getLayoutParams();
                    n14 = view.width;
                    n15 = -2;
                    int n21 = n14 != n15 ? n12 : n18;
                    if (n14 >= 0) {
                        n16 = Math.min(n14, n16);
                    }
                    if ((n19 = view.height) == n15) {
                        n12 = n18;
                    }
                    if (n19 >= 0) {
                        n17 = Math.min(n19, n17);
                    }
                    View view3 = this.mCustomView;
                    n16 = View.MeasureSpec.makeMeasureSpec((int)n16, (int)n21);
                    n12 = View.MeasureSpec.makeMeasureSpec((int)n17, (int)n12);
                    view3.measure(n16, n12);
                }
                if ((n12 = this.mContentHeight) <= 0) {
                    n13 = this.getChildCount();
                    n12 = 0;
                    while (n20 < n13) {
                        View view4 = this.getChildAt(n20);
                        n16 = view4.getMeasuredHeight() + n11;
                        if (n16 > n12) {
                            n12 = n16;
                        }
                        ++n20;
                    }
                    this.setMeasuredDimension(n10, n12);
                } else {
                    this.setMeasuredDimension(n10, n13);
                }
                return;
            }
            CharSequence charSequence = new StringBuilder();
            String string2 = ((Object)((Object)this)).getClass().getSimpleName();
            charSequence.append(string2);
            charSequence.append(" can only be used with android:layout_height=\"wrap_content\"");
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        CharSequence charSequence = new StringBuilder();
        String string3 = ((Object)((Object)this)).getClass().getSimpleName();
        charSequence.append(string3);
        charSequence.append(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void setContentHeight(int n10) {
        this.mContentHeight = n10;
    }

    public void setCustomView(View view) {
        View view2 = this.mCustomView;
        if (view2 != null) {
            this.removeView(view2);
        }
        this.mCustomView = view;
        if (view != null && (view2 = this.mTitleLayout) != null) {
            this.removeView(view2);
            view2 = null;
            this.mTitleLayout = null;
        }
        if (view != null) {
            this.addView(view);
        }
        this.requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mSubtitle = charSequence;
        this.initTitle();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.initTitle();
    }

    public void setTitleOptional(boolean bl2) {
        boolean bl3 = this.mTitleOptional;
        if (bl2 != bl3) {
            this.requestLayout();
        }
        this.mTitleOptional = bl2;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.showOverflowMenu();
        }
        return false;
    }
}

