/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.ContiguousDataSource;
import androidx.paging.DataSource;
import androidx.paging.DataSource$InvalidatedCallback;
import androidx.paging.PageResult$Receiver;
import androidx.paging.PositionalDataSource;
import java.util.concurrent.Executor;

public class PositionalDataSource$ContiguousWithoutPlaceholdersWrapper
extends ContiguousDataSource {
    public final PositionalDataSource mSource;

    public PositionalDataSource$ContiguousWithoutPlaceholdersWrapper(PositionalDataSource positionalDataSource) {
        this.mSource = positionalDataSource;
    }

    public void addInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.addInvalidatedCallback(dataSource$InvalidatedCallback);
    }

    public void dispatchLoadAfter(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        int n12 = n10 + 1;
        this.mSource.dispatchLoadRange(1, n12, n11, executor, pageResult$Receiver);
    }

    public void dispatchLoadBefore(int n10, Object object, int n11, Executor executor, PageResult$Receiver pageResult$Receiver) {
        int n12 = n10 + -1;
        if (n12 < 0) {
            PositionalDataSource positionalDataSource = this.mSource;
            int n13 = 2;
            Object var9_9 = null;
            positionalDataSource.dispatchLoadRange(n13, n12, 0, executor, pageResult$Receiver);
        } else {
            n10 = n12 + 1;
            int n14 = Math.min(n11, n10);
            int n15 = (n12 -= n14) + 1;
            PositionalDataSource positionalDataSource = this.mSource;
            int n16 = 2;
            positionalDataSource.dispatchLoadRange(n16, n15, n14, executor, pageResult$Receiver);
        }
    }

    public void dispatchLoadInitial(Integer n10, int n11, int n12, boolean bl2, Executor executor, PageResult$Receiver pageResult$Receiver) {
        if (n10 == null) {
            n10 = 0;
        } else {
            n11 = Math.max(n11 / n12, 2) * n12;
            int n13 = n10;
            int n14 = n11 / 2;
            n13 = (n13 - n14) / n12 * n12;
            n13 = Math.max(0, n13);
            n10 = n13;
        }
        PositionalDataSource positionalDataSource = this.mSource;
        int n15 = n10;
        positionalDataSource.dispatchLoadInitial(false, n15, n11, n12, executor, pageResult$Receiver);
    }

    public Integer getKey(int n10, Object object) {
        return n10;
    }

    public void invalidate() {
        this.mSource.invalidate();
    }

    public boolean isInvalid() {
        return this.mSource.isInvalid();
    }

    public DataSource map(Function object) {
        object = new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        throw object;
    }

    public DataSource mapByPage(Function object) {
        object = new UnsupportedOperationException("Inaccessible inner type doesn't support map op");
        throw object;
    }

    public void removeInvalidatedCallback(DataSource$InvalidatedCallback dataSource$InvalidatedCallback) {
        this.mSource.removeInvalidatedCallback(dataSource$InvalidatedCallback);
    }
}

