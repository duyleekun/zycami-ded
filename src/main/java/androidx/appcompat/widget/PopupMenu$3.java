/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.PopupMenu;

public class PopupMenu$3
extends ForwardingListener {
    public final /* synthetic */ PopupMenu this$0;

    public PopupMenu$3(PopupMenu popupMenu, View view) {
        this.this$0 = popupMenu;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.this$0.mPopup.getPopup();
    }

    public boolean onForwardingStarted() {
        this.this$0.show();
        return true;
    }

    public boolean onForwardingStopped() {
        this.this$0.dismiss();
        return true;
    }
}

