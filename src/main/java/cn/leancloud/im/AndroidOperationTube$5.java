/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMException;
import java.util.List;
import java.util.Map;

public class AndroidOperationTube$5
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;

    public AndroidOperationTube$5(AndroidOperationTube androidOperationTube, AVCallback aVCallback) {
        this.this$0 = androidOperationTube;
        super(aVCallback);
    }

    public void execute(Map list, Throwable object) {
        if (object != null) {
            list = this.callback;
            object = AVIMException.wrapperAVException((Throwable)object);
            ((AVCallback)((Object)list)).internalDone(null, (AVException)object);
        } else {
            boolean bl2;
            list = list != null && (bl2 = list.containsKey(object = "callbackOnlineClient")) ? (List)list.get(object) : null;
            object = this.callback;
            ((AVCallback)object).internalDone(list, null);
        }
    }
}

