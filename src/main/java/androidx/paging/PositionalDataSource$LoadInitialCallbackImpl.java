/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.DataSource$LoadCallbackHelper;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import java.util.List;

public class PositionalDataSource$LoadInitialCallbackImpl
extends PositionalDataSource$LoadInitialCallback {
    public final DataSource$LoadCallbackHelper mCallbackHelper;
    private final boolean mCountingEnabled;
    private final int mPageSize;

    public PositionalDataSource$LoadInitialCallbackImpl(PositionalDataSource object, boolean bl2, int n10, PageResult$Receiver pageResult$Receiver) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper;
        this.mCallbackHelper = dataSource$LoadCallbackHelper = new DataSource$LoadCallbackHelper((DataSource)object, 0, null, pageResult$Receiver);
        this.mCountingEnabled = bl2;
        this.mPageSize = n10;
        int n11 = 1;
        if (n10 >= n11) {
            return;
        }
        object = new IllegalArgumentException("Page size must be non-negative");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onResult(List object, int n10) {
        DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
        boolean bl2 = dataSource$LoadCallbackHelper.dispatchInvalidResultIfInvalid();
        if (bl2) return;
        if (n10 < 0) {
            object = new IllegalArgumentException("Position must be non-negative");
            throw object;
        }
        bl2 = object.isEmpty();
        if (bl2 && n10 != 0) {
            object = new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
            throw object;
        }
        bl2 = this.mCountingEnabled;
        if (!bl2) {
            dataSource$LoadCallbackHelper = this.mCallbackHelper;
            PageResult pageResult = new PageResult((List)object, n10);
            dataSource$LoadCallbackHelper.dispatchResultToReceiver(pageResult);
            return;
        }
        object = new IllegalStateException("Placeholders requested, but totalCount not provided. Please call the three-parameter onResult method, or disable placeholders in the PagedList.Config");
        throw object;
    }

    public void onResult(List object, int n10, int n11) {
        Object object2 = this.mCallbackHelper;
        boolean n12 = ((DataSource$LoadCallbackHelper)object2).dispatchInvalidResultIfInvalid();
        if (!n12) {
            int n13;
            int n14;
            int n15;
            DataSource$LoadCallbackHelper.validateInitialLoadParams((List)object, n10, n11);
            int n16 = object.size() + n10;
            if (n16 != n11 && (n15 = (n14 = object.size()) % (n13 = this.mPageSize)) != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("PositionalDataSource requires initial load size to be a multiple of page size to support internal tiling. loadSize ");
                int n17 = object.size();
                stringBuilder.append(n17);
                stringBuilder.append(", position ");
                stringBuilder.append(n10);
                stringBuilder.append(", totalCount ");
                stringBuilder.append(n11);
                stringBuilder.append(", pageSize ");
                n17 = this.mPageSize;
                stringBuilder.append(n17);
                object = stringBuilder.toString();
                object2 = new IllegalArgumentException((String)object);
                throw object2;
            }
            boolean bl2 = this.mCountingEnabled;
            if (bl2) {
                n11 -= n10;
                int n18 = object.size();
                object2 = this.mCallbackHelper;
                PageResult pageResult = new PageResult((List)object, n10, n11 -= n18, 0);
                ((DataSource$LoadCallbackHelper)object2).dispatchResultToReceiver(pageResult);
            } else {
                DataSource$LoadCallbackHelper dataSource$LoadCallbackHelper = this.mCallbackHelper;
                object2 = new PageResult((List)object, n10);
                dataSource$LoadCallbackHelper.dispatchResultToReceiver((PageResult)object2);
            }
        }
    }
}

