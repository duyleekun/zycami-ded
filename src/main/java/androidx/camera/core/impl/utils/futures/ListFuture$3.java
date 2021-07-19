/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;
import com.google.common.util.concurrent.ListenableFuture;

public class ListFuture$3
implements Runnable {
    public final /* synthetic */ ListFuture this$0;
    public final /* synthetic */ int val$index;
    public final /* synthetic */ ListenableFuture val$listenable;

    public ListFuture$3(ListFuture listFuture, int n10, ListenableFuture listenableFuture) {
        this.this$0 = listFuture;
        this.val$index = n10;
        this.val$listenable = listenableFuture;
    }

    public void run() {
        ListFuture listFuture = this.this$0;
        int n10 = this.val$index;
        ListenableFuture listenableFuture = this.val$listenable;
        listFuture.setOneValue(n10, listenableFuture);
    }
}

