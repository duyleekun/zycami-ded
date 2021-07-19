/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.me;

import d.v.e0.ie.l;
import d.v.e0.me.b;

public class e
extends b {
    private l c;

    public e(l l10) {
        this.c = l10;
    }

    public void onComplete() {
        l l10 = this.c;
        if (l10 != null) {
            l10.call(null);
        }
    }

    public void onError(Throwable throwable) {
        throwable.printStackTrace();
        l l10 = this.c;
        if (l10 != null) {
            Exception exception = new Exception(throwable);
            l10.onFailed(exception);
        }
    }

    public void onNext(Object object) {
    }
}

