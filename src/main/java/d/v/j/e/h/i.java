/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.h;

import d.v.j.e.h.h;
import k.d;
import k.r;

public class i
extends h {
    public void onFailure(d d10, Throwable throwable) {
        this.a().onError(throwable, 0, "");
    }

    public void onResponse(d object, r object2) {
        object = this.a();
        object2 = ((r)object2).a();
        object.onSuccess(object2);
    }
}

