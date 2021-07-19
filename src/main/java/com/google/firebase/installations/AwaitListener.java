/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.installations;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class AwaitListener
implements OnCompleteListener {
    private final CountDownLatch latch;

    public AwaitListener() {
        CountDownLatch countDownLatch;
        this.latch = countDownLatch = new CountDownLatch(1);
    }

    public boolean await(long l10, TimeUnit timeUnit) {
        return this.latch.await(l10, timeUnit);
    }

    public void onComplete(Task task) {
        this.latch.countDown();
    }

    public void onSuccess() {
        this.latch.countDown();
    }
}

