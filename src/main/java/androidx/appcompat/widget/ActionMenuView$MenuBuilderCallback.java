/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.widget.ActionMenuView;

public class ActionMenuView$MenuBuilderCallback
implements MenuBuilder$Callback {
    public final /* synthetic */ ActionMenuView this$0;

    public ActionMenuView$MenuBuilderCallback(ActionMenuView actionMenuView) {
        this.this$0 = actionMenuView;
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        boolean bl2;
        object = this.this$0.mOnMenuItemClickListener;
        if (object != null && (bl2 = object.onMenuItemClick(menuItem))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        MenuBuilder$Callback menuBuilder$Callback = this.this$0.mMenuBuilderCallback;
        if (menuBuilder$Callback != null) {
            menuBuilder$Callback.onMenuModeChange(menuBuilder);
        }
    }
}

