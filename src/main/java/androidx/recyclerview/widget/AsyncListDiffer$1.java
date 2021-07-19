/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.AsyncListDiffer$1$1;
import androidx.recyclerview.widget.AsyncListDiffer$1$2;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.DiffUtil$Callback;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import java.util.List;
import java.util.concurrent.Executor;

public class AsyncListDiffer$1
implements Runnable {
    public final /* synthetic */ AsyncListDiffer this$0;
    public final /* synthetic */ Runnable val$commitCallback;
    public final /* synthetic */ List val$newList;
    public final /* synthetic */ List val$oldList;
    public final /* synthetic */ int val$runGeneration;

    public AsyncListDiffer$1(AsyncListDiffer asyncListDiffer, List list, List list2, int n10, Runnable runnable) {
        this.this$0 = asyncListDiffer;
        this.val$oldList = list;
        this.val$newList = list2;
        this.val$runGeneration = n10;
        this.val$commitCallback = runnable;
    }

    public void run() {
        Object object = new AsyncListDiffer$1$1(this);
        object = DiffUtil.calculateDiff((DiffUtil$Callback)object);
        Executor executor = this.this$0.mMainThreadExecutor;
        AsyncListDiffer$1$2 asyncListDiffer$1$2 = new AsyncListDiffer$1$2(this, (DiffUtil$DiffResult)object);
        executor.execute(asyncListDiffer$1$2);
    }
}

