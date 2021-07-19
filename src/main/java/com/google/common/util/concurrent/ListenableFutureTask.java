/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public class ListenableFutureTask
extends FutureTask
implements ListenableFuture {
    private final ExecutionList executionList;

    public ListenableFutureTask(Runnable object, Object object2) {
        super((Runnable)object, object2);
        this.executionList = object = new ExecutionList();
    }

    public ListenableFutureTask(Callable object) {
        super(object);
        this.executionList = object = new ExecutionList();
    }

    public static ListenableFutureTask create(Runnable runnable, Object object) {
        ListenableFutureTask listenableFutureTask = new ListenableFutureTask(runnable, object);
        return listenableFutureTask;
    }

    public static ListenableFutureTask create(Callable callable) {
        ListenableFutureTask listenableFutureTask = new ListenableFutureTask(callable);
        return listenableFutureTask;
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.add(runnable, executor);
    }

    public void done() {
        this.executionList.execute();
    }
}

