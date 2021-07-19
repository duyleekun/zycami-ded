/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.view.ViewCompat;

public class ListPopupWindow$ResizePopupRunnable
implements Runnable {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$ResizePopupRunnable(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void run() {
        Object object;
        int n10;
        int n11;
        Object object2 = this.this$0.mDropDownList;
        if (object2 != null && (n11 = ViewCompat.isAttachedToWindow((View)object2)) != 0 && (n11 = (object2 = this.this$0.mDropDownList).getCount()) > (n10 = (object = this.this$0.mDropDownList).getChildCount())) {
            object2 = this.this$0.mDropDownList;
            n11 = object2.getChildCount();
            object = this.this$0;
            int n12 = ((ListPopupWindow)object).mListItemExpandMaximum;
            if (n11 <= n12) {
                object2 = ((ListPopupWindow)object).mPopup;
                n10 = 2;
                object2.setInputMethodMode(n10);
                object2 = this.this$0;
                ((ListPopupWindow)object2).show();
            }
        }
    }
}

