/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.View
 *  android.view.Window$Callback
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.WindowCallbackWrapper;

public class ToolbarActionBar$ToolbarCallbackWrapper
extends WindowCallbackWrapper {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$ToolbarCallbackWrapper(ToolbarActionBar toolbarActionBar, Window.Callback callback) {
        this.this$0 = toolbarActionBar;
        super(callback);
    }

    public View onCreatePanelView(int n10) {
        if (n10 == 0) {
            Context context = this.this$0.mDecorToolbar.getContext();
            View view = new View(context);
            return view;
        }
        return super.onCreatePanelView(n10);
    }

    public boolean onPreparePanel(int n10, View object, Menu menu2) {
        if ((n10 = (int)(super.onPreparePanel(n10, (View)object, menu2) ? 1 : 0)) != 0) {
            object = this.this$0;
            boolean bl2 = object.mToolbarMenuPrepared;
            if (!bl2) {
                object.mDecorToolbar.setMenuPrepared();
                object = this.this$0;
                object.mToolbarMenuPrepared = bl2 = true;
            }
        }
        return n10 != 0;
    }
}

