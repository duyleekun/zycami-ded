/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import java.util.Map;

public abstract class FollowersAndFolloweesCallback
extends AVCallback {
    public abstract void done(Map var1, AVException var2);

    public final void internalDone0(Map map, AVException aVException) {
        this.done(map, aVException);
    }
}

