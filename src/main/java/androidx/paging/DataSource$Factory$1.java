/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.DataSource$Factory;

public class DataSource$Factory$1
extends DataSource$Factory {
    public final /* synthetic */ DataSource$Factory this$0;
    public final /* synthetic */ Function val$function;

    public DataSource$Factory$1(DataSource$Factory dataSource$Factory, Function function) {
        this.this$0 = dataSource$Factory;
        this.val$function = function;
    }

    public DataSource create() {
        DataSource dataSource = this.this$0.create();
        Function function = this.val$function;
        return dataSource.mapByPage(function);
    }
}

