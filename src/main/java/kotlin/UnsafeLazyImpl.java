/*
 * Decompiled with CFR 0.151.
 */
package kotlin;

import f.h2.s.a;
import f.h2.t.f0;
import f.k1;
import f.t;
import java.io.Serializable;
import kotlin.InitializedLazyImpl;

public final class UnsafeLazyImpl
implements t,
Serializable {
    private Object _value;
    private a initializer;

    public UnsafeLazyImpl(a object) {
        f0.p(object, "initializer");
        this.initializer = object;
        this._value = object = k1.a;
    }

    private final Object writeReplace() {
        Object object = this.getValue();
        InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl(object);
        return initializedLazyImpl;
    }

    public Object getValue() {
        Object object = this._value;
        k1 k12 = k1.a;
        if (object == k12) {
            object = this.initializer;
            f0.m(object);
            this._value = object = object.invoke();
            object = null;
            this.initializer = null;
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

