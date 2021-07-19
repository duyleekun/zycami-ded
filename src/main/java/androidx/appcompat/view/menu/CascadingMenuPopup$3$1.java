/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.CascadingMenuPopup$3;
import androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo;
import androidx.appcompat.view.menu.MenuBuilder;

public class CascadingMenuPopup$3$1
implements Runnable {
    public final /* synthetic */ CascadingMenuPopup$3 this$1;
    public final /* synthetic */ MenuItem val$item;
    public final /* synthetic */ MenuBuilder val$menu;
    public final /* synthetic */ CascadingMenuPopup$CascadingMenuInfo val$nextInfo;

    public CascadingMenuPopup$3$1(CascadingMenuPopup$3 var1_1, CascadingMenuPopup$CascadingMenuInfo cascadingMenuPopup$CascadingMenuInfo, MenuItem menuItem, MenuBuilder menuBuilder) {
        this.this$1 = var1_1;
        this.val$nextInfo = cascadingMenuPopup$CascadingMenuInfo;
        this.val$item = menuItem;
        this.val$menu = menuBuilder;
    }

    public void run() {
        boolean bl2;
        int n10;
        CascadingMenuPopup cascadingMenuPopup;
        Object object = this.val$nextInfo;
        if (object != null) {
            cascadingMenuPopup = this.this$1.this$0;
            cascadingMenuPopup.mShouldCloseImmediately = n10 = 1;
            object = ((CascadingMenuPopup$CascadingMenuInfo)object).menu;
            cascadingMenuPopup = null;
            ((MenuBuilder)object).close(false);
            object = this.this$1.this$0;
            ((CascadingMenuPopup)object).mShouldCloseImmediately = false;
        }
        if ((bl2 = (object = this.val$item).isEnabled()) && (bl2 = (object = this.val$item).hasSubMenu())) {
            object = this.val$menu;
            cascadingMenuPopup = this.val$item;
            n10 = 4;
            ((MenuBuilder)object).performItemAction((MenuItem)cascadingMenuPopup, n10);
        }
    }
}

