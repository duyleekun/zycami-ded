/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVHMSMessageService$1;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.hms.AVMixPushManager;
import cn.leancloud.json.JSON;
import cn.leancloud.push.AndroidNotificationManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import e.a.g0;
import e.a.z;

public class AVHMSMessageService
extends HmsMessageService {
    public static final AVLogger LOGGER = LogUtil.getLogger(AVHMSMessageService.class);
    public static final String MIXPUSH_PRIFILE = "deviceProfile";
    public static final String VENDOR = "HMS";

    public static void updateAVInstallation(String object) {
        boolean bl2;
        String string2;
        boolean bl3 = StringUtil.isEmpty((String)object);
        if (bl3) {
            return;
        }
        String string3 = VENDOR;
        Object object2 = AVInstallation.getCurrentInstallation();
        String string4 = ((AVObject)object2).getString(string2 = "vendor");
        boolean bl4 = string3.equals(string4);
        if (!bl4) {
            ((AVObject)object2).put(string2, string3);
        }
        if (!(bl4 = ((String)object).equals(string4 = ((AVObject)object2).getString(string2 = "registrationId")))) {
            ((AVObject)object2).put(string2, object);
        }
        if ((string2 = ((AVObject)object2).getString((String)(object = MIXPUSH_PRIFILE))) == null) {
            string2 = "";
        }
        if (!(bl2 = string2.equals(string4 = AVMixPushManager.hwDeviceProfile))) {
            string2 = AVMixPushManager.hwDeviceProfile;
            ((AVObject)object2).put((String)object, string2);
        }
        object = ((AVObject)object2).saveInBackground();
        object2 = new AVHMSMessageService$1();
        object2 = ObserverBuilder.buildSingleObserver((SaveCallback)object2);
        ((z)object).subscribe((g0)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onMessageReceived(RemoteMessage object) {
        try {
            Object object2 = AndroidNotificationManager.getInstance();
            Object object3 = ((RemoteMessage)object).getData();
            boolean bl2 = StringUtil.isEmpty((String)object3);
            if (!bl2) {
                object = LOGGER;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "received passthrough(data) message: ";
                stringBuilder.append(string2);
                stringBuilder.append((String)object3);
                String string3 = stringBuilder.toString();
                ((AVLogger)object).d(string3);
                ((AndroidNotificationManager)object2).processMixPushMessage((String)object3);
                return;
            }
            object3 = ((RemoteMessage)object).getNotification();
            if (object3 != null) {
                object = ((RemoteMessage)object).getNotification();
                object = JSON.toJSONString(object);
                object3 = LOGGER;
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "received passthrough(notification) message: ";
                stringBuilder.append(string4);
                stringBuilder.append((String)object);
                String string5 = stringBuilder.toString();
                ((AVLogger)object3).d(string5);
                ((AndroidNotificationManager)object2).processMixPushMessage((String)object);
                return;
            }
            object2 = LOGGER;
            object3 = new StringBuilder();
            String string6 = "unknown passthrough message: ";
            ((StringBuilder)object3).append(string6);
            object = object.toString();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            ((AVLogger)object2).e((String)object);
            return;
        }
        catch (Exception exception) {
            AVLogger aVLogger = LOGGER;
            String string7 = "failed to process PushMessage.";
            aVLogger.e(string7, exception);
        }
    }

    public void onNewToken(String string2) {
        AVHMSMessageService.updateAVInstallation(string2);
    }

    public void onTokenError(Exception object) {
        AVLogger aVLogger = LOGGER;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("failed to apply token. cause: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        aVLogger.w((String)object);
    }
}

