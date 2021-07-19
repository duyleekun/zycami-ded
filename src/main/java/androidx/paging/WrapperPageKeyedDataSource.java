/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PageKeyedDataSource$LoadCallback;
import androidx.paging.PageKeyedDataSource$LoadInitialCallback;
import androidx.paging.PageKeyedDataSource$LoadInitialParams;
import androidx.paging.PageKeyedDataSource$LoadParams;
import androidx.paging.WrapperPageKeyedDataSource$1;
import androidx.paging.WrapperPageKeyedDataSource$2;
import androidx.paging.WrapperPageKeyedDataSource$3;

public class WrapperPageKeyedDataSource
extends PageKeyedDataSource {
    public final Function mListFunction;
    private final PageKeyedDataSource mSource;

    public WrapperPageKeyedDataSource(PageKeyedDataSource pageKeyedDataSource, Function function) {
        this.mSource = pageKeyedDataSource;
        this.mListFunction = function;
    }

    public void addInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.addInvalidatedCallback(dataSource$InvalidatedCallback);
    }

    public void invalidate() {
        this.mSource.invalidate();
    }

    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    public void loadAfter(PageKeyedDataSource$LoadParams pageKeyedDataSource$LoadParams, PageKeyedDataSource$LoadCallback pageKeyedDataSource$LoadCallback) {
        PageKeyedDataSource pageKeyedDataSource = this.mSource;
        WrapperPageKeyedDataSource$3 wrapperPageKeyedDataSource$3 = new WrapperPageKeyedDataSource$3(this, pageKeyedDataSource$LoadCallback);
        pageKeyedDataSource.loadAfter(pageKeyedDataSource$LoadParams, wrapperPageKeyedDataSource$3);
    }

    public void loadBefore(PageKeyedDataSource$LoadParams pageKeyedDataSource$LoadParams, PageKeyedDataSource$LoadCallback pageKeyedDataSource$LoadCallback) {
        PageKeyedDataSource pageKeyedDataSource = this.mSource;
        WrapperPageKeyedDataSource$2 wrapperPageKeyedDataSource$2 = new WrapperPageKeyedDataSource$2(this, pageKeyedDataSource$LoadCallback);
        pageKeyedDataSource.loadBefore(pageKeyedDataSource$LoadParams, wrapperPageKeyedDataSource$2);
    }

    public void loadInitial(PageKeyedDataSource$LoadInitialParams pageKeyedDataSource$LoadInitialParams, PageKeyedDataSource$LoadInitialCallback pageKeyedDataSource$LoadInitialCallback) {
        PageKeyedDataSource pageKeyedDataSource = this.mSource;
        WrapperPageKeyedDataSource$1 wrapperPageKeyedDataSource$1 = new WrapperPageKeyedDataSource$1(this, pageKeyedDataSource$LoadInitialCallback);
        pageKeyedDataSource.loadInitial(pageKeyedDataSource$LoadInitialParams, wrapperPageKeyedDataSource$1);
    }

    public void removeInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.removeInvalidatedCallback(dataSource$InvalidatedCallback);
    }
}

