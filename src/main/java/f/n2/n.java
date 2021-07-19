/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.b2.c;
import f.b2.j.b;
import f.b2.k.a.f;
import f.h2.t.f0;
import f.h2.t.x0.a;
import f.n2.o;
import f.o0;
import f.q1;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

public final class n
extends o
implements Iterator,
c,
a {
    private int a;
    private Object b;
    private Iterator c;
    private c d;

    private final Throwable g() {
        RuntimeException runtimeException;
        int n10 = this.a;
        int n11 = 4;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                CharSequence charSequence = new StringBuilder();
                String string2 = "Unexpected state of the iterator: ";
                charSequence.append(string2);
                int n12 = this.a;
                charSequence.append(n12);
                charSequence = charSequence.toString();
                runtimeException = new IllegalStateException((String)charSequence);
            } else {
                String string3 = "Iterator has failed.";
                runtimeException = new IllegalStateException(string3);
            }
        } else {
            runtimeException = new NoSuchElementException();
        }
        return runtimeException;
    }

    private final Object i() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            return this.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Object b(Object object, c object2) {
        Object object3;
        int n10;
        this.b = object;
        this.a = n10 = 3;
        this.d = object2;
        object = f.b2.j.b.h();
        if (object == (object3 = f.b2.j.b.h())) {
            f.c((c)object2);
        }
        if (object == (object2 = f.b2.j.b.h())) {
            return object;
        }
        return q1.a;
    }

    public Object e(Iterator object, c object2) {
        Object object3;
        int n10;
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return q1.a;
        }
        this.c = object;
        this.a = n10 = 2;
        this.d = object2;
        object = f.b2.j.b.h();
        if (object == (object3 = f.b2.j.b.h())) {
            f.c((c)object2);
        }
        if (object == (object2 = f.b2.j.b.h())) {
            return object;
        }
        return q1.a;
    }

    public CoroutineContext getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final c h() {
        return this.d;
    }

    public boolean hasNext() {
        while (true) {
            Object object;
            int bl2 = this.a;
            boolean bl3 = false;
            Object object2 = null;
            if (bl2) {
                int n10 = 2;
                int n11 = 1;
                if (bl2 != n11) {
                    int n12;
                    if (bl2 != n10 && bl2 != (n12 = 3)) {
                        int n13 = 4;
                        if (bl2 == n13) {
                            return false;
                        }
                        throw this.g();
                    }
                    return n11;
                }
                object = this.c;
                f0.m(object);
                bl2 = (int)(object.hasNext() ? 1 : 0);
                if (bl2) {
                    this.a = n10;
                    return n11;
                }
                this.c = null;
            }
            bl2 = 5;
            this.a = bl2;
            object = this.d;
            f0.m(object);
            this.d = null;
            object2 = q1.a;
            object2 = Result.constructor-impl(object2);
            object.resumeWith(object2);
        }
    }

    public final void j(c c10) {
        this.d = c10;
    }

    public Object next() {
        int n10;
        int n11 = this.a;
        if (n11 != 0 && n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 != n12) {
                n10 = 3;
                if (n11 == n10) {
                    this.a = 0;
                    Object object = this.b;
                    this.b = null;
                    return object;
                }
                throw this.g();
            }
            this.a = n10;
            Iterator iterator2 = this.c;
            f0.m(iterator2);
            return iterator2.next();
        }
        return this.i();
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void resumeWith(Object object) {
        o0.n(object);
        this.a = 4;
    }
}

