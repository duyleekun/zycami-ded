/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.callback;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.v2.AVIMException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AVIMOperationPartiallySucceededCallback
extends AVCallback {
    public abstract void done(AVIMException var1, List var2, List var3);

    public final void internalDone0(Map object, AVException object2) {
        if (object2 != null) {
            object = AVIMException.wrapperAVException((Throwable)object2);
            this.done((AVIMException)object, null, null);
        } else if (object != null) {
            object2 = (String[])object.get("callbackConvMemberPartialSUCC");
            String string2 = "callbackConvMemberPartialFAIL";
            object = (ArrayList)object.get(string2);
            object2 = Arrays.asList(object2);
            this.done(null, (List)object2, (List)object);
        } else {
            this.done(null, null, null);
        }
    }
}

