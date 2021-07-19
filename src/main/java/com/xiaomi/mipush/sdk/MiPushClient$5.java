/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.fa$a;
import com.xiaomi.push.hq;

public final class MiPushClient$5
implements fa$a {
    public void uploader(Context context, hq hq2) {
        MiTinyDataClient.upload(context, hq2);
    }
}

