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
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

public final class AppCompatDelegateImpl$ActionMenuPresenterCallback
implements MenuPresenter$Callback {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$ActionMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        this.this$0.checkCloseActionMenu(menuBuilder);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Window.Callback callback = this.this$0.getWindowCallback();
        if (callback != null) {
            int n10 = 108;
            callback.onMenuOpened(n10, (Menu)menuBuilder);
        }
        return true;
    }
}

