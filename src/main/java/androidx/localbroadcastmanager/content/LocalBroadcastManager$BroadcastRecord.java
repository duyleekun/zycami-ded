/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 */
package androidx.localbroadcastmanager.content;

import android.content.Intent;
import java.util.ArrayList;

public final class LocalBroadcastManager$BroadcastRecord {
    public final Intent intent;
    public final ArrayList receivers;

    public LocalBroadcastManager$BroadcastRecord(Intent intent, ArrayList arrayList) {
        this.intent = intent;
        this.receivers = arrayList;
    }
}

