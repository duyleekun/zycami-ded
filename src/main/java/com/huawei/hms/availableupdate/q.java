/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog
 *  android.app.ProgressDialog
 *  android.content.Context
 */
package com.huawei.hms.availableupdate;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import com.huawei.hms.availableupdate.o;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class q
extends o {
    public AlertDialog g() {
        Object object = this.e();
        int n10 = this.f();
        ProgressDialog progressDialog = new ProgressDialog((Context)object, n10);
        object = ResourceLoaderUtil.getString("hms_checking");
        progressDialog.setMessage((CharSequence)object);
        progressDialog.setCanceledOnTouchOutside(false);
        return progressDialog;
    }
}

