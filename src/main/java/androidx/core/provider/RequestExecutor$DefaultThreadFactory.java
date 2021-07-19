/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.RequestExecutor$DefaultThreadFactory$ProcessPriorityThread;
import java.util.concurrent.ThreadFactory;

public class RequestExecutor$DefaultThreadFactory
implements ThreadFactory {
    private int mPriority;
    private String mThreadName;

    public RequestExecutor$DefaultThreadFactory(String string2, int n10) {
        this.mThreadName = string2;
        this.mPriority = n10;
    }

    public Thread newThread(Runnable runnable) {
        String string2 = this.mThreadName;
        int n10 = this.mPriority;
        RequestExecutor$DefaultThreadFactory$ProcessPriorityThread requestExecutor$DefaultThreadFactory$ProcessPriorityThread = new RequestExecutor$DefaultThreadFactory$ProcessPriorityThread(runnable, string2, n10);
        return requestExecutor$DefaultThreadFactory$ProcessPriorityThread;
    }
}

