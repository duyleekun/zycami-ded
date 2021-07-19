/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.ListFuture;

public class ListFuture$2
implements Runnable {
    public final /* synthetic */ ListFuture this$0;

    public ListFuture$2(ListFuture listFuture) {
        this.this$0 = listFuture;
    }

    public void run() {
        ListFuture listFuture = this.this$0;
        listFuture.mValues = null;
        listFuture.mFutures = null;
    }
}

