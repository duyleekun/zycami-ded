/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.ContiguousDataSource;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource$LoadCallback;
import androidx.paging.ItemKeyedDataSource$LoadCallbackImpl;
import androidx.paging.ItemKeyedDataSource$LoadInitialCallback;
import androidx.paging.ItemKeyedDataSource$LoadInitialCallbackImpl;
import androidx.paging.ItemKeyedDataSource$LoadInitialParams;
import androidx.paging.ItemKeyedDataSource$LoadParams;
import androidx.paging.PageResult$Receiver;
import androidx.paging.WrapperItemKeyedDataSource;
import java.util.concurrent.Executor;

public abstract class ItemKeyedDataSource
extends ContiguousDataSource {
    public final void dispatchLoadAfter(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        object = this.getKey(object);
        ItemKeyedDataSource$LoadParams itemKeyedDataSource$LoadParams = new ItemKeyedDataSource$LoadParams(object, n11);
        object = new ItemKeyedDataSource$LoadCallbackImpl(this, 1, executor, pageResult$Receiver);
        this.loadAfter(itemKeyedDataSource$LoadParams, (ItemKeyedDataSource$LoadCallback)object);
    }

    public final void dispatchLoadBefore(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        object = this.getKey(object);
        ItemKeyedDataSource$LoadParams itemKeyedDataSource$LoadParams = new ItemKeyedDataSource$LoadParams(object, n11);
        object = new ItemKeyedDataSource$LoadCallbackImpl(this, 2, executor, pageResult$Receiver);
        this.loadBefore(itemKeyedDataSource$LoadParams, (ItemKeyedDataSource$LoadCallback)object);
    }

    public final void dispatchLoadInitial(Object object, int n10, int n11, boolean bl2, Executor executor, PageResult$Receiver object2) {
        ItemKeyedDataSource$LoadInitialCallbackImpl itemKeyedDataSource$LoadInitialCallbackImpl = new ItemKeyedDataSource$LoadInitialCallbackImpl(this, bl2, (PageResult$Receiver)object2);
        object2 = new ItemKeyedDataSource$LoadInitialParams(object, n10, bl2);
        this.loadInitial((ItemKeyedDataSource$LoadInitialParams)object2, itemKeyedDataSource$LoadInitialCallbackImpl);
        itemKeyedDataSource$LoadInitialCallbackImpl.mCallbackHelper.setPostExecutor(executor);
    }

    public final Object getKey(int n10, Object object) {
        if (object == null) {
            return null;
        }
        return this.getKey(object);
    }

    public abstract Object getKey(Object var1);

    public abstract void loadAfter(ItemKeyedDataSource$LoadParams var1, ItemKeyedDataSource$LoadCallback var2);

    public abstract void loadBefore(ItemKeyedDataSource$LoadParams var1, ItemKeyedDataSource$LoadCallback var2);

    public abstract void loadInitial(ItemKeyedDataSource$LoadInitialParams var1, ItemKeyedDataSource$LoadInitialCallback var2);

    public final ItemKeyedDataSource map(Function function) {
        function = DataSource.createListFunction(function);
        return this.mapByPage(function);
    }

    public final ItemKeyedDataSource mapByPage(Function function) {
        WrapperItemKeyedDataSource wrapperItemKeyedDataSource = new WrapperItemKeyedDataSource(this, function);
        return wrapperItemKeyedDataSource;
    }
}

