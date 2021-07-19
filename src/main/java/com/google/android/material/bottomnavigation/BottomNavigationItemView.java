/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

public class BottomNavigationItemView
extends FrameLayout
implements MenuView$ItemView {
    private static final int[] CHECKED_STATE_SET;
    public static final int INVALID_ITEM_POSITION = 255;
    private final int defaultMargin;
    private ImageView icon;
    private ColorStateList iconTint;
    private boolean isShifting;
    private MenuItemImpl itemData;
    private int itemPosition = -1;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private float scaleDownFactor;
    private float scaleUpFactor;
    private float shiftAmount;
    private final TextView smallLabel;

    static {
        int[] nArray = new int[]{0x10100A0};
        CHECKED_STATE_SET = nArray;
    }

    public BottomNavigationItemView(Context context) {
        this(context, null);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BottomNavigationItemView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        attributeSet = this.getResources();
        context = LayoutInflater.from((Context)context);
        n10 = R$layout.design_bottom_navigation_item;
        boolean bl2 = true;
        context.inflate(n10, (ViewGroup)this, bl2);
        int n11 = R$drawable.design_bottom_navigation_item_background;
        this.setBackgroundResource(n11);
        n11 = R$dimen.design_bottom_navigation_margin;
        this.defaultMargin = n11 = attributeSet.getDimensionPixelSize(n11);
        n11 = R$id.icon;
        context = (ImageView)this.findViewById(n11);
        this.icon = context;
        n11 = R$id.smallLabel;
        context = (TextView)this.findViewById(n11);
        this.smallLabel = context;
        int n12 = R$id.largeLabel;
        attributeSet = (TextView)this.findViewById(n12);
        this.largeLabel = attributeSet;
        n10 = 2;
        ViewCompat.setImportantForAccessibility((View)context, n10);
        ViewCompat.setImportantForAccessibility((View)attributeSet, n10);
        this.setFocusable(bl2);
        float f10 = context.getTextSize();
        float f11 = attributeSet.getTextSize();
        this.calculateTextScaleFactors(f10, f11);
    }

    private void calculateTextScaleFactors(float f10, float f11) {
        float f12;
        float f13;
        this.shiftAmount = f13 = f10 - f11;
        f13 = 1.0f;
        this.scaleUpFactor = f12 = f11 * f13 / f10;
        this.scaleDownFactor = f10 = f10 * f13 / f11;
    }

    private void setViewLayoutParams(View view, int n10, int n11) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)view.getLayoutParams();
        layoutParams.topMargin = n10;
        layoutParams.gravity = n11;
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    private void setViewValues(View view, float f10, float f11, int n10) {
        view.setScaleX(f10);
        view.setScaleY(f11);
        view.setVisibility(n10);
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public int getItemPosition() {
        return this.itemPosition;
    }

    public void initialize(MenuItemImpl menuItemImpl, int n10) {
        this.itemData = menuItemImpl;
        n10 = (int)(menuItemImpl.isCheckable() ? 1 : 0);
        this.setCheckable(n10 != 0);
        n10 = (int)(menuItemImpl.isChecked() ? 1 : 0);
        this.setChecked(n10 != 0);
        n10 = (int)(menuItemImpl.isEnabled() ? 1 : 0);
        this.setEnabled(n10 != 0);
        Object object = menuItemImpl.getIcon();
        this.setIcon((Drawable)object);
        object = menuItemImpl.getTitle();
        this.setTitle((CharSequence)object);
        n10 = menuItemImpl.getItemId();
        this.setId(n10);
        object = menuItemImpl.getContentDescription();
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            object = menuItemImpl.getContentDescription();
            this.setContentDescription((CharSequence)object);
        }
        object = menuItemImpl.getTooltipText();
        TooltipCompat.setTooltipText((View)this, (CharSequence)object);
        int n11 = menuItemImpl.isVisible();
        if (n11 != 0) {
            n11 = 0;
            menuItemImpl = null;
        } else {
            n11 = 8;
        }
        this.setVisibility(n11);
    }

    public int[] onCreateDrawableState(int n10) {
        boolean bl2;
        int[] nArray = super.onCreateDrawableState(++n10);
        Object object = this.itemData;
        if (object != null && (bl2 = ((MenuItemImpl)object).isCheckable()) && (bl2 = ((MenuItemImpl)(object = this.itemData)).isChecked())) {
            object = CHECKED_STATE_SET;
            FrameLayout.mergeDrawableStates((int[])nArray, (int[])object);
        }
        return nArray;
    }

    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean bl2) {
        this.refreshDrawableState();
    }

    public void setChecked(boolean bl2) {
        TextView textView = this.largeLabel;
        int n10 = textView.getWidth();
        int n11 = 2;
        float f10 = 2.8E-45f;
        float f11 = n10 / n11;
        textView.setPivotX(f11);
        textView = this.largeLabel;
        f11 = textView.getBaseline();
        textView.setPivotY(f11);
        textView = this.smallLabel;
        f11 = textView.getWidth() / n11;
        textView.setPivotX(f11);
        textView = this.smallLabel;
        f11 = textView.getBaseline();
        textView.setPivotY(f11);
        int n12 = this.labelVisibilityMode;
        n10 = -1;
        f11 = 0.0f / 0.0f;
        int n13 = 17;
        float f12 = 0.5f;
        int n14 = 49;
        int n15 = 4;
        float f13 = 1.0f;
        if (n12 != n10) {
            if (n12 != 0) {
                n10 = 1;
                f11 = Float.MIN_VALUE;
                if (n12 != n10) {
                    if (n12 == n11) {
                        textView = this.icon;
                        n10 = this.defaultMargin;
                        this.setViewLayoutParams((View)textView, n10, n13);
                        textView = this.largeLabel;
                        n10 = 8;
                        f11 = 1.1E-44f;
                        textView.setVisibility(n10);
                        textView = this.smallLabel;
                        textView.setVisibility(n10);
                    }
                } else if (bl2) {
                    textView = this.icon;
                    f11 = this.defaultMargin;
                    f10 = this.shiftAmount;
                    n10 = (int)(f11 + f10);
                    this.setViewLayoutParams((View)textView, n10, n14);
                    textView = this.largeLabel;
                    this.setViewValues((View)textView, f13, f13, 0);
                    textView = this.smallLabel;
                    f11 = this.scaleUpFactor;
                    this.setViewValues((View)textView, f11, f11, n15);
                } else {
                    textView = this.icon;
                    n10 = this.defaultMargin;
                    this.setViewLayoutParams((View)textView, n10, n14);
                    textView = this.largeLabel;
                    f11 = this.scaleDownFactor;
                    this.setViewValues((View)textView, f11, f11, n15);
                    textView = this.smallLabel;
                    this.setViewValues((View)textView, f13, f13, 0);
                }
            } else {
                if (bl2) {
                    textView = this.icon;
                    n10 = this.defaultMargin;
                    this.setViewLayoutParams((View)textView, n10, n14);
                    textView = this.largeLabel;
                    this.setViewValues((View)textView, f13, f13, 0);
                } else {
                    textView = this.icon;
                    n10 = this.defaultMargin;
                    this.setViewLayoutParams((View)textView, n10, n13);
                    textView = this.largeLabel;
                    this.setViewValues((View)textView, f12, f12, n15);
                }
                textView = this.smallLabel;
                textView.setVisibility(n15);
            }
        } else {
            n12 = (int)(this.isShifting ? 1 : 0);
            if (n12 != 0) {
                if (bl2) {
                    textView = this.icon;
                    n10 = this.defaultMargin;
                    this.setViewLayoutParams((View)textView, n10, n14);
                    textView = this.largeLabel;
                    this.setViewValues((View)textView, f13, f13, 0);
                } else {
                    textView = this.icon;
                    n10 = this.defaultMargin;
                    this.setViewLayoutParams((View)textView, n10, n13);
                    textView = this.largeLabel;
                    this.setViewValues((View)textView, f12, f12, n15);
                }
                textView = this.smallLabel;
                textView.setVisibility(n15);
            } else if (bl2) {
                textView = this.icon;
                f11 = this.defaultMargin;
                f10 = this.shiftAmount;
                n10 = (int)(f11 + f10);
                this.setViewLayoutParams((View)textView, n10, n14);
                textView = this.largeLabel;
                this.setViewValues((View)textView, f13, f13, 0);
                textView = this.smallLabel;
                f11 = this.scaleUpFactor;
                this.setViewValues((View)textView, f11, f11, n15);
            } else {
                textView = this.icon;
                n10 = this.defaultMargin;
                this.setViewLayoutParams((View)textView, n10, n14);
                textView = this.largeLabel;
                f11 = this.scaleDownFactor;
                this.setViewValues((View)textView, f11, f11, n15);
                textView = this.smallLabel;
                this.setViewValues((View)textView, f13, f13, 0);
            }
        }
        this.refreshDrawableState();
        this.setSelected(bl2);
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        this.smallLabel.setEnabled(bl2);
        this.largeLabel.setEnabled(bl2);
        ImageView imageView = this.icon;
        imageView.setEnabled(bl2);
        if (bl2) {
            Object object = this.getContext();
            int n10 = 1002;
            object = PointerIconCompat.getSystemIcon(object, n10);
            ViewCompat.setPointerIcon((View)this, (PointerIconCompat)object);
        } else {
            bl2 = false;
            Object var3_4 = null;
            ViewCompat.setPointerIcon((View)this, null);
        }
    }

    public void setIcon(Drawable drawable2) {
        if (drawable2 != null) {
            Drawable.ConstantState constantState = drawable2.getConstantState();
            if (constantState != null) {
                drawable2 = constantState.newDrawable();
            }
            drawable2 = DrawableCompat.wrap(drawable2).mutate();
            constantState = this.iconTint;
            DrawableCompat.setTintList(drawable2, (ColorStateList)constantState);
        }
        this.icon.setImageDrawable(drawable2);
    }

    public void setIconSize(int n10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)this.icon.getLayoutParams();
        layoutParams.width = n10;
        layoutParams.height = n10;
        this.icon.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    }

    public void setIconTintList(ColorStateList object) {
        this.iconTint = object;
        object = this.itemData;
        if (object != null) {
            object = ((MenuItemImpl)object).getIcon();
            this.setIcon((Drawable)object);
        }
    }

    public void setItemBackground(int n10) {
        Drawable drawable2;
        if (n10 == 0) {
            n10 = 0;
            drawable2 = null;
        } else {
            Context context = this.getContext();
            drawable2 = ContextCompat.getDrawable(context, n10);
        }
        this.setItemBackground(drawable2);
    }

    public void setItemBackground(Drawable drawable2) {
        ViewCompat.setBackground((View)this, drawable2);
    }

    public void setItemPosition(int n10) {
        this.itemPosition = n10;
    }

    public void setLabelVisibilityMode(int n10) {
        int n11 = this.labelVisibilityMode;
        if (n11 != n10) {
            this.labelVisibilityMode = n10;
            MenuItemImpl menuItemImpl = this.itemData;
            n11 = menuItemImpl != null ? 1 : 0;
            if (n11 != 0) {
                n10 = (int)(menuItemImpl.isChecked() ? 1 : 0);
                this.setChecked(n10 != 0);
            }
        }
    }

    public void setShifting(boolean bl2) {
        boolean bl3 = this.isShifting;
        if (bl3 != bl2) {
            this.isShifting = bl2;
            MenuItemImpl menuItemImpl = this.itemData;
            bl3 = menuItemImpl != null;
            if (bl3) {
                bl2 = menuItemImpl.isChecked();
                this.setChecked(bl2);
            }
        }
    }

    public void setShortcut(boolean bl2, char c10) {
    }

    public void setTextAppearanceActive(int n10) {
        TextViewCompat.setTextAppearance(this.largeLabel, n10);
        float f10 = this.smallLabel.getTextSize();
        float f11 = this.largeLabel.getTextSize();
        this.calculateTextScaleFactors(f10, f11);
    }

    public void setTextAppearanceInactive(int n10) {
        TextViewCompat.setTextAppearance(this.smallLabel, n10);
        float f10 = this.smallLabel.getTextSize();
        float f11 = this.largeLabel.getTextSize();
        this.calculateTextScaleFactors(f10, f11);
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            TextView textView = this.largeLabel;
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        boolean bl2;
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        Object object = this.itemData;
        if (object == null || (bl2 = TextUtils.isEmpty((CharSequence)(object = ((MenuItemImpl)object).getContentDescription())))) {
            this.setContentDescription(charSequence);
        }
    }

    public boolean showsIcon() {
        return true;
    }
}

