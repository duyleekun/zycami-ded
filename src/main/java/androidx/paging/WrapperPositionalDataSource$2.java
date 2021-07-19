/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.WrapperPositionalDataSource;
import java.util.List;

public class WrapperPositionalDataSource$2
extends PositionalDataSource$LoadRangeCallback {
    public final /* synthetic */ WrapperPositionalDataSource this$0;
    public final /* synthetic */ PositionalDataSource$LoadRangeCallback val$callback;

    public WrapperPositionalDataSource$2(WrapperPositionalDataSource wrapperPositionalDataSource, PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback) {
        this.this$0 = wrapperPositionalDataSource;
        this.val$callback = positionalDataSource$LoadRangeCallback;
    }

    public void onResult(List list) {
        PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback = this.val$callback;
        list = DataSource.convert(this.this$0.mListFunction, list);
        positionalDataSource$LoadRangeCallback.onResult(list);
    }
}

