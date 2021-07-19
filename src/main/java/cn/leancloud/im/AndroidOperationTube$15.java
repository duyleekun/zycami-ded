/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import java.util.Map;

public class AndroidOperationTube$15
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;

    public AndroidOperationTube$15(AndroidOperationTube androidOperationTube, AVCallback aVCallback) {
        this.this$0 = androidOperationTube;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        object = this.callback;
        if (object != null) {
            if (throwable == null) {
                throwable = null;
            } else {
                AVException aVException = new AVException(throwable);
                throwable = aVException;
            }
            ((AVCallback)object).internalDone((AVException)throwable);
        }
    }
}

