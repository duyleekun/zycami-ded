/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$ListSelectorHider
implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$ListSelectorHider(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void run() {
        this.this$0.clearListSelection();
    }
}

