/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.session.AVDefaultConnectionListener;

public class AVDefaultConnectionListener$2
extends AVCallback {
    public final /* synthetic */ AVDefaultConnectionListener this$0;

    public AVDefaultConnectionListener$2(AVDefaultConnectionListener aVDefaultConnectionListener) {
        this.this$0 = aVDefaultConnectionListener;
    }

    public void internalDone0(Object object, AVException aVException) {
        this.this$0.session.reopen();
    }
}

