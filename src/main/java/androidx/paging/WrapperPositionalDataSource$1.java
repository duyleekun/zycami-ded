/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.WrapperPositionalDataSource;
import java.util.List;

public class WrapperPositionalDataSource$1
extends PositionalDataSource$LoadInitialCallback {
    public final /* synthetic */ WrapperPositionalDataSource this$0;
    public final /* synthetic */ PositionalDataSource$LoadInitialCallback val$callback;

    public WrapperPositionalDataSource$1(WrapperPositionalDataSource wrapperPositionalDataSource, PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback) {
        this.this$0 = wrapperPositionalDataSource;
        this.val$callback = positionalDataSource$LoadInitialCallback;
    }

    public void onResult(List list, int n10) {
        PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback = this.val$callback;
        list = DataSource.convert(this.this$0.mListFunction, list);
        positionalDataSource$LoadInitialCallback.onResult(list, n10);
    }

    public void onResult(List list, int n10, int n11) {
        PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback = this.val$callback;
        list = DataSource.convert(this.this$0.mListFunction, list);
        positionalDataSource$LoadInitialCallback.onResult(list, n10, n11);
    }
}

