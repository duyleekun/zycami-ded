/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.ItemKeyedDataSource;
import androidx.paging.ItemKeyedDataSource$LoadCallback;
import androidx.paging.ItemKeyedDataSource$LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource$LoadInitialParams;
import androidx.paging.ItemKeyedDataSource$LoadParams;
import androidx.paging.WrapperItemKeyedDataSource$1;
import androidx.paging.WrapperItemKeyedDataSource$2;
import androidx.paging.WrapperItemKeyedDataSource$3;
import java.util.IdentityHashMap;
import java.util.List;

public class WrapperItemKeyedDataSource
extends ItemKeyedDataSource {
    private final IdentityHashMap mKeyMap;
    public final Function mListFunction;
    private final ItemKeyedDataSource mSource;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource itemKeyedDataSource, Function function) {
        IdentityHashMap identityHashMap;
        this.mKeyMap = identityHashMap = new IdentityHashMap();
        this.mSource = itemKeyedDataSource;
        this.mListFunction = function;
    }

    public void addInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.addInvalidatedCallback(dataSource$InvalidatedCallback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List convertWithStashedKeys(List list) {
        List list2 = DataSource.convert(this.mListFunction, list);
        IdentityHashMap identityHashMap = this.mKeyMap;
        synchronized (identityHashMap) {
            int n10 = 0;
            int n11;
            while (n10 < (n11 = list2.size())) {
                IdentityHashMap identityHashMap2 = this.mKeyMap;
                Object e10 = list2.get(n10);
                Object object = this.mSource;
                Object e11 = list.get(n10);
                object = ((ItemKeyedDataSource)object).getKey(e11);
                identityHashMap2.put(e10, object);
                ++n10;
            }
            return list2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object getKey(Object object) {
        IdentityHashMap identityHashMap = this.mKeyMap;
        synchronized (identityHashMap) {
            IdentityHashMap identityHashMap2 = this.mKeyMap;
            return identityHashMap2.get(object);
        }
    }

    public void invalidate() {
        this.mSource.invalidate();
    }

    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    public void loadAfter(ItemKeyedDataSource$LoadParams itemKeyedDataSource$LoadParams, ItemKeyedDataSource$LoadCallback itemKeyedDataSource$LoadCallback) {
        ItemKeyedDataSource itemKeyedDataSource = this.mSource;
        WrapperItemKeyedDataSource$2 wrapperItemKeyedDataSource$2 = new WrapperItemKeyedDataSource$2(this, itemKeyedDataSource$LoadCallback);
        itemKeyedDataSource.loadAfter(itemKeyedDataSource$LoadParams, wrapperItemKeyedDataSource$2);
    }

    public void loadBefore(ItemKeyedDataSource$LoadParams itemKeyedDataSource$LoadParams, ItemKeyedDataSource$LoadCallback itemKeyedDataSource$LoadCallback) {
        ItemKeyedDataSource itemKeyedDataSource = this.mSource;
        WrapperItemKeyedDataSource$3 wrapperItemKeyedDataSource$3 = new WrapperItemKeyedDataSource$3(this, itemKeyedDataSource$LoadCallback);
        itemKeyedDataSource.loadBefore(itemKeyedDataSource$LoadParams, wrapperItemKeyedDataSource$3);
    }

    public void loadInitial(ItemKeyedDataSource$LoadInitialParams itemKeyedDataSource$LoadInitialParams, ItemKeyedDataSource$LoadInitialCallback itemKeyedDataSource$LoadInitialCallback) {
        ItemKeyedDataSource itemKeyedDataSource = this.mSource;
        WrapperItemKeyedDataSource$1 wrapperItemKeyedDataSource$1 = new WrapperItemKeyedDataSource$1(this, itemKeyedDataSource$LoadInitialCallback);
        itemKeyedDataSource.loadInitial(itemKeyedDataSource$LoadInitialParams, wrapperItemKeyedDataSource$1);
    }

    public void removeInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.removeInvalidatedCallback(dataSource$InvalidatedCallback);
    }
}

