/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import java.util.List;
import java.util.concurrent.Executor;

public class PositionalDataSource$LoadRangeCallbackImpl
extends PositionalDataSource$LoadRangeCallback {
    private DataSource$LoadCallbackHelper mCallbackHelper;
    private final int mPositionOffset;

    public PositionalDataSource$LoadRangeCallbackImpl(PositionalDataSource positionalDataSource, int n10, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper(positionalDataSource, n10, executor, pageResult$Receiver);
        this.mPositionOffset = n11;
    }

    public void onResult(List list) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
        boolean bl2 = dataSource$LoadCallbackHelper.dispatchInvalidResultIfInvalid();
        if (!bl2) {
            dataSource$LoadCallbackHelper = this.mCallbackHelper;
            int n10 = this.mPositionOffset;
            PageResult pageResult = new PageResult(list, 0, 0, n10);
            dataSource$LoadCallbackHelper.dispatchResultToReceiver(pageResult);
        }
    }
}

