/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil$2;
import androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem;
import androidx.recyclerview.widget.TileList$Tile;

public class MessageThreadUtil$2$1
implements Runnable {
    public final /* synthetic */ MessageThreadUtil$2 this$1;

    public MessageThreadUtil$2$1(MessageThreadUtil$2 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        while (true) {
            int n10;
            Object object;
            Object object2;
            if ((object2 = this.this$1.mQueue.next()) == null) {
                this.this$1.mBackgroundRunning.set(false);
                return;
            }
            int n11 = ((MessageThreadUtil$SyncQueueItem)object2).what;
            int n12 = 1;
            if (n11 != n12) {
                Object object3;
                n12 = 3;
                int n13 = 2;
                if (n11 != n13) {
                    if (n11 != n12) {
                        n12 = 4;
                        if (n11 != n12) {
                            object = new StringBuilder();
                            object3 = "Unsupported message, what=";
                            ((StringBuilder)object).append((String)object3);
                            n10 = ((MessageThreadUtil$SyncQueueItem)object2).what;
                            ((StringBuilder)object).append(n10);
                            object2 = ((StringBuilder)object).toString();
                            object = "ThreadUtil";
                            Log.e((String)object, (String)object2);
                            continue;
                        }
                        object2 = (TileList$Tile)((MessageThreadUtil$SyncQueueItem)object2).data;
                        object = this.this$1.val$callback;
                        object.recycleTile((TileList$Tile)object2);
                        continue;
                    }
                    object = this.this$1.val$callback;
                    n12 = ((MessageThreadUtil$SyncQueueItem)object2).arg1;
                    n10 = ((MessageThreadUtil$SyncQueueItem)object2).arg2;
                    object.loadTile(n12, n10);
                    continue;
                }
                this.this$1.mQueue.removeMessages(n13);
                this.this$1.mQueue.removeMessages(n12);
                object = this.this$1;
                object3 = ((MessageThreadUtil$2)object).val$callback;
                n13 = ((MessageThreadUtil$SyncQueueItem)object2).arg1;
                int n14 = ((MessageThreadUtil$SyncQueueItem)object2).arg2;
                int n15 = ((MessageThreadUtil$SyncQueueItem)object2).arg3;
                int n16 = ((MessageThreadUtil$SyncQueueItem)object2).arg4;
                int n17 = ((MessageThreadUtil$SyncQueueItem)object2).arg5;
                object3.updateRange(n13, n14, n15, n16, n17);
                continue;
            }
            this.this$1.mQueue.removeMessages(n12);
            object = this.this$1.val$callback;
            n10 = ((MessageThreadUtil$SyncQueueItem)object2).arg1;
            object.refresh(n10);
        }
    }
}

