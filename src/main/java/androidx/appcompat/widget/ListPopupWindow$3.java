/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemSelectedListener
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.ListPopupWindow;

public class ListPopupWindow$3
implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ ListPopupWindow this$0;

    public ListPopupWindow$3(ListPopupWindow listPopupWindow) {
        this.this$0 = listPopupWindow;
    }

    public void onItemSelected(AdapterView object, View view, int n10, long l10) {
        int n11 = -1;
        if (n10 != n11 && (object = this.this$0.mDropDownList) != null) {
            ((DropDownListView)((Object)object)).setListSelectionHidden(false);
        }
    }

    public void onNothingSelected(AdapterView adapterView) {
    }
}

