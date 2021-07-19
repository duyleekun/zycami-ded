/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.x1.a;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.collections.State;

public abstract class b
implements Iterator,
f.h2.t.x0.a {
    private State a;
    private Object b;

    public b() {
        State state;
        this.a = state = State.NotReady;
    }

    private final boolean f() {
        boolean bl2;
        State state;
        this.a = state = State.Failed;
        this.b();
        state = this.a;
        State state2 = State.Ready;
        if (state == state2) {
            bl2 = true;
        } else {
            bl2 = false;
            state = null;
        }
        return bl2;
    }

    public abstract void b();

    public final void c() {
        State state;
        this.a = state = State.Done;
    }

    public final void e(Object object) {
        this.b = object;
        object = State.Ready;
        this.a = object;
    }

    public boolean hasNext() {
        Object object;
        Object object2 = this.a;
        Object object3 = State.Failed;
        Object object4 = 0;
        Object object5 = 1;
        if (object2 != object3) {
            object = object5;
        } else {
            object = 0;
            object3 = null;
        }
        if (object != 0) {
            object3 = f.x1.a.a;
            Object object6 = ((Enum)object2).ordinal();
            if ((object6 = (Object)((Object)object3[object6])) != object5) {
                object = 2;
                object4 = object6 != object ? (Object)this.f() : object5;
            }
            return (boolean)object4;
        }
        object3 = "Failed requirement.".toString();
        object2 = new IllegalArgumentException((String)object3);
        throw object2;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            State state;
            this.a = state = State.NotReady;
            return this.b;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

