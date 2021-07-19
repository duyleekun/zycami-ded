/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.os.Build
 *  android.os.Looper
 */
package cn.leancloud.hms;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import cn.leancloud.AVHMSMessageService;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVManifestUtils;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.hms.AVMixPushManager$1;
import cn.leancloud.hms.AVMixPushManager$2;
import cn.leancloud.hms.AVMixPushManager$3;
import cn.leancloud.hms.AVMixPushManager$4;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.push.HmsMessaging;
import d.j.a.f.a;
import d.j.d.a.k;
import e.a.g0;
import e.a.z;

public class AVMixPushManager {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVMixPushManager.class);
    public static final String MIXPUSH_PROFILE = "deviceProfile";
    public static String hwDeviceProfile = "";
    public static Class hwMessageServiceClazz = AVHMSMessageService.class;

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ void access$100(String string2) {
        AVMixPushManager.printErrorLog(string2);
    }

    private static boolean checkHuaweiManifest(Context context) {
        boolean bl2;
        block5: {
            bl2 = false;
            Object object = "android.permission.INTERNET";
            boolean bl3 = AVManifestUtils.checkPermission(context, (String)object);
            if (!bl3) break block5;
            object = hwMessageServiceClazz;
            try {
                boolean bl4 = AVManifestUtils.checkService(context, (Class)object);
                if (bl4) {
                    bl2 = bl4 = true;
                }
            }
            catch (Exception exception) {
                object = LOGGER;
                String string2 = exception.getMessage();
                ((AVLogger)object).d(string2);
            }
        }
        return bl2;
    }

    public static void connectHMS(Activity object) {
        if (object != null) {
            String string2 = a.a((Context)object).g("client/app_id");
            AVMixPushManager.connectHMS(object, string2);
            return;
        }
        object = new IllegalArgumentException("[HMS] activity cannot be null.");
        throw object;
    }

    public static void connectHMS(Activity object, String object2) {
        if (object != null) {
            Object object3;
            Object object4 = Looper.getMainLooper();
            if (object4 == (object3 = Looper.myLooper())) {
                object3 = new AVMixPushManager$1((Activity)object, (String)object2);
                object4 = new Thread((Runnable)object3);
                ((Thread)object4).start();
            } else {
                object = HmsInstanceId.getInstance((Context)object);
                object4 = "HCM";
                object = ((HmsInstanceId)object).getToken((String)object2, (String)object4);
                object4 = LOGGER;
                object3 = new StringBuilder();
                String string2 = "found HMS appId: ";
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object2);
                object2 = ", token: ";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append((String)object);
                object2 = ((StringBuilder)object3).toString();
                try {
                    ((AVLogger)object4).d((String)object2);
                    AVHMSMessageService.updateAVInstallation((String)object);
                }
                catch (Exception exception) {
                    object2 = LOGGER;
                    object4 = new StringBuilder();
                    object3 = "failed to get hms token. cause: ";
                    ((StringBuilder)object4).append((String)object3);
                    String string3 = exception.getMessage();
                    ((StringBuilder)object4).append(string3);
                    string3 = ((StringBuilder)object4).toString();
                    ((AVLogger)object2).w(string3);
                }
            }
            return;
        }
        object = new IllegalArgumentException("[HMS] activity cannot be null.");
        throw object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean isHuaweiPhone() {
        String string2 = Build.BRAND;
        boolean bl2 = false;
        String string3 = "huawei";
        try {
            boolean bl3 = string2.equalsIgnoreCase(string3);
            if (bl3) return true;
            string3 = "honor";
        }
        catch (Exception exception) {
            return bl2;
        }
        boolean bl4 = string2.equalsIgnoreCase(string3);
        if (!bl4) return bl2;
        return true;
    }

    private static void printErrorLog(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            AVLogger aVLogger = LOGGER;
            aVLogger.e(string2);
        }
    }

    public static void registerHMSPush(Application application) {
        AVMixPushManager.registerHMSPush(application, "");
    }

    public static void registerHMSPush(Application application, String string2) {
        AVMixPushManager.registerHMSPush(application, string2, null);
    }

    public static void registerHMSPush(Application object, String string2, Class clazz) {
        if (object != null) {
            boolean bl2;
            boolean bl3 = AVMixPushManager.isHuaweiPhone();
            if (!bl3) {
                AVMixPushManager.printErrorLog("[HMS] register error, is not huawei phone!");
                return;
            }
            if (clazz != null) {
                hwMessageServiceClazz = clazz;
            }
            if (!(bl2 = AVMixPushManager.checkHuaweiManifest((Context)object))) {
                AVMixPushManager.printErrorLog("[HMS] register error, mainifest is incomplete!");
                return;
            }
            hwDeviceProfile = string2;
            LOGGER.d("[HMS] start register HMS push");
            return;
        }
        object = new IllegalArgumentException("[HMS] context cannot be null.");
        throw object;
    }

    public static void turnOffHMSPush(Context object, AVCallback aVCallback) {
        object = HmsMessaging.getInstance((Context)object).turnOffPush();
        AVMixPushManager$3 aVMixPushManager$3 = new AVMixPushManager$3(aVCallback);
        ((k)object).e(aVMixPushManager$3);
    }

    public static void turnOnHMSPush(Context object, AVCallback aVCallback) {
        object = HmsMessaging.getInstance((Context)object).turnOnPush();
        AVMixPushManager$2 aVMixPushManager$2 = new AVMixPushManager$2(aVCallback);
        ((k)object).e(aVMixPushManager$2);
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
            object = new AVMixPushManager$4();
            object = ObserverBuilder.buildSingleObserver((SaveCallback)object);
            ((z)object2).subscribe((g0)object);
        }
    }
}

