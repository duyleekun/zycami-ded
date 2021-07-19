/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud;

import android.content.Context;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVVIVOPushMessageReceiver$1;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.convertor.ObserverBuilder;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import cn.leancloud.vivo.AVMixPushManager;
import d.r.a.r.c;
import d.r.a.s.b;
import e.a.g0;
import e.a.z;

public abstract class AVVIVOPushMessageReceiver
extends b {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVVIVOPushMessageReceiver.class);
    private final String VIVO_VERDOR;

    public AVVIVOPushMessageReceiver() {
        this.VIVO_VERDOR = "vivo";
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public abstract void onNotificationMessageClicked(Context var1, c var2);

    public void onReceiveRegId(Context object, String object2) {
        boolean bl2 = StringUtil.isEmpty((String)object2);
        if (bl2) {
            object = LOGGER;
            object2 = "received empty regId from VIVO server.";
            ((AVLogger)object).e((String)object2);
        } else {
            Object object3;
            String string2 = "vivo";
            object = AVInstallation.getCurrentInstallation();
            String string3 = ((AVObject)object).getString((String)(object3 = "vendor"));
            boolean bl3 = string2.equals(string3);
            if (!bl3) {
                ((AVObject)object).put((String)object3, string2);
            }
            if (!(bl3 = ((String)object2).equals(string3 = ((AVObject)object).getString((String)(object3 = "registrationId"))))) {
                ((AVObject)object).put((String)object3, object2);
            }
            if ((string3 = ((AVObject)object).getString((String)(object3 = "deviceProfile"))) == null) {
                string3 = "";
            }
            string2 = AVMixPushManager.vivoDeviceProfile;
            bl3 = string3.equals(string2);
            if (!bl3) {
                string3 = AVMixPushManager.vivoDeviceProfile;
                ((AVObject)object).put((String)object3, string3);
            }
            object = ((AVObject)object).saveInBackground();
            object3 = new AVVIVOPushMessageReceiver$1(this, (String)object2);
            object2 = ObserverBuilder.buildSingleObserver((SaveCallback)object3);
            ((z)object).subscribe((g0)object2);
        }
    }
}

