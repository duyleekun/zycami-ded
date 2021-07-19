/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar$OnMenuItemClickListener;

public class Toolbar$1
implements ActionMenuView$OnMenuItemClickListener {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$1(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        Toolbar$OnMenuItemClickListener toolbar$OnMenuItemClickListener = this.this$0.mOnMenuItemClickListener;
        if (toolbar$OnMenuItemClickListener != null) {
            return toolbar$OnMenuItemClickListener.onMenuItemClick(menuItem);
        }
        return false;
    }
}

