/*
 * Decompiled with CFR 0.151.
 */
package androidx.loader.content;

import androidx.core.os.OperationCanceledException;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.ModernAsyncTask;
import java.util.concurrent.CountDownLatch;

public final class AsyncTaskLoader$LoadTask
extends ModernAsyncTask
implements Runnable {
    private final CountDownLatch mDone;
    public final /* synthetic */ AsyncTaskLoader this$0;
    public boolean waiting;

    public AsyncTaskLoader$LoadTask(AsyncTaskLoader object) {
        this.this$0 = object;
        this.mDone = object = new CountDownLatch(1);
    }

    public Object doInBackground(Void ... object) {
        try {
            object = this.this$0;
        }
        catch (OperationCanceledException operationCanceledException) {
            boolean bl2 = this.isCancelled();
            if (bl2) {
                return null;
            }
            throw operationCanceledException;
        }
        return ((AsyncTaskLoader)object).onLoadInBackground();
    }

    public void onCancelled(Object object) {
        try {
            AsyncTaskLoader asyncTaskLoader = this.this$0;
            asyncTaskLoader.dispatchOnCancelled(this, object);
            return;
        }
        finally {
            this.mDone.countDown();
        }
    }

    public void onPostExecute(Object object) {
        try {
            AsyncTaskLoader asyncTaskLoader = this.this$0;
            asyncTaskLoader.dispatchOnLoadComplete(this, object);
            return;
        }
        finally {
            this.mDone.countDown();
        }
    }

    public void run() {
        this.waiting = false;
        this.this$0.executePendingTask();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void waitForLoader() {
        CountDownLatch countDownLatch;
        try {
            countDownLatch = this.mDone;
        }
        catch (InterruptedException interruptedException) {
            return;
        }
        countDownLatch.await();
    }
}

