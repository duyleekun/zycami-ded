/*
 * Decompiled with CFR 0.151.
 */
package androidx.lifecycle;

import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleObserver;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Lifecycle {
    public AtomicReference mInternalScopeRef;

    public Lifecycle() {
        AtomicReference atomicReference;
        this.mInternalScopeRef = atomicReference = new AtomicReference();
    }

    public abstract void addObserver(LifecycleObserver var1);

    public abstract Lifecycle$State getCurrentState();

    public abstract void removeObserver(LifecycleObserver var1);
}

