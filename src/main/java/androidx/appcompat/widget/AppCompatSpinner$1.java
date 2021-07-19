/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup;
import androidx.appcompat.widget.ForwardingListener;

public class AppCompatSpinner$1
extends ForwardingListener {
    public final /* synthetic */ AppCompatSpinner this$0;
    public final /* synthetic */ AppCompatSpinner$DropdownPopup val$popup;

    public AppCompatSpinner$1(AppCompatSpinner appCompatSpinner, View view, AppCompatSpinner$DropdownPopup appCompatSpinner$DropdownPopup) {
        this.this$0 = appCompatSpinner;
        this.val$popup = appCompatSpinner$DropdownPopup;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.val$popup;
    }

    public boolean onForwardingStarted() {
        Object object = this.this$0.getInternalPopup();
        boolean bl2 = object.isShowing();
        if (!bl2) {
            object = this.this$0;
            ((AppCompatSpinner)object).showPopup();
        }
        return true;
    }
}

