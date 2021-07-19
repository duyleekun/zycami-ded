/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 */
package cn.leancloud.vivo;

import android.app.Application;
import android.content.Context;
import cn.leancloud.AVException;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;
import cn.leancloud.AVObject;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import cn.leancloud.vivo.AVMixPushManager$1;
import cn.leancloud.vivo.AVMixPushManager$2;
import cn.leancloud.vivo.AVMixPushManager$3;
import cn.leancloud.vivo.AVMixPushManager$4;
import cn.leancloud.vivo.AVMixPushManager$5;
import cn.leancloud.vivo.AVMixPushManager$6;
import cn.leancloud.vivo.AVMixPushManager$7;
import com.vivo.push.util.VivoPushException;
import d.r.a.d;
import e.a.g0;
import e.a.z;
import java.util.List;

public class AVMixPushManager {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVMixPushManager.class);
    public static final String MIXPUSH_PROFILE = "deviceProfile";
    public static String vivoDeviceProfile = "";

    public static /* synthetic */ void access$000(String string2) {
        AVMixPushManager.printErrorLog(string2);
    }

    public static /* synthetic */ AVLogger access$100() {
        return LOGGER;
    }

    public static void bindVIVOAlias(Context object, String object2, AVCallback aVCallback) {
        if (object == null) {
            if (aVCallback != null) {
                object = Boolean.FALSE;
                int n10 = 142;
                String string2 = "context is null";
                object2 = new AVException(n10, string2);
                aVCallback.internalDone(object, (AVException)object2);
            }
        } else {
            object = d.f((Context)object);
            AVMixPushManager$3 aVMixPushManager$3 = new AVMixPushManager$3(aVCallback);
            ((d)object).a((String)object2, aVMixPushManager$3);
        }
    }

    public static void delVIVOTopic(Context object, String object2, AVCallback aVCallback) {
        if (object == null) {
            if (aVCallback != null) {
                object = Boolean.FALSE;
                int n10 = 142;
                String string2 = "context is null";
                object2 = new AVException(n10, string2);
                aVCallback.internalDone(object, (AVException)object2);
            }
        } else {
            object = d.f((Context)object);
            AVMixPushManager$6 aVMixPushManager$6 = new AVMixPushManager$6(aVCallback);
            ((d)object).d((String)object2, aVMixPushManager$6);
        }
    }

    public static String getVIVOAlias(Context context) {
        if (context == null) {
            return null;
        }
        return d.f(context).e();
    }

    public static List getVIVOTopics(Context context) {
        if (context == null) {
            return null;
        }
        return d.f(context).h();
    }

    public static boolean isSupportVIVOPush(Context object) {
        if ((object = d.f((Context)object)) == null) {
            return false;
        }
        return ((d)object).k();
    }

    private static void printErrorLog(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        if (!bl2) {
            AVLogger aVLogger = LOGGER;
            aVLogger.e(string2);
        }
    }

    public static boolean registerVIVOPush(Application application) {
        return AVMixPushManager.registerVIVOPush(application, "");
    }

    public static boolean registerVIVOPush(Application object, String charSequence) {
        vivoDeviceProfile = charSequence;
        object = d.f(object.getApplicationContext());
        try {
            ((d)object).b();
            ((d)object).j();
            return true;
        }
        catch (VivoPushException vivoPushException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("register error, mainifest is incomplete! details=");
            String string2 = vivoPushException.getMessage();
            ((StringBuilder)charSequence).append(string2);
            AVMixPushManager.printErrorLog(((StringBuilder)charSequence).toString());
            return false;
        }
    }

    public static void setVIVOTopic(Context object, String object2, AVCallback aVCallback) {
        if (object == null) {
            if (aVCallback != null) {
                object = Boolean.FALSE;
                int n10 = 142;
                String string2 = "context is null";
                object2 = new AVException(n10, string2);
                aVCallback.internalDone(object, (AVException)object2);
            }
        } else {
            object = d.f((Context)object);
            AVMixPushManager$5 aVMixPushManager$5 = new AVMixPushManager$5(aVCallback);
            ((d)object).m((String)object2, aVMixPushManager$5);
        }
    }

    public static void turnOffVIVOPush(AVCallback aVCallback) {
        d d10 = d.f(AVOSCloud.getContext());
        AVMixPushManager$1 aVMixPushManager$1 = new AVMixPushManager$1(aVCallback);
        d10.n(aVMixPushManager$1);
    }

    public static void turnOnVIVOPush(AVCallback aVCallback) {
        d d10 = d.f(AVOSCloud.getContext());
        AVMixPushManager$2 aVMixPushManager$2 = new AVMixPushManager$2(aVCallback);
        d10.o(aVMixPushManager$2);
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
            object = new AVMixPushManager$7();
            object = ObserverBuilder.buildSingleObserver((SaveCallback)object);
            ((z)object2).subscribe((g0)object);
        }
    }

    public static void unbindVIVOAlias(Context object, String object2, AVCallback aVCallback) {
        if (object == null) {
            if (aVCallback != null) {
                object = Boolean.FALSE;
                int n10 = 142;
                String string2 = "context is null";
                object2 = new AVException(n10, string2);
                aVCallback.internalDone(object, (AVException)object2);
            }
        } else {
            object = d.f((Context)object);
            AVMixPushManager$4 aVMixPushManager$4 = new AVMixPushManager$4(aVCallback);
            ((d)object).p((String)object2, aVMixPushManager$4);
        }
    }
}

