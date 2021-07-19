/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.CollapsibleActionView
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS$ActionProviderWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS$ActionProviderWrapperJB;
import androidx.appcompat.view.menu.MenuItemWrapperICS$CollapsibleActionViewWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS$OnActionExpandListenerWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS$OnMenuItemClickListenerWrapper;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

public class MenuItemWrapperICS
extends BaseMenuWrapper
implements MenuItem {
    public static final String LOG_TAG = "MenuItemWrapper";
    private Method mSetExclusiveCheckableMethod;
    private final SupportMenuItem mWrappedObject;

    public MenuItemWrapperICS(Context object, SupportMenuItem supportMenuItem) {
        super((Context)object);
        if (supportMenuItem != null) {
            this.mWrappedObject = supportMenuItem;
            return;
        }
        super("Wrapped Object can not be null.");
        throw object;
    }

    public boolean collapseActionView() {
        return this.mWrappedObject.collapseActionView();
    }

    public boolean expandActionView() {
        return this.mWrappedObject.expandActionView();
    }

    public ActionProvider getActionProvider() {
        androidx.core.view.ActionProvider actionProvider = this.mWrappedObject.getSupportActionProvider();
        boolean bl2 = actionProvider instanceof MenuItemWrapperICS$ActionProviderWrapper;
        if (bl2) {
            return ((MenuItemWrapperICS$ActionProviderWrapper)actionProvider).mInner;
        }
        return null;
    }

    public View getActionView() {
        View view = this.mWrappedObject.getActionView();
        boolean bl2 = view instanceof MenuItemWrapperICS$CollapsibleActionViewWrapper;
        if (bl2) {
            view = ((MenuItemWrapperICS$CollapsibleActionViewWrapper)view).getWrappedView();
        }
        return view;
    }

    public int getAlphabeticModifiers() {
        return this.mWrappedObject.getAlphabeticModifiers();
    }

    public char getAlphabeticShortcut() {
        return this.mWrappedObject.getAlphabeticShortcut();
    }

    public CharSequence getContentDescription() {
        return this.mWrappedObject.getContentDescription();
    }

    public int getGroupId() {
        return this.mWrappedObject.getGroupId();
    }

    public Drawable getIcon() {
        return this.mWrappedObject.getIcon();
    }

    public ColorStateList getIconTintList() {
        return this.mWrappedObject.getIconTintList();
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mWrappedObject.getIconTintMode();
    }

    public Intent getIntent() {
        return this.mWrappedObject.getIntent();
    }

    public int getItemId() {
        return this.mWrappedObject.getItemId();
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mWrappedObject.getMenuInfo();
    }

    public int getNumericModifiers() {
        return this.mWrappedObject.getNumericModifiers();
    }

    public char getNumericShortcut() {
        return this.mWrappedObject.getNumericShortcut();
    }

    public int getOrder() {
        return this.mWrappedObject.getOrder();
    }

    public SubMenu getSubMenu() {
        SubMenu subMenu = this.mWrappedObject.getSubMenu();
        return this.getSubMenuWrapper(subMenu);
    }

    public CharSequence getTitle() {
        return this.mWrappedObject.getTitle();
    }

    public CharSequence getTitleCondensed() {
        return this.mWrappedObject.getTitleCondensed();
    }

    public CharSequence getTooltipText() {
        return this.mWrappedObject.getTooltipText();
    }

    public boolean hasSubMenu() {
        return this.mWrappedObject.hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return this.mWrappedObject.isActionViewExpanded();
    }

    public boolean isCheckable() {
        return this.mWrappedObject.isCheckable();
    }

    public boolean isChecked() {
        return this.mWrappedObject.isChecked();
    }

    public boolean isEnabled() {
        return this.mWrappedObject.isEnabled();
    }

    public boolean isVisible() {
        return this.mWrappedObject.isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        MenuItemWrapperICS$ActionProviderWrapper menuItemWrapperICS$ActionProviderWrapper;
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 >= n11) {
            object = this.mContext;
            menuItemWrapperICS$ActionProviderWrapper = new MenuItemWrapperICS$ActionProviderWrapperJB(this, (Context)object, actionProvider);
        } else {
            object = this.mContext;
            menuItemWrapperICS$ActionProviderWrapper = new MenuItemWrapperICS$ActionProviderWrapper(this, (Context)object, actionProvider);
        }
        object = this.mWrappedObject;
        if (actionProvider == null) {
            n10 = 0;
            menuItemWrapperICS$ActionProviderWrapper = null;
        }
        object.setSupportActionProvider(menuItemWrapperICS$ActionProviderWrapper);
        return this;
    }

    public MenuItem setActionView(int n10) {
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        supportMenuItem.setActionView(n10);
        View view = this.mWrappedObject.getActionView();
        boolean bl2 = view instanceof CollapsibleActionView;
        if (bl2) {
            supportMenuItem = this.mWrappedObject;
            MenuItemWrapperICS$CollapsibleActionViewWrapper menuItemWrapperICS$CollapsibleActionViewWrapper = new MenuItemWrapperICS$CollapsibleActionViewWrapper(view);
            supportMenuItem.setActionView((View)menuItemWrapperICS$CollapsibleActionViewWrapper);
        }
        return this;
    }

    public MenuItem setActionView(View object) {
        boolean bl2 = object instanceof CollapsibleActionView;
        if (bl2) {
            MenuItemWrapperICS$CollapsibleActionViewWrapper menuItemWrapperICS$CollapsibleActionViewWrapper = new MenuItemWrapperICS$CollapsibleActionViewWrapper((View)object);
            object = menuItemWrapperICS$CollapsibleActionViewWrapper;
        }
        this.mWrappedObject.setActionView((View)object);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10) {
        this.mWrappedObject.setAlphabeticShortcut(c10);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c10, int n10) {
        this.mWrappedObject.setAlphabeticShortcut(c10, n10);
        return this;
    }

    public MenuItem setCheckable(boolean bl2) {
        this.mWrappedObject.setCheckable(bl2);
        return this;
    }

    public MenuItem setChecked(boolean bl2) {
        this.mWrappedObject.setChecked(bl2);
        return this;
    }

    public MenuItem setContentDescription(CharSequence charSequence) {
        this.mWrappedObject.setContentDescription(charSequence);
        return this;
    }

    public MenuItem setEnabled(boolean bl2) {
        this.mWrappedObject.setEnabled(bl2);
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setExclusiveCheckable(boolean bl2) {
        try {
            Object object;
            Method method = this.mSetExclusiveCheckableMethod;
            Object var3_9 = null;
            int n10 = 1;
            if (method == null) {
                Method method2;
                Class<Boolean> clazz;
                SupportMenuItem supportMenuItem = this.mWrappedObject;
                Class<?> clazz2 = supportMenuItem.getClass();
                object = "setExclusiveCheckable";
                Class[] classArray = new Class[n10];
                classArray[0] = clazz = Boolean.TYPE;
                this.mSetExclusiveCheckableMethod = method2 = clazz2.getDeclaredMethod((String)object, classArray);
            }
            Method method3 = this.mSetExclusiveCheckableMethod;
            object = this.mWrappedObject;
            Object[] objectArray = new Object[n10];
            Boolean bl3 = bl2;
            objectArray[0] = bl3;
            method3.invoke(object, objectArray);
            return;
        }
        catch (Exception exception) {
            String string2 = LOG_TAG;
            String string3 = "Error while calling setExclusiveCheckable";
            Log.w((String)string2, (String)string3, (Throwable)exception);
        }
    }

    public MenuItem setIcon(int n10) {
        this.mWrappedObject.setIcon(n10);
        return this;
    }

    public MenuItem setIcon(Drawable drawable2) {
        this.mWrappedObject.setIcon(drawable2);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mWrappedObject.setIconTintList(colorStateList);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mWrappedObject.setIconTintMode(mode);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mWrappedObject.setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c10) {
        this.mWrappedObject.setNumericShortcut(c10);
        return this;
    }

    public MenuItem setNumericShortcut(char c10, int n10) {
        this.mWrappedObject.setNumericShortcut(c10, n10);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        MenuItemWrapperICS$OnActionExpandListenerWrapper menuItemWrapperICS$OnActionExpandListenerWrapper = onActionExpandListener != null ? new MenuItemWrapperICS$OnActionExpandListenerWrapper(this, onActionExpandListener) : null;
        supportMenuItem.setOnActionExpandListener(menuItemWrapperICS$OnActionExpandListenerWrapper);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        SupportMenuItem supportMenuItem = this.mWrappedObject;
        MenuItemWrapperICS$OnMenuItemClickListenerWrapper menuItemWrapperICS$OnMenuItemClickListenerWrapper = onMenuItemClickListener != null ? new MenuItemWrapperICS$OnMenuItemClickListenerWrapper(this, onMenuItemClickListener) : null;
        supportMenuItem.setOnMenuItemClickListener(menuItemWrapperICS$OnMenuItemClickListenerWrapper);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11) {
        this.mWrappedObject.setShortcut(c10, c11);
        return this;
    }

    public MenuItem setShortcut(char c10, char c11, int n10, int n11) {
        this.mWrappedObject.setShortcut(c10, c11, n10, n11);
        return this;
    }

    public void setShowAsAction(int n10) {
        this.mWrappedObject.setShowAsAction(n10);
    }

    public MenuItem setShowAsActionFlags(int n10) {
        this.mWrappedObject.setShowAsActionFlags(n10);
        return this;
    }

    public MenuItem setTitle(int n10) {
        this.mWrappedObject.setTitle(n10);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mWrappedObject.setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mWrappedObject.setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setTooltipText(CharSequence charSequence) {
        this.mWrappedObject.setTooltipText(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean bl2) {
        return this.mWrappedObject.setVisible(bl2);
    }
}

