/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.PositionalDataSource$LoadInitialParams;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.PositionalDataSource$LoadRangeParams;
import java.util.ArrayList;
import java.util.List;

public class ListDataSource
extends PositionalDataSource {
    private final List mList;

    public ListDataSource(List list) {
        ArrayList arrayList;
        this.mList = arrayList = new ArrayList(list);
    }

    public void loadInitial(PositionalDataSource$LoadInitialParams object, PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback) {
        int n10 = this.mList.size();
        int n11 = PositionalDataSource.computeInitialLoadPosition((PositionalDataSource$LoadInitialParams)object, n10);
        int n12 = PositionalDataSource.computeInitialLoadSize((PositionalDataSource$LoadInitialParams)object, n11, n10);
        List list = this.mList;
        object = list.subList(n11, n12 += n11);
        positionalDataSource$LoadInitialCallback.onResult((List)object, n11, n10);
    }

    public void loadRange(PositionalDataSource$LoadRangeParams object, PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback) {
        List list = this.mList;
        int n10 = ((PositionalDataSource$LoadRangeParams)object).startPosition;
        int n11 = ((PositionalDataSource$LoadRangeParams)object).loadSize + n10;
        object = list.subList(n10, n11);
        positionalDataSource$LoadRangeCallback.onResult((List)object);
    }
}

