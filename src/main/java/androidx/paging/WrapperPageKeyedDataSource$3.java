/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource$LoadCallback;
import androidx.paging.WrapperPageKeyedDataSource;
import java.util.List;

public class WrapperPageKeyedDataSource$3
extends PageKeyedDataSource$LoadCallback {
    public final /* synthetic */ WrapperPageKeyedDataSource this$0;
    public final /* synthetic */ PageKeyedDataSource$LoadCallback val$callback;

    public WrapperPageKeyedDataSource$3(WrapperPageKeyedDataSource wrapperPageKeyedDataSource, PageKeyedDataSource$LoadCallback pageKeyedDataSource$LoadCallback) {
        this.this$0 = wrapperPageKeyedDataSource;
        this.val$callback = pageKeyedDataSource$LoadCallback;
    }

    public void onResult(List list, Object object) {
        PageKeyedDataSource$LoadCallback pageKeyedDataSource$LoadCallback = this.val$callback;
        list = DataSource.convert(this.this$0.mListFunction, list);
        pageKeyedDataSource$LoadCallback.onResult(list, object);
    }
}

