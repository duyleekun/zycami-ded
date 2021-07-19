/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package androidx.core.provider;

import android.os.Process;

public class RequestExecutor$DefaultThreadFactory$ProcessPriorityThread
extends Thread {
    private final int mPriority;

    public RequestExecutor$DefaultThreadFactory$ProcessPriorityThread(Runnable runnable, String string2, int n10) {
        super(runnable, string2);
        this.mPriority = n10;
    }

    public void run() {
        Process.setThreadPriority((int)this.mPriority);
        super.run();
    }
}

