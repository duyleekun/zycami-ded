/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.MessageThreadUtil;
import androidx.recyclerview.widget.MessageThreadUtil$1$1;
import androidx.recyclerview.widget.MessageThreadUtil$MessageQueue;
import androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem;
import androidx.recyclerview.widget.ThreadUtil$MainThreadCallback;
import androidx.recyclerview.widget.TileList$Tile;

public class MessageThreadUtil$1
implements ThreadUtil$MainThreadCallback {
    public static final int ADD_TILE = 2;
    public static final int REMOVE_TILE = 3;
    public static final int UPDATE_ITEM_COUNT = 1;
    private final Handler mMainThreadHandler;
    private Runnable mMainThreadRunnable;
    public final MessageThreadUtil$MessageQueue mQueue;
    public final /* synthetic */ MessageThreadUtil this$0;
    public final /* synthetic */ ThreadUtil$MainThreadCallback val$callback;

    public MessageThreadUtil$1(MessageThreadUtil object, ThreadUtil$MainThreadCallback threadUtil$MainThreadCallback) {
        this.this$0 = object;
        this.val$callback = threadUtil$MainThreadCallback;
        this.mQueue = object = new MessageThreadUtil$MessageQueue();
        threadUtil$MainThreadCallback = Looper.getMainLooper();
        object = new Handler((Looper)threadUtil$MainThreadCallback);
        this.mMainThreadHandler = object;
        this.mMainThreadRunnable = object = new MessageThreadUtil$1$1(this);
    }

    private void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        this.mQueue.sendMessage(messageThreadUtil$SyncQueueItem);
        messageThreadUtil$SyncQueueItem = this.mMainThreadHandler;
        Runnable runnable = this.mMainThreadRunnable;
        messageThreadUtil$SyncQueueItem.post(runnable);
    }

    public void addTile(int n10, TileList$Tile tileList$Tile) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(2, n10, tileList$Tile);
        this.sendMessage(messageThreadUtil$SyncQueueItem);
    }

    public void removeTile(int n10, int n11) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(3, n10, n11);
        this.sendMessage(messageThreadUtil$SyncQueueItem);
    }

    public void updateItemCount(int n10, int n11) {
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = MessageThreadUtil$SyncQueueItem.obtainMessage(1, n10, n11);
        this.sendMessage(messageThreadUtil$SyncQueueItem);
    }
}

