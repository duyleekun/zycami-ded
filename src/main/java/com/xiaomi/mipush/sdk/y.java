/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.util.Log
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.xiaomi.mipush.sdk.x;

public final class y
implements Runnable {
    public final /* synthetic */ Context a;

    public y(Context context) {
        this.a = context;
    }

    public void run() {
        Context context = this.a;
        context = context.getPackageManager();
        String string2 = this.a;
        string2 = string2.getPackageName();
        int n10 = 4612;
        context = context.getPackageInfo(string2, n10);
        string2 = this.a;
        x.b((Context)string2);
        string2 = this.a;
        x.a((Context)string2, (PackageInfo)context);
        string2 = this.a;
        try {
            x.b((Context)string2, (PackageInfo)context);
        }
        catch (Throwable throwable) {
            string2 = "ManifestChecker";
            String string3 = "";
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }
}

