/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.executor;

public abstract class TaskExecutor {
    public abstract void executeOnDiskIO(Runnable var1);

    public void executeOnMainThread(Runnable runnable) {
        boolean bl2 = this.isMainThread();
        if (bl2) {
            runnable.run();
        } else {
            this.postToMainThread(runnable);
        }
    }

    public abstract boolean isMainThread();

    public abstract void postToMainThread(Runnable var1);
}

