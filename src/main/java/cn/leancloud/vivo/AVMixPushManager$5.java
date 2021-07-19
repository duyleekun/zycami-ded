/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.vivo;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import d.r.a.a;

public final class AVMixPushManager$5
implements a {
    public final /* synthetic */ AVCallback val$callback;

    public AVMixPushManager$5(AVCallback aVCallback) {
        this.val$callback = aVCallback;
    }

    public void onStateChanged(int n10) {
        Object object = this.val$callback;
        if (object == null) {
            Boolean bl2;
            Object object2;
            int n11;
            object = null;
            if (n10 != 0) {
                n11 = 999;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "VIVO server internal error, state=";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                object2 = stringBuilder.toString();
                object = new AVException(n11, (String)object2);
            }
            object2 = this.val$callback;
            if (object == null) {
                n11 = 1;
            } else {
                n11 = 0;
                bl2 = null;
            }
            bl2 = n11 != 0;
            ((AVCallback)object2).internalDone(bl2, (AVException)object);
        }
    }
}

