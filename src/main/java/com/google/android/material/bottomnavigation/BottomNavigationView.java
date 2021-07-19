/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 */
package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView$1;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemReselectedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView$OnNavigationItemSelectedListener;
import com.google.android.material.bottomnavigation.BottomNavigationView$SavedState;
import com.google.android.material.internal.ThemeEnforcement;

public class BottomNavigationView
extends FrameLayout {
    private static final int MENU_PRESENTER_ID = 1;
    private final MenuBuilder menu;
    private MenuInflater menuInflater;
    private final BottomNavigationMenuView menuView;
    private final BottomNavigationPresenter presenter;
    private BottomNavigationView$OnNavigationItemReselectedListener reselectedListener;
    private BottomNavigationView$OnNavigationItemSelectedListener selectedListener;

    public BottomNavigationView(Context context) {
        this(context, null);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.bottomNavigationStyle;
        this(context, attributeSet, n10);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        boolean bl2;
        boolean bl3;
        int n11;
        int n12;
        BottomNavigationMenuView bottomNavigationMenuView;
        Object object = new BottomNavigationPresenter();
        this.presenter = object;
        BottomNavigationMenu bottomNavigationMenu = new BottomNavigationMenu(context);
        this.menu = bottomNavigationMenu;
        this.menuView = bottomNavigationMenuView = new BottomNavigationMenuView(context);
        int n13 = -2;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n13, n13);
        float f10 = 2.4E-44f;
        layoutParams.gravity = 17;
        bottomNavigationMenuView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        ((BottomNavigationPresenter)object).setBottomNavigationMenuView(bottomNavigationMenuView);
        boolean bl22 = true;
        ((BottomNavigationPresenter)object).setId((int)(bl22 ? 1 : 0));
        bottomNavigationMenuView.setPresenter((BottomNavigationPresenter)object);
        bottomNavigationMenu.addMenuPresenter((MenuPresenter)object);
        Context context2 = this.getContext();
        ((BottomNavigationPresenter)object).initForMenu(context2, bottomNavigationMenu);
        Object object2 = R$styleable.BottomNavigationView;
        int n14 = R$style.Widget_Design_BottomNavigationView;
        int n15 = 2;
        int[] nArray = new int[n15];
        nArray[0] = n12 = R$styleable.BottomNavigationView_itemTextAppearanceInactive;
        nArray[bl22] = n11 = R$styleable.BottomNavigationView_itemTextAppearanceActive;
        object = context;
        context2 = attributeSet;
        int n16 = n10;
        object = ThemeEnforcement.obtainTintedStyledAttributes(context, attributeSet, object2, n10, n14, nArray);
        n13 = R$styleable.BottomNavigationView_itemIconTint;
        boolean n17 = ((TintTypedArray)object).hasValue(n13);
        if (n17) {
            context2 = ((TintTypedArray)object).getColorStateList(n13);
            bottomNavigationMenuView.setIconTintList((ColorStateList)context2);
        } else {
            n13 = 16842808;
            f10 = 2.3693715E-38f;
            context2 = bottomNavigationMenuView.createDefaultColorStateList(n13);
            bottomNavigationMenuView.setIconTintList((ColorStateList)context2);
        }
        n13 = R$styleable.BottomNavigationView_itemIconSize;
        object2 = this.getResources();
        n16 = R$dimen.design_bottom_navigation_icon_size;
        int n18 = object2.getDimensionPixelSize(n16);
        n13 = ((TintTypedArray)object).getDimensionPixelSize(n13, n18);
        this.setItemIconSize(n13);
        n13 = (int)(((TintTypedArray)object).hasValue(n12) ? 1 : 0);
        if (n13 != 0) {
            n13 = ((TintTypedArray)object).getResourceId(n12, 0);
            this.setItemTextAppearanceInactive(n13);
        }
        if ((n13 = (int)(((TintTypedArray)object).hasValue(n11) ? 1 : 0)) != 0) {
            n13 = ((TintTypedArray)object).getResourceId(n11, 0);
            this.setItemTextAppearanceActive(n13);
        }
        if (bl3 = ((TintTypedArray)object).hasValue(n13 = R$styleable.BottomNavigationView_itemTextColor)) {
            context2 = ((TintTypedArray)object).getColorStateList(n13);
            this.setItemTextColor((ColorStateList)context2);
        }
        if (bl2 = ((TintTypedArray)object).hasValue(n13 = R$styleable.BottomNavigationView_elevation)) {
            n13 = ((TintTypedArray)object).getDimensionPixelSize(n13, 0);
            f10 = n13;
            ViewCompat.setElevation((View)this, f10);
        }
        n13 = R$styleable.BottomNavigationView_labelVisibilityMode;
        n13 = ((TintTypedArray)object).getInteger(n13, -1);
        this.setLabelVisibilityMode(n13);
        n13 = R$styleable.BottomNavigationView_itemHorizontalTranslationEnabled;
        n13 = (int)(((TintTypedArray)object).getBoolean(n13, bl22) ? 1 : 0);
        this.setItemHorizontalTranslationEnabled(n13 != 0);
        n13 = R$styleable.BottomNavigationView_itemBackground;
        n13 = ((TintTypedArray)object).getResourceId(n13, 0);
        bottomNavigationMenuView.setItemBackgroundRes(n13);
        n13 = R$styleable.BottomNavigationView_menu;
        boolean bl4 = ((TintTypedArray)object).hasValue(n13);
        if (bl4) {
            n13 = ((TintTypedArray)object).getResourceId(n13, 0);
            this.inflateMenu(n13);
        }
        ((TintTypedArray)object).recycle();
        this.addView((View)bottomNavigationMenuView, (ViewGroup.LayoutParams)layoutParams);
        n15 = Build.VERSION.SDK_INT;
        n13 = 21;
        f10 = 2.9E-44f;
        if (n15 < n13) {
            this.addCompatibilityTopDivider(context);
        }
        object = new BottomNavigationView$1(this);
        bottomNavigationMenu.setCallback((MenuBuilder$Callback)object);
    }

    public static /* synthetic */ BottomNavigationView$OnNavigationItemReselectedListener access$000(BottomNavigationView bottomNavigationView) {
        return bottomNavigationView.reselectedListener;
    }

    public static /* synthetic */ BottomNavigationView$OnNavigationItemSelectedListener access$100(BottomNavigationView bottomNavigationView) {
        return bottomNavigationView.selectedListener;
    }

    private void addCompatibilityTopDivider(Context context) {
        View view = new View(context);
        int n10 = R$color.design_bottom_navigation_shadow_color;
        int n11 = ContextCompat.getColor(context, n10);
        view.setBackgroundColor(n11);
        Resources resources = this.getResources();
        int n12 = R$dimen.design_bottom_navigation_shadow_height;
        n10 = resources.getDimensionPixelSize(n12);
        context = new FrameLayout.LayoutParams(-1, n10);
        view.setLayoutParams((ViewGroup.LayoutParams)context);
        this.addView(view);
    }

    private MenuInflater getMenuInflater() {
        MenuInflater menuInflater = this.menuInflater;
        if (menuInflater == null) {
            Context context = this.getContext();
            this.menuInflater = menuInflater = new SupportMenuInflater(context);
        }
        return this.menuInflater;
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int n10) {
        BottomNavigationPresenter bottomNavigationPresenter = this.presenter;
        boolean bl2 = true;
        bottomNavigationPresenter.setUpdateSuspended(bl2);
        bottomNavigationPresenter = this.getMenuInflater();
        MenuBuilder menuBuilder = this.menu;
        bottomNavigationPresenter.inflate(n10, menuBuilder);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(bl2);
    }

    public boolean isItemHorizontalTranslationEnabled() {
        return this.menuView.isItemHorizontalTranslationEnabled();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof BottomNavigationView$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (BottomNavigationView$SavedState)parcelable;
        Object object = parcelable.getSuperState();
        super.onRestoreInstanceState((Parcelable)object);
        object = this.menu;
        parcelable = parcelable.menuPresenterState;
        ((MenuBuilder)object).restorePresenterStates((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        BottomNavigationView$SavedState bottomNavigationView$SavedState = new BottomNavigationView$SavedState(parcelable);
        parcelable = new Bundle();
        bottomNavigationView$SavedState.menuPresenterState = parcelable;
        this.menu.savePresenterStates((Bundle)parcelable);
        return bottomNavigationView$SavedState;
    }

    public void setItemBackground(Drawable drawable2) {
        this.menuView.setItemBackground(drawable2);
    }

    public void setItemBackgroundResource(int n10) {
        this.menuView.setItemBackgroundRes(n10);
    }

    public void setItemHorizontalTranslationEnabled(boolean bl2) {
        BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
        boolean bl3 = bottomNavigationMenuView.isItemHorizontalTranslationEnabled();
        if (bl3 != bl2) {
            this.menuView.setItemHorizontalTranslationEnabled(bl2);
            BottomNavigationPresenter bottomNavigationPresenter = this.presenter;
            bl3 = false;
            bottomNavigationMenuView = null;
            bottomNavigationPresenter.updateMenuView(false);
        }
    }

    public void setItemIconSize(int n10) {
        this.menuView.setItemIconSize(n10);
    }

    public void setItemIconSizeRes(int n10) {
        n10 = this.getResources().getDimensionPixelSize(n10);
        this.setItemIconSize(n10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.menuView.setIconTintList(colorStateList);
    }

    public void setItemTextAppearanceActive(int n10) {
        this.menuView.setItemTextAppearanceActive(n10);
    }

    public void setItemTextAppearanceInactive(int n10) {
        this.menuView.setItemTextAppearanceInactive(n10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.menuView.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int n10) {
        BottomNavigationMenuView bottomNavigationMenuView = this.menuView;
        int n11 = bottomNavigationMenuView.getLabelVisibilityMode();
        if (n11 != n10) {
            this.menuView.setLabelVisibilityMode(n10);
            BottomNavigationPresenter bottomNavigationPresenter = this.presenter;
            n11 = 0;
            bottomNavigationMenuView = null;
            bottomNavigationPresenter.updateMenuView(false);
        }
    }

    public void setOnNavigationItemReselectedListener(BottomNavigationView$OnNavigationItemReselectedListener bottomNavigationView$OnNavigationItemReselectedListener) {
        this.reselectedListener = bottomNavigationView$OnNavigationItemReselectedListener;
    }

    public void setOnNavigationItemSelectedListener(BottomNavigationView$OnNavigationItemSelectedListener bottomNavigationView$OnNavigationItemSelectedListener) {
        this.selectedListener = bottomNavigationView$OnNavigationItemSelectedListener;
    }

    public void setSelectedItemId(int n10) {
        BottomNavigationPresenter bottomNavigationPresenter;
        boolean bl2;
        MenuBuilder menuBuilder = this.menu;
        MenuItem menuItem = menuBuilder.findItem(n10);
        if (menuItem != null && !(bl2 = (menuBuilder = this.menu).performItemAction(menuItem, bottomNavigationPresenter = this.presenter, 0))) {
            bl2 = true;
            menuItem.setChecked(bl2);
        }
    }
}

