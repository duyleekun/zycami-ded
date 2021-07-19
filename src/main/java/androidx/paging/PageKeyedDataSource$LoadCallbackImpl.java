/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PageKeyedDataSource$LoadCallback;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import java.util.List;
import java.util.concurrent.Executor;

public class PageKeyedDataSource$LoadCallbackImpl
extends PageKeyedDataSource$LoadCallback {
    public final DataSource$LoadCallbackHelper mCallbackHelper;
    private final PageKeyedDataSource mDataSource;

    public PageKeyedDataSource$LoadCallbackImpl(PageKeyedDataSource pageKeyedDataSource, int n10, Executor executor, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper(pageKeyedDataSource, n10, executor, pageResult$Receiver);
        this.mDataSource = pageKeyedDataSource;
    }

    public void onResult(List list, Object object) {
        Object object2 = this.mCallbackHelper;
        boolean n10 = ((DataSource$LoadCallbackHelper)object2).dispatchInvalidResultIfInvalid();
        if (!n10) {
            object2 = this.mCallbackHelper;
            int n11 = ((DataSource$LoadCallbackHelper)object2).mResultType;
            int n12 = 1;
            if (n11 == n12) {
                object2 = this.mDataSource;
                ((PageKeyedDataSource)object2).setNextKey(object);
            } else {
                object2 = this.mDataSource;
                ((PageKeyedDataSource)object2).setPreviousKey(object);
            }
            object = this.mCallbackHelper;
            n12 = 0;
            object2 = new PageResult(list, 0, 0, 0);
            ((DataSource$LoadCallbackHelper)object).dispatchResultToReceiver((PageResult)object2);
        }
    }
}

