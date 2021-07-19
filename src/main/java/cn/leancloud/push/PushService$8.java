/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package cn.leancloud.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.leancloud.AVInstallation;
import cn.leancloud.push.PushService$8$1;
import e.a.z;

public final class PushService$8
extends Handler {
    public PushService$8(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message object) {
        object = AVInstallation.getCurrentInstallation().saveInBackground();
        PushService$8$1 pushService$8$1 = new PushService$8$1(this);
        ((z)object).subscribe(pushService$8$1);
    }
}

