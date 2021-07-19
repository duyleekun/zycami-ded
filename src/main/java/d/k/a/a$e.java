/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import d.k.a.a$a;
import i.g.d;
import i.g.e;

public final class a$e
implements d,
e {
    public static final /* synthetic */ boolean f;
    private final d a;
    private final a$a b;
    private e c;
    private volatile boolean d;
    private boolean e = true;

    public a$e(d d10, a$a a$a) {
        this.a = d10;
        this.b = a$a;
    }

    public void cancel() {
        e e10 = this.c;
        this.d = true;
        e10.cancel();
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.c = e10;
        this.a.onSubscribe(this);
    }

    public void request(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        object = this.e;
        if (object != false) {
            boolean bl2;
            object = 0;
            this.e = false;
            Object object2 = this.b.b;
            if (object2 != null && !(bl2 = this.d)) {
                long l13;
                long l14;
                d d10 = this.a;
                d10.onNext(object2);
                long l15 = Long.MAX_VALUE;
                object = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
                if (object != false && (l14 = (l13 = (l10 -= (l15 = 1L)) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                    return;
                }
            }
        }
        this.c.request(l10);
    }
}

