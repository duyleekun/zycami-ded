/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.InterruptibleTask$DoNothingRunnable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;

public abstract class InterruptibleTask
extends AtomicReference
implements Runnable {
    private static final Runnable DONE;
    private static final Runnable INTERRUPTING;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED;

    static {
        InterruptibleTask$DoNothingRunnable interruptibleTask$DoNothingRunnable = new InterruptibleTask$DoNothingRunnable(null);
        DONE = interruptibleTask$DoNothingRunnable;
        interruptibleTask$DoNothingRunnable = new InterruptibleTask$DoNothingRunnable(null);
        INTERRUPTING = interruptibleTask$DoNothingRunnable;
        interruptibleTask$DoNothingRunnable = new InterruptibleTask$DoNothingRunnable(null);
        PARKED = interruptibleTask$DoNothingRunnable;
    }

    public abstract void afterRanInterruptibly(Object var1, Throwable var2);

    public final void interruptTask() {
        Runnable runnable;
        Runnable runnable2 = (Runnable)this.get();
        boolean bl2 = runnable2 instanceof Thread;
        if (bl2 && (bl2 = this.compareAndSet(runnable2, runnable = INTERRUPTING))) {
            runnable = runnable2;
            try {
                runnable = (Thread)runnable2;
                ((Thread)runnable).interrupt();
            }
            finally {
                Runnable runnable3 = DONE;
                runnable3 = this.getAndSet(runnable3);
                Runnable runnable4 = PARKED;
                if (runnable3 == runnable4) {
                    runnable2 = (Thread)runnable2;
                    LockSupport.unpark((Thread)runnable2);
                }
            }
        }
    }

    public abstract boolean isDone();

    public final void run() {
        block19: {
            Object object;
            int n10;
            int n11;
            boolean bl2;
            Thread thread;
            block18: {
                thread = Thread.currentThread();
                bl2 = this.compareAndSet(null, thread);
                if (!bl2) {
                    return;
                }
                bl2 = this.isDone();
                n11 = 1;
                n10 = 1000;
                if (bl2 ^= n11) {
                    try {
                        object = this.runInterruptibly();
                        break block18;
                    }
                    catch (Throwable throwable) {
                        Runnable runnable = DONE;
                        boolean bl3 = this.compareAndSet(thread, runnable);
                        if (!bl3) {
                            runnable = (Runnable)this.get();
                            int n12 = 0;
                            int n13 = 0;
                            while (true) {
                                Runnable runnable2;
                                Runnable runnable3;
                                if (runnable != (runnable3 = INTERRUPTING) && runnable != (runnable2 = PARKED)) {
                                    if (n12 == 0) break;
                                    thread.interrupt();
                                    break;
                                }
                                if ((n13 += n11) > n10) {
                                    runnable2 = PARKED;
                                    if (runnable == runnable2 || (bl3 = this.compareAndSet(runnable3, runnable2))) {
                                        bl3 = Thread.interrupted();
                                        n12 = !bl3 && n12 == 0 ? 0 : n11;
                                        LockSupport.park(this);
                                    }
                                } else {
                                    Thread.yield();
                                }
                                runnable = (Runnable)this.get();
                            }
                        }
                        if (bl2) {
                            this.afterRanInterruptibly(null, throwable);
                        }
                        break block19;
                    }
                }
                object = null;
            }
            Runnable runnable = DONE;
            boolean bl4 = this.compareAndSet(thread, runnable);
            if (!bl4) {
                runnable = (Runnable)this.get();
                int n14 = 0;
                int n15 = 0;
                while (true) {
                    Runnable runnable4;
                    Runnable runnable5;
                    if (runnable != (runnable5 = INTERRUPTING) && runnable != (runnable4 = PARKED)) {
                        if (n14 == 0) break;
                        thread.interrupt();
                        break;
                    }
                    if ((n15 += n11) > n10) {
                        runnable4 = PARKED;
                        if (runnable == runnable4 || (bl4 = this.compareAndSet(runnable5, runnable4))) {
                            bl4 = Thread.interrupted();
                            n14 = !bl4 && n14 == 0 ? 0 : n11;
                            LockSupport.park(this);
                        }
                    } else {
                        Thread.yield();
                    }
                    runnable = (Runnable)this.get();
                }
            }
            if (bl2) {
                this.afterRanInterruptibly(object, null);
            }
        }
    }

    public abstract Object runInterruptibly();

    public abstract String toPendingString();

    public final String toString() {
        Object object;
        Object object2 = (Runnable)this.get();
        if (object2 == (object = DONE)) {
            object2 = "running=[DONE]";
        } else {
            object = INTERRUPTING;
            if (object2 == object) {
                object2 = "running=[INTERRUPTED]";
            } else {
                boolean bl2 = object2 instanceof Thread;
                if (bl2) {
                    object = new StringBuilder();
                    String string2 = "running=[RUNNING ON ";
                    ((StringBuilder)object).append(string2);
                    object2 = ((Thread)object2).getName();
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append("]");
                    object2 = ((StringBuilder)object).toString();
                } else {
                    object2 = "running=[NOT STARTED YET]";
                }
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", ");
        object2 = this.toPendingString();
        ((StringBuilder)object).append((String)object2);
        return ((StringBuilder)object).toString();
    }
}

