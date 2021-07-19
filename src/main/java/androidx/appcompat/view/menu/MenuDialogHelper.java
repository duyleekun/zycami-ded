/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.DialogInterface$OnDismissListener
 *  android.content.DialogInterface$OnKeyListener
 *  android.graphics.drawable.Drawable
 *  android.os.IBinder
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ListAdapter
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog$Builder;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuPresenter$Callback;

public class MenuDialogHelper
implements DialogInterface.OnKeyListener,
DialogInterface.OnClickListener,
DialogInterface.OnDismissListener,
MenuPresenter$Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    public ListMenuPresenter mPresenter;
    private MenuPresenter$Callback mPresenterCallback;

    public MenuDialogHelper(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void onClick(DialogInterface object, int n10) {
        object = this.mMenu;
        MenuItemImpl menuItemImpl = (MenuItemImpl)this.mPresenter.getAdapter().getItem(n10);
        ((MenuBuilder)object).performItemAction(menuItemImpl, 0);
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        Object object;
        if (bl2 || menuBuilder == (object = this.mMenu)) {
            this.dismiss();
        }
        if ((object = this.mPresenterCallback) != null) {
            object.onCloseMenu(menuBuilder, bl2);
        }
    }

    public void onDismiss(DialogInterface object) {
        object = this.mPresenter;
        MenuBuilder menuBuilder = this.mMenu;
        ((ListMenuPresenter)object).onCloseMenu(menuBuilder, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        int n11 = 82;
        if (n10 == n11 || n10 == (n11 = 4)) {
            n11 = keyEvent.getAction();
            int n12 = 1;
            if (n11 == 0 && (n11 = keyEvent.getRepeatCount()) == 0) {
                dialogInterface = this.mDialog.getWindow();
                if (dialogInterface != null && (dialogInterface = dialogInterface.getDecorView()) != null && (dialogInterface = dialogInterface.getKeyDispatcherState()) != null) {
                    dialogInterface.startTracking(keyEvent, (Object)this);
                    return n12 != 0;
                }
            } else {
                Window window;
                n11 = keyEvent.getAction();
                if (n11 == n12 && (n11 = (int)(keyEvent.isCanceled() ? 1 : 0)) == 0 && (window = this.mDialog.getWindow()) != null && (window = window.getDecorView()) != null && (window = window.getKeyDispatcherState()) != null && (n11 = window.isTracking(keyEvent)) != 0) {
                    this.mMenu.close(n12 != 0);
                    dialogInterface.dismiss();
                    return n12 != 0;
                }
            }
        }
        return this.mMenu.performShortcut(n10, keyEvent, 0);
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        MenuPresenter$Callback menuPresenter$Callback = this.mPresenterCallback;
        if (menuPresenter$Callback != null) {
            return menuPresenter$Callback.onOpenSubMenu(menuBuilder);
        }
        return false;
    }

    public void setPresenterCallback(MenuPresenter$Callback menuPresenter$Callback) {
        this.mPresenterCallback = menuPresenter$Callback;
    }

    public void show(IBinder iBinder) {
        int n10;
        int n11;
        Object object = this.mMenu;
        Object object2 = ((MenuBuilder)object).getContext();
        AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)object2);
        Object object3 = alertDialog$Builder.getContext();
        int n12 = R$layout.abc_list_menu_item_layout;
        object2 = new ListMenuPresenter((Context)object3, n12);
        this.mPresenter = object2;
        ((ListMenuPresenter)object2).setCallback(this);
        object2 = this.mMenu;
        object3 = this.mPresenter;
        ((MenuBuilder)object2).addMenuPresenter((MenuPresenter)object3);
        object2 = this.mPresenter.getAdapter();
        alertDialog$Builder.setAdapter((ListAdapter)object2, this);
        object2 = ((MenuBuilder)object).getHeaderView();
        if (object2 != null) {
            alertDialog$Builder.setCustomTitle((View)object2);
        } else {
            object2 = ((MenuBuilder)object).getHeaderIcon();
            object2 = alertDialog$Builder.setIcon((Drawable)object2);
            object = ((MenuBuilder)object).getHeaderTitle();
            ((AlertDialog$Builder)object2).setTitle((CharSequence)object);
        }
        alertDialog$Builder.setOnKeyListener(this);
        this.mDialog = object = alertDialog$Builder.create();
        object.setOnDismissListener((DialogInterface.OnDismissListener)this);
        object = this.mDialog.getWindow().getAttributes();
        ((WindowManager.LayoutParams)object).type = n11 = 1003;
        if (iBinder != null) {
            ((WindowManager.LayoutParams)object).token = iBinder;
        }
        ((WindowManager.LayoutParams)object).flags = n10 = ((WindowManager.LayoutParams)object).flags | 0x20000;
        this.mDialog.show();
    }
}

