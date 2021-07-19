/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.huawei.hms.ui;

import android.content.DialogInterface;
import com.huawei.hms.ui.AbstractDialog;

public class AbstractDialog$c
implements DialogInterface.OnCancelListener {
    public final /* synthetic */ AbstractDialog a;

    public AbstractDialog$c(AbstractDialog abstractDialog) {
        this.a = abstractDialog;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.fireCancel();
    }
}

