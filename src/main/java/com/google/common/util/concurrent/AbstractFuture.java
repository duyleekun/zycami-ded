/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.AbstractFuture$AtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Cancellation;
import com.google.common.util.concurrent.AbstractFuture$Failure;
import com.google.common.util.concurrent.AbstractFuture$Listener;
import com.google.common.util.concurrent.AbstractFuture$SafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$SetFuture;
import com.google.common.util.concurrent.AbstractFuture$SynchronizedHelper;
import com.google.common.util.concurrent.AbstractFuture$Trusted;
import com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper;
import com.google.common.util.concurrent.AbstractFuture$Waiter;
import com.google.common.util.concurrent.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.common.util.concurrent.internal.InternalFutures;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFuture
extends InternalFutureFailureAccess
implements ListenableFuture {
    private static final AbstractFuture$AtomicHelper ATOMIC_HELPER;
    private static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final Logger log;
    private volatile AbstractFuture$Listener listeners;
    private volatile Object value;
    private volatile AbstractFuture$Waiter waiters;

    static {
        Object object;
        Object object2;
        Class<AbstractFuture> clazz = AbstractFuture$Waiter.class;
        Object object3 = "false";
        GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", (String)object3));
        log = Logger.getLogger(AbstractFuture.class.getName());
        Throwable throwable = null;
        try {
            object2 = object3 = new AbstractFuture$UnsafeAtomicHelper(null);
            object3 = null;
        }
        catch (Throwable throwable2) {
            AbstractFuture$SafeAtomicHelper abstractFuture$SafeAtomicHelper;
            object2 = Thread.class;
            object = "thread";
            object = AtomicReferenceFieldUpdater.newUpdater(clazz, object2, (String)object);
            object2 = "next";
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(clazz, clazz, (String)object2);
            object2 = AbstractFuture.class;
            Object object4 = "waiters";
            object4 = AtomicReferenceFieldUpdater.newUpdater(object2, clazz, (String)object4);
            clazz = AbstractFuture.class;
            object2 = AbstractFuture$Listener.class;
            Object object5 = "listeners";
            object5 = AtomicReferenceFieldUpdater.newUpdater(clazz, object2, (String)object5);
            clazz = AbstractFuture.class;
            object2 = Object.class;
            Object object6 = "value";
            object6 = AtomicReferenceFieldUpdater.newUpdater(clazz, object2, (String)object6);
            object2 = abstractFuture$SafeAtomicHelper;
            try {
                abstractFuture$SafeAtomicHelper = new AbstractFuture$SafeAtomicHelper((AtomicReferenceFieldUpdater)object, atomicReferenceFieldUpdater, (AtomicReferenceFieldUpdater)object4, (AtomicReferenceFieldUpdater)object5, (AtomicReferenceFieldUpdater)object6);
            }
            catch (Throwable throwable3) {
                object2 = new AbstractFuture$SynchronizedHelper(null);
                throwable = throwable3;
            }
        }
        ATOMIC_HELPER = object2;
        clazz = LockSupport.class;
        if (throwable != null) {
            clazz = log;
            object2 = Level.SEVERE;
            object = "UnsafeAtomicHelper is broken!";
            ((Logger)((Object)clazz)).log((Level)object2, (String)object, (Throwable)object3);
            object3 = "SafeAtomicHelper is broken!";
            ((Logger)((Object)clazz)).log((Level)object2, (String)object3, throwable);
        }
        clazz = new Class<AbstractFuture>();
        NULL = clazz;
    }

    public static /* synthetic */ AbstractFuture$AtomicHelper access$200() {
        return ATOMIC_HELPER;
    }

    public static /* synthetic */ boolean access$300() {
        return GENERATE_CANCELLATION_CAUSES;
    }

    public static /* synthetic */ Object access$400(AbstractFuture abstractFuture) {
        return abstractFuture.value;
    }

    public static /* synthetic */ Object access$402(AbstractFuture abstractFuture, Object object) {
        abstractFuture.value = object;
        return object;
    }

    public static /* synthetic */ Object access$500(ListenableFuture listenableFuture) {
        return AbstractFuture.getFutureValue(listenableFuture);
    }

    public static /* synthetic */ void access$600(AbstractFuture abstractFuture) {
        AbstractFuture.complete(abstractFuture);
    }

    public static /* synthetic */ AbstractFuture$Waiter access$800(AbstractFuture abstractFuture) {
        return abstractFuture.waiters;
    }

    public static /* synthetic */ AbstractFuture$Waiter access$802(AbstractFuture abstractFuture, AbstractFuture$Waiter abstractFuture$Waiter) {
        abstractFuture.waiters = abstractFuture$Waiter;
        return abstractFuture$Waiter;
    }

    public static /* synthetic */ AbstractFuture$Listener access$900(AbstractFuture abstractFuture) {
        return abstractFuture.listeners;
    }

    public static /* synthetic */ AbstractFuture$Listener access$902(AbstractFuture abstractFuture, AbstractFuture$Listener abstractFuture$Listener) {
        abstractFuture.listeners = abstractFuture$Listener;
        return abstractFuture$Listener;
    }

    private void addDoneString(StringBuilder stringBuilder) {
        String string2 = "]";
        Object object = AbstractFuture.getUninterruptibly(this);
        String string3 = "SUCCESS, result=[";
        stringBuilder.append(string3);
        this.appendUserObject(stringBuilder, object);
        try {
            stringBuilder.append(string2);
        }
        catch (RuntimeException runtimeException) {
            object = "UNKNOWN, cause=[";
            stringBuilder.append((String)object);
            Object object2 = runtimeException.getClass();
            stringBuilder.append(object2);
            object2 = " thrown from get()]";
            stringBuilder.append((String)object2);
        }
        catch (CancellationException cancellationException) {
            string2 = "CANCELLED";
            stringBuilder.append(string2);
        }
        catch (ExecutionException executionException) {
            string3 = "FAILURE, cause=[";
            stringBuilder.append(string3);
            Throwable throwable = executionException.getCause();
            stringBuilder.append(throwable);
            stringBuilder.append(string2);
        }
    }

    private void addPendingString(StringBuilder stringBuilder) {
        int n10 = stringBuilder.length();
        stringBuilder.append("PENDING");
        Object object = this.value;
        boolean bl2 = object instanceof AbstractFuture$SetFuture;
        String string2 = "]";
        if (bl2) {
            String string3 = ", setFuture=[";
            stringBuilder.append(string3);
            object = ((AbstractFuture$SetFuture)object).future;
            this.appendUserObject(stringBuilder, object);
            stringBuilder.append(string2);
        } else {
            CharSequence charSequence;
            block8: {
                object = this.pendingToString();
                try {
                    object = Strings.emptyToNull((String)object);
                    break block8;
                }
                catch (StackOverflowError stackOverflowError) {
                }
                catch (RuntimeException runtimeException) {
                    // empty catch block
                }
                charSequence = new StringBuilder();
                String string4 = "Exception thrown from implementation: ";
                ((StringBuilder)charSequence).append(string4);
                object = object.getClass();
                ((StringBuilder)charSequence).append(object);
                object = ((StringBuilder)charSequence).toString();
            }
            if (object != null) {
                charSequence = ", info=[";
                stringBuilder.append((String)charSequence);
                stringBuilder.append((String)object);
                stringBuilder.append(string2);
            }
        }
        int n11 = this.isDone();
        if (n11 != 0) {
            n11 = stringBuilder.length();
            stringBuilder.delete(n10, n11);
            this.addDoneString(stringBuilder);
        }
    }

    private void appendUserObject(StringBuilder stringBuilder, Object object) {
        block5: {
            Class<?> clazz;
            if (object == this) {
                object = "this future";
                stringBuilder.append((String)object);
                break block5;
            }
            try {
                stringBuilder.append(object);
                break block5;
            }
            catch (StackOverflowError stackOverflowError) {
            }
            catch (RuntimeException runtimeException) {
                // empty catch block
            }
            String string2 = "Exception thrown from implementation: ";
            stringBuilder.append(string2);
            clazz = clazz.getClass();
            stringBuilder.append(clazz);
        }
    }

    private static CancellationException cancellationExceptionWithCause(String string2, Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string2);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    private AbstractFuture$Listener clearListeners(AbstractFuture$Listener object) {
        AbstractFuture$Listener abstractFuture$Listener;
        AbstractFuture$Listener abstractFuture$Listener2;
        Object object2;
        boolean bl2;
        while (!(bl2 = ((AbstractFuture$AtomicHelper)(object2 = ATOMIC_HELPER)).casListeners(this, abstractFuture$Listener2 = this.listeners, abstractFuture$Listener = AbstractFuture$Listener.TOMBSTONE))) {
        }
        AbstractFuture$Listener abstractFuture$Listener3 = abstractFuture$Listener2;
        abstractFuture$Listener2 = object;
        object = abstractFuture$Listener3;
        while (object != null) {
            object2 = ((AbstractFuture$Listener)object).next;
            ((AbstractFuture$Listener)object).next = abstractFuture$Listener2;
            abstractFuture$Listener2 = object;
            object = object2;
        }
        return abstractFuture$Listener2;
    }

    private static void complete(AbstractFuture object) {
        AbstractFuture$Listener abstractFuture$Listener = null;
        block0: while (true) {
            ((AbstractFuture)object).releaseWaiters();
            ((AbstractFuture)object).afterDone();
            object = ((AbstractFuture)object).clearListeners(abstractFuture$Listener);
            while (object != null) {
                abstractFuture$Listener = ((AbstractFuture$Listener)object).next;
                Runnable runnable = ((AbstractFuture$Listener)object).task;
                boolean bl2 = runnable instanceof AbstractFuture$SetFuture;
                if (bl2) {
                    AbstractFuture$AtomicHelper abstractFuture$AtomicHelper;
                    boolean bl3;
                    runnable = (AbstractFuture$SetFuture)runnable;
                    object = ((AbstractFuture$SetFuture)runnable).owner;
                    Object object2 = ((AbstractFuture)object).value;
                    if (object2 == runnable && (bl3 = (abstractFuture$AtomicHelper = ATOMIC_HELPER).casValue((AbstractFuture)object, runnable, object2 = AbstractFuture.getFutureValue(((AbstractFuture$SetFuture)runnable).future)))) {
                        continue block0;
                    }
                } else {
                    object = ((AbstractFuture$Listener)object).executor;
                    AbstractFuture.executeListener(runnable, (Executor)object);
                }
                object = abstractFuture$Listener;
            }
            break;
        }
    }

    private static void executeListener(Runnable object, Executor executor) {
        try {
            executor.execute((Runnable)object);
        }
        catch (RuntimeException runtimeException) {
            Logger logger = log;
            Level level = Level.SEVERE;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "RuntimeException while executing runnable ";
            stringBuilder.append(string2);
            stringBuilder.append(object);
            stringBuilder.append(" with executor ");
            stringBuilder.append(executor);
            object = stringBuilder.toString();
            logger.log(level, (String)object, runtimeException);
        }
    }

    private Object getDoneValue(Object object) {
        boolean bl2 = object instanceof AbstractFuture$Cancellation;
        if (!bl2) {
            bl2 = object instanceof AbstractFuture$Failure;
            if (!bl2) {
                Object object2 = NULL;
                if (object == object2) {
                    object = null;
                }
                return object;
            }
            object = ((AbstractFuture$Failure)object).exception;
            ExecutionException executionException = new ExecutionException((Throwable)object);
            throw executionException;
        }
        object = ((AbstractFuture$Cancellation)object).cause;
        throw AbstractFuture.cancellationExceptionWithCause("Task was cancelled.", (Throwable)object);
    }

    private static Object getFutureValue(ListenableFuture object) {
        Object object2;
        block24: {
            boolean bl2;
            Object object3;
            Object object4 = "get() did not throw CancellationException, despite reporting isCancelled() == true: ";
            boolean bl3 = object instanceof AbstractFuture$Trusted;
            IllegalArgumentException illegalArgumentException = null;
            if (bl3) {
                object = ((AbstractFuture)object).value;
                boolean bl4 = object instanceof AbstractFuture$Cancellation;
                if (bl4) {
                    object4 = object;
                    object4 = (AbstractFuture$Cancellation)object;
                    bl3 = ((AbstractFuture$Cancellation)object4).wasInterrupted;
                    if (bl3) {
                        object = ((AbstractFuture$Cancellation)object4).cause;
                        if (object != null) {
                            object4 = ((AbstractFuture$Cancellation)object4).cause;
                            object = new AbstractFuture$Cancellation(false, (Throwable)object4);
                        } else {
                            object = AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
                        }
                    }
                }
                return object;
            }
            bl3 = object instanceof InternalFutureFailureAccess;
            if (bl3) {
                object3 = object;
                object3 = InternalFutures.tryInternalFastPathGetFailure((InternalFutureFailureAccess)object);
                if (object3 != null) {
                    object = new AbstractFuture$Failure((Throwable)object3);
                    return object;
                }
            }
            if (bl2 = (GENERATE_CANCELLATION_CAUSES ^ true) & (bl3 = ((Future)object).isCancelled())) {
                return AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
            }
            object2 = AbstractFuture.getUninterruptibly((Future)object);
            if (!bl3) break block24;
            CharSequence charSequence = new StringBuilder();
            charSequence.append((String)object4);
            charSequence.append(object);
            charSequence = charSequence.toString();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException((String)charSequence);
            try {
                object2 = new AbstractFuture$Cancellation(false, illegalArgumentException2);
                return object2;
            }
            catch (Throwable throwable) {
                object4 = new AbstractFuture$Failure(throwable);
                return object4;
            }
            catch (CancellationException cancellationException) {
                if (!bl3) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    ((StringBuilder)object2).append(object);
                    object = ((StringBuilder)object2).toString();
                    illegalArgumentException = new IllegalArgumentException((String)object, cancellationException);
                    object3 = new AbstractFuture$Failure(illegalArgumentException);
                    return object3;
                }
                object = new AbstractFuture$Cancellation(false, cancellationException);
                return object;
            }
            catch (ExecutionException executionException) {
                if (bl3) {
                    charSequence = new StringBuilder();
                    charSequence.append((String)object4);
                    charSequence.append(object);
                    object = charSequence.toString();
                    illegalArgumentException2 = new IllegalArgumentException((String)object, executionException);
                    object3 = new AbstractFuture$Cancellation(false, illegalArgumentException2);
                    return object3;
                }
                object4 = executionException.getCause();
                object = new AbstractFuture$Failure((Throwable)object4);
                return object;
            }
        }
        if (object2 == null) {
            object2 = NULL;
        }
        return object2;
    }

    private static Object getUninterruptibly(Future future) {
        boolean bl2 = false;
        Thread thread = null;
        while (true) {
            block5: {
                try {
                    future = future.get();
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        thread = Thread.currentThread();
                        thread.interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    continue;
                }
                thread = Thread.currentThread();
                thread.interrupt();
            }
            return future;
            break;
        }
    }

    private void releaseWaiters() {
        AbstractFuture$Waiter abstractFuture$Waiter;
        AbstractFuture$Waiter abstractFuture$Waiter2;
        AbstractFuture$AtomicHelper abstractFuture$AtomicHelper;
        boolean bl2;
        while (!(bl2 = (abstractFuture$AtomicHelper = ATOMIC_HELPER).casWaiters(this, abstractFuture$Waiter2 = this.waiters, abstractFuture$Waiter = AbstractFuture$Waiter.TOMBSTONE))) {
        }
        while (abstractFuture$Waiter2 != null) {
            abstractFuture$Waiter2.unpark();
            abstractFuture$Waiter2 = abstractFuture$Waiter2.next;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void removeWaiter(AbstractFuture$Waiter var1_1) {
        var1_1.thread = null;
        block0: while (true) {
            if ((var1_1 = this.waiters) == (var2_2 = AbstractFuture$Waiter.TOMBSTONE)) {
                return;
            }
            var2_2 = null;
            while (var1_1 != null) {
                var3_3 = var1_1.next;
                var4_4 = var1_1.thread;
                if (var4_4 != null) {
                    var2_2 = var1_1;
                } else if (var2_2 != null) {
                    var2_2.next = var3_3;
                    var1_1 = var2_2.thread;
                    if (var1_1 == null) {
                        continue block0;
                    }
                } else {
                    var4_4 = AbstractFuture.ATOMIC_HELPER;
                    var5_5 = var4_4.casWaiters(this, (AbstractFuture$Waiter)var1_1, var3_3);
                    if (var5_5) ** break;
                    continue block0;
                }
                var1_1 = var3_3;
            }
            break;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        AbstractFuture$Listener abstractFuture$Listener;
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Object object = "Executor was null.";
        Preconditions.checkNotNull(executor, object);
        boolean bl2 = this.isDone();
        if (!bl2 && (object = this.listeners) != (abstractFuture$Listener = AbstractFuture$Listener.TOMBSTONE)) {
            Object object2;
            abstractFuture$Listener = new AbstractFuture$Listener(runnable, executor);
            do {
                abstractFuture$Listener.next = object;
                object2 = ATOMIC_HELPER;
                bl2 = ((AbstractFuture$AtomicHelper)object2).casListeners(this, (AbstractFuture$Listener)object, abstractFuture$Listener);
                if (!bl2) continue;
                return;
            } while ((object = this.listeners) != (object2 = AbstractFuture$Listener.TOMBSTONE));
        }
        AbstractFuture.executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    public boolean cancel(boolean bl2) {
        boolean bl3;
        block15: {
            AbstractFuture$Cancellation abstractFuture$Cancellation;
            boolean bl4;
            Object object = this.value;
            bl3 = true;
            float f10 = Float.MIN_VALUE;
            if (object == null) {
                bl4 = bl3;
            } else {
                bl4 = false;
                abstractFuture$Cancellation = null;
            }
            boolean bl5 = object instanceof AbstractFuture$SetFuture;
            if (bl4 |= bl5) {
                Object object2;
                String string2;
                bl4 = GENERATE_CANCELLATION_CAUSES;
                if (bl4) {
                    string2 = "Future.cancel() was called.";
                    object2 = new CancellationException(string2);
                    abstractFuture$Cancellation = new AbstractFuture$Cancellation(bl2, (Throwable)object2);
                } else {
                    abstractFuture$Cancellation = bl2 ? AbstractFuture$Cancellation.CAUSELESS_INTERRUPTED : AbstractFuture$Cancellation.CAUSELESS_CANCELLED;
                }
                object2 = this;
                boolean bl6 = false;
                string2 = null;
                float f11 = 0.0f;
                while (true) {
                    AbstractFuture$AtomicHelper abstractFuture$AtomicHelper;
                    boolean bl7;
                    if (bl7 = (abstractFuture$AtomicHelper = ATOMIC_HELPER).casValue((AbstractFuture)object2, object, abstractFuture$Cancellation)) {
                        if (bl2) {
                            ((AbstractFuture)object2).interruptTask();
                        }
                        AbstractFuture.complete((AbstractFuture)object2);
                        bl5 = object instanceof AbstractFuture$SetFuture;
                        if (bl5) {
                            object = ((AbstractFuture$SetFuture)object).future;
                            bl5 = object instanceof AbstractFuture$Trusted;
                            if (bl5) {
                                object2 = object;
                                object2 = (AbstractFuture)object;
                                object = ((AbstractFuture)object2).value;
                                if (object == null) {
                                    bl6 = bl3;
                                    f11 = f10;
                                } else {
                                    bl6 = false;
                                    string2 = null;
                                    f11 = 0.0f;
                                }
                                bl7 = object instanceof AbstractFuture$SetFuture;
                                if (bl6 |= bl7) {
                                    bl6 = bl3;
                                    f11 = f10;
                                    continue;
                                }
                            } else {
                                object.cancel(bl2);
                            }
                        }
                        break block15;
                    }
                    object = ((AbstractFuture)object2).value;
                    bl7 = object instanceof AbstractFuture$SetFuture;
                    if (!bl7) break;
                }
                bl3 = bl6;
                f10 = f11;
            } else {
                bl3 = false;
                f10 = 0.0f;
            }
        }
        return bl3;
    }

    public Object get() {
        boolean bl2 = Thread.interrupted();
        if (!bl2) {
            AbstractFuture$Waiter abstractFuture$Waiter;
            boolean bl3;
            Object object = this.value;
            boolean bl4 = true;
            if (object != null) {
                bl3 = bl4;
            } else {
                bl3 = false;
                abstractFuture$Waiter = null;
            }
            boolean bl5 = object instanceof AbstractFuture$SetFuture ^ bl4;
            if (bl3 &= bl5) {
                return this.getDoneValue(object);
            }
            object = this.waiters;
            abstractFuture$Waiter = AbstractFuture$Waiter.TOMBSTONE;
            if (object != abstractFuture$Waiter) {
                Object object2;
                abstractFuture$Waiter = new AbstractFuture$Waiter();
                do {
                    block8: {
                        boolean bl6;
                        abstractFuture$Waiter.setNext((AbstractFuture$Waiter)object);
                        object2 = ATOMIC_HELPER;
                        bl2 = ((AbstractFuture$AtomicHelper)object2).casWaiters(this, (AbstractFuture$Waiter)object, abstractFuture$Waiter);
                        if (!bl2) continue;
                        do {
                            LockSupport.park(this);
                            bl2 = Thread.interrupted();
                            if (bl2) break block8;
                            object = this.value;
                            if (object != null) {
                                bl5 = bl4;
                                continue;
                            }
                            bl5 = false;
                            object2 = null;
                        } while (!(bl5 &= (bl6 = object instanceof AbstractFuture$SetFuture ^ bl4)));
                        return this.getDoneValue(object);
                    }
                    this.removeWaiter(abstractFuture$Waiter);
                    object = new InterruptedException();
                    throw object;
                } while ((object = this.waiters) != (object2 = AbstractFuture$Waiter.TOMBSTONE));
            }
            object = this.value;
            return this.getDoneValue(object);
        }
        InterruptedException interruptedException = new InterruptedException();
        throw interruptedException;
    }

    public Object get(long l10, TimeUnit timeUnit) {
        AbstractFuture abstractFuture = this;
        long l11 = l10;
        Object object = timeUnit;
        long l12 = timeUnit.toNanos(l10);
        Object object2 = Thread.interrupted();
        if (object2 == 0) {
            boolean bl2;
            int n10;
            Object object3;
            boolean bl3;
            Object object4;
            Object object5;
            long l13;
            long l14;
            long l15;
            int n11;
            int n12;
            Object object6;
            block16: {
                object6 = this.value;
                n12 = 1;
                n11 = object6 != null ? n12 : 0;
                int n13 = object6 instanceof AbstractFuture$SetFuture ^ n12;
                if ((n11 &= n13) != 0) {
                    return abstractFuture.getDoneValue(object6);
                }
                l15 = 0L;
                long l16 = l12 - l15;
                object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                l14 = object2 > 0 ? System.nanoTime() + l12 : l15;
                l13 = 1000L;
                long l17 = l12 - l13;
                object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object2 >= 0) {
                    object6 = abstractFuture.waiters;
                    object5 = AbstractFuture$Waiter.TOMBSTONE;
                    if (object6 != object5) {
                        object5 = new AbstractFuture$Waiter();
                        do {
                            block15: {
                                long l18;
                                ((AbstractFuture$Waiter)object5).setNext((AbstractFuture$Waiter)object6);
                                object4 = ATOMIC_HELPER;
                                object2 = ((AbstractFuture$AtomicHelper)object4).casWaiters(abstractFuture, (AbstractFuture$Waiter)object6, (AbstractFuture$Waiter)object5);
                                if (object2 == 0) continue;
                                do {
                                    LockSupport.parkNanos(abstractFuture, l12);
                                    bl3 = Thread.interrupted();
                                    if (bl3) break block15;
                                    object3 = abstractFuture.value;
                                    n10 = object3 != null ? n12 : 0;
                                    object2 = object3 instanceof AbstractFuture$SetFuture ^ n12;
                                    if ((n10 &= object2) != 0) {
                                        return abstractFuture.getDoneValue(object3);
                                    }
                                    l12 = System.nanoTime();
                                } while ((object2 = (Object)((l18 = (l12 = l14 - l12) - l13) == 0L ? 0 : (l18 < 0L ? -1 : 1))) >= 0);
                                abstractFuture.removeWaiter((AbstractFuture$Waiter)object5);
                                break block16;
                            }
                            abstractFuture.removeWaiter((AbstractFuture$Waiter)object5);
                            InterruptedException interruptedException = new InterruptedException();
                            throw interruptedException;
                        } while ((object6 = abstractFuture.waiters) != (object4 = AbstractFuture$Waiter.TOMBSTONE));
                    }
                    Object object7 = abstractFuture.value;
                    return abstractFuture.getDoneValue(object7);
                }
            }
            while ((object2 = (Object)(l12 == l15 ? 0 : (l12 < l15 ? -1 : 1))) > 0) {
                object3 = abstractFuture.value;
                n10 = object3 != null ? n12 : 0;
                object2 = object3 instanceof AbstractFuture$SetFuture ^ n12;
                if ((n10 &= object2) != 0) {
                    return abstractFuture.getDoneValue(object3);
                }
                bl3 = Thread.interrupted();
                if (!bl3) {
                    l12 = System.nanoTime();
                    l12 = l14 - l12;
                    continue;
                }
                InterruptedException interruptedException = new InterruptedException();
                throw interruptedException;
            }
            object6 = this.toString();
            object4 = timeUnit.toString();
            Object object8 = Locale.ROOT;
            object4 = ((String)object4).toLowerCase((Locale)object8);
            StringBuilder stringBuilder = new StringBuilder();
            object5 = "Waited ";
            stringBuilder.append((String)object5);
            stringBuilder.append(l11);
            Object object9 = " ";
            stringBuilder.append((String)object9);
            String string2 = timeUnit.toString().toLowerCase((Locale)object8);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            l14 = l12 + l13;
            long l19 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
            if (l19 < 0) {
                long l20;
                object8 = new StringBuilder();
                ((StringBuilder)object8).append(string2);
                ((StringBuilder)object8).append(" (plus ");
                string2 = ((StringBuilder)object8).toString();
                l12 = -l12;
                object8 = TimeUnit.NANOSECONDS;
                l14 = ((TimeUnit)((Object)object)).convert(l12, (TimeUnit)((Object)object8));
                long l21 = ((TimeUnit)((Object)object)).toNanos(l14);
                long l22 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
                int n14 = l22 != false && (n11 = (int)((l20 = (l12 -= l21) - l13) == 0L ? 0 : (l20 < 0L ? -1 : 1))) <= 0 ? 0 : n12;
                if (l22 > 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(l14);
                    ((StringBuilder)object).append((String)object9);
                    ((StringBuilder)object).append((String)object4);
                    string2 = ((StringBuilder)object).toString();
                    if (n14 != 0) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        ((StringBuilder)object).append(",");
                        string2 = ((StringBuilder)object).toString();
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append((String)object9);
                    string2 = ((StringBuilder)object).toString();
                }
                if (n14 != 0) {
                    object9 = new StringBuilder();
                    ((StringBuilder)object9).append(string2);
                    ((StringBuilder)object9).append(l12);
                    ((StringBuilder)object9).append(" nanoseconds ");
                    string2 = ((StringBuilder)object9).toString();
                }
                object9 = new StringBuilder();
                ((StringBuilder)object9).append(string2);
                ((StringBuilder)object9).append("delay)");
                string2 = ((StringBuilder)object9).toString();
            }
            if (bl2 = this.isDone()) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(" but future completed as timeout expired");
                string2 = ((StringBuilder)object).toString();
                object9 = new TimeoutException(string2);
                throw object9;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" for ");
            ((StringBuilder)object).append((String)object6);
            string2 = ((StringBuilder)object).toString();
            object9 = new TimeoutException(string2);
            throw object9;
        }
        InterruptedException interruptedException = new InterruptedException();
        throw interruptedException;
    }

    public void interruptTask() {
    }

    public boolean isCancelled() {
        return this.value instanceof AbstractFuture$Cancellation;
    }

    public boolean isDone() {
        Object object = this.value;
        boolean bl2 = true;
        boolean bl3 = object != null ? bl2 : false;
        return (object instanceof AbstractFuture$SetFuture ^ bl2) & bl3;
    }

    public final void maybePropagateCancellationTo(Future future) {
        boolean bl2 = future != null;
        boolean bl3 = this.isCancelled();
        if (bl2 &= bl3) {
            bl2 = this.wasInterrupted();
            future.cancel(bl2);
        }
    }

    public String pendingToString() {
        boolean bl2 = this instanceof ScheduledFuture;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("remaining delay=[");
            Future future = this;
            future = (ScheduledFuture)((Object)this);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long l10 = future.getDelay(timeUnit);
            stringBuilder.append(l10);
            stringBuilder.append(" ms]");
            return stringBuilder.toString();
        }
        return null;
    }

    public boolean set(Object object) {
        AbstractFuture$AtomicHelper abstractFuture$AtomicHelper;
        boolean bl2;
        if (object == null) {
            object = NULL;
        }
        if (bl2 = (abstractFuture$AtomicHelper = ATOMIC_HELPER).casValue(this, null, object)) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    public boolean setException(Throwable object) {
        object = (Throwable)Preconditions.checkNotNull(object);
        object = ATOMIC_HELPER;
        AbstractFuture$Failure abstractFuture$Failure = new AbstractFuture$Failure((Throwable)object);
        boolean bl2 = ((AbstractFuture$AtomicHelper)object).casValue(this, null, abstractFuture$Failure);
        if (bl2) {
            AbstractFuture.complete(this);
            return true;
        }
        return false;
    }

    public boolean setFuture(ListenableFuture object) {
        boolean bl2;
        boolean bl3;
        Preconditions.checkNotNull(object);
        Object object2 = this.value;
        Object object3 = null;
        if (object2 == null) {
            bl3 = object.isDone();
            bl2 = true;
            boolean bl4 = false;
            if (bl3) {
                object2 = ATOMIC_HELPER;
                boolean bl5 = ((AbstractFuture$AtomicHelper)object2).casValue(this, null, object = AbstractFuture.getFutureValue((ListenableFuture)object));
                if (bl5) {
                    AbstractFuture.complete(this);
                    return bl2;
                }
                return false;
            }
            AbstractFuture$AtomicHelper abstractFuture$AtomicHelper = ATOMIC_HELPER;
            object2 = new AbstractFuture$SetFuture(this, (ListenableFuture)object);
            bl4 = abstractFuture$AtomicHelper.casValue(this, null, object2);
            if (bl4) {
                object3 = DirectExecutor.INSTANCE;
                try {
                    object.addListener((Runnable)object2, (Executor)object3);
                }
                catch (Throwable throwable) {
                    try {
                        object3 = new AbstractFuture$Failure(throwable);
                    }
                    catch (Throwable throwable2) {
                        object3 = AbstractFuture$Failure.FALLBACK_INSTANCE;
                    }
                    AbstractFuture$AtomicHelper abstractFuture$AtomicHelper2 = ATOMIC_HELPER;
                    abstractFuture$AtomicHelper2.casValue(this, object2, object3);
                }
                return bl2;
            }
            object2 = this.value;
        }
        if (bl2 = object2 instanceof AbstractFuture$Cancellation) {
            object2 = (AbstractFuture$Cancellation)object2;
            bl3 = ((AbstractFuture$Cancellation)object2).wasInterrupted;
            object.cancel(bl3);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        string2 = "[status=";
        stringBuilder.append(string2);
        boolean bl2 = this.isCancelled();
        if (bl2) {
            string2 = "CANCELLED";
            stringBuilder.append(string2);
        } else {
            bl2 = this.isDone();
            if (bl2) {
                this.addDoneString(stringBuilder);
            } else {
                this.addPendingString(stringBuilder);
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final Throwable tryInternalFastPathGetFailure() {
        Object object;
        boolean bl2;
        boolean bl3 = this instanceof AbstractFuture$Trusted;
        if (bl3 && (bl2 = (object = this.value) instanceof AbstractFuture$Failure)) {
            return ((AbstractFuture$Failure)object).exception;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean wasInterrupted() {
        Object object = this.value;
        boolean bl2 = object instanceof AbstractFuture$Cancellation;
        if (!bl2) return false;
        object = (AbstractFuture$Cancellation)object;
        boolean bl3 = ((AbstractFuture$Cancellation)object).wasInterrupted;
        if (!bl3) return false;
        return true;
    }
}

