/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.w0.e.e.c$a;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class c$a$a
implements Iterator {
    private Object a;
    public final /* synthetic */ c$a b;

    public c$a$a(c$a a10) {
        this.b = a10;
    }

    public boolean hasNext() {
        Object object;
        this.a = object = this.b.b;
        return NotificationLite.isComplete(object) ^ true;
    }

    public Object next() {
        try {
            boolean bl2;
            Object object = this.a;
            if (object == null) {
                object = this.b;
                this.a = object = ((c$a)object).b;
            }
            if (!(bl2 = NotificationLite.isComplete(object = this.a))) {
                object = this.a;
                bl2 = NotificationLite.isError(object);
                if (!bl2) {
                    object = this.a;
                    object = NotificationLite.getValue(object);
                    return object;
                }
                object = this.a;
                object = NotificationLite.getError(object);
                object = ExceptionHelper.f((Throwable)object);
                throw object;
            }
            object = new NoSuchElementException();
            throw object;
        }
        finally {
            this.a = null;
        }
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Read only iterator");
        throw unsupportedOperationException;
    }
}

