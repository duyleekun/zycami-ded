/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.AVOPPOPushAdapter;
import cn.leancloud.callback.SaveCallback;

public class AVOPPOPushAdapter$1
extends SaveCallback {
    public final /* synthetic */ AVOPPOPushAdapter this$0;

    public AVOPPOPushAdapter$1(AVOPPOPushAdapter aVOPPOPushAdapter) {
        this.this$0 = aVOPPOPushAdapter;
    }

    public void done(AVException object) {
        if (object != null) {
            AVLogger aVLogger = AVOPPOPushAdapter.access$000();
            String string2 = "update installation error!";
            aVLogger.e(string2, (Throwable)object);
        } else {
            object = AVOPPOPushAdapter.access$000();
            String string3 = "oppo push registration successful!";
            ((AVLogger)object).d(string3);
        }
    }
}

