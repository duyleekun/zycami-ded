/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.AVMiPushMessageReceiver;
import cn.leancloud.callback.SaveCallback;

public class AVMiPushMessageReceiver$1
extends SaveCallback {
    public final /* synthetic */ AVMiPushMessageReceiver this$0;

    public AVMiPushMessageReceiver$1(AVMiPushMessageReceiver aVMiPushMessageReceiver) {
        this.this$0 = aVMiPushMessageReceiver;
    }

    public void done(AVException object) {
        if (object != null) {
            AVLogger aVLogger = AVMiPushMessageReceiver.access$000();
            String string2 = "update installation error!";
            aVLogger.e(string2, (Throwable)object);
        } else {
            object = AVMiPushMessageReceiver.access$000();
            String string3 = "Xiaomi push registration successful!";
            ((AVLogger)object).d(string3);
        }
    }
}

