/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource$LoadCallback;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import java.util.List;
import java.util.concurrent.Executor;

public class ItemKeyedDataSource$LoadCallbackImpl
extends ItemKeyedDataSource$LoadCallback {
    public final DataSource$LoadCallbackHelper mCallbackHelper;

    public ItemKeyedDataSource$LoadCallbackImpl(ItemKeyedDataSource itemKeyedDataSource, int n10, Executor executor, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper(itemKeyedDataSource, n10, executor, pageResult$Receiver);
    }

    public void onResult(List list) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
        boolean bl2 = dataSource$LoadCallbackHelper.dispatchInvalidResultIfInvalid();
        if (!bl2) {
            dataSource$LoadCallbackHelper = this.mCallbackHelper;
            PageResult pageResult = new PageResult(list, 0, 0, 0);
            dataSource$LoadCallbackHelper.dispatchResultToReceiver(pageResult);
        }
    }
}

