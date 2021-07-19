/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.Window;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

public final class ToolbarActionBar$ActionMenuPresenterCallback
implements MenuPresenter$Callback {
    private boolean mClosingActionMenu;
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$ActionMenuPresenterCallback(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        bl2 = this.mClosingActionMenu;
        if (bl2) {
            return;
        }
        this.mClosingActionMenu = bl2 = true;
        this.this$0.mDecorToolbar.dismissPopupMenus();
        Window.Callback callback = this.this$0.mWindowCallback;
        if (callback != null) {
            int n10 = 108;
            callback.onPanelClosed(n10, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback = this.this$0.mWindowCallback;
        if (callback != null) {
            callback.onMenuOpened(108, (Menu)menuBuilder);
            return true;
        }
        return false;
    }
}

