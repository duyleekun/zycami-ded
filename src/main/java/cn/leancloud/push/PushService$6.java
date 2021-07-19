/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package cn.leancloud.push;

import android.os.Message;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVObject;
import cn.leancloud.push.PushService;
import e.a.g0;
import e.a.s0.b;
import java.util.Arrays;
import java.util.Collection;

public final class PushService$6
implements g0 {
    public final /* synthetic */ String val$finalChannel;

    public PushService$6(String string2) {
        this.val$finalChannel = string2;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        PushService.access$000().w(throwable);
    }

    public void onNext(AVObject aVObject) {
        aVObject = AVInstallation.getCurrentInstallation();
        String string2 = this.val$finalChannel;
        String[] stringArray = new String[]{string2};
        stringArray = Arrays.asList(stringArray);
        aVObject.removeAll("channels", (Collection)stringArray);
        aVObject = PushService.access$600();
        stringArray = Message.obtain();
        aVObject.sendMessage((Message)stringArray);
    }

    public void onSubscribe(b b10) {
    }
}

