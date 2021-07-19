/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.SubMenu
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.SubMenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

public abstract class BaseMenuWrapper {
    public final Context mContext;
    private SimpleArrayMap mMenuItems;
    private SimpleArrayMap mSubMenus;

    public BaseMenuWrapper(Context context) {
        this.mContext = context;
    }

    public final MenuItem getMenuItemWrapper(MenuItem menuItem) {
        boolean bl2 = menuItem instanceof SupportMenuItem;
        if (bl2) {
            MenuItem menuItem2 = menuItem;
            menuItem2 = (SupportMenuItem)menuItem;
            SimpleArrayMap simpleArrayMap = this.mMenuItems;
            if (simpleArrayMap == null) {
                this.mMenuItems = simpleArrayMap = new SimpleArrayMap();
            }
            if ((menuItem = (MenuItem)(simpleArrayMap = this.mMenuItems).get(menuItem)) == null) {
                simpleArrayMap = this.mContext;
                menuItem = new MenuItemWrapperICS((Context)simpleArrayMap, (SupportMenuItem)menuItem2);
                simpleArrayMap = this.mMenuItems;
                simpleArrayMap.put(menuItem2, menuItem);
            }
        }
        return menuItem;
    }

    public final SubMenu getSubMenuWrapper(SubMenu subMenu) {
        boolean bl2 = subMenu instanceof SupportSubMenu;
        if (bl2) {
            subMenu = (SupportSubMenu)subMenu;
            Object object = this.mSubMenus;
            if (object == null) {
                object = new SimpleArrayMap();
                this.mSubMenus = object;
            }
            if ((object = (SubMenu)this.mSubMenus.get(subMenu)) == null) {
                Object object2 = this.mContext;
                object = new SubMenuWrapperICS((Context)object2, (SupportSubMenu)subMenu);
                object2 = this.mSubMenus;
                ((SimpleArrayMap)object2).put(subMenu, object);
            }
            return object;
        }
        return subMenu;
    }

    public final void internalClear() {
        SimpleArrayMap simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        if ((simpleArrayMap = this.mSubMenus) != null) {
            simpleArrayMap.clear();
        }
    }

    public final void internalRemoveGroup(int n10) {
        Object object;
        int n11;
        SimpleArrayMap simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap == null) {
            return;
        }
        simpleArrayMap = null;
        for (int i10 = 0; i10 < (n11 = ((SimpleArrayMap)(object = this.mMenuItems)).size()); ++i10) {
            object = (SupportMenuItem)this.mMenuItems.keyAt(i10);
            n11 = object.getGroupId();
            if (n11 != n10) continue;
            object = this.mMenuItems;
            ((SimpleArrayMap)object).removeAt(i10);
            i10 += -1;
        }
    }

    public final void internalRemoveItem(int n10) {
        Object object;
        int n11;
        SimpleArrayMap simpleArrayMap = this.mMenuItems;
        if (simpleArrayMap == null) {
            return;
        }
        simpleArrayMap = null;
        for (int i10 = 0; i10 < (n11 = ((SimpleArrayMap)(object = this.mMenuItems)).size()); ++i10) {
            object = (SupportMenuItem)this.mMenuItems.keyAt(i10);
            n11 = object.getItemId();
            if (n11 != n10) continue;
            SimpleArrayMap simpleArrayMap2 = this.mMenuItems;
            simpleArrayMap2.removeAt(i10);
            break;
        }
    }
}

