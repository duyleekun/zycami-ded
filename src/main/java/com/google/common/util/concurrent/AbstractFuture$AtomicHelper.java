/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.AbstractFuture$1;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$Waiter;

public abstract class AbstractFuture$AtomicHelper {
    private AbstractFuture$AtomicHelper() {
    }

    public /* synthetic */ AbstractFuture$AtomicHelper(AbstractFuture$1 abstractFuture$1) {
        this();
    }

    public abstract boolean casListeners(AbstractFuture var1, AbstractFuture.Listener var2, AbstractFuture.Listener var3);

    public abstract boolean casValue(AbstractFuture var1, Object var2, Object var3);

    public abstract boolean casWaiters(AbstractFuture var1, AbstractFuture.Waiter var2, AbstractFuture.Waiter var3);

    public abstract void putNext(AbstractFuture.Waiter var1, AbstractFuture.Waiter var2);

    public abstract void putThread(AbstractFuture.Waiter var1, Thread var2);
}

