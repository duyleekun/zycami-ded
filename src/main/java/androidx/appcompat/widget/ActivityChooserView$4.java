/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.ForwardingListener;

public class ActivityChooserView$4
extends ForwardingListener {
    public final /* synthetic */ ActivityChooserView this$0;

    public ActivityChooserView$4(ActivityChooserView activityChooserView, View view) {
        this.this$0 = activityChooserView;
        super(view);
    }

    public ShowableListMenu getPopup() {
        return this.this$0.getListPopupWindow();
    }

    public boolean onForwardingStarted() {
        this.this$0.showPopup();
        return true;
    }

    public boolean onForwardingStopped() {
        this.this$0.dismissPopup();
        return true;
    }
}

