/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.IntentFilter
 */
package androidx.localbroadcastmanager.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

public final class LocalBroadcastManager$ReceiverRecord {
    public boolean broadcasting;
    public boolean dead;
    public final IntentFilter filter;
    public final BroadcastReceiver receiver;

    public LocalBroadcastManager$ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.filter = intentFilter;
        this.receiver = broadcastReceiver;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("Receiver{");
        Object object = this.receiver;
        stringBuilder.append(object);
        stringBuilder.append(" filter=");
        object = this.filter;
        stringBuilder.append(object);
        boolean bl2 = this.dead;
        if (bl2) {
            object = " DEAD";
            stringBuilder.append((String)object);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

