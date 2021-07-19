/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import d.v.e0.ie.l;
import e.a.y0.d;

public class b
extends d {
    private l b;

    public b() {
    }

    public b(l l10) {
        this.b = l10;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        l l10 = this.b;
        if (l10 != null) {
            Exception exception = new Exception(throwable);
            l10.onFailed(exception);
        }
    }

    public void onNext(Object object) {
        l l10 = this.b;
        if (l10 != null) {
            l10.call(object);
        }
    }
}

