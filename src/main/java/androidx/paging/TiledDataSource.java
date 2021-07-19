/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.PositionalDataSource$LoadInitialParams;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.PositionalDataSource$LoadRangeParams;
import java.util.Collections;
import java.util.List;

public abstract class TiledDataSource
extends PositionalDataSource {
    public abstract int countItems();

    public boolean isContiguous() {
        return false;
    }

    public void loadInitial(PositionalDataSource$LoadInitialParams object, PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback) {
        int n10;
        int n11;
        int n12 = this.countItems();
        if (n12 == 0) {
            object = Collections.emptyList();
            positionalDataSource$LoadInitialCallback.onResult((List)object, 0, 0);
            return;
        }
        int n13 = PositionalDataSource.computeInitialLoadPosition((PositionalDataSource$LoadInitialParams)object, n12);
        List list = this.loadRange(n13, n11 = PositionalDataSource.computeInitialLoadSize((PositionalDataSource$LoadInitialParams)object, n13, n12));
        if (list != null && (n10 = list.size()) == n11) {
            positionalDataSource$LoadInitialCallback.onResult(list, n13, n12);
        } else {
            this.invalidate();
        }
    }

    public abstract List loadRange(int var1, int var2);

    public void loadRange(PositionalDataSource$LoadRangeParams object, PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback) {
        int n10 = ((PositionalDataSource$LoadRangeParams)object).startPosition;
        int n11 = ((PositionalDataSource$LoadRangeParams)object).loadSize;
        object = this.loadRange(n10, n11);
        if (object != null) {
            positionalDataSource$LoadRangeCallback.onResult((List)object);
        } else {
            this.invalidate();
        }
    }
}

