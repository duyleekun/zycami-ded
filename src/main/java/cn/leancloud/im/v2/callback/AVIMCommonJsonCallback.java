/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;
import java.util.Map;

public abstract class AVIMCommonJsonCallback
extends AVCallback {
    public abstract void done(Map var1, AVIMException var2);

    public void internalDone0(Map map, AVException aVException) {
        aVException = AVIMException.wrapperAVException(aVException);
        this.done(map, (AVIMException)aVException);
    }
}

