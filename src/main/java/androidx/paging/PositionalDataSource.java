/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.ContiguousDataSource;
import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PositionalDataSource$ContiguousWithoutPlaceholdersWrapper;
import androidx.paging.PositionalDataSource$LoadInitialCallback;
import androidx.paging.PositionalDataSource$LoadInitialCallbackImpl;
import androidx.paging.PositionalDataSource$LoadInitialParams;
import androidx.paging.PositionalDataSource$LoadRangeCallback;
import androidx.paging.PositionalDataSource$LoadRangeCallbackImpl;
import androidx.paging.PositionalDataSource$LoadRangeParams;
import androidx.paging.WrapperPositionalDataSource;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public abstract class PositionalDataSource
extends DataSource {
    public static int computeInitialLoadPosition(PositionalDataSource$LoadInitialParams positionalDataSource$LoadInitialParams, int n10) {
        int n11 = positionalDataSource$LoadInitialParams.requestedStartPosition;
        int n12 = positionalDataSource$LoadInitialParams.requestedLoadSize;
        int n13 = positionalDataSource$LoadInitialParams.pageSize;
        n11 = n11 / n13 * n13;
        n13 = Math.min((n10 - n12 + n13 + -1) / n13 * n13, n11);
        return Math.max(0, n13);
    }

    public static int computeInitialLoadSize(PositionalDataSource$LoadInitialParams positionalDataSource$LoadInitialParams, int n10, int n11) {
        int n12 = positionalDataSource$LoadInitialParams.requestedLoadSize;
        return Math.min(n11 -= n10, n12);
    }

    public final void dispatchLoadInitial(boolean bl2, int n10, int n11, int n12, Executor executor, PageResult$Receiver object) {
        PositionalDataSource$LoadInitialCallbackImpl positionalDataSource$LoadInitialCallbackImpl = new PositionalDataSource$LoadInitialCallbackImpl(this, bl2, n12, (PageResult$Receiver)object);
        object = new PositionalDataSource$LoadInitialParams(n10, n11, n12, bl2);
        this.loadInitial((PositionalDataSource$LoadInitialParams)object, positionalDataSource$LoadInitialCallbackImpl);
        positionalDataSource$LoadInitialCallbackImpl.mCallbackHelper.setPostExecutor(executor);
    }

    public final void dispatchLoadRange(int n10, int n11, int n12, Executor executor, PageResult$Receiver pageResult$Receiver) {
        PositionalDataSource$LoadRangeCallbackImpl positionalDataSource$LoadRangeCallbackImpl = new PositionalDataSource$LoadRangeCallbackImpl(this, n10, n11, executor, pageResult$Receiver);
        if (n12 == 0) {
            List list = Collections.emptyList();
            ((PositionalDataSource$LoadRangeCallback)positionalDataSource$LoadRangeCallbackImpl).onResult(list);
        } else {
            PositionalDataSource$LoadRangeParams positionalDataSource$LoadRangeParams = new PositionalDataSource$LoadRangeParams(n11, n12);
            this.loadRange(positionalDataSource$LoadRangeParams, positionalDataSource$LoadRangeCallbackImpl);
        }
    }

    public boolean isContiguous() {
        return false;
    }

    public abstract void loadInitial(PositionalDataSource$LoadInitialParams var1, PositionalDataSource$LoadInitialCallback var2);

    public abstract void loadRange(PositionalDataSource$LoadRangeParams var1, PositionalDataSource$LoadRangeCallback var2);

    public final PositionalDataSource map(Function function) {
        function = DataSource.createListFunction(function);
        return this.mapByPage(function);
    }

    public final PositionalDataSource mapByPage(Function function) {
        WrapperPositionalDataSource wrapperPositionalDataSource = new WrapperPositionalDataSource(this, function);
        return wrapperPositionalDataSource;
    }

    public ContiguousDataSource wrapAsContiguousWithoutPlaceholders() {
        PositionalDataSource$ContiguousWithoutPlaceholdersWrapper positionalDataSource$ContiguousWithoutPlaceholdersWrapper = new PositionalDataSource$ContiguousWithoutPlaceholdersWrapper(this);
        return positionalDataSource$ContiguousWithoutPlaceholdersWrapper;
    }
}

