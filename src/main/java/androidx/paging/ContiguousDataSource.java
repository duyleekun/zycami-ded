/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PageResult$Receiver;
import java.util.concurrent.Executor;

public abstract class ContiguousDataSource
extends DataSource {
    public abstract void dispatchLoadAfter(int var1, Object var2, int var3, Executor var4, PageResult$Receiver var5);

    public abstract void dispatchLoadBefore(int var1, Object var2, int var3, Executor var4, PageResult$Receiver var5);

    public abstract void dispatchLoadInitial(Object var1, int var2, int var3, boolean var4, Executor var5, PageResult$Receiver var6);

    public abstract Object getKey(int var1, Object var2);

    public boolean isContiguous() {
        return true;
    }

    public boolean supportsPageDropping() {
        return true;
    }
}

