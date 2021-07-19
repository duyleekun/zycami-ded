/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.SystemClock
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class COSPushHelper {
    private static long a = 0L;
    private static volatile boolean a = false;

    public static void convertMessage(Intent intent) {
        h.a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15 = SystemClock.elapsedRealtime();
        int n10 = COSPushHelper.getNeedRegister();
        if (n10 != 0 && ((l14 = (l13 = (l12 = a) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0 || (n10 = (l10 = (l12 += (l11 = 300000L)) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0)) {
            a = l15;
            COSPushHelper.registerCOSAssemblePush(context);
        }
    }

    public static boolean getNeedRegister() {
        return a;
    }

    public static boolean hasNetwork(Context context) {
        return h.a(context);
    }

    public static void onNotificationMessageCome(Context context, String string2) {
    }

    public static void onPassThoughMessageCome(Context context, String string2) {
    }

    public static void registerCOSAssemblePush(Context object) {
        object = e.a((Context)object);
        Object object2 = d.c;
        if ((object = ((e)object).a((d)((Object)object2))) != null) {
            object2 = "ASSEMBLE_PUSH :  register cos when network change!";
            b.a((String)object2);
            object.register();
        }
    }

    public static void setNeedRegister(boolean bl2) {
        Class<COSPushHelper> clazz = COSPushHelper.class;
        synchronized (clazz) {
            a = bl2;
            return;
        }
    }

    public static void uploadToken(Context context, String string2) {
        d d10 = d.c;
        h.a(context, d10, string2);
    }
}

