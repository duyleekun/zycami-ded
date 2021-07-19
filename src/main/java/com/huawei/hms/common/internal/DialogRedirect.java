/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 *  android.content.Intent
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import com.huawei.hms.common.internal.DialogRedirectImpl;
import com.huawei.hms.support.log.HMSLog;

public abstract class DialogRedirect
implements DialogInterface.OnClickListener {
    public static DialogRedirect getInstance(Activity activity, Intent intent, int n10) {
        DialogRedirectImpl dialogRedirectImpl = new DialogRedirectImpl(intent, activity, n10);
        return dialogRedirectImpl;
    }

    public void onClick(DialogInterface dialogInterface, int n10) {
        try {
            this.redirect();
        }
        catch (Throwable throwable) {
            String string2 = "DialogRedirect";
            String string3 = "Failed to start resolution intent";
            HMSLog.e(string2, string3);
        }
        return;
        {
            finally {
                dialogInterface.dismiss();
            }
        }
    }

    public abstract void redirect();
}

