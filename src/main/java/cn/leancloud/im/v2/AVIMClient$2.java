/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.callback.AVIMClientCallback;

public class AVIMClient$2
extends AVIMClientCallback {
    public final /* synthetic */ AVIMClient this$0;
    public final /* synthetic */ AVIMClientCallback val$callback;

    public AVIMClient$2(AVIMClient aVIMClient, AVIMClientCallback aVIMClientCallback) {
        this.this$0 = aVIMClient;
        this.val$callback = aVIMClientCallback;
    }

    public void done(AVIMClient aVIMClient, AVIMException aVIMException) {
        Object object;
        if (aVIMException == null) {
            object = this.this$0;
            ((AVIMClient)object).localClose();
        }
        if ((object = this.val$callback) != null) {
            ((AVIMClientCallback)object).done(aVIMClient, aVIMException);
        }
    }
}

