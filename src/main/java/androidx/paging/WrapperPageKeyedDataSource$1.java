/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource$LoadInitialCallback;
import androidx.paging.WrapperPageKeyedDataSource;
import java.util.List;

public class WrapperPageKeyedDataSource$1
extends PageKeyedDataSource$LoadInitialCallback {
    public final /* synthetic */ WrapperPageKeyedDataSource this$0;
    public final /* synthetic */ PageKeyedDataSource$LoadInitialCallback val$callback;

    public WrapperPageKeyedDataSource$1(WrapperPageKeyedDataSource wrapperPageKeyedDataSource, PageKeyedDataSource$LoadInitialCallback pageKeyedDataSource$LoadInitialCallback) {
        this.this$0 = wrapperPageKeyedDataSource;
        this.val$callback = pageKeyedDataSource$LoadInitialCallback;
    }

    public void onResult(List list, int n10, int n11, Object object, Object object2) {
        PageKeyedDataSource$LoadInitialCallback pageKeyedDataSource$LoadInitialCallback = this.val$callback;
        List list2 = DataSource.convert(this.this$0.mListFunction, list);
        pageKeyedDataSource$LoadInitialCallback.onResult(list2, n10, n11, object, object2);
    }

    public void onResult(List list, Object object, Object object2) {
        PageKeyedDataSource$LoadInitialCallback pageKeyedDataSource$LoadInitialCallback = this.val$callback;
        list = DataSource.convert(this.this$0.mListFunction, list);
        pageKeyedDataSource$LoadInitialCallback.onResult(list, object, object2);
    }
}

