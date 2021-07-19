/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem;

public class MessageThreadUtil$MessageQueue {
    private MessageThreadUtil$SyncQueueItem mRoot;

    public MessageThreadUtil$SyncQueueItem next() {
        synchronized (this) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem;
            block5: {
                messageThreadUtil$SyncQueueItem = this.mRoot;
                if (messageThreadUtil$SyncQueueItem != null) break block5;
                return null;
            }
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem.next;
            this.mRoot = messageThreadUtil$SyncQueueItem2;
            return messageThreadUtil$SyncQueueItem;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void removeMessages(int n10) {
        synchronized (this) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem;
            int n11;
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2;
            while ((messageThreadUtil$SyncQueueItem2 = this.mRoot) != null && (n11 = messageThreadUtil$SyncQueueItem2.what) == n10) {
                this.mRoot = messageThreadUtil$SyncQueueItem = messageThreadUtil$SyncQueueItem2.next;
                messageThreadUtil$SyncQueueItem2.recycle();
            }
            if (messageThreadUtil$SyncQueueItem2 != null) {
                messageThreadUtil$SyncQueueItem = messageThreadUtil$SyncQueueItem2.next;
                while (messageThreadUtil$SyncQueueItem != null) {
                    MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem3 = messageThreadUtil$SyncQueueItem.next;
                    int n12 = messageThreadUtil$SyncQueueItem.what;
                    if (n12 == n10) {
                        messageThreadUtil$SyncQueueItem2.next = messageThreadUtil$SyncQueueItem3;
                        messageThreadUtil$SyncQueueItem.recycle();
                    } else {
                        messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem;
                    }
                    messageThreadUtil$SyncQueueItem = messageThreadUtil$SyncQueueItem3;
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void sendMessage(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        synchronized (this) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2 = this.mRoot;
            if (messageThreadUtil$SyncQueueItem2 == null) {
                this.mRoot = messageThreadUtil$SyncQueueItem;
                return;
            }
            while (true) {
                MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem3;
                if ((messageThreadUtil$SyncQueueItem3 = messageThreadUtil$SyncQueueItem2.next) == null) {
                    messageThreadUtil$SyncQueueItem2.next = messageThreadUtil$SyncQueueItem;
                    return;
                }
                messageThreadUtil$SyncQueueItem2 = messageThreadUtil$SyncQueueItem3;
            }
        }
    }

    public void sendMessageAtFrontOfQueue(MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem) {
        synchronized (this) {
            MessageThreadUtil$SyncQueueItem messageThreadUtil$SyncQueueItem2 = this.mRoot;
            messageThreadUtil$SyncQueueItem.next = messageThreadUtil$SyncQueueItem2;
            this.mRoot = messageThreadUtil$SyncQueueItem;
            return;
        }
    }
}

