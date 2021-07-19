/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.hms;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import d.j.d.a.g;
import d.j.d.a.k;

public final class AVMixPushManager$2
implements g {
    public final /* synthetic */ AVCallback val$callback;

    public AVMixPushManager$2(AVCallback aVCallback) {
        this.val$callback = aVCallback;
    }

    public void onComplete(k object) {
        boolean bl2 = ((k)object).v();
        if (bl2) {
            object = this.val$callback;
            bl2 = false;
            Object var3_3 = null;
            ((AVCallback)object).internalDone(null);
        } else {
            AVCallback aVCallback = this.val$callback;
            object = ((k)object).q();
            AVException aVException = new AVException((Throwable)object);
            aVCallback.internalDone(aVException);
        }
    }
}

