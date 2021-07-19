/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource$LoadInitialCallback;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import java.util.List;

public class ItemKeyedDataSource$LoadInitialCallbackImpl
extends ItemKeyedDataSource$LoadInitialCallback {
    public final DataSource$LoadCallbackHelper mCallbackHelper;
    private final boolean mCountingEnabled;

    public ItemKeyedDataSource$LoadInitialCallbackImpl(ItemKeyedDataSource itemKeyedDataSource, boolean bl2, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper(itemKeyedDataSource, 0, null, pageResult$Receiver);
        this.mCountingEnabled = bl2;
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

    public void onResult(List list, int n10, int n11) {
        Object object = this.mCallbackHelper;
        boolean n12 = ((DataSource$LoadCallbackHelper)object).dispatchInvalidResultIfInvalid();
        if (!n12) {
            DataSource$LoadCallbackHelper.validateInitialLoadParams(list, n10, n11);
            n11 -= n10;
            int n13 = list.size();
            n11 -= n13;
            boolean bl2 = this.mCountingEnabled;
            if (bl2) {
                object = this.mCallbackHelper;
                PageResult pageResult = new PageResult(list, n10, n11, 0);
                ((DataSource$LoadCallbackHelper)object).dispatchResultToReceiver(pageResult);
            } else {
                DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
                object = new PageResult(list, n10);
                dataSource$LoadCallbackHelper.dispatchResultToReceiver((PageResult)object);
            }
        }
    }
}

