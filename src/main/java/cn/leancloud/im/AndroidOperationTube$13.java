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

public class AndroidOperationTube$13
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;

    public AndroidOperationTube$13(AndroidOperationTube androidOperationTube, AVCallback aVCallback) {
        this.this$0 = androidOperationTube;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        Object object2;
        if (object == null) {
            object = null;
        } else {
            object2 = "callbackHistoryMessages";
            object = (List)object.get(object2);
        }
        object2 = this.callback;
        throwable = AVIMException.wrapperAVException(throwable);
        ((AVCallback)object2).internalDone(object, (AVException)throwable);
    }
}

