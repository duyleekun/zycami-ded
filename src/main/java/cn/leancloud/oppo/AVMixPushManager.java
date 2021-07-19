/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.oppo;

import android.content.Context;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOPPOPushAdapter;
import cn.leancloud.AVObject;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.oppo.AVMixPushManager$1;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import d.i.a.a.b.a;
import e.a.g0;
import e.a.z;
import java.util.List;

public class AVMixPushManager {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVMixPushManager.class);
    public static final String MIXPUSH_PROFILE = "deviceProfile";
    public static String oppoDeviceProfile = "";

    public static /* synthetic */ void access$000(String string2) {
        AVMixPushManager.printErrorLog(string2);
    }

    public static /* synthetic */ AVLogger access$100() {
        return LOGGER;
    }

    public static void getOppoAliases() {
    }

    public static void getOppoNotificationStatus() {
        d.i.a.a.a.f();
    }

    public static void getOppoPushStatus() {
        d.i.a.a.a.i();
    }

    public static void getOppoTags() {
    }

    public static void getOppoUserAccounts() {
    }

    public static boolean isSupportOppoPush(Context context) {
        return d.i.a.a.a.r();
    }

    public static void pauseOppoPush() {
        d.i.a.a.a.u();
    }

    private static void printErrorLog(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            AVLogger aVLogger = LOGGER;
            aVLogger.e(string2);
        }
    }

    public static boolean registerOppoPush(Context object, String string2, String object2, AVOPPOPushAdapter object3) {
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty(string2)) && !(bl2 = StringUtil.isEmpty((String)object2))) {
            bl2 = true;
            d.i.a.a.a.q(object, bl2);
            boolean bl3 = AVMixPushManager.isSupportOppoPush(object);
            if (!bl3) {
                LOGGER.e("current device doesn't support OPPO Push.");
                return false;
            }
            d.i.a.a.a.w(object, string2, (String)object2, (a)object3);
            d.i.a.a.a.y();
            return bl2;
        }
        object2 = LOGGER;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("invalid parameter. context=");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(", appKey=");
        ((StringBuilder)object3).append(string2);
        object = ((StringBuilder)object3).toString();
        ((AVLogger)object2).e((String)object);
        return false;
    }

    public static boolean registerOppoPush(Context context, String string2, String string3, String string4, AVOPPOPushAdapter aVOPPOPushAdapter) {
        oppoDeviceProfile = string4;
        return AVMixPushManager.registerOppoPush(context, string2, string3, aVOPPOPushAdapter);
    }

    public static void resumeOppoPush() {
        d.i.a.a.a.z();
    }

    public static void setOppoAliases(List list) {
    }

    public static void setOppoPushTime(List list, int n10, int n11, int n12, int n13) {
        d.i.a.a.a.F(list, n10, n11, n12, n13);
    }

    public static void setOppoTags(List list) {
    }

    public static void setOppoUserAccount(String string2) {
    }

    public static void unRegisterMixPush() {
        Object object;
        Object object2 = AVInstallation.getCurrentInstallation();
        String string2 = ((AVObject)object2).getString((String)(object = "vendor"));
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            string2 = "lc";
            ((AVObject)object2).put((String)object, string2);
            object2 = ((AVObject)object2).saveInBackground();
            object = new AVMixPushManager$1();
            object = ObserverBuilder.buildSingleObserver((SaveCallback)object);
            ((z)object2).subscribe((g0)object);
            d.i.a.a.a.K();
        }
    }

    public static void unsetOppoAlias(String string2) {
    }

    public static void unsetOppoTags(List list) {
    }

    public static void unsetOppoUserAccouts(List list) {
    }
}

