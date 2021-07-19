/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.AsyncListDiffer$1;
import androidx.recyclerview.widget.DiffUtil$DiffResult;
import java.util.List;

public class AsyncListDiffer$1$2
implements Runnable {
    public final /* synthetic */ AsyncListDiffer$1 this$1;
    public final /* synthetic */ DiffUtil$DiffResult val$result;

    public AsyncListDiffer$1$2(AsyncListDiffer$1 var1_1, DiffUtil$DiffResult diffUtil$DiffResult) {
        this.this$1 = var1_1;
        this.val$result = diffUtil$DiffResult;
    }

    public void run() {
        Runnable runnable = this.this$1;
        AsyncListDiffer asyncListDiffer = runnable.this$0;
        int n10 = asyncListDiffer.mMaxScheduledGeneration;
        int n11 = runnable.val$runGeneration;
        if (n10 == n11) {
            List list = runnable.val$newList;
            DiffUtil$DiffResult diffUtil$DiffResult = this.val$result;
            runnable = runnable.val$commitCallback;
            asyncListDiffer.latchList(list, diffUtil$DiffResult, runnable);
        }
    }
}

