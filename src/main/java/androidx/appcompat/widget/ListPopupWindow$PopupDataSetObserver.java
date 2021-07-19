/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 */
package androidx.appcompat.widget;

import android.database.DataSetObserver;
import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$PopupDataSetObserver
extends DataSetObserver {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$PopupDataSetObserver(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onChanged() {
        ListPopupWindow listPopupWindow = this.this$0;
        boolean bl2 = listPopupWindow.isShowing();
        if (bl2) {
            listPopupWindow = this.this$0;
            listPopupWindow.show();
        }
    }

    public void onInvalidated() {
        this.this$0.dismiss();
    }
}

