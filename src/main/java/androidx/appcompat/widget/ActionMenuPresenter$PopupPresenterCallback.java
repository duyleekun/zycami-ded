/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;

public class ActionMenuPresenter$PopupPresenterCallback
implements MenuPresenter$Callback {
    public final /* synthetic */ ActionMenuPresenter this$0;

    public ActionMenuPresenter$PopupPresenterCallback(ActionMenuPresenter actionMenuPresenter) {
        this.this$0 = actionMenuPresenter;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl2) {
        Object object;
        boolean bl3 = menuBuilder instanceof SubMenuBuilder;
        if (bl3) {
            object = menuBuilder.getRootMenu();
            ((MenuBuilder)object).close(false);
        }
        if ((object = this.this$0.getCallback()) != null) {
            object.onCloseMenu(menuBuilder, bl2);
        }
    }

    public boolean onOpenSubMenu(MenuBuilder menuBuilder) {
        int n10;
        Object object = ActionMenuPresenter.access$300(this.this$0);
        boolean bl2 = false;
        if (menuBuilder == object) {
            return false;
        }
        object = this.this$0;
        MenuBuilder menuBuilder2 = menuBuilder;
        menuBuilder2 = ((SubMenuBuilder)menuBuilder).getItem();
        ((ActionMenuPresenter)object).mOpenSubMenuId = n10 = menuBuilder2.getItemId();
        object = this.this$0.getCallback();
        if (object != null) {
            bl2 = object.onOpenSubMenu(menuBuilder);
        }
        return bl2;
    }
}

