/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.appcompat.view.menu;

import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.MenuPopupWindow;

public class CascadingMenuPopup$1
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ CascadingMenuPopup this$0;

    public CascadingMenuPopup$1(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onGlobalLayout() {
        int n10;
        Object object = this.this$0;
        boolean n102 = ((CascadingMenuPopup)object).isShowing();
        if (n102 && (n10 = (object = this.this$0.mShowingMenus).size()) > 0) {
            object = this.this$0.mShowingMenus;
            boolean bl2 = false;
            MenuPopupWindow menuPopupWindow = null;
            object = ((CascadingMenuPopup$CascadingMenuInfo)object.get((int)0)).window;
            boolean bl3 = ((ListPopupWindow)object).isModal();
            if (!bl3) {
                boolean bl4;
                object = this.this$0.mShownAnchorView;
                if (object != null && (bl4 = object.isShown())) {
                    object = this.this$0.mShowingMenus.iterator();
                    while (bl2 = object.hasNext()) {
                        menuPopupWindow = ((CascadingMenuPopup$CascadingMenuInfo)object.next()).window;
                        menuPopupWindow.show();
                    }
                } else {
                    object = this.this$0;
                    ((CascadingMenuPopup)object).dismiss();
                }
            }
        }
    }
}

