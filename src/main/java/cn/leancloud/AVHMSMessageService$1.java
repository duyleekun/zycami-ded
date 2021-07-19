/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVHMSMessageService;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.SaveCallback;

public final class AVHMSMessageService$1
extends SaveCallback {
    public void done(AVException object) {
        if (object != null) {
            AVLogger aVLogger = AVHMSMessageService.LOGGER;
            String string2 = "update installation error!";
            aVLogger.e(string2, (Throwable)object);
        } else {
            object = AVHMSMessageService.LOGGER;
            String string3 = "Huawei push registration successful!";
            ((AVLogger)object).d(string3);
        }
    }
}

