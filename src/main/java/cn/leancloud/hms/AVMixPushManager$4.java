/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.hms;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.hms.AVMixPushManager;

public final class AVMixPushManager$4
extends SaveCallback {
    public void done(AVException object) {
        if (object != null) {
            object = "unRegisterMixPush error!";
            AVMixPushManager.access$100((String)object);
        } else {
            object = AVMixPushManager.access$000();
            String string2 = "Registration canceled successfully!";
            ((AVLogger)object).d(string2);
        }
    }
}

