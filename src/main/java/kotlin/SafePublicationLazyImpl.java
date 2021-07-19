/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.s.a;
import f.h2.t.f0;
import f.k1;
import f.t;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.InitializedLazyImpl;
import kotlin.SafePublicationLazyImpl$a;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public final class SafePublicationLazyImpl
implements t,
Serializable {
    public static final SafePublicationLazyImpl$a Companion;
    private static final AtomicReferenceFieldUpdater a;
    private volatile Object _value;
    private final Object final;
    private volatile a initializer;

    static {
        SafePublicationLazyImpl$a safePublicationLazyImpl$a;
        Companion = safePublicationLazyImpl$a = new SafePublicationLazyImpl$a(null);
        a = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    }

    public SafePublicationLazyImpl(a object) {
        f0.p(object, "initializer");
        this.initializer = object;
        this._value = object = k1.a;
        this.final = object;
    }

    private final Object writeReplace() {
        Object object = this.getValue();
        InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl(object);
        return initializedLazyImpl;
    }

    public Object getValue() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        boolean bl2;
        Object object = this._value;
        k1 k12 = k1.a;
        if (object != k12) {
            return object;
        }
        object = this.initializer;
        if (object != null && (bl2 = (atomicReferenceFieldUpdater = a).compareAndSet(this, k12, object = object.invoke()))) {
            this.initializer = null;
            return object;
        }
        return this._value;
    }

    public boolean isInitialized() {
        boolean bl2;
        Object object = this._value;
        k1 k12 = k1.a;
        if (object != k12) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public String toString() {
        boolean bl2 = this.isInitialized();
        String string2 = bl2 ? String.valueOf(this.getValue()) : "Lazy value not initialized yet.";
        return string2;
    }
}

