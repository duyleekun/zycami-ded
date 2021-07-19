/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import com.google.android.exoplayer2.AudioBecomingNoisyManager$AudioBecomingNoisyReceiver;
import com.google.android.exoplayer2.AudioBecomingNoisyManager$EventListener;

public final class AudioBecomingNoisyManager {
    private final Context context;
    private final AudioBecomingNoisyManager$AudioBecomingNoisyReceiver receiver;
    private boolean receiverRegistered;

    public AudioBecomingNoisyManager(Context object, Handler handler, AudioBecomingNoisyManager$EventListener audioBecomingNoisyManager$EventListener) {
        this.context = object = object.getApplicationContext();
        super(this, handler, audioBecomingNoisyManager$EventListener);
        this.receiver = object;
    }

    public static /* synthetic */ boolean access$000(AudioBecomingNoisyManager audioBecomingNoisyManager) {
        return audioBecomingNoisyManager.receiverRegistered;
    }

    public void setEnabled(boolean bl2) {
        boolean bl3;
        if (bl2 && !(bl3 = this.receiverRegistered)) {
            Context context = this.context;
            AudioBecomingNoisyManager$AudioBecomingNoisyReceiver audioBecomingNoisyManager$AudioBecomingNoisyReceiver = this.receiver;
            String string2 = "android.media.AUDIO_BECOMING_NOISY";
            IntentFilter intentFilter = new IntentFilter(string2);
            context.registerReceiver((BroadcastReceiver)audioBecomingNoisyManager$AudioBecomingNoisyReceiver, intentFilter);
            this.receiverRegistered = bl2 = true;
        } else if (!bl2 && (bl2 = this.receiverRegistered)) {
            Context context = this.context;
            AudioBecomingNoisyManager$AudioBecomingNoisyReceiver audioBecomingNoisyManager$AudioBecomingNoisyReceiver = this.receiver;
            context.unregisterReceiver((BroadcastReceiver)audioBecomingNoisyManager$AudioBecomingNoisyReceiver);
            bl2 = false;
            context = null;
            this.receiverRegistered = false;
        }
    }
}

