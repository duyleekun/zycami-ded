/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 *  android.media.AudioTrack$StreamEventCallback
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink$StreamEventCallbackV29;
import com.google.android.exoplayer2.util.Assertions;

public class DefaultAudioSink$StreamEventCallbackV29$1
extends AudioTrack.StreamEventCallback {
    public final /* synthetic */ DefaultAudioSink$StreamEventCallbackV29 this$1;
    public final /* synthetic */ DefaultAudioSink val$this$0;

    public DefaultAudioSink$StreamEventCallbackV29$1(DefaultAudioSink$StreamEventCallbackV29 streamEventCallbackV29, DefaultAudioSink defaultAudioSink) {
        this.this$1 = streamEventCallbackV29;
        this.val$this$0 = defaultAudioSink;
    }

    public void onDataRequest(AudioTrack object, int n10) {
        boolean bl2;
        AudioTrack audioTrack = DefaultAudioSink.access$300(this.this$1.this$0);
        if (object == audioTrack) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        object = DefaultAudioSink.access$400(this.this$1.this$0);
        if (object != null && (bl2 = DefaultAudioSink.access$500((DefaultAudioSink)(object = this.this$1.this$0)))) {
            object = DefaultAudioSink.access$400(this.this$1.this$0);
            object.onOffloadBufferEmptying();
        }
    }

    public void onTearDown(AudioTrack object) {
        boolean bl2;
        AudioTrack audioTrack = DefaultAudioSink.access$300(this.this$1.this$0);
        if (object == audioTrack) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        object = DefaultAudioSink.access$400(this.this$1.this$0);
        if (object != null && (bl2 = DefaultAudioSink.access$500((DefaultAudioSink)(object = this.this$1.this$0)))) {
            object = DefaultAudioSink.access$400(this.this$1.this$0);
            object.onOffloadBufferEmptying();
        }
    }
}

