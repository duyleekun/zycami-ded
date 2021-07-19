/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 */
package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioBecomingNoisyManager$EventListener;

public final class AudioBecomingNoisyManager$AudioBecomingNoisyReceiver
extends BroadcastReceiver
implements Runnable {
    private final Handler eventHandler;
    private final AudioBecomingNoisyManager$EventListener listener;
    public final /* synthetic */ AudioBecomingNoisyManager this$0;

    public AudioBecomingNoisyManager$AudioBecomingNoisyReceiver(AudioBecomingNoisyManager audioBecomingNoisyManager, Handler handler, AudioBecomingNoisyManager$EventListener eventListener) {
        this.this$0 = audioBecomingNoisyManager;
        this.eventHandler = handler;
        this.listener = eventListener;
    }

    public void onReceive(Context object, Intent object2) {
        object2 = "android.media.AUDIO_BECOMING_NOISY";
        object = object2.getAction();
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = this.eventHandler;
            object.post((Runnable)this);
        }
    }

    public void run() {
        Object object = this.this$0;
        boolean bl2 = AudioBecomingNoisyManager.access$000((AudioBecomingNoisyManager)object);
        if (bl2) {
            object = this.listener;
            object.onAudioBecomingNoisy();
        }
    }
}

