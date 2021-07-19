/*
 * Decompiled with CFR 0.151.
 */
package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper;
import androidx.concurrent.futures.AbstractResolvableFuture$Cancellation;
import androidx.concurrent.futures.AbstractResolvableFuture$Failure;
import androidx.concurrent.futures.AbstractResolvableFuture$Listener;
import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper;
import androidx.concurrent.futures.AbstractResolvableFuture$SetFuture;
import androidx.concurrent.futures.AbstractResolvableFuture$SynchronizedHelper;
import androidx.concurrent.futures.AbstractResolvableFuture$Waiter;
import androidx.concurrent.futures.DirectExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.Objects;
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

public abstract class AbstractResolvableFuture
implements ListenableFuture {
    public static final AbstractResolvableFuture$AtomicHelper ATOMIC_HELPER;
    public static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final Logger log;
    public volatile AbstractResolvableFuture$Listener listeners;
    public volatile Object value;
    public volatile AbstractResolvableFuture$Waiter waiters;

    static {
        boolean bl2;
        Class<AbstractResolvableFuture> clazz = AbstractResolvableFuture$Waiter.class;
        Object object = "false";
        GENERATE_CANCELLATION_CAUSES = bl2 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", (String)object));
        Object object2 = Logger.getLogger(AbstractResolvableFuture.class.getName());
        log = object2;
        object = Thread.class;
        Object object3 = "thread";
        object3 = AtomicReferenceFieldUpdater.newUpdater(clazz, object, (String)object3);
        object = "next";
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = AtomicReferenceFieldUpdater.newUpdater(clazz, clazz, (String)object);
        object = AbstractResolvableFuture.class;
        Object object4 = "waiters";
        object4 = AtomicReferenceFieldUpdater.newUpdater(object, clazz, (String)object4);
        clazz = AbstractResolvableFuture.class;
        object = AbstractResolvableFuture$Listener.class;
        Object object5 = "listeners";
        object5 = AtomicReferenceFieldUpdater.newUpdater(clazz, object, (String)object5);
        clazz = AbstractResolvableFuture.class;
        object = Object.class;
        Object object6 = "value";
        object6 = AtomicReferenceFieldUpdater.newUpdater(clazz, object, (String)object6);
        object = object2;
        try {
            object2 = new AbstractResolvableFuture$SafeAtomicHelper((AtomicReferenceFieldUpdater)object3, atomicReferenceFieldUpdater, (AtomicReferenceFieldUpdater)object4, (AtomicReferenceFieldUpdater)object5, (AtomicReferenceFieldUpdater)object6);
            clazz = null;
        }
        catch (Throwable throwable) {
            object2 = new AbstractResolvableFuture$SynchronizedHelper();
        }
        ATOMIC_HELPER = object2;
        object2 = LockSupport.class;
        if (clazz != null) {
            object2 = log;
            object = Level.SEVERE;
            object3 = "SafeAtomicHelper is broken!";
            ((Logger)object2).log((Level)object, (String)object3, (Throwable)((Object)clazz));
        }
        clazz = new Class<AbstractResolvableFuture>();
        NULL = clazz;
    }

    private void addDoneString(StringBuilder stringBuilder) {
        String string2 = "]";
        Object object = AbstractResolvableFuture.getUninterruptibly(this);
        String string3 = "SUCCESS, result=[";
        stringBuilder.append(string3);
        object = this.userObjectToString(object);
        stringBuilder.append((String)object);
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

    private static CancellationException cancellationExceptionWithCause(String string2, Throwable throwable) {
        CancellationException cancellationException = new CancellationException(string2);
        cancellationException.initCause(throwable);
        return cancellationException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    private AbstractResolvableFuture$Listener clearListeners(AbstractResolvableFuture$Listener object) {
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener;
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2;
        Object object2;
        boolean bl2;
        while (!(bl2 = ((AbstractResolvableFuture$AtomicHelper)(object2 = ATOMIC_HELPER)).casListeners(this, abstractResolvableFuture$Listener2 = this.listeners, abstractResolvableFuture$Listener = AbstractResolvableFuture$Listener.TOMBSTONE))) {
        }
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener3 = abstractResolvableFuture$Listener2;
        abstractResolvableFuture$Listener2 = object;
        object = abstractResolvableFuture$Listener3;
        while (object != null) {
            object2 = ((AbstractResolvableFuture$Listener)object).next;
            ((AbstractResolvableFuture$Listener)object).next = abstractResolvableFuture$Listener2;
            abstractResolvableFuture$Listener2 = object;
            object = object2;
        }
        return abstractResolvableFuture$Listener2;
    }

    public static void complete(AbstractResolvableFuture object) {
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener = null;
        block0: while (true) {
            ((AbstractResolvableFuture)object).releaseWaiters();
            ((AbstractResolvableFuture)object).afterDone();
            object = ((AbstractResolvableFuture)object).clearListeners(abstractResolvableFuture$Listener);
            while (object != null) {
                abstractResolvableFuture$Listener = ((AbstractResolvableFuture$Listener)object).next;
                Runnable runnable = ((AbstractResolvableFuture$Listener)object).task;
                boolean bl2 = runnable instanceof AbstractResolvableFuture$SetFuture;
                if (bl2) {
                    AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper;
                    boolean bl3;
                    runnable = (AbstractResolvableFuture$SetFuture)runnable;
                    object = ((AbstractResolvableFuture$SetFuture)runnable).owner;
                    Object object2 = ((AbstractResolvableFuture)object).value;
                    if (object2 == runnable && (bl3 = (abstractResolvableFuture$AtomicHelper = ATOMIC_HELPER).casValue((AbstractResolvableFuture)object, runnable, object2 = AbstractResolvableFuture.getFutureValue(((AbstractResolvableFuture$SetFuture)runnable).future)))) {
                        continue block0;
                    }
                } else {
                    object = ((AbstractResolvableFuture$Listener)object).executor;
                    AbstractResolvableFuture.executeListener(runnable, (Executor)object);
                }
                object = abstractResolvableFuture$Listener;
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
        boolean bl2 = object instanceof AbstractResolvableFuture$Cancellation;
        if (!bl2) {
            bl2 = object instanceof AbstractResolvableFuture$Failure;
            if (!bl2) {
                Object object2 = NULL;
                if (object == object2) {
                    object = null;
                }
                return object;
            }
            object = ((AbstractResolvableFuture$Failure)object).exception;
            ExecutionException executionException = new ExecutionException((Throwable)object);
            throw executionException;
        }
        object = ((AbstractResolvableFuture$Cancellation)object).cause;
        throw AbstractResolvableFuture.cancellationExceptionWithCause("Task was cancelled.", (Throwable)object);
    }

    public static Object getFutureValue(ListenableFuture object) {
        Object object2;
        block12: {
            boolean bl2 = object instanceof AbstractResolvableFuture;
            IllegalArgumentException illegalArgumentException = null;
            if (bl2) {
                object = ((AbstractResolvableFuture)object).value;
                bl2 = object instanceof AbstractResolvableFuture$Cancellation;
                if (bl2) {
                    Object object3 = object;
                    object3 = (AbstractResolvableFuture$Cancellation)object;
                    boolean bl3 = ((AbstractResolvableFuture$Cancellation)object3).wasInterrupted;
                    if (bl3) {
                        object = ((AbstractResolvableFuture$Cancellation)object3).cause;
                        if (object != null) {
                            object3 = ((AbstractResolvableFuture$Cancellation)object3).cause;
                            object = new AbstractResolvableFuture$Cancellation(false, (Throwable)object3);
                        } else {
                            object = AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
                        }
                    }
                }
                return object;
            }
            bl2 = object.isCancelled();
            boolean bl4 = (GENERATE_CANCELLATION_CAUSES ^ true) & bl2;
            if (bl4) {
                return AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
            }
            object2 = AbstractResolvableFuture.getUninterruptibly((Future)object);
            if (object2 != null) break block12;
            try {
                object2 = NULL;
            }
            catch (Throwable throwable) {
                AbstractResolvableFuture$Failure abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure(throwable);
                return abstractResolvableFuture$Failure;
            }
            catch (CancellationException cancellationException) {
                if (!bl2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("get() threw CancellationException, despite reporting isCancelled() == false: ");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    illegalArgumentException = new IllegalArgumentException((String)object, cancellationException);
                    AbstractResolvableFuture$Failure abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure(illegalArgumentException);
                    return abstractResolvableFuture$Failure;
                }
                object = new AbstractResolvableFuture$Cancellation(false, cancellationException);
                return object;
            }
            catch (ExecutionException executionException) {
                Throwable throwable = executionException.getCause();
                AbstractResolvableFuture$Failure abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure(throwable);
                return abstractResolvableFuture$Failure;
            }
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
        AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter;
        AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter2;
        AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper;
        boolean bl2;
        while (!(bl2 = (abstractResolvableFuture$AtomicHelper = ATOMIC_HELPER).casWaiters(this, abstractResolvableFuture$Waiter2 = this.waiters, abstractResolvableFuture$Waiter = AbstractResolvableFuture$Waiter.TOMBSTONE))) {
        }
        while (abstractResolvableFuture$Waiter2 != null) {
            abstractResolvableFuture$Waiter2.unpark();
            abstractResolvableFuture$Waiter2 = abstractResolvableFuture$Waiter2.next;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void removeWaiter(AbstractResolvableFuture$Waiter var1_1) {
        var1_1.thread = null;
        block0: while (true) {
            if ((var1_1 = this.waiters) == (var2_2 = AbstractResolvableFuture$Waiter.TOMBSTONE)) {
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
                    var4_4 = AbstractResolvableFuture.ATOMIC_HELPER;
                    var5_5 = var4_4.casWaiters(this, (AbstractResolvableFuture$Waiter)var1_1, var3_3);
                    if (var5_5) ** break;
                    continue block0;
                }
                var1_1 = var3_3;
            }
            break;
        }
    }

    private String userObjectToString(Object object) {
        if (object == this) {
            return "this future";
        }
        return String.valueOf(object);
    }

    public final void addListener(Runnable runnable, Executor executor) {
        AbstractResolvableFuture.checkNotNull(runnable);
        AbstractResolvableFuture.checkNotNull(executor);
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener = this.listeners;
        AbstractResolvableFuture$Listener abstractResolvableFuture$Listener2 = AbstractResolvableFuture$Listener.TOMBSTONE;
        if (abstractResolvableFuture$Listener != abstractResolvableFuture$Listener2) {
            Object object;
            abstractResolvableFuture$Listener2 = new AbstractResolvableFuture$Listener(runnable, executor);
            do {
                abstractResolvableFuture$Listener2.next = abstractResolvableFuture$Listener;
                object = ATOMIC_HELPER;
                boolean bl2 = ((AbstractResolvableFuture$AtomicHelper)object).casListeners(this, abstractResolvableFuture$Listener, abstractResolvableFuture$Listener2);
                if (!bl2) continue;
                return;
            } while ((abstractResolvableFuture$Listener = this.listeners) != (object = AbstractResolvableFuture$Listener.TOMBSTONE));
        }
        AbstractResolvableFuture.executeListener(runnable, executor);
    }

    public void afterDone() {
    }

    public final boolean cancel(boolean bl2) {
        boolean bl3;
        block15: {
            AbstractResolvableFuture$Cancellation abstractResolvableFuture$Cancellation;
            boolean bl4;
            Object object = this.value;
            bl3 = true;
            float f10 = Float.MIN_VALUE;
            if (object == null) {
                bl4 = bl3;
            } else {
                bl4 = false;
                abstractResolvableFuture$Cancellation = null;
            }
            boolean bl5 = object instanceof AbstractResolvableFuture$SetFuture;
            if (bl4 |= bl5) {
                Object object2;
                String string2;
                bl4 = GENERATE_CANCELLATION_CAUSES;
                if (bl4) {
                    string2 = "Future.cancel() was called.";
                    object2 = new CancellationException(string2);
                    abstractResolvableFuture$Cancellation = new AbstractResolvableFuture$Cancellation(bl2, (Throwable)object2);
                } else {
                    abstractResolvableFuture$Cancellation = bl2 ? AbstractResolvableFuture$Cancellation.CAUSELESS_INTERRUPTED : AbstractResolvableFuture$Cancellation.CAUSELESS_CANCELLED;
                }
                object2 = this;
                boolean bl6 = false;
                string2 = null;
                float f11 = 0.0f;
                while (true) {
                    AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper;
                    boolean bl7;
                    if (bl7 = (abstractResolvableFuture$AtomicHelper = ATOMIC_HELPER).casValue((AbstractResolvableFuture)object2, object, abstractResolvableFuture$Cancellation)) {
                        if (bl2) {
                            ((AbstractResolvableFuture)object2).interruptTask();
                        }
                        AbstractResolvableFuture.complete((AbstractResolvableFuture)object2);
                        bl5 = object instanceof AbstractResolvableFuture$SetFuture;
                        if (bl5) {
                            object = ((AbstractResolvableFuture$SetFuture)object).future;
                            bl5 = object instanceof AbstractResolvableFuture;
                            if (bl5) {
                                object2 = object;
                                object2 = (AbstractResolvableFuture)object;
                                object = ((AbstractResolvableFuture)object2).value;
                                if (object == null) {
                                    bl6 = bl3;
                                    f11 = f10;
                                } else {
                                    bl6 = false;
                                    string2 = null;
                                    f11 = 0.0f;
                                }
                                bl7 = object instanceof AbstractResolvableFuture$SetFuture;
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
                    object = ((AbstractResolvableFuture)object2).value;
                    bl7 = object instanceof AbstractResolvableFuture$SetFuture;
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

    public final Object get() {
        boolean bl2 = Thread.interrupted();
        if (!bl2) {
            AbstractResolvableFuture$Waiter abstractResolvableFuture$Waiter;
            boolean bl3;
            Object object = this.value;
            boolean bl4 = true;
            if (object != null) {
                bl3 = bl4;
            } else {
                bl3 = false;
                abstractResolvableFuture$Waiter = null;
            }
            boolean bl5 = object instanceof AbstractResolvableFuture$SetFuture ^ bl4;
            if (bl3 &= bl5) {
                return this.getDoneValue(object);
            }
            object = this.waiters;
            abstractResolvableFuture$Waiter = AbstractResolvableFuture$Waiter.TOMBSTONE;
            if (object != abstractResolvableFuture$Waiter) {
                Object object2;
                abstractResolvableFuture$Waiter = new AbstractResolvableFuture$Waiter();
                do {
                    block8: {
                        boolean bl6;
                        abstractResolvableFuture$Waiter.setNext((AbstractResolvableFuture$Waiter)object);
                        object2 = ATOMIC_HELPER;
                        bl2 = ((AbstractResolvableFuture$AtomicHelper)object2).casWaiters(this, (AbstractResolvableFuture$Waiter)object, abstractResolvableFuture$Waiter);
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
                        } while (!(bl5 &= (bl6 = object instanceof AbstractResolvableFuture$SetFuture ^ bl4)));
                        return this.getDoneValue(object);
                    }
                    this.removeWaiter(abstractResolvableFuture$Waiter);
                    object = new InterruptedException();
                    throw object;
                } while ((object = this.waiters) != (object2 = AbstractResolvableFuture$Waiter.TOMBSTONE));
            }
            object = this.value;
            return this.getDoneValue(object);
        }
        InterruptedException interruptedException = new InterruptedException();
        throw interruptedException;
    }

    public final Object get(long l10, TimeUnit timeUnit) {
        AbstractResolvableFuture abstractResolvableFuture = this;
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
                int n13 = object6 instanceof AbstractResolvableFuture$SetFuture ^ n12;
                if ((n11 &= n13) != 0) {
                    return abstractResolvableFuture.getDoneValue(object6);
                }
                l15 = 0L;
                long l16 = l12 - l15;
                object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                l14 = object2 > 0 ? System.nanoTime() + l12 : l15;
                l13 = 1000L;
                long l17 = l12 - l13;
                object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object2 >= 0) {
                    object6 = abstractResolvableFuture.waiters;
                    object5 = AbstractResolvableFuture$Waiter.TOMBSTONE;
                    if (object6 != object5) {
                        object5 = new AbstractResolvableFuture$Waiter();
                        do {
                            block15: {
                                long l18;
                                ((AbstractResolvableFuture$Waiter)object5).setNext((AbstractResolvableFuture$Waiter)object6);
                                object4 = ATOMIC_HELPER;
                                object2 = ((AbstractResolvableFuture$AtomicHelper)object4).casWaiters(abstractResolvableFuture, (AbstractResolvableFuture$Waiter)object6, (AbstractResolvableFuture$Waiter)object5);
                                if (object2 == 0) continue;
                                do {
                                    LockSupport.parkNanos(abstractResolvableFuture, l12);
                                    bl3 = Thread.interrupted();
                                    if (bl3) break block15;
                                    object3 = abstractResolvableFuture.value;
                                    n10 = object3 != null ? n12 : 0;
                                    object2 = object3 instanceof AbstractResolvableFuture$SetFuture ^ n12;
                                    if ((n10 &= object2) != 0) {
                                        return abstractResolvableFuture.getDoneValue(object3);
                                    }
                                    l12 = System.nanoTime();
                                } while ((object2 = (Object)((l18 = (l12 = l14 - l12) - l13) == 0L ? 0 : (l18 < 0L ? -1 : 1))) >= 0);
                                abstractResolvableFuture.removeWaiter((AbstractResolvableFuture$Waiter)object5);
                                break block16;
                            }
                            abstractResolvableFuture.removeWaiter((AbstractResolvableFuture$Waiter)object5);
                            InterruptedException interruptedException = new InterruptedException();
                            throw interruptedException;
                        } while ((object6 = abstractResolvableFuture.waiters) != (object4 = AbstractResolvableFuture$Waiter.TOMBSTONE));
                    }
                    Object object7 = abstractResolvableFuture.value;
                    return abstractResolvableFuture.getDoneValue(object7);
                }
            }
            while ((object2 = (Object)(l12 == l15 ? 0 : (l12 < l15 ? -1 : 1))) > 0) {
                object3 = abstractResolvableFuture.value;
                n10 = object3 != null ? n12 : 0;
                object2 = object3 instanceof AbstractResolvableFuture$SetFuture ^ n12;
                if ((n10 &= object2) != 0) {
                    return abstractResolvableFuture.getDoneValue(object3);
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

    public final boolean isCancelled() {
        return this.value instanceof AbstractResolvableFuture$Cancellation;
    }

    public final boolean isDone() {
        Object object = this.value;
        boolean bl2 = true;
        boolean bl3 = object != null ? bl2 : false;
        return (object instanceof AbstractResolvableFuture$SetFuture ^ bl2) & bl3;
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
        Object object = this.value;
        boolean bl2 = object instanceof AbstractResolvableFuture$SetFuture;
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setFuture=[");
            object = ((AbstractResolvableFuture$SetFuture)object).future;
            object = this.userObjectToString(object);
            stringBuilder.append((String)object);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
        boolean bl3 = this instanceof ScheduledFuture;
        if (bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("remaining delay=[");
            Future future = this;
            future = (ScheduledFuture)((Object)this);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long l10 = future.getDelay(timeUnit);
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(" ms]");
            return ((StringBuilder)object).toString();
        }
        return null;
    }

    public boolean set(Object object) {
        AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper;
        boolean bl2;
        if (object == null) {
            object = NULL;
        }
        if (bl2 = (abstractResolvableFuture$AtomicHelper = ATOMIC_HELPER).casValue(this, null, object)) {
            AbstractResolvableFuture.complete(this);
            return true;
        }
        return false;
    }

    public boolean setException(Throwable object) {
        object = (Throwable)AbstractResolvableFuture.checkNotNull(object);
        object = ATOMIC_HELPER;
        AbstractResolvableFuture$Failure abstractResolvableFuture$Failure = new AbstractResolvableFuture$Failure((Throwable)object);
        boolean bl2 = ((AbstractResolvableFuture$AtomicHelper)object).casValue(this, null, abstractResolvableFuture$Failure);
        if (bl2) {
            AbstractResolvableFuture.complete(this);
            return true;
        }
        return false;
    }

    public boolean setFuture(ListenableFuture object) {
        boolean bl2;
        boolean bl3;
        AbstractResolvableFuture.checkNotNull(object);
        Object object2 = this.value;
        Object object3 = null;
        if (object2 == null) {
            bl3 = object.isDone();
            bl2 = true;
            boolean bl4 = false;
            if (bl3) {
                object2 = ATOMIC_HELPER;
                boolean bl5 = ((AbstractResolvableFuture$AtomicHelper)object2).casValue(this, null, object = AbstractResolvableFuture.getFutureValue((ListenableFuture)object));
                if (bl5) {
                    AbstractResolvableFuture.complete(this);
                    return bl2;
                }
                return false;
            }
            AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper = ATOMIC_HELPER;
            object2 = new AbstractResolvableFuture$SetFuture(this, (ListenableFuture)object);
            bl4 = abstractResolvableFuture$AtomicHelper.casValue(this, null, object2);
            if (bl4) {
                object3 = DirectExecutor.INSTANCE;
                try {
                    object.addListener((Runnable)object2, (Executor)object3);
                }
                catch (Throwable throwable) {
                    try {
                        object3 = new AbstractResolvableFuture$Failure(throwable);
                    }
                    catch (Throwable throwable2) {
                        object3 = AbstractResolvableFuture$Failure.FALLBACK_INSTANCE;
                    }
                    AbstractResolvableFuture$AtomicHelper abstractResolvableFuture$AtomicHelper2 = ATOMIC_HELPER;
                    abstractResolvableFuture$AtomicHelper2.casValue(this, object2, object3);
                }
                return bl2;
            }
            object2 = this.value;
        }
        if (bl2 = object2 instanceof AbstractResolvableFuture$Cancellation) {
            object2 = (AbstractResolvableFuture$Cancellation)object2;
            bl3 = ((AbstractResolvableFuture$Cancellation)object2).wasInterrupted;
            object.cancel(bl3);
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.toString();
        stringBuilder.append((String)object);
        object = "[status=";
        stringBuilder.append((String)object);
        boolean bl2 = this.isCancelled();
        String string2 = "]";
        if (bl2) {
            object = "CANCELLED";
            stringBuilder.append((String)object);
        } else {
            bl2 = this.isDone();
            if (bl2) {
                this.addDoneString(stringBuilder);
            } else {
                boolean bl3;
                CharSequence charSequence;
                try {
                    object = this.pendingToString();
                }
                catch (RuntimeException runtimeException) {
                    charSequence = new StringBuilder();
                    String string3 = "Exception thrown from implementation: ";
                    ((StringBuilder)charSequence).append(string3);
                    object = runtimeException.getClass();
                    ((StringBuilder)charSequence).append(object);
                    object = ((StringBuilder)charSequence).toString();
                }
                if (object != null && !(bl3 = ((String)object).isEmpty())) {
                    charSequence = "PENDING, info=[";
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append((String)object);
                    stringBuilder.append(string2);
                } else {
                    bl2 = this.isDone();
                    if (bl2) {
                        this.addDoneString(stringBuilder);
                    } else {
                        object = "PENDING";
                        stringBuilder.append((String)object);
                    }
                }
            }
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean wasInterrupted() {
        Object object = this.value;
        boolean bl2 = object instanceof AbstractResolvableFuture$Cancellation;
        if (!bl2) return false;
        object = (AbstractResolvableFuture$Cancellation)object;
        boolean bl3 = ((AbstractResolvableFuture$Cancellation)object).wasInterrupted;
        if (!bl3) return false;
        return true;
    }
}

