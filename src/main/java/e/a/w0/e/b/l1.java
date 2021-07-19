/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.v0.c;
import e.a.w0.e.b.a;
import e.a.w0.e.b.l1$a;
import i.g.d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;

public final class l1
extends a {
    public final Iterable c;
    public final c d;

    public l1(j j10, Iterable iterable, c c10) {
        super(j10);
        this.c = iterable;
        this.d = c10;
    }

    public void m6(d d10) {
        Object object;
        Object object2;
        block7: {
            try {
                object2 = this.c;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
            object2 = object2.iterator();
            object = "The iterator returned by other is null";
            object2 = e.a.w0.b.a.g(object2, (String)object);
            object2 = (Iterator)object2;
            try {
                boolean bl2 = object2.hasNext();
                if (bl2) break block7;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
            EmptySubscription.complete(d10);
            return;
        }
        object = this.b;
        c c10 = this.d;
        l1$a l1$a = new l1$a(d10, (Iterator)object2, c10);
        ((j)object).l6(l1$a);
    }
}

