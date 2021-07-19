/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.fa;
import com.xiaomi.push.service.ak$a;

public final class MiPushClient$6
extends ak$a {
    public final /* synthetic */ Context val$context;

    public MiPushClient$6(int n10, String string2, Context context) {
        this.val$context = context;
        super(n10, string2);
    }

    public void onCallback() {
        fa.a(this.val$context);
    }
}

