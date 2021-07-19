/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.AVVIVOPushMessageReceiver;
import cn.leancloud.callback.SaveCallback;

public class AVVIVOPushMessageReceiver$1
extends SaveCallback {
    public final /* synthetic */ AVVIVOPushMessageReceiver this$0;
    public final /* synthetic */ String val$regId;

    public AVVIVOPushMessageReceiver$1(AVVIVOPushMessageReceiver aVVIVOPushMessageReceiver, String string2) {
        this.this$0 = aVVIVOPushMessageReceiver;
        this.val$regId = string2;
    }

    public void done(AVException object) {
        if (object != null) {
            AVLogger aVLogger = AVVIVOPushMessageReceiver.access$000();
            String string2 = "update installation(for vivo) error!";
            aVLogger.e(string2, (Throwable)object);
        } else {
            object = AVVIVOPushMessageReceiver.access$000();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("vivo push registration successful! regId=");
            String string3 = this.val$regId;
            charSequence.append(string3);
            charSequence = charSequence.toString();
            ((AVLogger)object).d((String)charSequence);
        }
    }
}

