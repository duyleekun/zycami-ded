/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class FirebaseInstallations$1
implements ThreadFactory {
    private final AtomicInteger mCount;

    public FirebaseInstallations$1() {
        AtomicInteger atomicInteger;
        this.mCount = atomicInteger = new AtomicInteger(1);
    }

    public Thread newThread(Runnable runnable) {
        Object object = new Object[1];
        Integer n10 = this.mCount.getAndIncrement();
        object[0] = n10;
        object = String.format("firebase-installations-executor-%d", object);
        Thread thread = new Thread(runnable, (String)object);
        return thread;
    }
}

