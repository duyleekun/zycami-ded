/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 */
package androidx.recyclerview.widget;

import android.os.AsyncTask;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.MessageThreadUtil$2$1;
import androidx.recyclerview.widget.MessageThreadUtil$MessageQueue;
import androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem;
import androidx.recyclerview.widget.ThreadUtil$BackgroundCallback;
import androidx.recyclerview.widget.TileList$Tile;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class MessageThreadUtil$2
implements ThreadUtil$BackgroundCallback {
    public static final int LOAD_TILE = 3;
    public static final int RECYCLE_TILE = 4;
    public static final int REFRESH = 1;
    public static final int UPDATE_RANGE = 2;
    private Runnable mBackgroundRunnable;
    public AtomicBoolean mBackgroundRunning;
    private final Executor mExecutor;
    public final MessageThreadUtil$MessageQueue mQueue;
    public final /* synthetic */ MessageThreadUtil this$0;
    public final /* synthetic */ ThreadUtil$BackgroundCallback val$callback;

    public MessageThreadUtil$2(MessageThreadUtil object, ThreadUtil$BackgroundCallback threadUtil$BackgroundCallback) {
        this.this$0 = object;
        this.val$callback = threadUtil$BackgroundCallback;
        this.mQueue = object = new MessageThreadUtil$MessageQueue();
        this.mExecutor = object = AsyncTask.THREAD_POOL_EXECUTOR;
        this.mBackgroundRunning = object = new AtomicBoolean(false);
        this.mBackgroundRunnable = object = new MessageThreadUtil$2$1(this);
    }

    private void maybeExecuteBackgroundRunnable() {
        Object object = this.mBackgroundRunning;
        Runnable runnable = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.mExecutor;
            runnable = this.mBackgroundRunnable;
            object.execute(runnable);
        }
    }

    private void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessage(messageThreadUtil$SyncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }

    private void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessageAtFrontOfQueue(messageThreadUtil$SyncQueueItem);
        this.maybeExecuteBackgroundRunnable();
    }

    public void loadTile(int n10, int n11) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(3, n10, n11);
        this.sendMessage(messageThreadUtil$SyncQueueItem);
    }

    public void recycleTile(TileList$Tile object) {
        object = MessageThreadUtil$SyncQueueItem.obtainMessage(4, 0, object);
        this.sendMessage((MessageThreadUtil$SyncQueueItem)object);
    }

    public void refresh(int n10) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(1, n10, null);
        this.sendMessageAtFrontOfQueue(messageThreadUtil$SyncQueueItem);
    }

    public void updateRange(int n10, int n11, int n12, int n13, int n14) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(2, n10, n11, n12, n13, n14, null);
        this.sendMessageAtFrontOfQueue(messageThreadUtil$SyncQueueItem);
    }
}

