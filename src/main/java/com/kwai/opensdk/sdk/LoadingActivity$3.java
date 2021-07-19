/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.kwai.opensdk.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.kwai.opensdk.sdk.LoadingActivity;

public class LoadingActivity$3
extends BroadcastReceiver {
    public final /* synthetic */ LoadingActivity this$0;

    public LoadingActivity$3(LoadingActivity loadingActivity) {
        this.this$0 = loadingActivity;
    }

    public void onReceive(Context object, Intent object2) {
        boolean bl2;
        if (object2 != null && (bl2 = ((String)(object2 = "com.kwai.opensdk.ACTION_OPEN_SDK_CLOSE_LOADING")).equals(object = object2.getAction())) && !(bl2 = (object = this.this$0).isFinishing())) {
            object = this.this$0;
            object.finish();
        }
    }
}

