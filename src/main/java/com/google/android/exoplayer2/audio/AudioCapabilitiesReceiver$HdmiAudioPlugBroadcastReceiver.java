/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver$1;

public final class AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver
extends BroadcastReceiver {
    public final /* synthetic */ AudioCapabilitiesReceiver this$0;

    private AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver(AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
        this.this$0 = audioCapabilitiesReceiver;
    }

    public /* synthetic */ AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver(AudioCapabilitiesReceiver audioCapabilitiesReceiver, AudioCapabilitiesReceiver$1 audioCapabilitiesReceiver$1) {
        this(audioCapabilitiesReceiver);
    }

    public void onReceive(Context object, Intent intent) {
        boolean bl2 = this.isInitialStickyBroadcast();
        if (!bl2) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.this$0;
            object = AudioCapabilities.getCapabilities(object, intent);
            AudioCapabilitiesReceiver.access$100(audioCapabilitiesReceiver, (AudioCapabilities)object);
        }
    }
}

