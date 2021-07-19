/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.huawei.hms.availableupdate;

import android.content.DialogInterface;
import com.huawei.hms.availableupdate.o;

public class o$a
implements DialogInterface.OnCancelListener {
    public final /* synthetic */ o a;

    public o$a(o o10) {
        this.a = o10;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.a.c();
    }
}

