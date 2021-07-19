/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;

public final class ToolbarActionBar$MenuBuilderCallback
implements MenuBuilder$Callback {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$MenuBuilderCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        Object object = this.this$0;
        Window.Callback callback = ((ToolbarActionBar)object).mWindowCallback;
        if (callback != null) {
            object = ((ToolbarActionBar)object).mDecorToolbar;
            boolean bl2 = object.isOverflowMenuShowing();
            int n10 = 108;
            if (bl2) {
                object = this.this$0.mWindowCallback;
                object.onPanelClosed(n10, (Menu)menuBuilder);
            } else {
                object = this.this$0.mWindowCallback;
                bl2 = object.onPreparePanel(0, null, (Menu)menuBuilder);
                if (bl2) {
                    object = this.this$0.mWindowCallback;
                    object.onMenuOpened(n10, (Menu)menuBuilder);
                }
            }
        }
    }
}

