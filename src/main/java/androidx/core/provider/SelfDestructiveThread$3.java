/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.SelfDestructiveThread;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SelfDestructiveThread$3
implements Runnable {
    public final /* synthetic */ SelfDestructiveThread this$0;
    public final /* synthetic */ Callable val$callable;
    public final /* synthetic */ Condition val$cond;
    public final /* synthetic */ AtomicReference val$holder;
    public final /* synthetic */ ReentrantLock val$lock;
    public final /* synthetic */ AtomicBoolean val$running;

    public SelfDestructiveThread$3(SelfDestructiveThread selfDestructiveThread, AtomicReference atomicReference, Callable callable, ReentrantLock reentrantLock, AtomicBoolean atomicBoolean, Condition condition) {
        this.this$0 = selfDestructiveThread;
        this.val$holder = atomicReference;
        this.val$callable = callable;
        this.val$lock = reentrantLock;
        this.val$running = atomicBoolean;
        this.val$cond = condition;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Callable callable;
        Object object;
        try {
            object = this.val$holder;
            callable = this.val$callable;
            callable = callable.call();
            ((AtomicReference)object).set(callable);
        }
        catch (Exception exception) {}
        object = this.val$lock;
        ((ReentrantLock)object).lock();
        try {
            object = this.val$running;
            callable = null;
            ((AtomicBoolean)object).set(false);
            object = this.val$cond;
            object.signal();
            return;
        }
        finally {
            this.val$lock.unlock();
        }
    }
}

