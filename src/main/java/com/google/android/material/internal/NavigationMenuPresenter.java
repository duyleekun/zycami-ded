/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.internal.NavigationMenuPresenter$1;
import com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuAdapter;
import com.google.android.material.internal.NavigationMenuView;

public class NavigationMenuPresenter
implements MenuPresenter {
    private static final String STATE_ADAPTER = "android:menu:adapter";
    private static final String STATE_HEADER = "android:menu:header";
    private static final String STATE_HIERARCHY = "android:menu:list";
    public NavigationMenuPresenter$NavigationMenuAdapter adapter;
    private MenuPresenter$Callback callback;
    public LinearLayout headerLayout;
    public ColorStateList iconTintList;
    private int id;
    public Drawable itemBackground;
    public int itemHorizontalPadding;
    public int itemIconPadding;
    public LayoutInflater layoutInflater;
    public MenuBuilder menu;
    private NavigationMenuView menuView;
    public final View.OnClickListener onClickListener;
    public int paddingSeparator;
    private int paddingTopDefault;
    public int textAppearance;
    public boolean textAppearanceSet;
    public ColorStateList textColor;

    public NavigationMenuPresenter() {
        NavigationMenuPresenter$1 navigationMenuPresenter$1 = new NavigationMenuPresenter$1(this);
        this.onClickListener = navigationMenuPresenter$1;
    }

    public void addHeaderView(View object) {
        this.headerLayout.addView(object);
        object = this.menuView;
        int n10 = object.getPaddingBottom();
        object.setPadding(0, 0, 0, n10);
    }

    public boolean collapseItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public void dispatchApplyWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        int n10 = this.paddingTopDefault;
        int n11 = windowInsetsCompat.getSystemWindowInsetTop();
        if (n10 != n11) {
            this.paddingTopDefault = n11;
            Object object = this.headerLayout;
            n11 = object.getChildCount();
            if (n11 == 0) {
                object = this.menuView;
                n10 = this.paddingTopDefault;
                int n12 = object.getPaddingBottom();
                object.setPadding(0, n10, 0, n12);
            }
        }
        ViewCompat.dispatchApplyWindowInsets((View)this.headerLayout, windowInsetsCompat);
    }

    public boolean expandItemActionView(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public MenuItemImpl getCheckedItem() {
        return this.adapter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.headerLayout.getChildCount();
    }

    public View getHeaderView(int n10) {
        return this.headerLayout.getChildAt(n10);
    }

    public int getId() {
        return this.id;
    }

    public Drawable getItemBackground() {
        return this.itemBackground;
    }

    public int getItemHorizontalPadding() {
        return this.itemHorizontalPadding;
    }

    public int getItemIconPadding() {
        return this.itemIconPadding;
    }

    public ColorStateList getItemTextColor() {
        return this.textColor;
    }

    public ColorStateList getItemTintList() {
        return this.iconTintList;
    }

    public MenuView getMenuView(ViewGroup object) {
        Object object2 = this.menuView;
        if (object2 == null) {
            object2 = this.layoutInflater;
            int n10 = R$layout.design_navigation_menu;
            object = (NavigationMenuView)object2.inflate(n10, (ViewGroup)object, false);
            this.menuView = object;
            object = this.adapter;
            if (object == null) {
                object = new NavigationMenuPresenter$NavigationMenuAdapter(this);
                this.adapter = object;
            }
            object = this.layoutInflater;
            int n11 = R$layout.design_navigation_item_header;
            NavigationMenuView navigationMenuView = this.menuView;
            object = (LinearLayout)object.inflate(n11, (ViewGroup)navigationMenuView, false);
            this.headerLayout = object;
            object = this.menuView;
            object2 = this.adapter;
            ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object2);
        }
        return this.menuView;
    }

    public View inflateHeaderView(int n10) {
        LayoutInflater layoutInflater = this.layoutInflater;
        LinearLayout linearLayout = this.headerLayout;
        View view = layoutInflater.inflate(n10, (ViewGroup)linearLayout, false);
        this.addHeaderView(view);
        return view;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        int n10;
        LayoutInflater layoutInflater;
        this.layoutInflater = layoutInflater = LayoutInflater.from((Context)context);
        this.menu = menuBuilder;
        context = context.getResources();
        int n11 = R$dimen.design_navigation_separator_vertical_padding;
        this.paddingSeparator = n10 = context.getDimensionPixelOffset(n11);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        MenuPresenter$Callback menuPresenter$Callback = this.callback;
        if (menuPresenter$Callback != null) {
            menuPresenter$Callback.onCloseMenu(menuBuilder, bl2);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof Bundle;
        if (bl2) {
            Object object;
            Object object2 = (parcelable = (Bundle)parcelable).getSparseParcelableArray(STATE_HIERARCHY);
            if (object2 != null) {
                object = this.menuView;
                object.restoreHierarchyState(object2);
            }
            if ((object2 = parcelable.getBundle(STATE_ADAPTER)) != null) {
                object = this.adapter;
                ((NavigationMenuPresenter$NavigationMenuAdapter)object).restoreInstanceState((Bundle)object2);
            }
            if ((parcelable = parcelable.getSparseParcelableArray((String)(object2 = STATE_HEADER))) != null) {
                object2 = this.headerLayout;
                object2.restoreHierarchyState((SparseArray)parcelable);
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        String string2;
        Bundle bundle = new Bundle();
        Object object = this.menuView;
        if (object != null) {
            object = new SparseArray();
            this.menuView.saveHierarchyState((SparseArray)object);
            string2 = STATE_HIERARCHY;
            bundle.putSparseParcelableArray(string2, (SparseArray)object);
        }
        if ((object = this.adapter) != null) {
            object = ((NavigationMenuPresenter$NavigationMenuAdapter)object).createInstanceState();
            string2 = STATE_ADAPTER;
            bundle.putBundle(string2, (Bundle)object);
        }
        if ((object = this.headerLayout) != null) {
            object = new SparseArray();
            this.headerLayout.saveHierarchyState((SparseArray)object);
            string2 = STATE_HEADER;
            bundle.putSparseParcelableArray(string2, (SparseArray)object);
        }
        return bundle;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    public void removeHeaderView(View object) {
        LinearLayout linearLayout = this.headerLayout;
        linearLayout.removeView(object);
        object = this.headerLayout;
        int n10 = object.getChildCount();
        if (n10 == 0) {
            object = this.menuView;
            int n11 = this.paddingTopDefault;
            int n12 = object.getPaddingBottom();
            object.setPadding(0, n11, 0, n12);
        }
    }

    public void setCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.callback = menuPresenter$Callback;
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        this.adapter.setCheckedItem(menuItemImpl);
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setItemBackground(Drawable drawable2) {
        this.itemBackground = drawable2;
        this.updateMenuView(false);
    }

    public void setItemHorizontalPadding(int n10) {
        this.itemHorizontalPadding = n10;
        this.updateMenuView(false);
    }

    public void setItemIconPadding(int n10) {
        this.itemIconPadding = n10;
        this.updateMenuView(false);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.iconTintList = colorStateList;
        this.updateMenuView(false);
    }

    public void setItemTextAppearance(int n10) {
        this.textAppearance = n10;
        this.textAppearanceSet = true;
        this.updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
        this.updateMenuView(false);
    }

    public void setUpdateSuspended(boolean bl2) {
        NavigationMenuPresenter$NavigationMenuAdapter navigationMenuPresenter$NavigationMenuAdapter = this.adapter;
        if (navigationMenuPresenter$NavigationMenuAdapter != null) {
            navigationMenuPresenter$NavigationMenuAdapter.setUpdateSuspended(bl2);
        }
    }

    public void updateMenuView(boolean bl2) {
        NavigationMenuPresenter$NavigationMenuAdapter navigationMenuPresenter$NavigationMenuAdapter = this.adapter;
        if (navigationMenuPresenter$NavigationMenuAdapter != null) {
            navigationMenuPresenter$NavigationMenuAdapter.update();
        }
    }
}

