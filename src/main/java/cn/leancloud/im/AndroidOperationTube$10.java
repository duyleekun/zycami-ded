/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMException;
import java.util.Map;

public class AndroidOperationTube$10
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;

    public AndroidOperationTube$10(AndroidOperationTube androidOperationTube, AVCallback aVCallback) {
        this.this$0 = androidOperationTube;
        super(aVCallback);
    }

    public void execute(Map map, Throwable throwable) {
        AVCallback aVCallback = this.callback;
        throwable = AVIMException.wrapperAVException(throwable);
        aVCallback.internalDone(map, (AVException)throwable);
    }
}

