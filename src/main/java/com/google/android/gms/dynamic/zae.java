/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public final class zae
implements View.OnClickListener {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Intent zaro;

    public zae(Context context, Intent intent) {
        this.val$context = context;
        this.zaro = intent;
    }

    public final void onClick(View view) {
        try {
            view = this.val$context;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            Log.e((String)"DeferredLifecycleHelper", (String)"Failed to start resolution intent", (Throwable)activityNotFoundException);
            return;
        }
        Intent intent = this.zaro;
        view.startActivity(intent);
    }
}

