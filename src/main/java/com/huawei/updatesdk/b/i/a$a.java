/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnShowListener
 *  android.view.View$OnClickListener
 */
package com.huawei.updatesdk.b.i;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.huawei.updatesdk.b.i.a;
import com.huawei.updatesdk.b.i.a$a$a;
import com.huawei.updatesdk.b.i.a$a$b;

public class a$a
implements DialogInterface.OnShowListener {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void onShow(DialogInterface dialogInterface) {
        DialogInterface dialogInterface2 = dialogInterface;
        dialogInterface2 = (AlertDialog)dialogInterface;
        Object object = dialogInterface2.getButton(-1);
        a$a$a a$a$a = new a$a$a(this);
        object.setOnClickListener((View.OnClickListener)a$a$a);
        int n10 = -2;
        dialogInterface2 = dialogInterface2.getButton(n10);
        if (dialogInterface2 != null) {
            object = new a$a$b(this);
            dialogInterface2.setOnClickListener((View.OnClickListener)object);
        }
        if ((dialogInterface2 = com.huawei.updatesdk.b.i.a.b(this.a)) != null) {
            dialogInterface2 = com.huawei.updatesdk.b.i.a.b(this.a);
            dialogInterface2.onShow(dialogInterface);
        }
    }
}

