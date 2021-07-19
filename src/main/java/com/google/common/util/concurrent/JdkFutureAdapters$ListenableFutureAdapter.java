/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

public class JdkFutureAdapters$ListenableFutureAdapter
extends ForwardingFuture
implements ListenableFuture {
    private static final Executor defaultAdapterExecutor;
    private static final ThreadFactory threadFactory;
    private final Executor adapterExecutor;
    private final Future delegate;
    private final ExecutionList executionList;
    private final AtomicBoolean hasListeners;

    static {
        Object object = new ThreadFactoryBuilder();
        threadFactory = object = ((ThreadFactoryBuilder)object).setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
        defaultAdapterExecutor = Executors.newCachedThreadPool((ThreadFactory)object);
    }

    public JdkFutureAdapters$ListenableFutureAdapter(Future future) {
        Executor executor = defaultAdapterExecutor;
        this(future, executor);
    }

    public JdkFutureAdapters$ListenableFutureAdapter(Future object, Executor executor) {
        Object object2 = new ExecutionList();
        this.executionList = object2;
        this.hasListeners = object2 = new AtomicBoolean(false);
        object = (Future)Preconditions.checkNotNull(object);
        this.delegate = object;
        this.adapterExecutor = object = (Executor)Preconditions.checkNotNull(executor);
    }

    public static /* synthetic */ Future access$000(JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter) {
        return jdkFutureAdapters$ListenableFutureAdapter.delegate;
    }

    public static /* synthetic */ ExecutionList access$100(JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter) {
        return jdkFutureAdapters$ListenableFutureAdapter.executionList;
    }

    public void addListener(Runnable object, Executor object2) {
        ExecutionList executionList = this.executionList;
        executionList.add((Runnable)object, (Executor)object2);
        object = this.hasListeners;
        object2 = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.delegate;
            bl3 = object.isDone();
            if (bl3) {
                this.executionList.execute();
                return;
            }
            object = this.adapterExecutor;
            object2 = new JdkFutureAdapters$ListenableFutureAdapter$1(this);
            object.execute((Runnable)object2);
        }
    }

    public Future delegate() {
        return this.delegate;
    }
}

