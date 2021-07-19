/*
 * Decompiled with CFR 0.151.
 */
package f.b2;

import f.b2.h$a;
import f.b2.j.b;
import f.b2.k.a.c;
import f.h2.t.f0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result$Failure;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;

public final class h
implements f.b2.c,
c {
    private static final AtomicReferenceFieldUpdater c;
    private static final h$a d;
    private volatile Object a;
    private final f.b2.c b;

    static {
        h$a h$a;
        d = h$a = new h$a(null);
        c = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "a");
    }

    public h(f.b2.c c10) {
        f0.p(c10, "delegate");
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
        this(c10, (Object)coroutineSingletons);
    }

    public h(f.b2.c c10, Object object) {
        f0.p(c10, "delegate");
        this.b = c10;
        this.a = object;
    }

    public final Object a() {
        Object object;
        block7: {
            block6: {
                block5: {
                    object = this.a;
                    CoroutineSingletons coroutineSingletons = CoroutineSingletons.UNDECIDED;
                    if (object == coroutineSingletons) {
                        object = c;
                        Object object2 = f.b2.j.b.h();
                        boolean bl2 = ((AtomicReferenceFieldUpdater)object).compareAndSet(this, coroutineSingletons, object2);
                        if (bl2) {
                            return f.b2.j.b.h();
                        }
                        object = this.a;
                    }
                    if (object != (coroutineSingletons = CoroutineSingletons.RESUMED)) break block5;
                    object = f.b2.j.b.h();
                    break block6;
                }
                boolean bl3 = object instanceof Result$Failure;
                if (bl3) break block7;
            }
            return object;
        }
        throw ((Result$Failure)object).exception;
    }

    public c getCallerFrame() {
        f.b2.c c10 = this.b;
        boolean bl2 = c10 instanceof c;
        if (!bl2) {
            c10 = null;
        }
        return (c)((Object)c10);
    }

    public CoroutineContext getContext() {
        return this.b.getContext();
    }

    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public void resumeWith(Object object) {
        block2: {
            while (true) {
                CoroutineSingletons coroutineSingletons;
                boolean bl2;
                Object object2;
                Object object3;
                if ((object3 = this.a) == (object2 = CoroutineSingletons.UNDECIDED)) {
                    object3 = c;
                    bl2 = ((AtomicReferenceFieldUpdater)object3).compareAndSet(this, object2, object);
                    if (!bl2) continue;
                    return;
                }
                object2 = f.b2.j.b.h();
                if (object3 != object2) break block2;
                object3 = c;
                object2 = f.b2.j.b.h();
                bl2 = ((AtomicReferenceFieldUpdater)object3).compareAndSet(this, object2, coroutineSingletons = CoroutineSingletons.RESUMED);
                if (bl2) break;
            }
            this.b.resumeWith(object);
            return;
        }
        object = new IllegalStateException("Already resumed");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SafeContinuation for ");
        f.b2.c c10 = this.b;
        stringBuilder.append(c10);
        return stringBuilder.toString();
    }
}

