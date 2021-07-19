/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.oppo;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.oppo.AVMixPushManager;

public final class AVMixPushManager$1
extends SaveCallback {
    public void done(AVException object) {
        if (object != null) {
            object = "unRegisterMixPush error!";
            AVMixPushManager.access$000((String)object);
        } else {
            object = AVMixPushManager.access$100();
            String string2 = "Registration canceled successfully!";
            ((AVLogger)object).d(string2);
        }
    }
}

