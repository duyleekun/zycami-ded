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
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.availableupdate.r;
import com.huawei.hms.availableupdate.s$a;
import com.huawei.hms.availableupdate.s$b;

public abstract class s
extends o {
    public s() {
    }

    public /* synthetic */ s(r r10) {
        this();
    }

    public AlertDialog g() {
        Activity activity = this.e();
        int n10 = this.f();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, n10);
        int n11 = this.h();
        builder.setMessage(n11);
        n11 = this.j();
        Object object = new s$a(this);
        builder.setPositiveButton(n11, (DialogInterface.OnClickListener)object);
        n11 = this.i();
        object = new s$b(this);
        builder.setNegativeButton(n11, (DialogInterface.OnClickListener)object);
        return builder.create();
    }

    public abstract int h();

    public abstract int i();

    public abstract int j();
}

