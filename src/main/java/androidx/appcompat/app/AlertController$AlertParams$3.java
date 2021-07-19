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
import androidx.appcompat.app.AppCompatDialog;

public class AlertController$AlertParams$3
implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController$AlertParams this$0;
    public final /* synthetic */ AlertController val$dialog;

    public AlertController$AlertParams$3(AlertController$AlertParams alertController$AlertParams, AlertController alertController) {
        this.this$0 = alertController$AlertParams;
        this.val$dialog = alertController;
    }

    public void onItemClick(AdapterView object, View object2, int n10, long l10) {
        object = this.this$0.mOnClickListener;
        object2 = this.val$dialog.mDialog;
        object.onClick((DialogInterface)object2, n10);
        object = this.this$0;
        boolean bl2 = ((AlertController$AlertParams)object).mIsSingleChoice;
        if (!bl2) {
            object = this.val$dialog.mDialog;
            ((AppCompatDialog)object).dismiss();
        }
    }
}

