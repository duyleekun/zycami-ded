/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 */
package com.google.android.exoplayer2.audio;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioCapabilitiesReceiver;

public final class AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver
extends ContentObserver {
    private final ContentResolver resolver;
    private final Uri settingUri;
    public final /* synthetic */ AudioCapabilitiesReceiver this$0;

    public AudioCapabilitiesReceiver$ExternalSurroundSoundSettingObserver(AudioCapabilitiesReceiver audioCapabilitiesReceiver, Handler handler, ContentResolver contentResolver, Uri uri) {
        this.this$0 = audioCapabilitiesReceiver;
        super(handler);
        this.resolver = contentResolver;
        this.settingUri = uri;
    }

    public void onChange(boolean bl2) {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.this$0;
        AudioCapabilities audioCapabilities = AudioCapabilities.getCapabilities(AudioCapabilitiesReceiver.access$200(audioCapabilitiesReceiver));
        AudioCapabilitiesReceiver.access$100(audioCapabilitiesReceiver, audioCapabilities);
    }

    public void register() {
        ContentResolver contentResolver = this.resolver;
        Uri uri = this.settingUri;
        contentResolver.registerContentObserver(uri, false, (ContentObserver)this);
    }

    public void unregister() {
        this.resolver.unregisterContentObserver((ContentObserver)this);
    }
}

