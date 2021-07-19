/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 */
package com.huawei.hms.availableupdate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import com.huawei.hms.availableupdate.a0$a;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.z;
import com.huawei.hms.utils.ResourceLoaderUtil;

public abstract class a0
extends o {
    public a0() {
    }

    public /* synthetic */ a0(z z10) {
        this();
    }

    public AlertDialog g() {
        Activity activity = this.e();
        int n10 = this.f();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, n10);
        int n11 = this.h();
        builder.setMessage(n11);
        n11 = this.i();
        a0$a a0$a = new a0$a(this);
        builder.setPositiveButton(n11, (DialogInterface.OnClickListener)a0$a);
        return builder.create();
    }

    public abstract int h();

    public int i() {
        return ResourceLoaderUtil.getStringId("hms_confirm");
    }
}

