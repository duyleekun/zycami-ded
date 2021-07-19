/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagedList;
import androidx.paging.PagedList$Callback;
import androidx.paging.PagedList$Config;
import androidx.paging.PagedStorage;
import java.util.concurrent.Executor;

public class SnapshotPagedList
extends PagedList {
    private final boolean mContiguous;
    private final DataSource mDataSource;
    private final Object mLastKey;

    public SnapshotPagedList(PagedList object) {
        int n10;
        DataSource dataSource;
        PagedStorage pagedStorage = ((PagedList)object).mStorage.snapshot();
        Executor executor = ((PagedList)object).mMainThreadExecutor;
        Executor executor2 = ((PagedList)object).mBackgroundThreadExecutor;
        PagedList$Config pagedList$Config = ((PagedList)object).mConfig;
        super(pagedStorage, executor, executor2, null, pagedList$Config);
        this.mDataSource = dataSource = ((PagedList)object).getDataSource();
        this.mContiguous = n10 = ((PagedList)object).isContiguous();
        this.mLastLoad = n10 = ((PagedList)object).mLastLoad;
        this.mLastKey = object = ((PagedList)object).getLastKey();
    }

    public void dispatchUpdatesSinceSnapshot(PagedList pagedList, PagedList$Callback pagedList$Callback) {
    }

    public DataSource getDataSource() {
        return this.mDataSource;
    }

    public Object getLastKey() {
        return this.mLastKey;
    }

    public boolean isContiguous() {
        return this.mContiguous;
    }

    public boolean isDetached() {
        return true;
    }

    public boolean isImmutable() {
        return true;
    }

    public void loadAroundInternal(int n10) {
    }
}

