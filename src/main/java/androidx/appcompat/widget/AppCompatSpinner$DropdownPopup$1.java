/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 */
package androidx.appcompat.widget;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatSpinner$DropdownPopup;

public class AppCompatSpinner$DropdownPopup$1
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AppCompatSpinner$DropdownPopup this$1;
    public final /* synthetic */ AppCompatSpinner val$this$0;

    public AppCompatSpinner$DropdownPopup$1(AppCompatSpinner$DropdownPopup dropdownPopup, AppCompatSpinner appCompatSpinner) {
        this.this$1 = dropdownPopup;
        this.val$this$0 = appCompatSpinner;
    }

    public void onItemClick(AdapterView object, View view, int n10, long l10) {
        this.this$1.this$0.setSelection(n10);
        object = this.this$1.this$0.getOnItemClickListener();
        if (object != null) {
            object = this.this$1;
            AppCompatSpinner appCompatSpinner = object.this$0;
            object = object.mAdapter;
            long l11 = object.getItemId(n10);
            appCompatSpinner.performItemClick(view, n10, l11);
        }
        this.this$1.dismiss();
    }
}

