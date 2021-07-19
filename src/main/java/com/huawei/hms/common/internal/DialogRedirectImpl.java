/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.huawei.hms.common.internal.DialogRedirect;

public class DialogRedirectImpl
extends DialogRedirect {
    private final Activity activity;
    private final Intent intent;
    private final int requestCode;

    public DialogRedirectImpl(Intent intent, Activity activity, int n10) {
        this.intent = intent;
        this.activity = activity;
        this.requestCode = n10;
    }

    public final void redirect() {
        Intent intent = this.intent;
        if (intent != null) {
            Activity activity = this.activity;
            int n10 = this.requestCode;
            activity.startActivityForResult(intent, n10);
        }
    }
}

