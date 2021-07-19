/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushClient;

public final class MiPushClient$4
implements Runnable {
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String[] val$packageNames;

    public MiPushClient$4(String[] stringArray, Context context) {
        this.val$packageNames = stringArray;
        this.val$context = context;
    }

    public void run() {
        String[] stringArray = this.val$packageNames;
        int n10 = stringArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = stringArray[i10];
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (bl2) continue;
            Context context = this.val$context;
            context = context.getPackageManager();
            int n11 = 4;
            string2 = context.getPackageInfo(string2, n11);
            if (string2 == null) continue;
            context = this.val$context;
            try {
                MiPushClient.access$200(context, (PackageInfo)string2);
            }
            catch (Throwable throwable) {
                b.a(throwable);
                break;
            }
            continue;
        }
    }
}

