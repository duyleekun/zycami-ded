/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.ActionMode
 *  android.view.ActionMode$Callback
 *  android.view.KeyEvent
 *  android.view.Menu
 *  android.view.View
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.content.Context;
import android.os.Build;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState;
import androidx.appcompat.view.SupportActionModeWrapper$CallbackWrapper;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import java.util.List;

public class AppCompatDelegateImpl$AppCompatWindowCallback
extends WindowCallbackWrapper {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$AppCompatWindowCallback(AppCompatDelegateImpl appCompatDelegateImpl, Window.Callback callback) {
        this.this$0 = appCompatDelegateImpl;
        super(callback);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        boolean bl3 = appCompatDelegateImpl.dispatchKeyEvent(keyEvent);
        if (!bl3 && !(bl2 = super.dispatchKeyEvent(keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        int n10;
        AppCompatDelegateImpl appCompatDelegateImpl;
        boolean bl2;
        boolean bl3 = super.dispatchKeyShortcutEvent(keyEvent);
        if (!bl3 && !(bl2 = (appCompatDelegateImpl = this.this$0).onKeyShortcut(n10 = keyEvent.getKeyCode(), keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void onContentChanged() {
    }

    public boolean onCreatePanelMenu(int n10, Menu menu2) {
        boolean bl2;
        if (n10 == 0 && !(bl2 = menu2 instanceof MenuBuilder)) {
            return false;
        }
        return super.onCreatePanelMenu(n10, menu2);
    }

    public boolean onMenuOpened(int n10, Menu menu2) {
        super.onMenuOpened(n10, menu2);
        this.this$0.onMenuOpened(n10);
        return true;
    }

    public void onPanelClosed(int n10, Menu menu2) {
        super.onPanelClosed(n10, menu2);
        this.this$0.onPanelClosed(n10);
    }

    public boolean onPreparePanel(int n10, View view, Menu menu2) {
        Menu menu3;
        boolean bl2 = menu2 instanceof MenuBuilder;
        if (bl2) {
            menu3 = menu2;
            menu3 = (MenuBuilder)menu2;
        } else {
            bl2 = false;
            menu3 = null;
        }
        if (n10 == 0 && menu3 == null) {
            return false;
        }
        if (menu3 != null) {
            boolean bl3 = true;
            menu3.setOverrideVisibleItems(bl3);
        }
        n10 = (int)(super.onPreparePanel(n10, view, menu2) ? 1 : 0);
        if (menu3 != null) {
            menu3.setOverrideVisibleItems(false);
        }
        return n10 != 0;
    }

    public void onProvideKeyboardShortcuts(List list, Menu menu2, int n10) {
        Object object = this.this$0;
        boolean bl2 = true;
        if ((object = ((AppCompatDelegateImpl)object).getPanelState(0, bl2)) != null && (object = ((AppCompatDelegateImpl$PanelFeatureState)object).menu) != null) {
            super.onProvideKeyboardShortcuts(list, (Menu)object, n10);
        } else {
            super.onProvideKeyboardShortcuts(list, menu2, n10);
        }
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return null;
        }
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        n10 = (int)(appCompatDelegateImpl.isHandleNativeActionModesEnabled() ? 1 : 0);
        if (n10 != 0) {
            return this.startAsSupportActionMode(callback);
        }
        return super.onWindowStartingActionMode(callback);
    }

    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int n10) {
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        boolean bl2 = appCompatDelegateImpl.isHandleNativeActionModesEnabled();
        if (bl2 && n10 == 0) {
            return this.startAsSupportActionMode(callback);
        }
        return super.onWindowStartingActionMode(callback, n10);
    }

    public final ActionMode startAsSupportActionMode(ActionMode.Callback object) {
        Context context = this.this$0.mContext;
        SupportActionModeWrapper$CallbackWrapper supportActionModeWrapper$CallbackWrapper = new SupportActionModeWrapper$CallbackWrapper(context, (ActionMode.Callback)object);
        if ((object = this.this$0.startSupportActionMode(supportActionModeWrapper$CallbackWrapper)) != null) {
            return supportActionModeWrapper$CallbackWrapper.getActionModeWrapper((androidx.appcompat.view.ActionMode)object);
        }
        return null;
    }
}

