/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api$AnyClient;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.tasks.TaskCompletionSource;

public final class zacj
implements RemoteCall {
    private final BiConsumer zakf;

    public zacj(BiConsumer biConsumer) {
        this.zakf = biConsumer;
    }

    public final void accept(Object object, Object object2) {
        BiConsumer biConsumer = this.zakf;
        object = (Api$AnyClient)object;
        object2 = (TaskCompletionSource)object2;
        biConsumer.accept(object, object2);
    }
}

