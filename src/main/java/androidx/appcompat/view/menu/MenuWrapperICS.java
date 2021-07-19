/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.SubMenu
 */
package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.BaseMenuWrapper;
import androidx.core.internal.view.SupportMenu;

public class MenuWrapperICS
extends BaseMenuWrapper
implements Menu {
    private final SupportMenu mWrappedObject;

    public MenuWrapperICS(Context object, SupportMenu supportMenu) {
        super((Context)object);
        if (supportMenu != null) {
            this.mWrappedObject = supportMenu;
            return;
        }
        super("Wrapped Object can not be null.");
        throw object;
    }

    public MenuItem add(int n10) {
        MenuItem menuItem = this.mWrappedObject.add(n10);
        return this.getMenuItemWrapper(menuItem);
    }

    public MenuItem add(int n10, int n11, int n12, int n13) {
        MenuItem menuItem = this.mWrappedObject.add(n10, n11, n12, n13);
        return this.getMenuItemWrapper(menuItem);
    }

    public MenuItem add(int n10, int n11, int n12, CharSequence charSequence) {
        MenuItem menuItem = this.mWrappedObject.add(n10, n11, n12, charSequence);
        return this.getMenuItemWrapper(menuItem);
    }

    public MenuItem add(CharSequence charSequence) {
        charSequence = this.mWrappedObject.add(charSequence);
        return this.getMenuItemWrapper((MenuItem)charSequence);
    }

    public int addIntentOptions(int n10, int n11, int n12, ComponentName componentName, Intent[] intentArray, Intent intent, int n13, MenuItem[] menuItemArray) {
        MenuItem[] menuItemArray2;
        int n14;
        MenuWrapperICS menuWrapperICS = this;
        MenuItem[] menuItemArray3 = menuItemArray;
        if (menuItemArray != null) {
            n14 = menuItemArray.length;
            menuItemArray2 = new MenuItem[n14];
        } else {
            n14 = 0;
            menuItemArray2 = null;
        }
        SupportMenu supportMenu = menuWrapperICS.mWrappedObject;
        int n15 = n10;
        int n16 = n11;
        int n17 = supportMenu.addIntentOptions(n10, n11, n12, componentName, intentArray, intent, n13, menuItemArray2);
        if (menuItemArray2 != null) {
            for (MenuItem menuItem : menuItemArray2) {
                menuItemArray3[n15] = menuItem = this.getMenuItemWrapper(menuItem);
            }
        }
        return n17;
    }

    public SubMenu addSubMenu(int n10) {
        SubMenu subMenu = this.mWrappedObject.addSubMenu(n10);
        return this.getSubMenuWrapper(subMenu);
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, int n13) {
        SubMenu subMenu = this.mWrappedObject.addSubMenu(n10, n11, n12, n13);
        return this.getSubMenuWrapper(subMenu);
    }

    public SubMenu addSubMenu(int n10, int n11, int n12, CharSequence charSequence) {
        SubMenu subMenu = this.mWrappedObject.addSubMenu(n10, n11, n12, charSequence);
        return this.getSubMenuWrapper(subMenu);
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        charSequence = this.mWrappedObject.addSubMenu(charSequence);
        return this.getSubMenuWrapper((SubMenu)charSequence);
    }

    public void clear() {
        this.internalClear();
        this.mWrappedObject.clear();
    }

    public void close() {
        this.mWrappedObject.close();
    }

    public MenuItem findItem(int n10) {
        MenuItem menuItem = this.mWrappedObject.findItem(n10);
        return this.getMenuItemWrapper(menuItem);
    }

    public MenuItem getItem(int n10) {
        MenuItem menuItem = this.mWrappedObject.getItem(n10);
        return this.getMenuItemWrapper(menuItem);
    }

    public boolean hasVisibleItems() {
        return this.mWrappedObject.hasVisibleItems();
    }

    public boolean isShortcutKey(int n10, KeyEvent keyEvent) {
        return this.mWrappedObject.isShortcutKey(n10, keyEvent);
    }

    public boolean performIdentifierAction(int n10, int n11) {
        return this.mWrappedObject.performIdentifierAction(n10, n11);
    }

    public boolean performShortcut(int n10, KeyEvent keyEvent, int n11) {
        return this.mWrappedObject.performShortcut(n10, keyEvent, n11);
    }

    public void removeGroup(int n10) {
        this.internalRemoveGroup(n10);
        this.mWrappedObject.removeGroup(n10);
    }

    public void removeItem(int n10) {
        this.internalRemoveItem(n10);
        this.mWrappedObject.removeItem(n10);
    }

    public void setGroupCheckable(int n10, boolean bl2, boolean bl3) {
        this.mWrappedObject.setGroupCheckable(n10, bl2, bl3);
    }

    public void setGroupEnabled(int n10, boolean bl2) {
        this.mWrappedObject.setGroupEnabled(n10, bl2);
    }

    public void setGroupVisible(int n10, boolean bl2) {
        this.mWrappedObject.setGroupVisible(n10, bl2);
    }

    public void setQwertyMode(boolean bl2) {
        this.mWrappedObject.setQwertyMode(bl2);
    }

    public int size() {
        return this.mWrappedObject.size();
    }
}

