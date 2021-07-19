/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;

public class AVCallback$1
implements Runnable {
    public final /* synthetic */ AVCallback this$0;
    public final /* synthetic */ AVException val$avException;
    public final /* synthetic */ Object val$t;

    public AVCallback$1(AVCallback aVCallback, Object object, AVException aVException) {
        this.this$0 = aVCallback;
        this.val$t = object;
        this.val$avException = aVException;
    }

    public void run() {
        AVCallback aVCallback = this.this$0;
        Object object = this.val$t;
        AVException aVException = this.val$avException;
        aVCallback.internalDone0(object, aVException);
    }
}

