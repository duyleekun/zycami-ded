/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$1;
import androidx.concurrent.futures.AbstractResolvableFuture$Listener;
import androidx.concurrent.futures.AbstractResolvableFuture$Waiter;

public abstract class AbstractResolvableFuture$AtomicHelper {
    private AbstractResolvableFuture$AtomicHelper() {
    }

    public /* synthetic */ AbstractResolvableFuture$AtomicHelper(AbstractResolvableFuture$1 abstractResolvableFuture$1) {
        this();
    }

    public abstract boolean casListeners(AbstractResolvableFuture var1, AbstractResolvableFuture.Listener var2, AbstractResolvableFuture.Listener var3);

    public abstract boolean casValue(AbstractResolvableFuture var1, Object var2, Object var3);

    public abstract boolean casWaiters(AbstractResolvableFuture var1, AbstractResolvableFuture.Waiter var2, AbstractResolvableFuture.Waiter var3);

    public abstract void putNext(AbstractResolvableFuture.Waiter var1, AbstractResolvableFuture.Waiter var2);

    public abstract void putThread(AbstractResolvableFuture.Waiter var1, Thread var2);
}

