/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.huawei.updatesdk.b.i;

import android.content.DialogInterface;
import com.huawei.updatesdk.b.i.a;

public class a$b
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ a a;

    public a$b(a a10) {
        this.a = a10;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = com.huawei.updatesdk.b.i.a.c(this.a);
        if (onDismissListener != null) {
            onDismissListener = com.huawei.updatesdk.b.i.a.c(this.a);
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}

