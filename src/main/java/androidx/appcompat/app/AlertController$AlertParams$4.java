/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.view.View
 *  android.widget.AdapterView
 *  android.widget.AdapterView$OnItemClickListener
 */
package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertController$AlertParams;
import androidx.appcompat.app.AlertController$RecycleListView;

public class AlertController$AlertParams$4
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$AlertParams this$0;
    public final /* synthetic */ AlertController val$dialog;
    public final /* synthetic */ AlertController$RecycleListView val$listView;

    public AlertController$AlertParams$4(AlertController$AlertParams alertController$AlertParams, AlertController$RecycleListView alertController$RecycleListView, AlertController alertController) {
        this.this$0 = alertController$AlertParams;
        this.val$listView = alertController$RecycleListView;
        this.val$dialog = alertController;
    }

    public void onItemClick(AdapterView object, View object2, int n10, long l10) {
        object = this.this$0.mCheckedItems;
        if (object != null) {
            object2 = this.val$listView;
            boolean bl2 = object2.isItemChecked(n10);
            object[n10] = (AdapterView)bl2;
        }
        object = this.this$0.mOnCheckboxClickListener;
        object2 = this.val$dialog.mDialog;
        boolean bl3 = this.val$listView.isItemChecked(n10);
        object.onClick((DialogInterface)object2, n10, bl3);
    }
}

