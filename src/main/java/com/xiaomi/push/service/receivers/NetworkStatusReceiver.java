/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 */
package com.xiaomi.push.service.receivers;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.COSPushHelper;
import com.xiaomi.mipush.sdk.FTOSPushHelper;
import com.xiaomi.mipush.sdk.HWPushHelper;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.ag;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.av;
import com.xiaomi.push.az;
import com.xiaomi.push.gx;
import com.xiaomi.push.service.bb;
import com.xiaomi.push.service.receivers.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class NetworkStatusReceiver
extends BroadcastReceiver {
    private static int a = 1;
    private static BlockingQueue a;
    private static ThreadPoolExecutor a;
    private static boolean a = false;
    private static int b = 1;
    private static int c = 2;
    private boolean b = false;

    static {
        Object object = new LinkedBlockingQueue();
        a = object;
        int n10 = a;
        int n11 = b;
        long l10 = c;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue blockingQueue = a;
        a = object = new ThreadPoolExecutor(n10, n11, l10, timeUnit, blockingQueue);
        a = false;
    }

    public NetworkStatusReceiver() {
        this.b = true;
    }

    public NetworkStatusReceiver(Object object) {
        a = true;
    }

    private void a(Context context) {
        Object object;
        Object object2;
        Object object3 = aq.a(context);
        boolean bl2 = ((aq)object3).a();
        if (!bl2 && (bl2 = ((com.xiaomi.mipush.sdk.b)(object3 = com.xiaomi.mipush.sdk.b.a(context))).c()) && !(bl2 = ((com.xiaomi.mipush.sdk.b)(object3 = com.xiaomi.mipush.sdk.b.a(context))).e())) {
            object3 = new Intent();
            object2 = "com.xiaomi.push.service.XMPushService";
            object = new ComponentName(context, object2);
            object3.setComponent((ComponentName)object);
            object = "com.xiaomi.push.network_status_changed";
            object3.setAction((String)object);
            object = bb.a(context);
            try {
                ((bb)object).a((Intent)object3);
            }
            catch (Exception exception) {
                com.xiaomi.channel.commonutils.logger.b.a(exception);
            }
        }
        gx.a(context);
        bl2 = az.b(context);
        if (bl2 && (bl2 = ((aq)(object3 = aq.a(context))).b())) {
            object3 = aq.a(context);
            ((aq)object3).c();
        }
        if (bl2 = az.b(context)) {
            object3 = ag.a(context);
            object = av.a;
            object = "syncing";
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object)));
            if (bl2) {
                MiPushClient.disablePush(context);
            }
            object3 = ag.a(context);
            object2 = av.b;
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object2)));
            if (bl2) {
                MiPushClient.enablePush(context);
            }
            object3 = ag.a(context);
            object2 = av.c;
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object2)));
            if (bl2) {
                MiPushClient.syncAssemblePushToken(context);
            }
            object3 = ag.a(context);
            object2 = av.d;
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object2)));
            if (bl2) {
                MiPushClient.syncAssembleFCMPushToken(context);
            }
            object3 = ag.a(context);
            object2 = av.e;
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object2)));
            if (bl2) {
                MiPushClient.syncAssembleCOSPushToken(context);
            }
            object3 = ag.a(context);
            object2 = av.f;
            bl2 = ((String)object).equals(object3 = ((ag)object3).a((av)((Object)object2)));
            if (bl2) {
                MiPushClient.syncAssembleFTOSPushToken(context);
            }
            if ((bl2 = HWPushHelper.needConnect()) && (bl2 = HWPushHelper.shouldTryConnect(context))) {
                HWPushHelper.setConnectTime(context);
                HWPushHelper.registerHuaWeiAssemblePush(context);
            }
            COSPushHelper.doInNetworkChange(context);
            FTOSPushHelper.doInNetworkChange(context);
        }
    }

    public static /* synthetic */ void a(NetworkStatusReceiver networkStatusReceiver, Context context) {
        networkStatusReceiver.a(context);
    }

    public static boolean a() {
        return a;
    }

    public void onReceive(Context context, Intent object) {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        object = a;
        a a10 = new a(this, context);
        ((ThreadPoolExecutor)object).execute(a10);
    }
}

