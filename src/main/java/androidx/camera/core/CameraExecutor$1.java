/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class CameraExecutor$1
implements ThreadFactory {
    private static final String THREAD_NAME_STEM = "CameraX-core_camera_%d";
    private final AtomicInteger mThreadId;

    public CameraExecutor$1() {
        AtomicInteger atomicInteger;
        this.mThreadId = atomicInteger = new AtomicInteger(0);
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

