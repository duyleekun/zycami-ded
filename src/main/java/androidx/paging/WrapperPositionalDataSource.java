/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.PositionalDataSource;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.PositionalDataSource$LoadInitialParams;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.PositionalDataSource$LoadRangeParams;
import androidx.paging.WrapperPositionalDataSource$1;
import androidx.paging.WrapperPositionalDataSource$2;

public class WrapperPositionalDataSource
extends PositionalDataSource {
    public final Function mListFunction;
    private final PositionalDataSource mSource;

    public WrapperPositionalDataSource(PositionalDataSource positionalDataSource, Function function) {
        this.mSource = positionalDataSource;
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

    public void loadInitial(PositionalDataSource$LoadInitialParams positionalDataSource$LoadInitialParams, PositionalDataSource$LoadInitialCallback positionalDataSource$LoadInitialCallback) {
        PositionalDataSource positionalDataSource = this.mSource;
        WrapperPositionalDataSource$1 wrapperPositionalDataSource$1 = new WrapperPositionalDataSource$1(this, positionalDataSource$LoadInitialCallback);
        positionalDataSource.loadInitial(positionalDataSource$LoadInitialParams, wrapperPositionalDataSource$1);
    }

    public void loadRange(PositionalDataSource$LoadRangeParams positionalDataSource$LoadRangeParams, PositionalDataSource$LoadRangeCallback positionalDataSource$LoadRangeCallback) {
        PositionalDataSource positionalDataSource = this.mSource;
        WrapperPositionalDataSource$2 wrapperPositionalDataSource$2 = new WrapperPositionalDataSource$2(this, positionalDataSource$LoadRangeCallback);
        positionalDataSource.loadRange(positionalDataSource$LoadRangeParams, wrapperPositionalDataSource$2);
    }

    public void removeInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.removeInvalidatedCallback(dataSource$InvalidatedCallback);
    }
}

