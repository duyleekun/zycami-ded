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
import androidx.appcompat.widget.PopupMenu;

public class PopupMenu$1
implements MenuBuilder$Callback {
    public final /* synthetic */ PopupMenu this$0;

    public PopupMenu$1(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        object = this.this$0.mMenuItemClickListener;
        if (object != null) {
            return object.onMenuItemClick(menuItem);
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
    }
}

