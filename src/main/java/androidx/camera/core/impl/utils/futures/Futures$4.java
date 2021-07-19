/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import com.google.common.util.concurrent.ListenableFuture;

public class Futures$4
implements Runnable {
    public final /* synthetic */ ListenableFuture val$input;

    public Futures$4(ListenableFuture listenableFuture) {
        this.val$input = listenableFuture;
    }

    public void run() {
        this.val$input.cancel(true);
    }
}

