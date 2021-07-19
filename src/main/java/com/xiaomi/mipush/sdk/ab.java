/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.MessageHandleService;

public final class ab
implements Runnable {
    public final /* synthetic */ Context a;

    public ab(Context context) {
        this.a = context;
    }

    public void run() {
        MessageHandleService.a(this.a);
    }
}

