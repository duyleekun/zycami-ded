/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package androidx.localbroadcastmanager.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class LocalBroadcastManager$1
extends Handler {
    public final /* synthetic */ LocalBroadcastManager this$0;

    public LocalBroadcastManager$1(LocalBroadcastManager localBroadcastManager, Looper looper) {
        this.this$0 = localBroadcastManager;
        super(looper);
    }

    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != n11) {
            super.handleMessage((Message)object);
        } else {
            object = this.this$0;
            ((LocalBroadcastManager)object).executePendingBroadcasts();
        }
    }
}

