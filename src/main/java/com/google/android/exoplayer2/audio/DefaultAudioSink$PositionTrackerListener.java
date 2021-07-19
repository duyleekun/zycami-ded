/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.audio;

import android.os.SystemClock;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker$Listener;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink$1;
import com.google.android.exoplayer2.audio.DefaultAudioSink$InvalidAudioTrackTimestampException;
import com.google.android.exoplayer2.util.Log;

public final class DefaultAudioSink$PositionTrackerListener
implements AudioTrackPositionTracker$Listener {
    public final /* synthetic */ DefaultAudioSink this$0;

    private DefaultAudioSink$PositionTrackerListener(DefaultAudioSink defaultAudioSink) {
        this.this$0 = defaultAudioSink;
    }

    public /* synthetic */ DefaultAudioSink$PositionTrackerListener(DefaultAudioSink defaultAudioSink, DefaultAudioSink$1 defaultAudioSink$1) {
        this(defaultAudioSink);
    }

    public void onInvalidLatency(long l10) {
        StringBuilder stringBuilder = new StringBuilder(61);
        stringBuilder.append("Ignoring impossibly large audio latency: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        Log.w("DefaultAudioSink", string2);
    }

    public void onPositionAdvancing(long l10) {
        AudioSink$Listener audioSink$Listener = DefaultAudioSink.access$400(this.this$0);
        if (audioSink$Listener != null) {
            audioSink$Listener = DefaultAudioSink.access$400(this.this$0);
            audioSink$Listener.onPositionAdvancing(l10);
        }
    }

    public void onPositionFramesMismatch(long l10, long l11, long l12, long l13) {
        DefaultAudioSink defaultAudioSink = this.this$0;
        long l14 = DefaultAudioSink.access$600(defaultAudioSink);
        DefaultAudioSink defaultAudioSink2 = this.this$0;
        long l15 = DefaultAudioSink.access$700(defaultAudioSink2);
        int n10 = 182;
        StringBuilder stringBuilder = new StringBuilder(n10);
        String string2 = "Spurious audio timestamp (frame position mismatch): ";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        String string3 = ", ";
        stringBuilder.append(string3);
        stringBuilder.append(l11);
        stringBuilder.append(string3);
        stringBuilder.append(l12);
        stringBuilder.append(string3);
        stringBuilder.append(l13);
        stringBuilder.append(string3);
        stringBuilder.append(l14);
        stringBuilder.append(string3);
        stringBuilder.append(l15);
        string3 = stringBuilder.toString();
        boolean bl2 = DefaultAudioSink.failOnSpuriousAudioTimestamp;
        if (!bl2) {
            Log.w("DefaultAudioSink", string3);
            return;
        }
        DefaultAudioSink$InvalidAudioTrackTimestampException defaultAudioSink$InvalidAudioTrackTimestampException = new DefaultAudioSink$InvalidAudioTrackTimestampException(string3, null);
        throw defaultAudioSink$InvalidAudioTrackTimestampException;
    }

    public void onSystemTimeUsMismatch(long l10, long l11, long l12, long l13) {
        DefaultAudioSink defaultAudioSink = this.this$0;
        long l14 = DefaultAudioSink.access$600(defaultAudioSink);
        DefaultAudioSink defaultAudioSink2 = this.this$0;
        long l15 = DefaultAudioSink.access$700(defaultAudioSink2);
        int n10 = 180;
        StringBuilder stringBuilder = new StringBuilder(n10);
        String string2 = "Spurious audio timestamp (system clock mismatch): ";
        stringBuilder.append(string2);
        stringBuilder.append(l10);
        String string3 = ", ";
        stringBuilder.append(string3);
        stringBuilder.append(l11);
        stringBuilder.append(string3);
        stringBuilder.append(l12);
        stringBuilder.append(string3);
        stringBuilder.append(l13);
        stringBuilder.append(string3);
        stringBuilder.append(l14);
        stringBuilder.append(string3);
        stringBuilder.append(l15);
        string3 = stringBuilder.toString();
        boolean bl2 = DefaultAudioSink.failOnSpuriousAudioTimestamp;
        if (!bl2) {
            Log.w("DefaultAudioSink", string3);
            return;
        }
        DefaultAudioSink$InvalidAudioTrackTimestampException defaultAudioSink$InvalidAudioTrackTimestampException = new DefaultAudioSink$InvalidAudioTrackTimestampException(string3, null);
        throw defaultAudioSink$InvalidAudioTrackTimestampException;
    }

    public void onUnderrun(int n10, long l10) {
        Object object = DefaultAudioSink.access$400(this.this$0);
        if (object != null) {
            long l11 = SystemClock.elapsedRealtime();
            DefaultAudioSink defaultAudioSink = this.this$0;
            long l12 = DefaultAudioSink.access$900(defaultAudioSink);
            long l13 = l11 - l12;
            object = this.this$0;
            AudioSink$Listener audioSink$Listener = DefaultAudioSink.access$400((DefaultAudioSink)object);
            audioSink$Listener.onUnderrun(n10, l10, l13);
        }
    }
}

