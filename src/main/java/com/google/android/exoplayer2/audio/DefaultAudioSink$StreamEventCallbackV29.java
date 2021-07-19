/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.media.AudioTrack$StreamEventCallback
 *  android.os.Handler
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.Handler;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import d.h.a.a.f0.j;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class DefaultAudioSink$StreamEventCallbackV29 {
    private final AudioTrack.StreamEventCallback callback;
    private final Handler handler;
    public final /* synthetic */ DefaultAudioSink this$0;

    public DefaultAudioSink$StreamEventCallbackV29(DefaultAudioSink defaultAudioSink) {
        Object object;
        this.this$0 = defaultAudioSink;
        this.handler = object = new Handler();
        super(this, defaultAudioSink);
        this.callback = object;
    }

    public void register(AudioTrack audioTrack) {
        Handler handler = this.handler;
        Objects.requireNonNull(handler);
        j j10 = new j(handler);
        handler = this.callback;
        audioTrack.registerStreamEventCallback((Executor)j10, (AudioTrack.StreamEventCallback)handler);
    }

    public void unregister(AudioTrack audioTrack) {
        AudioTrack.StreamEventCallback streamEventCallback = this.callback;
        audioTrack.unregisterStreamEventCallback(streamEventCallback);
        this.handler.removeCallbacksAndMessages(null);
    }
}

