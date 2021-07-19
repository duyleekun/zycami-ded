/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ItemKeyedDataSource$LoadInitialCallback;
import androidx.paging.WrapperItemKeyedDataSource;
import java.util.List;

public class WrapperItemKeyedDataSource$1
extends ItemKeyedDataSource$LoadInitialCallback {
    public final /* synthetic */ WrapperItemKeyedDataSource this$0;
    public final /* synthetic */ ItemKeyedDataSource$LoadInitialCallback val$callback;

    public WrapperItemKeyedDataSource$1(WrapperItemKeyedDataSource wrapperItemKeyedDataSource, ItemKeyedDataSource$LoadInitialCallback itemKeyedDataSource$LoadInitialCallback) {
        this.this$0 = wrapperItemKeyedDataSource;
        this.val$callback = itemKeyedDataSource$LoadInitialCallback;
    }

    public void onResult(List list) {
        ItemKeyedDataSource$LoadInitialCallback itemKeyedDataSource$LoadInitialCallback = this.val$callback;
        list = this.this$0.convertWithStashedKeys(list);
        itemKeyedDataSource$LoadInitialCallback.onResult(list);
    }

    public void onResult(List list, int n10, int n11) {
        ItemKeyedDataSource$LoadInitialCallback itemKeyedDataSource$LoadInitialCallback = this.val$callback;
        list = this.this$0.convertWithStashedKeys(list);
        itemKeyedDataSource$LoadInitialCallback.onResult(list, n10, n11);
    }
}

