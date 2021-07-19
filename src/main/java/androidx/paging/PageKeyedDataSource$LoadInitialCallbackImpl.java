/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PageKeyedDataSource$LoadInitialCallback;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import java.util.List;

public class PageKeyedDataSource$LoadInitialCallbackImpl
extends PageKeyedDataSource$LoadInitialCallback {
    public final DataSource$LoadCallbackHelper mCallbackHelper;
    private final boolean mCountingEnabled;
    private final PageKeyedDataSource mDataSource;

    public PageKeyedDataSource$LoadInitialCallbackImpl(PageKeyedDataSource pageKeyedDataSource, boolean bl2, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper(pageKeyedDataSource, 0, null, pageResult$Receiver);
        this.mDataSource = pageKeyedDataSource;
        this.mCountingEnabled = bl2;
    }

    public void onResult(List list, int n10, int n11, Object object, Object object2) {
        Object object3 = this.mCallbackHelper;
        boolean bl2 = ((DataSource$LoadCallbackHelper)object3).dispatchInvalidResultIfInvalid();
        if (!bl2) {
            DataSource$LoadCallbackHelper.validateInitialLoadParams(list, n10, n11);
            object3 = this.mDataSource;
            ((PageKeyedDataSource)object3).initKeys(object, object2);
            n11 -= n10;
            int n12 = list.size();
            n11 -= n12;
            n12 = (int)(this.mCountingEnabled ? 1 : 0);
            if (n12 != 0) {
                object = this.mCallbackHelper;
                bl2 = false;
                object3 = null;
                object2 = new PageResult(list, n10, n11, 0);
                ((DataSource$LoadCallbackHelper)object).dispatchResultToReceiver((PageResult)object2);
            } else {
                DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
                object = new PageResult(list, n10);
                dataSource$LoadCallbackHelper.dispatchResultToReceiver((PageResult)object);
            }
        }
    }

    public void onResult(List list, Object object, Object object2) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
        boolean bl2 = dataSource$LoadCallbackHelper.dispatchInvalidResultIfInvalid();
        if (!bl2) {
            this.mDataSource.initKeys(object, object2);
            object = this.mCallbackHelper;
            bl2 = false;
            dataSource$LoadCallbackHelper = null;
            object2 = new PageResult(list, 0, 0, 0);
            ((DataSource$LoadCallbackHelper)object).dispatchResultToReceiver((PageResult)object2);
        }
    }
}

