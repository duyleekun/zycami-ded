/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOPPOPushAdapter$1;
import cn.leancloud.AVObject;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.oppo.AVMixPushManager;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import d.i.a.a.b.a;
import e.a.g0;
import e.a.z;

public class AVOPPOPushAdapter
implements a {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVOPPOPushAdapter.class);
    private static final String VENDOR_OPPO = "oppo";

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    private void updateAVInstallation(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            String string2;
            String string3 = VENDOR_OPPO;
            Object object2 = AVInstallation.getCurrentInstallation();
            String string4 = ((AVObject)object2).getString(string2 = "vendor");
            boolean bl3 = string3.equals(string4);
            if (!bl3) {
                ((AVObject)object2).put(string2, string3);
            }
            if (!(bl3 = ((String)object).equals(string4 = ((AVObject)object2).getString(string2 = "registrationId")))) {
                ((AVObject)object2).put(string2, object);
            }
            if ((string2 = ((AVObject)object2).getString((String)(object = "deviceProfile"))) == null) {
                string2 = "";
            }
            string4 = AVMixPushManager.oppoDeviceProfile;
            boolean bl4 = string2.equals(string4);
            if (!bl4) {
                string2 = AVMixPushManager.oppoDeviceProfile;
                ((AVObject)object2).put((String)object, string2);
            }
            object = ((AVObject)object2).saveInBackground();
            object2 = new AVOPPOPushAdapter$1(this);
            object2 = ObserverBuilder.buildSingleObserver((SaveCallback)object2);
            ((z)object).subscribe((g0)object2);
        }
    }

    public void onGetNotificationStatus(int n10, int n11) {
        if (n10 != 0) {
            AVLogger aVLogger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to getNotificationStatus. errorCode: ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            aVLogger.e(string3);
        } else {
            AVLogger aVLogger = LOGGER;
            String string4 = "succeeded to getNotificationStatus.";
            aVLogger.i(string4);
        }
    }

    public void onGetPushStatus(int n10, int n11) {
        if (n10 != 0) {
            AVLogger aVLogger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to getPushStatus. errorCode: ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            aVLogger.e(string3);
        } else {
            AVLogger aVLogger = LOGGER;
            String string4 = "succeeded to getPushStatus.";
            aVLogger.i(string4);
        }
    }

    public void onRegister(int n10, String object) {
        if (n10 != 0) {
            object = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("failed to register device. errorCode: ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            ((AVLogger)object).e(string2);
            return;
        }
        n10 = (int)(StringUtil.isEmpty((String)object) ? 1 : 0);
        if (n10 != 0) {
            LOGGER.e("oppo register id is empty.");
            return;
        }
        this.updateAVInstallation((String)object);
    }

    public void onSetPushTime(int n10, String object) {
        if (n10 != 0) {
            object = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to setPushTime. errorCode: ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            ((AVLogger)object).e(string3);
        } else {
            AVLogger aVLogger = LOGGER;
            object = "succeeded to setPushTime.";
            aVLogger.i((String)object);
        }
    }

    public void onUnRegister(int n10) {
        if (n10 != 0) {
            AVLogger aVLogger = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "failed to unregister device. errorCode: ";
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            String string3 = stringBuilder.toString();
            aVLogger.e(string3);
        } else {
            AVLogger aVLogger = LOGGER;
            String string4 = "succeeded to unregister device.";
            aVLogger.i(string4);
        }
    }
}

