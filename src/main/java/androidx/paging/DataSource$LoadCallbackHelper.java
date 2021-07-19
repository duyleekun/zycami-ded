/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.DataSource$LoadCallbackHelper$1;
import androidx.paging.PageResult;
import androidx.paging.PageResult$Receiver;
import java.util.List;
import java.util.concurrent.Executor;

public class DataSource$LoadCallbackHelper {
    private final DataSource mDataSource;
    private boolean mHasSignalled;
    private Executor mPostExecutor;
    public final PageResult$Receiver mReceiver;
    public final int mResultType;
    private final Object mSignalLock;

    public DataSource$LoadCallbackHelper(DataSource dataSource, int n10, Executor executor, PageResult$Receiver pageResult$Receiver) {
        Object object;
        this.mSignalLock = object = new Object();
        this.mPostExecutor = null;
        this.mHasSignalled = false;
        this.mDataSource = dataSource;
        this.mResultType = n10;
        this.mPostExecutor = executor;
        this.mReceiver = pageResult$Receiver;
    }

    public static void validateInitialLoadParams(List object, int n10, int n11) {
        if (n10 >= 0) {
            int n12 = object.size() + n10;
            if (n12 <= n11) {
                int n13 = object.size();
                if (n13 == 0 && n11 > 0) {
                    object = new IllegalArgumentException("Initial result cannot be empty if items are present in data set.");
                    throw object;
                }
                return;
            }
            object = new IllegalArgumentException("List size + position too large, last item in list beyond totalCount.");
            throw object;
        }
        object = new IllegalArgumentException("Position must be non-negative");
        throw object;
    }

    public boolean dispatchInvalidResultIfInvalid() {
        Object object = this.mDataSource;
        boolean bl2 = ((DataSource)object).isInvalid();
        if (bl2) {
            object = PageResult.getInvalidResult();
            this.dispatchResultToReceiver((PageResult)object);
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void dispatchResultToReceiver(PageResult object) {
        Object object2 = this.mSignalLock;
        // MONITORENTER : object2
        int n10 = this.mHasSignalled;
        if (n10 != 0) {
            String executor = "callback.onResult already called, cannot call again.";
            object = new IllegalStateException(executor);
            throw object;
        }
        this.mHasSignalled = n10 = 1;
        Executor executor = this.mPostExecutor;
        // MONITOREXIT : object2
        if (executor != null) {
            object2 = new DataSource$LoadCallbackHelper$1(this, (PageResult)object);
            executor.execute((Runnable)object2);
            return;
        }
        object2 = this.mReceiver;
        n10 = this.mResultType;
        ((PageResult$Receiver)object2).onPageResult(n10, (PageResult)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setPostExecutor(Executor executor) {
        Object object = this.mSignalLock;
        synchronized (object) {
            this.mPostExecutor = executor;
            return;
        }
    }
}

