/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;
import java.util.Map;

public class AndroidOperationTube$3
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;
    public final /* synthetic */ String val$self;

    public AndroidOperationTube$3(AndroidOperationTube androidOperationTube, AVCallback aVCallback, String string2) {
        this.this$0 = androidOperationTube;
        this.val$self = string2;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        object = AVIMClient.getInstance(this.val$self);
        AVCallback aVCallback = this.callback;
        throwable = AVIMException.wrapperAVException(throwable);
        aVCallback.internalDone(object, (AVException)throwable);
    }
}

