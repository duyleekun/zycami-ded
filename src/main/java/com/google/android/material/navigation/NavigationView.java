/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 */
package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.navigation.NavigationView$1;
import com.google.android.material.navigation.NavigationView$OnNavigationItemSelectedListener;
import com.google.android.material.navigation.NavigationView$SavedState;

public class NavigationView
extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET;
    private static final int[] DISABLED_STATE_SET;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    public NavigationView$OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private final NavigationMenuPresenter presenter;

    static {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0x10100A0;
        CHECKED_STATE_SET = nArray;
        int[] nArray2 = new int[n10];
        nArray2[0] = -16842910;
        DISABLED_STATE_SET = nArray2;
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.navigationViewStyle;
        this(context, attributeSet, n10);
    }

    /*
     * WARNING - void declaration
     */
    public NavigationView(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        void var13_21;
        float f10;
        NavigationMenu navigationMenu;
        NavigationMenuPresenter navigationMenuPresenter;
        this.presenter = navigationMenuPresenter = new NavigationMenuPresenter();
        this.menu = navigationMenu = new NavigationMenu(context);
        int[] nArray = R$styleable.NavigationView;
        int n11 = R$style.Widget_Design_NavigationView;
        int[] nArray2 = new int[]{};
        int n12 = n10;
        object = ThemeEnforcement.obtainTintedStyledAttributes(context, (AttributeSet)object, nArray, n10, n11, nArray2);
        n10 = R$styleable.NavigationView_android_background;
        Drawable drawable2 = ((TintTypedArray)object).getDrawable(n10);
        ViewCompat.setBackground((View)this, drawable2);
        n10 = R$styleable.NavigationView_elevation;
        boolean n13 = ((TintTypedArray)object).hasValue(n10);
        if (n13) {
            n10 = ((TintTypedArray)object).getDimensionPixelSize(n10, 0);
            f10 = n10;
            ViewCompat.setElevation((View)this, f10);
        }
        n10 = R$styleable.NavigationView_android_fitsSystemWindows;
        n10 = (int)(((TintTypedArray)object).getBoolean(n10, false) ? 1 : 0);
        ViewCompat.setFitsSystemWindows((View)this, n10 != 0);
        n10 = R$styleable.NavigationView_android_maxWidth;
        this.maxWidth = n10 = ((TintTypedArray)object).getDimensionPixelSize(n10, 0);
        n10 = R$styleable.NavigationView_itemIconTint;
        boolean bl2 = ((TintTypedArray)object).hasValue(n10);
        if (bl2) {
            drawable2 = ((TintTypedArray)object).getColorStateList(n10);
        } else {
            n10 = 16842808;
            f10 = 2.3693715E-38f;
            drawable2 = this.createDefaultColorStateList(n10);
        }
        int n14 = R$styleable.NavigationView_itemTextAppearance;
        boolean bl3 = ((TintTypedArray)object).hasValue(n14);
        int n15 = 1;
        if (bl3) {
            int n16 = ((TintTypedArray)object).getResourceId(n14, 0);
            int n17 = n15;
        } else {
            boolean bl4 = false;
            boolean bl5 = false;
        }
        n12 = 0;
        ColorStateList colorStateList = null;
        n11 = R$styleable.NavigationView_itemTextColor;
        boolean bl6 = ((TintTypedArray)object).hasValue(n11);
        if (bl6) {
            colorStateList = ((TintTypedArray)object).getColorStateList(n11);
        }
        if (var13_21 == false && colorStateList == null) {
            n12 = 16842806;
            colorStateList = this.createDefaultColorStateList(n12);
        }
        n11 = R$styleable.NavigationView_itemBackground;
        Drawable drawable3 = ((TintTypedArray)object).getDrawable(n11);
        int n18 = R$styleable.NavigationView_itemHorizontalPadding;
        boolean bl7 = ((TintTypedArray)object).hasValue(n18);
        if (bl7) {
            int n19 = ((TintTypedArray)object).getDimensionPixelSize(n18, 0);
            navigationMenuPresenter.setItemHorizontalPadding(n19);
        }
        int n21 = R$styleable.NavigationView_itemIconPadding;
        n21 = ((TintTypedArray)object).getDimensionPixelSize(n21, 0);
        NavigationView$1 navigationView$1 = new NavigationView$1(this);
        navigationMenu.setCallback(navigationView$1);
        navigationMenuPresenter.setId(n15);
        navigationMenuPresenter.initForMenu(context, navigationMenu);
        navigationMenuPresenter.setItemIconTintList((ColorStateList)drawable2);
        if (var13_21 != false) {
            void var11_16;
            navigationMenuPresenter.setItemTextAppearance((int)var11_16);
        }
        navigationMenuPresenter.setItemTextColor(colorStateList);
        navigationMenuPresenter.setItemBackground(drawable3);
        navigationMenuPresenter.setItemIconPadding(n21);
        navigationMenu.addMenuPresenter(navigationMenuPresenter);
        context = (View)navigationMenuPresenter.getMenuView((ViewGroup)this);
        this.addView((View)context);
        int n22 = R$styleable.NavigationView_menu;
        n10 = (int)(((TintTypedArray)object).hasValue(n22) ? 1 : 0);
        if (n10 != 0) {
            n22 = ((TintTypedArray)object).getResourceId(n22, 0);
            this.inflateMenu(n22);
        }
        if ((n10 = (int)(((TintTypedArray)object).hasValue(n22 = R$styleable.NavigationView_headerLayout) ? 1 : 0)) != 0) {
            n22 = ((TintTypedArray)object).getResourceId(n22, 0);
            this.inflateHeaderView(n22);
        }
        ((TintTypedArray)object).recycle();
    }

    private ColorStateList createDefaultColorStateList(int n10) {
        int n11;
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.getContext().getTheme();
        int n12 = 1;
        n10 = (int)(theme.resolveAttribute(n10, typedValue, n12 != 0) ? 1 : 0);
        int n13 = 0;
        theme = null;
        if (n10 == 0) {
            return null;
        }
        Context context = this.getContext();
        int n14 = typedValue.resourceId;
        context = AppCompatResources.getColorStateList(context, n14);
        Resources.Theme theme2 = this.getContext().getTheme();
        n14 = (int)(theme2.resolveAttribute(n11 = androidx.appcompat.R$attr.colorPrimary, typedValue, n12 != 0) ? 1 : 0);
        if (n14 == 0) {
            return null;
        }
        int n15 = typedValue.data;
        n13 = context.getDefaultColor();
        n11 = 3;
        int[][] nArrayArray = new int[n11][];
        int[] nArray = DISABLED_STATE_SET;
        nArrayArray[0] = nArray;
        int[] nArray2 = CHECKED_STATE_SET;
        nArrayArray[n12] = nArray2;
        nArray2 = FrameLayout.EMPTY_STATE_SET;
        int n16 = 2;
        nArrayArray[n16] = nArray2;
        int[] nArray3 = new int[n11];
        nArray3[0] = n10 = context.getColorForState(nArray, n13);
        nArray3[n12] = n15;
        nArray3[n16] = n13;
        theme2 = new ColorStateList((int[][])nArrayArray, nArray3);
        return theme2;
    }

    private MenuInflater getMenuInflater() {
        MenuInflater menuInflater = this.menuInflater;
        if (menuInflater == null) {
            Context context = this.getContext();
            this.menuInflater = menuInflater = new SupportMenuInflater(context);
        }
        return this.menuInflater;
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int n10) {
        return this.presenter.getHeaderView(n10);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int n10) {
        return this.presenter.inflateHeaderView(n10);
    }

    public void inflateMenu(int n10) {
        this.presenter.setUpdateSuspended(true);
        MenuInflater menuInflater = this.getMenuInflater();
        NavigationMenu navigationMenu = this.menu;
        menuInflater.inflate(n10, (Menu)navigationMenu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public void onInsetsChanged(WindowInsetsCompat windowInsetsCompat) {
        this.presenter.dispatchApplyWindowInsets(windowInsetsCompat);
    }

    public void onMeasure(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n10);
        int n13 = -1 << -1;
        int n14 = 0x40000000;
        if (n12 != n13) {
            if (n12 == 0) {
                n10 = View.MeasureSpec.makeMeasureSpec((int)this.maxWidth, (int)n14);
            }
        } else {
            n10 = View.MeasureSpec.getSize((int)n10);
            n12 = this.maxWidth;
            n10 = View.MeasureSpec.makeMeasureSpec((int)Math.min(n10, n12), (int)n14);
        }
        super.onMeasure(n10, n11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof NavigationView$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (NavigationView$SavedState)parcelable;
        Object object = parcelable.getSuperState();
        super.onRestoreInstanceState((Parcelable)object);
        object = this.menu;
        parcelable = parcelable.menuState;
        ((MenuBuilder)object).restorePresenterStates((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable parcelable = super.onSaveInstanceState();
        NavigationView$SavedState navigationView$SavedState = new NavigationView$SavedState(parcelable);
        parcelable = new Bundle();
        navigationView$SavedState.menuState = parcelable;
        this.menu.savePresenterStates((Bundle)parcelable);
        return navigationView$SavedState;
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setCheckedItem(int n10) {
        Object object = this.menu;
        MenuItem menuItem = ((MenuBuilder)object).findItem(n10);
        if (menuItem != null) {
            object = this.presenter;
            menuItem = (MenuItemImpl)menuItem;
            ((NavigationMenuPresenter)object).setCheckedItem((MenuItemImpl)menuItem);
        }
    }

    public void setCheckedItem(MenuItem object) {
        Object object2 = this.menu;
        int n10 = object.getItemId();
        if ((object = ((MenuBuilder)object2).findItem(n10)) != null) {
            object2 = this.presenter;
            object = (MenuItemImpl)object;
            ((NavigationMenuPresenter)object2).setCheckedItem((MenuItemImpl)object);
            return;
        }
        object = new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
        throw object;
    }

    public void setItemBackground(Drawable drawable2) {
        this.presenter.setItemBackground(drawable2);
    }

    public void setItemBackgroundResource(int n10) {
        Drawable drawable2 = ContextCompat.getDrawable(this.getContext(), n10);
        this.setItemBackground(drawable2);
    }

    public void setItemHorizontalPadding(int n10) {
        this.presenter.setItemHorizontalPadding(n10);
    }

    public void setItemHorizontalPaddingResource(int n10) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        n10 = this.getResources().getDimensionPixelSize(n10);
        navigationMenuPresenter.setItemHorizontalPadding(n10);
    }

    public void setItemIconPadding(int n10) {
        this.presenter.setItemIconPadding(n10);
    }

    public void setItemIconPaddingResource(int n10) {
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        n10 = this.getResources().getDimensionPixelSize(n10);
        navigationMenuPresenter.setItemIconPadding(n10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemTextAppearance(int n10) {
        this.presenter.setItemTextAppearance(n10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setNavigationItemSelectedListener(NavigationView$OnNavigationItemSelectedListener navigationView$OnNavigationItemSelectedListener) {
        this.listener = navigationView$OnNavigationItemSelectedListener;
    }
}

