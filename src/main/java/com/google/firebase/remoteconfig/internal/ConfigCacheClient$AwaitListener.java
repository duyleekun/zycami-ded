/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient$1;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ConfigCacheClient$AwaitListener
implements OnSuccessListener,
OnFailureListener,
OnCanceledListener {
    private final CountDownLatch latch;

    private ConfigCacheClient$AwaitListener() {
        CountDownLatch countDownLatch;
        this.latch = countDownLatch = new CountDownLatch(1);
    }

    public /* synthetic */ ConfigCacheClient$AwaitListener(ConfigCacheClient$1 configCacheClient$1) {
        this();
    }

    public void await() {
        this.latch.await();
    }

    public boolean await(long l10, TimeUnit timeUnit) {
        return this.latch.await(l10, timeUnit);
    }

    public void onCanceled() {
        this.latch.countDown();
    }

    public void onFailure(Exception exception) {
        this.latch.countDown();
    }

    public void onSuccess(Object object) {
        this.latch.countDown();
    }
}

