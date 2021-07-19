/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public class MessageThreadUtil$SyncQueueItem {
    private static MessageThreadUtil$SyncQueueItem sPool;
    private static final Object sPoolLock;
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    public MessageThreadUtil$SyncQueueItem next;
    public int what;

    static {
        Object object;
        sPoolLock = object = new Object();
    }

    public static MessageThreadUtil$SyncQueueItem obtainMessage(int n10, int n11, int n12) {
        return MessageThreadUtil$SyncQueueItem.obtainMessage(n10, n11, n12, 0, 0, 0, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MessageThreadUtil$SyncQueueItem obtainMessage(int n10, int n11, int n12, int n13, int n14, int n15, Object object) {
        Object object2 = sPoolLock;
        synchronized (object2) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = sPool;
            if (messageThreadUtil$SyncQueueItem == null) {
                messageThreadUtil$SyncQueueItem = new MessageThreadUtil$SyncQueueItem();
            } else {
                MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2;
                sPool = messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem.next;
                messageThreadUtil$SyncQueueItem2 = null;
                messageThreadUtil$SyncQueueItem.next = null;
            }
            messageThreadUtil$SyncQueueItem.what = n10;
            messageThreadUtil$SyncQueueItem.arg1 = n11;
            messageThreadUtil$SyncQueueItem.arg2 = n12;
            messageThreadUtil$SyncQueueItem.arg3 = n13;
            messageThreadUtil$SyncQueueItem.arg4 = n14;
            messageThreadUtil$SyncQueueItem.arg5 = n15;
            messageThreadUtil$SyncQueueItem.data = object;
            return messageThreadUtil$SyncQueueItem;
        }
    }

    public static MessageThreadUtil$SyncQueueItem obtainMessage(int n10, int n11, Object object) {
        return MessageThreadUtil$SyncQueueItem.obtainMessage(n10, n11, 0, 0, 0, 0, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recycle() {
        this.next = null;
        MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem = null;
        this.arg5 = 0;
        this.arg4 = 0;
        this.arg3 = 0;
        this.arg2 = 0;
        this.arg1 = 0;
        this.what = 0;
        this.data = null;
        Object object = sPoolLock;
        synchronized (object) {
            messageThreadUtil$SyncQueueItem = sPool;
            if (messageThreadUtil$SyncQueueItem != null) {
                this.next = messageThreadUtil$SyncQueueItem;
            }
            sPool = this;
            return;
        }
    }
}

