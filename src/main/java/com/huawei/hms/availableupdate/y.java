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
import com.huawei.hms.availableupdate.y$a;
import com.huawei.hms.availableupdate.y$b;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class y
extends o {
    public String c;

    public y() {
        String string2;
        this.c = string2 = ResourceLoaderUtil.getString("hms_update_title");
    }

    public void a(String string2) {
        this.c = string2;
    }

    public AlertDialog g() {
        int n10 = ResourceLoaderUtil.getStringId("hms_update_message_new");
        int n11 = ResourceLoaderUtil.getStringId("hms_install");
        Activity activity = this.e();
        int n12 = this.f();
        AlertDialog.Builder builder = new AlertDialog.Builder((Context)activity, n12);
        activity = this.e();
        Object[] objectArray = new Object[1];
        String string2 = this.c;
        objectArray[0] = string2;
        Object object = activity.getString(n10, objectArray);
        builder.setMessage((CharSequence)object);
        object = new y$a(this);
        builder.setPositiveButton(n11, (DialogInterface.OnClickListener)object);
        n10 = ResourceLoaderUtil.getStringId("hms_cancel");
        y$b y$b = new y$b(this);
        builder.setNegativeButton(n10, (DialogInterface.OnClickListener)y$b);
        return builder.create();
    }
}

