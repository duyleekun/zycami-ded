/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.s.a;
import f.h2.t.f0;
import f.h2.t.u;
import f.k1;
import f.t;
import java.io.Serializable;
import kotlin.InitializedLazyImpl;

public final class SynchronizedLazyImpl
implements t,
Serializable {
    private volatile Object _value;
    private a initializer;
    private final Object lock;

    public SynchronizedLazyImpl(a object, Object object2) {
        String string2 = "initializer";
        f0.p(object, string2);
        this.initializer = object;
        this._value = object = k1.a;
        if (object2 == null) {
            object2 = this;
        }
        this.lock = object2;
    }

    public /* synthetic */ SynchronizedLazyImpl(a a10, Object object, int n10, u u10) {
        if ((n10 &= 2) != 0) {
            object = null;
        }
        this(a10, object);
    }

    private final Object writeReplace() {
        Object object = this.getValue();
        InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl(object);
        return initializedLazyImpl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getValue() {
        Object object = this._value;
        Object object2 = k1.a;
        if (object != object2) {
            return object;
        }
        object = this.lock;
        synchronized (object) {
            Object object3 = this._value;
            if (object3 == object2) {
                object2 = this.initializer;
                f0.m(object2);
                this._value = object3 = object2.invoke();
                object2 = null;
                this.initializer = null;
            }
            return object3;
        }
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

