/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.net.Uri
 *  android.os.Handler
 */
package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver$Listener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class AudioCapabilitiesReceiver {
    public AudioCapabilities audioCapabilities;
    private final Context context;
    private final AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver externalSurroundSoundSettingObserver;
    private final Handler handler;
    private final AudioCapabilitiesReceiver$Listener listener;
    private final BroadcastReceiver receiver;
    private boolean registered;

    public AudioCapabilitiesReceiver(Context context, AudioCapabilitiesReceiver$Listener audioCapabilitiesReceiver$Listener) {
        AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver;
        this.context = context = context.getApplicationContext();
        this.listener = audioCapabilitiesReceiver$Listener = (AudioCapabilitiesReceiver$Listener)Assertions.checkNotNull(audioCapabilitiesReceiver$Listener);
        audioCapabilitiesReceiver$Listener = Util.createHandlerForCurrentOrMainLooper();
        this.handler = audioCapabilitiesReceiver$Listener;
        int n10 = Util.SDK_INT;
        AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver = null;
        int n11 = 21;
        if (n10 >= n11) {
            audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver = new AudioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver(this, null);
        } else {
            n10 = 0;
            audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver = null;
        }
        this.receiver = audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver;
        audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver = AudioCapabilities.getExternalSurroundSoundGlobalSettingUri();
        if (audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver != null) {
            context = context.getContentResolver();
            audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver = new AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver(this, (Handler)audioCapabilitiesReceiver$Listener, (ContentResolver)context, (Uri)audioCapabilitiesReceiver$HdmiAudioPlugBroadcastReceiver);
        }
        this.externalSurroundSoundSettingObserver = audioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver;
    }

    public static /* synthetic */ void access$100(AudioCapabilitiesReceiver audioCapabilitiesReceiver, AudioCapabilities audioCapabilities) {
        audioCapabilitiesReceiver.onNewAudioCapabilities(audioCapabilities);
    }

    public static /* synthetic */ Context access$200(AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
        return audioCapabilitiesReceiver.context;
    }

    private void onNewAudioCapabilities(AudioCapabilities audioCapabilities) {
        Object object;
        boolean bl2 = this.registered;
        if (bl2 && !(bl2 = audioCapabilities.equals(object = this.audioCapabilities))) {
            this.audioCapabilities = audioCapabilities;
            object = this.listener;
            object.onAudioCapabilitiesChanged(audioCapabilities);
        }
    }

    public AudioCapabilities register() {
        boolean bl2 = this.registered;
        if (bl2) {
            return (AudioCapabilities)Assertions.checkNotNull(this.audioCapabilities);
        }
        this.registered = bl2 = true;
        Object object = this.externalSurroundSoundSettingObserver;
        if (object != null) {
            object.register();
        }
        object = this.receiver;
        Intent intent = null;
        if (object != null) {
            object = new IntentFilter("android.media.action.HDMI_AUDIO_PLUG");
            Context context = this.context;
            BroadcastReceiver broadcastReceiver = this.receiver;
            Handler handler = this.handler;
            intent = context.registerReceiver(broadcastReceiver, (IntentFilter)object, null, handler);
        }
        object = AudioCapabilities.getCapabilities(this.context, intent);
        this.audioCapabilities = object;
        return object;
    }

    public void unregister() {
        boolean bl2 = this.registered;
        if (!bl2) {
            return;
        }
        bl2 = false;
        this.audioCapabilities = null;
        Object object = this.receiver;
        if (object != null) {
            Context context = this.context;
            context.unregisterReceiver((BroadcastReceiver)object);
        }
        if ((object = this.externalSurroundSoundSettingObserver) != null) {
            ((AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver)((Object)object)).unregister();
        }
        this.registered = false;
    }
}

