/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.StateListDrawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.CheckedTextView
 *  android.widget.FrameLayout
 *  android.widget.TextView
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.internal.ForegroundLinearLayout;

public class NavigationMenuItemView
extends ForegroundLinearLayout
implements MenuView$ItemView {
    private static final int[] CHECKED_STATE_SET;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    public boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private final int iconSize;
    private ColorStateList iconTintList;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    static {
        int[] nArray = new int[]{0x10100A0};
        CHECKED_STATE_SET = nArray;
    }

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        int n11;
        super(this);
        this.accessibilityDelegate = object;
        this.setOrientation(0);
        LayoutInflater layoutInflater = LayoutInflater.from((Context)context);
        int n12 = R$layout.design_navigation_menu_item;
        boolean bl2 = true;
        layoutInflater.inflate(n12, (ViewGroup)this, bl2);
        context = context.getResources();
        n10 = R$dimen.design_navigation_icon_size;
        this.iconSize = n11 = context.getDimensionPixelSize(n10);
        n11 = R$id.design_menu_item_text;
        context = (CheckedTextView)this.findViewById(n11);
        this.textView = context;
        context.setDuplicateParentStateEnabled(bl2);
        ViewCompat.setAccessibilityDelegate((View)context, (AccessibilityDelegateCompat)object);
    }

    private void adjustAppearance() {
        boolean bl2 = this.shouldExpandActionArea();
        if (bl2) {
            Object object = this.textView;
            int n10 = 8;
            object.setVisibility(n10);
            object = this.actionArea;
            if (object != null) {
                object = (LinearLayoutCompat$LayoutParams)object.getLayoutParams();
                object.width = n10 = -1;
                FrameLayout frameLayout = this.actionArea;
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        } else {
            Object object = this.textView;
            int n11 = 0;
            FrameLayout frameLayout = null;
            object.setVisibility(0);
            object = this.actionArea;
            if (object != null) {
                object = (LinearLayoutCompat$LayoutParams)object.getLayoutParams();
                object.width = n11 = -2;
                frameLayout = this.actionArea;
                frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
    }

    private StateListDrawable createDefaultBackground() {
        boolean bl2;
        int n10;
        Object object = new TypedValue();
        Resources.Theme theme = this.getContext().getTheme();
        boolean bl3 = theme.resolveAttribute(n10 = R$attr.colorControlHighlight, object, bl2 = true);
        if (bl3) {
            theme = new StateListDrawable();
            Object object2 = CHECKED_STATE_SET;
            int n11 = object.data;
            ColorDrawable colorDrawable = new ColorDrawable(n11);
            theme.addState(object2, (Drawable)colorDrawable);
            object = ViewGroup.EMPTY_STATE_SET;
            object2 = new ColorDrawable;
            object2(0);
            theme.addState((int[])object, (Drawable)object2);
            return theme;
        }
        return null;
    }

    private void setActionView(View view) {
        if (view != null) {
            FrameLayout frameLayout = this.actionArea;
            if (frameLayout == null) {
                int n10 = R$id.design_menu_item_action_area_stub;
                this.actionArea = frameLayout = (FrameLayout)((ViewStub)this.findViewById(n10)).inflate();
            }
            this.actionArea.removeAllViews();
            frameLayout = this.actionArea;
            frameLayout.addView(view);
        }
    }

    private boolean shouldExpandActionArea() {
        boolean bl2;
        CharSequence charSequence = this.itemData.getTitle();
        if (charSequence == null && (charSequence = this.itemData.getIcon()) == null && (charSequence = this.itemData.getActionView()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            charSequence = null;
        }
        return bl2;
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void initialize(MenuItemImpl object, int n10) {
        Object object2;
        this.itemData = object;
        n10 = (int)(((MenuItemImpl)object).isVisible() ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            object2 = null;
        } else {
            n10 = 8;
        }
        this.setVisibility(n10);
        object2 = this.getBackground();
        if (object2 == null) {
            object2 = this.createDefaultBackground();
            ViewCompat.setBackground((View)this, object2);
        }
        n10 = (int)(((MenuItemImpl)object).isCheckable() ? 1 : 0);
        this.setCheckable(n10 != 0);
        n10 = (int)(((MenuItemImpl)object).isChecked() ? 1 : 0);
        this.setChecked(n10 != 0);
        n10 = (int)(((MenuItemImpl)object).isEnabled() ? 1 : 0);
        this.setEnabled(n10 != 0);
        object2 = ((MenuItemImpl)object).getTitle();
        this.setTitle((CharSequence)object2);
        object2 = ((MenuItemImpl)object).getIcon();
        this.setIcon((Drawable)object2);
        object2 = ((MenuItemImpl)object).getActionView();
        this.setActionView((View)object2);
        object2 = ((MenuItemImpl)object).getContentDescription();
        this.setContentDescription((CharSequence)object2);
        object = ((MenuItemImpl)object).getTooltipText();
        TooltipCompat.setTooltipText((View)this, (CharSequence)object);
        this.adjustAppearance();
    }

    public int[] onCreateDrawableState(int n10) {
        boolean bl2;
        int[] nArray = super.onCreateDrawableState(++n10);
        Object object = this.itemData;
        if (object != null && (bl2 = ((MenuItemImpl)object).isCheckable()) && (bl2 = ((MenuItemImpl)(object = this.itemData)).isChecked())) {
            object = CHECKED_STATE_SET;
            ViewGroup.mergeDrawableStates((int[])nArray, (int[])object);
        }
        return nArray;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void recycle() {
        FrameLayout frameLayout = this.actionArea;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.textView.setCompoundDrawables(null, null, null, null);
    }

    public void setCheckable(boolean bl2) {
        this.refreshDrawableState();
        boolean bl3 = this.checkable;
        if (bl3 != bl2) {
            this.checkable = bl2;
            AccessibilityDelegateCompat accessibilityDelegateCompat = this.accessibilityDelegate;
            CheckedTextView checkedTextView = this.textView;
            int n10 = 2048;
            accessibilityDelegateCompat.sendAccessibilityEvent((View)checkedTextView, n10);
        }
    }

    public void setChecked(boolean bl2) {
        this.refreshDrawableState();
        this.textView.setChecked(bl2);
    }

    public void setHorizontalPadding(int n10) {
        this.setPadding(n10, 0, n10, 0);
    }

    public void setIcon(Drawable drawable2) {
        if (drawable2 != null) {
            int n10 = this.hasIconTintList;
            if (n10 != 0) {
                Drawable.ConstantState constantState = drawable2.getConstantState();
                if (constantState != null) {
                    drawable2 = constantState.newDrawable();
                }
                drawable2 = DrawableCompat.wrap(drawable2).mutate();
                constantState = this.iconTintList;
                DrawableCompat.setTintList(drawable2, (ColorStateList)constantState);
            }
            n10 = this.iconSize;
            drawable2.setBounds(0, 0, n10, n10);
        } else {
            int n11 = this.needsEmptyIcon;
            if (n11 != 0) {
                drawable2 = this.emptyDrawable;
                if (drawable2 == null) {
                    drawable2 = this.getResources();
                    n11 = R$drawable.navigation_empty_icon;
                    Resources.Theme theme = this.getContext().getTheme();
                    this.emptyDrawable = drawable2 = ResourcesCompat.getDrawable((Resources)drawable2, n11, theme);
                    if (drawable2 != null) {
                        n11 = this.iconSize;
                        drawable2.setBounds(0, 0, n11, n11);
                    }
                }
                drawable2 = this.emptyDrawable;
            }
        }
        TextViewCompat.setCompoundDrawablesRelative((TextView)this.textView, drawable2, null, null, null);
    }

    public void setIconPadding(int n10) {
        this.textView.setCompoundDrawablePadding(n10);
    }

    public void setIconTintList(ColorStateList object) {
        boolean bl2;
        this.iconTintList = object;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.hasIconTintList = bl2;
        object = this.itemData;
        if (object != null) {
            object = ((MenuItemImpl)object).getIcon();
            this.setIcon((Drawable)object);
        }
    }

    public void setNeedsEmptyIcon(boolean bl2) {
        this.needsEmptyIcon = bl2;
    }

    public void setShortcut(boolean bl2, char c10) {
    }

    public void setTextAppearance(int n10) {
        TextViewCompat.setTextAppearance((TextView)this.textView, n10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textView.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.textView.setText(charSequence);
    }

    public boolean showsIcon() {
        return true;
    }
}

