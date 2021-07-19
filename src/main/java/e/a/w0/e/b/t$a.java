/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.h.b;
import i.g.d;
import java.util.Collection;

public final class t$a
extends b {
    public final Collection f;
    public final o g;

    public t$a(d d10, o o10, Collection collection) {
        super(d10);
        this.g = o10;
        this.f = collection;
    }

    public void clear() {
        this.f.clear();
        super.clear();
    }

    public void onComplete() {
        boolean bl2 = this.d;
        if (!bl2) {
            this.d = bl2 = true;
            this.f.clear();
            d d10 = this.a;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.d;
        if (bl2) {
            e.a.a1.a.Y(throwable);
        } else {
            this.d = bl2 = true;
            this.f.clear();
            d d10 = this.a;
            d10.onError(throwable);
        }
    }

    public void onNext(Object object) {
        int n10 = this.d;
        if (n10 != 0) {
            return;
        }
        n10 = this.e;
        if (n10 == 0) {
            Object object2;
            try {
                object2 = this.g;
            }
            catch (Throwable throwable) {
                this.c(throwable);
                return;
            }
            object2 = object2.apply(object);
            Object object3 = "The keySelector returned a null key";
            object2 = e.a.w0.b.a.g(object2, (String)object3);
            object3 = this.f;
            n10 = (int)(object3.add(object2) ? 1 : 0);
            if (n10 != 0) {
                object2 = this.a;
                object2.onNext(object);
            }
            object = this.b;
            long l10 = 1L;
            object.request(l10);
        } else {
            object = this.a;
            n10 = 0;
            Object var3_5 = null;
            object.onNext(null);
        }
    }

    public Object poll() {
        Object object;
        while ((object = this.c.poll()) != null) {
            Collection collection = this.f;
            Object object2 = this.g.apply(object);
            String string2 = "The keySelector returned a null key";
            int n10 = collection.add(object2 = e.a.w0.b.a.g(object2, string2));
            if (n10 != 0) break;
            int n11 = this.e;
            n10 = 2;
            if (n11 != n10) continue;
            object = this.b;
            long l10 = 1L;
            object.request(l10);
        }
        return object;
    }

    public int requestFusion(int n10) {
        return this.d(n10);
    }
}

