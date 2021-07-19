/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package cn.leancloud.push;

import android.os.Message;
import cn.leancloud.AVObject;
import cn.leancloud.push.PushService;
import cn.leancloud.push.PushService$8;
import e.a.g0;
import e.a.s0.b;

public class PushService$8$1
implements g0 {
    public final /* synthetic */ PushService$8 this$0;

    public PushService$8$1(PushService$8 pushService$8) {
        this.this$0 = pushService$8;
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        String string2;
        boolean bl2;
        if (object != null && (bl2 = (string2 = "already has one request sending").equals(object = ((Throwable)object).getMessage()))) {
            PushService.access$600().removeMessages(0);
            object = Message.obtain();
            ((Message)object).what = 0;
            string2 = PushService.access$600();
            long l10 = 2000L;
            string2.sendMessageDelayed((Message)object, l10);
        }
    }

    public void onNext(AVObject aVObject) {
    }

    public void onSubscribe(b b10) {
    }
}

