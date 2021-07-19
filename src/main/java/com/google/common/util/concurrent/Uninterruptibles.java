/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static void awaitUninterruptibly(CountDownLatch object) {
        boolean bl2 = false;
        Thread thread = null;
        while (true) {
            block5: {
                try {
                    ((CountDownLatch)object).await();
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
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
            return;
            break;
        }
    }

    public static boolean awaitUninterruptibly(CountDownLatch countDownLatch, long l10, TimeUnit timeUnit) {
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            boolean bl3;
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    bl3 = countDownLatch.await(l10, timeUnit);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread = Thread.currentThread();
                            thread.interrupt();
                        }
                        throw throwable;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return bl3;
            break;
        }
    }

    public static boolean awaitUninterruptibly(Condition condition, long l10, TimeUnit timeUnit) {
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            boolean bl3;
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    bl3 = condition.await(l10, timeUnit);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread = Thread.currentThread();
                            thread.interrupt();
                        }
                        throw throwable;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return bl3;
            break;
        }
    }

    public static Object getUninterruptibly(Future future) {
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

    public static Object getUninterruptibly(Future future, long l10, TimeUnit timeUnit) {
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    future = future.get(l10, timeUnit);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread = Thread.currentThread();
                            thread.interrupt();
                        }
                        throw throwable;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return future;
            break;
        }
    }

    public static void joinUninterruptibly(Thread thread) {
        boolean bl2 = false;
        Thread thread2 = null;
        while (true) {
            block5: {
                try {
                    thread.join();
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        thread2 = Thread.currentThread();
                        thread2.interrupt();
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
            return;
            break;
        }
    }

    public static void joinUninterruptibly(Thread thread, long l10, TimeUnit timeUnit) {
        Preconditions.checkNotNull(thread);
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    timeUnit.timedJoin(thread, l10);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread2 = Thread.currentThread();
                            thread2.interrupt();
                        }
                        throw throwable;
                    }
                }
                thread = Thread.currentThread();
                thread.interrupt();
            }
            return;
            break;
        }
    }

    public static void putUninterruptibly(BlockingQueue object, Object object2) {
        boolean bl2 = false;
        while (true) {
            block5: {
                try {
                    object.put(object2);
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        object2 = Thread.currentThread();
                        ((Thread)object2).interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    continue;
                }
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
            return;
            break;
        }
    }

    public static void sleepUninterruptibly(long l10, TimeUnit timeUnit) {
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    timeUnit.sleep(l10);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread = Thread.currentThread();
                            thread.interrupt();
                        }
                        throw throwable;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return;
            break;
        }
    }

    public static Object takeUninterruptibly(BlockingQueue blockingQueue) {
        boolean bl2 = false;
        Thread thread = null;
        while (true) {
            block5: {
                try {
                    blockingQueue = blockingQueue.take();
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
            return blockingQueue;
            break;
        }
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, int n10, long l10, TimeUnit timeUnit) {
        boolean bl2 = false;
        l10 = timeUnit.toNanos(l10);
        long l11 = System.nanoTime() + l10;
        while (true) {
            boolean bl3;
            block9: {
                timeUnit = TimeUnit.NANOSECONDS;
                try {
                    bl3 = semaphore.tryAcquire(n10, l10, timeUnit);
                    if (!bl2) break block9;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    try {
                        l10 = System.nanoTime();
                        l10 = l11 - l10;
                        continue;
                    }
                    catch (Throwable throwable) {
                        if (bl2) {
                            Thread thread = Thread.currentThread();
                            thread.interrupt();
                        }
                        throw throwable;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return bl3;
            break;
        }
    }

    public static boolean tryAcquireUninterruptibly(Semaphore semaphore, long l10, TimeUnit timeUnit) {
        return Uninterruptibles.tryAcquireUninterruptibly(semaphore, 1, l10, timeUnit);
    }
}

