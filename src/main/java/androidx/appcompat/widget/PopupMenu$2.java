/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package androidx.appcompat.widget;

import android.widget.PopupWindow;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.PopupMenu$OnDismissListener;

public class PopupMenu$2
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ PopupMenu this$0;

    public PopupMenu$2(PopupMenu popupMenu) {
        this.this$0 = popupMenu;
    }

    public void onDismiss() {
        PopupMenu popupMenu = this.this$0;
        PopupMenu$OnDismissListener popupMenu$OnDismissListener = popupMenu.mOnDismissListener;
        if (popupMenu$OnDismissListener != null) {
            popupMenu$OnDismissListener.onDismiss(popupMenu);
        }
    }
}

