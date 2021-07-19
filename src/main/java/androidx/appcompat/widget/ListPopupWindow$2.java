/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$2
implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$2(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void run() {
        Object object = this.this$0.getAnchorView();
        if (object != null && (object = object.getWindowToken()) != null) {
            object = this.this$0;
            ((ListPopupWindow)object).show();
        }
    }
}

