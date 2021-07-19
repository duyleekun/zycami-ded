/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushClient$ICallbackResult;

public final class MiPushClient$1
implements Runnable {
    public final /* synthetic */ String val$alias;
    public final /* synthetic */ String val$appID;
    public final /* synthetic */ String val$appToken;
    public final /* synthetic */ MiPushClient.ICallbackResult val$iCallbackResult;

    public MiPushClient$1(String string2, String string3, String string4, MiPushClient.ICallbackResult iCallbackResult) {
        this.val$appID = string2;
        this.val$appToken = string3;
        this.val$alias = string4;
        this.val$iCallbackResult = iCallbackResult;
    }

    public void run() {
        Context context = MiPushClient.access$000();
        String string2 = this.val$appID;
        String string3 = this.val$appToken;
        String string4 = this.val$alias;
        MiPushClient.ICallbackResult iCallbackResult = this.val$iCallbackResult;
        MiPushClient.access$100(context, string2, string3, null, string4, iCallbackResult);
    }
}

