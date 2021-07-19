/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.s0.b;
import e.a.v0.c;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

public final class z1$a
implements g0,
b {
    public final g0 a;
    public final Iterator b;
    public final c c;
    public b d;
    public boolean e;

    public z1$a(g0 g02, Iterator iterator2, c c10) {
        this.a = g02;
        this.b = iterator2;
        this.c = c10;
    }

    public void a(Throwable throwable) {
        this.e = true;
        this.d.dispose();
        this.a.onError(throwable);
    }

    public void dispose() {
        this.d.dispose();
    }

    public boolean isDisposed() {
        return this.d.isDisposed();
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
            e.a.t0.a.b(throwable);
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
            e.a.t0.a.b(throwable);
            this.a(throwable);
            return;
        }
        try {
            object = this.b;
            boolean bl3 = object.hasNext();
            if (!bl3) {
                this.e = bl3 = true;
                this.d.dispose();
                object = this.a;
                object.onComplete();
            }
            return;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.a(throwable);
            return;
        }
    }

    public void onSubscribe(b object) {
        b b10 = this.d;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.d = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }
}

