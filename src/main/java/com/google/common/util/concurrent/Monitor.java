/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.Monitor$Guard;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public final class Monitor {
    private Monitor$Guard activeGuards = null;
    private final boolean fair;
    private final ReentrantLock lock;

    public Monitor() {
        this(false);
    }

    public Monitor(boolean bl2) {
        ReentrantLock reentrantLock;
        this.fair = bl2;
        this.lock = reentrantLock = new ReentrantLock(bl2);
    }

    public static /* synthetic */ ReentrantLock access$000(Monitor monitor) {
        return monitor.lock;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void await(Monitor$Guard monitor$Guard, boolean bl2) {
        if (bl2) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                Condition condition = monitor$Guard.condition;
                condition.await();
            } while (!(bl2 = monitor$Guard.isSatisfied()));
            this.endWaitingFor(monitor$Guard);
            return;
        }
        catch (Throwable throwable) {
            this.endWaitingFor(monitor$Guard);
            throw throwable;
        }
    }

    /*
     * Exception decompiling
     */
    private boolean awaitNanos(Monitor$Guard var1_1, long var2_2, boolean var4_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [6[DOLOOP]], but top level block is 4[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void awaitUninterruptibly(Monitor$Guard monitor$Guard, boolean bl2) {
        if (bl2) {
            this.signalNextWaiter();
        }
        this.beginWaitingFor(monitor$Guard);
        try {
            do {
                Condition condition = monitor$Guard.condition;
                condition.awaitUninterruptibly();
            } while (!(bl2 = monitor$Guard.isSatisfied()));
            this.endWaitingFor(monitor$Guard);
            return;
        }
        catch (Throwable throwable) {
            this.endWaitingFor(monitor$Guard);
            throw throwable;
        }
    }

    private void beginWaitingFor(Monitor$Guard monitor$Guard) {
        int n10;
        int n11 = monitor$Guard.waiterCount;
        monitor$Guard.waiterCount = n10 = n11 + 1;
        if (n11 == 0) {
            Monitor$Guard monitor$Guard2;
            monitor$Guard.next = monitor$Guard2 = this.activeGuards;
            this.activeGuards = monitor$Guard;
        }
    }

    private void endWaitingFor(Monitor$Guard monitor$Guard) {
        int n10;
        monitor$Guard.waiterCount = n10 = monitor$Guard.waiterCount + -1;
        if (n10 == 0) {
            Monitor$Guard monitor$Guard2 = this.activeGuards;
            Monitor$Guard monitor$Guard3 = null;
            while (true) {
                if (monitor$Guard2 == monitor$Guard) {
                    if (monitor$Guard3 == null) {
                        this.activeGuards = monitor$Guard = monitor$Guard2.next;
                    } else {
                        monitor$Guard3.next = monitor$Guard = monitor$Guard2.next;
                    }
                    monitor$Guard2.next = null;
                    break;
                }
                Monitor$Guard monitor$Guard4 = monitor$Guard2.next;
                monitor$Guard3 = monitor$Guard2;
                monitor$Guard2 = monitor$Guard4;
            }
        }
    }

    private static long initNanoTime(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return l11;
        }
        l10 = System.nanoTime();
        long l13 = l10 - l11;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            l10 = 1L;
        }
        return l10;
    }

    private boolean isSatisfied(Monitor$Guard monitor$Guard) {
        try {
            return monitor$Guard.isSatisfied();
        }
        catch (Throwable throwable) {
            this.signalAllWaiters();
            throw throwable;
        }
    }

    private static long remainingNanos(long l10, long l11) {
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            l12 = System.nanoTime() - l10;
            l12 = l11 - l12;
        }
        return l12;
    }

    private void signalAllWaiters() {
        Monitor$Guard monitor$Guard = this.activeGuards;
        while (monitor$Guard != null) {
            Condition condition = monitor$Guard.condition;
            condition.signalAll();
            monitor$Guard = monitor$Guard.next;
        }
    }

    private void signalNextWaiter() {
        Object object = this.activeGuards;
        while (object != null) {
            boolean bl2 = this.isSatisfied((Monitor$Guard)object);
            if (bl2) {
                object = ((Monitor$Guard)object).condition;
                object.signal();
                break;
            }
            object = ((Monitor$Guard)object).next;
        }
    }

    private static long toSafeNanos(long l10, TimeUnit timeUnit) {
        return Longs.constrainToRange(timeUnit.toNanos(l10), 0L, 0x5FFFFFFFFFFFFFFDL);
    }

    public void enter() {
        this.lock.lock();
    }

    /*
     * WARNING - void declaration
     */
    public boolean enter(long l10, TimeUnit object) {
        void var13_13;
        long l11;
        long l12;
        l10 = Monitor.toSafeNanos(l10, (TimeUnit)((Object)object));
        object = this.lock;
        boolean bl2 = this.fair;
        boolean bl3 = true;
        if (!bl2 && (bl2 = ((ReentrantLock)object).tryLock())) {
            return bl3;
        }
        bl2 = Thread.interrupted();
        try {
            l12 = System.nanoTime();
            l11 = l10;
        }
        catch (Throwable throwable) {
            bl3 = bl2;
        }
        while (true) {
            boolean bl4;
            block10: {
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                try {
                    bl4 = ((ReentrantLock)object).tryLock(l11, timeUnit);
                    if (!bl2) break block10;
                }
                catch (InterruptedException interruptedException) {
                    try {
                        l11 = Monitor.remainingNanos(l12, l10);
                        bl2 = bl3;
                        continue;
                    }
                    catch (Throwable throwable) {
                        break;
                    }
                }
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            return bl4;
        }
        if (bl3) {
            Thread thread = Thread.currentThread();
            thread.interrupt();
        }
        throw var13_13;
    }

    public boolean enterIf(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            ((ReentrantLock)object2).lock();
            try {
                boolean bl2 = ((Monitor$Guard)object).isSatisfied();
                if (!bl2) {
                    ((ReentrantLock)object2).unlock();
                }
                return bl2;
            }
            catch (Throwable throwable) {
                ((ReentrantLock)object2).unlock();
                throw throwable;
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean enterIf(Monitor$Guard object, long l10, TimeUnit timeUnit) {
        Monitor monitor = ((Monitor$Guard)object).monitor;
        if (monitor == this) {
            boolean bl2 = this.enter(l10, timeUnit);
            if (!bl2) {
                return false;
            }
            try {
                boolean bl3 = ((Monitor$Guard)object).isSatisfied();
                if (!bl3) {
                    ReentrantLock reentrantLock = this.lock;
                    reentrantLock.unlock();
                }
                return bl3;
            }
            catch (Throwable throwable) {
                this.lock.unlock();
                throw throwable;
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean enterIfInterruptibly(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            ((ReentrantLock)object2).lockInterruptibly();
            try {
                boolean bl2 = ((Monitor$Guard)object).isSatisfied();
                if (!bl2) {
                    ((ReentrantLock)object2).unlock();
                }
                return bl2;
            }
            catch (Throwable throwable) {
                ((ReentrantLock)object2).unlock();
                throw throwable;
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean enterIfInterruptibly(Monitor$Guard object, long l10, TimeUnit timeUnit) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            boolean bl2 = ((ReentrantLock)object2).tryLock(l10, timeUnit);
            if (!bl2) {
                return false;
            }
            try {
                boolean bl3 = ((Monitor$Guard)object).isSatisfied();
                if (!bl3) {
                    ((ReentrantLock)object2).unlock();
                }
                return bl3;
            }
            catch (Throwable throwable) {
                ((ReentrantLock)object2).unlock();
                throw throwable;
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public void enterInterruptibly() {
        this.lock.lockInterruptibly();
    }

    public boolean enterInterruptibly(long l10, TimeUnit timeUnit) {
        return this.lock.tryLock(l10, timeUnit);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void enterWhen(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            boolean bl2 = ((ReentrantLock)object2).isHeldByCurrentThread();
            ((ReentrantLock)object2).lockInterruptibly();
            try {
                boolean bl3 = ((Monitor$Guard)object).isSatisfied();
                if (bl3) return;
            }
            catch (Throwable throwable) {
                this.leave();
                throw throwable;
            }
            this.await((Monitor$Guard)object, bl2);
            return;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean enterWhen(Monitor$Guard object, long l10, TimeUnit timeUnit) {
        block14: {
            boolean bl2;
            Object object2;
            block12: {
                block10: {
                    boolean bl3;
                    long l11;
                    block11: {
                        Object object3;
                        long l12;
                        long l13;
                        block17: {
                            block15: {
                                block16: {
                                    l11 = Monitor.toSafeNanos(l10, timeUnit);
                                    object2 = ((Monitor$Guard)object).monitor;
                                    if (object2 != this) break block14;
                                    object2 = this.lock;
                                    bl3 = ((ReentrantLock)object2).isHeldByCurrentThread();
                                    boolean bl4 = this.fair;
                                    bl2 = false;
                                    l13 = 0L;
                                    if (bl4) break block15;
                                    bl4 = Thread.interrupted();
                                    if (bl4) break block16;
                                    bl4 = ((ReentrantLock)object2).tryLock();
                                    if (!bl4) break block15;
                                    l12 = l13;
                                    break block17;
                                }
                                object = new InterruptedException();
                                throw object;
                            }
                            l12 = Monitor.initNanoTime(l11);
                            object3 = ((ReentrantLock)object2).tryLock(l10, timeUnit);
                            if (!object3) {
                                return false;
                            }
                        }
                        try {
                            object3 = ((Monitor$Guard)object).isSatisfied();
                            if (object3) break block10;
                            object3 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                            if (!object3) break block11;
                        }
                        catch (Throwable throwable) {
                            if (!bl3) {
                                try {
                                    this.signalNextWaiter();
                                }
                                finally {
                                    ((ReentrantLock)object2).unlock();
                                }
                            }
                            throw throwable;
                        }
                        l11 = Monitor.remainingNanos(l12, l11);
                    }
                    boolean bl5 = this.awaitNanos((Monitor$Guard)object, l11, bl3);
                    if (!bl5) break block12;
                }
                bl2 = true;
            }
            if (!bl2) {
                ((ReentrantLock)object2).unlock();
            }
            return bl2;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void enterWhenUninterruptibly(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            boolean bl2 = ((ReentrantLock)object2).isHeldByCurrentThread();
            ((ReentrantLock)object2).lock();
            try {
                boolean bl3 = ((Monitor$Guard)object).isSatisfied();
                if (bl3) return;
            }
            catch (Throwable throwable) {
                this.leave();
                throw throwable;
            }
            this.awaitUninterruptibly((Monitor$Guard)object, bl2);
            return;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean enterWhenUninterruptibly(Monitor$Guard object, long l10, TimeUnit object2) {
        long l11;
        long l12;
        long l13;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        block19: {
            boolean bl52;
            l10 = Monitor.toSafeNanos(l10, (TimeUnit)((Object)object2));
            object2 = ((Monitor$Guard)object).monitor;
            if (object2 != this) {
                object = new IllegalMonitorStateException();
                throw object;
            }
            object2 = this.lock;
            bl4 = ((ReentrantLock)object2).isHeldByCurrentThread();
            bl3 = Thread.interrupted();
            bl2 = true;
            boolean bl6 = this.fair;
            l13 = 0L;
            if (!bl6 && (bl52 = ((ReentrantLock)object2).tryLock())) {
                l12 = l13;
                break block19;
            }
            l12 = Monitor.initNanoTime(l10);
            l11 = l10;
            while (true) {
                try {
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    boolean bl7 = ((ReentrantLock)object2).tryLock(l11, timeUnit);
                    if (bl7) break;
                    if (!bl3) return false;
                }
                catch (InterruptedException interruptedException) {
                    try {
                        l11 = Monitor.remainingNanos(l12, l10);
                        return (boolean)l11;
                    }
                    finally {
                        bl3 = bl2;
                        continue;
                    }
                }
                object = Thread.currentThread();
                ((Thread)object).interrupt();
                return false;
            }
        }
        while (true) {
            void var1_5;
            block20: {
                boolean bl8 = ((Monitor$Guard)object).isSatisfied();
                if (!bl8) {
                    Object object3 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                    if (object3 == false) {
                        l12 = Monitor.initNanoTime(l10);
                        l11 = l10;
                    } else {
                        l11 = Monitor.remainingNanos(l12, l10);
                    }
                    bl2 = this.awaitNanos((Monitor$Guard)object, l11, bl4);
                }
                if (bl2) break block20;
                ((ReentrantLock)object2).unlock();
            }
            if (!bl3) return bl2;
            object = Thread.currentThread();
            ((Thread)object).interrupt();
            return bl2;
            catch (Throwable throwable) {
                try {
                    ((ReentrantLock)object2).unlock();
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    // empty catch block
                }
            }
            if (!bl3) throw var1_5;
            Thread thread = Thread.currentThread();
            thread.interrupt();
            throw var1_5;
            catch (InterruptedException interruptedException) {}
            bl3 = bl2;
            bl4 = false;
        }
    }

    public int getOccupiedDepth() {
        return this.lock.getHoldCount();
    }

    public int getQueueLength() {
        return this.lock.getQueueLength();
    }

    public int getWaitQueueLength(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            ((ReentrantLock)object2).lock();
            try {
                int n10 = ((Monitor$Guard)object).waiterCount;
                return n10;
            }
            finally {
                this.lock.unlock();
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean hasQueuedThread(Thread thread) {
        return this.lock.hasQueuedThread(thread);
    }

    public boolean hasQueuedThreads() {
        return this.lock.hasQueuedThreads();
    }

    public boolean hasWaiters(Monitor$Guard monitor$Guard) {
        int n10 = this.getWaitQueueLength(monitor$Guard);
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            monitor$Guard = null;
        }
        return n10 != 0;
    }

    public boolean isFair() {
        return this.fair;
    }

    public boolean isOccupied() {
        return this.lock.isLocked();
    }

    public boolean isOccupiedByCurrentThread() {
        return this.lock.isHeldByCurrentThread();
    }

    public void leave() {
        ReentrantLock reentrantLock;
        block4: {
            reentrantLock = this.lock;
            int n10 = reentrantLock.getHoldCount();
            int n11 = 1;
            if (n10 != n11) break block4;
            this.signalNextWaiter();
        }
        return;
        finally {
            reentrantLock.unlock();
        }
    }

    public boolean tryEnter() {
        return this.lock.tryLock();
    }

    public boolean tryEnterIf(Monitor$Guard object) {
        Object object2 = ((Monitor$Guard)object).monitor;
        if (object2 == this) {
            object2 = this.lock;
            boolean bl2 = ((ReentrantLock)object2).tryLock();
            if (!bl2) {
                return false;
            }
            try {
                boolean bl3 = ((Monitor$Guard)object).isSatisfied();
                if (!bl3) {
                    ((ReentrantLock)object2).unlock();
                }
                return bl3;
            }
            catch (Throwable throwable) {
                ((ReentrantLock)object2).unlock();
                throw throwable;
            }
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public void waitFor(Monitor$Guard object) {
        boolean bl2;
        Monitor monitor = ((Monitor$Guard)object).monitor;
        boolean bl3 = true;
        if (monitor == this) {
            bl2 = bl3;
        } else {
            bl2 = false;
            monitor = null;
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl4 = reentrantLock.isHeldByCurrentThread();
        if (bl2 &= bl4) {
            bl2 = ((Monitor$Guard)object).isSatisfied();
            if (!bl2) {
                this.await((Monitor$Guard)object, bl3);
            }
            return;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public boolean waitFor(Monitor$Guard object, long l10, TimeUnit object2) {
        boolean bl2;
        l10 = Monitor.toSafeNanos(l10, object2);
        object2 = ((Monitor$Guard)object).monitor;
        boolean bl3 = true;
        if (object2 == this) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl4 = reentrantLock.isHeldByCurrentThread();
        if (bl2 &= bl4) {
            bl2 = ((Monitor$Guard)object).isSatisfied();
            if (bl2) {
                return bl3;
            }
            bl2 = Thread.interrupted();
            if (!bl2) {
                return this.awaitNanos((Monitor$Guard)object, l10, bl3);
            }
            object = new InterruptedException();
            throw object;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    public void waitForUninterruptibly(Monitor$Guard object) {
        boolean bl2;
        Monitor monitor = ((Monitor$Guard)object).monitor;
        boolean bl3 = true;
        if (monitor == this) {
            bl2 = bl3;
        } else {
            bl2 = false;
            monitor = null;
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl4 = reentrantLock.isHeldByCurrentThread();
        if (bl2 &= bl4) {
            bl2 = ((Monitor$Guard)object).isSatisfied();
            if (!bl2) {
                this.awaitUninterruptibly((Monitor$Guard)object, bl3);
            }
            return;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean waitForUninterruptibly(Monitor$Guard object, long l10, TimeUnit object2) {
        boolean bl2;
        l10 = Monitor.toSafeNanos(l10, object2);
        object2 = ((Monitor$Guard)object).monitor;
        boolean bl3 = true;
        if (object2 == this) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        ReentrantLock reentrantLock = this.lock;
        boolean bl4 = reentrantLock.isHeldByCurrentThread();
        if (bl2 &= bl4) {
            void var1_4;
            bl2 = ((Monitor$Guard)object).isSatisfied();
            if (bl2) {
                return bl3;
            }
            long l11 = Monitor.initNanoTime(l10);
            bl2 = Thread.interrupted();
            long l12 = l10;
            boolean bl5 = bl3;
            while (true) {
                boolean bl6;
                block12: {
                    try {
                        bl6 = this.awaitNanos((Monitor$Guard)object, l12, bl5);
                        if (!bl2) break block12;
                    }
                    catch (Throwable throwable) {
                        bl3 = bl2;
                        break;
                    }
                    catch (InterruptedException interruptedException) {
                        block13: {
                            bl2 = ((Monitor$Guard)object).isSatisfied();
                            if (!bl2) break block13;
                            Thread.currentThread().interrupt();
                            return bl3;
                        }
                        try {
                            l12 = Monitor.remainingNanos(l11, l10);
                            bl5 = false;
                            bl2 = bl3;
                            continue;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    Thread thread = Thread.currentThread();
                    thread.interrupt();
                }
                return bl6;
                break;
            }
            if (bl3) {
                Thread thread = Thread.currentThread();
                thread.interrupt();
            }
            throw var1_4;
        }
        object = new IllegalMonitorStateException();
        throw object;
    }
}

