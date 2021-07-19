/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ExecutionList {
    private static final Logger log = Logger.getLogger(ExecutionList.class.getName());
    private boolean executed;
    private ExecutionList$RunnableExecutorPair runnables;

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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Object object = "Executor was null.";
        Preconditions.checkNotNull(executor, object);
        synchronized (this) {
            boolean bl2 = this.executed;
            if (!bl2) {
                ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair = this.runnables;
                this.runnables = object = new ExecutionList$RunnableExecutorPair(runnable, executor, executionList$RunnableExecutorPair);
                return;
            }
        }
        ExecutionList.executeListener(runnable, executor);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute() {
        Object object;
        Object object2;
        Object object3;
        synchronized (this) {
            boolean bl2 = this.executed;
            if (bl2) {
                return;
            }
            this.executed = bl2 = true;
            object3 = this.runnables;
            object2 = null;
            this.runnables = null;
        }
        while (object3 != null) {
            object = ((ExecutionList$RunnableExecutorPair)object3).next;
            ((ExecutionList$RunnableExecutorPair)object3).next = object2;
            object2 = object3;
            object3 = object;
        }
        while (object2 != null) {
            object3 = ((ExecutionList$RunnableExecutorPair)object2).runnable;
            object = ((ExecutionList$RunnableExecutorPair)object2).executor;
            ExecutionList.executeListener((Runnable)object3, (Executor)object);
            object2 = ((ExecutionList$RunnableExecutorPair)object2).next;
        }
        return;
    }
}

