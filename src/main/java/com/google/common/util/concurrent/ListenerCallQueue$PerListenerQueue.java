/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.ListenerCallQueue$Event;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ListenerCallQueue$PerListenerQueue
implements Runnable {
    public final Executor executor;
    public boolean isThreadScheduled;
    public final Queue labelQueue;
    public final Object listener;
    public final Queue waitQueue;

    public ListenerCallQueue$PerListenerQueue(Object object, Executor executor) {
        ArrayDeque arrayDeque = Queues.newArrayDeque();
        this.waitQueue = arrayDeque;
        arrayDeque = Queues.newArrayDeque();
        this.labelQueue = arrayDeque;
        this.listener = object = Preconditions.checkNotNull(object);
        this.executor = object = (Executor)Preconditions.checkNotNull(executor);
    }

    public void add(ListenerCallQueue$Event object, Object object2) {
        synchronized (this) {
            Queue queue = this.waitQueue;
            queue.add(object);
            object = this.labelQueue;
            object.add(object2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dispatch() {
        Logger logger;
        Level level;
        boolean bl2;
        synchronized (this) {
            boolean bl3 = this.isThreadScheduled;
            bl2 = true;
            level = null;
            if (!bl3) {
                this.isThreadScheduled = bl2;
            } else {
                bl2 = false;
                logger = null;
            }
        }
        if (!bl2) return;
        try {
            Executor executor = this.executor;
            executor.execute(this);
            return;
        }
        catch (RuntimeException runtimeException) {
            synchronized (this) {
                this.isThreadScheduled = false;
            }
            logger = ListenerCallQueue.access$000();
            level = Level.SEVERE;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("Exception while running callbacks for ");
            Object object = this.listener;
            charSequence.append(object);
            charSequence.append(" on ");
            object = this.executor;
            charSequence.append(object);
            charSequence = charSequence.toString();
            logger.log(level, (String)charSequence, runtimeException);
            throw runtimeException;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        Throwable throwable;
        boolean bl2;
        block16: {
            Object object;
            Object object2;
            boolean bl3;
            float f10;
            while (true) {
                Object var1_1 = null;
                bl2 = true;
                f10 = Float.MIN_VALUE;
                bl3 = this.isThreadScheduled;
                Preconditions.checkState(bl3);
                object2 = this.waitQueue;
                object2 = object2.poll();
                object2 = (ListenerCallQueue$Event)object2;
                object = this.labelQueue;
                object = object.poll();
                if (object2 == null) {
                    this.isThreadScheduled = false;
                    // MONITOREXIT : this
                    return;
                }
                // MONITOREXIT : this
                break;
            }
            catch (Throwable throwable2) {
                bl3 = bl2;
                float f11 = f10;
                Throwable throwable3 = throwable2;
                try {
                    throw throwable3;
                }
                catch (Throwable throwable4) {
                    throwable = throwable4;
                    bl2 = bl3;
                    f10 = f11;
                    break block16;
                }
            }
            {
                Object object3;
                try {
                    object3 = this.listener;
                    object2.call(object3);
                }
                catch (RuntimeException runtimeException) {
                    object3 = ListenerCallQueue.access$000();
                    Level level = Level.SEVERE;
                    StringBuilder stringBuilder = new StringBuilder();
                    Object object4 = "Exception while executing callback: ";
                    stringBuilder.append((String)object4);
                    object4 = this.listener;
                    stringBuilder.append(object4);
                    object4 = " ";
                    stringBuilder.append((String)object4);
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    ((Logger)object3).log(level, (String)object, runtimeException);
                }
                continue;
            }
            catch (Throwable throwable5) {
                // empty catch block
            }
        }
        if (!bl2) throw throwable;
        // MONITORENTER : this
        this.isThreadScheduled = false;
        // MONITOREXIT : this
        throw throwable;
    }
}

