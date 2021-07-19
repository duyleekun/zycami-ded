/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.lifecycle.ComputableLiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource$Factory;
import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.LivePagedListBuilder$1$1;
import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Builder;
import androidx.paging.PagedList$Config;
import java.util.concurrent.Executor;

public final class LivePagedListBuilder$1
extends ComputableLiveData {
    private final DataSource$InvalidatedCallback mCallback;
    private DataSource mDataSource;
    private PagedList mList;
    public final /* synthetic */ PagedList$BoundaryCallback val$boundaryCallback;
    public final /* synthetic */ PagedList$Config val$config;
    public final /* synthetic */ DataSource$Factory val$dataSourceFactory;
    public final /* synthetic */ Executor val$fetchExecutor;
    public final /* synthetic */ Object val$initialLoadKey;
    public final /* synthetic */ Executor val$notifyExecutor;

    public LivePagedListBuilder$1(Executor object, Object object2, DataSource$Factory dataSource$Factory, PagedList$Config pagedList$Config, Executor executor, Executor executor2, PagedList$BoundaryCallback pagedList$BoundaryCallback) {
        this.val$initialLoadKey = object2;
        this.val$dataSourceFactory = dataSource$Factory;
        this.val$config = pagedList$Config;
        this.val$notifyExecutor = executor;
        this.val$fetchExecutor = executor2;
        this.val$boundaryCallback = pagedList$BoundaryCallback;
        super((Executor)object);
        this.mCallback = object = new LivePagedListBuilder$1$1(this);
    }

    public PagedList compute() {
        boolean bl2;
        Object object = this.val$initialLoadKey;
        Object object2 = this.mList;
        if (object2 != null) {
            object = ((PagedList)object2).getLastKey();
        }
        do {
            Object object3;
            if ((object2 = this.mDataSource) != null) {
                object3 = this.mCallback;
                ((DataSource)object2).removeInvalidatedCallback((DataSource$InvalidatedCallback)object3);
            }
            this.mDataSource = object2 = this.val$dataSourceFactory.create();
            object3 = this.mCallback;
            ((DataSource)object2).addInvalidatedCallback((DataSource$InvalidatedCallback)object3);
            object3 = this.mDataSource;
            PagedList$Config pagedList$Config = this.val$config;
            object2 = new PagedList$Builder((DataSource)object3, pagedList$Config);
            object3 = this.val$notifyExecutor;
            object2 = ((PagedList$Builder)object2).setNotifyExecutor((Executor)object3);
            object3 = this.val$fetchExecutor;
            object2 = ((PagedList$Builder)object2).setFetchExecutor((Executor)object3);
            object3 = this.val$boundaryCallback;
            this.mList = object2 = ((PagedList$Builder)object2).setBoundaryCallback((PagedList$BoundaryCallback)object3).setInitialKey(object).build();
        } while (bl2 = ((PagedList)object2).isDetached());
        return this.mList;
    }
}

