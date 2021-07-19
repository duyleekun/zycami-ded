/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.h;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class FTOSPushHelper {
    private static long a = 0L;
    private static volatile boolean a = false;

    private static void a(Context object) {
        object = e.a((Context)object);
        Object object2 = d.d;
        if ((object = ((e)object).a((d)((Object)object2))) != null) {
            object2 = "ASSEMBLE_PUSH :  register fun touch os when network change!";
            b.a((String)object2);
            object.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15 = SystemClock.elapsedRealtime();
        int n10 = FTOSPushHelper.getNeedRegister();
        if (n10 != 0 && ((l14 = (l13 = (l12 = a) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) <= 0 || (n10 = (l10 = (l12 += (l11 = 300000L)) - l15) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0)) {
            a = l15;
            FTOSPushHelper.a(context);
        }
    }

    public static boolean getNeedRegister() {
        return a;
    }

    public static boolean hasNetwork(Context context) {
        return h.a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        if (object != null && (bl3 = object.containsKey(object2 = "pushMsg")) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(object2)))) && (object2 = h.a(context)) != null) {
            String string2;
            Map map = ((MiPushMessage)(object = h.a((String)object))).getExtra();
            bl3 = map.containsKey(string2 = "notify_effect");
            if (bl3) {
                return;
            }
            ((PushMessageReceiver)((Object)object2)).onNotificationMessageClicked(context, (MiPushMessage)object);
        }
    }

    public static void setNeedRegister(boolean bl2) {
        a = bl2;
    }

    public static void uploadToken(Context context, String string2) {
        d d10 = d.d;
        h.a(context, d10, string2);
    }
}

