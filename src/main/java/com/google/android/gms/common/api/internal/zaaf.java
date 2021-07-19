/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zaaf {
    private final zai zafq;
    private final TaskCompletionSource zafr;

    public zaaf(zai zai2) {
        TaskCompletionSource taskCompletionSource;
        this.zafr = taskCompletionSource = new TaskCompletionSource();
        this.zafq = zai2;
    }

    public final TaskCompletionSource zaal() {
        return this.zafr;
    }

    public final zai zak() {
        return this.zafq;
    }
}

