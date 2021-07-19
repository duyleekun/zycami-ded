/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioTrack
 */
package com.google.android.exoplayer2.audio;

import android.media.AudioTrack;
import com.google.android.exoplayer2.audio.DefaultAudioSink;

public class DefaultAudioSink$1
extends Thread {
    public final /* synthetic */ DefaultAudioSink this$0;
    public final /* synthetic */ AudioTrack val$toRelease;

    public DefaultAudioSink$1(DefaultAudioSink defaultAudioSink, String string2, AudioTrack audioTrack) {
        this.this$0 = defaultAudioSink;
        this.val$toRelease = audioTrack;
        super(string2);
    }

    public void run() {
        try {
            AudioTrack audioTrack = this.val$toRelease;
            audioTrack.flush();
            audioTrack = this.val$toRelease;
            audioTrack.release();
            return;
        }
        finally {
            DefaultAudioSink.access$200(this.this$0).open();
        }
    }
}

