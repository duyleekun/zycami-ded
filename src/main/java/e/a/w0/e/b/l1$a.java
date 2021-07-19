/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.o;
import e.a.v0.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;

public final class l1$a
implements o,
e {
    public final d a;
    public final Iterator b;
    public final c c;
    public e d;
    public boolean e;

    public l1$a(d d10, Iterator iterator2, c c10) {
        this.a = d10;
        this.b = iterator2;
        this.c = c10;
    }

    public void a(Throwable throwable) {
        e.a.t0.a.b(throwable);
        this.e = true;
        this.d.cancel();
        this.a.onError(throwable);
    }

    public void cancel() {
        this.d.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        this.e = true;
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.e;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.e = true;
        this.a.onError(throwable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object object) {
        Object object3;
        Object object2;
        boolean bl2 = this.e;
        if (bl2) {
            return;
        }
        try {
            object2 = this.b;
            object2 = object2.next();
            object3 = "The iterator returned a null value";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
        }
        catch (Throwable throwable) {
            this.a(throwable);
            return;
        }
        try {
            object3 = this.c;
            object = object3.apply(object, object2);
            object2 = "The zipper function returned a null value";
            object = e.a.w0.b.a.g(object, (String)object2);
            object2 = this.a;
            object2.onNext(object);
        }
        catch (Throwable throwable) {
            this.a(throwable);
            return;
        }
        try {
            object = this.b;
            boolean bl3 = object.hasNext();
            if (!bl3) {
                this.e = bl3 = true;
                this.d.cancel();
                object = this.a;
                object.onComplete();
            }
            return;
        }
        catch (Throwable throwable) {
            this.a(throwable);
            return;
        }
    }

    public void onSubscribe(e object) {
        e e10 = this.d;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.d.request(l10);
    }
}

