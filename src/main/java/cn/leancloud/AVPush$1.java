/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVException;
import cn.leancloud.AVObject;
import cn.leancloud.AVPush;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.SendCallback;
import cn.leancloud.json.JSONObject;
import e.a.g0;
import e.a.s0.b;
import java.util.Map;

public class AVPush$1
implements g0 {
    public final /* synthetic */ AVPush this$0;
    public final /* synthetic */ SendCallback val$callback;

    public AVPush$1(AVPush aVPush, SendCallback sendCallback) {
        this.this$0 = aVPush;
        this.val$callback = sendCallback;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        SendCallback sendCallback = this.val$callback;
        if (sendCallback != null) {
            AVException aVException = new AVException(throwable);
            sendCallback.internalDone(aVException);
        }
    }

    public void onNext(JSONObject object) {
        Object object2 = this.this$0;
        String string2 = "_Notification";
        AVObject aVObject = new AVObject(string2);
        AVPush.access$002((AVPush)object2, aVObject);
        object2 = AVPush.access$000(this.this$0);
        object = ((JSONObject)object).getInnerMap();
        ((AVObject)object2).resetServerData((Map)object);
        object = this.val$callback;
        if (object != null) {
            object2 = null;
            ((AVCallback)object).internalDone(null);
        }
    }

    public void onSubscribe(b b10) {
    }
}

