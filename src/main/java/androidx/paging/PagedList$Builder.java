/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.PagedList$BoundaryCallback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedList$Config$Builder;
import java.util.concurrent.Executor;

public final class PagedList$Builder {
    private PagedList$BoundaryCallback mBoundaryCallback;
    private final PagedList$Config mConfig;
    private final DataSource mDataSource;
    private Executor mFetchExecutor;
    private Object mInitialKey;
    private Executor mNotifyExecutor;

    public PagedList$Builder(DataSource dataSource, int n10) {
        PagedList$Config$Builder pagedList$Config$Builder = new PagedList$Config$Builder();
        PagedList$Config pagedList$Config = pagedList$Config$Builder.setPageSize(n10).build();
        this(dataSource, pagedList$Config);
    }

    public PagedList$Builder(DataSource object, PagedList$Config pagedList$Config) {
        if (object != null) {
            if (pagedList$Config != null) {
                this.mDataSource = object;
                this.mConfig = pagedList$Config;
                return;
            }
            object = new IllegalArgumentException("Config may not be null");
            throw object;
        }
        object = new IllegalArgumentException("DataSource may not be null");
        throw object;
    }

    public PagedList build() {
        Executor executor = this.mNotifyExecutor;
        if (executor != null) {
            Executor executor2 = this.mFetchExecutor;
            if (executor2 != null) {
                DataSource dataSource = this.mDataSource;
                PagedList$BoundaryCallback pagedList$BoundaryCallback = this.mBoundaryCallback;
                PagedList$Config pagedList$Config = this.mConfig;
                Object object = this.mInitialKey;
                return PagedList.create(dataSource, executor, executor2, pagedList$BoundaryCallback, pagedList$Config, object);
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("BackgroundThreadExecutor required");
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("MainThreadExecutor required");
        throw illegalArgumentException;
    }

    public PagedList$Builder setBoundaryCallback(PagedList$BoundaryCallback pagedList$BoundaryCallback) {
        this.mBoundaryCallback = pagedList$BoundaryCallback;
        return this;
    }

    public PagedList$Builder setFetchExecutor(Executor executor) {
        this.mFetchExecutor = executor;
        return this;
    }

    public PagedList$Builder setInitialKey(Object object) {
        this.mInitialKey = object;
        return this;
    }

    public PagedList$Builder setNotifyExecutor(Executor executor) {
        this.mNotifyExecutor = executor;
        return this;
    }
}

