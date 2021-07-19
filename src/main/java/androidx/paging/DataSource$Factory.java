/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.DataSource$Factory$1;

public abstract class DataSource$Factory {
    public abstract DataSource create();

    public DataSource$Factory map(Function function) {
        function = DataSource.createListFunction(function);
        return this.mapByPage(function);
    }

    public DataSource$Factory mapByPage(Function function) {
        DataSource$Factory$1 dataSource$Factory$1 = new DataSource$Factory$1(this, function);
        return dataSource$Factory$1;
    }
}

