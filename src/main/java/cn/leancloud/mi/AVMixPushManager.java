/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 */
package cn.leancloud.mi;

import android.content.Context;
import android.os.Build;
import cn.leancloud.AVLogger;
import cn.leancloud.AVManifestUtils;
import cn.leancloud.AVMiPushMessageReceiver;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.xiaomi.mipush.sdk.MiPushClient;

public class AVMixPushManager {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVMixPushManager.class);
    public static final String MIXPUSH_PROFILE = "deviceProfile";
    public static String miDeviceProfile = "";
    public static Class miPushReceiverClazz = AVMiPushMessageReceiver.class;

    private static boolean checkXiaomiManifest(Context context) {
        Object object;
        try {
            object = miPushReceiverClazz;
        }
        catch (Exception exception) {
            object = LOGGER;
            String string2 = exception.getMessage();
            ((AVLogger)object).d(string2);
            return false;
        }
        return AVManifestUtils.checkReceiver(context, (Class)object);
    }

    private static boolean isXiaomiPhone() {
        String string2;
        boolean bl2;
        String string3 = Build.MANUFACTURER;
        boolean bl3 = StringUtil.isEmpty(string3);
        if (!bl3 && (bl2 = (string3 = string3.toLowerCase()).contains(string2 = "xiaomi"))) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        return bl2;
    }

    private static void printErrorLog(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            AVLogger aVLogger = LOGGER;
            aVLogger.e(string2);
        }
    }

    public static void registerXiaomiPush(Context context, String string2, String string3) {
        AVMixPushManager.registerXiaomiPush(context, string2, string3, "");
    }

    public static void registerXiaomiPush(Context context, String string2, String string3, Class clazz) {
        AVMixPushManager.registerXiaomiPush(context, string2, string3, "", clazz);
    }

    public static void registerXiaomiPush(Context context, String string2, String string3, String string4) {
        AVMixPushManager.registerXiaomiPush(context, string2, string3, string4, null);
    }

    public static void registerXiaomiPush(Context object, String string2, String string3, String string4, Class clazz) {
        if (object != null) {
            boolean bl2 = StringUtil.isEmpty(string2);
            if (!bl2) {
                bl2 = StringUtil.isEmpty(string3);
                if (!bl2) {
                    boolean bl3;
                    if (clazz != null) {
                        miPushReceiverClazz = clazz;
                    }
                    if (!(bl3 = AVMixPushManager.isXiaomiPhone())) {
                        AVMixPushManager.printErrorLog("register error, current device is not a xiaomi phone!");
                        return;
                    }
                    bl3 = AVMixPushManager.checkXiaomiManifest((Context)object);
                    if (!bl3) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append("register error, mainifest is incomplete(receiver not found: ");
                        string2 = miPushReceiverClazz.getSimpleName();
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(")!");
                        AVMixPushManager.printErrorLog(((StringBuilder)object).toString());
                        return;
                    }
                    miDeviceProfile = string4;
                    MiPushClient.registerPush((Context)object, string2, string3);
                    LOGGER.d("finished to register mi push");
                    return;
                }
                object = new IllegalArgumentException("miAppKey cannot be null.");
                throw object;
            }
            object = new IllegalArgumentException("miAppId cannot be null.");
            throw object;
        }
        object = new IllegalArgumentException("context cannot be null.");
        throw object;
    }

    public static void registerXiaomiPush(Context context, String string2, String string3, String string4, boolean bl2) {
        AVMixPushManager.registerXiaomiPush(context, string2, string3, string4, bl2, null);
    }

    public static void registerXiaomiPush(Context context, String string2, String string3, String string4, boolean bl2, Class clazz) {
        AVMiPushMessageReceiver.setInternationalVendor(bl2);
        AVMixPushManager.registerXiaomiPush(context, string2, string3, string4, clazz);
    }
}

