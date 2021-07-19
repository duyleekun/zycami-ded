/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.ItemKeyedDataSource$LoadCallback;
import androidx.paging.WrapperItemKeyedDataSource;
import java.util.List;

public class WrapperItemKeyedDataSource$2
extends ItemKeyedDataSource$LoadCallback {
    public final /* synthetic */ WrapperItemKeyedDataSource this$0;
    public final /* synthetic */ ItemKeyedDataSource$LoadCallback val$callback;

    public WrapperItemKeyedDataSource$2(WrapperItemKeyedDataSource wrapperItemKeyedDataSource, ItemKeyedDataSource$LoadCallback itemKeyedDataSource$LoadCallback) {
        this.this$0 = wrapperItemKeyedDataSource;
        this.val$callback = itemKeyedDataSource$LoadCallback;
    }

    public void onResult(List list) {
        ItemKeyedDataSource$LoadCallback itemKeyedDataSource$LoadCallback = this.val$callback;
        list = this.this$0.convertWithStashedKeys(list);
        itemKeyedDataSource$LoadCallback.onResult(list);
    }
}

