/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window$Callback
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

public class ToolbarWidgetWrapper$1
implements View.OnClickListener {
    public final ActionMenuItem mNavItem;
    public final /* synthetic */ ToolbarWidgetWrapper this$0;

    public ToolbarWidgetWrapper$1(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        ActionMenuItem actionMenuItem;
        this.this$0 = toolbarWidgetWrapper;
        Context context = toolbarWidgetWrapper.mToolbar.getContext();
        CharSequence charSequence = toolbarWidgetWrapper.mTitle;
        this.mNavItem = actionMenuItem = new ActionMenuItem(context, 0, 16908332, 0, 0, charSequence);
    }

    public void onClick(View object) {
        boolean bl2;
        object = this.this$0;
        Window.Callback callback = object.mWindowCallback;
        if (callback != null && (bl2 = object.mMenuPrepared)) {
            bl2 = false;
            object = null;
            ActionMenuItem actionMenuItem = this.mNavItem;
            callback.onMenuItemSelected(0, (MenuItem)actionMenuItem);
        }
    }
}

