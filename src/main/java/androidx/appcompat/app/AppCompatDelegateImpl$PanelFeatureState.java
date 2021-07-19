/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$Theme
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.MenuView;

public final class AppCompatDelegateImpl$PanelFeatureState {
    public int background;
    public View createdPanelView;
    public ViewGroup decorView;
    public int featureId;
    public Bundle frozenActionViewState;
    public Bundle frozenMenuState;
    public int gravity;
    public boolean isHandled;
    public boolean isOpen;
    public boolean isPrepared;
    public ListMenuPresenter listMenuPresenter;
    public Context listPresenterContext;
    public MenuBuilder menu;
    public boolean qwertyMode;
    public boolean refreshDecorView;
    public boolean refreshMenuContent;
    public View shownPanelView;
    public boolean wasLastOpen;
    public int windowAnimations;
    public int x;
    public int y;

    public AppCompatDelegateImpl$PanelFeatureState(int n10) {
        this.featureId = n10;
        this.refreshDecorView = false;
    }

    public void applyFrozenState() {
        Bundle bundle;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null && (bundle = this.frozenMenuState) != null) {
            menuBuilder.restorePresenterStates(bundle);
            menuBuilder = null;
            this.frozenMenuState = null;
        }
    }

    public void clearMenuPresenters() {
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null) {
            ListMenuPresenter listMenuPresenter = this.listMenuPresenter;
            menuBuilder.removeMenuPresenter(listMenuPresenter);
        }
        this.listMenuPresenter = null;
    }

    public MenuView getListMenuView(MenuPresenter$Callback object) {
        Object object2 = this.menu;
        if (object2 == null) {
            return null;
        }
        object2 = this.listMenuPresenter;
        if (object2 == null) {
            Context context = this.listPresenterContext;
            int n10 = R$layout.abc_list_menu_item_layout;
            this.listMenuPresenter = object2 = new ListMenuPresenter(context, n10);
            ((ListMenuPresenter)object2).setCallback((MenuPresenter$Callback)object);
            object = this.menu;
            object2 = this.listMenuPresenter;
            ((MenuBuilder)object).addMenuPresenter((MenuPresenter)object2);
        }
        object = this.listMenuPresenter;
        object2 = this.decorView;
        return ((ListMenuPresenter)object).getMenuView((ViewGroup)object2);
    }

    public boolean hasPanelItems() {
        View view = this.shownPanelView;
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        view = this.createdPanelView;
        boolean bl3 = true;
        if (view != null) {
            return bl3;
        }
        view = this.listMenuPresenter.getAdapter();
        int n10 = view.getCount();
        if (n10 > 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int n10;
        parcelable = (AppCompatDelegateImpl$PanelFeatureState$SavedState)parcelable;
        this.featureId = n10 = parcelable.featureId;
        n10 = parcelable.isOpen ? 1 : 0;
        this.wasLastOpen = n10;
        parcelable = parcelable.menuState;
        this.frozenMenuState = parcelable;
        this.shownPanelView = null;
        this.decorView = null;
    }

    public Parcelable onSaveInstanceState() {
        int n10;
        AppCompatDelegateImpl$PanelFeatureState$SavedState appCompatDelegateImpl$PanelFeatureState$SavedState = new AppCompatDelegateImpl$PanelFeatureState$SavedState();
        appCompatDelegateImpl$PanelFeatureState$SavedState.featureId = n10 = this.featureId;
        n10 = this.isOpen ? 1 : 0;
        appCompatDelegateImpl$PanelFeatureState$SavedState.isOpen = n10;
        MenuBuilder menuBuilder = this.menu;
        if (menuBuilder != null) {
            menuBuilder = new Bundle();
            appCompatDelegateImpl$PanelFeatureState$SavedState.menuState = menuBuilder;
            MenuBuilder menuBuilder2 = this.menu;
            menuBuilder2.savePresenterStates((Bundle)menuBuilder);
        }
        return appCompatDelegateImpl$PanelFeatureState$SavedState;
    }

    public void setMenu(MenuBuilder menuBuilder) {
        Object object = this.menu;
        if (menuBuilder == object) {
            return;
        }
        if (object != null) {
            ListMenuPresenter listMenuPresenter = this.listMenuPresenter;
            ((MenuBuilder)object).removeMenuPresenter(listMenuPresenter);
        }
        this.menu = menuBuilder;
        if (menuBuilder != null && (object = this.listMenuPresenter) != null) {
            menuBuilder.addMenuPresenter((MenuPresenter)object);
        }
    }

    public void setStyle(Context object) {
        Object object2 = new TypedValue();
        Resources.Theme theme = object.getResources().newTheme();
        Resources.Theme theme2 = object.getTheme();
        theme.setTo(theme2);
        int n10 = R$attr.actionBarPopupTheme;
        boolean bl2 = true;
        theme.resolveAttribute(n10, object2, bl2);
        n10 = object2.resourceId;
        if (n10 != 0) {
            theme.applyStyle(n10, bl2);
        }
        n10 = R$attr.panelMenuListTheme;
        theme.resolveAttribute(n10, object2, bl2);
        int n11 = object2.resourceId;
        if (n11 != 0) {
            theme.applyStyle(n11, bl2);
        } else {
            n11 = R$style.Theme_AppCompat_CompactMenu;
            theme.applyStyle(n11, bl2);
        }
        object2 = new ContextThemeWrapper((Context)object, 0);
        object2.getTheme().setTo(theme);
        this.listPresenterContext = object2;
        object = R$styleable.AppCompatTheme;
        object = object2.obtainStyledAttributes((int[])object);
        n11 = R$styleable.AppCompatTheme_panelBackground;
        this.background = n11 = object.getResourceId(n11, 0);
        n11 = R$styleable.AppCompatTheme_android_windowAnimationStyle;
        this.windowAnimations = n11 = object.getResourceId(n11, 0);
        object.recycle();
    }
}

