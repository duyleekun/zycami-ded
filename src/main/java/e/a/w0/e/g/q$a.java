/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.g;

import e.a.a1.a;
import e.a.l0;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

public final class q$a
implements o,
b {
    public final l0 a;
    public e b;
    public Object c;
    public boolean d;
    public volatile boolean e;

    public q$a(l0 l02) {
        this.a = l02;
    }

    public void dispose() {
        this.e = true;
        this.b.cancel();
    }

    public boolean isDisposed() {
        return this.e;
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        Object object = this.c;
        Object object2 = null;
        this.c = null;
        if (object == null) {
            object = this.a;
            String string2 = "The source Publisher is empty";
            object2 = new NoSuchElementException(string2);
            object.onError((Throwable)object2);
        } else {
            object2 = this.a;
            object2.onSuccess(object);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.d = true;
        this.c = null;
        this.a.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        Object object2 = this.c;
        if (object2 != null) {
            this.b.cancel();
            this.d = true;
            this.c = null;
            object = this.a;
            String string2 = "Too many elements in the Publisher";
            object2 = new IndexOutOfBoundsException(string2);
            object.onError((Throwable)object2);
        } else {
            this.c = object;
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.b;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.b = e10;
            object = this.a;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

