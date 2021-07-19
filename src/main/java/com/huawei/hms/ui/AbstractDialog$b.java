/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package com.huawei.hms.ui;

import android.content.DialogInterface;
import com.huawei.hms.ui.AbstractDialog;

public class AbstractDialog$b
implements DialogInterface.OnClickListener {
    public final /* synthetic */ AbstractDialog a;

    public AbstractDialog$b(AbstractDialog abstractDialog) {
        this.a = abstractDialog;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        this.a.cancel();
    }
}

