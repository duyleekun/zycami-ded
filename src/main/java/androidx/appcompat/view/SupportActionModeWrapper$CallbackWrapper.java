/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.Menu
 *  android.view.MenuItem
 */
package androidx.appcompat.view;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.view.menu.MenuWrapperICS;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;
import java.util.ArrayList;

public class SupportActionModeWrapper$CallbackWrapper
implements ActionMode$Callback {
    public final ArrayList mActionModes;
    public final Context mContext;
    public final SimpleArrayMap mMenus;
    public final ActionMode.Callback mWrappedCallback;

    public SupportActionModeWrapper$CallbackWrapper(Context object, ActionMode.Callback callback) {
        this.mContext = object;
        this.mWrappedCallback = callback;
        this.mActionModes = object;
        super();
        this.mMenus = object;
    }

    private Menu getMenuWrapper(Menu menu2) {
        Menu menu3 = (Menu)this.mMenus.get(menu2);
        if (menu3 == null) {
            Object object = this.mContext;
            Menu menu4 = menu2;
            menu4 = (SupportMenu)menu2;
            menu3 = new MenuWrapperICS((Context)object, (SupportMenu)menu4);
            object = this.mMenus;
            ((SimpleArrayMap)object).put(menu2, menu3);
        }
        return menu3;
    }

    public android.view.ActionMode getActionModeWrapper(ActionMode actionMode) {
        Object object = this.mActionModes;
        int n10 = object.size();
        Context context = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            ActionMode actionMode2;
            SupportActionModeWrapper supportActionModeWrapper = (SupportActionModeWrapper)((Object)this.mActionModes.get(i10));
            if (supportActionModeWrapper == null || (actionMode2 = supportActionModeWrapper.mWrappedObject) != actionMode) continue;
            return supportActionModeWrapper;
        }
        context = this.mContext;
        object = new SupportActionModeWrapper(context, actionMode);
        this.mActionModes.add(object);
        return object;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        ActionMode.Callback callback = this.mWrappedCallback;
        actionMode = this.getActionModeWrapper(actionMode);
        Context context = this.mContext;
        menuItem = (SupportMenuItem)menuItem;
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(context, (SupportMenuItem)menuItem);
        return callback.onActionItemClicked((android.view.ActionMode)actionMode, (MenuItem)menuItemWrapperICS);
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu2) {
        ActionMode.Callback callback = this.mWrappedCallback;
        actionMode = this.getActionModeWrapper(actionMode);
        menu2 = this.getMenuWrapper(menu2);
        return callback.onCreateActionMode((android.view.ActionMode)actionMode, menu2);
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        ActionMode.Callback callback = this.mWrappedCallback;
        actionMode = this.getActionModeWrapper(actionMode);
        callback.onDestroyActionMode((android.view.ActionMode)actionMode);
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu2) {
        ActionMode.Callback callback = this.mWrappedCallback;
        actionMode = this.getActionModeWrapper(actionMode);
        menu2 = this.getMenuWrapper(menu2);
        return callback.onPrepareActionMode((android.view.ActionMode)actionMode, menu2);
    }
}

