/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.ContiguousDataSource;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource$LoadCallback;
import androidx.paging.PageKeyedDataSource$LoadCallbackImpl;
import androidx.paging.PageKeyedDataSource$LoadInitialCallback;
import androidx.paging.PageKeyedDataSource$LoadInitialCallbackImpl;
import androidx.paging.PageKeyedDataSource$LoadInitialParams;
import androidx.paging.PageKeyedDataSource$LoadParams;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import androidx.paging.WrapperPageKeyedDataSource;
import java.util.concurrent.Executor;

public abstract class PageKeyedDataSource
extends ContiguousDataSource {
    private final Object mKeyLock;
    private Object mNextKey;
    private Object mPreviousKey;

    public PageKeyedDataSource() {
        Object object;
        this.mKeyLock = object = new Object();
        this.mNextKey = null;
        this.mPreviousKey = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object getNextKey() {
        Object object = this.mKeyLock;
        synchronized (object) {
            return this.mNextKey;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object getPreviousKey() {
        Object object = this.mKeyLock;
        synchronized (object) {
            return this.mPreviousKey;
        }
    }

    public final void dispatchLoadAfter(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        Object object2 = this.getNextKey();
        int n12 = 1;
        if (object2 != null) {
            PageKeyedDataSource$LoadParams pageKeyedDataSource$LoadParams = new PageKeyedDataSource$LoadParams(object2, n11);
            object2 = new PageKeyedDataSource$LoadCallbackImpl(this, n12, executor, pageResult$Receiver);
            this.loadAfter(pageKeyedDataSource$LoadParams, (PageKeyedDataSource$LoadCallback)object2);
        } else {
            object2 = PageResult.getEmptyResult();
            pageResult$Receiver.onPageResult(n12, (PageResult)object2);
        }
    }

    public final void dispatchLoadBefore(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        Object object2 = this.getPreviousKey();
        int n12 = 2;
        if (object2 != null) {
            PageKeyedDataSource$LoadParams pageKeyedDataSource$LoadParams = new PageKeyedDataSource$LoadParams(object2, n11);
            object2 = new PageKeyedDataSource$LoadCallbackImpl(this, n12, executor, pageResult$Receiver);
            this.loadBefore(pageKeyedDataSource$LoadParams, (PageKeyedDataSource$LoadCallback)object2);
        } else {
            object2 = PageResult.getEmptyResult();
            pageResult$Receiver.onPageResult(n12, (PageResult)object2);
        }
    }

    public final void dispatchLoadInitial(Object object, int n10, int n11, boolean bl2, Executor executor, PageResult$Receiver pageResult$Receiver) {
        object = new PageKeyedDataSource$LoadInitialCallbackImpl(this, bl2, pageResult$Receiver);
        PageKeyedDataSource$LoadInitialParams pageKeyedDataSource$LoadInitialParams = new PageKeyedDataSource$LoadInitialParams(n10, bl2);
        this.loadInitial(pageKeyedDataSource$LoadInitialParams, (PageKeyedDataSource$LoadInitialCallback)object);
        ((PageKeyedDataSource$LoadInitialCallbackImpl)object).mCallbackHelper.setPostExecutor(executor);
    }

    public final Object getKey(int n10, Object object) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initKeys(Object object, Object object2) {
        Object object3 = this.mKeyLock;
        synchronized (object3) {
            this.mPreviousKey = object;
            this.mNextKey = object2;
            return;
        }
    }

    public abstract void loadAfter(PageKeyedDataSource$LoadParams var1, PageKeyedDataSource$LoadCallback var2);

    public abstract void loadBefore(PageKeyedDataSource$LoadParams var1, PageKeyedDataSource$LoadCallback var2);

    public abstract void loadInitial(PageKeyedDataSource$LoadInitialParams var1, PageKeyedDataSource$LoadInitialCallback var2);

    public final PageKeyedDataSource map(Function function) {
        function = DataSource.createListFunction(function);
        return this.mapByPage(function);
    }

    public final PageKeyedDataSource mapByPage(Function function) {
        WrapperPageKeyedDataSource wrapperPageKeyedDataSource = new WrapperPageKeyedDataSource(this, function);
        return wrapperPageKeyedDataSource;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setNextKey(Object object) {
        Object object2 = this.mKeyLock;
        synchronized (object2) {
            this.mNextKey = object;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPreviousKey(Object object) {
        Object object2 = this.mKeyLock;
        synchronized (object2) {
            this.mPreviousKey = object;
            return;
        }
    }

    public boolean supportsPageDropping() {
        return false;
    }
}

