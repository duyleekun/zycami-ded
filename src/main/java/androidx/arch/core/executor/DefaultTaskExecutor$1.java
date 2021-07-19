/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.DefaultTaskExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskExecutor$1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "arch_disk_io_%d";
    private final AtomicInteger mThreadId;
    public final /* synthetic */ DefaultTaskExecutor this$0;

    public DefaultTaskExecutor$1(DefaultTaskExecutor object) {
        this.this$0 = object;
        this.mThreadId = object = new AtomicInteger(0);
    }

    public Thread newThread(Runnable object) {
        Thread thread = new Thread((Runnable)object);
        object = new Object[1];
        Integer n10 = this.mThreadId.getAndIncrement();
        object[0] = n10;
        object = String.format(THREAD_NAME_STEM, object);
        thread.setName((String)object);
        return thread;
    }
}

