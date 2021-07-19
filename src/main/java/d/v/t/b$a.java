/*
 * Decompiled with CFR 0.151.
 */
package d.v.t;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import m.a.a;

public final class b$a
extends AVCallback {
    public void a(Boolean objectArray, AVException object) {
        objectArray = null;
        if (object != null) {
            objectArray = new Object[]{};
            String string2 = "leancloud api failed to turn on vivo push. cause:";
            a.b(string2, objectArray);
            ((Throwable)object).printStackTrace();
        } else {
            objectArray = new Object[]{};
            object = "leancloud api succeed to turn on vivo push.";
            a.b((String)object, objectArray);
        }
    }
}

