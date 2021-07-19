/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.ListView
 */
package androidx.appcompat.view.menu;

import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.MenuPopupWindow;

public class CascadingMenuPopup$CascadingMenuInfo {
    public final MenuBuilder menu;
    public final int position;
    public final MenuPopupWindow window;

    public CascadingMenuPopup$CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int n10) {
        this.window = menuPopupWindow;
        this.menu = menuBuilder;
        this.position = n10;
    }

    public ListView getListView() {
        return this.window.getListView();
    }
}

