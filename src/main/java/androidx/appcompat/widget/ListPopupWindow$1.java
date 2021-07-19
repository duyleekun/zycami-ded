/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ForwardingListener;
import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$1
extends ForwardingListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$1(ListPopupWindow listPopupWindow, View view) {
        this.this$0 = listPopupWindow;
        super(view);
    }

    public ListPopupWindow getPopup() {
        return this.this$0;
    }
}

