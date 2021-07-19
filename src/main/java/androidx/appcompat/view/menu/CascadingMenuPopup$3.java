/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  android.view.MenuItem
 */
package androidx.appcompat.view.menu;

import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.CascadingMenuPopup$3$1;
import androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.MenuItemHoverListener;

public class CascadingMenuPopup$3
implements MenuItemHoverListener {
    public final /* synthetic */ CascadingMenuPopup this$0;

    public CascadingMenuPopup$3(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        int n10;
        int n11;
        int n12;
        Object object;
        Object object2;
        block4: {
            object2 = this.this$0.mSubMenuHoverHandler;
            object = null;
            object2.removeCallbacksAndMessages(null);
            object2 = this.this$0.mShowingMenus;
            n12 = object2.size();
            n11 = 0;
            while (true) {
                n10 = -1;
                if (n11 >= n12) break;
                MenuBuilder menuBuilder2 = ((CascadingMenuPopup$CascadingMenuInfo)this.this$0.mShowingMenus.get((int)n11)).menu;
                if (menuBuilder != menuBuilder2) {
                    ++n11;
                    continue;
                }
                break block4;
                break;
            }
            n11 = n10;
        }
        if (n11 == n10) {
            return;
        }
        object2 = this.this$0.mShowingMenus;
        n12 = object2.size();
        if (++n11 < n12) {
            object = object2 = this.this$0.mShowingMenus.get(n11);
            object = (CascadingMenuPopup$CascadingMenuInfo)object2;
        }
        object2 = new CascadingMenuPopup$3$1(this, (CascadingMenuPopup$CascadingMenuInfo)object, menuItem, menuBuilder);
        long l10 = SystemClock.uptimeMillis() + 200L;
        this.this$0.mSubMenuHoverHandler.postAtTime((Runnable)object2, (Object)menuBuilder, l10);
    }

    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages((Object)menuBuilder);
    }
}

