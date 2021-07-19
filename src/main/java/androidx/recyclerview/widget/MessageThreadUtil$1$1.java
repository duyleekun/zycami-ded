/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.recyclerview.widget;

import android.util.Log;
import androidx.recyclerview.widget.MessageThreadUtil$1;
import androidx.recyclerview.widget.MessageThreadUtil$SyncQueueItem;
import androidx.recyclerview.widget.TileList$Tile;

public class MessageThreadUtil$1$1
implements Runnable {
    public final /* synthetic */ MessageThreadUtil$1 this$1;

    public MessageThreadUtil$1$1(MessageThreadUtil$1 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        Object object = this.this$1.mQueue.next();
        while (object != null) {
            int n10;
            Object object2;
            int n11 = ((MessageThreadUtil$SyncQueueItem)object).what;
            int n12 = 1;
            if (n11 != n12) {
                Object object3;
                n12 = 2;
                if (n11 != n12) {
                    n12 = 3;
                    if (n11 != n12) {
                        object2 = new StringBuilder();
                        object3 = "Unsupported message, what=";
                        ((StringBuilder)object2).append((String)object3);
                        n10 = ((MessageThreadUtil$SyncQueueItem)object).what;
                        ((StringBuilder)object2).append(n10);
                        object = ((StringBuilder)object2).toString();
                        object2 = "ThreadUtil";
                        Log.e((String)object2, (String)object);
                    } else {
                        object2 = this.this$1.val$callback;
                        n12 = ((MessageThreadUtil$SyncQueueItem)object).arg1;
                        n10 = ((MessageThreadUtil$SyncQueueItem)object).arg2;
                        object2.removeTile(n12, n10);
                    }
                } else {
                    object2 = (TileList$Tile)((MessageThreadUtil$SyncQueueItem)object).data;
                    object3 = this.this$1.val$callback;
                    n10 = ((MessageThreadUtil$SyncQueueItem)object).arg1;
                    object3.addTile(n10, (TileList$Tile)object2);
                }
            } else {
                object2 = this.this$1.val$callback;
                n12 = ((MessageThreadUtil$SyncQueueItem)object).arg1;
                n10 = ((MessageThreadUtil$SyncQueueItem)object).arg2;
                object2.updateItemCount(n12, n10);
            }
            object = this.this$1.mQueue.next();
        }
    }
}

