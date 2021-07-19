/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;
import java.util.Map;

public class AndroidOperationTube$1
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;
    public final /* synthetic */ String val$clientId;

    public AndroidOperationTube$1(AndroidOperationTube androidOperationTube, AVCallback aVCallback, String string2) {
        this.this$0 = androidOperationTube;
        this.val$clientId = string2;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        object = AndroidOperationTube.access$000();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("openClient get response. error:");
        ((StringBuilder)object2).append(throwable);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)object).d((String)object2);
        object = this.callback;
        object2 = AVIMClient.getInstance(this.val$clientId);
        throwable = AVIMException.wrapperAVException(throwable);
        ((AVCallback)object).internalDone(object2, (AVException)throwable);
    }
}

