/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource$Factory;
import androidx.paging.LivePagedListBuilder$1;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedList$Config$Builder;
import java.util.concurrent.Executor;

public final class LivePagedListBuilder {
    private PagedList.BoundaryCallback mBoundaryCallback;
    private PagedList$Config mConfig;
    private DataSource$Factory mDataSourceFactory;
    private Executor mFetchExecutor;
    private Object mInitialLoadKey;

    public LivePagedListBuilder(DataSource$Factory dataSource$Factory, int n10) {
        PagedList$Config$Builder pagedList$Config$Builder = new PagedList$Config$Builder();
        PagedList$Config pagedList$Config = pagedList$Config$Builder.setPageSize(n10).build();
        this(dataSource$Factory, pagedList$Config);
    }

    public LivePagedListBuilder(DataSource$Factory object, PagedList$Config pagedList$Config) {
        Executor executor;
        this.mFetchExecutor = executor = ArchTaskExecutor.getIOThreadExecutor();
        if (pagedList$Config != null) {
            if (object != null) {
                this.mDataSourceFactory = object;
                this.mConfig = pagedList$Config;
                return;
            }
            object = new IllegalArgumentException("DataSource.Factory must be provided");
            throw object;
        }
        object = new IllegalArgumentException("PagedList.Config must be provided");
        throw object;
    }

    private static LiveData create(Object object, PagedList$Config pagedList$Config, PagedList.BoundaryCallback boundaryCallback, DataSource$Factory dataSource$Factory, Executor executor, Executor executor2) {
        LivePagedListBuilder$1 livePagedListBuilder$1 = new LivePagedListBuilder$1(executor2, object, dataSource$Factory, pagedList$Config, executor, executor2, boundaryCallback);
        return livePagedListBuilder$1.getLiveData();
    }

    public LiveData build() {
        Object object = this.mInitialLoadKey;
        PagedList$Config pagedList$Config = this.mConfig;
        PagedList.BoundaryCallback boundaryCallback = this.mBoundaryCallback;
        DataSource$Factory dataSource$Factory = this.mDataSourceFactory;
        Executor executor = ArchTaskExecutor.getMainThreadExecutor();
        Executor executor2 = this.mFetchExecutor;
        return LivePagedListBuilder.create(object, pagedList$Config, boundaryCallback, dataSource$Factory, executor, executor2);
    }

    public LivePagedListBuilder setBoundaryCallback(PagedList.BoundaryCallback boundaryCallback) {
        this.mBoundaryCallback = boundaryCallback;
        return this;
    }

    public LivePagedListBuilder setFetchExecutor(Executor executor) {
        this.mFetchExecutor = executor;
        return this;
    }

    public LivePagedListBuilder setInitialLoadKey(Object object) {
        this.mInitialLoadKey = object;
        return this;
    }
}

