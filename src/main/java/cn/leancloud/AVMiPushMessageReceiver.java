/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package cn.leancloud;

import android.content.Context;
import android.text.TextUtils;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVMiPushMessageReceiver$1;
import cn.leancloud.AVObject;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.JSONObject$Builder;
import cn.leancloud.mi.AVMixPushManager;
import cn.leancloud.push.AndroidNotificationManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import e.a.g0;
import e.a.z;

public class AVMiPushMessageReceiver
extends PushMessageReceiver {
    private static final String AV_MIXPUSH_MI_NOTIFICATION_ACTION = "com.avos.avoscloud.mi_notification_action";
    private static final String AV_MIXPUSH_MI_NOTIFICATION_ARRIVED_ACTION = "com.avos.avoscloud.mi_notification_arrived_action";
    private static final AVLogger LOGGER = LogUtil.getLogger(AVMiPushMessageReceiver.class);
    public static final String VENDOR_XIAOMI = "mi";
    public static final String VENDOR_XIAOMI_INTERNATIONAL = "mi-intl";
    private static String defaultVendor = "mi";

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    private void processMiNotification(MiPushMessage object) {
        boolean bl2;
        if (object != null && !(bl2 = StringUtil.isEmpty((String)(object = ((MiPushMessage)object).getContent())))) {
            AndroidNotificationManager androidNotificationManager = AndroidNotificationManager.getInstance();
            String string2 = AV_MIXPUSH_MI_NOTIFICATION_ACTION;
            androidNotificationManager.processMixNotification((String)object, string2);
        }
    }

    private void processMiPushMessage(MiPushMessage object) {
        if (object != null) {
            boolean bl2;
            boolean bl3;
            String string2;
            Object object2;
            block7: {
                object2 = ((MiPushMessage)object).getTitle();
                string2 = ((MiPushMessage)object).getDescription();
                bl3 = TextUtils.isEmpty((CharSequence)(object = ((MiPushMessage)object).getContent()));
                if (!bl3) {
                    try {
                        object = JSON.parseObject((String)object);
                        break block7;
                    }
                    catch (Exception exception) {
                        AVLogger aVLogger = LOGGER;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = "Parsing json data error, ";
                        stringBuilder.append(string3);
                        stringBuilder.append((String)object);
                        object = stringBuilder.toString();
                        aVLogger.e((String)object, exception);
                    }
                }
                object = null;
            }
            if (object == null) {
                object = JSONObject$Builder.create(null);
            }
            if (!(bl3 = StringUtil.isEmpty((String)object2))) {
                String string4 = "title";
                object.put(string4, object2);
            }
            if (!(bl2 = StringUtil.isEmpty(string2))) {
                object2 = "alert";
                object.put(object2, string2);
            }
            object2 = AndroidNotificationManager.getInstance();
            object = ((JSONObject)object).toJSONString();
            ((AndroidNotificationManager)object2).processMixPushMessage((String)object);
        }
    }

    public static void setInternationalVendor(boolean bl2) {
        String string2;
        String string3;
        defaultVendor = bl2 ? (string3 = VENDOR_XIAOMI_INTERNATIONAL) : (string2 = VENDOR_XIAOMI);
    }

    private void updateAVInstallation(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            boolean bl3;
            String string2;
            String string3 = defaultVendor;
            Object object2 = AVInstallation.getCurrentInstallation();
            String string4 = ((AVObject)object2).getString(string2 = "vendor");
            boolean bl4 = string3.equals(string4);
            if (!bl4) {
                string3 = defaultVendor;
                ((AVObject)object2).put(string2, string3);
            }
            if (!(bl3 = ((String)object).equals(string2 = ((AVObject)object2).getString(string3 = "registrationId")))) {
                ((AVObject)object2).put(string3, object);
            }
            if ((string3 = ((AVObject)object2).getString((String)(object = "deviceProfile"))) == null) {
                string3 = "";
            }
            string2 = AVMixPushManager.miDeviceProfile;
            bl4 = string3.equals(string2);
            if (!bl4) {
                string3 = AVMixPushManager.miDeviceProfile;
                ((AVObject)object2).put((String)object, string3);
            }
            object = ((AVObject)object2).saveInBackground();
            object2 = new AVMiPushMessageReceiver$1(this);
            object2 = ObserverBuilder.buildSingleObserver((SaveCallback)object2);
            ((z)object).subscribe((g0)object2);
        }
    }

    public void onCommandResult(Context object, MiPushCommandMessage object2) {
        boolean bl2;
        int n10;
        int n11;
        String string2;
        int n12;
        super.onCommandResult((Context)object, (MiPushCommandMessage)object2);
        object = ((MiPushCommandMessage)object2).getCommand();
        Object object3 = ((MiPushCommandMessage)object2).getCommandArguments();
        if (object3 != null && (n12 = object3.size()) > 0) {
            n12 = 0;
            string2 = (String)object3.get(0);
        } else {
            n12 = 0;
            string2 = null;
        }
        if (object3 != null && (n11 = object3.size()) > (n10 = 1)) {
            object3 = (String)object3.get(n10);
        }
        if (bl2 = ((String)(object3 = "register")).equals(object)) {
            long l10;
            long l11 = ((MiPushCommandMessage)object2).getResultCode();
            long l12 = l11 - (l10 = 0L);
            Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object4 == false) {
                this.updateAVInstallation(string2);
            }
        } else {
            object2 = "set-alias";
            boolean bl3 = ((String)object2).equals(object);
            if (!(bl3 || (bl3 = ((String)(object2 = "unset-alias")).equals(object)) || (bl3 = ((String)(object2 = "subscribe-topic")).equals(object)) || (bl3 = ((String)(object2 = "unsubscibe-topic")).equals(object)))) {
                object2 = "accept-time";
                ((String)object2).equals(object);
            }
        }
    }

    public void onNotificationMessageArrived(Context object, MiPushMessage object2) {
        boolean bl2;
        if (object2 != null && !(bl2 = StringUtil.isEmpty((String)(object = ((MiPushMessage)object2).getContent())))) {
            object2 = AndroidNotificationManager.getInstance();
            String string2 = AV_MIXPUSH_MI_NOTIFICATION_ARRIVED_ACTION;
            ((AndroidNotificationManager)object2).porcessMixNotificationArrived((String)object, string2);
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        this.processMiNotification(miPushMessage);
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        this.processMiPushMessage(miPushMessage);
    }

    public void onReceiveRegisterResult(Context object, MiPushCommandMessage object2) {
        String string2;
        int n10;
        super.onReceiveRegisterResult((Context)object, (MiPushCommandMessage)object2);
        object = ((MiPushCommandMessage)object2).getCommand();
        Object object3 = ((MiPushCommandMessage)object2).getCommandArguments();
        if (object3 != null && (n10 = object3.size()) > 0) {
            n10 = 0;
            string2 = null;
            object3 = (String)object3.get(0);
        } else {
            object3 = null;
        }
        string2 = "register";
        Object object4 = string2.equals(object);
        if (object4) {
            long l10;
            long l11 = ((MiPushCommandMessage)object2).getResultCode();
            long l12 = l11 - (l10 = 0L);
            object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (!object4) {
                this.updateAVInstallation((String)object3);
            } else {
                object = LOGGER;
                object3 = new StringBuilder();
                string2 = "register error, ";
                ((StringBuilder)object3).append(string2);
                object2 = ((MiPushCommandMessage)object2).toString();
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
                ((AVLogger)object).d((String)object2);
            }
        }
    }
}

