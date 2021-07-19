/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.IoExecutor;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class IoExecutor$1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "CameraX-camerax_io_%d";
    private final AtomicInteger mThreadId;
    public final /* synthetic */ IoExecutor this$0;

    public IoExecutor$1(IoExecutor object) {
        this.this$0 = object;
        this.mThreadId = object = new AtomicInteger(0);
    }

    public Thread newThread(Runnable object) {
        Thread thread = new Thread((Runnable)object);
        object = Locale.US;
        Object[] objectArray = new Object[1];
        Integer n10 = this.mThreadId.getAndIncrement();
        objectArray[0] = n10;
        object = String.format((Locale)object, THREAD_NAME_STEM, objectArray);
        thread.setName((String)object);
        return thread;
    }
}

