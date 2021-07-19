/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;

public class ToolbarActionBar$2
implements Toolbar$OnMenuItemClickListener {
    public final /* synthetic */ ToolbarActionBar this$0;

    public ToolbarActionBar$2(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.this$0.mWindowCallback.onMenuItemSelected(0, menuItem);
    }
}

