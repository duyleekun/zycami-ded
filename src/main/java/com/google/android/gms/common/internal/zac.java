/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.internal.DialogRedirect;

public final class zac
extends DialogRedirect {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaoh;

    public zac(Intent intent, Activity activity, int n10) {
        this.zaoh = intent;
        this.val$activity = activity;
        this.val$requestCode = n10;
    }

    public final void redirect() {
        Intent intent = this.zaoh;
        if (intent != null) {
            Activity activity = this.val$activity;
            int n10 = this.val$requestCode;
            activity.startActivityForResult(intent, n10);
        }
    }
}

