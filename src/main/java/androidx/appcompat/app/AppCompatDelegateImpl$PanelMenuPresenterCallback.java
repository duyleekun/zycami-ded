/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 */
package androidx.appcompat.app;

import android.view.Menu;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

public final class AppCompatDelegateImpl$PanelMenuPresenterCallback
implements MenuPresenter$Callback {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$PanelMenuPresenterCallback(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    /*
     * WARNING - void declaration
     */
    public void onCloseMenu(MenuBuilder object, boolean bl2) {
        void var5_7;
        Object object2 = ((MenuBuilder)object).getRootMenu();
        boolean bl3 = true;
        if (object2 != object) {
            boolean bl4 = bl3;
        } else {
            boolean bl4 = false;
        }
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        if (var5_7 != false) {
            object = object2;
        }
        if ((object = appCompatDelegateImpl.findMenuPanel((Menu)object)) != null) {
            if (var5_7 != false) {
                AppCompatDelegateImpl appCompatDelegateImpl2 = this.this$0;
                int n10 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId;
                appCompatDelegateImpl2.callOnPanelClosed(n10, (AppCompatDelegateImpl$PanelFeatureState)object, (Menu)object2);
                appCompatDelegateImpl2 = this.this$0;
                appCompatDelegateImpl2.closePanel((AppCompatDelegateImpl$PanelFeatureState)object, bl3);
            } else {
                object2 = this.this$0;
                ((AppCompatDelegateImpl)object2).closePanel((AppCompatDelegateImpl$PanelFeatureState)object, bl2);
            }
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        Object object = menuBuilder.getRootMenu();
        if (menuBuilder == object) {
            object = this.this$0;
            int n10 = ((AppCompatDelegateImpl)object).mHasActionBar;
            if (n10 != 0 && (object = ((AppCompatDelegateImpl)object).getWindowCallback()) != null) {
                AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
                n10 = appCompatDelegateImpl.mIsDestroyed;
                if (n10 == 0) {
                    n10 = 108;
                    object.onMenuOpened(n10, (Menu)menuBuilder);
                }
            }
        }
        return true;
    }
}

