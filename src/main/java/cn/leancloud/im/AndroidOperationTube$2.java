/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMClient$AVIMClientStatus;
import cn.leancloud.im.v2.AVIMException;
import java.util.Map;

public class AndroidOperationTube$2
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;

    public AndroidOperationTube$2(AndroidOperationTube androidOperationTube, AVCallback aVCallback) {
        this.this$0 = androidOperationTube;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        Object object2;
        boolean bl2;
        if (object != null && (bl2 = object.containsKey(object2 = "callbackClientStatus"))) {
            int n10 = (Integer)object.get(object2);
            object = AVIMClient$AVIMClientStatus.getClientStatus(n10);
        } else {
            boolean bl3 = false;
            object = null;
        }
        object2 = this.callback;
        throwable = AVIMException.wrapperAVException(throwable);
        ((AVCallback)object2).internalDone(object, (AVException)throwable);
    }
}

